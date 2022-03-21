package DAO;
import Main.SqlConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibraryDAO {
    public static int createAccount(String username, String password){
        int status = 0;

        try {
            Connection conn = SqlConnection.dbConnect();
            PreparedStatement prepardstm = conn.prepareStatement("INSERT INTO Users(username, password) VALUES(?,?)");

            prepardstm.setString( 1, username);
            prepardstm.setString( 2, password);


            status = prepardstm.executeUpdate();
            conn.close();
            }
        catch (Exception e) {
            System.out.println(e);
        }
        return status;
        }

        public static boolean CheckUsername(String username) {
            boolean check = false;
            ResultSet resultset;

            String query = "select * from Users where username =?";

        try {
            Connection conn = SqlConnection.dbConnect();
            PreparedStatement prepardstm = conn.prepareStatement(query);



            prepardstm.setString(1, username);
            resultset = prepardstm.executeQuery();

            if(resultset.next()){
                check = true;
            }

        }
        catch(Exception ex){
            System.out.println(ex);
        }

        return check;
        }

        public static int addBook(String bookName, String bookAuthor, int bookQuantity ){
        int status = 0;


        try{
            Connection conn = SqlConnection.dbConnect();
            PreparedStatement prepardstm = conn.prepareStatement("insert into books(bookName, bookAuthor, Quantity) values(?,?,?)");

            prepardstm.setString(1,bookName);
            prepardstm.setString(2,bookAuthor);
            prepardstm.setInt(3,bookQuantity);

            status = prepardstm.executeUpdate();
            conn.close();


        }
        catch(Exception ex){
            System.out.println(ex);
        }


        }




}
