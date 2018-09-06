package moneycollector.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author RIYAD
 */
public class JFrameBussinessManagement extends javax.swing.JFrame {
    
    private int onScreenX,onScreenY;  //To move undecorated frame with mouse dragged
    
    /**
     * Creates new form JFrameHome
     */
    public JFrameBussinessManagement() {
        initComponents();
        setOnPerfectLocation();
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
        jPanelContants = new javax.swing.JPanel();

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

        jLabelTitle.setFont(new java.awt.Font("Yu Mincho Light", 1, 28)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitle.setText("Bussiness Management");

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
            .addGap(0, 391, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButtonMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClose))
            .addComponent(jPanelContants, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanelContants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        JFrameHome home = new JFrameHome();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jPanelContantsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContantsMouseExited
        
    }//GEN-LAST:event_jPanelContantsMouseExited

    private void jPanelContantsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelContantsMouseEntered
        
    }//GEN-LAST:event_jPanelContantsMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelContants;
    private javax.swing.JPanel jPanelMain;
    // End of variables declaration//GEN-END:variables
}