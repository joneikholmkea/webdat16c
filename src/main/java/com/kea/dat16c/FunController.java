package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FunController
{

    List<FunLink> funLinks = new ArrayList<>();

    @RequestMapping({"fun"})
    public String fun(Model model){
        model.addAttribute("user", "Dat16c site");
        return "fun";
    }

    @RequestMapping(value = {"fun"}, method = RequestMethod.POST)
    public String handleSubmit(@ModelAttribute FunLink funLink, Model model)
    {
        funLinks.add(funLink);
        model.addAttribute("funLinks", funLinks);
        return "fun";
    }


}
