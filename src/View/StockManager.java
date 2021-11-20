package View;

import Controller.StockDao;
import Model.Stock;
import Util.DatabaseConnector;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author hirwa
 */
public class StockManager extends javax.swing.JFrame {

    DatabaseConnector connector = new DatabaseConnector();
    String selectedName;
    
    public StockManager() {
        initComponents();
        displayInJTable();
    }

    public void resetFields(){
        typeComboBox.setSelectedIndex(0);
        nameTextField.setText(null);
        quantityComboBox.setSelectedIndex(0);
        qualityComboBox.setSelectedIndex(0);
        priceTextField.setText(null);
        entryDateDateChooser.setDate(null);
    }
    
    private void displayInJTable(){
        try {
            connector.getConnection();
            String selectDataQuerry = "SELECT * FROM stock";
            connector.s = connector.con.createStatement();
            connector.rs = connector.s.executeQuery(selectDataQuerry);
            
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            model.setRowCount(0);
            
            while(connector.rs.next()){
                String type = connector.rs.getString(1);
                String name = connector.rs.getString(2);
                String quantity = connector.rs.getString(3);
                String quality = connector.rs.getString(4);
                String price = connector.rs.getString(5);
                String date = connector.rs.getString(6);
                
                model.addRow(new Object[] {type, name, quantity, quality, price, date});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connector.getDisconnection();
        }
    
    }
    
    private void update(Stock st){
        try {
            connector.getConnection();
            String updateQuerry = "UPDATE stock SET type=?, name=?, quantity=?, quality=?, price=?, entryDate=? WHERE name=?";
            connector.ps = connector.con.prepareStatement(updateQuerry);
            
            connector.ps.setString(1, st.getType());
            connector.ps.setString(2, st.getName());
            connector.ps.setString(3, st.getQuantity());
            connector.ps.setString(4, st.getQuality());
            connector.ps.setString(5, st.getPrice());
            connector.ps.setString(6, st.getEntryDate());
            connector.ps.setString(7, selectedName);
            connector.ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        typeComboBox = new javax.swing.JComboBox<>();
        quantityComboBox = new javax.swing.JComboBox<>();
        qualityComboBox = new javax.swing.JComboBox<>();
        priceTextField = new javax.swing.JTextField();
        entryDateDateChooser = new com.toedter.calendar.JDateChooser();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButon = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Manager Demo");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Stock Manager");

        jLabel2.setText("Type");

        jLabel3.setText("Name");

        jLabel4.setText("Quantity");

        jLabel5.setText("Quality");

        jLabel6.setText("Entry date");

        jLabel7.setText("Price");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruits", "Cereals", "Vegetables", "Beverages", "Meat", "Pastry", "Others" }));

        quantityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));

        qualityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Very Good", "Good", "Acceptable", "Poor" }));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButon.setText("Delete");
        deleteButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset/Clear");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Name", "Quantity", "Quality", "Price", "Entry Date"
            }
        ));
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameTextField)
                                    .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quantityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(qualityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priceTextField)
                                    .addComponent(entryDateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(quantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(qualityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(18, 18, 18)
                        .addComponent(updateButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButon)
                        .addGap(18, 18, 18)
                        .addComponent(resetButton)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(entryDateDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
       //Step1: Get data from input spaces.
       String type = typeComboBox.getSelectedItem().toString();
       String name = nameTextField.getText();
       String quantity = quantityComboBox.getSelectedItem().toString();
       String quality = qualityComboBox.getSelectedItem().toString();
       String price = priceTextField.getText();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       String date = dateFormat.format(entryDateDateChooser.getDate());
       
       //Step2: Send data into the model class
        Stock stock = new Stock(type, name, quantity, quality, price, date);
       
        //Step3: Tell DAO or Controller class to save data
        StockDao stockDao = new StockDao();
        stockDao.save(stock);
        
       //Step4: Additional commands.
        displayInJTable();
        resetFields();
        JOptionPane.showMessageDialog(rootPane, "Saved!");
    }//GEN-LAST:event_saveButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
            int selectedRow = dataTable.getSelectedRow();
            
            selectedName = model.getValueAt(selectedRow, 1).toString(); 
            
            typeComboBox.setSelectedItem(model.getValueAt(selectedRow, 0).toString());
            nameTextField.setText(model.getValueAt(selectedRow, 1).toString());
            quantityComboBox.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
            qualityComboBox.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
            priceTextField.setText(model.getValueAt(selectedRow, 4).toString());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 5).toString());
            entryDateDateChooser.setDate(date);
            
        } catch (ParseException ex) {
            Logger.getLogger(StockManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_dataTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
       //Step1: Get data from input spaces.
       String type = typeComboBox.getSelectedItem().toString();
       String name = nameTextField.getText();
       String quantity = quantityComboBox.getSelectedItem().toString();
       String quality = qualityComboBox.getSelectedItem().toString();
       String price = priceTextField.getText();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       String date = dateFormat.format(entryDateDateChooser.getDate());
       
       //Step2: Send data into the model class
        Stock stock = new Stock(type, name, quantity, quality, price, date);
       
        update(stock);
        
        displayInJTable();
        resetFields();
        JOptionPane.showMessageDialog(rootPane, "Update!");
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButonActionPerformed
        Stock st = new Stock();
        st.setName(selectedName);
        
        StockDao stdao = new StockDao();
        stdao.delete(st);
        
        displayInJTable();
        resetFields();
        JOptionPane.showMessageDialog(rootPane, "Deleted!");
    }//GEN-LAST:event_deleteButonActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JButton deleteButon;
    private com.toedter.calendar.JDateChooser entryDateDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JComboBox<String> qualityComboBox;
    private javax.swing.JComboBox<String> quantityComboBox;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
