package net.engineeringdigest.journalApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {

    @Autowired
    private Dog dog;

//    Dog dog = new Dog();
    @GetMapping("say-hello")
    public String sayHello () {
        return "Hello !";
    }

    @GetMapping("ok")
    public String dogBark () {
        return dog.bark();
    }
}
