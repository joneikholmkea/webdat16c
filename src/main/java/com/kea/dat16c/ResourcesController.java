package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResourcesController {

    List<Resource> resourceList = new ArrayList<>();

    @RequestMapping({"", "/", "resources"})
    public String resources(Model model){
        model.addAttribute("resource", "");
        System.out.println("ender");
        return "resources";
    }
    @RequestMapping(value = {"resources"}, method = RequestMethod.POST)
    public String handleUpload(@ModelAttribute Resource resource, Model model){
        resourceList.add(resource);
        model.addAttribute("resource", resourceList);
        System.out.println("benjamin");
       System.out.println(resourceList.size());
        return "resources";
    }



}
