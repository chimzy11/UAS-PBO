package MedicineStore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;
public class LupaPassword extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public LupaPassword() {
        initComponents();
        setResizable(false);
        setDefaultCloseOperation(LupaPassword.DO_NOTHING_ON_CLOSE);
        lPasswordAnda.setText("");
        lPassword.setEnabled(false);
        lPassword.setVisible(false);
        generateSecurityCode();
    }
    
    private void generateSecurityCode() {
        String securityCode = generateRandomCode(6);
        lKodeKeamanan.setText(securityCode);
    }

    private String generateRandomCode(int length) {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(10);
            code.append(randomNumber);
        }

        return code.toString();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tKodeKeamanan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lKodeKeamanan = new javax.swing.JLabel();
        lPasswordAnda = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bCekPassword = new javax.swing.JButton();
        lPassword = new javax.swing.JTextField();
        bBack = new javax.swing.JLabel();

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/account (1).png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jLabel2CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(184, 231, 225));

        jLabel3.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(158, 111, 33));
        jLabel3.setText("Forgot Password");

        tKodeKeamanan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tKodeKeamanan.setForeground(new java.awt.Color(158, 111, 33));
        tKodeKeamanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKodeKeamananActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(158, 111, 33));
        jLabel7.setText("E-Mail");

        tEmail.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tEmail.setForeground(new java.awt.Color(158, 111, 33));
        tEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tEmailMouseExited(evt);
            }
        });
        tEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEmailActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(158, 111, 33));
        jLabel9.setText("Kode Keamanan");

        lKodeKeamanan.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lKodeKeamanan.setForeground(new java.awt.Color(158, 111, 33));
        lKodeKeamanan.setText("000000");

        lPasswordAnda.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lPasswordAnda.setForeground(new java.awt.Color(158, 111, 33));
        lPasswordAnda.setText("Password anda adalah ");

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(158, 111, 33));
        jLabel10.setText("Apps by Rismayanti");

        bCekPassword.setBackground(new java.awt.Color(158, 111, 33));
        bCekPassword.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bCekPassword.setForeground(new java.awt.Color(184, 231, 225));
        bCekPassword.setText("Cek Password");
        bCekPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCekPasswordActionPerformed(evt);
            }
        });

        lPassword.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lPassword.setForeground(new java.awt.Color(158, 111, 33));
        lPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lPassword.setToolTipText("");
        lPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lPasswordActionPerformed(evt);
            }
        });

        bBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow.png"))); // NOI18N
        bBack.setPreferredSize(new java.awt.Dimension(100, 100));
        bBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBackMouseClicked(evt);
            }
        });
        bBack.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                bBackCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tKodeKeamanan)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(lKodeKeamanan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bCekPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lPasswordAnda, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lKodeKeamanan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tKodeKeamanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lPasswordAnda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(bCekPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        bCekPassword.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tKodeKeamananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKodeKeamananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tKodeKeamananActionPerformed

    private void tEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tEmailActionPerformed

    private void bCekPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCekPasswordActionPerformed
    String email = tEmail.getText(); // Mendapatkan nilai teks dari tEmail

    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(rootPane, "Masukkan alamat email", "Error", JOptionPane.ERROR_MESSAGE);
    }
    else if (!email.contains("@")) {
            JOptionPane.showMessageDialog(rootPane, "Email tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        try {
            conn = Koneksi.getConnection();
            pst = conn.prepareStatement("SELECT * FROM tb_login WHERE email=?");
            pst.setString(1, email);
            rs = pst.executeQuery();

            if (rs.next()) {
                String password = rs.getString("password");
                
                String lKodeKeamananText = lKodeKeamanan.getText();
                String tKodeKeamananText = tKodeKeamanan.getText();

                int lKodeKeamanan = Integer.parseInt(lKodeKeamananText);
                int tKodeKeamanan = Integer.parseInt(tKodeKeamananText);

                if (lKodeKeamanan == tKodeKeamanan) {
                    lPassword.setVisible(true);
                    lPasswordAnda.setText("Password anda adalah");
                    lPassword.setText(password);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Kode keamanan tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Email tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
    }//GEN-LAST:event_bCekPasswordActionPerformed

    private void lPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lPasswordActionPerformed

    private void jLabel2CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabel2CaretPositionChanged
        
    }//GEN-LAST:event_jLabel2CaretPositionChanged

    private void bBackCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_bBackCaretPositionChanged

    }//GEN-LAST:event_bBackCaretPositionChanged

    private void bBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBackMouseClicked
        setVisible(false);
    }//GEN-LAST:event_bBackMouseClicked

    private void tEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEmailMouseExited

    }//GEN-LAST:event_tEmailMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LupaPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bBack;
    private javax.swing.JButton bCekPassword;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lKodeKeamanan;
    private javax.swing.JTextField lPassword;
    private javax.swing.JLabel lPasswordAnda;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tKodeKeamanan;
    // End of variables declaration//GEN-END:variables
}
