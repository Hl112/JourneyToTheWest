/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lamhdt.dtos.LogDTO;
import lamhdt.model.LogDAO;

/**
 *
 * @author HL
 */
public class Notification extends javax.swing.JFrame {

    private Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
    private int offsetX, offsetY;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private LogDAO dao = new LogDAO();
    /**
     * Creates new form Notification
     */
    public Notification() {
        initComponents();
        this.setLocation(ss.width / 2 - this.getSize().width / 2, ss.height / 2 - this.getSize().height / 2);
        container.setSize(300, 30);
        
        try {
            lbCount.setText(dao.getUnreadByID(3) + " NEW");
            lbTotal.setText(dao.getTotalByID(3) + " TOTAL");
            List<LogDTO> rs = dao.getAllLogByID(3);
            Collections.sort(rs);
            for (LogDTO logDTO : rs) {
            addNoti(logDTO.getEvent(), logDTO.getRoleNew(), "ADMIN", logDTO.getTime(), logDTO.getId(), logDTO.getIsNew());
        }
        } catch (Exception e) {
        }
       
       
        
      
    }
    
    public Notification(int id) {
         initComponents();
        this.setLocation(ss.width / 2 - this.getSize().width / 2, ss.height / 2 - this.getSize().height / 2);
        container.setSize(300, 30);
          try {
            lbCount.setText(dao.getUnreadByID(id) + " NEW");
            lbTotal.setText(dao.getTotalByID(id) + " TOTAL");
            List<LogDTO> rs = dao.getAllLogByID(id);
            //Collections.sort(rs);
            for (LogDTO logDTO : rs) {
            addNoti(logDTO.getEvent(), logDTO.getRoleNew(), "ADMIN", logDTO.getTime(), logDTO.getId(), logDTO.getIsNew());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void addNoti(String event, String role, String username, Timestamp time, int id, int isNew) {
        final JPanel noti = new javax.swing.JPanel();
         final JLabel txtId = new javax.swing.JLabel(id + "");;
        Dimension sizeC = container.getPreferredSize();
        int currentH = sizeC.height;
        container.setPreferredSize(new Dimension(300, currentH+100));
        if (currentH > 500) {
            this.setPreferredSize(new Dimension(338, 500));
        } else {
            this.setPreferredSize(new Dimension(323, 500));
        }
        Date d = new Date(time.getTime());
        int h = time.getHours();
        int m = time.getMinutes();
        

        if (event.equals("Update")) {
            noti.setBackground(new java.awt.Color(217, 237, 247));
            noti.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(118, 232, 241)));
            noti.setPreferredSize(new java.awt.Dimension(300, 100));
            JLabel lbE = new javax.swing.JLabel();
            lbE.setBackground(new java.awt.Color(60, 118, 61));
            lbE.setFont(new java.awt.Font("SVN-Russell", 0, 18)); // NOI18N
            lbE.setForeground(new java.awt.Color(49, 112, 143));
            lbE.setText("Update");
            JLabel by = new javax.swing.JLabel();
            by.setFont(new java.awt.Font("SVN-Linux Libertine", 1, 18)); // NOI18N
            by.setForeground(new java.awt.Color(49, 112, 143));
            by.setText("by " + username);
            JLabel at = new javax.swing.JLabel();
            at.setFont(new java.awt.Font("SVN-Sunday", 0, 14)); // NOI18N
            at.setForeground(new java.awt.Color(49, 112, 143));
            at.setText("at:");
            JLabel lbt = new javax.swing.JLabel();
            lbt.setFont(new java.awt.Font("SVN-Titillium Bold", 0, 14)); // NOI18N
            lbt.setForeground(new java.awt.Color(49, 112, 143));
            lbt.setText(sdf.format(d) + " - " + h + "h" + m);
            JLabel msg = new javax.swing.JLabel();
            msg.setForeground(new java.awt.Color(54, 112, 143));
            msg.setText(" - You has been add to Role :");
            JLabel lbRole = new javax.swing.JLabel();
            lbRole.setForeground(new java.awt.Color(54, 112, 143));
            lbRole.setFont(new java.awt.Font("SVN-Linux Libertine", 1, 14));
            lbRole.setText(role);
           
            javax.swing.GroupLayout groupL = new javax.swing.GroupLayout(noti);
            noti.setLayout(groupL);
            groupL.setHorizontalGroup(
                    groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(groupL.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupL.createSequentialGroup()
                                                    .addComponent(lbE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                                    .addComponent(by))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupL.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(at)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lbt)))
                                    .addContainerGap())
                            .addGroup(groupL.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(msg)
                                            .addGroup(groupL.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(lbRole)))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            groupL.setVerticalGroup(
                    groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(groupL.createSequentialGroup()
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(by))
                                    .addGap(2, 2, 2)
                                    .addComponent(msg)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(groupL.createSequentialGroup()
                                                    .addComponent(lbRole)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbt))
                                            .addGroup(groupL.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(at)))
                                    .addGap(20, 20, 20))
            );
          
        }
        else{
            
            noti.setBackground(new java.awt.Color(252, 248, 227));
            noti.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(250, 235, 204)));
            noti.setPreferredSize(new java.awt.Dimension(300, 100));
            JLabel lbE = new javax.swing.JLabel();
            lbE.setBackground(new java.awt.Color(138, 109, 59));
            lbE.setFont(new java.awt.Font("SVN-Russell", 0, 18)); // NOI18N
            lbE.setForeground(new java.awt.Color(153, 126, 86));
            lbE.setText("Delete");
            JLabel by = new javax.swing.JLabel();
            by.setFont(new java.awt.Font("SVN-Linux Libertine", 1, 18)); // NOI18N
            by.setForeground(new java.awt.Color(153, 126, 86));
            by.setText("by " + username);
            JLabel at = new javax.swing.JLabel();
            at.setFont(new java.awt.Font("SVN-Sunday", 0, 14)); // NOI18N
            at.setForeground(new java.awt.Color(153, 126, 86));
            at.setText("at:");
            JLabel lbt = new javax.swing.JLabel();
            lbt.setFont(new java.awt.Font("SVN-Titillium Bold", 0, 14)); // NOI18N
            lbt.setForeground(new java.awt.Color(153, 126, 86));
            lbt.setText(sdf.format(d) + " - " + h + "h" + m);
            JLabel msg = new javax.swing.JLabel();
            msg.setForeground(new java.awt.Color(158, 126, 86));
            msg.setText(" - You has been delete from Role :");
            JLabel lbRole = new javax.swing.JLabel();
            lbRole.setForeground(new java.awt.Color(153, 126, 86));
            lbRole.setFont(new java.awt.Font("SVN-Linux Libertine", 1, 14));
            lbRole.setText(role);
            javax.swing.GroupLayout groupL = new javax.swing.GroupLayout(noti);
            noti.setLayout(groupL);
            groupL.setHorizontalGroup(
                    groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(groupL.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupL.createSequentialGroup()
                                                    .addComponent(lbE, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                                    .addComponent(by))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, groupL.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(at)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lbt)))
                                    .addContainerGap())
                            .addGroup(groupL.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(msg)
                                            .addGroup(groupL.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(lbRole)))
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            groupL.setVerticalGroup(
                    groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(groupL.createSequentialGroup()
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbE, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(by))
                                    .addGap(2, 2, 2)
                                    .addComponent(msg)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(groupL.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(groupL.createSequentialGroup()
                                                    .addComponent(lbRole)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbt))
                                            .addGroup(groupL.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(at)))
                                    .addGap(20, 20, 20))
            );
            
        }
        if(isNew == 0) 
            noti.setBackground(new java.awt.Color(204, 204, 204));
        else
         noti.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    noti.setBackground(new java.awt.Color(204, 204, 204));
                    try {
                        dao.makeRead(Integer.parseInt(txtId.getText()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
          container.add(noti);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        titlebar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbCount = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        notiP = new javax.swing.JScrollPane();
        container = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notification");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(323, 500));
        setResizable(false);

        titlebar.setBackground(new java.awt.Color(255, 255, 255));
        titlebar.setPreferredSize(new java.awt.Dimension(325, 30));
        titlebar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titlebarMouseDragged(evt);
            }
        });
        titlebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titlebarMousePressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_close_window_24px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SVN-Sunday", 0, 14)); // NOI18N
        jLabel2.setText("Notification");

        lbCount.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        lbCount.setForeground(new java.awt.Color(255, 0, 51));
        lbCount.setText("6 NEW");

        lbTotal.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        lbTotal.setText("12 Total");

        jLabel4.setText("-");

        javax.swing.GroupLayout titlebarLayout = new javax.swing.GroupLayout(titlebar);
        titlebar.setLayout(titlebarLayout);
        titlebarLayout.setHorizontalGroup(
            titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlebarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lbCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(5, 5, 5))
        );
        titlebarLayout.setVerticalGroup(
            titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlebarLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titlebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbCount)
                        .addComponent(lbTotal)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(titlebar, java.awt.BorderLayout.PAGE_START);

        notiP.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        notiP.setToolTipText("");
        notiP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        notiP.setColumnHeaderView(container);
        notiP.setMaximumSize(new java.awt.Dimension(400, 600));
        notiP.setRowHeaderView(null);

        container.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        container.setLayout(flowLayout1);
        notiP.setViewportView(container);

        getContentPane().add(notiP, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
        try {
            UI.showNoti();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void titlebarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarMousePressed
        this.offsetX = evt.getX();
        this.offsetY = evt.getY();
    }//GEN-LAST:event_titlebarMousePressed

    private void titlebarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titlebarMouseDragged
        this.setLocation(evt.getXOnScreen() - offsetX, evt.getYOnScreen() - offsetY);
    }//GEN-LAST:event_titlebarMouseDragged

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
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCount;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JScrollPane notiP;
    private javax.swing.JPanel titlebar;
    // End of variables declaration//GEN-END:variables
}
