/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.inventory;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Savindu
 */
public class Categories extends javax.swing.JPanel {

    /**
     * Creates new form Categories
     */
    public Categories() {
        initComponents();
        customJTable(tbl_Cat);
    }
    
     public void customJTable(JTable table){
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(new Color(0,51,51));
        table.setRowHeight(25);
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
        btn_add_category = new javax.swing.JLabel();
        btn_cat_edit = new javax.swing.JLabel();
        btn_cat_delete = new javax.swing.JLabel();
        search = new javax.swing.JPanel();
        product_search = new javax.swing.JTextField();
        btn_product_search = new javax.swing.JLabel();
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
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cat_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cat_deleteMouseExited(evt);
            }
        });
        jPanel1.add(btn_cat_delete);

        search.setBackground(new java.awt.Color(55, 71, 79));

        product_search.setBackground(new java.awt.Color(55, 71, 79));
        product_search.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        product_search.setForeground(new java.awt.Color(244, 244, 244));
        product_search.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        product_search.setText("Search");
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

        btn_product_search.setBackground(new java.awt.Color(55, 71, 79));
        btn_product_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/pos/images/icons8-search-36.png"))); // NOI18N

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(product_search, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_product_search)
                .addContainerGap())
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_product_search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(product_search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
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
        tbl_Cat.setRowHeight(25);
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(165, Short.MAX_VALUE)))
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
            if(row.length == 1){
                for(int i=0; i<5; i++){  
                rowData[i] = tbl_Cat.getModel().getValueAt(row[0], i).toString();
                System.out.println("getSelectedRow = "+rowData[i]); 
                }  
            }else{
                JOptionPane.showMessageDialog(null, "Please select a single row to Edit");
            }
            
          EditCategory edit_cat = new EditCategory();
          edit_cat.setData(rowData[0], rowData[1]);
          edit_cat.setVisible(true);
    }//GEN-LAST:event_btn_cat_editMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_add_category;
    private javax.swing.JLabel btn_cat_delete;
    private javax.swing.JLabel btn_cat_edit;
    private javax.swing.JLabel btn_product_search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField product_search;
    private javax.swing.JPanel search;
    private javax.swing.JTable tbl_Cat;
    // End of variables declaration//GEN-END:variables
}
