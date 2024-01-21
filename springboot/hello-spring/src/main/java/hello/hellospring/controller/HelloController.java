package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    /hello
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "장미림님");
        return "hello";
    }

//    /hello-mvc?name=입력값
//    @GetMapping("hello-mvc")
//    public String helloMvc(@RequestParam("name") String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello-template";
//    }

//    (API) /hello-string?name=입력값
    @GetMapping("hello-string")
    @ResponseBody  // http 통신의 body부에 내가 지정한 데이터를 직접 넣어주겠다.
    //
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }


//    (API - JSON 방식) /hello-api?name=입력값
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // 프로퍼티 접근 방식 (Getter & Setter)
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}
