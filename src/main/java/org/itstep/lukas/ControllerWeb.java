package org.itstep.lukas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class ControllerWeb {

    @GetMapping( "/hello")
    public String hello(@RequestParam("name") String name, Model model , Map<String, Integer> map){
        model.addAttribute("", 12);
        return "hello";
    }
}
