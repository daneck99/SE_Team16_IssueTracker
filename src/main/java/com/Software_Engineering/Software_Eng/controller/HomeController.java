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

    @GetMapping("/")
    public String index(){
        System.out.println("HomeController.index");
        return "index";
    }
}
>>>>>>> b01b163 (Initial commit)
