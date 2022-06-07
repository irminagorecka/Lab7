package com.example.lab7.pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        /*MyDB db = new MyDB("localhost", "mydb", 3306); //wyświetlenie rekordów
        db.setUserName("root");
        db.setPassword("Edek2020!");
        Connection conn = db.getConnection();
         if(conn!=null){
             Statement polecenie = conn.createStatement();
             ResultSet res = polecenie.executeQuery("SELECT * FROM coffee_houses");
             System.out.printf("%10s%20s%7s%7s%7s\n", "STORE ID", "CITY","COFFEE","MERCH","TOTAL");//sout nagłówek
             while(res.next()){ //iterowanie po res, res zwraca wynik zapytania
                 System.out.printf("%10d%20s%7d%7d%7d\n", res.getInt(1), res.getString("CITY"), res.getInt(3), res.getInt(4), res.getInt(5));
             }//sout wynik zapytania, getString jak varchar, getInt jak int
         }
         db.closeConnection();
         System.out.println("Połączenie z bazą zakończone");*/

        MyDB db = new MyDB("localhost", "mydb", 3306); //update rekordów
        db.setUserName("root");
        db.setPassword("Edek2020!");
        Connection conn = db.getConnection();
        if(conn!=null){
            Statement polecenie = conn.createStatement();
            Number dostawa=100;
            polecenie.executeUpdate("UPDATE coffee_houses SET COFFEE=COFFEE+"+dostawa+" WHERE CITY='SF'");
            ResultSet res = polecenie.executeQuery("SELECT * FROM coffee_houses");
            System.out.printf("%10s%20s%7s%7s%7s\n", "STORE ID", "CITY","COFFEE","MERCH","TOTAL");//sout nagłówek
            while(res.next()){ //iterowanie po res, res zwraca wynik zapytania
                System.out.printf("%10d%20s%7d%7d%7d\n", res.getInt(1), res.getString("CITY"), res.getInt(3), res.getInt(4), res.getInt(5));
            }//sout wynik zapytania, getString jak varchar, getInt jak int
        }
        db.closeConnection();
        System.out.println("Połączenie z bazą zakończone");



    }
}
