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
public class ProjectController
{
    List<ProjectLinks> links = new ArrayList<>();

        @RequestMapping({"projects"})
        public String index(Model model, HttpSession session){
            User user = (User)session.getAttribute("isLoggedIn");
            if(user != null){
                model.addAttribute("user", user.getUsername());
                return "projects";
            }
            model.addAttribute("user", "Dat16c site");
            return "index";
        }

    @RequestMapping(value = {"projects"}, method = RequestMethod.POST)
    public String handlesubmit(@ModelAttribute ProjectLinks link, Model model)
    {
        links.add(link);
        model.addAttribute("links",links);
        return "projects";
    }

}


