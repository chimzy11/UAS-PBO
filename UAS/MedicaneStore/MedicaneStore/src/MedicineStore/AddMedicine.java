package MedicineStore;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;

public class AddMedicine extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;

    public AddMedicine() {
        initComponents();
    }

    void CekDosis() {
        String input = tDosis.getText();
        try {
            int Sosis = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Dosis harus berupa angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            tDosis.setText("");
            tDosis.requestFocus();
        }
    }

    void CekStok() {
        String input = tStok.getText();
        try {
            int Stok = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Stok harus berupa angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            tStok.setText("");
            tStok.requestFocus();
        }
    }

    void CekHarga() {
        String input = tHarga.getText();
        try {
            int Harga = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga harus berupa angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            tHarga.setText("");
            tHarga.requestFocus();
        }
    }

    boolean cekDataKosong() {
        if (tNamaObat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama obat tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tNamaObat.requestFocus();
            return false;
        }

        if (!(rKering.isSelected() || rBerdahak.isSelected() || rAlergi.isSelected() || rBerkepanjangan.isSelected())) {
            JOptionPane.showMessageDialog(null, "Harap pilih satu gejala", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (cBentukSediaan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Harap pilih bentuk sediaan", "Peringatan", JOptionPane.WARNING_MESSAGE);
            cBentukSediaan.requestFocus();
            return false;
        }

        if (cTanggal.getSelectedIndex() == 0 || cBulan.getSelectedIndex() == 0 || cTahun.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Harap pilih tanggal, bulan, dan tahun", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (tEfekSamping.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Efek samping tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tEfekSamping.requestFocus();
            return false;
        }

        if (tDosis.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dosis tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tDosis.requestFocus();
            return false;
        }

        if (tStok.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Stok tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tStok.requestFocus();
            return false;
        }

        if (tHarga.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tHarga.requestFocus();
            return false;
        }

        CekDosis();
        CekStok();
        CekHarga();
        return true;
    }

    private void clearFields() {
        tNamaObat.setText("");
        buttonGroup.clearSelection();

        cBentukSediaan.setSelectedIndex(0);
        cTanggal.setSelectedIndex(0);
        cBulan.setSelectedIndex(0);
        cTahun.setSelectedIndex(0);

        tEfekSamping.setText("");
        tDosis.setText("");
        tStok.setText("");
        tHarga.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tNamaObat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rBerdahak = new javax.swing.JRadioButton();
        rAlergi = new javax.swing.JRadioButton();
        rBerkepanjangan = new javax.swing.JRadioButton();
        rKering = new javax.swing.JRadioButton();
        cBulan = new javax.swing.JComboBox<>();
        cBentukSediaan = new javax.swing.JComboBox<>();
        cTahun = new javax.swing.JComboBox<>();
        cTanggal = new javax.swing.JComboBox<>();
        tEfekSamping = new javax.swing.JTextField();
        tDosis = new javax.swing.JTextField();
        tStok = new javax.swing.JTextField();
        tHarga = new javax.swing.JTextField();
        lJenisDosis = new javax.swing.JLabel();
        tClear = new javax.swing.JButton();
        tSimpan = new javax.swing.JButton();
        bHome = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(184, 231, 225));
        jLabel7.setText("Nama Lengkap");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(184, 231, 225));

        jPanel2.setBackground(new java.awt.Color(255, 239, 214));

        bBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow (1).png"))); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(158, 111, 33));
        jLabel1.setText("Tambah Data ");

        jPanel3.setBackground(new java.awt.Color(248, 246, 244));

        tNamaObat.setBackground(new java.awt.Color(255, 239, 214));
        tNamaObat.setForeground(new java.awt.Color(158, 111, 33));
        tNamaObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaObatActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(158, 111, 33));
        jLabel8.setText("Nama Obat");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(158, 111, 33));
        jLabel9.setText("Indikasi");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(158, 111, 33));
        jLabel10.setText(" ");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(158, 111, 33));
        jLabel11.setText("Bentuk Sediaan");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(158, 111, 33));
        jLabel12.setText("Tanggal Expired");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(158, 111, 33));
        jLabel13.setText("Harga");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(158, 111, 33));
        jLabel14.setText("Efek Samping");

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(158, 111, 33));
        jLabel15.setText("Dosis");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(158, 111, 33));
        jLabel16.setText("Stok");

        rBerdahak.setBackground(new java.awt.Color(248, 246, 244));
        buttonGroup.add(rBerdahak);
        rBerdahak.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rBerdahak.setForeground(new java.awt.Color(158, 111, 33));
        rBerdahak.setText("Berdahak");
        rBerdahak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rBerdahakMouseClicked(evt);
            }
        });

        rAlergi.setBackground(new java.awt.Color(248, 246, 244));
        buttonGroup.add(rAlergi);
        rAlergi.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rAlergi.setForeground(new java.awt.Color(158, 111, 33));
        rAlergi.setText("Alergi");
        rAlergi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rAlergiMouseClicked(evt);
            }
        });

        rBerkepanjangan.setBackground(new java.awt.Color(248, 246, 244));
        buttonGroup.add(rBerkepanjangan);
        rBerkepanjangan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rBerkepanjangan.setForeground(new java.awt.Color(158, 111, 33));
        rBerkepanjangan.setText("Berkepenjangan");
        rBerkepanjangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rBerkepanjanganMouseClicked(evt);
            }
        });

        rKering.setBackground(new java.awt.Color(248, 246, 244));
        buttonGroup.add(rKering);
        rKering.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        rKering.setForeground(new java.awt.Color(158, 111, 33));
        rKering.setText("Kering");
        rKering.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rKeringMouseClicked(evt);
            }
        });
        rKering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rKeringActionPerformed(evt);
            }
        });

        cBulan.setBackground(new java.awt.Color(255, 239, 214));
        cBulan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cBulan.setForeground(new java.awt.Color(158, 111, 33));
        cBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bulan", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cBulan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cBulanFocusLost(evt);
            }
        });

        cBentukSediaan.setBackground(new java.awt.Color(255, 239, 214));
        cBentukSediaan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cBentukSediaan.setForeground(new java.awt.Color(158, 111, 33));
        cBentukSediaan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Bentuk Sediaan --", "Sirup", "Tablet", "Kapsul", "Tetes", "Inhaler", "Spray tenggorokan" }));
        cBentukSediaan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cBentukSediaanFocusLost(evt);
            }
        });
        cBentukSediaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cBentukSediaanMouseClicked(evt);
            }
        });
        cBentukSediaan.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                cBentukSediaanCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cBentukSediaanInputMethodTextChanged(evt);
            }
        });
        cBentukSediaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBentukSediaanActionPerformed(evt);
            }
        });

        cTahun.setBackground(new java.awt.Color(255, 239, 214));
        cTahun.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cTahun.setForeground(new java.awt.Color(158, 111, 33));
        cTahun.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tahun", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033" }));
        cTahun.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cTahunFocusLost(evt);
            }
        });
        cTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTahunActionPerformed(evt);
            }
        });

        cTanggal.setBackground(new java.awt.Color(255, 239, 214));
        cTanggal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cTanggal.setForeground(new java.awt.Color(158, 111, 33));
        cTanggal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tanggal", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cTanggal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cTanggalFocusLost(evt);
            }
        });

        tEfekSamping.setBackground(new java.awt.Color(255, 239, 214));
        tEfekSamping.setForeground(new java.awt.Color(158, 111, 33));
        tEfekSamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tEfekSampingActionPerformed(evt);
            }
        });

        tDosis.setBackground(new java.awt.Color(255, 239, 214));
        tDosis.setForeground(new java.awt.Color(158, 111, 33));
        tDosis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tDosisFocusLost(evt);
            }
        });
        tDosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDosisActionPerformed(evt);
            }
        });

        tStok.setBackground(new java.awt.Color(255, 239, 214));
        tStok.setForeground(new java.awt.Color(158, 111, 33));
        tStok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tStokFocusLost(evt);
            }
        });
        tStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tStokActionPerformed(evt);
            }
        });

        tHarga.setBackground(new java.awt.Color(255, 239, 214));
        tHarga.setForeground(new java.awt.Color(158, 111, 33));
        tHarga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tHargaFocusLost(evt);
            }
        });
        tHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHargaActionPerformed(evt);
            }
        });

        lJenisDosis.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lJenisDosis.setForeground(new java.awt.Color(158, 111, 33));
        lJenisDosis.setText("ml");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel10))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tEfekSamping)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(rKering, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(rBerdahak, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(rAlergi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(rBerkepanjangan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(cBentukSediaan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(tNamaObat)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(cTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(tDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lJenisDosis))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(25, 25, 25))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rKering)
                            .addComponent(rBerdahak))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rAlergi)
                                .addComponent(rBerkepanjangan)))))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cBentukSediaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(tEfekSamping, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lJenisDosis)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tClear.setBackground(new java.awt.Color(184, 231, 225));
        tClear.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tClear.setForeground(new java.awt.Color(158, 111, 33));
        tClear.setText("Clear");
        tClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tClearActionPerformed(evt);
            }
        });

        tSimpan.setBackground(new java.awt.Color(184, 231, 225));
        tSimpan.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tSimpan.setForeground(new java.awt.Color(158, 111, 33));
        tSimpan.setText("Simpan");
        tSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tSimpanMouseClicked(evt);
            }
        });
        tSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSimpanActionPerformed(evt);
            }
        });

        bHome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bHome.setForeground(new java.awt.Color(158, 111, 33));
        bHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        bHome.setText("   Dashboard");
        bHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bHomeMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/drugs.png"))); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel5.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jLabel5CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(21, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(161, 161, 161)
                                .addComponent(tClear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(135, 135, 135)
                    .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(135, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(305, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tClear)
                        .addComponent(tSimpan))
                    .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(201, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(358, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void bBackCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_bBackCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_bBackCaretPositionChanged

    private void tNamaObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaObatActionPerformed

    }//GEN-LAST:event_tNamaObatActionPerformed

    private void rKeringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rKeringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rKeringActionPerformed

    private void tEfekSampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tEfekSampingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tEfekSampingActionPerformed

    private void tDosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDosisActionPerformed

    }//GEN-LAST:event_tDosisActionPerformed

    private void tStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tStokActionPerformed

    }//GEN-LAST:event_tStokActionPerformed

    private void tHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tHargaActionPerformed

    private void tClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tClearActionPerformed
        clearFields();
    }//GEN-LAST:event_tClearActionPerformed

    private void tSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSimpanActionPerformed
        Medicaine medicane = new Medicaine(0, null, null, null, null, null, null, 0, 0);

        if (cekDataKosong()) {
            String NamaObat = tNamaObat.getText();
            medicane.setNamaObat(NamaObat);

            String indikasiObat = "";

            if (rKering.isSelected()) {
                indikasiObat = "Batuk Kering";
            } else if (rBerdahak.isSelected()) {
                indikasiObat = "Batuk Berdahak";
            } else if (rAlergi.isSelected()) {
                indikasiObat = "Batuk Alergi";
            } else if (rBerkepanjangan.isSelected()) {
                indikasiObat = "Batuk Berkepanjangan";
            }

            medicane.setIndikasi(indikasiObat);

            String bentukSediaan = cBentukSediaan.getSelectedItem().toString();
            medicane.setBentukSediaan(bentukSediaan);

            String EfekSamping = tEfekSamping.getText();
            medicane.setEfekSamping(EfekSamping);

            String Dosis = tDosis.getText();
            medicane.setDosis(Dosis);

            int Stok = Integer.parseInt(tStok.getText());
            medicane.setStok(Stok);

            int harga = Integer.parseInt(tHarga.getText());
            medicane.setHarga(harga);

            try {
                conn = Koneksi.getConnection();
                pst = conn.prepareStatement("SELECT * FROM tb_obat WHERE nama=?");
                pst.setString(1, medicane.getNamaObat());
                rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Nama obat sudah ada didatabase.");
                } else {

                    String TanggalExp = cTanggal.getSelectedItem().toString();
                    String BulanExp = cBulan.getSelectedItem().toString();
                    String TahunExp = cTahun.getSelectedItem().toString();

                    LocalDate selectedDate = LocalDate.parse(TahunExp + "-" + BulanExp + "-" + TanggalExp);
                    LocalDate currentDate = LocalDate.now();

                    if (selectedDate.isBefore(currentDate)) {
                        JOptionPane.showMessageDialog(null, "Tanggal expired sudah lewat.");
                        return;
                    } else {
                        String Expired = TahunExp + "-" + BulanExp + "-" + TanggalExp;
                        medicane.setTanggalExp(Expired);
                    }

                    pst = conn.prepareStatement("INSERT INTO tb_obat (nama, indikasi, bentuk, expired, efek_samping, dosis, stok, harga) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    pst.setString(1, medicane.getNamaObat());
                    pst.setString(2, medicane.getIndikasi());
                    pst.setString(3, medicane.getBentukSediaan());
                    pst.setString(4, medicane.getTanggalExp());
                    pst.setString(5, medicane.getEfekSamping());
                    pst.setString(6, medicane.getDosis() + " " + cBentukSediaan.getSelectedItem().toString());
                    pst.setInt(7, medicane.getStok());
                    pst.setInt(8, medicane.getHarga());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data baru berhasil ditambahkan.");

                    ManageMedicine MM = new ManageMedicine();
                    MM.refreshTable();
                    MM.setVisible(true);
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tSimpanActionPerformed

    private void bHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bHomeMouseClicked

    }//GEN-LAST:event_bHomeMouseClicked

    private void jLabel5CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabel5CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5CaretPositionChanged

    private void bBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBackMouseClicked
        setVisible(false);
    }//GEN-LAST:event_bBackMouseClicked

    private void tSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSimpanMouseClicked
        Medicaine medicane = new Medicaine(0, null, null, null, null, null, null, 0, 0);

        if (cekDataKosong()) {
            String NamaObat = tNamaObat.getText();
            medicane.setNamaObat(NamaObat);

            String indikasiObat = "";

            if (rKering.isSelected()) {
                indikasiObat = "Batuk Kering";
            } else if (rBerdahak.isSelected()) {
                indikasiObat = "Batuk Berdahak";
            } else if (rAlergi.isSelected()) {
                indikasiObat = "Batuk Alergi";
            } else if (rBerkepanjangan.isSelected()) {
                indikasiObat = "Batuk Berkepanjangan";
            }

            medicane.setIndikasi(indikasiObat);

            String bentukSediaan = cBentukSediaan.getSelectedItem().toString();
            medicane.setBentukSediaan(bentukSediaan);

            String EfekSamping = tEfekSamping.getText();
            medicane.setEfekSamping(EfekSamping);

            String Dosis = tDosis.getText();
            medicane.setDosis(Dosis);

            int Stok = Integer.parseInt(tStok.getText());
            medicane.setStok(Stok);

            int harga = Integer.parseInt(tHarga.getText());
            medicane.setHarga(harga);

            try {
                conn = Koneksi.getConnection();
                pst = conn.prepareStatement("SELECT * FROM tb_obat WHERE nama=?");
                pst.setString(1, medicane.getNamaObat());
                rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Nama obat sudah ada didatabase.");
                } else {

                    String TanggalExp = cTanggal.getSelectedItem().toString();
                    String BulanExp = cBulan.getSelectedItem().toString();
                    String TahunExp = cTahun.getSelectedItem().toString();

                    LocalDate selectedDate = LocalDate.parse(TahunExp + "-" + BulanExp + "-" + TanggalExp);
                    LocalDate currentDate = LocalDate.now();

                    if (selectedDate.isBefore(currentDate)) {
                        JOptionPane.showMessageDialog(null, "Tanggal expired sudah lewat.");
                        return;
                    } else {
                        String Expired = TahunExp + "-" + BulanExp + "-" + TanggalExp;
                        medicane.setTanggalExp(Expired);
                    }

                    pst = conn.prepareStatement("INSERT INTO tb_obat (nama, indikasi, bentuk, expired, efek_samping, dosis, stok, harga) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    pst.setString(1, medicane.getNamaObat());
                    pst.setString(2, medicane.getIndikasi());
                    pst.setString(3, medicane.getBentukSediaan() + " " + cBentukSediaan.getSelectedItem().toString());
                    pst.setString(4, medicane.getTanggalExp());
                    pst.setString(5, medicane.getEfekSamping());
                    pst.setString(6, medicane.getDosis());
                    pst.setInt(7, medicane.getStok());
                    pst.setInt(8, medicane.getHarga());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data baru berhasil ditambahkan.");

                    ManageMedicine MM = new ManageMedicine();
                    MM.refreshTable();
                    MM.setVisible(true);
                    setVisible(false);
                }
            } catch (HeadlessException | SQLException e) {
            }
        }
    }//GEN-LAST:event_tSimpanMouseClicked

    private void rKeringMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rKeringMouseClicked

    }//GEN-LAST:event_rKeringMouseClicked

    private void rBerdahakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rBerdahakMouseClicked

    }//GEN-LAST:event_rBerdahakMouseClicked

    private void rAlergiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rAlergiMouseClicked

    }//GEN-LAST:event_rAlergiMouseClicked

    private void rBerkepanjanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rBerkepanjanganMouseClicked

    }//GEN-LAST:event_rBerkepanjanganMouseClicked

    private void cBentukSediaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cBentukSediaanMouseClicked

    }//GEN-LAST:event_cBentukSediaanMouseClicked

    private void cBentukSediaanInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cBentukSediaanInputMethodTextChanged

    }//GEN-LAST:event_cBentukSediaanInputMethodTextChanged

    private void cBentukSediaanCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cBentukSediaanCaretPositionChanged

    }//GEN-LAST:event_cBentukSediaanCaretPositionChanged

    private void cBentukSediaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBentukSediaanActionPerformed
        String bentukSediaan = cBentukSediaan.getSelectedItem().toString();
        String jenisDosis = "";

        if (bentukSediaan.equals("Sirup")) {
            jenisDosis = "ml";
        } else if (bentukSediaan.equals("Tablet")) {
            jenisDosis = "mg";
        } else if (bentukSediaan.equals("Kapsul")) {
            jenisDosis = "kapsul";
        } else if (bentukSediaan.equals("Tetes")) {
            jenisDosis = "tetes";
        } else if (bentukSediaan.equals("Inhaler")) {
            jenisDosis = "puff";
        } else if (bentukSediaan.equals("Spray tenggorokan")) {
            jenisDosis = "semprotan";
        }

        lJenisDosis.setText(jenisDosis);
    }//GEN-LAST:event_cBentukSediaanActionPerformed

    private void cTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTahunActionPerformed

    }//GEN-LAST:event_cTahunActionPerformed

    private void tDosisFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDosisFocusLost
    }//GEN-LAST:event_tDosisFocusLost

    private void tStokFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tStokFocusLost

    }//GEN-LAST:event_tStokFocusLost

    private void tHargaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tHargaFocusLost

    }//GEN-LAST:event_tHargaFocusLost

    private void cBentukSediaanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cBentukSediaanFocusLost

    }//GEN-LAST:event_cBentukSediaanFocusLost

    private void cTanggalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cTanggalFocusLost

    }//GEN-LAST:event_cTanggalFocusLost

    private void cBulanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cBulanFocusLost

    }//GEN-LAST:event_cBulanFocusLost

    private void cTahunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cTahunFocusLost

    }//GEN-LAST:event_cTahunFocusLost

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
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bBack;
    private javax.swing.JLabel bHome;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> cBentukSediaan;
    private javax.swing.JComboBox<String> cBulan;
    private javax.swing.JComboBox<String> cTahun;
    private javax.swing.JComboBox<String> cTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lJenisDosis;
    private javax.swing.JRadioButton rAlergi;
    private javax.swing.JRadioButton rBerdahak;
    private javax.swing.JRadioButton rBerkepanjangan;
    private javax.swing.JRadioButton rKering;
    private javax.swing.JButton tClear;
    private javax.swing.JTextField tDosis;
    private javax.swing.JTextField tEfekSamping;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tNamaObat;
    private javax.swing.JButton tSimpan;
    private javax.swing.JTextField tStok;
    // End of variables declaration//GEN-END:variables
}
