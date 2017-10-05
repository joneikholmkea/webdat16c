package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ProjectController
{
        @RequestMapping({"", "/", "projects"})
        public String index(Model model){
            model.addAttribute("user", "Dat16c site");
            return "projects";
        }

    }


