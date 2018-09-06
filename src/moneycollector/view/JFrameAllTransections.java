package moneycollector.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import moneycollector.service.MemberDetail;

/**
 *
 * @author RIYAD
 */
public final class JFrameAllTransections extends javax.swing.JFrame {
    
    private int onScreenX,onScreenY;  //To move undecorated frame with mouse dragged
    private int componetsInPanel = 1;
    private MemberDetail tempMember;
    private String previewsQuery,orderOn = "AMOUNTRECEIVED";
    private final String ids[];
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int countedMoney;
    
    /**
     * Creates new form JFrameHome
     * @param totalUsers
     */
    public JFrameAllTransections(int totalUsers) {
        initComponents();
        setOnPerfectLocation();
        ids = new String[totalUsers];
        loadData();
        loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY AMOUNTRECEIVED DESC");
    }
    
    /**
     * Set the previews query.
     * After delete data previews query should be called for its refreshment.
     * @return
     */
    public String getPreviewsQuery(){
        return previewsQuery;
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

        buttonGroupDateNameID = new javax.swing.ButtonGroup();
        buttonGroupAscDsc = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelMain = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jScrollPaneAllTransections = new javax.swing.JScrollPane();
        jPanelAllTransections = new javax.swing.JPanel();
        jCheckBoxShowDelete = new javax.swing.JCheckBox();
        jPanelOrderBy = new javax.swing.JPanel();
        jRadioButtonName = new javax.swing.JRadioButton();
        jRadioButtonID = new javax.swing.JRadioButton();
        jRadioButtonDate = new javax.swing.JRadioButton();
        jRadioButtonAsc = new javax.swing.JRadioButton();
        jRadioButtonDSC = new javax.swing.JRadioButton();
        jComboBoxUserList = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonUsers = new javax.swing.JRadioButton();
        jRadioButtonOther = new javax.swing.JRadioButton();
        jRadioButtonBank = new javax.swing.JRadioButton();
        jLabelShowingTransectionsFor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelShowingDateBetween = new javax.swing.JLabel();
        jSpinnerFirstDate = new javax.swing.JSpinner();
        jSpinnerSecondDate = new javax.swing.JSpinner();
        jLabelCollected = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelMain.setBackground(new java.awt.Color(30, 30, 30));
        jPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51), 3));
        jPanelMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelMainMouseDragged(evt);
            }
        });
        jPanelMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMainMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMainMousePressed(evt);
            }
        });

        jLabelTitle.setFont(new java.awt.Font("Yu Mincho Demibold", 0, 34)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitle.setText("ALL TRANSECTIONS");

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

        jScrollPaneAllTransections.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneAllTransections.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelAllTransections.setBackground(new java.awt.Color(51, 51, 51));
        jPanelAllTransections.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPaneAllTransections.setViewportView(jPanelAllTransections);

        jCheckBoxShowDelete.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jCheckBoxShowDelete.setForeground(new java.awt.Color(255, 255, 153));
        jCheckBoxShowDelete.setText("Show Delete Buttons");
        jCheckBoxShowDelete.setOpaque(false);
        jCheckBoxShowDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxShowDeleteActionPerformed(evt);
            }
        });

        jPanelOrderBy.setBackground(new java.awt.Color(0, 0, 0));
        jPanelOrderBy.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Order By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanelOrderBy.setOpaque(false);
        jPanelOrderBy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelOrderByMouseClicked(evt);
            }
        });

        buttonGroupDateNameID.add(jRadioButtonName);
        jRadioButtonName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonName.setForeground(new java.awt.Color(102, 255, 255));
        jRadioButtonName.setText("NAME");
        jRadioButtonName.setOpaque(false);
        jRadioButtonName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonNameItemStateChanged(evt);
            }
        });

        buttonGroupDateNameID.add(jRadioButtonID);
        jRadioButtonID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonID.setForeground(new java.awt.Color(102, 255, 255));
        jRadioButtonID.setText("ID");
        jRadioButtonID.setOpaque(false);
        jRadioButtonID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonIDItemStateChanged(evt);
            }
        });

        buttonGroupDateNameID.add(jRadioButtonDate);
        jRadioButtonDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonDate.setForeground(new java.awt.Color(102, 255, 255));
        jRadioButtonDate.setSelected(true);
        jRadioButtonDate.setText("DATE");
        jRadioButtonDate.setOpaque(false);
        jRadioButtonDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonDateItemStateChanged(evt);
            }
        });

        buttonGroupAscDsc.add(jRadioButtonAsc);
        jRadioButtonAsc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonAsc.setForeground(new java.awt.Color(102, 255, 255));
        jRadioButtonAsc.setText("ASCENDING");
        jRadioButtonAsc.setOpaque(false);
        jRadioButtonAsc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonAscItemStateChanged(evt);
            }
        });

        buttonGroupAscDsc.add(jRadioButtonDSC);
        jRadioButtonDSC.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButtonDSC.setForeground(new java.awt.Color(102, 255, 255));
        jRadioButtonDSC.setSelected(true);
        jRadioButtonDSC.setText("DESCENDING");
        jRadioButtonDSC.setOpaque(false);
        jRadioButtonDSC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonDSCItemStateChanged(evt);
            }
        });

        jComboBoxUserList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxUserList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL" }));
        jComboBoxUserList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOrderByLayout = new javax.swing.GroupLayout(jPanelOrderBy);
        jPanelOrderBy.setLayout(jPanelOrderByLayout);
        jPanelOrderByLayout.setHorizontalGroup(
            jPanelOrderByLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBoxUserList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelOrderByLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOrderByLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonDSC)
                    .addComponent(jRadioButtonAsc)
                    .addGroup(jPanelOrderByLayout.createSequentialGroup()
                        .addComponent(jRadioButtonDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonID)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOrderByLayout.setVerticalGroup(
            jPanelOrderByLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderByLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxUserList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelOrderByLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonDate)
                    .addComponent(jRadioButtonName)
                    .addComponent(jRadioButtonID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jRadioButtonAsc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonDSC)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        buttonGroup1.add(jRadioButtonUsers);
        jRadioButtonUsers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonUsers.setForeground(new java.awt.Color(153, 255, 51));
        jRadioButtonUsers.setSelected(true);
        jRadioButtonUsers.setText("USERS");
        jRadioButtonUsers.setOpaque(false);
        jRadioButtonUsers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonUsersItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonOther);
        jRadioButtonOther.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonOther.setForeground(new java.awt.Color(153, 255, 51));
        jRadioButtonOther.setText("Other");
        jRadioButtonOther.setOpaque(false);
        jRadioButtonOther.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonOtherItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonBank);
        jRadioButtonBank.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButtonBank.setForeground(new java.awt.Color(153, 255, 51));
        jRadioButtonBank.setText("Bank");
        jRadioButtonBank.setOpaque(false);
        jRadioButtonBank.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonBankItemStateChanged(evt);
            }
        });

        jLabelShowingTransectionsFor.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelShowingTransectionsFor.setForeground(new java.awt.Color(255, 255, 102));
        jLabelShowingTransectionsFor.setText("Showing Transections For");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonUsers)
                    .addComponent(jRadioButtonOther)
                    .addComponent(jRadioButtonBank))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabelShowingTransectionsFor)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelShowingTransectionsFor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonUsers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonOther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonBank)
                .addGap(24, 24, 24))
        );

        jPanel2.setBackground(new java.awt.Color(15, 15, 30));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 0)));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabelShowingDateBetween.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelShowingDateBetween.setForeground(new java.awt.Color(255, 255, 102));
        jLabelShowingDateBetween.setText("Showing Result Between");

        jSpinnerFirstDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinnerFirstDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1471456800000L), null, null, java.util.Calendar.DAY_OF_MONTH));
        jSpinnerFirstDate.setAutoscrolls(true);
        jSpinnerFirstDate.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerFirstDate, "dd-MM-yyyy"));
        jSpinnerFirstDate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerFirstDateStateChanged(evt);
            }
        });

        jSpinnerSecondDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSpinnerSecondDate.setModel(new javax.swing.SpinnerDateModel());
        jSpinnerSecondDate.setEditor(new javax.swing.JSpinner.DateEditor(jSpinnerSecondDate, "dd-MM-yyyy"));
        jSpinnerSecondDate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSecondDateStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerSecondDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabelShowingDateBetween)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelShowingDateBetween)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinnerFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinnerSecondDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabelCollected.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabelCollected.setForeground(new java.awt.Color(255, 204, 204));
        jLabelCollected.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCollected.setText("Collected");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jLabelCollected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMinimize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneAllTransections, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxShowDelete))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelOrderBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonClose)
                                .addComponent(jButtonMinimize))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelCollected)
                .addGap(18, 18, 18)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jCheckBoxShowDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneAllTransections, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelOrderBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    
    /**
     * Loading database from a file
     * @param query query of the result
     */
    public void loadData(String query) {
        componetsInPanel = 1;
        this.jPanelAllTransections.removeAll();
        
        Connection c;
        Statement stmt;
        String date;
        countedMoney = 0;
        DateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");
            previewsQuery = query;
            query = "SELECT * FROM ("+previewsQuery+") WHERE strftime('%Y-%m-%d',AMOUNTRECEIVED/1000,'unixepoch') BETWEEN '"+sdf.format((java.util.Date)jSpinnerFirstDate.getValue())+"' AND '"+sdf.format((java.util.Date)jSpinnerSecondDate.getValue())+"'";
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) { 
                    date = format.format(sdf.parse(rs.getDate("AMOUNTRECEIVED").toString()));
                    countedMoney+=rs.getInt("AMOUNT");
                    if(jRadioButtonUsers.isSelected()){
                        tempMember = new MemberDetail(rs.getString("NAME"), rs.getString("ID"), rs.getString("REFERENCE"), rs.getInt("AMOUNT"));
                        updateTransectionPanel(new JPanelTransection(this,date,tempMember,JPanelTransection.TABLE_TRANSECTION));
                    }else if(jRadioButtonOther.isSelected()){
                        tempMember = new MemberDetail(rs.getString("NAME"),"","",rs.getInt("AMOUNT"));
                        updateTransectionPanel(new JPanelTransection(this,date,tempMember,JPanelTransection.TABLE_OTHER));
                    }else{
                        tempMember = new MemberDetail(rs.getString("NAME"),"","",rs.getInt("AMOUNT"));
                        updateTransectionPanel(new JPanelTransection(this,date,tempMember,JPanelTransection.TABLE_BANK));
                    }
                }
                if(componetsInPanel == 1)   updateTransectionPanel();
            }
            if(jRadioButtonUsers.isSelected()){
                this.jLabelCollected.setText("Collected " + countedMoney + " tk From " + jComboBoxUserList.getSelectedItem() + " between " + format.format((java.util.Date)jSpinnerFirstDate.getValue()) + " to " + format.format((java.util.Date)jSpinnerSecondDate.getValue()));
            }else if(jRadioButtonOther.isSelected()){
                this.jLabelCollected.setText("Collected " + countedMoney + " tk for Other between " + format.format((java.util.Date)jSpinnerFirstDate.getValue()) + " to " + format.format((java.util.Date)jSpinnerSecondDate.getValue()));
            }else{
                this.jLabelCollected.setText("Deposited " + countedMoney + " tk to bank account between " + format.format((java.util.Date)jSpinnerFirstDate.getValue()) + " to " + format.format((java.util.Date)jSpinnerSecondDate.getValue()));
            }
            
            stmt.close();
            showDeleteButtons(this.jCheckBoxShowDelete.isSelected());
        } catch (ClassNotFoundException | SQLException | ParseException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Overloaded method
     * Loading database from a file
     */
    void loadData() {
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Renaissanse.rns");

            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT NAME,ID FROM USERS ORDER BY NAME ASC")) {
                int count = 0;
                while (rs.next()) {
                    ids[count++] = rs.getString("ID");
                    this.jComboBoxUserList.addItem(rs.getString("NAME"));
                }
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
   
    /**
     * When the show delete buttons check box clicked
     * @param flag is Need to show delete buttons
     */
    private void showDeleteButtons(boolean flag){
        for(Component jpt:this.jPanelAllTransections.getComponents()){
            ((JPanelTransection)jpt).setDeleteButtonVisible(flag);
        }
    }
   
    private void updateTransectionPanel(JPanelTransection trans){
        jPanelAllTransections.setPreferredSize(new Dimension(400,73*componetsInPanel));
        jScrollPaneAllTransections.setPreferredSize(new Dimension(400,73*componetsInPanel));
        jPanelAllTransections.add(trans);
        jPanelAllTransections.repaint();
        jPanelAllTransections.revalidate();
        componetsInPanel++;
    }
    
    private void updateTransectionPanel(){
        jPanelAllTransections.setPreferredSize(new Dimension(400,73*componetsInPanel));
        jScrollPaneAllTransections.setPreferredSize(new Dimension(400,73*componetsInPanel));
        jPanelAllTransections.repaint();
        jPanelAllTransections.revalidate();
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

    private void jCheckBoxShowDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxShowDeleteActionPerformed
        //When the show delete button clicked
        showDeleteButtons(jCheckBoxShowDelete.isSelected());
    }//GEN-LAST:event_jCheckBoxShowDeleteActionPerformed

    private void jComboBoxUserListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserListActionPerformed
        if(jComboBoxUserList.getSelectedIndex() == 0){
            jRadioButtonName.setEnabled(true);
            jRadioButtonID.setEnabled(true);
            loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                    " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY AMOUNTRECEIVED " + ((jRadioButtonAsc.isSelected())?"ASC":"DESC"));
        }else{
            jRadioButtonDate.setSelected(true);
            jRadioButtonName.setEnabled(false);
            jRadioButtonID.setEnabled(false);
            loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                    " WHERE USERS.ID = TRANSECTIONS.ID AND USERS.ID = \'" + ids[jComboBoxUserList.getSelectedIndex()-1] +  
                    "\' ORDER BY AMOUNTRECEIVED " + ((jRadioButtonAsc.isSelected())?"ASC":"DESC"));
        }
    }//GEN-LAST:event_jComboBoxUserListActionPerformed

    private void jRadioButtonDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonDateItemStateChanged
        if(jRadioButtonDate.isSelected()){
            orderOn = "AMOUNTRECEIVED";
            loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                    " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY AMOUNTRECEIVED " + ((jRadioButtonAsc.isSelected())?"ASC":"DESC"));
        }
    }//GEN-LAST:event_jRadioButtonDateItemStateChanged

    private void jRadioButtonNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonNameItemStateChanged
        if(jRadioButtonName.isSelected()){
            orderOn = "NAME";
            loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                    " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY NAME " + ((jRadioButtonAsc.isSelected())?"ASC":"DESC"));
        }
    }//GEN-LAST:event_jRadioButtonNameItemStateChanged

    private void jRadioButtonIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonIDItemStateChanged
        if(jRadioButtonID.isSelected()){
            orderOn = "USERS.ID";
            loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                    " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY USERS.ID " + ((jRadioButtonAsc.isSelected())?"ASC":"DESC"));
        }
    }//GEN-LAST:event_jRadioButtonIDItemStateChanged

    private void jRadioButtonAscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonAscItemStateChanged
        if(jRadioButtonAsc.isSelected()){
            if(jRadioButtonUsers.isSelected()){
                if(this.jComboBoxUserList.getSelectedIndex() == 0){
                loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                        " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY " + orderOn + " ASC");
                }else{
                    loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                            " WHERE USERS.ID = TRANSECTIONS.ID AND USERS.ID = \'" + ids[jComboBoxUserList.getSelectedIndex()-1] +  
                            "\' ORDER BY AMOUNTRECEIVED ASC");
                }
            }else if(jRadioButtonOther.isSelected()){
                loadData("SELECT DATEDEPOSITED AS AMOUNTRECEIVED,DEPOSITEDBY AS NAME,AMOUNT FROM OTHER ORDER BY AMOUNTRECEIVED ASC");
            }else{
                loadData("SELECT DATEDEPOSITED AS AMOUNTRECEIVED,DEPOSITEDBY AS NAME,AMOUNT FROM BANK ORDER BY AMOUNTRECEIVED ASC");
            }
        }
    }//GEN-LAST:event_jRadioButtonAscItemStateChanged

    private void jRadioButtonDSCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonDSCItemStateChanged
        if(jRadioButtonDSC.isSelected()){
            if(jRadioButtonUsers.isSelected()){
                if(this.jComboBoxUserList.getSelectedIndex() == 0){
                loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                        " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY " + orderOn + " DESC");
                }else{
                    loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                            " WHERE USERS.ID = TRANSECTIONS.ID AND USERS.ID = \'" + ids[jComboBoxUserList.getSelectedIndex()-1] +  
                            "\' ORDER BY AMOUNTRECEIVED DESC");
                }
            }else if(jRadioButtonOther.isSelected()){
                loadData("SELECT DATEDEPOSITED AS AMOUNTRECEIVED,DEPOSITEDBY AS NAME,AMOUNT FROM OTHER ORDER BY AMOUNTRECEIVED DESC");
            }else{
                loadData("SELECT DATEDEPOSITED AS AMOUNTRECEIVED,DEPOSITEDBY AS NAME,AMOUNT FROM BANK ORDER BY AMOUNTRECEIVED DESC");
            }
        }
    }//GEN-LAST:event_jRadioButtonDSCItemStateChanged

    private void jRadioButtonOtherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonOtherItemStateChanged
        if(jRadioButtonOther.isSelected()){
            jComboBoxUserList.setEnabled(false);
            jRadioButtonName.setEnabled(false);
            jRadioButtonID.setEnabled(false);
            jRadioButtonDate.setSelected(true);
            loadData("SELECT DATEDEPOSITED AS AMOUNTRECEIVED,DEPOSITEDBY AS NAME,AMOUNT FROM OTHER ORDER BY AMOUNTRECEIVED " + ((jRadioButtonAsc.isSelected())?"ASC":"DESC"));
        }
    }//GEN-LAST:event_jRadioButtonOtherItemStateChanged

    private void jRadioButtonBankItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonBankItemStateChanged
        if(jRadioButtonBank.isSelected()){
            jComboBoxUserList.setEnabled(false);
            jRadioButtonName.setEnabled(false);
            jRadioButtonID.setEnabled(false);
            jRadioButtonDate.setSelected(true);
            loadData("SELECT DATEDEPOSITED AS AMOUNTRECEIVED,DEPOSITEDBY AS NAME,AMOUNT FROM BANK ORDER BY AMOUNTRECEIVED " + ((jRadioButtonAsc.isSelected())?"ASC":"DESC"));
        }
    }//GEN-LAST:event_jRadioButtonBankItemStateChanged

    private void jRadioButtonUsersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonUsersItemStateChanged
        if(jRadioButtonUsers.isSelected()){
            jLabelTitle.setText("USERS TRANSECTIONS");
            jComboBoxUserList.setEnabled(true);
            jRadioButtonName.setEnabled(true);
            jRadioButtonID.setEnabled(true);
            if(this.jComboBoxUserList.getSelectedIndex() == 0){
                loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                        " WHERE USERS.ID = TRANSECTIONS.ID ORDER BY " + orderOn + ((jRadioButtonAsc.isSelected())?" ASC":" DESC"));
            }else{
                loadData("SELECT USERS.ID,NAME,AMOUNT,AMOUNTRECEIVED,REFERENCE FROM USERS,TRANSECTIONS " + 
                        " WHERE USERS.ID = TRANSECTIONS.ID AND USERS.ID = \'" + ids[jComboBoxUserList.getSelectedIndex()-1] +  
                        "\' ORDER BY AMOUNTRECEIVED " + ((jRadioButtonAsc.isSelected())?" ASC":" DESC"));
            }
        }
    }//GEN-LAST:event_jRadioButtonUsersItemStateChanged

    private void jSpinnerFirstDateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerFirstDateStateChanged
        loadData(previewsQuery);
    }//GEN-LAST:event_jSpinnerFirstDateStateChanged

    private void jSpinnerSecondDateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerSecondDateStateChanged
        loadData(previewsQuery);
    }//GEN-LAST:event_jSpinnerSecondDateStateChanged

    private void jPanelMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMainMouseClicked
        this.requestFocus();
    }//GEN-LAST:event_jPanelMainMouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        this.requestFocus();
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanelOrderByMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelOrderByMouseClicked
        this.requestFocus();
    }//GEN-LAST:event_jPanelOrderByMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroupAscDsc;
    private javax.swing.ButtonGroup buttonGroupDateNameID;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JCheckBox jCheckBoxShowDelete;
    private javax.swing.JComboBox jComboBoxUserList;
    private javax.swing.JLabel jLabelCollected;
    private javax.swing.JLabel jLabelShowingDateBetween;
    private javax.swing.JLabel jLabelShowingTransectionsFor;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAllTransections;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelOrderBy;
    private javax.swing.JRadioButton jRadioButtonAsc;
    private javax.swing.JRadioButton jRadioButtonBank;
    private javax.swing.JRadioButton jRadioButtonDSC;
    private javax.swing.JRadioButton jRadioButtonDate;
    private javax.swing.JRadioButton jRadioButtonID;
    private javax.swing.JRadioButton jRadioButtonName;
    private javax.swing.JRadioButton jRadioButtonOther;
    private javax.swing.JRadioButton jRadioButtonUsers;
    private javax.swing.JScrollPane jScrollPaneAllTransections;
    private javax.swing.JSpinner jSpinnerFirstDate;
    private javax.swing.JSpinner jSpinnerSecondDate;
    // End of variables declaration//GEN-END:variables
}