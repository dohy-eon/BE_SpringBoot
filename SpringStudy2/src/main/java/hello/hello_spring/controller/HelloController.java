package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 기본 hello 메서드 (문자열 반환)
    @GetMapping
    @ResponseBody
    public String helloController() {
        return "hello";
    }

    // MVC 방식 (Model + View)
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name); // Model에 데이터 추가
        return "hello-template"; // View 템플릿 이름 반환
    }

    // ResponseBody로 단순 문자열 반환
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // JSON 객체 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name); // 객체에 데이터 설정
        return hello; // JSON 형태로 반환
    }

    // 내부 static class (Hello DTO)
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
