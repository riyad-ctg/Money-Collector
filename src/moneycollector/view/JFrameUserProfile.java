package moneycollector.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import moneycollector.service.MemberDetail;

/**
 *
 * @author RIYAD
 */
public class JFrameUserProfile extends javax.swing.JFrame {
    
    private int onScreenX,onScreenY;  //To move undecorated frame with mouse dragged
    private final MemberDetail member;
    private MovingThread move = new MovingThread();
    private int transectionCount = 0;
    
    /**
     * Creates new form JFrameHome
     * @param member MemberDetail of a member
     */
    public JFrameUserProfile(MemberDetail member) {
        initComponents();
        setOnPerfectLocation();
        
        this.member = member;
        loadTable();
        setTexts();
        checkOther();
    }
    
    private void loadTable(){
         try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");
            DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            DefaultTableModel tableModel;
            ResultSet rs;
            Statement stmt = c.createStatement();
            
            if(member.getId().equals("A00000")){
                rs = stmt.executeQuery("SELECT DATEDEPOSITED,AMOUNT,DEPOSITEDBY FROM OTHER ORDER BY DATEDEPOSITED ASC");
                jTableUserInfo.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {},
                    new String [] {
                        "Date", "Amount" , "Deposited By"
                    }) 
                {
                    Class[] types = new Class [] {
                        java.lang.String.class, java.lang.Integer.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false
                    };
                    @Override
                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                tableModel = (DefaultTableModel) jTableUserInfo.getModel();
                Object ob[] = new Object[4];
                while(rs.next()){
                   transectionCount++;
                   ob[0] =  format.format(format2.parse(rs.getDate("DATEDEPOSITED").toString()));
                   ob[1] = rs.getInt(2);
                   ob[2] = rs.getString(3);
                   tableModel.addRow(ob);
                }
            }else{
                rs = stmt.executeQuery("SELECT AMOUNTRECEIVED,AMOUNT FROM TRANSECTIONS WHERE ID = '"+member.getId()+"' ORDER BY AMOUNTRECEIVED ASC");
                tableModel = (DefaultTableModel) jTableUserInfo.getModel();
                Object ob[] = new Object[3];
                while(rs.next()){
                    transectionCount++;
                    ob[0] =  format.format(format2.parse(rs.getDate("AMOUNTRECEIVED").toString()));
                    ob[1] = rs.getInt(2);
                    tableModel.addRow(ob);
                }
            }
            
            
            
         }catch(ClassNotFoundException | SQLException | ParseException ex){
             Logger.getLogger(JFrameUserProfile.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
    /**
     * Set Texts of labels
     */
    private void setTexts(){
        this.jLabelID.setText("ID: " + member.getId());
        this.jLabelName.setText("NAME: " + member.getName());
        this.jLabelReference.setText("REFERENCE: " + member.getRef());
        this.jLabelAmount.setText(member.getAmount() + "");
        this.jLabelDailyContribution.setText("Daily Contribution " + String.format("%.2f",(float)member.getAmount()/JFrameHome.TotalDays));
        this.jLabelMonthlyContribution.setText("Monthly Contribution " + String.format("%.2f",((float)member.getAmount()/JFrameHome.TotalDays)*30));
        if(member.getAmount() == 0){
            this.jLabelPercentage.setText("Deposited 0.0% of Total Amount");
        }else{
            this.jLabelPercentage.setText("Deposited " + String.format("%.2f",(float)(100*member.getAmount())/JFrameHome.TotalMoney) + "% of Total Amount");
        }
        this.jLabelTransectionCreated.setText("Created " + transectionCount + " Transections");
        move.start();
    }
    
    /**
     * Setting the frame into a perfect location
     */
    private void setOnPerfectLocation(){
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((scrSize.width-this.getWidth())/2,(scrSize.height-this.getHeight())/4);
    }
    
    /**
     * The extended thread to moving the text
     */
    private class MovingThread extends Thread{
        @Override
        public void run(){
            while(true){
                for(int i = 40;i<=50;i++){
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {}
                    jLabelAmount.setFont(new java.awt.Font("Segoe Print", 1, i));
                }
                for(int i = 50;i>=40;i--){
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {}
                    jLabelAmount.setFont(new java.awt.Font("Segoe Print", 1, i));
                }
            }
        }
    }
    
    private void checkOther(){
        if(member.getId().equals("A00000")){
            this.jButtonDeleteUser.setEnabled(false);
            this.jButtonEditUser.setEnabled(false);
        }
    }
    
    /**
     * Deleting selected data from the database
     */
    private void deleteData() {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");
            
            stmt = c.prepareStatement("DELETE FROM TRANSECTIONS WHERE ID = ?");
            stmt.setString(1, member.getId());
            stmt.executeUpdate();
            
            stmt = c.prepareStatement("DELETE FROM USERS WHERE ID = ?");
            stmt.setString(1, member.getId());
            stmt.executeUpdate();
            
            stmt.close();
            c.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabelReference = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTotalAmount = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jButtonEditUser = new javax.swing.JButton();
        jButtonDeleteUser = new javax.swing.JButton();
        jLabelDailyContribution = new javax.swing.JLabel();
        jLabelMonthlyContribution = new javax.swing.JLabel();
        jLabelPercentage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUserInfo = new javax.swing.JTable();
        jLabelTransectionCreated = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelMain.setBackground(new java.awt.Color(25, 25, 25));
        jPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 204), 3));
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

        jLabelTitle.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitle.setText("MEMBER PROFILE");

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

        jButtonBack.setBackground(new java.awt.Color(153, 0, 0));
        jButtonBack.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 51));
        jButtonBack.setText("BACK");
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBackMouseExited(evt);
            }
        });
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 22)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("NAME:");

        jLabelID.setFont(new java.awt.Font("Tempus Sans ITC", 1, 22)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");

        jLabelReference.setFont(new java.awt.Font("Tempus Sans ITC", 1, 22)); // NOI18N
        jLabelReference.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReference.setText("REFERENCE:");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabelTotalAmount.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabelTotalAmount.setForeground(new java.awt.Color(204, 255, 204));
        jLabelTotalAmount.setText("TOTAL AMOUNT");

        jLabelAmount.setFont(new java.awt.Font("Segoe Print", 1, 40)); // NOI18N
        jLabelAmount.setForeground(new java.awt.Color(204, 255, 204));
        jLabelAmount.setText("0000000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAmount))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTotalAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jButtonEditUser.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jButtonEditUser.setText("Edit This User");
        jButtonEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditUserActionPerformed(evt);
            }
        });

        jButtonDeleteUser.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jButtonDeleteUser.setText("Delete This User");
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        jLabelDailyContribution.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelDailyContribution.setForeground(new java.awt.Color(240, 240, 150));
        jLabelDailyContribution.setText("Daily Contribution");

        jLabelMonthlyContribution.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelMonthlyContribution.setForeground(new java.awt.Color(240, 240, 150));
        jLabelMonthlyContribution.setText("MonthlyContribution");

        jLabelPercentage.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelPercentage.setForeground(new java.awt.Color(240, 240, 150));
        jLabelPercentage.setText("Percentage");

        jTableUserInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        jTableUserInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableUserInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUserInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableUserInfo.setRowHeight(24);
        jScrollPane1.setViewportView(jTableUserInfo);

        jLabelTransectionCreated.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelTransectionCreated.setForeground(new java.awt.Color(240, 240, 150));
        jLabelTransectionCreated.setText("Created Transection");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMinimize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jButtonEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelName)
                                            .addComponent(jLabelID)
                                            .addComponent(jLabelReference)))
                                    .addGroup(jPanelMainLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelMonthlyContribution)
                                            .addComponent(jLabelDailyContribution)
                                            .addComponent(jLabelPercentage)
                                            .addComponent(jLabelTransectionCreated))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonClose)
                        .addComponent(jButtonMinimize))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTitle))))
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelReference)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTransectionCreated)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDailyContribution)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMonthlyContribution)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPercentage)
                        .addGap(30, 30, 30)))
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMainMousePressed
        //To move the undecorated frame/panel with mouse dragged.
        //This Panel will save the clicked mouse position.
        this.onScreenX = evt.getX();
        this.onScreenY = evt.getY();
    }//GEN-LAST:event_jPanelMainMousePressed

    private void jPanelMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMainMouseDragged
        //To move the undecorated frame/panel with mouse dragged.
        this.setLocation(this.getX()+(evt.getX()-this.onScreenX),this.getY()+(evt.getY()-this.onScreenY));
    }//GEN-LAST:event_jPanelMainMouseDragged

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        JFrameHome home  = new JFrameHome();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseExited
        jButtonBack.setBackground(new Color(153,0,0));
        jButtonBack.setForeground(new Color(255,255,102));
    }//GEN-LAST:event_jButtonBackMouseExited

    private void jButtonBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseEntered
        jButtonBack.setBackground(new Color(204,0,0));
        jButtonBack.setForeground(Color.CYAN);
    }//GEN-LAST:event_jButtonBackMouseEntered

    private void jButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizeActionPerformed
        //When click the minimize button
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizeActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        //When Click the X button
        JFrameHome home  = new JFrameHome();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
        int ret =  JOptionPane.showConfirmDialog(rootPane,"Are you sure to delete this user?\n\nAll transetions of this user will be removed.\nYou cannot undo later.","Are You Sure??",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ret == 0){
            deleteData();
            this.dispose();
            JFrameHome home  = new JFrameHome();
            home.setVisible(true);
            JOptionPane.showMessageDialog(null, "Record successfully deleted", "Database Status", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    private void jButtonEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditUserActionPerformed
        JFrameNewUser nsu = new JFrameNewUser(member);
        nsu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonEditUserActionPerformed
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonEditUser;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelDailyContribution;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMonthlyContribution;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPercentage;
    private javax.swing.JLabel jLabelReference;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTotalAmount;
    private javax.swing.JLabel jLabelTransectionCreated;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUserInfo;
    // End of variables declaration//GEN-END:variables
}