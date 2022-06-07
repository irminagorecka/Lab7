package com.example.lab7.pl.lublin.wsei.java.cwiczenia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.sql.SQLException;
import java.sql.ResultSet;

import static javax.management.remote.JMXConnectorFactory.connect;

public class MyDB {
    private String host;
    private int portNr;
    private String databaseName;
    private Connection conn = null;
    private Statement statement = null;


    private String userName;
    private String password;

    public MyDB(String host, String databaseName, int portNr) {
        this.host = host;
        this.databaseName = databaseName;
        this.portNr = portNr;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public int getPortNr() {
        return portNr;
    }

    public String getDatabaseName() {
        return databaseName;
    }


    private void connect() {

        Properties connectionProps = new Properties();
        connectionProps.put("user", getUserName());
        connectionProps.put("password", getPassword());
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        String jdbcString = "jdbc:mysql://" + getHost() + ":" + getPortNr() + "/" + getDatabaseName();
        try {
            conn = DriverManager.getConnection(jdbcString, connectionProps);
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Błąd połączenia do bazy: " + jdbcString);
            System.out.println("Kominukat błędu: " + e.getMessage());
            conn = null;
        }
        System.out.println("Connected to database " + getDatabaseName());
    }

    public Connection getConnection() {
        if (conn == null) //warunek dla nie połączono
            connect();
        return conn;
    }

    public Object closeConnection() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Błąd przy zamykaniu połączenia bazodanowego: " + e.getMessage());
            }
        Number dostawa = 100;
        String selectStatement = "UPDATE coffee_houses SET COFFEE = COFFEE+" + dostawa + " WHERE CITY='SF'";
        return null;
    }

        public ResultSet selectData (String selectStatement){
            if ((conn != null) && (statement != null))
                try {
                    return statement.executeQuery(selectStatement);
                } catch (SQLException e) {
                    System.out.println("Błąd w relizacji zapytania: " + selectStatement + ", " + e.getMessage());
                }
            return null;

    }

}
