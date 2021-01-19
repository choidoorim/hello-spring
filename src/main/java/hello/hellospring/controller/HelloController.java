package hello.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //웹 어플리케이션에서 /hello가 들어오면 해당 메소드를 실행 시켜준다.
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Spring!!"); //data는 키이고, value(값)는 hello!! 이다. value 값이 html의 data변수에 치환이 된다.
        return "hello"; //hello.html 파일과 랜더링을 하여 실행시켜라 라는 뜻이다. 랜더링은 templates 폴더안에 있는 파일을 랜더링한다.
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(value = "name", required = true) String name, Model model){ //required true는 반드시 값을 넘겨야 하는 것.
        model.addAttribute("name", name);
        return "hello-template"; //html file name
    }

    @GetMapping("hello-string")
    @ResponseBody //http통신 프로토콜에서 body부분에 Data를 직접 넣어주겠다는 뜻. View를 사용하지 않고 그대로 데이터를 전달한다.
    public String helloString(@RequestParam("name")  String name){
        return "hello " + name;
    } //API방식은 View가 없이 문자 그대로 html에 내려간다.

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helliAPI(@RequestParam("name") String name){
        Hello hello = new Hello(); //Spring은 객체가 return으로 오게 될경우 기본적으로 json방식으로 http에 응답하게 되어있다.
        hello.setName(name);
        return hello;

    }

    static class Hello{ //Getter와Setter
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
