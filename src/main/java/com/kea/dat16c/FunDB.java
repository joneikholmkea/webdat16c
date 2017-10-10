package com.kea.dat16c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by soere on 10-10-2017.
 */
public class FunDB
{
    private final String DBUser = "WebsiteUser";
    private final String DBPassword = "1234";
    private final String DJDBC_CONNECTION_STRING = "jdbc:mysql://soerendb.cukdrwpucsqt.eu-central-1.rds.amazonaws.com:3306/Website";
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    Connection connection;
    PreparedStatement preparedStatement;

    public synchronized void createConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DJDBC_CONNECTION_STRING, DBUser, DBPassword);
            System.out.println(connection.toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public synchronized void GetFunLinks(FunLink funLink)
    {
        String Sql = "SELECT FunLinksURL, Describtion FROM FunLinks WHERE FunLinksURL = ? AND Describtion = ?";
        try
        {
            preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, funLink.getLink());
            preparedStatement.setString(2, funLink.getDesc());
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public synchronized void CreateFunlinks(FunLink funLink)
    {
        String Sql = "INSERT INTO FunLinks(FunLinksURL, Describtion) VALUES (?, ?)";
        try
        {
            preparedStatement = connection.prepareStatement(Sql);
            preparedStatement.setString(1, funLink.getLink());
            preparedStatement.setString(2, funLink.getDesc());
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
