package moneycollector.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author RIYAD
 */
public class JFrameNewTransection extends javax.swing.JFrame {
    
    private int onScreenX,onScreenY;  //To move undecorated frame with mouse dragged
    private final String ids[];
    
    /**
     * Creates new form JFrameHome
     * @param TotalUsers total members in this database
     */
    public JFrameNewTransection(int TotalUsers) {
        initComponents();
        setOnPerfectLocation();
        ids = new String[TotalUsers];
        loadData();
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
        jTabbedPaneTransectionForm = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jSpinnerDate = new javax.swing.JSpinner();
        jLabelDate = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jLabelAmount = new javax.swing.JLabel();
        jComboBoxNames = new javax.swing.JComboBox();
        jLabelName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonSave1 = new javax.swing.JButton();
        jSpinnerDate1 = new javax.swing.JSpinner();
        jLabelDate1 = new javax.swing.JLabel();
        jTextFieldAmount1 = new javax.swing.JTextField();
        jLabelAmount1 = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButtonSave2 = new javax.swing.JButton();
        jSpinnerDate2 = new javax.swing.JSpinner();
        jLabelDate2 = new javax.swing.JLabel();
        jTextFieldAmount2 = new javax.swing.JTextField();
        jLabelAmount2 = new javax.swing.JLabel();
        jLabelName2 = new javax.swing.JLabel();
        jTextFieldName1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelMain.setBackground(new java.awt.Color(25, 25, 25));
        jPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 3));
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
        jLabelTitle.setText("NEW TRANSECTION");

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

        jTabbedPaneTransectionForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPaneTransectionForm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneTransectionFormStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        jButtonSave.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jButtonSave.setText("SAVE");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jSpinnerDate.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jSpinnerDate.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerDate.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerDate, "dd/MMM/yyyy"));

        jLabelDate.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDate.setText("DATE:");

        jTextFieldAmount.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextFieldAmount.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelAmount.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelAmount.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAmount.setText("AMOUNT:");

        jComboBoxNames.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jComboBoxNames.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select User..................." }));

        jLabelName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("NAME:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDate)
                            .addComponent(jLabelAmount)
                            .addComponent(jLabelName))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldAmount)
                                .addComponent(jComboBoxNames, 0, 344, Short.MAX_VALUE))
                            .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jComboBoxNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAmount))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate))
                .addGap(18, 18, 18)
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPaneTransectionForm.addTab("USER TRANSECTION", jPanel1);

        jPanel2.setBackground(new java.awt.Color(20, 20, 20));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        jButtonSave1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jButtonSave1.setText("SAVE");
        jButtonSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSave1ActionPerformed(evt);
            }
        });

        jSpinnerDate1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jSpinnerDate1.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerDate1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerDate1, "dd/MMM/yyyy"));

        jLabelDate1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelDate1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDate1.setText("DATE:");

        jTextFieldAmount1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextFieldAmount1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelAmount1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelAmount1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAmount1.setText("AMOUNT:");

        jLabelName1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelName1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName1.setText("DEPOSITED BY:");

        jTextFieldName.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextFieldName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDate1)
                            .addComponent(jLabelAmount1)
                            .addComponent(jLabelName1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAmount1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate1))
                .addGap(18, 18, 18)
                .addComponent(jButtonSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPaneTransectionForm.addTab("OTHER TRANSECTION", jPanel2);

        jPanel3.setBackground(new java.awt.Color(20, 20, 20));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        jButtonSave2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jButtonSave2.setText("SAVE");
        jButtonSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSave2ActionPerformed(evt);
            }
        });

        jSpinnerDate2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jSpinnerDate2.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerDate2.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerDate2, "dd/MMM/yyyy"));

        jLabelDate2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelDate2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDate2.setText("DATE:");

        jTextFieldAmount2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextFieldAmount2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabelAmount2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelAmount2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAmount2.setText("AMOUNT:");

        jLabelName2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabelName2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName2.setText("DEPOSITED BY:");

        jTextFieldName1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jTextFieldName1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelDate2)
                            .addComponent(jLabelAmount2)
                            .addComponent(jLabelName2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldName1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName2)
                    .addComponent(jTextFieldName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAmount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAmount2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDate2))
                .addGap(18, 18, 18)
                .addComponent(jButtonSave2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPaneTransectionForm.addTab("BANK TRANSECTION", jPanel3);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonMinimize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addContainerGap())))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jTabbedPaneTransectionForm, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneTransectionForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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
     * Loading database from a file
     */
    private void loadData() {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM USERS ORDER BY ID ASC")) {
                int count = 0;
                while (rs.next()) {
                    jComboBoxNames.addItem(rs.getString("NAME") + "    Ref:" + rs.getString("REFERENCE"));
                    ids[count++] = rs.getString("ID");
                }
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    
    /**
     * Inserting data to the desired database
     */
    private void insertData(String id,int amount,Date dt) {
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.prepareStatement("INSERT INTO TRANSECTIONS (ID,AMOUNT,AMOUNTRECEIVED)"
                    + "VALUES (?,?,?)");
            stmt.setString(1, id);
            stmt.setInt(2, amount);
            stmt.setDate(3, dt);

            stmt.executeUpdate();
            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(null, "Record successfully inserted", "Database Status", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR:A member should not have two transections in the same date.Please insert in another day or Edit the transection of this day.", "Database error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
    
    private void insertDepositorData(Date dt,String name,int amount,String tableName){
        Connection c;
        PreparedStatement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.prepareStatement("INSERT INTO " + tableName + " (DATEDEPOSITED,DEPOSITEDBY,AMOUNT) "
                    + "VALUES (?,?,?)");
            stmt.setDate(1, dt);
            stmt.setString(2, name);
            stmt.setInt(3, amount);

            stmt.executeUpdate();
            stmt.close();
            c.close();
            JOptionPane.showMessageDialog(null, "Record successfully inserted", "Database Status", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERROR:A member should not have two transections in the same date.Please insert in another day or Edit the transection of this day.", "Database error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
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
    }//GEN-LAST:event_jPanelMainMousePressed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        //When Click the X button
        JFrameHome home = new JFrameHome();
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

    private void jButtonSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSave1ActionPerformed
        //--------------- Date Validation steps --------------------//
        if(jTextFieldName.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please input a depositor name","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldName.requestFocus();
            return;
        }
        if(jTextFieldAmount1.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please fill up Amount","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldAmount1.requestFocus();
            return;
        }
        int amount;
        
        try{
            jTextFieldAmount1.setText(jTextFieldAmount1.getText().trim());
            amount = Integer.parseInt(jTextFieldAmount1.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Somthing Went Wrong With your given amount.Input it again!!","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldAmount1.setText("");
            jTextFieldAmount1.requestFocus();
            return;
        }
        
        // -------------------- End Data Validation ---------------\\

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sqlDate = new Date(sdf.parse(sdf.format(jSpinnerDate1.getValue())).getTime());
            insertDepositorData(sqlDate,jTextFieldName.getText(), amount,"OTHER");
            JFrameHome home = new JFrameHome();
            this.dispose();
            home.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(JFrameNewTransection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonSave1ActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed

        //---------------- Data Validation steps --------------------//

        if(jComboBoxNames.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(rootPane,"Please select a User Name","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jComboBoxNames.showPopup();
            jComboBoxNames.requestFocus();
            return;
        }else if(jTextFieldAmount.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please fill up Amount","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldAmount.requestFocus();
            return;
        }

        int amount;

        try{
            jTextFieldAmount.setText(jTextFieldAmount.getText().trim());
            amount = Integer.parseInt(jTextFieldAmount.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Somthing Went Wrong With your given amount.Input it again!!","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldAmount.setText("");
            jTextFieldAmount.requestFocus();
            return;
        }

        // -------------------- End Data Validation ---------------\\

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sqlDate = new Date(sdf.parse(sdf.format(jSpinnerDate.getValue())).getTime());
            insertData(ids[jComboBoxNames.getSelectedIndex()-1], amount, sqlDate);
            JFrameHome home = new JFrameHome();
            this.dispose();
            home.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(JFrameNewTransection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    
    private void jButtonSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSave2ActionPerformed
        //--------------- Date Validation steps --------------------//
        if(jTextFieldName1.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please input a depositor name","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldName1.requestFocus();
            return;
        }
        if(jTextFieldAmount2.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"Please fill up Amount","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldAmount2.requestFocus();
            return;
        }
        int amount;
        
        try{
            jTextFieldAmount2.setText(jTextFieldAmount2.getText().trim());
            amount = Integer.parseInt(jTextFieldAmount2.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,"Somthing Went Wrong With your given amount.Input it again!!","Error Cannot Save..",JOptionPane.ERROR_MESSAGE);
            jTextFieldAmount2.setText("");
            jTextFieldAmount2.requestFocus();
            return;
        }
        
        // -------------------- End Data Validation ---------------\\

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sqlDate = new Date(sdf.parse(sdf.format(jSpinnerDate2.getValue())).getTime());
            insertDepositorData(sqlDate,jTextFieldName1.getText(), amount,"BANK");
            JFrameHome home = new JFrameHome();
            this.dispose();
            home.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(JFrameNewTransection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSave2ActionPerformed

    private void jTabbedPaneTransectionFormStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneTransectionFormStateChanged
        switch(jTabbedPaneTransectionForm.getSelectedIndex()){
            case 0:
                jLabelTitle.setText("USER TRANSECTION");
                break;
            case 1:
                jLabelTitle.setText("OTHER TRANSECTION");
                break;
            case 2:
                jLabelTitle.setText("BANK TRANSECTION");
                break;
        }
    }//GEN-LAST:event_jTabbedPaneTransectionFormStateChanged

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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSave1;
    private javax.swing.JButton jButtonSave2;
    private javax.swing.JComboBox jComboBoxNames;
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelAmount1;
    private javax.swing.JLabel jLabelAmount2;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDate1;
    private javax.swing.JLabel jLabelDate2;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JLabel jLabelName2;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JSpinner jSpinnerDate;
    private javax.swing.JSpinner jSpinnerDate1;
    private javax.swing.JSpinner jSpinnerDate2;
    private javax.swing.JTabbedPane jTabbedPaneTransectionForm;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldAmount1;
    private javax.swing.JTextField jTextFieldAmount2;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldName1;
    // End of variables declaration//GEN-END:variables
}