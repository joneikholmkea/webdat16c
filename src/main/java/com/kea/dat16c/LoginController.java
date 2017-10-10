package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
   public Data data = new Data();


   @RequestMapping(value = {"login"}, method = RequestMethod.GET)
   public String loginPage(Model model){
      System.out.println("database connected");
      data.createConnection();
      return "login";
   }
   @RequestMapping(value = {"tryLogin"}, method = RequestMethod.POST)
   public String login(@ModelAttribute  User user, Model model, HttpSession session){
      if(user != null){
         if(data.getUser(user)){
            model.addAttribute("user", user.getUsername());
            session.setAttribute("isLoggedIn", user);
         }
      }else{
         model.addAttribute( "user", "Wrong login info, try again!");
      }

      return "login";
   }

   @RequestMapping(value = {"createUser"}, method = RequestMethod.POST)
   public String createUser(@ModelAttribute User user, Model model){
      data.createUser(user);
      if(user != null){
         model.addAttribute("createUserText", "User now created, try and login");
      }else{
         model.addAttribute("createUserText", "Username already taken or something else went wrong");
      }
      return "login";
   }



}
