/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import lamhdt.dtos.*;
import lamhdt.model.*;
import lamhdt.util.DigitalWatch;
import lamhdt.valid.MyValidation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author HL
 */
public class UI extends javax.swing.JFrame {

    private static final Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static int idUser;
    private static javax.swing.JLabel lbHours;
    private static javax.swing.JLabel lbMinutes;
    private static javax.swing.JLabel lbNoti;
    private static javax.swing.JLabel lbSeconds;
    Graphics imgActorGraphics, imgEquipmentGraphics;
    private int permission, offsetX, offsetY, cRole, cFilmHistory, cShootingSchedule;
    private int statusNewTribulation, statusNewActor, statusNewEquipment, statusNewRole;
    private CardLayout navCardLayout, cardTribulation, cardLRole;
    private DefaultTableModel tblModelTribulation, tblModelUsedEquipment, tblModelUsedRole, tblModelActor, tblModelEquipment, tblModelRole, tblModelCastRoleSelect;
    private DefaultTableModel tblModelCastToRole, tblModelStatisticsEquipment, tblModelRoleContent, tblModelFilmedHistory, tblModelShootingSchedule;
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private JFileChooser fchooserActor, fchooserEquipment = null, fchooser;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "GIF", "JPG", "JPEG", "PNG");
    private FileNameExtensionFilter download = new FileNameExtensionFilter("Role Content", "TXT");
    private BufferedImage img = null;
    private String username;
    private String password;
    private UserDTO userDTO = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CActor;
    private javax.swing.JPanel CEquipment;
    private javax.swing.JPanel CFilmHistory;
    private javax.swing.JPanel CRole;
    private javax.swing.JPanel CRoleContent;
    private javax.swing.JPanel CShootingSchedule;
    private javax.swing.JPanel CTribulation;
    private javax.swing.JPanel ContainerStatiticNav;
    private javax.swing.JPanel NavStatistic;
    private javax.swing.JPanel Wellcome;
    private javax.swing.JPanel accountActor;
    private javax.swing.JPanel adminSN;
    private javax.swing.JLabel btnActorOpenImg;
    private javax.swing.JButton btnAddUsedEquipment;
    private javax.swing.JButton btnAddUsedRole;
    private javax.swing.JButton btnClearEndDate;
    private javax.swing.JButton btnClearStartDate;
    private javax.swing.JButton btnCreateActor;
    private javax.swing.JButton btnCreateEquipment;
    private javax.swing.JButton btnCreateRole;
    private javax.swing.JButton btnCreateTribulation;
    private javax.swing.JButton btnDeleteActor;
    private javax.swing.JButton btnDeleteCastRole;
    private javax.swing.JButton btnDeleteEquipment;
    private javax.swing.JButton btnDeleteRole;
    private javax.swing.JButton btnDeleteTribulation;
    private javax.swing.JButton btnDeleteUsedEquipment;
    private javax.swing.JButton btnDeleteUsedRole;
    private javax.swing.JButton btnDownload;
    private javax.swing.JLabel btnEditAccount;
    private javax.swing.JLabel btnEditInfo;
    private javax.swing.JLabel btnEquipmentOpenImg;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JButton btnNewActor;
    private javax.swing.JButton btnNewEquipment;
    private javax.swing.JButton btnNewRole;
    private javax.swing.JButton btnNewTribulation;
    private javax.swing.JButton btnSearchActor;
    private javax.swing.JButton btnSearchCastRole;
    private javax.swing.JButton btnSearchEquipment;
    private javax.swing.JButton btnSearchRole;
    private javax.swing.JButton btnSearchTribulation;
    private javax.swing.JButton btnSearchUsedEquipment;
    private javax.swing.JButton btnSearchUsedRole;
    private javax.swing.JButton btnShowEquipmentByTID;
    private javax.swing.JButton btnShowRoleByTID;
    private javax.swing.JButton btnUpdateActor;
    private javax.swing.JButton btnUpdateCastRole;
    private javax.swing.JButton btnUpdateEquipment;
    private javax.swing.JButton btnUpdateRole;
    private javax.swing.JButton btnUpdateTribulation;
    private javax.swing.JPanel cardDashBoard;
    private javax.swing.JPanel cardFilmedHistory;
    private javax.swing.JPanel cardListTribulation;
    private javax.swing.JPanel cardMnActor;
    private javax.swing.JPanel cardMnEquipment;
    private javax.swing.JPanel cardMnTribulation;
    private javax.swing.JPanel cardRole;
    private javax.swing.JPanel cardRoleContent;
    private javax.swing.JPanel cardShootingSchedule;
    private javax.swing.JPanel cardStatisticEquipment;
    private javax.swing.JPanel cardUsedEquip;
    private javax.swing.JPanel cardUsedRole;
    private javax.swing.JPanel castToRole;
    private javax.swing.JComboBox<String> cbSelectStatus;
    private javax.swing.JPanel containerActor;
    private javax.swing.JPanel containerDashboard;
    private javax.swing.JPanel containerEquipment;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel containerRole;
    private javax.swing.JPanel containerRoleChoose;
    private javax.swing.JPanel containerRoleDescription;
    private javax.swing.JPanel containerTblStatistics;
    private javax.swing.JPanel containerTime;
    private javax.swing.JPanel containerTribulation;
    private javax.swing.JPanel controllerCastToRole;
    private javax.swing.JPanel controllerDV;
    private javax.swing.JPanel controllerEquipment;
    private javax.swing.JPanel controllerRole;
    private javax.swing.JPanel controllerTribulation;
    private javax.swing.JPanel controllerTribulation1;
    private javax.swing.JPanel controllerTribulation2;
    private javax.swing.JPanel detailActor;
    private javax.swing.JPanel detailEquipment;
    private javax.swing.JPanel errorEndDate;
    private javax.swing.JPanel errorStartDate;
    private javax.swing.JPanel hours;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel iconMnActor;
    private javax.swing.JLabel iconMnTribulation;
    private javax.swing.JPanel imgActor;
    private javax.swing.JPanel imgActorView;
    private javax.swing.JPanel imgEquipment;
    private javax.swing.JPanel imgEquipmentView;
    private javax.swing.JPanel infoActor;
    private javax.swing.JPanel infoEquipment;
    private javax.swing.JPanel infoPanelTribulation;
    private javax.swing.JPanel infoRole;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel2324;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrolActor;
    private javax.swing.JScrollPane jScrolActor1;
    private javax.swing.JScrollPane jScrolTribulation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JScrollPane jScrollTribulationDescription;
    private javax.swing.JLabel lbCActor;
    private javax.swing.JLabel lbCEquipment;
    private javax.swing.JLabel lbCFilmHistory;
    private javax.swing.JLabel lbCRole;
    private javax.swing.JLabel lbCRoleContent;
    private javax.swing.JLabel lbCSchedule;
    private javax.swing.JLabel lbCTribulation;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEndDate;
    private javax.swing.JLabel lbEndDate1;
    private javax.swing.JLabel lbErrorED;
    private javax.swing.JLabel lbErrorSD;
    private javax.swing.JLabel lbNameActor;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel lbPlace;
    private javax.swing.JLabel lbStartDate;
    private javax.swing.JPanel lbTitle;
    private javax.swing.JLabel lbTitleHours;
    private javax.swing.JLabel lbTitleMinutes;
    private javax.swing.JLabel lbTitleSecond;
    private javax.swing.JLabel lbTribulationName;
    private javax.swing.JPanel listActor;
    private javax.swing.JPanel listEquipment;
    private javax.swing.JPanel listRole;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoTitle;
    private javax.swing.JPanel minutes;
    private javax.swing.JPanel moreInfo;
    private javax.swing.JPanel navDashBoard;
    private javax.swing.JPanel navFilmedHistory;
    private javax.swing.JPanel navLeft;
    private javax.swing.JPanel navLogout;
    private javax.swing.JPanel navManageActor;
    private javax.swing.JPanel navManageEquipment;
    private javax.swing.JPanel navManageRole;
    private javax.swing.JPanel navManageTribulation;
    private javax.swing.JPanel navRoleContent;
    private javax.swing.JPanel navShootingSchedule;
    private javax.swing.JPanel navStatisticsEquipment;
    private javax.swing.JPanel notification;
    private javax.swing.JPanel panelHistory;
    private javax.swing.JPanel panelInfoHistory;
    private javax.swing.JPanel panelInfoShooting;
    private javax.swing.JPanel panelShooting;
    private javax.swing.JPanel second;
    private javax.swing.JList<String> selectEquipment;
    private javax.swing.JPanel selectInfo;
    private javax.swing.JPanel selectInfo1;
    private javax.swing.JPanel selectInfoRole;
    private javax.swing.JSpinner selectQuantity;
    private javax.swing.JList<String> selectRole;
    private javax.swing.JList<String> selectRoleName;
    private javax.swing.JList<String> selectTribulation;
    private javax.swing.JList<String> selectTribulation1;
    private javax.swing.JLabel separete;
    private javax.swing.JPanel tabActor;
    private javax.swing.JPanel tabEquipment;
    private javax.swing.JPanel tabRole;
    private javax.swing.JPanel tabTribulation;
    private javax.swing.JPanel tabb1;
    private javax.swing.JPanel tabb3;
    private javax.swing.JPanel tabb4;
    private javax.swing.JPanel tabb5;
    private javax.swing.JPanel tabb6;
    private javax.swing.JPanel tabb7;
    private javax.swing.JPanel tabb8;
    private javax.swing.JPanel tblActor;
    private javax.swing.JTable tblActorView;
    private javax.swing.JTable tblCastRoleActorView;
    private javax.swing.JTable tblCastToRoleView;
    private javax.swing.JPanel tblEquipment;
    private javax.swing.JTable tblEquipmentView;
    private javax.swing.JTable tblHistoryTribulationView;
    private javax.swing.JTable tblListEquipmentView;
    private javax.swing.JPanel tblPanelCastToRole;
    private javax.swing.JPanel tblPanelUsedEquipment;
    private javax.swing.JPanel tblPanelUsedRole;
    private javax.swing.JTable tblRoleContentView;
    private javax.swing.JTable tblRoleView;
    private javax.swing.JTable tblShootingScheduleView;
    private javax.swing.JPanel tblTribulation;
    private javax.swing.JTable tblTribulationView;
    private javax.swing.JTable tblUsedEquimentView;
    private javax.swing.JTable tblUsedRoleView;
    private javax.swing.JPanel timePanel;
    private javax.swing.JPanel titleBar;
    private javax.swing.JPanel titleBarRight;
    private javax.swing.JLabel titleDashBoard;
    private javax.swing.JLabel titleFilmedHistory;
    private javax.swing.JPanel titleHours;
    private javax.swing.JLabel titleLogout;
    private javax.swing.JPanel titleMinutes;
    private javax.swing.JLabel titleMnActor;
    private javax.swing.JLabel titleMnEquipment;
    private javax.swing.JLabel titleMnRole;
    private javax.swing.JLabel titleRoleContent;
    private javax.swing.JPanel titleSecond;
    private javax.swing.JLabel titleShootingSchedule;
    private javax.swing.JLabel titleStatisticsEquipment;
    private javax.swing.JPanel titleTimeNow;
    private javax.swing.JLabel titleTribulation;
    private javax.swing.JPanel tribulationInfo;
    private javax.swing.JTextField txtActorContentName;
    private javax.swing.JTextArea txtActorDescription;
    private javax.swing.JTextField txtActorEmail;
    private javax.swing.JTextField txtActorName;
    private javax.swing.JTextField txtActorPathImg;
    private javax.swing.JTextField txtActorPhone;
    private javax.swing.JTextField txtActorURLImage;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextArea txtEquipmentDescription;
    private javax.swing.JTextField txtEquipmentName;
    private javax.swing.JTextField txtEquipmentPathImg;
    private javax.swing.JTextField txtEquipmentQuantity;
    private javax.swing.JTextField txtEquipmentURLImage;
    private javax.swing.JTextArea txtHDescription;
    private javax.swing.JTextField txtHEndDate;
    private javax.swing.JTextField txtHNumbaerOfShoot;
    private javax.swing.JTextField txtHPlace;
    private javax.swing.JTextField txtHStartDate;
    private javax.swing.JTextField txtHTribulationName;
    private javax.swing.JTextField txtNumOfShoot;
    private javax.swing.JTextField txtPathRoleContent;
    private javax.swing.JTextField txtPlace;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextArea txtRoleContentDescription;
    private javax.swing.JTextArea txtRoleDescription;
    private javax.swing.JLabel txtRoleUser;
    private javax.swing.JTextArea txtSDescription;
    private javax.swing.JTextField txtSEndDate;
    private javax.swing.JTextField txtSNumberOfShoot;
    private javax.swing.JTextField txtSPlace;
    private javax.swing.JTextField txtSStartDate;
    private javax.swing.JTextField txtSTribulationName;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JTextField txtStatisticEndDate;
    private javax.swing.JTextField txtStatisticStartDate;
    private javax.swing.JTextArea txtTribulationDescription;
    private javax.swing.JTextField txtTribulationName;
    private javax.swing.JPanel userSN;
    private javax.swing.JLabel wellcomeName;
    private javax.swing.JPanel wellcomePanel;
    public UI() {
        initComponents();
        MyInit(1);
    }
    public UI(int permission, String username, String password) {
        initComponents();
        btnEditInfo.setVisible(false);
        this.username = username;
        this.password = password;
        userDTO = new UserDTO(username, password, permission);
        switchUser(permission);
        MyInit(permission);
    }

    public static void showNoti() throws Exception {
        LogDAO logDAO = new LogDAO();
        lbNoti.setText(logDAO.getUnreadByID(idUser) + " NOTIFICATION");
    }

    public static void showTime(String time) {
        String[] data = time.split(":");
        lbHours.setText(data[0]);
        lbMinutes.setText(data[1]);
        lbSeconds.setText(data[2]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    private void setUnVisit() {
        // set BG Color
        JPanel[] pn = {navDashBoard, navManageTribulation, navManageActor, navManageEquipment, navManageRole, navStatisticsEquipment, navRoleContent, navShootingSchedule, navFilmedHistory};
        for (JPanel jPanel : pn) {
            jPanel.setBackground(new java.awt.Color(62, 62, 62));
        }
        // set Text Color
        JLabel[] label = {titleDashBoard, titleTribulation, titleMnActor, titleMnRole, titleStatisticsEquipment, titleMnEquipment, titleRoleContent, titleShootingSchedule, titleFilmedHistory};
        for (JLabel jLabel : label) {
            jLabel.setForeground(new java.awt.Color(184, 184, 184));
        }
    }

    private void switchUser(int permission) {
        if (permission != 1) {
            JPanel[] navAdmin = {navManageTribulation, navManageActor, navManageEquipment, navManageRole, navStatisticsEquipment, adminSN};
            for (JPanel navPanel : navAdmin) {
                navPanel.setVisible(false);
            }
            btnEditInfo.setVisible(true);
            try {
                ActorDAO actorDAO = new ActorDAO();
                idUser = actorDAO.getIDByUsername(username);
                if (!username.equals("admin"))
                    wellcomeName.setText(actorDAO.getNameByUsername(username));
                showNoti();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JPanel[] navUser = {navRoleContent, navShootingSchedule, navFilmedHistory, notification, userSN};
            for (JPanel navPanel : navUser) {
                navPanel.setVisible(false);
            }
            try {
                updateDashBoardADMIN();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initCollumn() {
        tblActorView.getColumnModel().getColumn(0).setMaxWidth(80);
        TableColumn tribulationID = tblTribulationView.getColumnModel().getColumn(0);
        TableColumn equipmentID = tblEquipmentView.getColumnModel().getColumn(0);
        TableColumn selectCastRole = tblCastRoleActorView.getColumnModel().getColumn(0);
        TableColumn tribulationHistory = tblHistoryTribulationView.getColumnModel().getColumn(0);
        TableColumn tribulationSchedule = tblShootingScheduleView.getColumnModel().getColumn(0);
        TableColumn[] col = {tribulationID, equipmentID, selectCastRole, tribulationHistory, tribulationSchedule};
        for (TableColumn tableColumn : col) {
            tableColumn.setMaxWidth(0);
            tableColumn.setMinWidth(0);
            tableColumn.setPreferredWidth(0);
        }
        jScrollPane13.getColumnHeader().setVisible(false);
        JTableHeader tblHeadTribulation = tblTribulationView.getTableHeader();
        JTableHeader tblHeadUsedEquip = tblUsedEquimentView.getTableHeader();
        JTableHeader tblHeadUsedRole = tblUsedRoleView.getTableHeader();
        JTableHeader tblHeadActor = tblActorView.getTableHeader();
        JTableHeader tblHeadEquipment = tblEquipmentView.getTableHeader();
        JTableHeader tblHeadListRole = tblRoleView.getTableHeader();
        JTableHeader tblHeadCastRole = tblCastToRoleView.getTableHeader();
        JTableHeader tblHeadListEquip = tblListEquipmentView.getTableHeader();
        JTableHeader tblHeadRoleContent = tblRoleContentView.getTableHeader();
        JTableHeader tblHeadHistoryTribulation = tblHistoryTribulationView.getTableHeader();
        JTableHeader tblHeadShootingSchedule = tblShootingScheduleView.getTableHeader();
        JTableHeader[] tblHead = {tblHeadTribulation, tblHeadUsedEquip, tblHeadUsedRole, tblHeadActor, tblHeadEquipment, tblHeadListRole, tblHeadCastRole, tblHeadListEquip, tblHeadRoleContent, tblHeadHistoryTribulation, tblHeadShootingSchedule};
        for (JTableHeader header : tblHead) {
            header.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 17));
            header.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            header.setOpaque(false);
            header.setBackground(Color.black);
            //header.setForeground(new java.awt.Color(255,255,255));
        }
    }

    private void MyInit(int permission) {
        this.permission = permission;
        this.setLocation(sSize.width / 2 - this.getSize().width / 2, sSize.height / 2 - this.getSize().height / 2);
        statusNewTribulation = statusNewActor = statusNewEquipment = statusNewRole = 1;
        cRole = cFilmHistory = cShootingSchedule = 0;
        navCardLayout = (CardLayout) this.containerPanel.getLayout();
        cardTribulation = (CardLayout) containerTribulation.getLayout();
        cardLRole = (CardLayout) containerRole.getLayout();
        tblModelTribulation = (DefaultTableModel) tblTribulationView.getModel();
        tblModelRole = (DefaultTableModel) tblRoleView.getModel();
        tblModelActor = (DefaultTableModel) tblActorView.getModel();
        tblModelEquipment = (DefaultTableModel) tblEquipmentView.getModel();
        tblModelRoleContent = (DefaultTableModel) tblRoleContentView.getModel();
        tblModelUsedEquipment = (DefaultTableModel) tblUsedEquimentView.getModel();
        tblModelUsedRole = (DefaultTableModel) tblUsedRoleView.getModel();
        tblModelCastToRole = (DefaultTableModel) tblCastToRoleView.getModel();
        tblModelCastRoleSelect = (DefaultTableModel) tblCastRoleActorView.getModel();
        tblModelRoleContent = (DefaultTableModel) tblRoleContentView.getModel();
        tblModelFilmedHistory = (DefaultTableModel) tblHistoryTribulationView.getModel();
        tblModelShootingSchedule = (DefaultTableModel) tblShootingScheduleView.getModel();
        tblModelStatisticsEquipment = (DefaultTableModel) tblListEquipmentView.getModel();
        initCollumn();
        fchooserActor = new JFileChooser();
        fchooserEquipment = new JFileChooser();
        fchooser = new JFileChooser();
        fchooser.setMultiSelectionEnabled(false);
        fchooser.setFileFilter(download);
        fchooserActor.setFileFilter(filter);
        fchooserActor.setMultiSelectionEnabled(false);
        fchooserEquipment.setFileFilter(filter);
        fchooserEquipment.setMultiSelectionEnabled(false);
        imgActorGraphics = imgActorView.getGraphics();
        imgEquipmentGraphics = imgEquipmentView.getGraphics();
        btnShowRoleByTID.setEnabled(false);
        btnShowEquipmentByTID.setEnabled(false);
        new DigitalWatch();

        if (permission == 0) {
            try {
                updateDashboardUser();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateDashBoardADMIN() throws Exception {
        TribulationDAO tribulationDAO = new TribulationDAO();
        ActorDAO actorDAO = new ActorDAO();
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        RoleDAO roleDAO = new RoleDAO();
        lbCTribulation.setText(tribulationDAO.countTribulation() + "");
        lbCActor.setText(actorDAO.countActor() + "");
        lbCEquipment.setText(equipmentDAO.countEquipment() + "");
        lbCRole.setText(roleDAO.countRole() + "");
    }

    private void updateDashboardUser() throws Exception {
        updateRoleContent();
        updateListTribulationHistory();
        updateListTribulationSchedule();
        lbCRoleContent.setText(cRole + "");
        lbCFilmHistory.setText(cFilmHistory + "");
        lbCSchedule.setText(cShootingSchedule + "");
    }

    private void updateListTribulation() throws Exception {
        TribulationDAO tribulationDAO = new TribulationDAO();
        List<TribulationDTO> listTribulation = tribulationDAO.getAllTribulation();
        showListTribulation(listTribulation);
        showSelectTribulation(listTribulation);
    }

    private void updateListTribulationHistory() throws Exception {
        ActorDAO actorDAO = new ActorDAO();
        TribulationDAO tribulationDAO = new TribulationDAO();
        int id = actorDAO.getIDByUsername(username);
        Date date = new Date(System.currentTimeMillis());
        List<TribulationDTO> listTribulation = tribulationDAO.getAllTribulationByIDActor(id);
        if (listTribulation != null) {
            List<TribulationDTO> history = new ArrayList<>();
            for (TribulationDTO tribulationDTO : listTribulation) {
                if (tribulationDTO.getEndDate().toLocalDate().compareTo(date.toLocalDate()) <= 0) {
                    history.add(tribulationDTO);
                }
            }
            if (history != null)
                cFilmHistory = history.size();
            showListHistoryTribulation(history);
        }
    }

    private void updateListTribulationSchedule() throws Exception {
        ActorDAO actorDAO = new ActorDAO();
        TribulationDAO tribulationDAO = new TribulationDAO();
        int id = actorDAO.getIDByUsername(username);
        Date date = new Date(System.currentTimeMillis());
        List<TribulationDTO> listTribulation = tribulationDAO.getAllTribulationByIDActor(id);
        if (listTribulation != null) {
            List<TribulationDTO> schedule = new ArrayList<>();
            for (TribulationDTO tribulationDTO : listTribulation) {
                if (tribulationDTO.getEndDate().toLocalDate().compareTo(date.toLocalDate()) > 0) {
                    schedule.add(tribulationDTO);
                }
            }
            if (schedule != null)
                cShootingSchedule = schedule.size();
            showListShootingSchedule(schedule);
        }
    }

    private void updateListActor() throws Exception {
        ActorDAO actorDAO = new ActorDAO();
        List<ActorDTO> listActor = actorDAO.getAllActor();
        showListActor(listActor);

    }

    private void updateSelectActor() throws Exception {
        CastToRoleDAO castToRoleDAO = new CastToRoleDAO();
        List<CastRoleDTO> listSelect = castToRoleDAO.getAllActor();
        showSelectActor(listSelect);
    }

    private void updateEquipment() throws Exception {
        EquipmentDAO equipmentDAO = new EquipmentDAO();
        List<EquipmentDTO> listEquipment = equipmentDAO.getAllEquipment();
        showListEquipment(listEquipment);
        showSelectEquipment(listEquipment);
    }

    private void updateUsedEquipment() throws Exception {
        UsedEquipmentDAO usedEquipmentDAO = new UsedEquipmentDAO();
        List<UsedEquipmentDTO> listUsedEquip = usedEquipmentDAO.getAllUsedEquipment();
        showUsedEquipment(listUsedEquip);
    }

    private void updateRole() throws Exception {
        RoleDAO roleDAO = new RoleDAO();
        List<RoleDTO> listRole = roleDAO.getAllRole();
        showListRole(listRole);
        showSelectRole(listRole);
    }

    private void updateRoleContent() throws Exception {
        RoleDAO roleDAO = new RoleDAO();
        ActorDAO dao = new ActorDAO();
        txtActorContentName.setText(dao.getNameByUsername(username));
        List<RoleDTO> listRole = roleDAO.getRoleByUsername(username);
        if (listRole != null)
            cRole = listRole.size();
        showListRoleContent(listRole);
    }

    private void updateUsedRole() throws Exception {
        UsedRoleDAO usedRoleDAO = new UsedRoleDAO();
        List<UsedRoleDTO> listUsedRole = usedRoleDAO.getAllUsedRole();
        showListUsedRole(listUsedRole);
    }

    private void updateListCastRole() throws Exception {
        CastToRoleDAO castToRoleDAO = new CastToRoleDAO();
        List<CastRoleDTO> listCastRole = castToRoleDAO.getAllCastRole();
        showListCastToRole(listCastRole);
    }

    private void updateStatistic() throws Exception {
        StatisticEquipmentDAO dao = new StatisticEquipmentDAO();
        List<StatisticEquipmentDTO> listStatistic = dao.getAllStatistic();
        showListStatistic(listStatistic);
    }

    private void updateStatistic(int status, String startDate, String endDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date sd = null, ed = null;
        try {
            long time = sdf.parse(startDate).getTime();
            sd = new Date(time);
            int years = sd.getYear() + 1900;
            if ((int) (Math.log10(years) + 1) != 4) sd = null;
        } catch (ParseException e) {

        }
        try {
            long time = sdf.parse(endDate).getTime();
            ed = new Date(time);
            int years = ed.getYear() + 1900;
            if ((int) (Math.log10(years) + 1) != 4) ed = null;
        } catch (ParseException e) {
        }
        StatisticEquipmentDAO dao = new StatisticEquipmentDAO();
        List<StatisticEquipmentDTO> listStatistic = dao.getAllStatistic();
        List<StatisticEquipmentDTO> afterFilter = new ArrayList<>();
        for (StatisticEquipmentDTO statisticEquipmentDTO : listStatistic) {
            boolean check = true;
            if (status == 1 && statisticEquipmentDTO.getUsingQuantity() == 0)
                continue;
            if (status == 2 && statisticEquipmentDTO.getUsingQuantity() != 0)
                continue;
            if (sd != null && statisticEquipmentDTO.getUsingQuantity() != 0 && sd.toLocalDate().compareTo(statisticEquipmentDTO.getStartDate().toLocalDate()) > 0)
                continue;
            if (ed != null && statisticEquipmentDTO.getUsingQuantity() != 0 && ed.toLocalDate().compareTo(statisticEquipmentDTO.getEndDate().toLocalDate()) < 0)
                continue;

            if (check) afterFilter.add(statisticEquipmentDTO);
        }
        showListStatistic(afterFilter);
    }

    private void showListTribulation(List<TribulationDTO> list) {
        try {
            tblModelTribulation.setRowCount(0);
            for (TribulationDTO tribulationDTO : list) {
                tblModelTribulation.addRow(tribulationDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListHistoryTribulation(List<TribulationDTO> list) {
        try {
            tblModelFilmedHistory.setRowCount(0);
            for (TribulationDTO tribulationDTO : list) {
                tblModelFilmedHistory.addRow(tribulationDTO.toVectorHistory());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListShootingSchedule(List<TribulationDTO> list) {
        try {
            tblModelShootingSchedule.setRowCount(0);
            for (TribulationDTO tribulationDTO : list) {
                tblModelShootingSchedule.addRow(tribulationDTO.toVectorHistory());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSelectTribulation(List<TribulationDTO> list) {
        try {
            Vector v = new Vector();
            for (TribulationDTO tribulationDTO : list) {
                v.add(tribulationDTO.getTribulationName());
            }
            selectTribulation.setListData(v);
            selectTribulation1.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListActor(List<ActorDTO> list) {
        try {
            tblModelActor.setRowCount(0);
            for (ActorDTO actorDTO : list) {
                tblModelActor.addRow(actorDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSelectActor(List<CastRoleDTO> list) {
        try {
            tblModelCastRoleSelect.setRowCount(0);
            for (CastRoleDTO castRoleDTO : list) {
                tblModelCastRoleSelect.addRow(castRoleDTO.toVectorSelection());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListEquipment(List<EquipmentDTO> list) {
        try {
            tblModelEquipment.setRowCount(0);
            for (EquipmentDTO equipmentDTO : list) {
                tblModelEquipment.addRow(equipmentDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showUsedEquipment(List<UsedEquipmentDTO> list) {
        try {
            tblModelUsedEquipment.setRowCount(0);
            for (UsedEquipmentDTO usedEquipmentDTO : list) {
                tblModelUsedEquipment.addRow(usedEquipmentDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSelectEquipment(List<EquipmentDTO> list) {
        try {
            Vector v = new Vector();
            for (EquipmentDTO equipmentDTO : list) {
                v.add(equipmentDTO.getEquipmentName());
            }
            selectEquipment.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListRole(List<RoleDTO> list) {
        try {
            tblModelRole.setRowCount(0);
            for (RoleDTO roleDTO : list) {
                tblModelRole.addRow(roleDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListRoleContent(List<RoleDTO> list) {
        try {
            tblModelRoleContent.setRowCount(0);
            for (RoleDTO roleDTO : list) {
                tblModelRoleContent.addRow(roleDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListUsedRole(List<UsedRoleDTO> list) {
        try {
            tblModelUsedRole.setRowCount(0);
            for (UsedRoleDTO usedRoleDTO : list) {
                tblModelUsedRole.addRow(usedRoleDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListCastToRole(List<CastRoleDTO> list) {
        try {
            tblModelCastToRole.setRowCount(0);
            for (CastRoleDTO castRoleDTO : list) {
                tblModelCastToRole.addRow(castRoleDTO.toVector());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showSelectRole(List<RoleDTO> list) {
        try {
            Vector v = new Vector();
            for (RoleDTO roleDTO : list) {
                v.add(roleDTO.getRoleName());
            }
            selectRole.setListData(v);
            selectRoleName.setListData(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListStatistic(List<StatisticEquipmentDTO> list) {
        try {
            tblModelStatisticsEquipment.setRowCount(0);
            if (list != null)
                for (StatisticEquipmentDTO statisticEquipmentDTO : list) {
                    tblModelStatisticsEquipment.addRow(statisticEquipmentDTO.toVector());
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TribulationDTO getInfoTribulation() throws Exception {
        return MyValidation.validTribulation(txtTribulationName.getText().trim(), txtPlace.getText().trim(), txtStartDate.getText().trim(), txtEndDate.getText().trim(), txtNumOfShoot.getText().trim(), txtTribulationDescription.getText().trim());
    }

    private ActorDTO getInfoActor() throws Exception {

        return MyValidation.validActor(txtActorName.getText().trim(), txtActorPhone.getText().trim(), txtActorEmail.getText().trim(), txtActorDescription.getText().trim(), txtActorPathImg.getText().trim());
    }

    private EquipmentDTO getInfoEquipment() throws Exception {
        return MyValidation.validEquipment(txtEquipmentName.getText().trim(), txtEquipmentQuantity.getText().trim(), txtEquipmentDescription.getText().trim(), txtEquipmentPathImg.getText().trim());
    }

    private RoleDTO getInfoRole() throws Exception {
        return MyValidation.validRole(txtRole.getText().trim(), txtRoleDescription.getText().trim());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEquipmentPathImg = new javax.swing.JTextField();
        txtPathRoleContent = new javax.swing.JTextField();
        txtActorPathImg = new javax.swing.JTextField();
        titleBar = new javax.swing.JPanel();
        logoTitle = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        txtRoleUser = new javax.swing.JLabel();
        titleBarRight = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnEditAccount = new javax.swing.JLabel();
        btnEditInfo = new javax.swing.JLabel();
        navLeft = new javax.swing.JPanel();
        separete = new javax.swing.JLabel();
        navDashBoard = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        titleDashBoard = new javax.swing.JLabel();
        navManageTribulation = new javax.swing.JPanel();
        iconMnTribulation = new javax.swing.JLabel();
        titleTribulation = new javax.swing.JLabel();
        navManageActor = new javax.swing.JPanel();
        iconMnActor = new javax.swing.JLabel();
        titleMnActor = new javax.swing.JLabel();
        navManageEquipment = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        titleMnEquipment = new javax.swing.JLabel();
        navManageRole = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        titleMnRole = new javax.swing.JLabel();
        navStatisticsEquipment = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        titleStatisticsEquipment = new javax.swing.JLabel();
        navRoleContent = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        titleRoleContent = new javax.swing.JLabel();
        navFilmedHistory = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        titleFilmedHistory = new javax.swing.JLabel();
        navShootingSchedule = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        titleShootingSchedule = new javax.swing.JLabel();
        navLogout = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        titleLogout = new javax.swing.JLabel();
        containerPanel = new javax.swing.JPanel();
        cardDashBoard = new javax.swing.JPanel();
        wellcomePanel = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        notification = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbNoti = new javax.swing.JLabel();
        Wellcome = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        wellcomeName = new javax.swing.JLabel();
        containerDashboard = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        titleTimeNow = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        containerTime = new javax.swing.JPanel();
        hours = new javax.swing.JPanel();
        titleHours = new javax.swing.JPanel();
        lbTitleHours = new javax.swing.JLabel();
        lbHours = new javax.swing.JLabel();
        minutes = new javax.swing.JPanel();
        titleMinutes = new javax.swing.JPanel();
        lbTitleMinutes = new javax.swing.JLabel();
        lbMinutes = new javax.swing.JLabel();
        second = new javax.swing.JPanel();
        titleSecond = new javax.swing.JPanel();
        lbTitleSecond = new javax.swing.JLabel();
        lbSeconds = new javax.swing.JLabel();
        ContainerStatiticNav = new javax.swing.JPanel();
        NavStatistic = new javax.swing.JPanel();
        adminSN = new javax.swing.JPanel();
        CTribulation = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lbCTribulation = new javax.swing.JLabel();
        CActor = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lbCActor = new javax.swing.JLabel();
        CEquipment = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        lbCEquipment = new javax.swing.JLabel();
        CRole = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        lbCRole = new javax.swing.JLabel();
        userSN = new javax.swing.JPanel();
        CRoleContent = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        lbCRoleContent = new javax.swing.JLabel();
        CFilmHistory = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        lbCFilmHistory = new javax.swing.JLabel();
        CShootingSchedule = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        lbCSchedule = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cardMnTribulation = new javax.swing.JPanel();
        tabTribulation = new javax.swing.JPanel();
        tabb3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        tabb4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        tabb5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        containerTribulation = new javax.swing.JPanel();
        cardListTribulation = new javax.swing.JPanel();
        infoPanelTribulation = new javax.swing.JPanel();
        tribulationInfo = new javax.swing.JPanel();
        btnShowRoleByTID = new javax.swing.JButton();
        btnShowEquipmentByTID = new javax.swing.JButton();
        moreInfo = new javax.swing.JPanel();
        lbTribulationName = new javax.swing.JLabel();
        txtTribulationName = new javax.swing.JTextField();
        lbPlace = new javax.swing.JLabel();
        txtPlace = new javax.swing.JTextField();
        lbStartDate = new javax.swing.JLabel();
        lbEndDate = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        txtEndDate = new javax.swing.JTextField();
        jScrollTribulationDescription = new javax.swing.JScrollPane();
        txtTribulationDescription = new javax.swing.JTextArea();
        lbEndDate1 = new javax.swing.JLabel();
        txtNumOfShoot = new javax.swing.JTextField();
        tblTribulation = new javax.swing.JPanel();
        jScrolTribulation = new javax.swing.JScrollPane();
        tblTribulationView = new javax.swing.JTable();
        controllerTribulation = new javax.swing.JPanel();
        btnNewTribulation = new javax.swing.JButton();
        btnCreateTribulation = new javax.swing.JButton();
        btnSearchTribulation = new javax.swing.JButton();
        btnUpdateTribulation = new javax.swing.JButton();
        btnDeleteTribulation = new javax.swing.JButton();
        cardUsedEquip = new javax.swing.JPanel();
        selectInfo = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectEquipment = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectTribulation = new javax.swing.JList<>();
        jPanel8 = new javax.swing.JPanel();
        selectQuantity = new javax.swing.JSpinner();
        tblPanelUsedEquipment = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUsedEquimentView = new javax.swing.JTable();
        controllerTribulation1 = new javax.swing.JPanel();
        btnAddUsedEquipment = new javax.swing.JButton();
        btnSearchUsedEquipment = new javax.swing.JButton();
        btnDeleteUsedEquipment = new javax.swing.JButton();
        cardUsedRole = new javax.swing.JPanel();
        selectInfo1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        selectRole = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        selectTribulation1 = new javax.swing.JList<>();
        controllerTribulation2 = new javax.swing.JPanel();
        btnAddUsedRole = new javax.swing.JButton();
        btnSearchUsedRole = new javax.swing.JButton();
        btnDeleteUsedRole = new javax.swing.JButton();
        tblPanelUsedRole = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblUsedRoleView = new javax.swing.JTable();
        cardMnActor = new javax.swing.JPanel();
        tabActor = new javax.swing.JPanel();
        tabb1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        containerActor = new javax.swing.JPanel();
        listActor = new javax.swing.JPanel();
        detailActor = new javax.swing.JPanel();
        imgActor = new javax.swing.JPanel();
        imgActorView = new javax.swing.JPanel();
        txtActorURLImage = new javax.swing.JTextField();
        btnActorOpenImg = new javax.swing.JLabel();
        infoActor = new javax.swing.JPanel();
        lbNameActor = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        txtActorPhone = new javax.swing.JTextField();
        txtActorEmail = new javax.swing.JTextField();
        txtActorName = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtActorDescription = new javax.swing.JTextArea();
        controllerDV = new javax.swing.JPanel();
        btnNewActor = new javax.swing.JButton();
        btnCreateActor = new javax.swing.JButton();
        btnSearchActor = new javax.swing.JButton();
        btnUpdateActor = new javax.swing.JButton();
        btnDeleteActor = new javax.swing.JButton();
        tblActor = new javax.swing.JPanel();
        jScrolActor = new javax.swing.JScrollPane();
        tblActorView = new javax.swing.JTable();
        accountActor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        cardMnEquipment = new javax.swing.JPanel();
        tabEquipment = new javax.swing.JPanel();
        tabb6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        containerEquipment = new javax.swing.JPanel();
        listEquipment = new javax.swing.JPanel();
        detailEquipment = new javax.swing.JPanel();
        imgEquipment = new javax.swing.JPanel();
        imgEquipmentView = new javax.swing.JPanel();
        btnEquipmentOpenImg = new javax.swing.JLabel();
        txtEquipmentURLImage = new javax.swing.JTextField();
        infoEquipment = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtEquipmentDescription = new javax.swing.JTextArea();
        jPanel21 = new javax.swing.JPanel();
        txtEquipmentName = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        txtEquipmentQuantity = new javax.swing.JTextField();
        controllerEquipment = new javax.swing.JPanel();
        btnNewEquipment = new javax.swing.JButton();
        btnCreateEquipment = new javax.swing.JButton();
        btnSearchEquipment = new javax.swing.JButton();
        btnUpdateEquipment = new javax.swing.JButton();
        btnDeleteEquipment = new javax.swing.JButton();
        tblEquipment = new javax.swing.JPanel();
        jScrolActor1 = new javax.swing.JScrollPane();
        tblEquipmentView = new javax.swing.JTable();
        cardRole = new javax.swing.JPanel();
        tabRole = new javax.swing.JPanel();
        tabb7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tabb8 = new javax.swing.JPanel();
        jLabel2324 = new javax.swing.JLabel();
        containerRole = new javax.swing.JPanel();
        listRole = new javax.swing.JPanel();
        controllerRole = new javax.swing.JPanel();
        btnNewRole = new javax.swing.JButton();
        btnCreateRole = new javax.swing.JButton();
        btnSearchRole = new javax.swing.JButton();
        btnUpdateRole = new javax.swing.JButton();
        btnDeleteRole = new javax.swing.JButton();
        infoRole = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblRoleView = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtRole = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtRoleDescription = new javax.swing.JTextArea();
        castToRole = new javax.swing.JPanel();
        controllerCastToRole = new javax.swing.JPanel();
        btnUpdateCastRole = new javax.swing.JButton();
        btnSearchCastRole = new javax.swing.JButton();
        btnDeleteCastRole = new javax.swing.JButton();
        tblPanelCastToRole = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblCastToRoleView = new javax.swing.JTable();
        selectInfoRole = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        selectRoleName = new javax.swing.JList<>();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblCastRoleActorView = new javax.swing.JTable();
        cardStatisticEquipment = new javax.swing.JPanel();
        lbTitle = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        containerTblStatistics = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblListEquipmentView = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        cbSelectStatus = new javax.swing.JComboBox<>();
        jPanel39 = new javax.swing.JPanel();
        errorStartDate = new javax.swing.JPanel();
        lbErrorSD = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        txtStatisticStartDate = new javax.swing.JTextField();
        btnClearStartDate = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        txtStatisticEndDate = new javax.swing.JTextField();
        btnClearEndDate = new javax.swing.JButton();
        errorEndDate = new javax.swing.JPanel();
        lbErrorED = new javax.swing.JLabel();
        cardRoleContent = new javax.swing.JPanel();
        containerRoleChoose = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtActorContentName = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblRoleContentView = new javax.swing.JTable();
        containerRoleDescription = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        txtRoleContentDescription = new javax.swing.JTextArea();
        btnDownload = new javax.swing.JButton();
        cardFilmedHistory = new javax.swing.JPanel();
        panelHistory = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblHistoryTribulationView = new javax.swing.JTable();
        panelInfoHistory = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        txtHTribulationName = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        txtHPlace = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtHStartDate = new javax.swing.JTextField();
        txtHEndDate = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        txtHNumbaerOfShoot = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        txtHDescription = new javax.swing.JTextArea();
        cardShootingSchedule = new javax.swing.JPanel();
        panelShooting = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblShootingScheduleView = new javax.swing.JTable();
        panelInfoShooting = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        txtSTribulationName = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        txtSPlace = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtSStartDate = new javax.swing.JTextField();
        txtSEndDate = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        txtSNumberOfShoot = new javax.swing.JTextField();
        jScrollPane21 = new javax.swing.JScrollPane();
        txtSDescription = new javax.swing.JTextArea();

        txtEquipmentPathImg.setText("jTextField11");

        txtActorPathImg.setText("jTextField11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tay Du Ky ");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(989, 600));
        setResizable(false);

        titleBar.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        titleBar.setPreferredSize(new java.awt.Dimension(856, 30));
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBarMouseDragged(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBarMousePressed(evt);
            }
        });
        titleBar.setLayout(new java.awt.BorderLayout());

        logoTitle.setBackground(new java.awt.Color(243, 106, 90));
        logoTitle.setPreferredSize(new java.awt.Dimension(260, 100));
        logoTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setFont(new java.awt.Font("SVN-Sliced", 0, 36)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_cd_24px_1.png"))); // NOI18N
        logoTitle.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 3, -1, -1));

        txtRoleUser.setFont(new java.awt.Font("SVN-Square", 0, 24)); // NOI18N
        txtRoleUser.setForeground(new java.awt.Color(255, 255, 255));
        txtRoleUser.setText("Tay Du Ky");
        logoTitle.add(txtRoleUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, -3, -1, -1));

        titleBar.add(logoTitle, java.awt.BorderLayout.LINE_START);

        titleBarRight.setBackground(new java.awt.Color(255, 255, 255));
        titleBarRight.setPreferredSize(new java.awt.Dimension(500, 30));
        titleBarRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_close_window_24px.png"))); // NOI18N
        btnExit.setToolTipText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        titleBarRight.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 3, -1, -1));

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_minimize_window_24px_6.png"))); // NOI18N
        btnMinimize.setToolTipText("Minimize");
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        titleBarRight.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 3, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_menu_24px_1.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        titleBarRight.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, -1, -1));

        btnEditAccount.setFont(new java.awt.Font("SVN-SAF", 0, 12)); // NOI18N
        btnEditAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_manager_24px.png"))); // NOI18N
        btnEditAccount.setText("Edit Account ");
        btnEditAccount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 0, 51), new java.awt.Color(0, 51, 255), new java.awt.Color(255, 255, 254), new java.awt.Color(255, 254, 255)));
        btnEditAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditAccount.setPreferredSize(new java.awt.Dimension(138, 28));
        btnEditAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditAccountMouseClicked(evt);
            }
        });
        titleBarRight.add(btnEditAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, -1));

        btnEditInfo.setFont(new java.awt.Font("SVN-SAF", 0, 12)); // NOI18N
        btnEditInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_activity_history_24px.png"))); // NOI18N
        btnEditInfo.setText("EDIT INFORMATION");
        btnEditInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 0, 51), new java.awt.Color(0, 51, 255), new java.awt.Color(255, 255, 254), new java.awt.Color(255, 255, 254)));
        btnEditInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditInfoMouseClicked(evt);
            }
        });
        titleBarRight.add(btnEditInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        titleBar.add(titleBarRight, java.awt.BorderLayout.CENTER);

        getContentPane().add(titleBar, java.awt.BorderLayout.PAGE_START);

        navLeft.setBackground(new java.awt.Color(62, 62, 62));
        navLeft.setMaximumSize(new java.awt.Dimension(260, 32767));
        navLeft.setMinimumSize(new java.awt.Dimension(260, 36));
        navLeft.setPreferredSize(new java.awt.Dimension(260, 570));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0);
        flowLayout1.setAlignOnBaseline(true);
        navLeft.setLayout(flowLayout1);

        separete.setPreferredSize(new java.awt.Dimension(260, 30));
        navLeft.add(separete);

        navDashBoard.setBackground(new java.awt.Color(237, 237, 237));
        navDashBoard.setAlignmentX(0.0F);
        navDashBoard.setAlignmentY(0.0F);
        navDashBoard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navDashBoard.setPreferredSize(new java.awt.Dimension(260, 54));
        navDashBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navDashBoardMouseClicked(evt);
            }
        });
        navDashBoard.setLayout(new java.awt.BorderLayout());

        icon.setBackground(new java.awt.Color(237, 237, 237));
        icon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_speed_24px_2.png"))); // NOI18N
        icon.setPreferredSize(new java.awt.Dimension(40, 24));
        navDashBoard.add(icon, java.awt.BorderLayout.LINE_START);

        titleDashBoard.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleDashBoard.setForeground(new java.awt.Color(243, 106, 90));
        titleDashBoard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleDashBoard.setText("Dashboard");
        titleDashBoard.setPreferredSize(new java.awt.Dimension(200, 14));
        navDashBoard.add(titleDashBoard, java.awt.BorderLayout.LINE_END);

        navLeft.add(navDashBoard);

        navManageTribulation.setBackground(new java.awt.Color(62, 62, 62));
        navManageTribulation.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navManageTribulation.setAlignmentX(0.0F);
        navManageTribulation.setAlignmentY(0.0F);
        navManageTribulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navManageTribulation.setPreferredSize(new java.awt.Dimension(260, 54));
        navManageTribulation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navManageTribulationMouseClicked(evt);
            }
        });
        navManageTribulation.setLayout(new java.awt.BorderLayout());

        iconMnTribulation.setBackground(new java.awt.Color(237, 237, 237));
        iconMnTribulation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        iconMnTribulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_task_completed_24px.png"))); // NOI18N
        iconMnTribulation.setPreferredSize(new java.awt.Dimension(40, 24));
        navManageTribulation.add(iconMnTribulation, java.awt.BorderLayout.LINE_START);

        titleTribulation.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleTribulation.setForeground(new java.awt.Color(184, 184, 184));
        titleTribulation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleTribulation.setText("Manage Tribulation");
        titleTribulation.setPreferredSize(new java.awt.Dimension(200, 14));
        navManageTribulation.add(titleTribulation, java.awt.BorderLayout.LINE_END);

        navLeft.add(navManageTribulation);

        navManageActor.setBackground(new java.awt.Color(62, 62, 62));
        navManageActor.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navManageActor.setAlignmentX(0.0F);
        navManageActor.setAlignmentY(0.0F);
        navManageActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navManageActor.setPreferredSize(new java.awt.Dimension(260, 54));
        navManageActor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navManageActorMouseClicked(evt);
            }
        });
        navManageActor.setLayout(new java.awt.BorderLayout());

        iconMnActor.setBackground(new java.awt.Color(237, 237, 237));
        iconMnActor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        iconMnActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_management_24px.png"))); // NOI18N
        iconMnActor.setPreferredSize(new java.awt.Dimension(40, 24));
        navManageActor.add(iconMnActor, java.awt.BorderLayout.LINE_START);

        titleMnActor.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleMnActor.setForeground(new java.awt.Color(184, 184, 184));
        titleMnActor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleMnActor.setText("Manage Actor");
        titleMnActor.setPreferredSize(new java.awt.Dimension(200, 14));
        navManageActor.add(titleMnActor, java.awt.BorderLayout.LINE_END);

        navLeft.add(navManageActor);

        navManageEquipment.setBackground(new java.awt.Color(62, 62, 62));
        navManageEquipment.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navManageEquipment.setAlignmentX(0.0F);
        navManageEquipment.setAlignmentY(0.0F);
        navManageEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navManageEquipment.setPreferredSize(new java.awt.Dimension(260, 54));
        navManageEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navManageEquipmentMouseClicked(evt);
            }
        });
        navManageEquipment.setLayout(new java.awt.BorderLayout());

        jLabel8.setBackground(new java.awt.Color(237, 237, 237));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_maintenance_24px_1.png"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(40, 24));
        navManageEquipment.add(jLabel8, java.awt.BorderLayout.LINE_START);

        titleMnEquipment.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleMnEquipment.setForeground(new java.awt.Color(184, 184, 184));
        titleMnEquipment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleMnEquipment.setText("Manage Equipment");
        titleMnEquipment.setPreferredSize(new java.awt.Dimension(200, 14));
        navManageEquipment.add(titleMnEquipment, java.awt.BorderLayout.LINE_END);

        navLeft.add(navManageEquipment);

        navManageRole.setBackground(new java.awt.Color(62, 62, 62));
        navManageRole.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navManageRole.setAlignmentX(0.0F);
        navManageRole.setAlignmentY(0.0F);
        navManageRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navManageRole.setPreferredSize(new java.awt.Dimension(260, 54));
        navManageRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navManageRoleMouseClicked(evt);
            }
        });
        navManageRole.setLayout(new java.awt.BorderLayout());

        jLabel10.setBackground(new java.awt.Color(237, 237, 237));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_manager_24px.png"))); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(40, 24));
        navManageRole.add(jLabel10, java.awt.BorderLayout.LINE_START);

        titleMnRole.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleMnRole.setForeground(new java.awt.Color(184, 184, 184));
        titleMnRole.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleMnRole.setText("Manage Role");
        titleMnRole.setPreferredSize(new java.awt.Dimension(200, 14));
        navManageRole.add(titleMnRole, java.awt.BorderLayout.LINE_END);

        navLeft.add(navManageRole);

        navStatisticsEquipment.setBackground(new java.awt.Color(62, 62, 62));
        navStatisticsEquipment.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navStatisticsEquipment.setAlignmentX(0.0F);
        navStatisticsEquipment.setAlignmentY(0.0F);
        navStatisticsEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navStatisticsEquipment.setPreferredSize(new java.awt.Dimension(260, 54));
        navStatisticsEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navStatisticsEquipmentMouseClicked(evt);
            }
        });
        navStatisticsEquipment.setLayout(new java.awt.BorderLayout());

        jLabel14.setBackground(new java.awt.Color(237, 237, 237));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_static_views_24px.png"))); // NOI18N
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 24));
        navStatisticsEquipment.add(jLabel14, java.awt.BorderLayout.LINE_START);

        titleStatisticsEquipment.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleStatisticsEquipment.setForeground(new java.awt.Color(184, 184, 184));
        titleStatisticsEquipment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleStatisticsEquipment.setText("Statistics Equipment");
        titleStatisticsEquipment.setPreferredSize(new java.awt.Dimension(200, 14));
        navStatisticsEquipment.add(titleStatisticsEquipment, java.awt.BorderLayout.LINE_END);

        navLeft.add(navStatisticsEquipment);

        navRoleContent.setBackground(new java.awt.Color(62, 62, 62));
        navRoleContent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navRoleContent.setAlignmentX(0.0F);
        navRoleContent.setAlignmentY(0.0F);
        navRoleContent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navRoleContent.setPreferredSize(new java.awt.Dimension(260, 54));
        navRoleContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navRoleContentMouseClicked(evt);
            }
        });
        navRoleContent.setLayout(new java.awt.BorderLayout());

        jLabel16.setBackground(new java.awt.Color(237, 237, 237));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_table_of_content_24px.png"))); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(40, 24));
        navRoleContent.add(jLabel16, java.awt.BorderLayout.LINE_START);

        titleRoleContent.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleRoleContent.setForeground(new java.awt.Color(184, 184, 184));
        titleRoleContent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleRoleContent.setText("Role Content");
        titleRoleContent.setPreferredSize(new java.awt.Dimension(200, 14));
        navRoleContent.add(titleRoleContent, java.awt.BorderLayout.LINE_END);

        navLeft.add(navRoleContent);

        navFilmedHistory.setBackground(new java.awt.Color(62, 62, 62));
        navFilmedHistory.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navFilmedHistory.setAlignmentX(0.0F);
        navFilmedHistory.setAlignmentY(0.0F);
        navFilmedHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navFilmedHistory.setPreferredSize(new java.awt.Dimension(260, 54));
        navFilmedHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navFilmedHistoryMouseClicked(evt);
            }
        });
        navFilmedHistory.setLayout(new java.awt.BorderLayout());

        jLabel22.setBackground(new java.awt.Color(237, 237, 237));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_tasklist_24px.png"))); // NOI18N
        jLabel22.setPreferredSize(new java.awt.Dimension(40, 24));
        navFilmedHistory.add(jLabel22, java.awt.BorderLayout.LINE_START);

        titleFilmedHistory.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleFilmedHistory.setForeground(new java.awt.Color(184, 184, 184));
        titleFilmedHistory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleFilmedHistory.setText("Filmed History");
        titleFilmedHistory.setPreferredSize(new java.awt.Dimension(200, 14));
        navFilmedHistory.add(titleFilmedHistory, java.awt.BorderLayout.LINE_END);

        navLeft.add(navFilmedHistory);

        navShootingSchedule.setBackground(new java.awt.Color(62, 62, 62));
        navShootingSchedule.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navShootingSchedule.setAlignmentX(0.0F);
        navShootingSchedule.setAlignmentY(0.0F);
        navShootingSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navShootingSchedule.setPreferredSize(new java.awt.Dimension(260, 54));
        navShootingSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navShootingScheduleMouseClicked(evt);
            }
        });
        navShootingSchedule.setLayout(new java.awt.BorderLayout());

        jLabel20.setBackground(new java.awt.Color(237, 237, 237));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_order_history_24px.png"))); // NOI18N
        jLabel20.setPreferredSize(new java.awt.Dimension(40, 24));
        navShootingSchedule.add(jLabel20, java.awt.BorderLayout.LINE_START);

        titleShootingSchedule.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        titleShootingSchedule.setForeground(new java.awt.Color(184, 184, 184));
        titleShootingSchedule.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleShootingSchedule.setText("Shooting Schedule");
        titleShootingSchedule.setPreferredSize(new java.awt.Dimension(200, 14));
        navShootingSchedule.add(titleShootingSchedule, java.awt.BorderLayout.LINE_END);

        navLeft.add(navShootingSchedule);

        navLogout.setBackground(new java.awt.Color(62, 62, 62));
        navLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        navLogout.setAlignmentX(0.0F);
        navLogout.setAlignmentY(0.0F);
        navLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navLogout.setPreferredSize(new java.awt.Dimension(260, 54));
        navLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navLogoutMouseClicked(evt);
            }
        });
        navLogout.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(237, 237, 237));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_logout_rounded_left_24px.png"))); // NOI18N
        jLabel18.setPreferredSize(new java.awt.Dimension(40, 24));
        navLogout.add(jLabel18, java.awt.BorderLayout.LINE_START);

        titleLogout.setFont(new java.awt.Font("SVN-SAF", 0, 22)); // NOI18N
        titleLogout.setForeground(new java.awt.Color(184, 184, 184));
        titleLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLogout.setText("Log Out");
        titleLogout.setPreferredSize(new java.awt.Dimension(200, 14));
        navLogout.add(titleLogout, java.awt.BorderLayout.LINE_END);

        navLeft.add(navLogout);

        getContentPane().add(navLeft, java.awt.BorderLayout.LINE_START);

        containerPanel.setPreferredSize(new java.awt.Dimension(721, 570));
        containerPanel.setLayout(new java.awt.CardLayout());

        cardDashBoard.setBackground(new java.awt.Color(237, 237, 237));
        cardDashBoard.setPreferredSize(new java.awt.Dimension(721, 570));
        cardDashBoard.setLayout(new java.awt.BorderLayout());

        wellcomePanel.setPreferredSize(new java.awt.Dimension(721, 50));
        wellcomePanel.setLayout(new java.awt.BorderLayout());

        jPanel19.setLayout(new java.awt.BorderLayout());

        notification.setBackground(new java.awt.Color(255, 255, 255));
        notification.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 255), new java.awt.Color(255, 0, 51), new java.awt.Color(254, 254, 254), new java.awt.Color(254, 254, 254)));
        notification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notification.setPreferredSize(new java.awt.Dimension(170, 54));
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationMouseClicked(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_google_alerts_48px.png"))); // NOI18N

        jLabel19.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 255));
        jLabel19.setText("You have");

        lbNoti.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        lbNoti.setForeground(new java.awt.Color(255, 0, 51));
        lbNoti.setText("6 NOTIFICATION");

        javax.swing.GroupLayout notificationLayout = new javax.swing.GroupLayout(notification);
        notification.setLayout(notificationLayout);
        notificationLayout.setHorizontalGroup(
                notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(notificationLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(notificationLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel19))
                                        .addGroup(notificationLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lbNoti)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        notificationLayout.setVerticalGroup(
                notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(notificationLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel19)
                                .addGap(1, 1, 1)
                                .addComponent(lbNoti)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.add(notification, java.awt.BorderLayout.LINE_END);

        Wellcome.setBackground(new java.awt.Color(255, 255, 255));
        Wellcome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 0, 51), new java.awt.Color(0, 51, 255), new java.awt.Color(254, 254, 254), new java.awt.Color(254, 254, 254)));

        jLabel7.setFont(new java.awt.Font("SVN-Revolution", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 153, 255));
        jLabel7.setText("Wellcome");

        wellcomeName.setFont(new java.awt.Font("SVN-Rocker", 0, 24)); // NOI18N
        wellcomeName.setForeground(new java.awt.Color(0, 102, 255));
        wellcomeName.setText("ADMIN");

        javax.swing.GroupLayout WellcomeLayout = new javax.swing.GroupLayout(Wellcome);
        Wellcome.setLayout(WellcomeLayout);
        WellcomeLayout.setHorizontalGroup(
                WellcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WellcomeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(wellcomeName)
                                .addContainerGap(303, Short.MAX_VALUE))
        );
        WellcomeLayout.setVerticalGroup(
                WellcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WellcomeLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(WellcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(wellcomeName))
                                .addContainerGap())
        );

        jPanel19.add(Wellcome, java.awt.BorderLayout.CENTER);

        wellcomePanel.add(jPanel19, java.awt.BorderLayout.CENTER);

        cardDashBoard.add(wellcomePanel, java.awt.BorderLayout.PAGE_START);

        containerDashboard.setPreferredSize(new java.awt.Dimension(721, 520));
        containerDashboard.setLayout(new java.awt.BorderLayout());

        timePanel.setBackground(new java.awt.Color(6, 10, 31));
        timePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 51)));
        timePanel.setPreferredSize(new java.awt.Dimension(721, 250));
        timePanel.setLayout(new java.awt.BorderLayout());

        titleTimeNow.setBackground(new java.awt.Color(6, 10, 31));
        titleTimeNow.setPreferredSize(new java.awt.Dimension(196, 42));
        titleTimeNow.setLayout(new java.awt.BorderLayout());

        jPanel14.setOpaque(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 42, Short.MAX_VALUE)
        );

        titleTimeNow.add(jPanel14, java.awt.BorderLayout.LINE_START);

        jPanel18.setOpaque(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 42, Short.MAX_VALUE)
        );

        titleTimeNow.add(jPanel18, java.awt.BorderLayout.LINE_END);

        jPanel29.setOpaque(false);

        jLabel25.setFont(new java.awt.Font("SVN-SAF", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("THE TIME IS NOW");
        jPanel29.add(jLabel25);

        titleTimeNow.add(jPanel29, java.awt.BorderLayout.CENTER);

        timePanel.add(titleTimeNow, java.awt.BorderLayout.PAGE_START);

        containerTime.setOpaque(false);
        containerTime.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        hours.setBackground(new java.awt.Color(33, 150, 243));
        hours.setPreferredSize(new java.awt.Dimension(140, 150));
        hours.setLayout(new java.awt.BorderLayout());

        titleHours.setBackground(new java.awt.Color(255, 255, 255));
        titleHours.setPreferredSize(new java.awt.Dimension(140, 40));

        lbTitleHours.setBackground(new java.awt.Color(255, 255, 255));
        lbTitleHours.setFont(new java.awt.Font("SVN-SAF", 0, 20)); // NOI18N
        lbTitleHours.setText("Hours");
        titleHours.add(lbTitleHours);

        hours.add(titleHours, java.awt.BorderLayout.PAGE_END);

        lbHours.setFont(new java.awt.Font("SVN-Revolution", 0, 70)); // NOI18N
        lbHours.setForeground(new java.awt.Color(255, 255, 255));
        lbHours.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHours.setText("00");
        hours.add(lbHours, java.awt.BorderLayout.CENTER);

        containerTime.add(hours);

        minutes.setBackground(new java.awt.Color(33, 150, 243));
        minutes.setPreferredSize(new java.awt.Dimension(140, 150));
        minutes.setLayout(new java.awt.BorderLayout());

        titleMinutes.setBackground(new java.awt.Color(255, 255, 255));
        titleMinutes.setPreferredSize(new java.awt.Dimension(140, 40));

        lbTitleMinutes.setFont(new java.awt.Font("SVN-SAF", 0, 20)); // NOI18N
        lbTitleMinutes.setText("MINUTES");
        titleMinutes.add(lbTitleMinutes);

        minutes.add(titleMinutes, java.awt.BorderLayout.PAGE_END);

        lbMinutes.setFont(new java.awt.Font("SVN-Revolution", 0, 70)); // NOI18N
        lbMinutes.setForeground(new java.awt.Color(255, 255, 255));
        lbMinutes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMinutes.setText("00");
        minutes.add(lbMinutes, java.awt.BorderLayout.CENTER);

        containerTime.add(minutes);

        second.setBackground(new java.awt.Color(255, 0, 106));
        second.setPreferredSize(new java.awt.Dimension(140, 150));
        second.setLayout(new java.awt.BorderLayout());

        titleSecond.setBackground(new java.awt.Color(255, 255, 255));
        titleSecond.setPreferredSize(new java.awt.Dimension(140, 40));

        lbTitleSecond.setFont(new java.awt.Font("SVN-SAF", 0, 20)); // NOI18N
        lbTitleSecond.setText("Seconds");
        titleSecond.add(lbTitleSecond);

        second.add(titleSecond, java.awt.BorderLayout.PAGE_END);

        lbSeconds.setFont(new java.awt.Font("SVN-Revolution", 0, 70)); // NOI18N
        lbSeconds.setForeground(new java.awt.Color(255, 255, 255));
        lbSeconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSeconds.setText("00");
        second.add(lbSeconds, java.awt.BorderLayout.CENTER);

        containerTime.add(second);

        timePanel.add(containerTime, java.awt.BorderLayout.CENTER);

        containerDashboard.add(timePanel, java.awt.BorderLayout.PAGE_START);

        ContainerStatiticNav.setPreferredSize(new java.awt.Dimension(721, 270));
        ContainerStatiticNav.setLayout(new java.awt.BorderLayout());

        NavStatistic.setBackground(new java.awt.Color(102, 102, 102));
        NavStatistic.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(0, 51, 255)));
        NavStatistic.setPreferredSize(new java.awt.Dimension(721, 240));
        NavStatistic.setLayout(new java.awt.BorderLayout());

        adminSN.setBackground(new java.awt.Color(0, 0, 51));
        adminSN.setPreferredSize(new java.awt.Dimension(721, 240));
        java.awt.FlowLayout flowLayout6 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 40);
        flowLayout6.setAlignOnBaseline(true);
        adminSN.setLayout(flowLayout6);

        CTribulation.setBackground(new java.awt.Color(255, 51, 51));
        CTribulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CTribulation.setPreferredSize(new java.awt.Dimension(140, 150));
        CTribulation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CTribulationMouseClicked(evt);
            }
        });
        CTribulation.setLayout(new java.awt.BorderLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel33.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        jLabel33.setText("Tribulation");
        jPanel17.add(jLabel33);

        CTribulation.add(jPanel17, java.awt.BorderLayout.PAGE_END);

        lbCTribulation.setFont(new java.awt.Font("SVN-Revolution", 0, 60)); // NOI18N
        lbCTribulation.setForeground(new java.awt.Color(255, 255, 255));
        lbCTribulation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCTribulation.setText("109");
        CTribulation.add(lbCTribulation, java.awt.BorderLayout.CENTER);

        adminSN.add(CTribulation);

        CActor.setBackground(new java.awt.Color(255, 0, 102));
        CActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CActor.setPreferredSize(new java.awt.Dimension(140, 150));
        CActor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CActorMouseClicked(evt);
            }
        });
        CActor.setLayout(new java.awt.BorderLayout());

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel35.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        jLabel35.setText("Actor");
        jPanel20.add(jLabel35);

        CActor.add(jPanel20, java.awt.BorderLayout.PAGE_END);

        lbCActor.setFont(new java.awt.Font("SVN-Revolution", 0, 60)); // NOI18N
        lbCActor.setForeground(new java.awt.Color(255, 255, 255));
        lbCActor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCActor.setText("109");
        CActor.add(lbCActor, java.awt.BorderLayout.CENTER);

        adminSN.add(CActor);

        CEquipment.setBackground(new java.awt.Color(0, 204, 0));
        CEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CEquipment.setPreferredSize(new java.awt.Dimension(140, 150));
        CEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CEquipmentMouseClicked(evt);
            }
        });
        CEquipment.setLayout(new java.awt.BorderLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel37.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        jLabel37.setText("Equipment");
        jPanel23.add(jLabel37);

        CEquipment.add(jPanel23, java.awt.BorderLayout.PAGE_END);

        lbCEquipment.setFont(new java.awt.Font("SVN-Revolution", 0, 60)); // NOI18N
        lbCEquipment.setForeground(new java.awt.Color(255, 255, 255));
        lbCEquipment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCEquipment.setText("109");
        CEquipment.add(lbCEquipment, java.awt.BorderLayout.CENTER);

        adminSN.add(CEquipment);

        CRole.setBackground(new java.awt.Color(102, 0, 204));
        CRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CRole.setPreferredSize(new java.awt.Dimension(140, 150));
        CRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CRoleMouseClicked(evt);
            }
        });
        CRole.setLayout(new java.awt.BorderLayout());

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel39.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        jLabel39.setText("Role");
        jPanel30.add(jLabel39);

        CRole.add(jPanel30, java.awt.BorderLayout.PAGE_END);

        lbCRole.setFont(new java.awt.Font("SVN-Revolution", 0, 60)); // NOI18N
        lbCRole.setForeground(new java.awt.Color(255, 255, 255));
        lbCRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCRole.setText("109");
        CRole.add(lbCRole, java.awt.BorderLayout.CENTER);

        adminSN.add(CRole);

        NavStatistic.add(adminSN, java.awt.BorderLayout.PAGE_START);

        userSN.setBackground(new java.awt.Color(0, 0, 51));
        userSN.setPreferredSize(new java.awt.Dimension(140, 240));
        java.awt.FlowLayout flowLayout7 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 60, 40);
        flowLayout7.setAlignOnBaseline(true);
        userSN.setLayout(flowLayout7);

        CRoleContent.setBackground(new java.awt.Color(51, 102, 255));
        CRoleContent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CRoleContent.setPreferredSize(new java.awt.Dimension(140, 150));
        CRoleContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CRoleContentMouseClicked(evt);
            }
        });
        CRoleContent.setLayout(new java.awt.BorderLayout());

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel34.setFont(new java.awt.Font("SVN-SAF", 0, 20)); // NOI18N
        jLabel34.setText("ROLE");
        jPanel22.add(jLabel34);

        CRoleContent.add(jPanel22, java.awt.BorderLayout.PAGE_END);

        lbCRoleContent.setFont(new java.awt.Font("SVN-Revolution", 0, 70)); // NOI18N
        lbCRoleContent.setForeground(new java.awt.Color(255, 255, 255));
        lbCRoleContent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCRoleContent.setText("99");
        CRoleContent.add(lbCRoleContent, java.awt.BorderLayout.CENTER);

        userSN.add(CRoleContent);

        CFilmHistory.setBackground(new java.awt.Color(204, 0, 204));
        CFilmHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CFilmHistory.setPreferredSize(new java.awt.Dimension(140, 150));
        CFilmHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CFilmHistoryMouseClicked(evt);
            }
        });
        CFilmHistory.setLayout(new java.awt.BorderLayout());

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel36.setFont(new java.awt.Font("SVN-SAF", 0, 20)); // NOI18N
        jLabel36.setText("Film history");
        jPanel24.add(jLabel36);

        CFilmHistory.add(jPanel24, java.awt.BorderLayout.PAGE_END);

        lbCFilmHistory.setFont(new java.awt.Font("SVN-Revolution", 0, 70)); // NOI18N
        lbCFilmHistory.setForeground(new java.awt.Color(255, 255, 255));
        lbCFilmHistory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCFilmHistory.setText("99");
        CFilmHistory.add(lbCFilmHistory, java.awt.BorderLayout.CENTER);

        userSN.add(CFilmHistory);

        CShootingSchedule.setBackground(new java.awt.Color(0, 204, 153));
        CShootingSchedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CShootingSchedule.setPreferredSize(new java.awt.Dimension(140, 150));
        CShootingSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CShootingScheduleMouseClicked(evt);
            }
        });
        CShootingSchedule.setLayout(new java.awt.BorderLayout());

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel40.setFont(new java.awt.Font("SVN-SAF", 0, 20)); // NOI18N
        jLabel40.setText("schedule");
        jPanel44.add(jLabel40);

        CShootingSchedule.add(jPanel44, java.awt.BorderLayout.PAGE_END);

        lbCSchedule.setFont(new java.awt.Font("SVN-Revolution", 0, 70)); // NOI18N
        lbCSchedule.setForeground(new java.awt.Color(255, 255, 255));
        lbCSchedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCSchedule.setText("99");
        CShootingSchedule.add(lbCSchedule, java.awt.BorderLayout.CENTER);

        userSN.add(CShootingSchedule);

        NavStatistic.add(userSN, java.awt.BorderLayout.CENTER);

        ContainerStatiticNav.add(NavStatistic, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 0, 51), new java.awt.Color(0, 51, 255), new java.awt.Color(254, 254, 254), new java.awt.Color(254, 254, 254)));
        jPanel13.setPreferredSize(new java.awt.Dimension(721, 30));

        jLabel26.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_heart_outline_24px.png"))); // NOI18N

        jLabel29.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        jLabel29.setText("SE141120");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_copyright_24px.png"))); // NOI18N

        jLabel31.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        jLabel31.setText("2020");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel31)
                                        .addComponent(jLabel30)
                                        .addComponent(jLabel29)
                                        .addComponent(jLabel26)))
        );

        ContainerStatiticNav.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        containerDashboard.add(ContainerStatiticNav, java.awt.BorderLayout.CENTER);

        cardDashBoard.add(containerDashboard, java.awt.BorderLayout.CENTER);

        containerPanel.add(cardDashBoard, "cDB");

        cardMnTribulation.setBackground(new java.awt.Color(237, 237, 237));
        cardMnTribulation.setLayout(new java.awt.BorderLayout());

        tabTribulation.setBackground(new java.awt.Color(237, 237, 237));
        tabTribulation.setOpaque(false);
        tabTribulation.setPreferredSize(new java.awt.Dimension(584, 30));
        tabTribulation.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        tabb3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        tabb3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabb3.setOpaque(false);
        tabb3.setPreferredSize(new java.awt.Dimension(220, 30));
        tabb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabb3MouseClicked(evt);
            }
        });
        tabb3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel21.setBackground(new java.awt.Color(237, 237, 237));
        jLabel21.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_table_of_content_24px.png"))); // NOI18N
        jLabel21.setText("List Tribulation");
        tabb3.add(jLabel21);

        tabTribulation.add(tabb3);

        tabb4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabb4.setOpaque(false);
        tabb4.setPreferredSize(new java.awt.Dimension(220, 30));
        tabb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabb4MouseClicked(evt);
            }
        });
        java.awt.FlowLayout flowLayout3 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 2, 2);
        flowLayout3.setAlignOnBaseline(true);
        tabb4.setLayout(flowLayout3);

        jLabel23.setBackground(new java.awt.Color(237, 237, 237));
        jLabel23.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_maintenance_24px.png"))); // NOI18N
        jLabel23.setText("Used Equipment");
        tabb4.add(jLabel23);

        tabTribulation.add(tabb4);

        tabb5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabb5.setOpaque(false);
        tabb5.setPreferredSize(new java.awt.Dimension(220, 30));
        tabb5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabb5MouseClicked(evt);
            }
        });
        tabb5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 2));

        jLabel28.setBackground(new java.awt.Color(237, 237, 237));
        jLabel28.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_manager_24px.png"))); // NOI18N
        jLabel28.setText("Used Role");
        tabb5.add(jLabel28);

        tabTribulation.add(tabb5);
        tabb5.getAccessibleContext().setAccessibleName("");

        cardMnTribulation.add(tabTribulation, java.awt.BorderLayout.PAGE_START);

        containerTribulation.setBackground(new java.awt.Color(237, 237, 237));
        containerTribulation.setLayout(new java.awt.CardLayout());

        cardListTribulation.setLayout(new java.awt.BorderLayout());

        infoPanelTribulation.setPreferredSize(new java.awt.Dimension(605, 180));
        infoPanelTribulation.setLayout(new java.awt.BorderLayout());

        tribulationInfo.setBackground(new java.awt.Color(255, 255, 255));
        tribulationInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "More Infomation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 255))); // NOI18N
        tribulationInfo.setPreferredSize(new java.awt.Dimension(130, 180));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30);
        flowLayout2.setAlignOnBaseline(true);
        tribulationInfo.setLayout(flowLayout2);

        btnShowRoleByTID.setBackground(new java.awt.Color(204, 255, 255));
        btnShowRoleByTID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_management_24px.png"))); // NOI18N
        btnShowRoleByTID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowRoleByTID.setPreferredSize(new java.awt.Dimension(80, 40));
        btnShowRoleByTID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRoleByTIDActionPerformed(evt);
            }
        });
        tribulationInfo.add(btnShowRoleByTID);

        btnShowEquipmentByTID.setBackground(new java.awt.Color(255, 255, 255));
        btnShowEquipmentByTID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_maintenance_24px_1.png"))); // NOI18N
        btnShowEquipmentByTID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowEquipmentByTID.setPreferredSize(new java.awt.Dimension(80, 40));
        btnShowEquipmentByTID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowEquipmentByTIDActionPerformed(evt);
            }
        });
        tribulationInfo.add(btnShowEquipmentByTID);

        infoPanelTribulation.add(tribulationInfo, java.awt.BorderLayout.LINE_END);

        moreInfo.setBackground(new java.awt.Color(255, 255, 255));
        moreInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tribulation Infomation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 255))); // NOI18N

        lbTribulationName.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbTribulationName.setForeground(new java.awt.Color(0, 51, 255));
        lbTribulationName.setText("Tribulation Name:");

        txtTribulationName.setForeground(new java.awt.Color(255, 0, 51));
        txtTribulationName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        lbPlace.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbPlace.setForeground(new java.awt.Color(0, 51, 204));
        lbPlace.setText("Place:");

        txtPlace.setForeground(new java.awt.Color(255, 0, 51));
        txtPlace.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        lbStartDate.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbStartDate.setForeground(new java.awt.Color(0, 51, 255));
        lbStartDate.setText("Start Date:");

        lbEndDate.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbEndDate.setForeground(new java.awt.Color(0, 51, 204));
        lbEndDate.setText("End Date:");

        txtStartDate.setForeground(new java.awt.Color(255, 0, 51));
        txtStartDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 255)));

        txtEndDate.setForeground(new java.awt.Color(255, 0, 51));
        txtEndDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        jScrollTribulationDescription.setBackground(new java.awt.Color(255, 255, 255));
        jScrollTribulationDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tribulation Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        txtTribulationDescription.setColumns(20);
        txtTribulationDescription.setForeground(new java.awt.Color(255, 0, 51));
        txtTribulationDescription.setLineWrap(true);
        txtTribulationDescription.setRows(5);
        txtTribulationDescription.setWrapStyleWord(true);
        jScrollTribulationDescription.setViewportView(txtTribulationDescription);

        lbEndDate1.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbEndDate1.setForeground(new java.awt.Color(0, 51, 204));
        lbEndDate1.setText("Number of shoot:");

        txtNumOfShoot.setForeground(new java.awt.Color(255, 0, 51));
        txtNumOfShoot.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout moreInfoLayout = new javax.swing.GroupLayout(moreInfo);
        moreInfo.setLayout(moreInfoLayout);
        moreInfoLayout.setHorizontalGroup(
                moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(moreInfoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(moreInfoLayout.createSequentialGroup()
                                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbTribulationName)
                                                        .addComponent(lbPlace)
                                                        .addComponent(lbStartDate)
                                                        .addComponent(lbEndDate))
                                                .addGap(18, 18, 18)
                                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtPlace)
                                                        .addComponent(txtStartDate)
                                                        .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                                        .addComponent(txtTribulationName)))
                                        .addGroup(moreInfoLayout.createSequentialGroup()
                                                .addComponent(lbEndDate1)
                                                .addGap(22, 22, 22)
                                                .addComponent(txtNumOfShoot)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollTribulationDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        moreInfoLayout.setVerticalGroup(
                moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(moreInfoLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTribulationName)
                                        .addComponent(txtTribulationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbPlace)
                                        .addComponent(txtPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbStartDate)
                                        .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbEndDate)
                                        .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(moreInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbEndDate1)
                                        .addComponent(txtNumOfShoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(moreInfoLayout.createSequentialGroup()
                                .addComponent(jScrollTribulationDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 5, Short.MAX_VALUE))
        );

        infoPanelTribulation.add(moreInfo, java.awt.BorderLayout.CENTER);

        cardListTribulation.add(infoPanelTribulation, java.awt.BorderLayout.PAGE_START);

        tblTribulation.setBackground(new java.awt.Color(255, 255, 255));
        tblTribulation.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tribulation List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        tblTribulationView.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        tblTribulationView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Tribulation ID", "Tribulation Name", "Tribulation Description"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblTribulationView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTribulationView.setFocusable(false);
        tblTribulationView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblTribulationView.setOpaque(false);
        tblTribulationView.setRowHeight(25);
        tblTribulationView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblTribulationView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTribulationView.setShowGrid(false);
        tblTribulationView.getTableHeader().setReorderingAllowed(false);
        tblTribulationView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTribulationViewMouseClicked(evt);
            }
        });
        jScrolTribulation.setViewportView(tblTribulationView);
        tblTribulationView.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout tblTribulationLayout = new javax.swing.GroupLayout(tblTribulation);
        tblTribulation.setLayout(tblTribulationLayout);
        tblTribulationLayout.setHorizontalGroup(
                tblTribulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblTribulationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrolTribulation, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                .addContainerGap())
        );
        tblTribulationLayout.setVerticalGroup(
                tblTribulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblTribulationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrolTribulation, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                .addContainerGap())
        );

        cardListTribulation.add(tblTribulation, java.awt.BorderLayout.CENTER);

        controllerTribulation.setBackground(new java.awt.Color(255, 255, 255));
        controllerTribulation.setPreferredSize(new java.awt.Dimension(596, 50));
        controllerTribulation.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        btnNewTribulation.setBackground(new java.awt.Color(91, 192, 222));
        btnNewTribulation.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnNewTribulation.setForeground(new java.awt.Color(255, 255, 255));
        btnNewTribulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_loader_24px.png"))); // NOI18N
        btnNewTribulation.setText("New");
        btnNewTribulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewTribulation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewTribulationMouseClicked(evt);
            }
        });
        btnNewTribulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewTribulationActionPerformed(evt);
            }
        });
        controllerTribulation.add(btnNewTribulation);

        btnCreateTribulation.setBackground(new java.awt.Color(51, 255, 102));
        btnCreateTribulation.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnCreateTribulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_plus_24px_5.png"))); // NOI18N
        btnCreateTribulation.setText("Create");
        btnCreateTribulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateTribulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTribulationActionPerformed(evt);
            }
        });
        controllerTribulation.add(btnCreateTribulation);

        btnSearchTribulation.setBackground(new java.awt.Color(51, 112, 183));
        btnSearchTribulation.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnSearchTribulation.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchTribulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_24px_1.png"))); // NOI18N
        btnSearchTribulation.setText("Search");
        btnSearchTribulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchTribulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTribulationActionPerformed(evt);
            }
        });
        controllerTribulation.add(btnSearchTribulation);

        btnUpdateTribulation.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateTribulation.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnUpdateTribulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_update_left_rotation_24px_3.png"))); // NOI18N
        btnUpdateTribulation.setText("Update");
        btnUpdateTribulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateTribulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTribulationActionPerformed(evt);
            }
        });
        controllerTribulation.add(btnUpdateTribulation);

        btnDeleteTribulation.setBackground(new java.awt.Color(217, 83, 79));
        btnDeleteTribulation.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnDeleteTribulation.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteTribulation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnDeleteTribulation.setText("Delete");
        btnDeleteTribulation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteTribulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTribulationActionPerformed(evt);
            }
        });
        controllerTribulation.add(btnDeleteTribulation);

        cardListTribulation.add(controllerTribulation, java.awt.BorderLayout.PAGE_END);

        containerTribulation.add(cardListTribulation, "cardListTribulation");

        cardUsedEquip.setLayout(new java.awt.BorderLayout());

        selectInfo.setBackground(new java.awt.Color(255, 255, 255));
        selectInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Used Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        selectInfo.setPreferredSize(new java.awt.Dimension(675, 180));
        selectInfo.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel7.setOpaque(false);

        selectEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        selectEquipment.setForeground(new java.awt.Color(0, 51, 204));
        selectEquipment.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "IT6", "IT7", "IT8"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        selectEquipment.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        selectEquipment.setToolTipText("Choose one Equipment in list to add.");
        jScrollPane1.setViewportView(selectEquipment);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addContainerGap())
        );

        selectInfo.add(jPanel7);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tribulation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel5.setOpaque(false);

        selectTribulation.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        selectTribulation.setForeground(new java.awt.Color(0, 51, 204));
        selectTribulation.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        selectTribulation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        selectTribulation.setToolTipText("Choose one Tribulation in list to add.");
        jScrollPane2.setViewportView(selectTribulation);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addContainerGap())
        );

        selectInfo.add(jPanel5);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Quantity", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel8.setOpaque(false);

        selectQuantity.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 24)); // NOI18N
        selectQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        selectQuantity.setToolTipText("Select Quatity to add (Quantity must be greater than 0) ");
        selectQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selectQuantity.setEditor(new javax.swing.JSpinner.NumberEditor(selectQuantity, ""));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(selectQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(selectQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addContainerGap())
        );

        selectInfo.add(jPanel8);

        cardUsedEquip.add(selectInfo, java.awt.BorderLayout.PAGE_START);

        tblPanelUsedEquipment.setBackground(new java.awt.Color(255, 255, 255));
        tblPanelUsedEquipment.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Used Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        tblUsedEquimentView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Equipment", "Tribulation", "Quantity"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblUsedEquimentView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblUsedEquimentView.setFocusable(false);
        tblUsedEquimentView.setRowHeight(25);
        tblUsedEquimentView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblUsedEquimentView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblUsedEquimentView.setShowHorizontalLines(false);
        tblUsedEquimentView.setShowVerticalLines(false);
        tblUsedEquimentView.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblUsedEquimentView);

        javax.swing.GroupLayout tblPanelUsedEquipmentLayout = new javax.swing.GroupLayout(tblPanelUsedEquipment);
        tblPanelUsedEquipment.setLayout(tblPanelUsedEquipmentLayout);
        tblPanelUsedEquipmentLayout.setHorizontalGroup(
                tblPanelUsedEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblPanelUsedEquipmentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                .addContainerGap())
        );
        tblPanelUsedEquipmentLayout.setVerticalGroup(
                tblPanelUsedEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblPanelUsedEquipmentLayout.createSequentialGroup()
                                .addContainerGap(98, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95))
        );

        cardUsedEquip.add(tblPanelUsedEquipment, java.awt.BorderLayout.CENTER);

        controllerTribulation1.setBackground(new java.awt.Color(255, 255, 255));
        controllerTribulation1.setPreferredSize(new java.awt.Dimension(596, 50));
        controllerTribulation1.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        btnAddUsedEquipment.setBackground(new java.awt.Color(51, 255, 102));
        btnAddUsedEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnAddUsedEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_plus_24px_5.png"))); // NOI18N
        btnAddUsedEquipment.setText("Add");
        btnAddUsedEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUsedEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsedEquipmentActionPerformed(evt);
            }
        });
        controllerTribulation1.add(btnAddUsedEquipment);

        btnSearchUsedEquipment.setBackground(new java.awt.Color(51, 112, 183));
        btnSearchUsedEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnSearchUsedEquipment.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchUsedEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_24px_1.png"))); // NOI18N
        btnSearchUsedEquipment.setText("Search");
        btnSearchUsedEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchUsedEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUsedEquipmentActionPerformed(evt);
            }
        });
        controllerTribulation1.add(btnSearchUsedEquipment);

        btnDeleteUsedEquipment.setBackground(new java.awt.Color(217, 83, 79));
        btnDeleteUsedEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnDeleteUsedEquipment.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUsedEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnDeleteUsedEquipment.setText("Delete");
        btnDeleteUsedEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteUsedEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUsedEquipmentActionPerformed(evt);
            }
        });
        controllerTribulation1.add(btnDeleteUsedEquipment);

        cardUsedEquip.add(controllerTribulation1, java.awt.BorderLayout.PAGE_END);

        containerTribulation.add(cardUsedEquip, "cardUsedEquipment");

        cardUsedRole.setLayout(new java.awt.BorderLayout());

        selectInfo1.setBackground(new java.awt.Color(255, 255, 255));
        selectInfo1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Used Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        selectInfo1.setPreferredSize(new java.awt.Dimension(675, 180));
        selectInfo1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel9.setOpaque(false);

        selectRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        selectRole.setForeground(new java.awt.Color(0, 51, 204));
        selectRole.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        selectRole.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        selectRole.setToolTipText("Choose one Role in list to add.");
        jScrollPane5.setViewportView(selectRole);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addContainerGap())
        );

        selectInfo1.add(jPanel9);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tribulation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel6.setOpaque(false);

        selectTribulation1.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        selectTribulation1.setForeground(new java.awt.Color(0, 51, 204));
        selectTribulation1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        selectTribulation1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        selectTribulation1.setToolTipText("Choose one Tribulation in list to add.");
        jScrollPane4.setViewportView(selectTribulation1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addContainerGap())
        );

        selectInfo1.add(jPanel6);

        cardUsedRole.add(selectInfo1, java.awt.BorderLayout.PAGE_START);

        controllerTribulation2.setBackground(new java.awt.Color(255, 255, 255));
        controllerTribulation2.setPreferredSize(new java.awt.Dimension(596, 50));
        controllerTribulation2.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        btnAddUsedRole.setBackground(new java.awt.Color(51, 255, 102));
        btnAddUsedRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnAddUsedRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_plus_24px_5.png"))); // NOI18N
        btnAddUsedRole.setText("Add");
        btnAddUsedRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUsedRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsedRoleActionPerformed(evt);
            }
        });
        controllerTribulation2.add(btnAddUsedRole);

        btnSearchUsedRole.setBackground(new java.awt.Color(51, 112, 183));
        btnSearchUsedRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnSearchUsedRole.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchUsedRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_24px_1.png"))); // NOI18N
        btnSearchUsedRole.setText("Search");
        btnSearchUsedRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchUsedRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUsedRoleActionPerformed(evt);
            }
        });
        controllerTribulation2.add(btnSearchUsedRole);

        btnDeleteUsedRole.setBackground(new java.awt.Color(217, 83, 79));
        btnDeleteUsedRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnDeleteUsedRole.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteUsedRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnDeleteUsedRole.setText("Delete");
        btnDeleteUsedRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteUsedRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUsedRoleActionPerformed(evt);
            }
        });
        controllerTribulation2.add(btnDeleteUsedRole);

        cardUsedRole.add(controllerTribulation2, java.awt.BorderLayout.PAGE_END);

        tblPanelUsedRole.setBackground(new java.awt.Color(255, 255, 255));
        tblPanelUsedRole.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Used Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        tblUsedRoleView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Role", "Tribulation"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblUsedRoleView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblUsedRoleView.setFocusable(false);
        tblUsedRoleView.setRowHeight(25);
        tblUsedRoleView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblUsedRoleView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblUsedRoleView.setShowHorizontalLines(false);
        tblUsedRoleView.setShowVerticalLines(false);
        tblUsedRoleView.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblUsedRoleView);

        javax.swing.GroupLayout tblPanelUsedRoleLayout = new javax.swing.GroupLayout(tblPanelUsedRole);
        tblPanelUsedRole.setLayout(tblPanelUsedRoleLayout);
        tblPanelUsedRoleLayout.setHorizontalGroup(
                tblPanelUsedRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblPanelUsedRoleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                .addContainerGap())
        );
        tblPanelUsedRoleLayout.setVerticalGroup(
                tblPanelUsedRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblPanelUsedRoleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(180, Short.MAX_VALUE))
        );

        cardUsedRole.add(tblPanelUsedRole, java.awt.BorderLayout.CENTER);

        containerTribulation.add(cardUsedRole, "cardUsedRole");

        cardMnTribulation.add(containerTribulation, java.awt.BorderLayout.CENTER);

        containerPanel.add(cardMnTribulation, "cMKN");

        cardMnActor.setBackground(new java.awt.Color(237, 237, 237));
        cardMnActor.setLayout(new java.awt.BorderLayout());

        tabActor.setBackground(new java.awt.Color(237, 237, 237));
        tabActor.setPreferredSize(new java.awt.Dimension(596, 30));
        tabActor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        tabb1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        tabb1.setOpaque(false);
        tabb1.setPreferredSize(new java.awt.Dimension(230, 30));
        tabb1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel4.setBackground(new java.awt.Color(237, 237, 237));
        jLabel4.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_management_24px.png"))); // NOI18N
        jLabel4.setText("List Actor");
        tabb1.add(jLabel4);

        tabActor.add(tabb1);

        cardMnActor.add(tabActor, java.awt.BorderLayout.PAGE_START);

        containerActor.setLayout(new java.awt.CardLayout());

        listActor.setBackground(new java.awt.Color(237, 237, 237));
        listActor.setLayout(new java.awt.BorderLayout());

        detailActor.setOpaque(false);
        detailActor.setPreferredSize(new java.awt.Dimension(596, 180));
        detailActor.setLayout(new java.awt.BorderLayout());

        imgActor.setBackground(new java.awt.Color(255, 255, 255));
        imgActor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Image Actor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 255))); // NOI18N
        imgActor.setPreferredSize(new java.awt.Dimension(200, 150));

        imgActorView.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout imgActorViewLayout = new javax.swing.GroupLayout(imgActorView);
        imgActorView.setLayout(imgActorViewLayout);
        imgActorViewLayout.setHorizontalGroup(
                imgActorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        imgActorViewLayout.setVerticalGroup(
                imgActorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 110, Short.MAX_VALUE)
        );

        txtActorURLImage.setEditable(false);
        txtActorURLImage.setBackground(new java.awt.Color(255, 255, 255));
        txtActorURLImage.setForeground(new java.awt.Color(255, 0, 51));
        txtActorURLImage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 204)));

        btnActorOpenImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_opened_folder_24px.png"))); // NOI18N
        btnActorOpenImg.setToolTipText("Open File");
        btnActorOpenImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActorOpenImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActorOpenImgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgActorLayout = new javax.swing.GroupLayout(imgActor);
        imgActor.setLayout(imgActorLayout);
        imgActorLayout.setHorizontalGroup(
                imgActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imgActorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(imgActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imgActorView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(imgActorLayout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(btnActorOpenImg)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtActorURLImage, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        imgActorLayout.setVerticalGroup(
                imgActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imgActorLayout.createSequentialGroup()
                                .addComponent(imgActorView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(imgActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnActorOpenImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtActorURLImage))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        detailActor.add(imgActor, java.awt.BorderLayout.LINE_END);

        infoActor.setBackground(new java.awt.Color(255, 255, 255));
        infoActor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Infomation Actor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 255))); // NOI18N
        infoActor.setPreferredSize(new java.awt.Dimension(539, 180));

        lbNameActor.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbNameActor.setForeground(new java.awt.Color(0, 51, 255));
        lbNameActor.setText("Name:");

        lbPhone.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbPhone.setForeground(new java.awt.Color(0, 51, 255));
        lbPhone.setText("Phone:");

        lbEmail.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(0, 51, 255));
        lbEmail.setText("Email:");

        txtActorPhone.setForeground(new java.awt.Color(255, 0, 51));
        txtActorPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        txtActorEmail.setForeground(new java.awt.Color(255, 0, 51));
        txtActorEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        txtActorName.setForeground(new java.awt.Color(255, 0, 51));
        txtActorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        jScrollPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setOpaque(false);

        txtActorDescription.setColumns(20);
        txtActorDescription.setForeground(new java.awt.Color(255, 0, 51));
        txtActorDescription.setLineWrap(true);
        txtActorDescription.setRows(5);
        txtActorDescription.setWrapStyleWord(true);
        jScrollPane7.setViewportView(txtActorDescription);

        javax.swing.GroupLayout infoActorLayout = new javax.swing.GroupLayout(infoActor);
        infoActor.setLayout(infoActorLayout);
        infoActorLayout.setHorizontalGroup(
                infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoActorLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(infoActorLayout.createSequentialGroup()
                                                .addComponent(lbNameActor)
                                                .addGap(20, 20, 20)
                                                .addComponent(txtActorName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                        .addGroup(infoActorLayout.createSequentialGroup()
                                                .addGroup(infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbEmail)
                                                        .addComponent(lbPhone))
                                                .addGap(18, 18, 18)
                                                .addGroup(infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtActorPhone)
                                                        .addComponent(txtActorEmail))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
        );
        infoActorLayout.setVerticalGroup(
                infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoActorLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtActorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbNameActor))
                                .addGap(12, 12, 12)
                                .addGroup(infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbPhone)
                                        .addComponent(txtActorPhone))
                                .addGap(12, 12, 12)
                                .addGroup(infoActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbEmail)
                                        .addComponent(txtActorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                        .addGroup(infoActorLayout.createSequentialGroup()
                                .addComponent(jScrollPane7)
                                .addContainerGap())
        );

        detailActor.add(infoActor, java.awt.BorderLayout.CENTER);

        listActor.add(detailActor, java.awt.BorderLayout.PAGE_START);

        controllerDV.setBackground(new java.awt.Color(255, 255, 255));
        controllerDV.setPreferredSize(new java.awt.Dimension(596, 50));
        controllerDV.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        btnNewActor.setBackground(new java.awt.Color(91, 192, 222));
        btnNewActor.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnNewActor.setForeground(new java.awt.Color(255, 255, 255));
        btnNewActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_loader_24px.png"))); // NOI18N
        btnNewActor.setText("New");
        btnNewActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActorActionPerformed(evt);
            }
        });
        controllerDV.add(btnNewActor);

        btnCreateActor.setBackground(new java.awt.Color(51, 255, 102));
        btnCreateActor.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnCreateActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_plus_24px_5.png"))); // NOI18N
        btnCreateActor.setText("Create");
        btnCreateActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActorActionPerformed(evt);
            }
        });
        controllerDV.add(btnCreateActor);

        btnSearchActor.setBackground(new java.awt.Color(51, 112, 183));
        btnSearchActor.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnSearchActor.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_24px_1.png"))); // NOI18N
        btnSearchActor.setText("Search");
        btnSearchActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActorActionPerformed(evt);
            }
        });
        controllerDV.add(btnSearchActor);

        btnUpdateActor.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateActor.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnUpdateActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_update_left_rotation_24px_3.png"))); // NOI18N
        btnUpdateActor.setText("Update");
        btnUpdateActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActorActionPerformed(evt);
            }
        });
        controllerDV.add(btnUpdateActor);

        btnDeleteActor.setBackground(new java.awt.Color(217, 83, 79));
        btnDeleteActor.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnDeleteActor.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteActor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnDeleteActor.setText("Delete");
        btnDeleteActor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteActor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActorActionPerformed(evt);
            }
        });
        controllerDV.add(btnDeleteActor);

        listActor.add(controllerDV, java.awt.BorderLayout.PAGE_END);

        tblActor.setBackground(new java.awt.Color(255, 255, 255));
        tblActor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "List Actor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 102, 255))); // NOI18N

        tblActorView.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        tblActorView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Actor ID", "Actor Name", "Actor Username"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblActorView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblActorView.setFocusable(false);
        tblActorView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblActorView.setRowHeight(25);
        tblActorView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblActorView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblActorView.setShowGrid(true);
        tblActorView.setShowHorizontalLines(false);
        tblActorView.setShowVerticalLines(false);
        tblActorView.getTableHeader().setReorderingAllowed(false);
        tblActorView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblActorViewMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblActorViewMouseEntered(evt);
            }
        });
        jScrolActor.setViewportView(tblActorView);

        javax.swing.GroupLayout tblActorLayout = new javax.swing.GroupLayout(tblActor);
        tblActor.setLayout(tblActorLayout);
        tblActorLayout.setHorizontalGroup(
                tblActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblActorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrolActor, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                .addContainerGap())
        );
        tblActorLayout.setVerticalGroup(
                tblActorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblActorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrolActor, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                .addContainerGap())
        );

        listActor.add(tblActor, java.awt.BorderLayout.CENTER);

        containerActor.add(listActor, "dsDV");

        accountActor.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("List Account");
        jPanel1.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        accountActor.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel24.setText("jLabel24");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel24)
                                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel24)
                                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton2)
                                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        accountActor.add(jPanel2);

        containerActor.add(accountActor, "card3");

        cardMnActor.add(containerActor, java.awt.BorderLayout.CENTER);

        containerPanel.add(cardMnActor, "cMDV");

        cardMnEquipment.setBackground(new java.awt.Color(237, 237, 237));
        cardMnEquipment.setLayout(new java.awt.BorderLayout());

        tabEquipment.setBackground(new java.awt.Color(237, 237, 237));
        tabEquipment.setPreferredSize(new java.awt.Dimension(596, 30));
        tabEquipment.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        tabb6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        tabb6.setOpaque(false);
        tabb6.setPreferredSize(new java.awt.Dimension(300, 30));
        tabb6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel6.setBackground(new java.awt.Color(237, 237, 237));
        jLabel6.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_maintenance_24px.png"))); // NOI18N
        jLabel6.setText("Manage Equipment");
        tabb6.add(jLabel6);

        tabEquipment.add(tabb6);

        cardMnEquipment.add(tabEquipment, java.awt.BorderLayout.PAGE_START);

        containerEquipment.setLayout(new java.awt.CardLayout());

        listEquipment.setBackground(new java.awt.Color(237, 237, 237));
        listEquipment.setLayout(new java.awt.BorderLayout());

        detailEquipment.setOpaque(false);
        detailEquipment.setPreferredSize(new java.awt.Dimension(596, 180));
        detailEquipment.setLayout(new java.awt.BorderLayout());

        imgEquipment.setBackground(new java.awt.Color(255, 255, 255));
        imgEquipment.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Image Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 255))); // NOI18N
        imgEquipment.setPreferredSize(new java.awt.Dimension(200, 150));

        javax.swing.GroupLayout imgEquipmentViewLayout = new javax.swing.GroupLayout(imgEquipmentView);
        imgEquipmentView.setLayout(imgEquipmentViewLayout);
        imgEquipmentViewLayout.setHorizontalGroup(
                imgEquipmentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 168, Short.MAX_VALUE)
        );
        imgEquipmentViewLayout.setVerticalGroup(
                imgEquipmentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 109, Short.MAX_VALUE)
        );

        btnEquipmentOpenImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_opened_folder_24px.png"))); // NOI18N
        btnEquipmentOpenImg.setToolTipText("Open File");
        btnEquipmentOpenImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEquipmentOpenImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEquipmentOpenImgMouseClicked(evt);
            }
        });

        txtEquipmentURLImage.setForeground(new java.awt.Color(255, 0, 51));
        txtEquipmentURLImage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout imgEquipmentLayout = new javax.swing.GroupLayout(imgEquipment);
        imgEquipment.setLayout(imgEquipmentLayout);
        imgEquipmentLayout.setHorizontalGroup(
                imgEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgEquipmentLayout.createSequentialGroup()
                                .addGroup(imgEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(imgEquipmentLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(imgEquipmentView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(imgEquipmentLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnEquipmentOpenImg)
                                                .addGap(8, 8, 8)
                                                .addComponent(txtEquipmentURLImage, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        imgEquipmentLayout.setVerticalGroup(
                imgEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imgEquipmentLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imgEquipmentView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(imgEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imgEquipmentLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(txtEquipmentURLImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(imgEquipmentLayout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(btnEquipmentOpenImg)))
                                .addContainerGap())
        );

        detailEquipment.add(imgEquipment, java.awt.BorderLayout.LINE_END);

        infoEquipment.setBackground(new java.awt.Color(255, 255, 255));
        infoEquipment.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Infomation Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 255))); // NOI18N

        jScrollPane8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setOpaque(false);

        txtEquipmentDescription.setColumns(20);
        txtEquipmentDescription.setForeground(new java.awt.Color(255, 0, 51));
        txtEquipmentDescription.setLineWrap(true);
        txtEquipmentDescription.setRows(5);
        txtEquipmentDescription.setWrapStyleWord(true);
        jScrollPane8.setViewportView(txtEquipmentDescription);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Equipment Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        txtEquipmentName.setForeground(new java.awt.Color(255, 0, 51));
        txtEquipmentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));
        txtEquipmentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtEquipmentName, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtEquipmentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Quantity", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        txtEquipmentQuantity.setForeground(new java.awt.Color(255, 0, 51));
        txtEquipmentQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));
        txtEquipmentQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
                jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel35Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtEquipmentQuantity)
                                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
                jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEquipmentQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout infoEquipmentLayout = new javax.swing.GroupLayout(infoEquipment);
        infoEquipment.setLayout(infoEquipmentLayout);
        infoEquipmentLayout.setHorizontalGroup(
                infoEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoEquipmentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(infoEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        infoEquipmentLayout.setVerticalGroup(
                infoEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoEquipmentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(infoEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane8)
                                        .addGroup(infoEquipmentLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        detailEquipment.add(infoEquipment, java.awt.BorderLayout.CENTER);
        infoEquipment.getAccessibleContext().setAccessibleName("");

        listEquipment.add(detailEquipment, java.awt.BorderLayout.PAGE_START);

        controllerEquipment.setBackground(new java.awt.Color(255, 255, 255));
        controllerEquipment.setPreferredSize(new java.awt.Dimension(596, 50));
        controllerEquipment.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        btnNewEquipment.setBackground(new java.awt.Color(91, 192, 222));
        btnNewEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnNewEquipment.setForeground(new java.awt.Color(255, 255, 255));
        btnNewEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_loader_24px.png"))); // NOI18N
        btnNewEquipment.setText("New");
        btnNewEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewEquipmentActionPerformed(evt);
            }
        });
        controllerEquipment.add(btnNewEquipment);

        btnCreateEquipment.setBackground(new java.awt.Color(51, 255, 102));
        btnCreateEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnCreateEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_plus_24px_5.png"))); // NOI18N
        btnCreateEquipment.setText("Create");
        btnCreateEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEquipmentActionPerformed(evt);
            }
        });
        controllerEquipment.add(btnCreateEquipment);

        btnSearchEquipment.setBackground(new java.awt.Color(51, 112, 183));
        btnSearchEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnSearchEquipment.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_24px_1.png"))); // NOI18N
        btnSearchEquipment.setText("Search");
        btnSearchEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEquipmentActionPerformed(evt);
            }
        });
        controllerEquipment.add(btnSearchEquipment);

        btnUpdateEquipment.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnUpdateEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_update_left_rotation_24px_3.png"))); // NOI18N
        btnUpdateEquipment.setText("Update");
        btnUpdateEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEquipmentActionPerformed(evt);
            }
        });
        controllerEquipment.add(btnUpdateEquipment);

        btnDeleteEquipment.setBackground(new java.awt.Color(217, 83, 79));
        btnDeleteEquipment.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnDeleteEquipment.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteEquipment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnDeleteEquipment.setText("Delete");
        btnDeleteEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEquipmentActionPerformed(evt);
            }
        });
        controllerEquipment.add(btnDeleteEquipment);

        listEquipment.add(controllerEquipment, java.awt.BorderLayout.PAGE_END);

        tblEquipment.setBackground(new java.awt.Color(255, 255, 255));
        tblEquipment.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "List Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        tblEquipmentView.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        tblEquipmentView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Equipment ID", "Equipment Name", "Status"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblEquipmentView.setToolTipText("Choose one row at collum status to show more infomation");
        tblEquipmentView.setColumnSelectionAllowed(true);
        tblEquipmentView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblEquipmentView.setFocusable(false);
        tblEquipmentView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblEquipmentView.setRowHeight(25);
        tblEquipmentView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblEquipmentView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEquipmentView.setShowGrid(true);
        tblEquipmentView.setShowHorizontalLines(false);
        tblEquipmentView.setShowVerticalLines(false);
        tblEquipmentView.getTableHeader().setReorderingAllowed(false);
        tblEquipmentView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquipmentViewMouseClicked(evt);
            }
        });
        jScrolActor1.setViewportView(tblEquipmentView);

        javax.swing.GroupLayout tblEquipmentLayout = new javax.swing.GroupLayout(tblEquipment);
        tblEquipment.setLayout(tblEquipmentLayout);
        tblEquipmentLayout.setHorizontalGroup(
                tblEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblEquipmentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrolActor1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                .addContainerGap())
        );
        tblEquipmentLayout.setVerticalGroup(
                tblEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblEquipmentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrolActor1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                .addContainerGap())
        );

        listEquipment.add(tblEquipment, java.awt.BorderLayout.CENTER);

        containerEquipment.add(listEquipment, "dsEquipment");

        cardMnEquipment.add(containerEquipment, java.awt.BorderLayout.CENTER);

        containerPanel.add(cardMnEquipment, "cMDC");

        cardRole.setBackground(new java.awt.Color(237, 237, 237));
        cardRole.setLayout(new java.awt.BorderLayout());

        tabRole.setBackground(new java.awt.Color(237, 237, 237));
        tabRole.setPreferredSize(new java.awt.Dimension(596, 30));
        tabRole.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        tabb7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        tabb7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabb7.setOpaque(false);
        tabb7.setPreferredSize(new java.awt.Dimension(230, 30));
        tabb7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabb7MouseClicked(evt);
            }
        });
        tabb7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLabel5.setBackground(new java.awt.Color(237, 237, 237));
        jLabel5.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_management_24px.png"))); // NOI18N
        jLabel5.setText("List Role");
        tabb7.add(jLabel5);

        tabRole.add(tabb7);

        tabb8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabb8.setOpaque(false);
        tabb8.setPreferredSize(new java.awt.Dimension(230, 30));
        tabb8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabb8MouseClicked(evt);
            }
        });

        jLabel2324.setBackground(new java.awt.Color(237, 237, 237));
        jLabel2324.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        jLabel2324.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_management_24px.png"))); // NOI18N
        jLabel2324.setText("Cast To Role");
        jLabel2324.setOpaque(true);

        javax.swing.GroupLayout tabb8Layout = new javax.swing.GroupLayout(tabb8);
        tabb8.setLayout(tabb8Layout);
        tabb8Layout.setHorizontalGroup(
                tabb8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabb8Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel2324)
                                .addContainerGap(54, Short.MAX_VALUE))
        );
        tabb8Layout.setVerticalGroup(
                tabb8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tabb8Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2324)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabRole.add(tabb8);

        cardRole.add(tabRole, java.awt.BorderLayout.PAGE_START);

        containerRole.setLayout(new java.awt.CardLayout());

        listRole.setBackground(new java.awt.Color(237, 237, 237));
        listRole.setLayout(new java.awt.BorderLayout());

        controllerRole.setBackground(new java.awt.Color(255, 255, 255));
        controllerRole.setPreferredSize(new java.awt.Dimension(596, 50));
        controllerRole.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        btnNewRole.setBackground(new java.awt.Color(91, 192, 222));
        btnNewRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnNewRole.setForeground(new java.awt.Color(255, 255, 255));
        btnNewRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_loader_24px.png"))); // NOI18N
        btnNewRole.setText("New");
        btnNewRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRoleActionPerformed(evt);
            }
        });
        controllerRole.add(btnNewRole);

        btnCreateRole.setBackground(new java.awt.Color(51, 255, 102));
        btnCreateRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnCreateRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_plus_24px_5.png"))); // NOI18N
        btnCreateRole.setText("Create");
        btnCreateRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRoleActionPerformed(evt);
            }
        });
        controllerRole.add(btnCreateRole);

        btnSearchRole.setBackground(new java.awt.Color(51, 112, 183));
        btnSearchRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnSearchRole.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_24px_1.png"))); // NOI18N
        btnSearchRole.setText("Search");
        btnSearchRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchRoleActionPerformed(evt);
            }
        });
        controllerRole.add(btnSearchRole);

        btnUpdateRole.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnUpdateRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_update_left_rotation_24px_3.png"))); // NOI18N
        btnUpdateRole.setText("Update");
        btnUpdateRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRoleActionPerformed(evt);
            }
        });
        controllerRole.add(btnUpdateRole);

        btnDeleteRole.setBackground(new java.awt.Color(217, 83, 79));
        btnDeleteRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnDeleteRole.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnDeleteRole.setText("Delete");
        btnDeleteRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRoleActionPerformed(evt);
            }
        });
        controllerRole.add(btnDeleteRole);

        listRole.add(controllerRole, java.awt.BorderLayout.PAGE_END);

        infoRole.setLayout(new java.awt.GridLayout(1, 0));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "List Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        tblRoleView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null},
                        {null},
                        {null},
                        {null}
                },
                new String[]{
                        "Role Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblRoleView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRoleView.setFocusable(false);
        tblRoleView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblRoleView.setRowHeight(25);
        tblRoleView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblRoleView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRoleView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRoleView.setShowHorizontalLines(false);
        tblRoleView.setShowVerticalLines(false);
        tblRoleView.getTableHeader().setReorderingAllowed(false);
        tblRoleView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoleViewMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblRoleView);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                                .addContainerGap())
        );

        infoRole.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Infomation Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel2.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Name Role: ");

        txtRole.setForeground(new java.awt.Color(255, 0, 51));
        txtRole.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Description Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtRoleDescription.setColumns(20);
        txtRoleDescription.setForeground(new java.awt.Color(255, 0, 51));
        txtRoleDescription.setLineWrap(true);
        txtRoleDescription.setRows(5);
        txtRoleDescription.setWrapStyleWord(true);
        jScrollPane10.setViewportView(txtRoleDescription);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                        .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtRole)))
                                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                                .addContainerGap())
        );

        infoRole.add(jPanel16);

        listRole.add(infoRole, java.awt.BorderLayout.CENTER);

        containerRole.add(listRole, "cardListRole");

        castToRole.setLayout(new java.awt.BorderLayout());

        controllerCastToRole.setBackground(new java.awt.Color(255, 255, 255));
        controllerCastToRole.setPreferredSize(new java.awt.Dimension(596, 50));
        controllerCastToRole.setLayout(new java.awt.GridLayout(1, 6, 10, 0));

        btnUpdateCastRole.setBackground(new java.awt.Color(51, 255, 102));
        btnUpdateCastRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnUpdateCastRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_plus_24px_5.png"))); // NOI18N
        btnUpdateCastRole.setText("Update");
        btnUpdateCastRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateCastRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCastRoleActionPerformed(evt);
            }
        });
        controllerCastToRole.add(btnUpdateCastRole);

        btnSearchCastRole.setBackground(new java.awt.Color(51, 112, 183));
        btnSearchCastRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnSearchCastRole.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchCastRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_search_24px_1.png"))); // NOI18N
        btnSearchCastRole.setText("Search");
        btnSearchCastRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchCastRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCastRoleActionPerformed(evt);
            }
        });
        controllerCastToRole.add(btnSearchCastRole);

        btnDeleteCastRole.setBackground(new java.awt.Color(217, 83, 79));
        btnDeleteCastRole.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        btnDeleteCastRole.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCastRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnDeleteCastRole.setText("Delete");
        btnDeleteCastRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCastRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCastRoleActionPerformed(evt);
            }
        });
        controllerCastToRole.add(btnDeleteCastRole);

        castToRole.add(controllerCastToRole, java.awt.BorderLayout.PAGE_END);

        tblPanelCastToRole.setBackground(new java.awt.Color(255, 255, 255));
        tblPanelCastToRole.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cast to Role List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N

        tblCastToRoleView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "Role Name", "Actor Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblCastToRoleView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCastToRoleView.setFocusable(false);
        tblCastToRoleView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblCastToRoleView.setRowHeight(25);
        tblCastToRoleView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblCastToRoleView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCastToRoleView.setShowHorizontalLines(false);
        tblCastToRoleView.setShowVerticalLines(false);
        tblCastToRoleView.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(tblCastToRoleView);

        javax.swing.GroupLayout tblPanelCastToRoleLayout = new javax.swing.GroupLayout(tblPanelCastToRole);
        tblPanelCastToRole.setLayout(tblPanelCastToRoleLayout);
        tblPanelCastToRoleLayout.setHorizontalGroup(
                tblPanelCastToRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblPanelCastToRoleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                .addContainerGap())
        );
        tblPanelCastToRoleLayout.setVerticalGroup(
                tblPanelCastToRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(tblPanelCastToRoleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(180, Short.MAX_VALUE))
        );

        castToRole.add(tblPanelCastToRole, java.awt.BorderLayout.CENTER);

        selectInfoRole.setBackground(new java.awt.Color(255, 255, 255));
        selectInfoRole.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        selectInfoRole.setPreferredSize(new java.awt.Dimension(675, 180));
        selectInfoRole.setLayout(new java.awt.GridLayout(1, 0));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel11.setOpaque(false);

        selectRoleName.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        selectRoleName.setForeground(new java.awt.Color(0, 51, 204));
        selectRoleName.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        selectRoleName.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        selectRoleName.setToolTipText("Choose one Role in list to add.");
        jScrollPane12.setViewportView(selectRoleName);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addContainerGap())
        );

        selectInfoRole.add(jPanel11);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Actor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel12.setOpaque(false);

        tblCastRoleActorView.setForeground(new java.awt.Color(0, 51, 255));
        tblCastRoleActorView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String[]{
                        "ID Actor", "Actor Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblCastRoleActorView.setRowHeight(20);
        tblCastRoleActorView.setShowHorizontalLines(false);
        tblCastRoleActorView.setShowVerticalLines(false);
        jScrollPane13.setViewportView(tblCastRoleActorView);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addContainerGap())
        );

        selectInfoRole.add(jPanel12);

        castToRole.add(selectInfoRole, java.awt.BorderLayout.PAGE_START);

        containerRole.add(castToRole, "cardCastToRole");

        cardRole.add(containerRole, java.awt.BorderLayout.CENTER);

        containerPanel.add(cardRole, "cPCVD");

        cardStatisticEquipment.setBackground(new java.awt.Color(237, 237, 237));
        cardStatisticEquipment.setLayout(new java.awt.BorderLayout());

        lbTitle.setPreferredSize(new java.awt.Dimension(721, 60));

        jLabel9.setFont(new java.awt.Font("SVN-Revolution", 0, 24)); // NOI18N
        jLabel9.setText("Statistics Equipment");
        lbTitle.add(jLabel9);

        cardStatisticEquipment.add(lbTitle, java.awt.BorderLayout.PAGE_START);

        containerTblStatistics.setBackground(new java.awt.Color(255, 255, 255));
        containerTblStatistics.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "List Equipment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        containerTblStatistics.setLayout(new java.awt.BorderLayout());

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        tblListEquipmentView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Equipment Name", "Status", "From", "To"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblListEquipmentView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblListEquipmentView.setFocusable(false);
        tblListEquipmentView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblListEquipmentView.setRowHeight(25);
        tblListEquipmentView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblListEquipmentView.setShowHorizontalLines(false);
        tblListEquipmentView.setShowVerticalLines(false);
        tblListEquipmentView.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(tblListEquipmentView);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
                jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 709, Short.MAX_VALUE)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                        .addContainerGap()))
        );
        jPanel36Layout.setVerticalGroup(
                jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 542, Short.MAX_VALUE)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(179, Short.MAX_VALUE)))
        );

        containerTblStatistics.add(jPanel36, java.awt.BorderLayout.CENTER);

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Fittler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 102, 255))); // NOI18N
        jPanel37.setPreferredSize(new java.awt.Dimension(709, 110));
        jPanel37.setLayout(new java.awt.GridLayout(1, 0));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Select Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 255))); // NOI18N

        cbSelectStatus.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        cbSelectStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- Select Status ---", "Using", "Unusing"}));
        cbSelectStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSelectStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
                jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel40Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cbSelectStatus, 0, 200, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
                jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel40Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cbSelectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel37.add(jPanel40);

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Select Start Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 51, 255))); // NOI18N
        jPanel39.setToolTipText("Format (dd/mm/yyyy)");
        jPanel39.setLayout(new java.awt.BorderLayout());

        errorStartDate.setBackground(new java.awt.Color(255, 255, 255));
        errorStartDate.setPreferredSize(new java.awt.Dimension(220, 25));
        java.awt.FlowLayout flowLayout4 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 3, 1);
        flowLayout4.setAlignOnBaseline(true);
        errorStartDate.setLayout(flowLayout4);

        lbErrorSD.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        lbErrorSD.setForeground(new java.awt.Color(255, 255, 255));
        lbErrorSD.setText("Invalid Date(dd/mm/yyyy)");
        errorStartDate.add(lbErrorSD);

        jPanel39.add(errorStartDate, java.awt.BorderLayout.PAGE_START);

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        txtStatisticStartDate.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        txtStatisticStartDate.setForeground(new java.awt.Color(255, 0, 51));
        txtStatisticStartDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatisticStartDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 255)));
        txtStatisticStartDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtStatisticStartDate.setPreferredSize(new java.awt.Dimension(140, 30));
        txtStatisticStartDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStatisticStartDateKeyReleased(evt);
            }
        });
        jPanel42.add(txtStatisticStartDate);

        btnClearStartDate.setBackground(new java.awt.Color(255, 255, 255));
        btnClearStartDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px_1.png"))); // NOI18N
        btnClearStartDate.setEnabled(false);
        btnClearStartDate.setPreferredSize(new java.awt.Dimension(57, 30));
        btnClearStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearStartDateActionPerformed(evt);
            }
        });
        jPanel42.add(btnClearStartDate);

        jPanel39.add(jPanel42, java.awt.BorderLayout.CENTER);

        jPanel37.add(jPanel39);

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Select End Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 14), new java.awt.Color(0, 102, 255))); // NOI18N
        jPanel38.setLayout(new java.awt.BorderLayout());

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        txtStatisticEndDate.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        txtStatisticEndDate.setForeground(new java.awt.Color(255, 0, 51));
        txtStatisticEndDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatisticEndDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 255)));
        txtStatisticEndDate.setPreferredSize(new java.awt.Dimension(140, 30));
        txtStatisticEndDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStatisticEndDateKeyReleased(evt);
            }
        });
        jPanel43.add(txtStatisticEndDate);

        btnClearEndDate.setBackground(new java.awt.Color(255, 255, 255));
        btnClearEndDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px_1.png"))); // NOI18N
        btnClearEndDate.setEnabled(false);
        btnClearEndDate.setPreferredSize(new java.awt.Dimension(57, 30));
        btnClearEndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearEndDateActionPerformed(evt);
            }
        });
        jPanel43.add(btnClearEndDate);

        jPanel38.add(jPanel43, java.awt.BorderLayout.CENTER);

        errorEndDate.setBackground(new java.awt.Color(255, 255, 255));
        errorEndDate.setToolTipText("Format (dd/mm/yyyy)");
        errorEndDate.setPreferredSize(new java.awt.Dimension(220, 25));
        java.awt.FlowLayout flowLayout5 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 3, 1);
        flowLayout5.setAlignOnBaseline(true);
        errorEndDate.setLayout(flowLayout5);

        lbErrorED.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 18)); // NOI18N
        lbErrorED.setForeground(new java.awt.Color(255, 255, 255));
        lbErrorED.setText("Invalid Date(dd/mm/yyyy)");
        errorEndDate.add(lbErrorED);

        jPanel38.add(errorEndDate, java.awt.BorderLayout.PAGE_START);

        jPanel37.add(jPanel38);

        containerTblStatistics.add(jPanel37, java.awt.BorderLayout.PAGE_START);

        cardStatisticEquipment.add(containerTblStatistics, java.awt.BorderLayout.CENTER);

        containerPanel.add(cardStatisticEquipment, "cTKDC");

        cardRoleContent.setBackground(new java.awt.Color(237, 237, 237));
        cardRoleContent.setLayout(new java.awt.BorderLayout());

        containerRoleChoose.setBackground(new java.awt.Color(255, 255, 255));
        containerRoleChoose.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Choose a Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 255))); // NOI18N
        containerRoleChoose.setPreferredSize(new java.awt.Dimension(716, 200));

        jLabel11.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("Name Actor:");

        txtActorContentName.setEditable(false);
        txtActorContentName.setForeground(new java.awt.Color(255, 0, 51));
        txtActorContentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));
        txtActorContentName.setOpaque(false);

        tblRoleContentView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Role"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblRoleContentView.setToolTipText("Select one row to show Description");
        tblRoleContentView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRoleContentView.setFocusable(false);
        tblRoleContentView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblRoleContentView.setRowHeight(25);
        tblRoleContentView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblRoleContentView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRoleContentView.setShowHorizontalLines(false);
        tblRoleContentView.setShowVerticalLines(false);
        tblRoleContentView.getTableHeader().setReorderingAllowed(false);
        tblRoleContentView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoleContentViewMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblRoleContentView);

        javax.swing.GroupLayout containerRoleChooseLayout = new javax.swing.GroupLayout(containerRoleChoose);
        containerRoleChoose.setLayout(containerRoleChooseLayout);
        containerRoleChooseLayout.setHorizontalGroup(
                containerRoleChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(containerRoleChooseLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(containerRoleChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                        .addGroup(containerRoleChooseLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtActorContentName)))
                                .addContainerGap())
        );
        containerRoleChooseLayout.setVerticalGroup(
                containerRoleChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(containerRoleChooseLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(containerRoleChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtActorContentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        cardRoleContent.add(containerRoleChoose, java.awt.BorderLayout.PAGE_START);

        containerRoleDescription.setBackground(new java.awt.Color(255, 255, 255));
        containerRoleDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jScrollPane17.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtRoleContentDescription.setEditable(false);
        txtRoleContentDescription.setColumns(20);
        txtRoleContentDescription.setForeground(new java.awt.Color(255, 0, 102));
        txtRoleContentDescription.setLineWrap(true);
        txtRoleContentDescription.setRows(5);
        txtRoleContentDescription.setWrapStyleWord(true);
        jScrollPane17.setViewportView(txtRoleContentDescription);

        btnDownload.setBackground(new java.awt.Color(255, 255, 255));
        btnDownload.setFont(new java.awt.Font("SVN-Sunday", 0, 14)); // NOI18N
        btnDownload.setForeground(new java.awt.Color(0, 102, 255));
        btnDownload.setText("Download");
        btnDownload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerRoleDescriptionLayout = new javax.swing.GroupLayout(containerRoleDescription);
        containerRoleDescription.setLayout(containerRoleDescriptionLayout);
        containerRoleDescriptionLayout.setHorizontalGroup(
                containerRoleDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(containerRoleDescriptionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerRoleDescriptionLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
        );
        containerRoleDescriptionLayout.setVerticalGroup(
                containerRoleDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(containerRoleDescriptionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDownload)
                                .addContainerGap(181, Short.MAX_VALUE))
        );

        cardRoleContent.add(containerRoleDescription, java.awt.BorderLayout.CENTER);

        containerPanel.add(cardRoleContent, "cCVD");

        cardFilmedHistory.setBackground(new java.awt.Color(237, 237, 237));
        cardFilmedHistory.setLayout(new java.awt.GridLayout(1, 0));

        panelHistory.setBackground(new java.awt.Color(255, 255, 255));
        panelHistory.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filmed History", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        tblHistoryTribulationView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Tribulation ID", "Tribulation Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblHistoryTribulationView.setToolTipText("Select one row to show Information");
        tblHistoryTribulationView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblHistoryTribulationView.setFocusable(false);
        tblHistoryTribulationView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblHistoryTribulationView.setRowHeight(25);
        tblHistoryTribulationView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblHistoryTribulationView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblHistoryTribulationView.setShowHorizontalLines(false);
        tblHistoryTribulationView.setShowVerticalLines(false);
        tblHistoryTribulationView.getTableHeader().setReorderingAllowed(false);
        tblHistoryTribulationView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryTribulationViewMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblHistoryTribulationView);

        javax.swing.GroupLayout panelHistoryLayout = new javax.swing.GroupLayout(panelHistory);
        panelHistory.setLayout(panelHistoryLayout);
        panelHistoryLayout.setHorizontalGroup(
                panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHistoryLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelHistoryLayout.setVerticalGroup(
                panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHistoryLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                                .addContainerGap())
        );

        cardFilmedHistory.add(panelHistory);

        panelInfoHistory.setBackground(new java.awt.Color(255, 255, 255));
        panelInfoHistory.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Infomation Tribulation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tribulation Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        txtHTribulationName.setEditable(false);
        txtHTribulationName.setForeground(new java.awt.Color(255, 0, 51));
        txtHTribulationName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtHTribulationName)
                                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHTribulationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Place", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        txtHPlace.setEditable(false);
        txtHPlace.setForeground(new java.awt.Color(255, 0, 51));
        txtHPlace.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtHPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtHPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Start Date:");

        jLabel13.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("End Date:");

        txtHStartDate.setEditable(false);
        txtHStartDate.setForeground(new java.awt.Color(255, 0, 51));
        txtHStartDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        txtHEndDate.setEditable(false);
        txtHEndDate.setForeground(new java.awt.Color(255, 0, 51));
        txtHEndDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHStartDate)
                                        .addComponent(txtHEndDate))
                                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel27Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtHStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(txtHEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Number of shoot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        txtHNumbaerOfShoot.setEditable(false);
        txtHNumbaerOfShoot.setForeground(new java.awt.Color(255, 0, 51));
        txtHNumbaerOfShoot.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
                jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtHNumbaerOfShoot)
                                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
                jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(txtHNumbaerOfShoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane19.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        jScrollPane19.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtHDescription.setEditable(false);
        txtHDescription.setColumns(20);
        txtHDescription.setForeground(new java.awt.Color(255, 0, 51));
        txtHDescription.setLineWrap(true);
        txtHDescription.setRows(5);
        txtHDescription.setWrapStyleWord(true);
        jScrollPane19.setViewportView(txtHDescription);

        javax.swing.GroupLayout panelInfoHistoryLayout = new javax.swing.GroupLayout(panelInfoHistory);
        panelInfoHistory.setLayout(panelInfoHistoryLayout);
        panelInfoHistoryLayout.setHorizontalGroup(
                panelInfoHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInfoHistoryLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelInfoHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane19))
                                .addContainerGap())
        );
        panelInfoHistoryLayout.setVerticalGroup(
                panelInfoHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInfoHistoryLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                .addContainerGap())
        );

        cardFilmedHistory.add(panelInfoHistory);

        containerPanel.add(cardFilmedHistory, "cCLSKN");

        cardShootingSchedule.setBackground(new java.awt.Color(237, 237, 237));
        cardShootingSchedule.setLayout(new java.awt.GridLayout(1, 0));

        panelShooting.setBackground(new java.awt.Color(255, 255, 255));
        panelShooting.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Shooting Schedule", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        tblShootingScheduleView.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Tribulation ID", "Tribulation Name"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblShootingScheduleView.setToolTipText("Select one row to show Information");
        tblShootingScheduleView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblShootingScheduleView.setFocusable(false);
        tblShootingScheduleView.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblShootingScheduleView.setRowHeight(25);
        tblShootingScheduleView.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tblShootingScheduleView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblShootingScheduleView.setShowHorizontalLines(false);
        tblShootingScheduleView.setShowVerticalLines(false);
        tblShootingScheduleView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShootingScheduleViewMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tblShootingScheduleView);

        javax.swing.GroupLayout panelShootingLayout = new javax.swing.GroupLayout(panelShooting);
        panelShooting.setLayout(panelShootingLayout);
        panelShootingLayout.setHorizontalGroup(
                panelShootingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShootingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelShootingLayout.setVerticalGroup(
                panelShootingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShootingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                                .addContainerGap())
        );

        cardShootingSchedule.add(panelShooting);

        panelInfoShooting.setBackground(new java.awt.Color(255, 255, 255));
        panelInfoShooting.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Infomation Tribulation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tribulation Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        txtSTribulationName.setEditable(false);
        txtSTribulationName.setForeground(new java.awt.Color(255, 0, 51));
        txtSTribulationName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel31Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtSTribulationName)
                                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSTribulationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Place", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        txtSPlace.setEditable(false);
        txtSPlace.setForeground(new java.awt.Color(255, 0, 51));
        txtSPlace.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
                jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtSPlace, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
                jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtSPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));
        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        jLabel15.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Start Date:");

        jLabel27.setFont(new java.awt.Font("SVN-Linux Libertine", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 255));
        jLabel27.setText("End Date:");

        txtSStartDate.setEditable(false);
        txtSStartDate.setForeground(new java.awt.Color(255, 0, 51));
        txtSStartDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        txtSEndDate.setEditable(false);
        txtSEndDate.setForeground(new java.awt.Color(255, 0, 51));
        txtSEndDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel33Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel27))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSStartDate)
                                        .addComponent(txtSEndDate))
                                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel33Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(txtSStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(txtSEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Number of shoot", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N

        txtSNumberOfShoot.setEditable(false);
        txtSNumberOfShoot.setForeground(new java.awt.Color(255, 0, 51));
        txtSNumberOfShoot.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
                jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtSNumberOfShoot)
                                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
                jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                                .addComponent(txtSNumberOfShoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane21.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("SVN-Linux Libertine", 0, 18), new java.awt.Color(0, 51, 204))); // NOI18N
        jScrollPane21.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtSDescription.setEditable(false);
        txtSDescription.setColumns(20);
        txtSDescription.setForeground(new java.awt.Color(255, 0, 51));
        txtSDescription.setLineWrap(true);
        txtSDescription.setRows(5);
        txtSDescription.setWrapStyleWord(true);
        jScrollPane21.setViewportView(txtSDescription);

        javax.swing.GroupLayout panelInfoShootingLayout = new javax.swing.GroupLayout(panelInfoShooting);
        panelInfoShooting.setLayout(panelInfoShootingLayout);
        panelInfoShootingLayout.setHorizontalGroup(
                panelInfoShootingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInfoShootingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelInfoShootingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane21))
                                .addContainerGap())
        );
        panelInfoShootingLayout.setVerticalGroup(
                panelInfoShootingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInfoShootingLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                .addContainerGap())
        );

        cardShootingSchedule.add(panelInfoShooting);

        containerPanel.add(cardShootingSchedule, "cCLSQ");

        getContentPane().add(containerPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMousePressed
        offsetX = evt.getX();
        offsetY = evt.getY();
    }//GEN-LAST:event_titleBarMousePressed

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMouseDragged
        this.setLocation(evt.getXOnScreen() - offsetX, evt.getYOnScreen() - offsetY);
    }//GEN-LAST:event_titleBarMouseDragged

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.HIDE_ON_CLOSE);

    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void navLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navLogoutMouseClicked
        this.dispose();
        new LoginJFrame().setVisible(true);
    }//GEN-LAST:event_navLogoutMouseClicked

    private void navDashBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navDashBoardMouseClicked
        setUnVisit();
        navDashBoard.setBackground(new java.awt.Color(237, 237, 237));
        titleDashBoard.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cDB");
        try {
            updateDashBoardADMIN();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_navDashBoardMouseClicked

    private void navManageTribulationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navManageTribulationMouseClicked
        setUnVisit();
        navManageTribulation.setBackground(new java.awt.Color(237, 237, 237));
        titleTribulation.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cMKN");
        tabb3MouseClicked(evt);
    }//GEN-LAST:event_navManageTribulationMouseClicked

    private void navManageActorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navManageActorMouseClicked
        setUnVisit();
        navManageActor.setBackground(new java.awt.Color(237, 237, 237));
        titleMnActor.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cMDV");
        try {
            updateListActor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_navManageActorMouseClicked

    private void navManageEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navManageEquipmentMouseClicked
        setUnVisit();
        statusNewEquipment = 1;
        navManageEquipment.setBackground(new java.awt.Color(237, 237, 237));
        titleMnEquipment.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cMDC");
        try {
            updateEquipment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_navManageEquipmentMouseClicked

    private void navManageRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navManageRoleMouseClicked
        setUnVisit();
        navManageRole.setBackground(new java.awt.Color(237, 237, 237));
        titleMnRole.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cPCVD");
        tabb7MouseClicked(evt);
        try {
            updateRole();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_navManageRoleMouseClicked

    private void navStatisticsEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navStatisticsEquipmentMouseClicked
        setUnVisit();
        navStatisticsEquipment.setBackground(new java.awt.Color(237, 237, 237));
        titleStatisticsEquipment.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cTKDC");
        try {
            updateStatistic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_navStatisticsEquipmentMouseClicked

    private void navRoleContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navRoleContentMouseClicked
        setUnVisit();
        navRoleContent.setBackground(new java.awt.Color(237, 237, 237));
        titleRoleContent.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cCVD");
        try {
            updateRoleContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_navRoleContentMouseClicked

    private void navShootingScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navShootingScheduleMouseClicked
        setUnVisit();
        navShootingSchedule.setBackground(new java.awt.Color(237, 237, 237));
        titleShootingSchedule.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cCLSQ");
        try {
            updateListTribulationSchedule();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_navShootingScheduleMouseClicked

    private void navFilmedHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navFilmedHistoryMouseClicked
        setUnVisit();
        navFilmedHistory.setBackground(new java.awt.Color(237, 237, 237));
        titleFilmedHistory.setForeground(new java.awt.Color(243, 106, 90));
        navCardLayout.show(containerPanel, "cCLSKN");
        try {
            updateListTribulationHistory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_navFilmedHistoryMouseClicked

    private void btnUpdateActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActorActionPerformed
        ActorDTO dto = null;
        int row, id = 0;
        try {
            row = tblActorView.getSelectedRow();
            id = (int) tblModelActor.getValueAt(row, 0);
            dto = getInfoActor();
            dto.setActorUsername((String) tblModelActor.getValueAt(row, 2));
        } catch (ArrayIndexOutOfBoundsException dd) {
            JOptionPane.showMessageDialog(this, " ! Please select one row to Update");
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        try {
            ActorDAO dao = new ActorDAO();
            if (dao.updateActorByID(id, dto)) {
                JOptionPane.showMessageDialog(this, "Update Sucsess");
                updateListActor();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update Fail");
        }

    }//GEN-LAST:event_btnUpdateActorActionPerformed

    private void btnUpdateTribulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTribulationActionPerformed
        TribulationDTO dto = null;
        int row, id = 0;
        try {
            row = tblTribulationView.getSelectedRow();
            id = (int) tblModelTribulation.getValueAt(row, 0);
            dto = getInfoTribulation();
        } catch (ArrayIndexOutOfBoundsException dd) {
            JOptionPane.showMessageDialog(this, "! Please select one Row in List to Update");
            return;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        try {
            TribulationDAO tribulationDAO = new TribulationDAO();
            if (tribulationDAO.updateTribulation(id, dto)) {
                updateListTribulation();
                JOptionPane.showMessageDialog(this, "Update Success");
                btnNewTribulationActionPerformed(evt);
            }
        } catch (Exception e) {
            btnNewTribulationActionPerformed(evt);

            if (e.getMessage().contains("Date is duplicate in other Tribulation")) {
                JOptionPane.showMessageDialog(this, "Date is duplicate in other Tribulation");
                return;
            }
            if (e.getMessage().contains("duplicate")) {
                JOptionPane.showMessageDialog(this, dto.getTribulationName() + " Tribulation is existed.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Update Fail");
        }


    }//GEN-LAST:event_btnUpdateTribulationActionPerformed

    private void tabb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabb3MouseClicked
        tabb3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        tabb4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        tabb5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        cardTribulation.show(containerTribulation, "cardListTribulation");
        try {
            updateListTribulation();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tabb3MouseClicked

    private void tabb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabb4MouseClicked
        tabb4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        tabb3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        tabb5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        cardTribulation.show(containerTribulation, "cardUsedEquipment");
        try {
            updateUsedEquipment();
            updateEquipment();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tabb4MouseClicked

    private void tabb5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabb5MouseClicked
        tabb5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        tabb4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        tabb3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        cardTribulation.show(containerTribulation, "cardUsedRole");
        try {
            updateRole();
            updateUsedRole();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tabb5MouseClicked

    private void txtEquipmentQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentQuantityActionPerformed

    private void txtEquipmentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentNameActionPerformed

    private void btnUpdateEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEquipmentActionPerformed
        int row, id;
        EquipmentDTO dto = null;
        try {
            row = tblEquipmentView.getSelectedRow();
            id = (int) tblModelEquipment.getValueAt(row, 0);
            dto = getInfoEquipment();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one row to Update");
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
        try {
            EquipmentDAO dao = new EquipmentDAO();
            if (dao.updateEquipmentByID(id, dto)) {
                JOptionPane.showMessageDialog(this, "Update Success");
                updateEquipment();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update Fail");
        }


    }//GEN-LAST:event_btnUpdateEquipmentActionPerformed

    private void btnUpdateRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRoleActionPerformed
        int row;
        String roleName;
        RoleDTO dto = null;
        try {
            row = tblRoleView.getSelectedRow();
            roleName = (String) tblModelRole.getValueAt(row, 0);
            dto = getInfoRole();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one row to Update");
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
        try {
            RoleDAO dao = new RoleDAO();
            if (dao.updateRoleByName(roleName, dto)) {
                updateRole();
                JOptionPane.showMessageDialog(this, "Update Success");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update Fail");
        }
    }//GEN-LAST:event_btnUpdateRoleActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        if (navLeft.isVisible()) {
            navLeft.setVisible(false);
        } else {
            navLeft.setVisible(true);
        }

    }//GEN-LAST:event_jLabel12MouseClicked

    private void btnShowRoleByTIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRoleByTIDActionPerformed
        try {
            int row = tblTribulationView.getSelectedRow();
            int id = (int) tblModelTribulation.getValueAt(row, 0);
            new ShowTable().RoleInit(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one row to show");

        }
    }//GEN-LAST:event_btnShowRoleByTIDActionPerformed

    private void tabb7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabb7MouseClicked
        cardLRole.show(containerRole, "cardListRole");
        tabb8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        tabb7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        try {
            updateRole();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tabb7MouseClicked

    private void tabb8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabb8MouseClicked
        cardLRole.show(containerRole, "cardCastToRole");
        tabb7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 102, 255)));
        tabb8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 102, 255)));
        try {
            updateSelectActor();
            updateListCastRole();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tabb8MouseClicked

    private void tblTribulationViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTribulationViewMouseClicked
        int row = tblTribulationView.getSelectedRow();
        try {
            statusNewTribulation = 0;
            int id = (int) tblModelTribulation.getValueAt(row, 0);
            TribulationDAO dao = new TribulationDAO();
            TribulationDTO dto = dao.getTribulationByID(id);
            txtTribulationName.setText(dto.getTribulationName());
            txtPlace.setText(dto.getPlace());
            txtStartDate.setText(dto.getStartDate().toLocalDate().format(df));
            txtEndDate.setText(dto.getEndDate().toLocalDate().format(df));
            txtNumOfShoot.setText(dto.getNumberOfShoot() + "");
            txtTribulationDescription.setText(dto.getDescription());
            btnShowRoleByTID.setEnabled(true);
            btnShowEquipmentByTID.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tblTribulationViewMouseClicked

    private void tblActorViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActorViewMouseClicked

        int row = tblActorView.getSelectedRow();
        statusNewActor = 0;
        int actorID = (int) tblModelActor.getValueAt(row, 0);
        try {
            ActorDAO actorDAO = new ActorDAO();
            ActorDTO dto = actorDAO.getActorByID(actorID);
            txtActorName.setText(dto.getActorName());
            txtActorPhone.setText(dto.getPhone());
            txtActorEmail.setText(dto.getEmail());
            txtActorDescription.setText(dto.getDescription());
            File f = null;
            try {
                f = new File(dto.getImage());
            } catch (Exception e) {
                f = new File("imgActor/noimg.jpg");
            }

            if (!f.getName().equals("noimg.jpg")) {
                txtActorURLImage.setText(f.getName());
            } else {
                txtActorURLImage.setText(" ! No Image");
            }
            txtActorURLImage.setEditable(false);
            img = ImageIO.read(f);
            imgActorGraphics.drawImage(img, 0, 0, imgActorView.getWidth(), imgActorView.getHeight(), imgActorView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblActorViewMouseClicked

    private void tblEquipmentViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquipmentViewMouseClicked
        int row = tblEquipmentView.getSelectedRow();
        statusNewEquipment = 0;
        int equipmentID = (int) tblModelEquipment.getValueAt(row, 0);
        int col = tblEquipmentView.getSelectedColumn();
        if (col == 2) {
            new ShowTable().TribulationInit(equipmentID);
        }
        try {
            EquipmentDAO equipmentDAO = new EquipmentDAO();
            EquipmentDTO dto = equipmentDAO.getEquipmentByID(equipmentID);
            txtEquipmentName.setText(dto.getEquipmentName());
            txtEquipmentQuantity.setText(dto.getQuantity() + "");
            txtEquipmentDescription.setText(dto.getDescription());
            File f = null;
            try {
                f = new File(dto.getImage());
            } catch (Exception e) {
                f = new File("imgEquipment/noimg.jpg");
            }
            if (!f.getName().equals("noimg.jpg")) {
                txtEquipmentURLImage.setText(f.getName());
            } else {
                txtEquipmentURLImage.setText(" ! No Image");
            }
            txtActorURLImage.setEditable(false);
            img = ImageIO.read(f);
            imgEquipmentGraphics.drawImage(img, 0, 0, imgEquipmentView.getWidth(), imgEquipmentView.getHeight(), imgEquipmentView);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblEquipmentViewMouseClicked

    private void tblRoleViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoleViewMouseClicked
        int row = tblRoleView.getSelectedRow();
        String roleName = (String) tblModelRole.getValueAt(row, 0);
        statusNewRole = 0;
        try {
            RoleDAO roleDAO = new RoleDAO();
            RoleDTO dto = roleDAO.getRole(roleName);
            txtRole.setText(roleName);
            txtRoleDescription.setText(FileDAO.readFile("RoleContent/" + dto.getDescription() + ".txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblRoleViewMouseClicked

    private void btnCreateTribulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTribulationActionPerformed
        TribulationDTO dto = null;
        try {
            if (statusNewTribulation == 0) {
                throw new Exception(" ! Press New button before Create ");
            }
            dto = getInfoTribulation();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
        try {
            TribulationDAO dao = new TribulationDAO();
            if (dao.createTribulation(dto)) {
                updateListTribulation();
                JOptionPane.showMessageDialog(this, "Insert success");
                btnNewTribulationActionPerformed(evt);
            }
        } catch (Exception e) {
            btnNewTribulationActionPerformed(evt);

            if (e.getMessage().contains("Date is exist in other Tribulation")) {
                JOptionPane.showMessageDialog(this, "Date is duplicate in other Tribulation");
                return;
            }
            if (e.getMessage().contains("duplicate")) {
                JOptionPane.showMessageDialog(this, dto.getTribulationName() + " Tribulation is existed.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Insert Fail");
        }


    }//GEN-LAST:event_btnCreateTribulationActionPerformed

    private void btnDeleteTribulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTribulationActionPerformed

        try {
            int row = tblTribulationView.getSelectedRow();
            int id = (int) tblModelTribulation.getValueAt(row, 0);
            TribulationDAO tribulationDAO = new TribulationDAO();
            if (tribulationDAO.deleteTribulation(id)) {
                updateListTribulation();
                JOptionPane.showMessageDialog(this, "Delete Success");
                btnNewTribulationActionPerformed(evt);
            }
        } catch (ArrayIndexOutOfBoundsException dd) {
            JOptionPane.showMessageDialog(this, "! Please select one row to delete");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Delete Fail");
        }
    }//GEN-LAST:event_btnDeleteTribulationActionPerformed

    private void btnSearchTribulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTribulationActionPerformed
        String value = JOptionPane.showInputDialog(this, "Enter Tribulation Name To Search:\n(Input Value to Search, Press Cancel to show all)", "Search Box", JOptionPane.QUESTION_MESSAGE);
        try {
            if (value == null) {
                updateListTribulation();
            } else {
                if (!value.equals("")) {
                    TribulationDAO tribulationDAO = new TribulationDAO();
                    List<TribulationDTO> listTribulation = tribulationDAO.getTribulationByName(value.trim());
                    showListTribulation(listTribulation);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchTribulationActionPerformed

    private void btnNewActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActorActionPerformed
        JTextField[] actorField = {txtActorName, txtActorPhone, txtActorEmail, txtActorURLImage};
        for (JTextField jTextField : actorField) {
            jTextField.setText("");
        }
        txtActorDescription.setText("");
        txtActorPathImg.setText("");
        imgActorGraphics.clearRect(0, 0, imgActorView.getWidth(), imgActorView.getHeight());
        tblActorView.clearSelection();
        statusNewActor = 1;
    }//GEN-LAST:event_btnNewActorActionPerformed

    private void btnNewEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewEquipmentActionPerformed
        txtEquipmentName.setText("");
        txtEquipmentQuantity.setText("");
        txtEquipmentDescription.setText("");
        txtEquipmentURLImage.setText("");
        txtEquipmentPathImg.setText("");
        imgEquipmentGraphics.clearRect(0, 0, imgEquipmentView.getWidth(), imgEquipmentView.getHeight());
        tblEquipmentView.clearSelection();
        statusNewEquipment = 1;
    }//GEN-LAST:event_btnNewEquipmentActionPerformed

    private void btnCreateActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActorActionPerformed
        ActorDTO dto = null;
        try {
            if (statusNewActor == 0) {
                throw new Exception(" ! Please press New button before create actor");
            }
            dto = getInfoActor();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        try {
            ActorDAO actorDAO = new ActorDAO();
            UserDAO userDAO = new UserDAO();
            dto.setActorUsername(userDAO.AutoRegistration().getUsername());
            if (actorDAO.createActor(dto)) {
                updateListActor();
                JOptionPane.showMessageDialog(this, "Insert Succes.\nUsername: " + dto.getActorUsername() + "\n Default Password for Actor: 123");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Insert Fail");
        }
    }//GEN-LAST:event_btnCreateActorActionPerformed

    private void btnDeleteActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActorActionPerformed
        try {
            int row = tblActorView.getSelectedRow();
            int id = (int) tblModelActor.getValueAt(row, 0);
            String username = (String) tblModelActor.getValueAt(row, 2);
            ActorDAO dao = new ActorDAO();
            if (dao.deleteActorByID(id, username, txtActorURLImage.getText())) {
                JOptionPane.showMessageDialog(this, "Delete Success");
                updateListActor();
                tblActorView.clearSelection();
                btnNewActorActionPerformed(evt);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, " ! Please select one row to delete");
            return;
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(this, ee.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActorActionPerformed

    private void btnAddUsedEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsedEquipmentActionPerformed
        UsedEquipmentDTO dto = new UsedEquipmentDTO();

        int quantity = 0, equipmentID, tribulationID;
        try {
            if (selectEquipment.isSelectionEmpty()) {
                throw new Exception(" ! Please select one Equipment to add.");
            }
            if (selectTribulation.isSelectionEmpty()) {
                throw new Exception(" ! Please select one Tribulation to add.");
            }
            dto.setEquipmentName(selectEquipment.getSelectedValue());
            dto.setTribulationName(selectTribulation.getSelectedValue());
            dto.setQuantity((int) selectQuantity.getValue());
            if (dto.getQuantity() < 1) {
                throw new Exception(" ! Please input Quantity is number and more than 1.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        try {
            EquipmentDAO equipmentDAO = new EquipmentDAO();
            TribulationDAO tribulationDAO = new TribulationDAO();
            dto.setEquipmentID(equipmentDAO.getIDByName(dto.getEquipmentName()));
            dto.setTribulationID(tribulationDAO.getIDbyName(dto.getTribulationName()));
            UsedEquipmentDAO dao = new UsedEquipmentDAO();
            if (dao.addUsedEquipment(dto)) {
                JOptionPane.showMessageDialog(this, "Add sucsess");
                updateUsedEquipment();
                selectEquipment.clearSelection();
                selectQuantity.setValue(0);
            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                JOptionPane.showMessageDialog(this, "Equipment " + dto.getEquipmentName() + " is existed in " + dto.getTribulationName() + " Tribulation");
                return;
            }
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
    }//GEN-LAST:event_btnAddUsedEquipmentActionPerformed

    private void btnDeleteUsedEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUsedEquipmentActionPerformed
        UsedEquipmentDTO dto = new UsedEquipmentDTO();

        try {
            int row = tblUsedEquimentView.getSelectedRow();
            dto.setEquipmentName((String) tblModelUsedEquipment.getValueAt(row, 0));
            dto.setTribulationName((String) tblModelUsedEquipment.getValueAt(row, 1));
            dto.setQuantity((int) tblModelUsedEquipment.getValueAt(row, 2));
            EquipmentDAO equipmentDAO = new EquipmentDAO();
            TribulationDAO tribulationDAO = new TribulationDAO();
            dto.setEquipmentID(equipmentDAO.getIDByName(dto.getEquipmentName()));
            dto.setTribulationID(tribulationDAO.getIDbyName(dto.getTribulationName()));
        } catch (ArrayIndexOutOfBoundsException dd) {
            JOptionPane.showMessageDialog(this, " ! Please select one row to Delete.");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Delete Faid !");
            return;
        }
        try {
            UsedEquipmentDAO dao = new UsedEquipmentDAO();
            if (dao.deleteUsedEquipment(dto)) {
                JOptionPane.showMessageDialog(this, "Delete Success");
                updateUsedEquipment();
                selectTribulation.clearSelection();
                selectEquipment.clearSelection();
                selectQuantity.setValue(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnDeleteUsedEquipmentActionPerformed

    private void btnAddUsedRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsedRoleActionPerformed
        UsedRoleDTO dto = null;
        try {
            if (selectRole.isSelectionEmpty()) {
                throw new Exception(" ! Please select one Role to Add.");
            }
            if (selectTribulation1.isSelectionEmpty()) {
                throw new Exception(" ! Please select one Tribulation to Add.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        dto = new UsedRoleDTO(selectTribulation1.getSelectedValue(), selectRole.getSelectedValue());
        try {
            TribulationDAO tribulationDAO = new TribulationDAO();
            dto.setId(tribulationDAO.getIDbyName(dto.getTribulationName()));

            UsedRoleDAO dao = new UsedRoleDAO();
            if (dao.addUsedRole(dto)) {
                JOptionPane.showMessageDialog(this, "Add Sucsess.");
                updateUsedRole();
                selectTribulation1.clearSelection();
            }

        } catch (Exception e) {
            selectRole.clearSelection();
            selectTribulation1.clearSelection();
            if (e.getMessage().contains("duplicate")) {
                JOptionPane.showMessageDialog(this, "! Role " + dto.getRoleName() + " is existed in " + dto.getTribulationName() + " Tribulation.");

                return;
            }
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnAddUsedRoleActionPerformed

    private void btnDeleteUsedRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUsedRoleActionPerformed
        UsedRoleDTO dto = null;
        try {
            int row = tblUsedRoleView.getSelectedRow();
            String roleName = (String) tblModelUsedRole.getValueAt(row, 0);
            String tribulationName = (String) tblModelUsedRole.getValueAt(row, 1);
            dto = new UsedRoleDTO(tribulationName, roleName);
            TribulationDAO tribulationDAO = new TribulationDAO();
            dto.setId(tribulationDAO.getIDbyName(dto.getTribulationName()));

        } catch (ArrayIndexOutOfBoundsException dd) {
            JOptionPane.showMessageDialog(this, " ! Please select one row to delete");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UsedRoleDAO dao = new UsedRoleDAO();
            if (dao.deleteUsedRole(dto)) {
                JOptionPane.showMessageDialog(this, " Delete Sucsess");
                updateUsedRole();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnDeleteUsedRoleActionPerformed

    private void btnCreateEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEquipmentActionPerformed
        EquipmentDTO dto = null;
        try {
            if (statusNewActor == 0) {
                throw new Exception(" ! Please press New button before create actor");
            }
            dto = getInfoEquipment();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }

        try {
            EquipmentDAO dao = new EquipmentDAO();
            if (dao.createEquipment(dto)) {
                JOptionPane.showMessageDialog(this, "Create Success");
                updateEquipment();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Create Faid");

        }
    }//GEN-LAST:event_btnCreateEquipmentActionPerformed

    private void btnActorOpenImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActorOpenImgMouseClicked
        int returnVal = fchooserActor.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fchooserActor.getSelectedFile();
            txtActorURLImage.setText(f.getName());
            txtActorPathImg.setText(f.getAbsolutePath());
            try {
                img = ImageIO.read(f);
                imgActorGraphics.drawImage(img, 0, 0, imgActorView.getWidth(), imgActorView.getHeight(), imgActorView);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_btnActorOpenImgMouseClicked

    private void btnEquipmentOpenImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEquipmentOpenImgMouseClicked
        int returnVal = fchooserEquipment.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fchooserEquipment.getSelectedFile();
            txtEquipmentURLImage.setText(f.getName());
            txtEquipmentPathImg.setText(f.getAbsolutePath());
            try {
                img = ImageIO.read(f);
                imgEquipmentGraphics.drawImage(img, 0, 0, imgEquipmentView.getWidth(), imgEquipmentView.getHeight(), imgEquipmentView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEquipmentOpenImgMouseClicked

    private void btnDeleteEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEquipmentActionPerformed
        try {
            int row = tblEquipmentView.getSelectedRow();
            int id = (int) tblModelEquipment.getValueAt(row, 0);
            statusNewRole = 1;
            EquipmentDAO dao = new EquipmentDAO();
            if (dao.deleteEquipmentByID(id, txtEquipmentURLImage.getText())) {
                updateEquipment();
                JOptionPane.showMessageDialog(this, "Delete Success.");
                btnNewEquipmentActionPerformed(evt);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one row to Delete.");
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Delete Fail.");
        }

    }//GEN-LAST:event_btnDeleteEquipmentActionPerformed

    private void btnNewRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRoleActionPerformed
        txtRole.setText("");
        txtRoleDescription.setText("");
        tblRoleView.clearSelection();
        statusNewRole = 1;
    }//GEN-LAST:event_btnNewRoleActionPerformed

    private void btnCreateRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRoleActionPerformed
        RoleDTO dto = null;
        try {
            if (statusNewRole == 0) throw new Exception("Please press New button before Create");
            dto = getInfoRole();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        try {
            RoleDAO dao = new RoleDAO();
            if (dao.createRole(dto)) {
                updateRole();
                JOptionPane.showMessageDialog(this, "Insert Success");
                btnNewRoleActionPerformed(evt);
            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                JOptionPane.showMessageDialog(this, "Role Name is existed.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Insert Fail");
        }
    }//GEN-LAST:event_btnCreateRoleActionPerformed

    private void btnDeleteRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRoleActionPerformed
        int row;
        String roleName;
        try {
            row = tblRoleView.getSelectedRow();
            roleName = (String) tblModelRole.getValueAt(row, 0);
            RoleDAO dao = new RoleDAO();
            if (dao.deleteRoleByName(roleName)) {
                updateRole();
                JOptionPane.showMessageDialog(this, "Delete Success.");
                btnNewRoleActionPerformed(evt);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one row to Delete");
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Delete Fail");
        }

    }//GEN-LAST:event_btnDeleteRoleActionPerformed

    private void btnUpdateCastRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCastRoleActionPerformed
        try {
            if (selectRoleName.isSelectionEmpty()) {
                throw new Exception("Please Select One Role In List");
            }
            if (tblCastRoleActorView.getSelectedRow() == -1) {
                throw new Exception("Please Select One Actor In List");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return;
        }
        try {
            int row = tblCastRoleActorView.getSelectedRow();
            CastRoleDTO dto = new CastRoleDTO();
            dto.setRoleName(selectRoleName.getSelectedValue());
            dto.setIDActor((int) tblModelCastRoleSelect.getValueAt(row, 0));
            CastToRoleDAO dao = new CastToRoleDAO();
            selectRoleName.clearSelection();
            tblCastRoleActorView.clearSelection();
            if (dao.createCastRole(dto)) {
                JOptionPane.showMessageDialog(this, "Update Success.");
                updateListCastRole();

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Update Fail.");
        }

    }//GEN-LAST:event_btnUpdateCastRoleActionPerformed

    private void btnDeleteCastRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCastRoleActionPerformed
        try {
            int row = tblCastToRoleView.getSelectedRow();
            String roleName = (String) tblModelCastToRole.getValueAt(row, 0);
            CastToRoleDAO dao = new CastToRoleDAO();
            if (dao.deleteCastRole(roleName)) {
                JOptionPane.showMessageDialog(this, "Delete Success");
                updateListCastRole();
                selectRoleName.clearSelection();
                tblCastRoleActorView.clearSelection();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one row to Delete");
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Delete Fail");
        }
    }//GEN-LAST:event_btnDeleteCastRoleActionPerformed

    private void btnSearchActorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActorActionPerformed
        String value = JOptionPane.showInputDialog(this, "Enter Actor Name To Search:\n(Input Value to Search, Press Cancel to show all)", "Search Box", JOptionPane.QUESTION_MESSAGE);
        try {
            if (value == null) {
                updateListActor();
            } else {
                if (!value.equals("")) {
                    ActorDAO actorDAO = new ActorDAO();
                    List<ActorDTO> listActor = actorDAO.getActorByName(value.trim());
                    showListActor(listActor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchActorActionPerformed

    private void btnSearchEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEquipmentActionPerformed
        String value = JOptionPane.showInputDialog(this, "Enter Equipment Name To Search:\n(Input Value to Search, Press Cancel to show all)", "Search Box", JOptionPane.QUESTION_MESSAGE);
        try {
            if (value == null) {
                updateEquipment();
            } else {
                if (!value.equals("")) {
                    EquipmentDAO equipmentDAO = new EquipmentDAO();
                    List<EquipmentDTO> listEquipment = equipmentDAO.getAllEquipmentByName(value);
                    showListEquipment(listEquipment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchEquipmentActionPerformed

    private void btnSearchRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRoleActionPerformed
        String value = JOptionPane.showInputDialog(this, "Enter Role Name To Search:\n(Input Value to Search, Press Cancel to show all)", "Search Box", JOptionPane.QUESTION_MESSAGE);
        try {
            if (value == null) {
                updateRole();
            } else {
                if (!value.equals("")) {
                    RoleDAO roleDAO = new RoleDAO();
                    List<RoleDTO> listRole = roleDAO.getRoleByName(value);
                    showListRole(listRole);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchRoleActionPerformed

    private void tblRoleContentViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoleContentViewMouseClicked
        int row = tblRoleContentView.getSelectedRow();
        String roleName = (String) tblModelRoleContent.getValueAt(row, 0);
        try {
            RoleDAO roleDAO = new RoleDAO();
            RoleDTO dto = roleDAO.getRole(roleName);
            txtPathRoleContent.setText("RoleContent/" + dto.getDescription() + ".txt");
            txtRoleContentDescription.setText(FileDAO.readFile("RoleContent/" + dto.getDescription() + ".txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblRoleContentViewMouseClicked

    private void tblHistoryTribulationViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryTribulationViewMouseClicked
        int row = tblHistoryTribulationView.getSelectedRow();
        try {
            int id = (int) tblModelFilmedHistory.getValueAt(row, 0);
            TribulationDAO dao = new TribulationDAO();
            TribulationDTO dto = dao.getTribulationByID(id);
            txtHTribulationName.setText(dto.getTribulationName());
            txtHPlace.setText(dto.getPlace());
            txtHStartDate.setText(dto.getStartDate().toLocalDate().format(df));
            txtHEndDate.setText(dto.getEndDate().toLocalDate().format(df));
            txtHNumbaerOfShoot.setText(dto.getNumberOfShoot() + "");
            txtHDescription.setText(dto.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_tblHistoryTribulationViewMouseClicked

    private void tblShootingScheduleViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShootingScheduleViewMouseClicked
        int row = tblShootingScheduleView.getSelectedRow();
        try {
            int id = (int) tblModelShootingSchedule.getValueAt(row, 0);
            TribulationDAO dao = new TribulationDAO();
            TribulationDTO dto = dao.getTribulationByID(id);
            txtSTribulationName.setText(dto.getTribulationName());
            txtSPlace.setText(dto.getPlace());
            txtSStartDate.setText(dto.getStartDate().toLocalDate().format(df));
            txtSEndDate.setText(dto.getEndDate().toLocalDate().format(df));
            txtSNumberOfShoot.setText(dto.getNumberOfShoot() + "");
            txtSDescription.setText(dto.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblShootingScheduleViewMouseClicked

    private void tblActorViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblActorViewMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblActorViewMouseEntered

    private void btnShowEquipmentByTIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowEquipmentByTIDActionPerformed
        try {
            int row = tblTribulationView.getSelectedRow();
            int id = (int) tblModelTribulation.getValueAt(row, 0);
            new ShowTable().EquipmentInit(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one row to show");
        }
    }//GEN-LAST:event_btnShowEquipmentByTIDActionPerformed

    private void btnNewTribulationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewTribulationMouseClicked

    }//GEN-LAST:event_btnNewTribulationMouseClicked

    private void btnNewTribulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewTribulationActionPerformed
        JTextField[] field = {txtTribulationName, txtPlace, txtStartDate, txtEndDate, txtNumOfShoot};
        for (JTextField jTextField : field) {
            jTextField.setText("");
        }
        btnShowEquipmentByTID.setEnabled(false);
        btnShowRoleByTID.setEnabled(false);
        txtTribulationDescription.setText("");
        statusNewTribulation = 1;
    }//GEN-LAST:event_btnNewTribulationActionPerformed

    private void btnSearchUsedEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUsedEquipmentActionPerformed
        String value = JOptionPane.showInputDialog(this, "Enter Equipment Name To Search:\n(Input Value to Search, Press Cancel to show all)", "Search Box", JOptionPane.QUESTION_MESSAGE);
        try {
            if (value == null) {
                updateUsedEquipment();
            } else {
                if (!value.equals("")) {
                    UsedEquipmentDAO equipDAO = new UsedEquipmentDAO();
                    List<UsedEquipmentDTO> listEquip = equipDAO.getAllUsedEquipmentByName(value.trim());
                    showUsedEquipment(listEquip);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchUsedEquipmentActionPerformed

    private void btnSearchUsedRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUsedRoleActionPerformed
        String value = JOptionPane.showInputDialog(this, "Enter Role Name To Search:\n(Input Value to Search, Press Cancel to show all)", "Search Box", JOptionPane.QUESTION_MESSAGE);
        try {
            if (value == null) {
                updateUsedRole();
            } else {
                if (!value.equals("")) {
                    UsedRoleDAO roleDAO = new UsedRoleDAO();
                    List<UsedRoleDTO> listRole = roleDAO.getAllUsedRoleByName(value.trim());
                    showListUsedRole(listRole);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchUsedRoleActionPerformed

    private void btnSearchCastRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCastRoleActionPerformed
        String value = JOptionPane.showInputDialog(this, "Enter Actor Name To Search:\n(Input Value to Search, Press Cancel to show all)", "Search Box", JOptionPane.QUESTION_MESSAGE);
        try {
            if (value == null) {
                updateListCastRole();
            } else {
                if (!value.equals("")) {
                    CastToRoleDAO castRoleDAO = new CastToRoleDAO();
                    List<CastRoleDTO> listCastRole = castRoleDAO.getAllCastRoleByActorName(value);
                    showListCastToRole(listCastRole);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchCastRoleActionPerformed

    private void txtStatisticStartDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStatisticStartDateKeyReleased
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        if (txtStatisticStartDate.getText().equals("")) {
            btnClearStartDate.setEnabled(false);
            errorStartDate.setBackground(new java.awt.Color(255, 255, 255));
        } else {
            btnClearStartDate.setEnabled(true);
            try {
                Date d = new Date(sdf.parse(txtStatisticStartDate.getText().trim()).getTime());
                int years = d.getYear() + 1900;
                if ((int) (Math.log10(years) + 1) != 4) throw new ParseException(username, ERROR);
                errorStartDate.setBackground(new java.awt.Color(255, 255, 255));
                updateStatistic(cbSelectStatus.getSelectedIndex(), txtStatisticStartDate.getText().trim(), txtStatisticEndDate.getText().trim());
            } catch (ParseException e) {
                errorStartDate.setBackground(new java.awt.Color(255, 51, 102));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_txtStatisticStartDateKeyReleased

    private void cbSelectStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectStatusActionPerformed
        if (cbSelectStatus.getSelectedIndex() == 2) {
            btnClearStartDateActionPerformed(evt);
            btnClearEndDateActionPerformed(evt);
        }
        try {
            updateStatistic(cbSelectStatus.getSelectedIndex(), txtStatisticStartDate.getText().trim(), txtStatisticEndDate.getText().trim());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_cbSelectStatusActionPerformed

    private void txtStatisticEndDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStatisticEndDateKeyReleased
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        if (txtStatisticEndDate.getText().equals("")) {
            btnClearEndDate.setEnabled(false);
            errorEndDate.setBackground(new java.awt.Color(255, 255, 255));
        } else {
            btnClearEndDate.setEnabled(true);
            try {
                Date d = new Date(sdf.parse(txtStatisticEndDate.getText().trim()).getTime());
                int years = d.getYear() + 1900;
                if ((int) (Math.log10(years) + 1) != 4) throw new ParseException(username, ERROR);

                errorEndDate.setBackground(new java.awt.Color(255, 255, 255));
                updateStatistic(cbSelectStatus.getSelectedIndex(), txtStatisticStartDate.getText().trim(), txtStatisticEndDate.getText().trim());
            } catch (ParseException e) {
                errorEndDate.setBackground(new java.awt.Color(255, 51, 102));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_txtStatisticEndDateKeyReleased

    private void btnClearStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearStartDateActionPerformed
        txtStatisticStartDate.setText("");
        errorStartDate.setBackground(new java.awt.Color(255, 255, 255));
        btnClearStartDate.setEnabled(false);
        try {
            updateStatistic(cbSelectStatus.getSelectedIndex(), txtStatisticStartDate.getText().trim(), txtStatisticEndDate.getText().trim());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnClearStartDateActionPerformed

    private void btnClearEndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearEndDateActionPerformed
        txtStatisticEndDate.setText("");
        errorEndDate.setBackground(new java.awt.Color(255, 255, 255));
        btnClearEndDate.setEnabled(false);
        try {
            updateStatistic(cbSelectStatus.getSelectedIndex(), txtStatisticStartDate.getText().trim(), txtStatisticEndDate.getText().trim());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnClearEndDateActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        try {
            int row = tblRoleContentView.getSelectedRow();
            String valid = (String) tblModelRoleContent.getValueAt(row, 0);
            String linkFile = txtPathRoleContent.getText();
            System.out.println(linkFile);
            fchooser.setDialogTitle("Download Role Content");
            fchooser.setSelectedFile(new File(valid + ".txt"));
            int reVal = fchooser.showSaveDialog(this);
            if (reVal == JFileChooser.APPROVE_OPTION) {
                File f = fchooser.getSelectedFile();
                File ff = new File(linkFile);
                if (ff.exists() && ff.isFile()) {
                    FileDAO.copyFile(linkFile, f.getParent(), f.getName());
                    JOptionPane.showMessageDialog(this, "Download  " + valid + " Role Successfully");

                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Please select one Role");
            return;
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_btnDownloadActionPerformed

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
        LogDAO dao = new LogDAO();
        try {
            if (dao.getTotalByID(idUser) == 0) {
                JOptionPane.showMessageDialog(this, "No Notification");
                return;
            }

            if (dao.getUnreadByID(idUser) == 0) {
                JOptionPane.showMessageDialog(this, "No New Notification");
            }
            new Notification(idUser).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_notificationMouseClicked

    private void CTribulationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTribulationMouseClicked
        navManageTribulationMouseClicked(evt);
    }//GEN-LAST:event_CTribulationMouseClicked

    private void CActorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CActorMouseClicked
        navManageActorMouseClicked(evt);
    }//GEN-LAST:event_CActorMouseClicked

    private void CEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CEquipmentMouseClicked
        navManageEquipmentMouseClicked(evt);
    }//GEN-LAST:event_CEquipmentMouseClicked

    private void CRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CRoleMouseClicked
        navManageRoleMouseClicked(evt);
    }//GEN-LAST:event_CRoleMouseClicked

    private void CRoleContentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CRoleContentMouseClicked
        navRoleContentMouseClicked(evt);
    }//GEN-LAST:event_CRoleContentMouseClicked

    private void CFilmHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CFilmHistoryMouseClicked
        navFilmedHistoryMouseClicked(evt);
    }//GEN-LAST:event_CFilmHistoryMouseClicked

    private void CShootingScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CShootingScheduleMouseClicked
        navShootingScheduleMouseClicked(evt);
    }//GEN-LAST:event_CShootingScheduleMouseClicked

    private void btnEditAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditAccountMouseClicked
        this.dispose();
        new ChangeAccountUI(userDTO).setVisible(true);
    }//GEN-LAST:event_btnEditAccountMouseClicked

    private void btnEditInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditInfoMouseClicked
        this.dispose();
        new ChangeActorInfo(userDTO).setVisible(true);
    }//GEN-LAST:event_btnEditInfoMouseClicked
    // End of variables declaration//GEN-END:variables
}
