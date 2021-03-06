/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Savindu.inventory.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.DB.Sales.DatabaseConnection;
import java.sql.ResultSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeMath.round;
/**
 *
 * @author Savindu
 */
public class Products {

  
    private String id;
    private String barcode;
    private String name;
    private String category;
    private String img;
    private String description;
    private String uploadedOn;
    
    
    private Connection con;
    
    private String INSERT_PRODUCTS_SQL = "INSERT INTO `products` (`name`, `barcode`, `category`, `description`, `img`, `quantity`, `product_price`, `tax`, `commission`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //private String SELECT_PRODUCTS_SQL = "SELECT `productID`, `name`, `barcode`, `category`, `description`, `img`, `uploadedOn` FROM `products`";  
    private String SELECT_PRODUCTS_SQL = "SELECT p.`productID`, p.`name`, p.`barcode`, c.`cat_Name`, p.`description`, p.`img`, p.`uploadedOn`, p.`quantity`, p.`product_price`, p.`tax`, p.`commission` FROM `products` p LEFT JOIN `categories` c ON c.`id` = p.`category`";
    private String UPDATE_PRODUCTS_SQL = "UPDATE `products` SET `name`= ?,`barcode`= ?,`category`= ?,`description`= ?,`img`= ? WHERE `productID`= ?";
    private String DELETE_PRODUCTS_SQL = "DELETE FROM `products` WHERE `productID` = ?";
    
    public Products() {
        DatabaseConnection dbc = DatabaseConnection.getDatabaseConnection();
        con = dbc.getConnection();
    }
    
      public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Products{" + "barcode=" + barcode + ", name=" + name + ", category=" + category + ", img=" + img + ", description=" + description + ", con=" + con + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        if(img != null){
            this.img = img; 
        }else{
            this.img = "Products\\image-not-found.png";
        }
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public String getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(String uploadedOn) {
        this.uploadedOn = uploadedOn;
    }
    
    public boolean save(Products product) throws SQLException{
            boolean state = false;
            Random rand = new Random(); 
            double price = 100000 + (500000 - 100000) * rand.nextDouble();
            price = round(price, 2);
            int quantity = rand.nextInt(1000);
            double tax = price * 0.1;
            double commision = price * 0.4;
         
        try{
           // for(Products product : products){
               PreparedStatement preparedStatement = con.prepareStatement(INSERT_PRODUCTS_SQL);
        
               preparedStatement.setString(1, product.getName());          
               preparedStatement.setString(2, product.getBarcode()); 
               preparedStatement.setString(3, product.getCategory()); 
               preparedStatement.setString(4, product.getDesc()); 
               preparedStatement.setString(5, product.getImg());
               preparedStatement.setInt(6, quantity);
               preparedStatement.setDouble(7, price);
               preparedStatement.setDouble(8, tax);
               preparedStatement.setDouble(9, commision);
               
            
               System.out.println(preparedStatement);
               
               int result = preparedStatement.executeUpdate();
               
               if(result > 0){
                   state = true;
               }else{
                   state = false;
               }
            //}
        }catch(Exception e){
            System.out.println(e);
        }
        
       return state;
    }
    
    public ArrayList<Products> getProducts(){
        ArrayList<Products> products = new ArrayList<>();
        Products product;
        ResultSet rs = null;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCTS_SQL);
            System.out.println(preparedStatement);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                product = new Products();
                product.setId(rs.getString(1));
                product.setName(rs.getString(2));
                product.setBarcode(rs.getString(3));
                product.setCategory(rs.getString(4));
                product.setDesc(rs.getString(5));
                product.setImg(rs.getString(6));
                product.setUploadedOn(rs.getString(7));
                
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return products;
    }
    
    public boolean update(Products product){
        boolean state = false;
        try{
           // for(Products product : products){
               PreparedStatement preparedStatement = con.prepareStatement(UPDATE_PRODUCTS_SQL);
        
               preparedStatement.setString(1, product.getName());          
               preparedStatement.setString(2, product.getBarcode()); 
               preparedStatement.setString(3, product.getCategory()); 
               preparedStatement.setString(4, product.getDesc()); 
               preparedStatement.setString(5, product.getImg()); 
               preparedStatement.setString(6, product.getId());
               System.out.println(preparedStatement);
               
               int result = preparedStatement.executeUpdate();
               
               if(result > 0){
                   state = true;
               }else{
                   state = false;
               }
            //}
        }catch(Exception e){
            System.out.println(e);
        }
        return state;
    }
    
    public boolean remove(ArrayList<String> products){
        boolean state = false;
         int result = 0;
        try{
           // for(Products product : products){
               PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCTS_SQL);
        
               for(int i=0; i<products.size(); i++){
                 preparedStatement.setString(1, products.get(i).toString());
                 System.out.println(preparedStatement);
               
                 result  = preparedStatement.executeUpdate();  
               }
               
               
               if(result > 0){
                   state = true;
               }else{
                   state = false;
               }
            //}
        }catch(Exception e){
            System.out.println(e);
        }
        
        return state;
    }
}
