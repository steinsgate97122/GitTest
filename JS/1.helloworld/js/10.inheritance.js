// ES6后使用类继承，还有一种是原型继承，这里只写一下类继承的语法

// 先定义父类
class Animal {
    constructor(name) {
        this.name = name;
    }

    sayHello() {
        console.log("Hello, i'm " + this.name);
    }
}

// 子类继承父类
class Dog extends Animal {
    constructor(name, breed) {
        super(name);
        this.breed = breed;
    }

    bark() {
        console.log("Wolf Wolf");
    }
}

// 创建子类实例
let dog = new Dog("Buddy", "Golden Retriever");
dog.sayHello();
dog.bark();