package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @RequestMapping({"", "/", "index"})
    public String index(Model model, HttpSession session){
        if(session.getAttribute(session.getId()) != null){
            User user = (User)session.getAttribute("isLoggedIn");
            model.addAttribute("user", user.getUsername());
            return "index";
        }
        model.addAttribute("user", "Dat16c site");
        return "index";
    }


}
