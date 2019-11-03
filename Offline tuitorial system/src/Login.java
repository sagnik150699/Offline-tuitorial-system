package Tutorial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Login extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1;

    Login(){
        super("Login Page");

        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel",new ImageIcon(i2));

        b1.addActionListener(this);
        b2.addActionListener(this);


        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icon/pop.png"));
        Image i3 = ic3.getImage().getScaledInstance(128, 128,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);

        setLayout(new BorderLayout());

        p1 = new JPanel();

        add(l3,BorderLayout.WEST);
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(pf2);
        add(p1,BorderLayout.CENTER);

        p1.add(b1);
        p1.add(b2);

        p1.setBackground(Color.WHITE);

        setSize(420,250);
        setLocation(550,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1){
            try{
                Conn c1 = new Conn();
                String a  = tf1.getText();
                String b  = new String(pf2.getPassword());
                String q  = "select * from login where username = '"+a+"' and password = '"+b+"'";
                ResultSet rs = c1.statement.executeQuery(q);
                if(rs.next()){
                    new Project().setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                    System.exit(0);
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else{
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Login().setVisible(true);
    }
}

