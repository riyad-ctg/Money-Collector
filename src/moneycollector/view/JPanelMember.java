package moneycollector.view;
import java.awt.Color;
import moneycollector.service.MemberDetail;

/**
 *
 * @author RIYAD
 */
public class JPanelMember extends javax.swing.JPanel {
    
    private JFrameHome home;
    private MemberDetail member;
    
    /**
     * Creates new form JPanelMember
     * @param parent Parent frame of this panel
     * @param no The number which maintained in order
     * @param member MemberDetail of a member
     */
    public JPanelMember(JFrameHome parent,int no,MemberDetail member) {
        initComponents();
        home = parent;
        this.member = member;
        this.setToolTipText("REFERENCE:  " + member.getRef());
        setThings(no);
    }
    
    private void setThings(int no){
        this.jLabelNo.setText((no-1) + ".");
        this.jLabelName.setText(member.getName());
        this.jLabelID.setText(member.getId());
        this.jLabelAmount.setText(member.getAmount() + "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNo = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();

        setBackground(new java.awt.Color(35, 35, 35));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        jLabelNo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelNo.setForeground(new java.awt.Color(255, 255, 0));
        jLabelNo.setText("1.");

        jLabelName.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 0));
        jLabelName.setText("Masud");

        jLabelAmount.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelAmount.setForeground(new java.awt.Color(255, 255, 0));
        jLabelAmount.setText("Amount:");

        jLabelID.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 0));
        jLabelID.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabelAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelNo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
            .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setBackground(Color.black);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setBackground(new Color(35,35,35));
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        JFrameUserProfile usf = new JFrameUserProfile(member);
        usf.setVisible(true);
        home.dispose();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNo;
    // End of variables declaration//GEN-END:variables
}
