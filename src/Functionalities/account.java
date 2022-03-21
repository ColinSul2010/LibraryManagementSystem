package Functionalities;

import DAO.LibraryDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class account extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameTxtField;
    private JPasswordField passwordTxtField;
    private JButton SignupButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton LoginButton;
    private JCheckBox LibrarianButton;

    public account() {
        setContentPane(mainPanel);
        setTitle("Library Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        SignupButton.addActionListener(new ActionListener() {

            public void actionPreformed(ActionEvent e) {



                try {
                    String username = usernameLabel.getText();
                    String password = passwordLabel.getText();;
                    int x = DAO.LibraryDAO.createAccount(username, password);


                    if (x > 0 && LibrarianButton.isSelected()){
                        JOptionPane.showMessageDialog(null, "You have created an account." );
                        librarianView libWindow = new librarianView();
                        setVisible(false);
                        //libWindow.setVisible(true);
                    }
                    else if(x > 0 && !LibrarianButton.isSelected()) {
                        JOptionPane.showMessageDialog(null, "You have logged in.");
                        setVisible(false);
                        //libWindow.setVisible(true);
                    }

                    else if(password.equals("")){
                        JOptionPane.showMessageDialog(null, "Enter your password.");
                    }
                    else if(username.equals("")){
                        JOptionPane.showMessageDialog(null,"Enter your username");
                    }
                    else if(LibraryDAO.CheckUsername(username)){
                        JOptionPane.showMessageDialog(null,"This username already exists");
                    }


                }
                catch (Exception ex) {
                    System.out.println(e);
                }

            }

        });
    }

    public static void main(String[] args) {

}
}
