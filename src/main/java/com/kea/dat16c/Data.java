package com.kea.dat16c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Data {
   private final String sqlUsername = "admin";
   private final String sqlPassword = "kino";
   private final String DB_Url = "jdbc:mysql://nitro.lol:3306/spring?useSSL=true";
   private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   Connection connection;
   PreparedStatement preparedStatement;

   public void createConnection(){
      try {
         Class.forName(JDBC_DRIVER);
         connection = DriverManager.getConnection(DB_Url, sqlUsername, sqlPassword);
      }catch(Exception ex){
         ex.printStackTrace();
      }
   }

   public boolean getUser(User user){
      String SQL = "SELECT * FROM users WHERE username = ? AND password = ?";
      try {
         preparedStatement = connection.prepareStatement(SQL);
         preparedStatement.setString(1, user.getUsername());
         preparedStatement.setString(2, user.getPassword());
         ResultSet rs = preparedStatement.executeQuery();

         if(rs.next()){
            return true;
         }
         return false;
      } catch (Exception e) {
         e.printStackTrace();
      }

      return false;
   }
   public void createUser(User user){
      String SQL = "INSERT INTO users(username, password) VALUES (?, ?) ";
      try {
         preparedStatement = connection.prepareStatement(SQL);
         preparedStatement.setString(1, user.getUsername());
         preparedStatement.setString(2, user.getPassword());
         preparedStatement.execute();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }




}
