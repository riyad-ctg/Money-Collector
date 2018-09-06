package moneycollector.view;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import moneycollector.service.MemberDetail;

/**
 * This panel is created for show each of these transection by executes queries
 * @author RIYAD
 */
public class JPanelTransection extends javax.swing.JPanel {
    
    public static final int TABLE_TRANSECTION = 1;
    public static final int TABLE_OTHER = 2;
    public static final int TABLE_BANK = 3;
    
    
    private String dateTaken;
    private JFrameAllTransections parentFrame;
    private MemberDetail member;
    private int index;
    
    /**
     * Creates new form JPanelTransection
     * @param parentFrame   Parent Frame of this panel
     * @param date  Date of the transection
     * @param member MemberDetail of the member
     * @param tableType Is the index of table Transection = 1,Other = 2,Bank = 3
     */
    public JPanelTransection(JFrameAllTransections parentFrame,String date,MemberDetail member,int tableType) {
        initComponents();
        this.dateTaken = date;
        this.parentFrame = parentFrame;
        this.member = member;
        this.index = tableType;
        setTexts();
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
            switch(index){
                case 1:
                    stmt = c.prepareStatement("DELETE FROM TRANSECTIONS WHERE ID = ? AND AMOUNTRECEIVED = ?");
                    stmt.setString(1, member.getId());
                    break;
                case 2:
                    stmt = c.prepareStatement("DELETE FROM OTHER WHERE DEPOSITEDBY = ? AND DATEDEPOSITED = ?");
                    stmt.setString(1, member.getName());
                    break;
                default:
                    stmt = c.prepareStatement("DELETE FROM BANK WHERE DEPOSITEDBY = ? AND DATEDEPOSITED = ?");
                    stmt.setString(1, member.getName());
                    break;
            }
            stmt.setDate(2, getDate("dd/MMM/yyyy", dateTaken));
            stmt.executeUpdate();
            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(null, "Record successfully deleted", "Database Status", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Date getDate(String pattern,String date){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        java.util.Date dt = null;
        try {
            dt = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(JPanelTransection.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        return new Date(dt.getTime());
    }
    
    private void setTexts(){
        jLabelName.setText("NAME:" + member.getName());
        jLabelDate.setText("DATE:" + dateTaken);
        jLabelAmount.setText("" + member.getAmount());
        if(member.getId().length() != 0){
            this.setToolTipText("ID  " + member.getId());
        }
    }
    
    public void setDeleteButtonVisible(boolean flag){
        this.jButtonDelete.setVisible(flag);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelName = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jPanelAmountPanel = new javax.swing.JPanel();
        jLabelAmountTitle = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(10, 10, 10));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51)));

        jLabelName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("NAME:");

        jLabelDate.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDate.setText("DATE:");

        jPanelAmountPanel.setBackground(new java.awt.Color(0, 0, 51));

        jLabelAmountTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabelAmountTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAmountTitle.setText("AMOUNT");

        jLabelAmount.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabelAmount.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAmount.setText("0000000000");
        jLabelAmount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelAmountPanelLayout = new javax.swing.GroupLayout(jPanelAmountPanel);
        jPanelAmountPanel.setLayout(jPanelAmountPanelLayout);
        jPanelAmountPanelLayout.setHorizontalGroup(
            jPanelAmountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmountPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelAmountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAmount)
                    .addComponent(jLabelAmountTitle))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelAmountPanelLayout.setVerticalGroup(
            jPanelAmountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAmountTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAmount)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButtonDelete.setFont(new java.awt.Font("Yu Mincho", 0, 14)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAmountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDate)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelAmountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        int ret = JOptionPane.showConfirmDialog(null,"Are you sure to delete this transection from database??\n\nYou cannot undo later.","Are you sure??",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ret == 0){
            deleteData();
            parentFrame.loadData(parentFrame.getPreviewsQuery());
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelAmountTitle;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanelAmountPanel;
    // End of variables declaration//GEN-END:variables
}
