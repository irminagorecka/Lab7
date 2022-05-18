package com.example.lab7.pl.lublin.wsei.java.cwiczenia.test;

import java.util.Properties;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
String serverName="localhost";
String database="mydb";
Number portNumber=3306;
Connection conn=null;
Properties connectionProps = new Properties();
connectionProps.put("user", "root");
connectionProps.put("password", "Edek2020!");
connectionProps.put("serverTimezone","Europe/Warsaw");

 conn=DriverManager.getConnection("jdbc:mysql://"+serverName + "/" +database, connectionProps); //łączy z bazą danych, mogę wpisać też "Jdbc:mysql://localhost:3306/mydb?user=root&password=*****&serverTimezone=Europe%2FWarsaw"
        System.out.println("Connected to database");



    }



}
