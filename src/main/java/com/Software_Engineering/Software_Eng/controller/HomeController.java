<<<<<<< HEAD
package com.Software_Engineering.Software_Eng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        System.out.println("HomeController.index");
        return "index";
    }
}
=======
package com.Software_Engineering.Software_Eng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    기본 주소 요청
    // 사용자에게 요청이 들어오면 가장 먼저 컨트롤러로 전달됨
    @GetMapping("/")
    public String index(){
        System.out.println("HomeController.index");
        return "index"; // =>template 폴더의 index.html을 찾아감
    }
}
>>>>>>> b01b163 (Initial commit)
