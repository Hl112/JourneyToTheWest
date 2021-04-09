/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lamhdt.dtos.ActorDTO;
import lamhdt.dtos.UserDTO;
import lamhdt.model.ActorDAO;

/**
 *
 * @author HL
 */
public class ChangeActorInfo extends javax.swing.JFrame {

    private int offsetX, offsetY;
    private Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
    private ActorDTO actor = null;
    private UserDTO user = null;
    private BufferedImage img = null;
    private int idActor;
    private Graphics gr;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "GIF", "JPG", "JPEG", "PNG");
    private JFileChooser ff = new JFileChooser();
    private File f = null;

    /**
     * Creates new form ChangeActorInfo
     */
    
    class LoadIMG implements Runnable{
        Thread t = null;
        public LoadIMG() {
            t = new Thread(this);
            t.start();
        }
        
        @Override
        public void run() {
            try {
            f = new File(actor.getImage().trim());
        } catch (Exception e) {
            f = new File("imgActor/noimg.jpg");
        }
        try {
            img = ImageIO.read(f);
            imgView.getGraphics().drawImage(img, 0, 0, imgView.getSize().width, imgView.getSize().height, null);

        } catch (IOException ex) {
        }
        }
        
    }
    
    public ChangeActorInfo() {
        initComponents();
        this.setLocation(ss.width / 2 - this.getSize().width / 2, ss.height / 2 - this.getSize().height / 2);
    }

    public ChangeActorInfo(UserDTO dto) {
         initComponents(); 
        this.user = dto;
        ff.setMultiSelectionEnabled(false);
        ff.setFileFilter(filter);
        try {
            ActorDAO dao = new ActorDAO();
            this.idActor = dao.getIDByUsername(dto.getUsername());
            this.actor = dao.getActorByID(idActor);
            actor.setActorUsername(user.getUsername());  
        } catch (Exception e) {
            e.printStackTrace();
        }
      
     
        this.setLocation(ss.width / 2 - this.getSize().width / 2, ss.height / 2 - this.getSize().height / 2);
        lbName.setText(actor.getActorName());
            lbPhone.setText(actor.getPhone());
            lbEmail.setText(actor.getEmail());
       
       new LoadIMG();
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        path = new javax.swing.JLabel();
        titleBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        imgView = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbPhone = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        btnOkName = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtPhone = new javax.swing.JTextField();
        btnOkPhone = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        btnOkEmail = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Actor Information");
        setMinimumSize(new java.awt.Dimension(400, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 600));
        setResizable(false);

        titleBar.setBackground(new java.awt.Color(33, 33, 33));
        titleBar.setPreferredSize(new java.awt.Dimension(661, 35));
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

        jLabel1.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("actor Profile");

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_delete_24px.png"))); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout titleBarLayout = new javax.swing.GroupLayout(titleBar);
        titleBar.setLayout(titleBarLayout);
        titleBarLayout.setHorizontalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addContainerGap())
        );
        titleBarLayout.setVerticalGroup(
            titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleBarLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(titleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(titleBar, java.awt.BorderLayout.PAGE_START);

        container.setPreferredSize(new java.awt.Dimension(399, 424));
        container.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 102), new java.awt.Color(0, 51, 255), new java.awt.Color(0, 102, 255), new java.awt.Color(255, 0, 102)));
        jPanel12.setMaximumSize(new java.awt.Dimension(400, 32767));
        jPanel12.setMinimumSize(new java.awt.Dimension(400, 124));
        jPanel12.setPreferredSize(new java.awt.Dimension(400, 424));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(395, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jLabel2.setFont(new java.awt.Font("SVN-SAF", 0, 18)); // NOI18N
        jLabel2.setText("Information Actor");
        jPanel1.add(jLabel2);

        jSeparator1.setPreferredSize(new java.awt.Dimension(380, 10));
        jPanel1.add(jSeparator1);

        jPanel12.add(jPanel1);

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 155));

        imgView.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(255, 0, 51), new java.awt.Color(0, 51, 255), new java.awt.Color(255, 254, 255), new java.awt.Color(255, 254, 255)));
        imgView.setOpaque(false);

        javax.swing.GroupLayout imgViewLayout = new javax.swing.GroupLayout(imgView);
        imgView.setLayout(imgViewLayout);
        imgViewLayout.setHorizontalGroup(
            imgViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imgViewLayout.setVerticalGroup(
            imgViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lbName.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(0, 51, 204));
        lbName.setText("Luc Tieu Linh Dong");

        lbPhone.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        lbPhone.setForeground(new java.awt.Color(0, 102, 204));
        lbPhone.setText("0123456789");

        lbEmail.setFont(new java.awt.Font("SVN-Abril Fatface", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(0, 51, 204));
        lbEmail.setText("tieudong@tdk.com");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        jButton4.setText("Change Picture");
        jButton4.setOpaque(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(lbPhone)
                    .addComponent(lbEmail))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbPhone)
                        .addGap(18, 18, 18)
                        .addComponent(lbEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(imgView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton4)
                .addContainerGap())
        );

        jPanel12.add(jPanel2);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(395, 40));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        txtName.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 0, 51));
        txtName.setText("INPUT NEW NAME");
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(33, 33, 33)));
        txtName.setPreferredSize(new java.awt.Dimension(260, 35));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        jPanel4.add(txtName);

        btnOkName.setBackground(new java.awt.Color(255, 255, 255));
        btnOkName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_checked_checkbox_24px.png"))); // NOI18N
        btnOkName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkNameActionPerformed(evt);
            }
        });
        jPanel4.add(btnOkName);

        jPanel12.add(jPanel4);

        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(395, 40));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        txtPhone.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(255, 0, 51));
        txtPhone.setText("INPUT NEW PHONE");
        txtPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(33, 33, 33)));
        txtPhone.setPreferredSize(new java.awt.Dimension(260, 35));
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        jPanel5.add(txtPhone);

        btnOkPhone.setBackground(new java.awt.Color(255, 255, 255));
        btnOkPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_checked_checkbox_24px.png"))); // NOI18N
        btnOkPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkPhoneActionPerformed(evt);
            }
        });
        jPanel5.add(btnOkPhone);

        jPanel12.add(jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(395, 40));
        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 8, 5));

        txtEmail.setFont(new java.awt.Font("SVN-Abril Fatface", 1, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 0, 51));
        txtEmail.setText("INPUT NEW EMAIL");
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(33, 33, 33)));
        txtEmail.setPreferredSize(new java.awt.Dimension(260, 35));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel6.add(txtEmail);

        btnOkEmail.setBackground(new java.awt.Color(255, 255, 255));
        btnOkEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8_checked_checkbox_24px.png"))); // NOI18N
        btnOkEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkEmailActionPerformed(evt);
            }
        });
        jPanel6.add(btnOkEmail);

        jPanel12.add(jPanel6);

        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(395, 170));

        jLabel6.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Descripton");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 0, 51), new java.awt.Color(0, 51, 255), null, null));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDescription.setColumns(20);
        txtDescription.setForeground(new java.awt.Color(255, 0, 51));
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBorder(null);
        jScrollPane1.setViewportView(txtDescription);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SVN-SAF", 0, 14)); // NOI18N
        jButton1.setText("Save Description");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel12.add(jPanel7);

        container.add(jPanel12, java.awt.BorderLayout.CENTER);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
        new UI(user.getPermision(), user.getUsername(), user.getPassword()).setVisible(true);
    }//GEN-LAST:event_btnCloseMouseClicked

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMousePressed
        offsetX = evt.getX();
        offsetY = evt.getY();
    }//GEN-LAST:event_titleBarMousePressed

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMouseDragged
        this.setLocation(evt.getXOnScreen() - offsetX, evt.getYOnScreen() - offsetY);
    }//GEN-LAST:event_titleBarMouseDragged

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        if (txtName.getText().trim().equalsIgnoreCase("INPUT NEW NAME")) {
            txtName.setText("");
        }

    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        if (txtName.getText().trim().equals("")) {
            txtName.setText("INPUT NEW NAME");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        if (txtPhone.getText().trim().equalsIgnoreCase("INPUT NEW PHONE")) {
            txtPhone.setText("");
        }
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        if (txtPhone.getText().trim().equals("")) {
            txtPhone.setText("INPUT NEW PHONE");
        }
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().trim().equalsIgnoreCase("INPUT NEW EMAIL")) {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().trim().equals("")) {
            txtEmail.setText("INPUT NEW EMAIL");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        int returnVal = ff.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = ff.getSelectedFile();
            path.setText(f.getAbsolutePath());
            try {
                img = ImageIO.read(f);
                imgView.getGraphics().drawImage(img, 0, 0, imgView.getWidth(), imgView.getHeight(), imgView);
                actor.setImage(f.getAbsolutePath());
                ActorDAO dao = new ActorDAO();
                if (dao.updateActorByID(idActor, actor)) {
                    JOptionPane.showMessageDialog(this, "Change Picture Sucsess");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void btnOkNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkNameActionPerformed
        String name = txtName.getText();
        if (!name.equals("INPUT NEW NAME"))
        try {
            actor.setActorName(txtName.getText().trim());
            ActorDAO dao = new ActorDAO();
            if (dao.updateActorByID(idActor, actor)) {
                JOptionPane.showMessageDialog(this, "Change Name Sucsess");
                lbName.setText(name);
                txtName.setText("INPUT NEW NAME");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } else {
            JOptionPane.showMessageDialog(this, "Please Input New Name");
        }
    }//GEN-LAST:event_btnOkNameActionPerformed

    private void btnOkPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkPhoneActionPerformed
        String phone = txtPhone.getText();
        if (!phone.equals("INPUT NEW PHONE"))
        try {
            actor.setPhone(txtPhone.getText().trim());
            ActorDAO dao = new ActorDAO();
            if (dao.updateActorByID(idActor, actor)) {
                JOptionPane.showMessageDialog(this, "Change Phone Sucsess");
                lbPhone.setText(phone);
                txtPhone.setText("INPUT NEW PHONE");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } else {
            JOptionPane.showMessageDialog(this, "Please Input New Phone");
        }
    }//GEN-LAST:event_btnOkPhoneActionPerformed

    private void btnOkEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkEmailActionPerformed
        String email = txtEmail.getText();
        if (!email.equals("INPUT NEW EMAIL"))
        try {
            actor.setEmail(txtEmail.getText().trim());
            ActorDAO dao = new ActorDAO();
            if (dao.updateActorByID(idActor, actor)) {
                JOptionPane.showMessageDialog(this, "Change Email Sucsess");
                lbEmail.setText(email);
                txtEmail.setText("INPUT NEW EMAIL");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } else {
            JOptionPane.showMessageDialog(this, "Please Input New Email");
        }
    }//GEN-LAST:event_btnOkEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String des = txtEmail.getText();
        if(!des.equals(""))
        try {
            actor.setDescription(txtDescription.getText().trim());
            ActorDAO dao = new ActorDAO();
            if (dao.updateActorByID(idActor, actor)) {
                JOptionPane.showMessageDialog(this, "Change Description Sucsess");

                txtDescription.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        else JOptionPane.showMessageDialog(this, "Please Input Description.");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeActorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeActorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeActorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeActorInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeActorInfo().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnOkEmail;
    private javax.swing.JButton btnOkName;
    private javax.swing.JButton btnOkPhone;
    private javax.swing.JPanel container;
    public static javax.swing.JPanel imgView;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhone;
    private javax.swing.JLabel path;
    private javax.swing.JPanel titleBar;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
