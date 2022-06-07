package com.example.lab7.pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;

public class TestMyDB {
    public static void main(String[] args) {
        MyDB db = new MyDB("localhost", "mydb", 3306);
        db.setUserName("root");
        db.setPassword("Edek2020!");
        Connection conn = db.getConnection();

        if(conn!=null)
        System.out.println("Połączenie z bazą danych nawiązane");

        db.closeConnection();
        System.out.println("Połączenie z bazą zakończone");







    }
}
