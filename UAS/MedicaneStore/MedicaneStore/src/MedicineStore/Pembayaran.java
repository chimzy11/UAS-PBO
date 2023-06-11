package MedicineStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;

public class Pembayaran extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    public Pembayaran() {
        initComponents();
        JOptionPane.showMessageDialog(null, "Silahkan lakukan pembayaran melalui Mobile Banking dengan tujuan Finnet Indonesia, PT", "Informasi", JOptionPane.INFORMATION_MESSAGE);       
        tKodePembayaran.setEditable(false);
        generateSecurityCode();
        bBayar.setVisible(false);
    }

    private void generateSecurityCode() {
        String securityCode = generateRandomCode(10);
        tKodePembayaran.setText(securityCode);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tNamaLengkap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bBayar = new javax.swing.JButton();
        bBack = new javax.swing.JLabel();
        tNorek = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cJenisBank = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        tKodePembayaran = new javax.swing.JTextField();
        cValid = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 239, 214));

        jLabel3.setFont(new java.awt.Font("Freestyle Script", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(158, 111, 33));
        jLabel3.setText("Pembayaran");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(158, 111, 33));
        jLabel7.setText("Nama Lengkap");

        tNamaLengkap.setBackground(new java.awt.Color(255, 239, 214));
        tNamaLengkap.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tNamaLengkap.setForeground(new java.awt.Color(158, 111, 33));
        tNamaLengkap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tNamaLengkapMouseExited(evt);
            }
        });
        tNamaLengkap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaLengkapActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(158, 111, 33));
        jLabel10.setText("Apps by Rismayanti");

        bBayar.setBackground(new java.awt.Color(158, 111, 33));
        bBayar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bBayar.setForeground(new java.awt.Color(184, 231, 225));
        bBayar.setText("Bayar");
        bBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBayarActionPerformed(evt);
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

        tNorek.setBackground(new java.awt.Color(255, 239, 214));
        tNorek.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tNorek.setForeground(new java.awt.Color(158, 111, 33));
        tNorek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tNorekMouseExited(evt);
            }
        });
        tNorek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNorekActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(158, 111, 33));
        jLabel8.setText("Nomor Rekening");

        cJenisBank.setBackground(new java.awt.Color(255, 239, 214));
        cJenisBank.setForeground(new java.awt.Color(158, 111, 33));
        cJenisBank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Bank --", "Mandiri", "BRI", "BCA", "BTN" }));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(158, 111, 33));
        jLabel9.setText("Jenis Bank");

        tKodePembayaran.setBackground(new java.awt.Color(255, 239, 214));
        tKodePembayaran.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tKodePembayaran.setForeground(new java.awt.Color(158, 111, 33));
        tKodePembayaran.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tKodePembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tKodePembayaranMouseExited(evt);
            }
        });
        tKodePembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKodePembayaranActionPerformed(evt);
            }
        });

        cValid.setBackground(new java.awt.Color(255, 239, 214));
        cValid.setForeground(new java.awt.Color(158, 111, 33));
        cValid.setLabel("Data pembayaran saya valid");
        cValid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cValidActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(158, 111, 33));
        jLabel11.setText("Nomor Pembayaran");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bBayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(tNamaLengkap)
                            .addComponent(jLabel7)
                            .addComponent(tNorek)
                            .addComponent(cJenisBank, 0, 258, Short.MAX_VALUE)
                            .addComponent(tKodePembayaran, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cValid, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(82, 82, 82))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cJenisBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNorek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(tKodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cValid)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bBayar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(bBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bBackCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_bBackCaretPositionChanged

    }//GEN-LAST:event_bBackCaretPositionChanged

    private void bBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBackMouseClicked
        try{
            conn = Koneksi.getConnection();
            pst = conn.prepareStatement("DELETE FROM tb_keranjang");
            pst.executeUpdate();
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bBackMouseClicked

    private void bBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBayarActionPerformed
        String jenisBank = cJenisBank.getSelectedItem().toString();
        
        String norek = tNorek.getText().trim();

        try {
            conn = Koneksi.getConnection();
            pst = conn.prepareStatement("SELECT * FROM tb_login WHERE nama=?");
            pst.setString(1, tNamaLengkap.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                if (jenisBank.equals("-- Pilih Bank --")) {
                    JOptionPane.showMessageDialog(null, "Silakan pilih bank terlebih dahulu.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!norek.matches("\\d{10,}")) {
                        JOptionPane.showMessageDialog(null, "Nomor rekening harus berupa angka dan minimal 10 digit.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            conn = Koneksi.getConnection();
                            int totalTransaksi = 0;

                            // Mengambil total transaksi dari kolom subtotal di tabel tb_keranjang
                            pst = conn.prepareStatement("SELECT SUM(subtotal) AS total FROM tb_keranjang");
                            ResultSet rs = pst.executeQuery();
                            if (rs.next()) {
                                totalTransaksi = rs.getInt("total");
                            }

                            pst = conn.prepareStatement("INSERT INTO tb_transaksi (nama_lengkap, bank, norek, total_transaksi) VALUES (?, ?, ?, ?)");
                            pst.setString(1, tNamaLengkap.getText());
                            pst.setString(2, cJenisBank.getSelectedItem().toString());
                            pst.setString(3, tNorek.getText());
                            pst.setInt(4, totalTransaksi);
                            
                            pst.executeUpdate();
                            pst = conn.prepareStatement("DELETE FROM tb_keranjang");
                            pst.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Anda telah melakukan pembelian, informasi pengiriman produk akan dikirim melalu E-Mail Anda", "Informasi", JOptionPane.INFORMATION_MESSAGE);    
                            BuyMedicine BM = new BuyMedicine();
                            BM.setVisible(true);
                            setVisible(false);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nama Anda tidak terdaftar.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bBayarActionPerformed

    private void tNamaLengkapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaLengkapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaLengkapActionPerformed

    private void tNamaLengkapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tNamaLengkapMouseExited

    }//GEN-LAST:event_tNamaLengkapMouseExited

    private void tNorekMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tNorekMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tNorekMouseExited

    private void tNorekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNorekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNorekActionPerformed

    private void tKodePembayaranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKodePembayaranMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tKodePembayaranMouseExited

    private void tKodePembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKodePembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tKodePembayaranActionPerformed

    private void cValidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cValidActionPerformed
        if (cValid.isSelected()) {
            bBayar.setVisible(true);
        } else {
            bBayar.setVisible(false);
        }
    }//GEN-LAST:event_cValidActionPerformed

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
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bBack;
    private javax.swing.JButton bBayar;
    private javax.swing.JComboBox<String> cJenisBank;
    private javax.swing.JCheckBox cValid;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tKodePembayaran;
    private javax.swing.JTextField tNamaLengkap;
    private javax.swing.JTextField tNorek;
    // End of variables declaration//GEN-END:variables
}
