package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
   Data data = new Data();

   @RequestMapping(value = {"login"}, method = RequestMethod.GET)
   public String loginPage(Model model){
      model.addAttribute("user", new User("",""));
      System.out.println("it works lol");
      return "login";
   }
   @RequestMapping(value = {"tryLogin"}, method = RequestMethod.POST)
   public String login(@ModelAttribute  User user, Model model){
      if(data.getUser(user)){
         model.addAttribute("user", "now logged in as " + user.getUsername() + " and password is: " + user.getPassword());
      }

      model.addAttribute( "user", "Wrong login info, try again!");
      return "login";
   }

   @RequestMapping(value = {"createUser"}, method = RequestMethod.POST)
   public String createUser(@ModelAttribute User user, Model model){
      data.createUser(user);
      model.addAttribute("createUserText", "User now created, try and login");

      return "login";
   }
}
