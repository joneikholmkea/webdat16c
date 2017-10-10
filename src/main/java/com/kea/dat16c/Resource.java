package com.kea.dat16c;

public class Resource {

   public String link;
   public String description;

   public Resource(){ }


   public Resource(String link, String description) {
      this.link = link;
      this.link = description;

   }
   public String getLink(){
      return link;
   }
   public void setLink(String link){
      this.link = link;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
   public String toString(){
      return link + "  " + description;
      //
   }


}
