package view;

import java.awt.*;
import javax.swing.*;


/**
 * @author Christine Ann Dejito
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
    
    private void regMouseClicked(java.awt.event.MouseEvent evt) {                                      
            Register r = new Register();
            r.setVisible(true);
            setVisible(false);
    }     
    
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {                                      
            AdminDashboard ad = new AdminDashboard();
            ad.setVisible(true);
            setVisible(false);
    }
    
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
    }
    
    private void initComponents(){
        title = new JLabel();
        title.setText("HIRAYA");
        title.setBounds(600, 80, 300, 50);
        title.setFont(new Font("Serif", Font.BOLD, 70));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.CENTER);
        
        username = new JLabel();
        username.setText("Username");
        username.setFont(new Font("Serif", Font.PLAIN, 20));
        username.setBounds(100, 85, 200, 50);
      
        uname = new JTextField();
        uname.setBounds(100, 135, 700, 50);
        
        password = new JLabel();
        password.setText("Password");
        password.setFont(new Font("Serif", Font.PLAIN, 20));
        password.setBounds(100, 185, 200, 50);
        
        
        pass = new JTextField();
        pass.setBounds(100, 235, 700, 50);
        
        login = new JButton();
        login.setText("Login");
        login.setBounds(100, 340, 700, 60);
        login.setFont(new Font("Serif", Font.BOLD, 30));
        login.setForeground(Color.WHITE);
        login.setBackground(new Color(0x316FA2));
        
        reg = new JLabel();
        reg.setText("Don't have an account? Register");
        reg.setBounds(100, 400, 400, 50);
        reg.setFont(new Font("Serif", Font.ITALIC, 15));
        reg.setForeground(new Color(0x316FA2));
        
        panel1 = new JPanel();
        panel1.setBounds(300, 180, 900, 500);
        panel1.setBackground(new Color(182, 206, 229));
        panel1.setLayout(null);
        
        panel1.add(username);
        panel1.add(uname);
        panel1.add(password);
        panel1.add(pass);
        panel1.add(login);
        panel1.add(reg);
        
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1535,820);
        setResizable(false);
        getContentPane().setBackground(new Color(109, 173, 208));
        setTitle("Library Management System");
        setLayout(null);
        setVisible(true);
        
        add(title);
        add(panel1);
        
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }     
        });
        
        login.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                    loginActionPerformed(evt);
                } 
        });
    }
    
    private JLabel title;
    private JLabel username;
    private JTextField uname;
    private JLabel password;
    private JTextField pass;
    private JButton login;
    private JLabel reg;
    private JPanel panel1;
    
}