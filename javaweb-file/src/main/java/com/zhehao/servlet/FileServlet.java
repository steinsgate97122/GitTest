package com.zhehao.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 文件上传，使用ServletFileUpload，封装了网络传输的相关方法

            // 1.判断表单中是否包含文件上传，如果不包含直接返回
            if (!ServletFileUpload.isMultipartContent(req)) {
                return;
            }

            // 2.设置文件上传路径，放在WEB-INF下用户无法直接访问
            String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
            File uploadFile = new File(uploadPath);
            if (!uploadFile.exists()) {
                // 如果不存在，创建该路径
                uploadFile.mkdir();
            }

            // 2.1.设置文件存放的临时路径
            String tmpPath = this.getServletContext().getRealPath("/WEB-INF/tmp");
            File tmpFile = new File(tmpPath);
            if (!tmpFile.exists()) {
                // 如果不存在，创建该路径
                tmpFile.mkdir();
            }

            // 3.ServletFileUpload将输入表单解析为FileItem对象
            // 3.1.创建DiskFileItemFactory对象，设置缓存区大小和临时目录
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setSizeThreshold(1024 * 1024); // 缓存区大小为1Mb
            diskFileItemFactory.setRepository(tmpFile);

            // 3.2.根据diskFileItemFactory创建ServletFileUpload对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            // 3.3.ServletFileUpload解析request
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);

            // 4.上传文件，FileItem中获取输入流
            for (FileItem fileItem : fileItems) {
                // 不包含文件数据，直接跳过
                if (fileItem.isFormField()) {
                    fileItem.delete();
                    continue;
                }
                String uploadFileName = fileItem.getName();
                // 校验名称合法性
                if (uploadFileName == null || uploadFileName.trim().equals("")) {
                    continue;
                }
                // 根据uploadFileName获取文件名和后缀名，文件名为最后一个/后面的所有内容，后缀名为最后一个.后面的所有内容
                String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

                // UUID防止文件重名，创建文件夹
                String uuid = UUID.randomUUID().toString();
                String realPath = uploadPath + "/" + uuid;
                File realPathFile = new File(realPath);
                if (!realPathFile.exists()) {
                    realPathFile.mkdir();
                }

                // 上传，根据fileItem获取文件输入流
                InputStream inputStream = fileItem.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(realPath + "/" + fileName);
                byte[] buffer = new byte[1024 * 1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.close();
                inputStream.close();
                fileItem.delete();
            }
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
