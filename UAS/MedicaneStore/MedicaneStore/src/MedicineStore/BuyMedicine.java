package MedicineStore;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class BuyMedicine extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public BuyMedicine() {
        initComponents();
        refreshTable();
        tTotalHarga.setText("0");
       
        DefaultTableModel modelObat = (DefaultTableModel) TableObat.getModel();
        DefaultTableModel modelKeranjang = (DefaultTableModel) TableKeranjang.getModel();
        modelKeranjang.setRowCount(0);
        TableKeranjang.setModel(modelObat);
        TableKeranjang.setModel(modelKeranjang);

        TableObat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = TableObat.getSelectedRow();
                if (row != -1) {
                    try {
                        String namaObat = (String) modelObat.getValueAt(row, 0);
                        int harga = (int) modelObat.getValueAt(row, 3);

                        boolean obatSudahAda = false;
                        for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
                            String namaObatKeranjang = (String) modelKeranjang.getValueAt(i, 0);
                            if (namaObatKeranjang.equals(namaObat)) {
                                obatSudahAda = true;
                                break;
                            }
                        }

                        if (obatSudahAda) {
                            JOptionPane.showMessageDialog(null, "Obat sudah ditambahkan ke keranjang.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            Object[] rowData = new Object[]{namaObat, 1, harga};
                            modelKeranjang.addRow(rowData);
                            int totalHarga = 0;
                            for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
                                int hargaBaris = (int) modelKeranjang.getValueAt(i, 2);
                                totalHarga += hargaBaris;
                            }
                            tTotalHarga.setText(String.valueOf(totalHarga));
                        }
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
    TableKeranjang.getModel().addTableModelListener(new TableModelListener() {
        DefaultTableModel modelObat = (DefaultTableModel) TableObat.getModel();

        @Override
        public void tableChanged(TableModelEvent e) {
            if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 1) {
                int row = e.getFirstRow();
                String jumlahStr = (String) modelKeranjang.getValueAt(row, 1);
                int jumlah;
                try {
                    jumlah = Integer.parseInt(jumlahStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Jumlah harus berupa angka.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                    modelKeranjang.setValueAt("1", row, 1);
                    return;
                }
                int harga = (int) modelKeranjang.getValueAt(row, 2);

                try {
                    conn = Koneksi.getConnection();
                    String NamaObat = modelObat.getValueAt(row, 0).toString();
                    pst = conn.prepareStatement("SELECT stok FROM tb_obat WHERE nama = ?");
                    pst.setString(1, NamaObat);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        int stok = rs.getInt("stok");

                        if (jumlah == 0 || jumlah > stok) {
                            JOptionPane.showMessageDialog(null, "Jumlah tidak sesuai dengan stok yang tersedia.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                            modelKeranjang.setValueAt("1", row, 1);
                            return;
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                int hargaTotal = jumlah * harga;
                modelKeranjang.setValueAt(hargaTotal, row, 2);
                
                int totalHarga = 0;
                for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
                    int hargaBaris = (int) modelKeranjang.getValueAt(i, 2);
                    totalHarga += hargaBaris;
                }
                tTotalHarga.setText(String.valueOf(totalHarga));
            }
        }
    });
    }
    
    void refreshTable() {
        try {
            conn = Koneksi.getConnection();
            pst = conn.prepareStatement("SELECT * FROM tb_obat");
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) TableObat.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("nama");
                row[1] = rs.getString("indikasi");
                row[2] = rs.getString("bentuk");
                row[3] = rs.getInt("harga");

                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void Searching(){
        String keyword = tSearch.getText();

        try {
            String sql = "SELECT * FROM tb_obat WHERE nama LIKE ?";
            Connection conn = Koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();

            // Menghapus data dari tabel sebelum menampilkan hasil pencarian
            DefaultTableModel model = (DefaultTableModel) TableObat.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                Object[] row = new Object[8];
                row[0] = rs.getString("nama");
                row[1] = rs.getString("indikasi");
                row[2] = rs.getString("bentuk");
                row[3] = rs.getString("expired");
                row[4] = rs.getString("efek_samping");
                row[5] = rs.getString("dosis");
                row[6] = rs.getInt("stok");
                row[7] = rs.getInt("harga");

                model.addRow(row);
            }
            if (model.getRowCount() <= 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                refreshTable();
                tSearch.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error executing SQL statement: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bHome = new javax.swing.JLabel();
        bBuyMenu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableKeranjang = new javax.swing.JTable();
        bDetail = new javax.swing.JButton();
        tSearch = new javax.swing.JTextField();
        bSearch = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableObat = new javax.swing.JTable();
        bBuy = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tTotalHarga = new javax.swing.JLabel();
        bCancel = new javax.swing.JButton();
        bDetailProduk = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(221, 212, 199));

        jPanel4.setBackground(new java.awt.Color(184, 231, 225));
        jPanel4.setForeground(new java.awt.Color(184, 231, 225));

        jLabel11.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(158, 111, 33));
        jLabel11.setText("   HEALED");

        jLabel12.setFont(new java.awt.Font("Segoe Script", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(158, 111, 33));
        jLabel12.setText("Cough Medicine Store");

        bHome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bHome.setForeground(new java.awt.Color(158, 111, 33));
        bHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        bHome.setText("     HOME");
        bHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bHomeMouseClicked(evt);
            }
        });

        bBuyMenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bBuyMenu.setForeground(new java.awt.Color(158, 111, 33));
        bBuyMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-to-basket.png"))); // NOI18N
        bBuyMenu.setText("     BUY");
        bBuyMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuyMenuMouseClicked(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pharmacy.png"))); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel9.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jLabel9CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(bBuyMenu)
                .addGap(248, 248, 248))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bBuyMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(248, 246, 244));
        jPanel5.setForeground(new java.awt.Color(248, 246, 244));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 100));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jLabel3.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jLabel3CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(158, 111, 33));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/address (1).png"))); // NOI18N
        jLabel2.setText("     Samarinda, Kalimantan Timur");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(158, 111, 33));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/instagram.png"))); // NOI18N
        jLabel8.setText("     @HealedCoughMedicineStore");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(184, 231, 225));
        jPanel6.setForeground(new java.awt.Color(184, 231, 225));

        jLabel15.setText("L");

        TableKeranjang.setAutoCreateRowSorter(true);
        TableKeranjang.setBackground(new java.awt.Color(255, 239, 214));
        TableKeranjang.setForeground(new java.awt.Color(158, 111, 33));
        TableKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama Obat", "Jumlah", "Sub Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableKeranjang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TableKeranjang.setGridColor(new java.awt.Color(158, 111, 33));
        TableKeranjang.setSelectionBackground(new java.awt.Color(184, 231, 225));
        TableKeranjang.setSelectionForeground(new java.awt.Color(158, 111, 33));
        jScrollPane1.setViewportView(TableKeranjang);

        bDetail.setBackground(new java.awt.Color(158, 111, 33));
        bDetail.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bDetail.setForeground(new java.awt.Color(184, 231, 225));
        bDetail.setText("Detail");
        bDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDetailMouseClicked(evt);
            }
        });
        bDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDetailActionPerformed(evt);
            }
        });

        tSearch.setBackground(new java.awt.Color(255, 239, 214));
        tSearch.setForeground(new java.awt.Color(158, 111, 33));
        tSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tSearchMouseEntered(evt);
            }
        });

        bSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/loupe.png"))); // NOI18N
        bSearch.setPreferredSize(new java.awt.Dimension(100, 100));
        bSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSearchMouseClicked(evt);
            }
        });
        bSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                bSearchCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        TableObat.setAutoCreateRowSorter(true);
        TableObat.setBackground(new java.awt.Color(255, 239, 214));
        TableObat.setForeground(new java.awt.Color(158, 111, 33));
        TableObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Obat", "Indikasi ", "Bentuk ", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableObat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TableObat.setGridColor(new java.awt.Color(158, 111, 33));
        TableObat.setSelectionBackground(new java.awt.Color(184, 231, 225));
        TableObat.setSelectionForeground(new java.awt.Color(158, 111, 33));
        jScrollPane2.setViewportView(TableObat);

        bBuy.setBackground(new java.awt.Color(158, 111, 33));
        bBuy.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bBuy.setForeground(new java.awt.Color(184, 231, 225));
        bBuy.setText("Buy");
        bBuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuyMouseClicked(evt);
            }
        });
        bBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuyActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(158, 111, 33));
        jLabel13.setText("Total    : Rp.");

        tTotalHarga.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tTotalHarga.setForeground(new java.awt.Color(158, 111, 33));
        tTotalHarga.setText("100000");

        bCancel.setBackground(new java.awt.Color(158, 111, 33));
        bCancel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bCancel.setForeground(new java.awt.Color(184, 231, 225));
        bCancel.setText("Cancel");
        bCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCancelMouseClicked(evt);
            }
        });
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });

        bDetailProduk.setBackground(new java.awt.Color(184, 231, 225));
        bDetailProduk.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bDetailProduk.setForeground(new java.awt.Color(158, 111, 33));
        bDetailProduk.setText("Detail");
        bDetailProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDetailProdukActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(158, 111, 33));
        jLabel14.setText("KERANJANG");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bDetailProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tTotalHarga)
                                        .addGap(14, 14, 14))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(bCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bDetail)
                                .addComponent(bDetailProduk))
                            .addComponent(tSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tTotalHarga))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bBuy)
                            .addComponent(bCancel)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15))
        );

        jLabel17.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("BUY COUGH MEDICINE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 734, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bHomeMouseClicked
        DashboardUser DA = new DashboardUser();
        DA.setVisible(true);
        dispose();
    }//GEN-LAST:event_bHomeMouseClicked

    private void bBuyMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuyMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuyMenuMouseClicked

    private void jLabel9CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabel9CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9CaretPositionChanged

    private void tSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tSearchMouseEntered
        Searching();
    }//GEN-LAST:event_tSearchMouseEntered

    private void bSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSearchMouseClicked
        Searching();
    }//GEN-LAST:event_bSearchMouseClicked

    private void bSearchCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_bSearchCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_bSearchCaretPositionChanged

    private void bDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDetailMouseClicked

    }//GEN-LAST:event_bDetailMouseClicked

    private void bDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bDetailActionPerformed

    private void bBuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuyMouseClicked
        DefaultTableModel modelKeranjang = (DefaultTableModel) TableKeranjang.getModel();

         try {
             conn = Koneksi.getConnection();
             String query = "INSERT INTO tb_keranjang (nama, jumlah, subtotal) VALUES (?, ?, ?)";
             pst = conn.prepareStatement(query);

             for (int row = 0; row < modelKeranjang.getRowCount(); row++) {
                 String nama = modelKeranjang.getValueAt(row, 0).toString();
                 int jumlah = Integer.parseInt(modelKeranjang.getValueAt(row, 1).toString());
                 int subtotalHarga = Integer.parseInt(modelKeranjang.getValueAt(row, 2).toString());

                 pst.setString(1, nama);
                 pst.setInt(2, jumlah);
                 pst.setInt(3, subtotalHarga);

                 pst.executeUpdate();

                 String updateStokQuery = "UPDATE tb_obat SET stok = stok - ? WHERE nama = ?";
                 PreparedStatement updateStokPst = conn.prepareStatement(updateStokQuery);
                 updateStokPst.setInt(1, jumlah);
                 updateStokPst.setString(2, nama);
                 updateStokPst.executeUpdate();
             }
             Pembayaran P = new Pembayaran();
             P.setVisible(true);
        } catch (SQLException ex) {
             ex.printStackTrace();
             JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data ke tabel keranjang.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bBuyMouseClicked

    private void bBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bBuyActionPerformed

    private void bCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelMouseClicked
        DefaultTableModel modelKeranjang = (DefaultTableModel) TableKeranjang.getModel();
        modelKeranjang.setRowCount(0);  
        tTotalHarga.setText(String.valueOf("0"));
    }//GEN-LAST:event_bCancelMouseClicked

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bCancelActionPerformed

    private void bDetailProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDetailProdukActionPerformed
        DetailMedicine DA = new DetailMedicine();
        DA.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_bDetailProdukActionPerformed

    private void jLabel3CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabel3CaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3CaretPositionChanged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked
 
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
            java.util.logging.Logger.getLogger(BuyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableKeranjang;
    private javax.swing.JTable TableObat;
    private javax.swing.JButton bBuy;
    private javax.swing.JLabel bBuyMenu;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bDetail;
    private javax.swing.JButton bDetailProduk;
    private javax.swing.JLabel bHome;
    private javax.swing.JLabel bSearch;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tSearch;
    private javax.swing.JLabel tTotalHarga;
    // End of variables declaration//GEN-END:variables
}
