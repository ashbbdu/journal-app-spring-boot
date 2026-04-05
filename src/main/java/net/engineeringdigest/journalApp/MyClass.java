import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {
    @GetMapping("say-hello")
    public String sayHello () {
        return "Hello !";
    }
}
