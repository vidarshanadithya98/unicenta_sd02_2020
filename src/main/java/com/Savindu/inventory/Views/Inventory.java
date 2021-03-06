/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.inventory.Views;

import com.Savindu.inventory.Entity.Products;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Savindu
 */
public class Inventory extends javax.swing.JPanel {

    /**
     * Creates new form Inventory
     */


    //AppInterface ap = new AppInterface();
    Products product = new Products();
    ArrayList<String> filePathList = new ArrayList<>();

    public Inventory() {
        initComponents();
        customJTable(tbl_Products);
        addProductsToTable();
        //product_search.setVisible(false);


        DocumentListener documentListener = new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                search(product_search.getText());
            }
            public void insertUpdate(DocumentEvent documentEvent) {
                search(product_search.getText());
            }
            public void removeUpdate(DocumentEvent documentEvent) {
                search(product_search.getText());
            }
          };

      product_search.getDocument().addDocumentListener(documentListener);

    }

    public void customJTable(JTable table){
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(55,71,79));
        table.getTableHeader().setForeground(new Color(0,51,51));
        table.setRowHeight(100);
        table.setAutoCreateRowSorter(true);
    }

     public void addProductsToTable() {
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int column) {
                if (column==1) return ImageIcon.class;
                return Object.class;
            }
        };

        ArrayList<Products> list = new ArrayList<>();
        list = product.getProducts();

        if(filePathList.size() > 0){
            filePathList.clear();
        }

        Object rowData[] = new Object[7];
        Object columns[] = new Object[7];
        columns[0] = " ID";
        columns[1] = " Img";
        columns[2] = " Barcode";
        columns[3] = " Name";
        columns[4] = " Category";
        columns[5] = " Description";
        columns[6] = " Uploaded On";

        model.setColumnIdentifiers(columns);

        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).getId();
            filePathList.add(list.get(i).getImg());
            if(list.get(i).getImg() != null){
                rowData[1] = resizeImg(list.get(i).getImg());
            }
            rowData[2] = list.get(i).getBarcode();
            rowData[3] = list.get(i).getName();
            rowData[4] = list.get(i).getCategory();
            rowData[5] = list.get(i).getDesc();
            rowData[6] = list.get(i).getUploadedOn();
            model.addRow(rowData);
        }
        System.out.println("filePathList: "+Arrays.toString(filePathList.toArray()));
        tbl_Products.setModel(model);
    }

      public ImageIcon resizeImg(String filePath){
          ImageIcon imageIcon = null;
        if(filePath != null){
            BufferedImage img = null;
            File tmpDir = new File(filePath);
            boolean exists = tmpDir.exists();
            if(!exists){
             filePath = "Products\\\\image-not-found.png";
            }
            try {
                img = ImageIO.read(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Image dimg = img.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(dimg);

        }
        return imageIcon;
    }

      public void search(String str){
        DefaultTableModel md = ((DefaultTableModel)tbl_Products.getModel());
        TableRowSorter sorter = new TableRowSorter<>(md);
        tbl_Products.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
      }

       private void writeToExcell(JTable table, String path) throws FileNotFoundException, IOException {
            new WorkbookFactory();
            Workbook wb = new XSSFWorkbook(); //Excell workbook
            Sheet sheet = wb.createSheet(); //WorkSheet
            Row row = sheet.createRow(2); //Row created at line 3
            TableModel model = table.getModel(); //Table model


            Row headerRow = sheet.createRow(0); //Create row at line 0
            for(int headings = 0; headings < model.getColumnCount(); headings++){ //For each column
                headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
            }

            for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
                for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
                    row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
                }

                //Set the row to the next one in the sequence
                row = sheet.createRow((rows + 3));
            }
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String fileName = path+"\\"+"Inventory_Products_"+timestamp.getTime()+".xlsx";
            File newFile = new File(fileName);
            System.out.println(fileName);
            newFile.createNewFile(); // if file already exists will do nothing
            FileOutputStream out = new FileOutputStream(newFile);
            wb.write(out);//Save the file

            if(newFile.exists()){
                JOptionPane.showMessageDialog(null, "Excel File has successfully Exported to "+fileName);
            }

            out.close();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        refresh = new javax.swing.JLabel();
        btn_product_add = new javax.swing.JLabel();
        btn_product_edit = new javax.swing.JLabel();
        btn_product_delete = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        product_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Products = new javax.swing.JTable();
        btn_export = new javax.swing.JButton();

        setBackground(new java.awt.Color(28, 35, 51));

        jPanel1.setBackground(new java.awt.Color(55, 71, 79));
        jPanel1.setPreferredSize(new java.awt.Dimension(1032, 120));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(55, 71, 79));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        refresh.setBackground(new java.awt.Color(55, 71, 79));
        refresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refresh.setForeground(new java.awt.Color(244, 244, 244));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-refresh-32.png"))); // NOI18N
        refresh.setText("Refresh ");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshMouseExited(evt);
            }
        });
        jPanel1.add(refresh);

        btn_product_add.setBackground(new java.awt.Color(55, 71, 79));
        btn_product_add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_product_add.setForeground(new java.awt.Color(244, 244, 244));
        btn_product_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-add-32.png"))); // NOI18N
        btn_product_add.setText("New Product");
        btn_product_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_product_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_product_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_product_addMouseExited(evt);
            }
        });
        jPanel1.add(btn_product_add);

        btn_product_edit.setBackground(new java.awt.Color(55, 71, 79));
        btn_product_edit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_product_edit.setForeground(new java.awt.Color(244, 244, 244));
        btn_product_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-edit-32.png"))); // NOI18N
        btn_product_edit.setText("Edit Product");
        btn_product_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_product_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_product_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_product_editMouseExited(evt);
            }
        });
        jPanel1.add(btn_product_edit);

        btn_product_delete.setBackground(new java.awt.Color(55, 71, 79));
        btn_product_delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_product_delete.setForeground(new java.awt.Color(244, 244, 244));
        btn_product_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-delete-view-32.png"))); // NOI18N
        btn_product_delete.setText("Delete Product");
        btn_product_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_product_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_product_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_product_deleteMouseExited(evt);
            }
        });
        jPanel1.add(btn_product_delete);

        search.setBackground(new java.awt.Color(55, 71, 79));

        product_search.setBackground(new java.awt.Color(28, 35, 51));
        product_search.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        product_search.setForeground(new java.awt.Color(244, 244, 244));
        product_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        product_search.setText("Search");
        product_search.setBorder(null);
        product_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_searchMouseClicked(evt);
            }
        });
        product_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_searchActionPerformed(evt);
            }
        });
        product_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                product_searchKeyTyped(evt);
            }
        });
        product_search.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                product_searchVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_search, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(product_search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.add(search);

        tbl_Products.setBackground(new java.awt.Color(55, 71, 79));
        tbl_Products.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tbl_Products.setForeground(new java.awt.Color(244, 244, 244));
        tbl_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_Products.setFocusable(false);
        tbl_Products.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_Products.setRowHeight(75);
        tbl_Products.setSelectionBackground(new java.awt.Color(28, 35, 51));
        tbl_Products.setShowVerticalLines(false);
        tbl_Products.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_Products);

        btn_export.setBackground(new java.awt.Color(55, 71, 79));
        btn_export.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        btn_export.setForeground(new java.awt.Color(244, 244, 244));
        btn_export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-export-excel-36 (1).png"))); // NOI18N
        btn_export.setText("Export to Excel");
        btn_export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_export)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_export)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void product_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_searchActionPerformed
        // TODO add your handling code here:
        //product_search.setText(null);

    }//GEN-LAST:event_product_searchActionPerformed

    private void btn_product_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_addMouseEntered
        // TODO add your handling code here:
        btn_product_add.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_btn_product_addMouseEntered

    private void btn_product_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_addMouseExited
        // TODO add your handling code here:
        btn_product_add.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_btn_product_addMouseExited

    private void btn_product_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_editMouseEntered
        // TODO add your handling code here:
        btn_product_edit.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_btn_product_editMouseEntered

    private void btn_product_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_editMouseExited
        // TODO add your handling code here:
        btn_product_edit.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_btn_product_editMouseExited

    private void btn_product_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_deleteMouseExited
        // TODO add your handling code here:
        btn_product_delete.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_btn_product_deleteMouseExited

    private void btn_product_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_deleteMouseEntered
        // TODO add your handling code here:
        btn_product_delete.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_btn_product_deleteMouseEntered

    private void product_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_searchMouseClicked
        // TODO add your handling code here:
        product_search.setText(null);

    }//GEN-LAST:event_product_searchMouseClicked

    private void btn_product_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_addMouseClicked
        // TODO add your handling code here:

        AddProduct add_product = new AddProduct();
        add_product.setVisible(true);
    }//GEN-LAST:event_btn_product_addMouseClicked

    private void btn_product_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_editMouseClicked
        // TODO add your handling code here:
         int row[] = tbl_Products.getSelectedRows();
         String rowData[] = new String[7];
            if(row.length == 1){
                for(int i=0; i<7; i++){
                rowData[i] = tbl_Products.getModel().getValueAt(row[0], i).toString();
                System.out.println("getSelectedRow = "+rowData[i]);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please select a single row to Edit");
            }
          EditProduct edit_prdt = new EditProduct();
          //setData(String p_bar, String p_cat, String p_name, String img, String p_desc)
          System.out.println("Arrays.toString(rowData): "+Arrays.toString(rowData));

          edit_prdt.setData(rowData[0], rowData[2], rowData[4], rowData[3], filePathList.get(row[0]), rowData[5]);
          edit_prdt.setVisible(true);



    }//GEN-LAST:event_btn_product_editMouseClicked

    private void refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseEntered
        // TODO add your handling code here:
        refresh.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited
        // TODO add your handling code here:
        refresh.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_refreshMouseExited

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
        DefaultTableModel md = ((DefaultTableModel)tbl_Products.getModel());
        md.setRowCount(0);
        if(md.getRowCount() == 0){
            this.addProductsToTable();
        }

    }//GEN-LAST:event_refreshMouseClicked

    private void btn_product_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_product_deleteMouseClicked
        // TODO add your handling code here:
        int row[] = tbl_Products.getSelectedRows();
        ArrayList<String> rowData = new ArrayList<String>();
        DefaultTableModel md = ((DefaultTableModel)tbl_Products.getModel());
        System.out.println(row.length);
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete "+row.length+" Products?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            if(row.length > 0){
                int j = 1;
                for(int i=0; i < row.length; i++){
                rowData.add(tbl_Products.getModel().getValueAt(row[i], 0).toString());
                        md.removeRow(row[i]);
                        if(i < row.length-1){
                          row[i+1] = row[i+1]-j;
                          j++;
                        }
                System.out.println("SelectedRow = "+row[i]);
                System.out.println("getSelectedRow = "+rowData.get(i).toString());
                }
                System.out.println(Arrays.toString(rowData.toArray()));
                product.remove(rowData);
                md.setRowCount(0);
                if(md.getRowCount() == 0){
                    this.addProductsToTable();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please select products to Delete");
            }
        }

    }//GEN-LAST:event_btn_product_deleteMouseClicked

    private void product_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_product_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_product_searchKeyTyped

    private void product_searchVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_product_searchVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_product_searchVetoableChange

    private void btn_exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exportActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Export Wizard");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        String pathStr = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//          System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
//          System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
          pathStr = chooser.getSelectedFile().getAbsolutePath();
        } else {
          System.out.println("No Selection ");
        }

        try {
            this.writeToExcell(tbl_Products, pathStr);
        } catch (IOException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_exportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_export;
    private javax.swing.JLabel btn_product_add;
    private javax.swing.JLabel btn_product_delete;
    private javax.swing.JLabel btn_product_edit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField product_search;
    private javax.swing.JLabel refresh;
    private javax.swing.JPanel search;
    private javax.swing.JTable tbl_Products;
    // End of variables declaration//GEN-END:variables
}
