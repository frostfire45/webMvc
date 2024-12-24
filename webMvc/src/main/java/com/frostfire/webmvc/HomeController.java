package com.frostfire.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// https://medium.com/@AlexanderObregon/how-to-handle-file-uploads-and-downloads-with-spring-boot-84638463fd6f
// https://www.codejava.net/frameworks/spring-boot/spring-boot-file-upload-tutorial
@Controller
public class HomeController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
