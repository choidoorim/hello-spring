package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //localhost 8080으로 들어오면 메서드를 실행 시켜준다.
    public String home() {
        return "home"; //home.html이 호출이 된다.
    }

}
