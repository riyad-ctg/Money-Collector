package moneycollector;

import moneycollector.view.JFrameHome;

public class Main {
    public static void main(String[] args) {
        //Calling The Home Frame
        //This is How We Show A Frame
        //We chosed jFrame theme nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            JFrameHome home = new JFrameHome();
            home.setVisible(true);
            home.setResizable(false);
        });
    }
}