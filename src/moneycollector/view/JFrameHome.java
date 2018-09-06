package moneycollector.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import moneycollector.service.MemberDetail;

/**
 * This is the home frame of the application
 * @author RIYAD
 */
public class JFrameHome extends javax.swing.JFrame {
    
    public static long TotalDays;
    public static int TotalMoney;
    private int onScreenX,onScreenY;
    private int componetsInPanel = 1,totalUser;
    private MemberDetail tempMember;
    private final JLabel lb[] = new JLabel[2];
    private MovingLeft move;
    private final DocumentOnTextField dotf = new DocumentOnTextField();
    private String lastQuery1,lastQuery2;
    private int sleepingNumber = 10;
    
    /**
     * Creates new form JFrameHome
     */
    public JFrameHome() {
        initComponents();
        TotalDays = getDifferenceDays();
        //test();
        setOnPerfectLocation();
        openDB();
        setThings();
        
    }
    
    /**
     * Setting the frame into a perfect location
     */
    private void setOnPerfectLocation(){
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((scrSize.width-this.getWidth())/2,(scrSize.height-this.getHeight())/4);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelTitle2 = new javax.swing.JLabel();
        jPanelContants = new javax.swing.JPanel();
        jPanelCoumnsName = new javax.swing.JPanel();
        jLabelStarted1 = new javax.swing.JLabel();
        jLabelStarted2 = new javax.swing.JLabel();
        jLabelStarted3 = new javax.swing.JLabel();
        jTextFieldSearchUser = new javax.swing.JTextField();
        jScrollPaneAllMembers = new javax.swing.JScrollPane();
        jPanelAllMembers = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();
        jButtonAddNewTransection = new javax.swing.JButton();
        jButtonAddNewMember = new javax.swing.JButton();
        jButtonAllTransection = new javax.swing.JButton();
        jButtonOption = new javax.swing.JButton();
        jButtonAllTransection1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jPanelMain.setBackground(new java.awt.Color(25, 25, 25));
        jPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255), 3));
        jPanelMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelMainMouseDragged(evt);
            }
        });
        jPanelMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMainMousePressed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 42)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitle.setText("Renaissanse");

        jLabelTitle2.setFont(new java.awt.Font("Kalpurush", 1, 20)); // NOI18N
        jLabelTitle2.setForeground(new java.awt.Color(51, 255, 0));
        jLabelTitle2.setText("Social Welfare Co-operative");

        jPanelContants.setBackground(new java.awt.Color(55, 55, 40));
        jPanelContants.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanelContants.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelContants.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelContantsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelContantsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelContantsLayout = new javax.swing.GroupLayout(jPanelContants);
        jPanelContants.setLayout(jPanelContantsLayout);
        jPanelContantsLayout.setHorizontalGroup(
            jPanelContantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelContantsLayout.setVerticalGroup(
            jPanelContantsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        jPanelCoumnsName.setBackground(new java.awt.Color(15, 15, 15));
        jPanelCoumnsName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        jLabelStarted1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStarted1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelStarted1.setForeground(new java.awt.Color(255, 255, 0));
        jLabelStarted1.setText("NAME");

        jLabelStarted2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStarted2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelStarted2.setForeground(new java.awt.Color(255, 255, 0));
        jLabelStarted2.setText("ID");

        jLabelStarted3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStarted3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelStarted3.setForeground(new java.awt.Color(255, 255, 0));
        jLabelStarted3.setText("TOTAL AMOUNT");

        jTextFieldSearchUser.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldSearchUser.setText("Search User...");
        jTextFieldSearchUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSearchUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldSearchUserFocusLost(evt);
            }
        });

        jScrollPaneAllMembers.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneAllMembers.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelAllMembers.setBackground(new java.awt.Color(100, 100, 80));
        jScrollPaneAllMembers.setViewportView(jPanelAllMembers);

        javax.swing.GroupLayout jPanelCoumnsNameLayout = new javax.swing.GroupLayout(jPanelCoumnsName);
        jPanelCoumnsName.setLayout(jPanelCoumnsNameLayout);
        jPanelCoumnsNameLayout.setHorizontalGroup(
            jPanelCoumnsNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoumnsNameLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelStarted1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelStarted2)
                .addGap(194, 194, 194)
                .addComponent(jLabelStarted3)
                .addGap(76, 76, 76)
                .addComponent(jTextFieldSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPaneAllMembers)
        );
        jPanelCoumnsNameLayout.setVerticalGroup(
            jPanelCoumnsNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCoumnsNameLayout.createSequentialGroup()
                .addGroup(jPanelCoumnsNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStarted1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCoumnsNameLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanelCoumnsNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelStarted3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jTextFieldSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelStarted2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAllMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButtonClose.setBackground(new java.awt.Color(153, 153, 153));
        jButtonClose.setText("X");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonMinimize.setBackground(new java.awt.Color(153, 153, 153));
        jButtonMinimize.setText("-");
        jButtonMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizeActionPerformed(evt);
            }
        });

        jButtonAddNewTransection.setBackground(new java.awt.Color(153, 0, 0));
        jButtonAddNewTransection.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddNewTransection.setForeground(new java.awt.Color(255, 255, 51));
        jButtonAddNewTransection.setText("ADD NEW TRANSECTION");
        jButtonAddNewTransection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAddNewTransectionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAddNewTransectionMouseExited(evt);
            }
        });
        jButtonAddNewTransection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewTransectionActionPerformed(evt);
            }
        });

        jButtonAddNewMember.setBackground(new java.awt.Color(153, 0, 0));
        jButtonAddNewMember.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAddNewMember.setForeground(new java.awt.Color(255, 255, 51));
        jButtonAddNewMember.setText("ADD NEW MEMBER");
        jButtonAddNewMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAddNewMemberMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAddNewMemberMouseExited(evt);
            }
        });
        jButtonAddNewMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNewMemberActionPerformed(evt);
            }
        });

        jButtonAllTransection.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonAllTransection.setText("ALL Transections");
        jButtonAllTransection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAllTransectionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAllTransectionMouseExited(evt);
            }
        });
        jButtonAllTransection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllTransectionActionPerformed(evt);
            }
        });

        jButtonOption.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonOption.setText("OPTIONS");
        jButtonOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOptionActionPerformed(evt);
            }
        });

        jButtonAllTransection1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButtonAllTransection1.setText("Bussiness Management");
        jButtonAllTransection1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAllTransection1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAllTransection1MouseExited(evt);
            }
        });
        jButtonAllTransection1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAllTransection1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCoumnsName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAddNewMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddNewTransection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabelTitle))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabelTitle2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addComponent(jButtonOption)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMinimize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addComponent(jButtonAllTransection1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAllTransection)
                        .addContainerGap())))
            .addComponent(jPanelContants, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonClose)
                            .addComponent(jButtonMinimize)
                            .addComponent(jButtonOption))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAllTransection, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAllTransection1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jButtonAddNewMember, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddNewTransection, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11)
                .addComponent(jPanelContants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelCoumnsName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private class DocumentOnTextField implements DocumentListener{
        @Override
        public void insertUpdate(DocumentEvent e) {
            searchData();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            searchData();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    }
    
    
    /**
     * Adding things to the scrollPane
     * @param mem is the Panel which to be added
     */
    private void updateUsersPanel(JPanelMember mem){
        jPanelAllMembers.setPreferredSize(new Dimension(978,48*componetsInPanel));
        jScrollPaneAllMembers.setPreferredSize(new Dimension(978,48*componetsInPanel));
        jPanelAllMembers.add(mem);
        jPanelAllMembers.repaint();
        jPanelAllMembers.revalidate();
        componetsInPanel++;
    }
    
    /**
     * Overloaded for just update the panel;
     */
    public void updateUsersPanel(){
        jPanelAllMembers.setPreferredSize(new Dimension(978,48*componetsInPanel));
        jScrollPaneAllMembers.setPreferredSize(new Dimension(978,48*componetsInPanel));
        jPanelAllMembers.repaint();
        jPanelAllMembers.revalidate();
    }
    
    private long getDifferenceDays() {
        Date d1 = new Date(116,8,1);
        Date d2 = new Date();
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
    /**
     * This method does set all the texts from database to moving labels
     */
    private void setThings(){
        
        for(int i = 0;i<2;i++){
            lb[i] = new JLabel();
            lb[i].setForeground(Color.CYAN);
            lb[i].setFont(new Font("Tahoma",Font.PLAIN,24));
        }
        TotalMoney = getData("SELECT IFNULL(SUM(AMOUNT),0) + (SELECT IFNULL(SUM(AMOUNT),0) FROM OTHER) AS RESULT FROM TRANSECTIONS");
        lb[0].setText("TOTAL AMOUNT:" + TotalMoney  + 
                "        TOTAL MEMBERS:" + getData("SELECT COUNT(ID) AS RESULT FROM USERS") + 
                "        TOTAL TRANSECTIONS:" + getData("SELECT COUNT(ID) + (SELECT COUNT(DEPOSITEDBY) FROM OTHER) AS RESULT FROM TRANSECTIONS")  +
                "        TOTAL CASH IN BANK :" + getData("SELECT IFNULL(SUM(AMOUNT),0) AS RESULT FROM BANK") +
                "        TOTAL CASH IN HAND :" + ( TotalMoney - getData("SELECT IFNULL(SUM(AMOUNT),0) AS RESULT FROM BANK")) +
                "        DAILY CONTRIBUTION(till Today):" + String.format("%.2f",((float)TotalMoney/TotalDays)) + 
                "        TOTAL AMOUNT IN THIS MONTH:" + getData("SELECT ifnull(SUM(AMOUNT),0) + (SELECT ifnull(SUM(AMOUNT),0) FROM OTHER WHERE strftime('%Y-%m-%d',DATEDEPOSITED/1000,'unixepoch') BETWEEN date('now','start of month') and date('now','localtime')) " +
                        " as RESULT FROM TRANSECTIONS WHERE strftime('%Y-%m-%d',AMOUNTRECEIVED/1000,'unixepoch') BETWEEN date('now','start of month') and date('now','localtime')")  +
                "        TOTAL AMOUNT IN LAST MONTH:" + getData("SELECT IFNULL(SUM(AMOUNT),0) + (SELECT IFNULL(SUM(AMOUNT),0) FROM OTHER WHERE strftime('%Y-%m-%d',DATEDEPOSITED/1000,'unixepoch') BETWEEN date('now','start of month','-1 month') and date('now','start of month','-1 day')) AS RESULT " + 
                        " FROM TRANSECTIONS WHERE strftime('%Y-%m-%d',AMOUNTRECEIVED/1000,'unixepoch') BETWEEN date('now','start of month','-1 month') and date('now','start of month','-1 day');"));
        lb[1].setText(lb[0].getText());
        int len = lb[0].getText().length();
        for(int i = 0;i<2;i++){
            lb[i].setBounds((len*15*i)+5,10,len*15,32);
            this.jPanelContants.add(lb[i]);
        }
        move = new MovingLeft((len*15)+5);
        move.start();
    }
    
    /**
     * This method does get the data from database with different types of queries.
     * @param query Query for return a result. There should be one result query.
     * @return Result of the query. The column name should be "RESULT"
     */
    private int getData(String query){
        Connection c;
        Statement stmt;
        int result = 0;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                result =  rs.getInt("RESULT");
            }
            rs.close();
            stmt.close();
            return result;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return result;
    }
    
    /**
     * This is a thread which can move texts right to left
     */
    private class MovingLeft extends Thread{
        private int x;
        MovingLeft(int x){
            this.x = x;
        }
        @Override
        public void run(){
            for(int i = 545;i>=5;i--){
                    lb[0].setLocation(i-x+5,10);
                    lb[1].setLocation(i,10);
                    try {
                        sleep(sleepingNumber);
                    } catch (InterruptedException ex) {}
            }
            while(true){
                for(int i = x;i>=5;i--){
                    lb[0].setLocation(i-x+5,10);
                    lb[1].setLocation(i,10);
                    try {
                        sleep(sleepingNumber);
                    } catch (InterruptedException ex) {}
                }
            }
        }
    }
    
    
    /**
     * Opening a Database if there is not exist a new database will created.
     * 
     */
    private void openDB() {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");


            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS USERS ("
                    + "ID VARCHAR(100) PRIMARY KEY NOT NULL,"
                    + "NAME VARCHAR( 100 ) NOT NULL ,"
                    + "REFERENCE VARCHAR( 100 ) NOT NULL"
                    + ")";
            stmt.executeUpdate(sql); 
            
            stmt = c.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS TRANSECTIONS ("
                    + "ID VARCHAR(100) NOT NULL,"
                    + "AMOUNT INTEGER NOT NULL ,"
                    + "AMOUNTRECEIVED DATE NOT NULL,"
                    + "FOREIGN KEY (ID) REFERENCES USERS ON UPDATE CASCADE ON DELETE CASCADE,"
                    + "PRIMARY KEY (ID,AMOUNTRECEIVED)"
                    + ")";
            stmt.executeUpdate(sql);
            
            stmt = c.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS OTHER ("
                    + "DATEDEPOSITED DATE NOT NULL,"
                    + "DEPOSITEDBY VARCHAR(100) NOT NULL ,"
                    + "AMOUNT INTEGER NOT NULL,"
                    + "PRIMARY KEY (DATEDEPOSITED,DEPOSITEDBY)"
                    + ")";
            stmt.executeUpdate(sql);
            
            stmt = c.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS BANK ("
                    + "DATEDEPOSITED DATE NOT NULL,"
                    + "DEPOSITEDBY VARCHAR(100) NOT NULL ,"
                    + "AMOUNT INTEGER NOT NULL,"
                    + "PRIMARY KEY (DATEDEPOSITED,DEPOSITEDBY)"
                    + ")";
            stmt.executeUpdate(sql);
            
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
        loadData();

    }
    
    /**
     * Loading database from a file
     */
    public void loadData() {
        Connection c;
        Statement stmt;
        try {
            jPanelAllMembers.removeAll();
            componetsInPanel = 1;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.createStatement();
            
            lastQuery1 = "SELECT USERS.ID,NAME,REFERENCE,SUM(AMOUNT) AS TOTAL " +
                    "FROM USERS,TRANSECTIONS WHERE USERS.ID = TRANSECTIONS.ID" +
                    " GROUP BY USERS.ID";
            
            lastQuery2 = "SELECT ID,NAME,REFERENCE FROM USERS WHERE ID NOT IN " +
                    " (SELECT ID FROM TRANSECTIONS)";
            
            String other = "SELECT SUM(AMOUNT) AS MONEY FROM OTHER";
            ResultSet rs = stmt.executeQuery(other);
            while(rs.next()){
                tempMember = new MemberDetail("OTHER","A00000","Anyone",rs.getInt("MONEY"));
                updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
            }
            rs = stmt.executeQuery(lastQuery1);
            while (rs.next()) {
                tempMember = new MemberDetail(rs.getString("NAME"),rs.getString("ID"), rs.getString("REFERENCE"),rs.getInt("TOTAL"));
                updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
            }
            
            rs = stmt.executeQuery(lastQuery2);
            while (rs.next()) {
                tempMember = new MemberDetail(rs.getString("NAME"),rs.getString("ID"), rs.getString("REFERENCE"));
                updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
            }
            
            totalUser = componetsInPanel;
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }  
    
    private void searchData(){
        Connection c;
        Statement stmt;
        String query1,query2;
        ResultSet rs;
        boolean isGotResult = false;
        try {
            jPanelAllMembers.removeAll();
            componetsInPanel = 1;
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");
            
            String text = this.jTextFieldSearchUser.getText().trim();            
            text = text.replaceAll("\'", "");
            
            query1  = "SELECT USERS.ID,NAME,REFERENCE,SUM(AMOUNT) AS TOTAL " +
                    "FROM USERS,TRANSECTIONS WHERE USERS.ID = TRANSECTIONS.ID AND NAME LIKE \'" + text + "%\'" + 
                    " GROUP BY USERS.ID";
           
            query2 = "SELECT ID,NAME,REFERENCE FROM USERS WHERE ID NOT IN " +
                    " (SELECT ID FROM TRANSECTIONS) AND NAME LIKE \'" + text + "%\'";
            
            String other = "SELECT SUM(AMOUNT) AS MONEY FROM OTHER";
            stmt = c.createStatement();
            
            if(jTextFieldSearchUser.getText().isEmpty()){
                rs = stmt.executeQuery(other);
                while(rs.next()){
                    tempMember = new MemberDetail("OTHER","A00000","Anyone",rs.getInt("MONEY"));
                    updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
                }
            }
            
            rs = stmt.executeQuery(query1);
            while (rs.next()) {
                isGotResult = true;
                tempMember = new MemberDetail(rs.getString("NAME"),rs.getString("ID"), rs.getString("REFERENCE"),rs.getInt("TOTAL"));
                updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
            }
            rs = stmt.executeQuery(query2);
            while (rs.next()) {
                isGotResult  = true;
                tempMember = new MemberDetail(rs.getString("NAME"),rs.getString("ID"), rs.getString("REFERENCE"));
                updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
            }
            
            if(isGotResult){
                lastQuery1 = query1;
                lastQuery2 = query2;
            }else{
                rs = stmt.executeQuery(lastQuery1);
                while (rs.next()) {
                    tempMember = new MemberDetail(rs.getString("NAME"),rs.getString("ID"), rs.getString("REFERENCE"),rs.getInt("TOTAL"));
                    updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
                }
                rs = stmt.executeQuery(lastQuery2);
                while (rs.next()) {
                    tempMember = new MemberDetail(rs.getString("NAME"),rs.getString("ID"), rs.getString("REFERENCE"));
                    updateUsersPanel(new JPanelMember(this,componetsInPanel,tempMember));
                }
            }
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    private void jPanelMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMainMouseDragged
        //To move the undecorated frame/panel with mouse dragged.
        this.setLocation(this.getX()+(evt.getX()-this.onScreenX),this.getY()+(evt.getY()-this.onScreenY));
    }//GEN-LAST:event_jPanelMainMouseDragged

    private void jPanelMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMainMousePressed
        //To move the undecorated frame/panel with mouse dragged.
        //This Panel will save the clicked mouse position.
        this.onScreenX = evt.getX();
        this.onScreenY = evt.getY();
        this.requestFocus();
    }//GEN-LAST:event_jPanelMainMousePressed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        //When Click the X button
        int ret = JOptionPane.showConfirmDialog(rootPane, "Are You Wanna Close This App???", "Renaissance APP By Riyad",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ret == 0)    System.exit(0);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizeActionPerformed
        //When click the minimize button
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizeActionPerformed

    private void jButtonAddNewTransectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewTransectionActionPerformed
        //When click the add new transection button
        //if there is no users available there should'nt have any transections
        if(totalUser == 1){
            JOptionPane.showMessageDialog(rootPane, "Sorry you need at least one user to make a transection.", "Error need one user", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JFrameNewTransection nts = new JFrameNewTransection(totalUser-1);
        nts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAddNewTransectionActionPerformed

    private void jButtonAddNewTransectionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddNewTransectionMouseEntered
        //This is just mouse listener
        //When the mouse cursor is over the button this method will called
        jButtonAddNewTransection.setBackground(new Color(204,0,0));
        jButtonAddNewTransection.setForeground(Color.CYAN);
    }//GEN-LAST:event_jButtonAddNewTransectionMouseEntered

    private void jButtonAddNewTransectionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddNewTransectionMouseExited
        //This is just mouse listener
        //When the mouse cursor is over the button this method will called
        jButtonAddNewTransection.setBackground(new Color(153,0,0));
        jButtonAddNewTransection.setForeground(new Color(255,255,102));
    }//GEN-LAST:event_jButtonAddNewTransectionMouseExited

    private void jButtonAddNewMemberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddNewMemberMouseEntered
        //This is just mouse listener
        //When the mouse cursor is over the button this method will called
        jButtonAddNewMember.setBackground(new Color(204,0,0));
        jButtonAddNewMember.setForeground(Color.CYAN);
    }//GEN-LAST:event_jButtonAddNewMemberMouseEntered

    private void jButtonAddNewMemberMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddNewMemberMouseExited
        //This is just mouse listener
        //When the mouse cursor is over the button this method will called
        jButtonAddNewMember.setBackground(new Color(153,0,0));
        jButtonAddNewMember.setForeground(new Color(255,255,102));
    }//GEN-LAST:event_jButtonAddNewMemberMouseExited

    private void jButtonAddNewMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNewMemberActionPerformed
        //When the button is clicked
        JFrameNewUser newUser = new JFrameNewUser();
        newUser.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAddNewMemberActionPerformed

    private void jButtonAllTransectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllTransectionActionPerformed
        //When the button is clicked
        JFrameAllTransections jFrameAllTransections =  new JFrameAllTransections(totalUser-1);
        jFrameAllTransections.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonAllTransectionActionPerformed

    private void jButtonOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOptionActionPerformed
        //When option button clicked
        JDialogOption.showTheFrame(this);
    }//GEN-LAST:event_jButtonOptionActionPerformed

    private void jTextFieldSearchUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchUserFocusGained
        jTextFieldSearchUser.setForeground(Color.black);
        jTextFieldSearchUser.setText("");
        jTextFieldSearchUser.getDocument().addDocumentListener(dotf);
    }//GEN-LAST:event_jTextFieldSearchUserFocusGained

    private void jTextFieldSearchUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSearchUserFocusLost
        if(jTextFieldSearchUser.getText().isEmpty()){
            jTextFieldSearchUser.getDocument().removeDocumentListener(dotf);
            jTextFieldSearchUser.setText("Seach User...");
            jTextFieldSearchUser.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_jTextFieldSearchUserFocusLost

    private void jPanelContantsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContantsMouseEntered
        sleepingNumber = 3;
    }//GEN-LAST:event_jPanelContantsMouseEntered

    private void jPanelContantsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContantsMouseExited
        sleepingNumber = 10;
    }//GEN-LAST:event_jPanelContantsMouseExited

    private void jButtonAllTransectionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAllTransectionMouseEntered
        jButtonAllTransection.setBackground(Color.WHITE);
    }//GEN-LAST:event_jButtonAllTransectionMouseEntered

    private void jButtonAllTransectionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAllTransectionMouseExited
        jButtonAllTransection.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonAllTransectionMouseExited

    private void jButtonAllTransection1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAllTransection1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAllTransection1MouseEntered

    private void jButtonAllTransection1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAllTransection1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAllTransection1MouseExited

    private void jButtonAllTransection1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAllTransection1ActionPerformed
        JFrameBussinessManagement bm = new JFrameBussinessManagement();
        bm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAllTransection1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNewMember;
    private javax.swing.JButton jButtonAddNewTransection;
    private javax.swing.JButton jButtonAllTransection;
    private javax.swing.JButton jButtonAllTransection1;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JButton jButtonOption;
    private javax.swing.JLabel jLabelStarted1;
    private javax.swing.JLabel jLabelStarted2;
    private javax.swing.JLabel jLabelStarted3;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitle2;
    private javax.swing.JPanel jPanelAllMembers;
    private javax.swing.JPanel jPanelContants;
    private javax.swing.JPanel jPanelCoumnsName;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPaneAllMembers;
    private javax.swing.JTextField jTextFieldSearchUser;
    // End of variables declaration//GEN-END:variables
}