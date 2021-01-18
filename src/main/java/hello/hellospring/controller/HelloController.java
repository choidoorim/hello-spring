package hello.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    //웹 어플리케이션에서 /hello가 들어오면 해당 메소드를 실행 시켜준다.
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Spring!!"); //data는 키이고, value(값)는 hello!! 이다. value 값이 html의 data변수에 치환이 된다.
        return "hello"; //hello.html 파일과 랜더링을 하여 실행시켜라 라는 뜻이다. 랜더링은 templates 폴더안에 있는 파일을 랜더링한다.
    }
}
