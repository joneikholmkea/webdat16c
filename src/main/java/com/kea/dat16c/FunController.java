package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FunController
{


    @RequestMapping({"fun"})
    public String fun(Model model){
        model.addAttribute("user", "Dat16c site");
        return "fun";
    }




}
