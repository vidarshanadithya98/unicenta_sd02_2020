/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.inventory.Views;

import com.Savindu.inventory.Entity.Category;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Savindu
 */

public class Categories extends javax.swing.JPanel {

    /**
     * Creates new form Categories
     */
    
    Category cat = new Category();
    ArrayList<String> filePathList = new ArrayList<>();
    
    public Categories() {
        initComponents();
        customJTable(tbl_Cat);
        addCategoriesToTable();
        
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
      
      if(product_search.getText() == null){
          product_search.setText("Search");
      }
      
    }
    
     public void customJTable(JTable table){
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(new Color(0,51,51));
        table.setAutoCreateRowSorter(true);
    }

     public void addCategoriesToTable() {
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public Class<?> getColumnClass(int column) {
                if (column==2) return ImageIcon.class;
                return Object.class;
            }
        };
        model.setRowCount(0);
        ArrayList<Category> list = new ArrayList<>();
        list = cat.getCategories();
        
         if(filePathList.size() > 0){
            filePathList.clear();
        }
        
        Object rowData[] = new Object[5];
        Object columns[] = new Object[5];
        columns[0] = " ID";
        columns[1] = " Cat_ID";
        columns[2] = " Img";
        columns[3] = " Name";
        columns[4] = " Uploaded On";
        
        model.setColumnIdentifiers(columns);
        
        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).getId();
            rowData[1] = list.get(i).getCatID();
            filePathList.add(list.get(i).getImg());
            if(list.get(i).getImg() != null){
                 rowData[2] = resizeImg(list.get(i).getImg());
            }
            rowData[3] = list.get(i).getName();
            rowData[4] = list.get(i).getUpload();
            model.addRow(rowData);
        }
         System.out.println("filePathList: "+Arrays.toString(filePathList.toArray()));
        tbl_Cat.setModel(model);
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
        DefaultTableModel md = ((DefaultTableModel)tbl_Cat.getModel());
        TableRowSorter sorter = new TableRowSorter<>(md);
        tbl_Cat.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + str));
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
        btn_add_category = new javax.swing.JLabel();
        btn_cat_edit = new javax.swing.JLabel();
        btn_cat_delete = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        product_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cat = new javax.swing.JTable();

        setBackground(new java.awt.Color(28, 35, 51));
        setForeground(new java.awt.Color(244, 244, 244));

        jPanel1.setBackground(new java.awt.Color(55, 71, 79));
        jPanel1.setPreferredSize(new java.awt.Dimension(1032, 120));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(55, 71, 79));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        refresh.setBackground(new java.awt.Color(55, 71, 79));
        refresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(244, 244, 244));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-refresh-36.png"))); // NOI18N
        refresh.setText("Reload");
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

        btn_add_category.setBackground(new java.awt.Color(55, 71, 79));
        btn_add_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_add_category.setForeground(new java.awt.Color(244, 244, 244));
        btn_add_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-add-list-36.png"))); // NOI18N
        btn_add_category.setText("New Category");
        btn_add_category.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_add_categoryFocusGained(evt);
            }
        });
        btn_add_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_add_categoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add_categoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add_categoryMouseExited(evt);
            }
        });
        jPanel1.add(btn_add_category);

        btn_cat_edit.setBackground(new java.awt.Color(55, 71, 79));
        btn_cat_edit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cat_edit.setForeground(new java.awt.Color(244, 244, 244));
        btn_cat_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-edit-36.png"))); // NOI18N
        btn_cat_edit.setText("Edit Category");
        btn_cat_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cat_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cat_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cat_editMouseExited(evt);
            }
        });
        jPanel1.add(btn_cat_edit);

        btn_cat_delete.setBackground(new java.awt.Color(55, 71, 79));
        btn_cat_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cat_delete.setForeground(new java.awt.Color(244, 244, 244));
        btn_cat_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-delete-bin-36.png"))); // NOI18N
        btn_cat_delete.setText("Remove Category");
        btn_cat_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cat_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cat_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cat_deleteMouseExited(evt);
            }
        });
        jPanel1.add(btn_cat_delete);

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

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_search, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
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

        tbl_Cat.setBackground(new java.awt.Color(55, 71, 79));
        tbl_Cat.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tbl_Cat.setForeground(new java.awt.Color(244, 244, 244));
        tbl_Cat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ddf", "dfdf", "dfdf", "dfdf", "dfdf"},
                {"dfdf", "dfdf", "dfdf", "fddf", "dfd"},
                {"sdcfvgb", "fvgb", "gbhn", "vfgbth", "nvfgbh"},
                {"fcvgbh", "vfgbth", "fvgbh", "vfgbh", "fvgbhbg"},
                {"vfgbhn", "vgfbhn", "gvfbhn", "fgbhn", "dwewf"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl_Cat.setFocusable(false);
        tbl_Cat.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_Cat.setRowHeight(75);
        tbl_Cat.setSelectionBackground(new java.awt.Color(28, 35, 51));
        tbl_Cat.setShowVerticalLines(false);
        tbl_Cat.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_Cat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_categoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_add_categoryFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_add_categoryFocusGained

    private void btn_add_categoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_categoryMouseEntered
        // TODO add your handling code here:
        btn_add_category.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_btn_add_categoryMouseEntered

    private void btn_add_categoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_categoryMouseExited
        // TODO add your handling code here:
        btn_add_category.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_btn_add_categoryMouseExited

    private void btn_cat_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cat_editMouseEntered
        // TODO add your handling code here:
        btn_cat_edit.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_btn_cat_editMouseEntered

    private void btn_cat_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cat_editMouseExited
        // TODO add your handling code here:
        btn_cat_edit.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_btn_cat_editMouseExited

    private void btn_cat_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cat_deleteMouseEntered
        // TODO add your handling code here:
        btn_cat_delete.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_btn_cat_deleteMouseEntered

    private void btn_cat_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cat_deleteMouseExited
        // TODO add your handling code here:
        btn_cat_delete.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_btn_cat_deleteMouseExited

    private void product_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_searchMouseClicked
        // TODO add your handling code here:
        product_search.setText(null);

    }//GEN-LAST:event_product_searchMouseClicked

    private void product_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_searchActionPerformed
        // TODO add your handling code here:
        product_search.setText(null);
    }//GEN-LAST:event_product_searchActionPerformed

    private void btn_add_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_add_categoryMouseClicked
        // TODO add your handling code here:
        AddCat addCat = new AddCat();
        addCat.setVisible(true);
        
    }//GEN-LAST:event_btn_add_categoryMouseClicked

    private void btn_cat_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cat_editMouseClicked
        // TODO add your handling code here:
        int row[] = tbl_Cat.getSelectedRows();
        String rowData[] = new String[5];
        ArrayList<String> itemData = new ArrayList<>();
            if(row.length == 1){
                for(int i=0; i<5; i++){  
                rowData[i] = tbl_Cat.getModel().getValueAt(row[0], i).toString();
                System.out.println("getSelectedRow = "+rowData[i]); 
                }  
            }else{
                JOptionPane.showMessageDialog(null, "Please select a single row to Edit");
            }
          EditCategory edit_cat = new EditCategory();
          edit_cat.setData(rowData[0], rowData[1], rowData[3], filePathList.get(row[0]));
          edit_cat.setVisible(true);
    }//GEN-LAST:event_btn_cat_editMouseClicked

    private void btn_cat_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cat_deleteMouseClicked
        // TODO add your handling code here:
        int row[] = tbl_Cat.getSelectedRows();
        ArrayList<String> rowData = new ArrayList<String>();
        DefaultTableModel md = ((DefaultTableModel)tbl_Cat.getModel());
        System.out.println(row.length);
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete "+row.length+" Category?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            if(row.length > 0){
                int j = 1;
                for(int i=0; i < row.length; i++){    
                rowData.add(tbl_Cat.getModel().getValueAt(row[i], 0).toString());
                        md.removeRow(row[i]);
                        if(i < row.length-1){
                          row[i+1] = row[i+1]-j; 
                          j++;
                        }
                System.out.println("SelectedRow = "+row[i]);
                System.out.println("getSelectedRow = "+rowData.get(i).toString());
                }  
                System.out.println(Arrays.toString(rowData.toArray()));
                cat.remove(rowData);
                md.setRowCount(0);
                if(md.getRowCount() == 0){ 
                    this.addCategoriesToTable();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please select products to Delete");
            }
        }
    }//GEN-LAST:event_btn_cat_deleteMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
        DefaultTableModel md = ((DefaultTableModel)tbl_Cat.getModel());
        md.setRowCount(0);
        if(md.getRowCount() == 0){ 
            this.addCategoriesToTable();
        }
    }//GEN-LAST:event_refreshMouseClicked

    private void refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseEntered
        // TODO add your handling code here:
        refresh.setForeground(new Color(0x2ECC71));
    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited
        // TODO add your handling code here:
        refresh.setForeground(new Color(0xf4f4f4));
    }//GEN-LAST:event_refreshMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_add_category;
    private javax.swing.JLabel btn_cat_delete;
    private javax.swing.JLabel btn_cat_edit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField product_search;
    private javax.swing.JLabel refresh;
    private javax.swing.JPanel search;
    private javax.swing.JTable tbl_Cat;
    // End of variables declaration//GEN-END:variables
}
