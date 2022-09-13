/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Project extends JFrame {
        Connection con;
        Statement st;
        ResultSet rs;
        JPanel pane;
        JLabel l1, l2,l3,l4;
        JTextField t1,t2,t3,t4;
        JButton b1,b2;
        
        Project(){
            pane = new JPanel();
            pane.setSize(400,400);
            pane.setLayout(new FlowLayout());
            l1 = new JLabel("Name");
            l2 = new JLabel("Email");
            l3 = new JLabel("Password");
            l4 = new JLabel("Address");
            t1 = new JTextField(10);
            t2 = new JTextField(10);
            t3 = new JTextField(10);
            t4 = new JTextField(10);
            b1 = new JButton("Sign Up");
            b2 = new JButton("Log In");
            pane.add(l1);
            pane.add(l2);
            pane.add(l3);
            pane.add(l4);
            pane.add(t1);
            pane.add(t2);
            pane.add(t3);
            pane.add(t4);
            pane.add(b1);
            pane.add(b2);
            add(pane);
            
        }
        public void connect(){
            try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Hotel","manage","manage");
            st = con.createStatement();
            String name = t1.getText();
            String email = t2.getText();
            String pass = t3.getText();
            String address = t4.getText();
            String insertData = "insert into hoteldetails values(name,email,pass,address)";
            st.executeUpdate(insertData);
            rs = st.executeQuery(insertData);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
            b1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae){
                    try{
                        while(rs.next()){
                            JOptionPane.showMessageDialog(null,ae);
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }    
    public static void main(String[] args) {
        Project obj = new Project();
        obj.setVisible(true);
    }
}


