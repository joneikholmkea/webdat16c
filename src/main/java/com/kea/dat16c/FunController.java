package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FunController
{
    List<FunLink> links = new ArrayList<>();
    List<String> desc = new ArrayList<>();

    @RequestMapping({"fun"})
    public String fun(Model model, HttpSession session){
        User user = (User)session.getAttribute("isLoggedIn");
        if(user != null){
            model.addAttribute("user", user);
            return "fun";
        }else{
            model.addAttribute("user", "Dat16c site");
        }
        return "index";
    }


    @RequestMapping(value = {"fun"}, method = RequestMethod.POST)
    public String handleSubmit(@ModelAttribute FunLink link, Model model)
    {
        links.add(link);
       // desc.add(string);
        model.addAttribute("links", links);
        System.out.println(links);
      //  System.out.println(desc);
        return "fun";
    }




}
