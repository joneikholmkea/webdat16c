package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping({"", "/", "index"})
    public String index(Model model){
        model.addAttribute("user", "Dat16c site");
        return "index";
    }

}
