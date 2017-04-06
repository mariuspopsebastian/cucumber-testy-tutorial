//package org.fasttrackit.bazadedate;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Marius on 23-Mar-17.
// */
//public class CrudoOperation {
//
//    final static String URL = "jdbc:postgresql://54.93.65.5:5432/Auto2_MariusPop";
//    final static String USERNAME = "fasttrackit_dev";
//    final static String PASSWORD = "fasttrackit_dev";
//
//    public static void main(String[] args) {
//        System.out.println("Hello database users! We are going to call DB from Java");
//        try {
//            //demo CRUD operations
//            //        demoCreate();
//            readCredentiale();
//            //      demoUpdate();
//            //      demoDelete();
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        public static List<Item> readShoppingItems() throws ClassNotFoundException, SQLException {
//
//            // 1. load the driver
//            Class.forName("org.postgresql.Driver");
//
//            // 2. obtain a connection
//            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            // 3. create a query statement
//            Statement st = conn.createStatement();
//
//            // 4. execute a query
//            ResultSet rs = st.executeQuery("SELECT nume ,cantitate FROM shoppingItem");
//
//            // 5. iterate the result set and print the values
//            List<Item> items =  new ArrayList<>();
//            while (rs.next()) {
//                String nume = rs.getString("nume");
//                int cantitate = rs.getInt("cantitate");
//                Item item = new Item(nume, cantitate);
//                items.add(item);
//                System.out.print(rs.getString("nume").trim());
//                System.out.print("---");
//                System.out.println(rs.getInt("cantitate"));
//            }
//
//
//
//    }
//
//
//
//}
