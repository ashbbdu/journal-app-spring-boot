package net.engineeringdigest.journalApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {

    @GetMapping("/greet")
    public static String sayHello () {
        return "Hello";
    }

    @Autowired
    public Dog dog;

    @GetMapping("/doggreet")
    public String dogH () {
        return dog.bark();
    }
}
