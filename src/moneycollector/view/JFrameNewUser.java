package moneycollector.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import moneycollector.service.MemberDetail;

/**
 *
 * @author RIYAD
 */
public class JFrameNewUser extends javax.swing.JFrame {
    
    private int onScreenX,onScreenY;  //To move undecorated frame with mouse dragged
    private boolean isEditor;
    private MemberDetail member;
    
    /**
     * Creates new form JFrameHome
     */
    public JFrameNewUser() {
        initComponents();
        setOnPerfectLocation();
        jTextFieldName.requestFocus();
    }
    
    public JFrameNewUser(MemberDetail member){
        this();
        this.member = member;
        isEditor = true;
        this.jLabelTitle.setText("UPDATE USER");
        setData();
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
        jButtonClose = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldID = new javax.swing.JTextField();
        jLabelID = new javax.swing.JLabel();
        jTextFieldReference = new javax.swing.JTextField();
        jLabelReference = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelMain.setBackground(new java.awt.Color(25, 25, 25));
        jPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 3));
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

        jLabelTitle.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 48)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitle.setText("NEW MEMBER");

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

        jLabelName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("NAME:");

        jTextFieldName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N

        jTextFieldID.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N

        jLabelID.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setText("ID:");

        jTextFieldReference.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N

        jLabelReference.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelReference.setForeground(new java.awt.Color(255, 255, 255));
        jLabelReference.setText("Reference:");

        jButtonSave.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jButtonSave.setText("SAVE");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelName)
                            .addComponent(jLabelID)
                            .addComponent(jLabelReference)))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonMinimize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldReference, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelTitle)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 151, Short.MAX_VALUE))))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonMinimize))
                .addGap(3, 3, 3)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitle))
                .addGap(29, 29, 29)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReference)
                    .addComponent(jTextFieldReference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void setData(){
        this.jTextFieldID.setText(member.getId());
        this.jTextFieldName.setText(member.getName());
        this.jTextFieldReference.setText(member.getRef());
    }
    
    /**
     * Inserting data to the desired database
     */
    private void insertData(String id,String name,String ref) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.prepareStatement("INSERT INTO USERS (ID,NAME,REFERENCE)"
                    + "VALUES (?,?,?)");
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setString(3, ref);

            stmt.executeUpdate();
            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(null, "Record successfully inserted", "Database Status", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    /**
     * Updating data to the desired database
     */
    private void updateData(MemberDetail member,String oldID) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.prepareStatement("UPDATE USERS SET ID = ?,NAME = ?,REFERENCE = ? WHERE ID = ?");
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getName());
            stmt.setString(3, member.getRef());
            stmt.setString(4, oldID);
            stmt.executeUpdate();
            
            
            stmt = c.prepareStatement("UPDATE TRANSECTIONS SET ID = ? WHERE ID = ?");
            stmt.setString(1,member.getId());
            stmt.setString(2,oldID);
            stmt.executeUpdate();
            
            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(null, "Record successfully updated", "Database Status", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private boolean isAvailable(String id){
        if(id.equals("A00000")) return false;
        if(isEditor && id.equals(member.getId())) return true;
        int count = 0;
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");
            
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT COUNT(ID) AS RESULT FROM USERS "+
                    "WHERE ID = \'"+ id +"\'")) {
                while (rs.next()) {
                    count = rs.getInt("RESULT");
                }
            }
            stmt.close();
            return (count != 1);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return (count != 1);
    }
    
    
    /**
     * System.out.println
     */
    private void pp(Object ob){
        System.out.println(ob);
    }
    
    /**
     * System.out.print
     */
    private void p(Object ob){
        System.out.print(ob);
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
    }//GEN-LAST:event_jPanelMainMousePressed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        //When Click the X button
        JFrameHome home  = new JFrameHome();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizeActionPerformed
        //When click the minimize button
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizeActionPerformed

    private void jButtonBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseEntered
         jButtonBack.setBackground(new Color(204,0,0));
        jButtonBack.setForeground(Color.CYAN);
    }//GEN-LAST:event_jButtonBackMouseEntered

    private void jButtonBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseExited
        jButtonBack.setBackground(new Color(153,0,0));
        jButtonBack.setForeground(new Color(255,255,102));
    }//GEN-LAST:event_jButtonBackMouseExited

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        if(isEditor){
            JFrameUserProfile back  = new JFrameUserProfile(member);
            back.setVisible(true);
        }else{
            JFrameHome home = new JFrameHome();
            home.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
        //---------------- Data Validation steps --------------------//
        if(jTextFieldName.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please fill up Name","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldName.requestFocus();
            return;
        }else if(jTextFieldID.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please fill up ID","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldID.requestFocus();
            return;
        }else if(jTextFieldReference.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please fill up Reference","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldReference.requestFocus();
            return;
        }
        
        jTextFieldName.setText(jTextFieldName.getText().trim());
        jTextFieldID.setText(jTextFieldID.getText().trim());
        jTextFieldReference.setText(jTextFieldReference.getText().trim());
        
        // -------------------- End Data Validation ---------------\\
        
        if(isEditor){
            if(isAvailable(jTextFieldID.getText())){
               int ret = JOptionPane.showConfirmDialog(rootPane,"Are you sure to update this account?\n"+
                       "ID:"  + ((member.getId().equals(this.jTextFieldID.getText()))?"NOT CHANGED":"Previews:" + member.getId() + "  New " + this.jTextFieldID.getText()) + "\n" +
                       "NAME:"  + ((member.getName().equals(this.jTextFieldName.getText()))?"NOT CHANGED":"Previews:" + member.getName() + "  New " + this.jTextFieldName.getText()) + "\n" + 
                       "REFERENCE:"  + ((member.getRef().equals(this.jTextFieldReference.getText()))?"NOT CHANGED":"Previews:" + member.getRef()+ "  New " + this.jTextFieldReference.getText() + "\n"),
                       "Are You Sure??",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if(ret==0){
                    String oldID = member.getId();
                    member.setId(jTextFieldID.getText());
                    member.setName(jTextFieldName.getText());
                    member.setRef(jTextFieldReference.getText());
                    updateData(member,oldID);
                    JFrameUserProfile usf = new JFrameUserProfile(member);
                    usf.setVisible(true);
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Sorry the id not available try different one!!","Error need unique id ",JOptionPane.ERROR_MESSAGE);
                jTextFieldID.requestFocus();
            }
        }else if(isAvailable(jTextFieldID.getText())){
            try{
                insertData(jTextFieldID.getText(),jTextFieldName.getText(),jTextFieldReference.getText());
                JFrameHome home = new JFrameHome();
                home.setVisible(true);
                this.dispose();
            }catch(Exception ex){
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Sorry the id not available try different one!!","Error need unique id ",JOptionPane.ERROR_MESSAGE);
            jTextFieldID.requestFocus();
        }
        
    }//GEN-LAST:event_jButtonSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelReference;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldReference;
    // End of variables declaration//GEN-END:variables
}