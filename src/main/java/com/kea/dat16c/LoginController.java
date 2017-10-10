package com.kea.dat16c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

   private final int SESSION_TIMEOUT = 1800;
   public Data data = new Data();


   @RequestMapping(value = {"login"}, method = RequestMethod.GET)
   public String loginPage(Model model, HttpSession session){
      User user = (User)session.getAttribute("isLoggedIn");
      if(user != null){
         model.addAttribute("user", user);
      }else{
         model.addAttribute("user", "Dat16c site");
      }
      return "login";
   }

   @RequestMapping(value = {"logout"})
   public String logout(HttpSession session, Model model){
      session.invalidate();
      model.addAttribute("user", "Dat16c Site");

      return "redirect:index";
   }

   @RequestMapping(value = {"tryLogin"}, method = RequestMethod.POST)
   public String login(@ModelAttribute  User user, Model model, HttpSession session){
      if(user != null){
         if(data.getUser(user)){
            session.setMaxInactiveInterval(SESSION_TIMEOUT);
            model.addAttribute("user", user.getUsername());
            session.setAttribute("isLoggedIn", user);

            return "index";
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
