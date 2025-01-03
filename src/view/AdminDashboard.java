package view;

import java.awt.*;
import javax.swing.*;
import controller.BookController;
import controller.BorrowingController;
import controller.UserController;
import utility.Database;
import utility.UserSession;

/**
 * 
 * @author Christine Ann Dejito
 */
public class AdminDashboard extends javax.swing.JFrame{
    
    Database db = new Database();
    BookController bookC = new BookController(db);
    BorrowingController borrowC = new BorrowingController(db);
    UserController userC = new UserController(db);
    
    public AdminDashboard(){
        initComponents();
    }
    
    private void homeMouseClicked(java.awt.event.MouseEvent evt) {                                     
        setVisible(true);
    } 
    
    private void bookmMouseClicked(java.awt.event.MouseEvent evt) {                                     
        AdminBookManagement abm = new AdminBookManagement();
        abm.setVisible(true);
        setVisible(false);
    }
    
    private void usermMouseClicked(java.awt.event.MouseEvent evt) {                                     
        AdminUserManagement asm = new AdminUserManagement();
        asm.setVisible(true);
        setVisible(false);
    } 
    
    private void recordsMouseClicked(java.awt.event.MouseEvent evt) {                                     
        AdminRecords ar = new AdminRecords();
        ar.setVisible(true);
        setVisible(false);
    } 
    
    
    
    public static void main(String[] args) {
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
        
    }
    
    private void initComponents(){
        
        dash = new JLabel();
        dash.setText("Dashboard");
        dash.setBounds(75, 50, 300, 50);
        dash.setFont(new Font("Serif", Font.BOLD, 30));
        dash.setForeground(Color.WHITE);
        
        home = new JLabel();
        home.setText("Home");
        home.setBounds(40, 200, 300, 50);
        home.setFont(new Font("Serif", Font.PLAIN, 25));
        home.setForeground(Color.WHITE);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        
        bookm = new JLabel();
        bookm.setText("Book Management");
        bookm.setBounds(40, 260, 300, 50);
        bookm.setFont(new Font("Serif", Font.PLAIN, 25));
        bookm.setForeground(Color.WHITE);
        bookm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookmMouseClicked(evt);
            }
        });
        
        userm = new JLabel();
        userm.setText("User Management");
        userm.setBounds(40, 320, 300, 50);
        userm.setFont(new Font("Serif", Font.PLAIN, 25));
        userm.setForeground(Color.WHITE);
        userm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usermMouseClicked(evt);
            }
        });
        
        records = new JLabel();
        records.setText("Records");
        records.setBounds(40, 380, 300, 50);
        records.setFont(new Font("Serif", Font.PLAIN, 25));
        records.setForeground(Color.WHITE);
        records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordsMouseClicked(evt);
            }
        });
        
        ImageIcon pp = new ImageIcon("src/images/jingliu.jpg");
        
        username = new JLabel();
        username.setText(UserSession.getInstance().getUsername());
        username.setBounds(40, 600, 200, 200);
        username.setFont(new Font("Serif", Font.PLAIN, 25));
        username.setForeground(Color.WHITE);
//        username.setIcon(pp);
        username.setHorizontalTextPosition(JLabel.LEFT);
        username.setVerticalTextPosition(JLabel.CENTER);
        username.setLayout(null);
        
        nav = new JPanel();
        nav.setBounds(0,0,300, 820);
        nav.setBackground(new Color(0x00233D));
        nav.setLayout(null);
        
        nav.add(dash);
        nav.add(home);
        nav.add(bookm);
        nav.add(userm);
        nav.add(records);
        nav.add(username);
        
        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setVgap(-120);
        
        //BOX1
        booksl = new JLabel("BOOKS COUNT", SwingConstants.CENTER);
        booksl.setFont(new Font("Serif", Font.BOLD, 25));
        booksl.setForeground(Color.WHITE);
        
        booksc = new JLabel(""+bookC.getBookCount(), SwingConstants.CENTER);
        booksc.setFont(new Font("Serif", Font.BOLD, 40));
        booksc.setForeground(Color.WHITE);
        
        box1 = new JPanel();
        box1.setBackground(new Color(0x00233D));
        box1.setLayout(gridLayout);
        box1.add(booksl);
        box1.add(booksc);
        
        //BOX2
        usersl = new JLabel("USERS COUNT", SwingConstants.CENTER);
        usersl.setFont(new Font("Serif", Font.BOLD, 25));
        usersl.setForeground(Color.WHITE);
        
        usersc = new JLabel(""+userC.getUserCount(), SwingConstants.CENTER);
        usersc.setFont(new Font("Serif", Font.BOLD, 40));
        usersc.setForeground(Color.WHITE);
        
        box2 = new JPanel();
        box2.setBackground(new Color(0x00233D));
        box2.setLayout(gridLayout);
        box2.add(usersl);
        box2.add(usersc);
        
        
        //BOX3
        reservationsl = new JLabel("<html><div style='text-align: center'>RESERVATIONS COUNT</div></html>", SwingConstants.CENTER);
        reservationsl.setPreferredSize(new Dimension(80, 50));
        reservationsl.setSize(reservationsl.getPreferredSize());
        reservationsl.setFont(new Font("Serif", Font.BOLD, 25));
        reservationsl.setForeground(Color.WHITE);
        
        reservationsc = new JLabel(""+bookC.getCurrentlyReservedCount(), SwingConstants.CENTER);
        reservationsc.setFont(new Font("Serif", Font.BOLD, 40));
        reservationsc.setForeground(Color.WHITE);
        
        box3 = new JPanel();
        box3.setBackground(new Color(0x00233D));
        box3.setLayout(gridLayout);
        box3.add(reservationsl);
        box3.add(reservationsc);
        box3.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        
        
        //BOX4
        borrowl = new JLabel("<html><div style='text-align: center'>BORROWING COUNT</div></html>", SwingConstants.CENTER);
//        borrowl.setPreferredSize(new Dimension(120, 60)); // Set width and height
//        borrowl.setSize(borrowl.getPreferredSize());
        borrowl.setFont(new Font("Serif", Font.BOLD, 25));
        borrowl.setForeground(Color.WHITE);
        
        borrowc = new JLabel(""+bookC.getCurrentlyBorrowingCount(), SwingConstants.CENTER);
        borrowc.setFont(new Font("Serif", Font.BOLD, 40));
        borrowc.setForeground(Color.WHITE);
  
        box4 = new JPanel();
        box4.setBackground(new Color(0x00233D));
        box4.setLayout(gridLayout);
        box4.add(borrowl);
        box4.add(borrowc);
        
        
        //BOX5
        overduel = new JLabel("<html><div style='text-align: center'>OVERDUE BOOKS COUNT</div></html>", SwingConstants.CENTER);
        overduel.setFont(new Font("Serif", Font.BOLD, 25));
        overduel.setForeground(Color.WHITE);
        
        overduec = new JLabel(""+bookC.getCurrentlyOverdueCount(), SwingConstants.CENTER);
        overduec.setFont(new Font("Serif", Font.BOLD, 40));
        overduec.setForeground(Color.WHITE);
        
        box5 = new JPanel();
        box5.setBackground(new Color(0x00233D));
        box5.setLayout(gridLayout);
        box5.add(overduel);
        box5.add(overduec);
        
        
        //BOX6
        totalbl = new JLabel("<html><div style='text-align: center'>TOTAL BORROWED COUNT</div></html>", SwingConstants.CENTER);
        totalbl.setFont(new Font("Serif", Font.BOLD, 25));
        totalbl.setForeground(Color.WHITE);
        
        totalbc = new JLabel(""+bookC.getTotalBorrowingCount(), SwingConstants.CENTER);
        totalbc.setFont(new Font("Serif", Font.BOLD, 40));
        totalbc.setForeground(Color.WHITE);
        
        box6 = new JPanel();
        box6.setBackground(new Color(0x00233D));
        box6.setLayout(gridLayout);
        box6.add(totalbl);
        box6.add(totalbc);
        
        
        //BOXES DIV
        div1 = new JPanel();
        div1.setBounds(400, 100, 1020, 570);
        div1.setBackground(null);
        div1.setLayout(new GridLayout(2,3, 50, 70));
        
        div1.add(box1);
        div1.add(box2);
        div1.add(box3);
        div1.add(box4);
        div1.add(box5);
        div1.add(box6);
        
//        div2 = new JPanel();
//        div2.setBounds(400, 100, 1020, 570);
//        div2.setBackground(Color.green);
//        div2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1535,820);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Library Management System");
        setLayout(null);
        setVisible(true);
        
        add(nav);
        add(div1);
        //add(div2);
    }
    
    private javax.swing.JPanel nav;
    private javax.swing.JLabel dash;
    private javax.swing.JLabel home;
    private javax.swing.JLabel bookm;
    private javax.swing.JLabel userm;
    private javax.swing.JLabel records;
    private javax.swing.JLabel username;
    
    
    private javax.swing.JLabel booksl;
    private javax.swing.JLabel booksc;
    private javax.swing.JLabel usersl;
    private javax.swing.JLabel usersc;
    private javax.swing.JLabel reservationsl;
    private javax.swing.JLabel reservationsc;
    private javax.swing.JLabel borrowl;
    private javax.swing.JLabel borrowc;
    private javax.swing.JLabel overduel;
    private javax.swing.JLabel overduec;
    private javax.swing.JLabel totalbl;
    private javax.swing.JLabel totalbc;
    
    private javax.swing.JPanel div1;
    private javax.swing.JPanel box1;
    private javax.swing.JPanel box2;
    private javax.swing.JPanel box3;
    private javax.swing.JPanel box4;
    private javax.swing.JPanel box5;
    private javax.swing.JPanel box6;
    
    
}