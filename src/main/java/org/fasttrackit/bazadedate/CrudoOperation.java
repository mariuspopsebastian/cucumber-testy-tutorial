package org.fasttrackit.bazadedate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marius on 23-Mar-17.
 */
public class CrudoOperation {

    //final static String URL = "jdbc:postgresql://54.93.65.5:5432/credentiale";
    //final static String USERNAME = "root";
    //final static String PASSWORD = "";
    final static String URL = "jdbc:mysql://localhost:3306/credentiale";
    final static String USERNAME = "root";
    final static String PASSWORD = "";

    public static void main(String[] args) {
        System.out.println("Hello database users! We are going to call DB from Java");
        try {
            //demo CRUD operations
            //        demoCreate();
            readCredentiale();
            //      demoUpdate();
            //      demoDelete();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Cont> readCredentiale() throws ClassNotFoundException, SQLException {

        // 1. load the driver
        //Class.forName("org.postgresql.Driver");
        Class.forName("com.mysql.jdbc.Driver");


        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        Statement st = conn.createStatement();

        // 4. execute a query
        ResultSet rs = st.executeQuery("SELECT email ,password FROM credentiale2");

        // 5. iterate the result set and print the values
        List<Cont> items = new ArrayList<>();
        while (rs.next()) {
            String email = rs.getString("email");
            String password = rs.getString("password");
            Cont item = new Cont(email, password);
            items.add(item);
            System.out.print(item);
        }

        return items;

    }


    public static List<Produs> readProdus() throws ClassNotFoundException, SQLException {

        // 1. load the driver
        //Class.forName("org.postgresql.Driver");
        Class.forName("com.mysql.jdbc.Driver");


        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        Statement st = conn.createStatement();

        // 4. execute a query
        ResultSet rs = st.executeQuery("SELECT produs, search, pret  FROM produse");

        // 5. iterate the result set and print the values
        List<Produs> items = new ArrayList<>();
        while (rs.next()) {
            String produs = rs.getString("produs");
            String search = rs.getString("search");
            int pret =rs.getInt("pret");
            Produs item = new Produs(produs, search, pret);
            items.add(item);
            System.out.print(item);
        }

        return items;

    }

}

