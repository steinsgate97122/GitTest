package com.zhehao.demo;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailDemo01 {
    public static void main(String[] args) throws GeneralSecurityException, MessagingException {
        // 1.环境信息存入Properties集合
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.139.com"); // 邮件服务器
        properties.setProperty("mail.transport.protocol", "smtp"); // 协议
        properties.setProperty("mail.smtp.auth", "true"); // 需要鉴权

        // 设置SSL加密
        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);

        // 2.创建Session对象配置邮件会话，包含主机、端口号、用户名、密码等信息，由Properties对象初始化
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 发件人邮件用户名，授权码
                return new PasswordAuthentication("1251039098@139.com", "f6946a549b9c1a3a4600");
            }
        });
        session.setDebug(true);

        // 3.通过Session得到Transport，设置收件人的用户名和授权码
        Transport transport = session.getTransport();
        transport.connect("smtp.139.com", "1251039098@139.com", "f6946a549b9c1a3a4600");

        // 4.MimeMessage可以构建复杂的邮件内容
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("1251039098@139.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1251039098@139.com"));
        message.setSubject("我是标题");

        // MimeBodyPart表示邮件消息的一部分，可以是邮件的文本内容、图片、附件等
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dataHandler = new DataHandler(new FileDataSource("src/main/resources/LZSB.png"));
        image.setDataHandler(dataHandler);
        image.setContentID("sb.png");

        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是<img src='cid:sb.png'>邮件", "text/html;charset=UTF-8");

        // MimeMultipart可以包含多个MimeBodyPart对象，构成完整的邮件消息
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(image);
        mimeMultipart.addBodyPart(text);
        mimeMultipart.setSubType("related"); // subType设置消息类型

        message.setContent(mimeMultipart);
        message.saveChanges();

        // 5.使用Transport发送MimeMessage
        transport.sendMessage(message, message.getAllRecipients());

        // 6.关闭资源
        transport.close();
    }
}
