package DBHandling;


import DTOs.Medicine;
import DTOs.Sales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBHandler {
    String DB_URL = "jdbc:mysql://localhost:3306/medical_store";
    String DB_User = "root";
    String DB_PWD = "624621999";
    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs=null;
    
    private void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_User, DB_PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    private void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
                pst.close();
                if(rs!=null)
                    rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean validateUser(String username, String password){
        createConnection();
        try {
            pst = conn.prepareStatement("select * from employee where username = ? and password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next())
                return true;     
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return false;
    }
    
    public ArrayList<Medicine> viewAllMedicines(){
        createConnection();
        ArrayList<Medicine> array = new ArrayList<>();
        try {
            pst = conn.prepareStatement("select * from medicine_view");
            rs = pst.executeQuery();
            while(rs.next()){
                 Medicine obj = new Medicine(rs.getInt("id"), rs.getString("name"),
                         rs.getDouble("costPrice"), rs.getDouble("salePrice"),
                         rs.getInt("amount"), rs.getString("companyName"), 
                         rs.getString("phone"), rs.getString("email"));
                 array.add(obj);
            }    
        //return array;        
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return array;
    }
    
    public ArrayList<Sales> viewAllSales(){
        createConnection();
        ArrayList<Sales> array = new ArrayList<>();
        try {
            pst = conn.prepareStatement("select * from sale");
            rs = pst.executeQuery();
            while(rs.next()){
                 Sales obj = new Sales(rs.getInt("id"), rs.getString("customerName"),
                         rs.getString("phone"), rs.getString("saleDate"),
                         rs.getDouble("total"));
                 array.add(obj);
            }    
        //return array;        
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return array;
    }
    
    public ArrayList<String> getMedicinesName(){
        createConnection();
        ArrayList<String> names = new ArrayList<>();
        try {
            pst = conn.prepareStatement("select name from medicine_view");
            rs = pst.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return names;
    }
    
    public boolean updateStock(String medicine, int amount){
        createConnection();
        try {
            pst = conn.prepareStatement("select amount from medicine_view where name = ?");
            pst.setString(1, medicine);
            rs = pst.executeQuery();
            if (rs.next()){
                pst = conn.prepareStatement("update medicine_view set amount = ? "
                        + "where name = ?");
                pst.setInt(1, amount+rs.getInt("amount"));
                pst.setString(2, medicine);
                int r = pst.executeUpdate();
                if(r!=0)
                    return true;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return false;
    }

    public boolean updatePrice(String medicine, double costPrice, double salePrice) {
        createConnection();
        try {
            pst = conn.prepareStatement("update medicine_view set costPrice = ?, "
                    + "salePrice = ? where name = ?");
            pst.setDouble(1, costPrice);
            pst.setDouble(2, salePrice);
            pst.setString(3, medicine);
            int r = pst.executeUpdate();
            if(r!=0)
                return true; 
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return false;
    }

    public boolean addNewEmployee(String username, String password, String name,
            String fatherName, String cnic, String phone, String address) {
        createConnection();
        try {
            pst = conn.prepareStatement("insert into employeeData (name,fatherName,"
                    + "cnic,phone,address) values (?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, fatherName);
            pst.setString(3, cnic);
            pst.setString(4, phone);
            pst.setString(5, address);
            int r = pst.executeUpdate();
            if(r!=0){
                pst = conn.prepareStatement("insert into employee (username,password,"
                    + "dataId) values (?,?,(select max(id) from employeeData))");
                pst.setString(1, username);
                pst.setString(2, password);
                int check = pst.executeUpdate();
                if(check!=0)
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return false;
    }

    public boolean addNewMedicine(String medicineName, String companyName, 
            String phone, String email, double costPrice, double salePrice, 
            int amount) {
        createConnection();
        try {
            int companyId = insertCompany(companyName,phone,email);
            if(insertPrice(costPrice,salePrice,amount)){
                if(companyId == 0){
                    pst = conn.prepareStatement("insert into medicine (name,"
                            + "companyId,priceId) values (?,(select max(id) from "
                            + "company),(select max(id) from price))");
                }
                else{
                    pst = conn.prepareStatement("insert into medicine (name,"
                            + "companyId,priceId) values (?,?,(select max(id) "
                            + "from price))");
                    pst.setInt(2, companyId);
                }
                pst.setString(1, medicineName);
                int r = pst.executeUpdate();
                if(r!=0)
                    return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return false;
    }

    private boolean insertPrice(double costPrice, double salePrice, int amount) {
        try {
            pst = conn.prepareStatement("insert into price (costPrice,salePrice,"
                    + "amount) values (?,?,?)");
            pst.setDouble(1, costPrice);
            pst.setDouble(2, salePrice);
            pst.setInt(3, amount);
            int r = pst.executeUpdate();
            if(r!=0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private int insertCompany(String companyName, String phone, String email) {
        int companyId = 0;
        try {
            pst = conn.prepareStatement("select id from company where name = ?");
            pst.setString(1, companyName);
            rs = pst.executeQuery();
            if (rs.next()) {
                companyId = rs.getInt("id");
                return companyId;
            } 
            else {
                pst = conn.prepareStatement("insert into company (name,phone,email)"
                        + "values (?,?,?)");
                pst.setString(1, companyName);
                pst.setString(2, phone);
                pst.setString(3, email);
                int r = pst.executeUpdate();
                if (r != 0) 
                    return companyId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyId;
    }

    public int getAmount(String medicineName) {
        createConnection();
        try {
            pst = conn.prepareStatement("select amount from medicine_view where name = ?");
            pst.setString(1, medicineName);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return -1;
    }

    public int getIdOfMedicine(String medicineName) {
        createConnection();
        try {
            pst = conn.prepareStatement("select id from medicine where name = ?");
            pst.setString(1, medicineName);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return -1;
    }

    public double getPrice(int id) {
        createConnection();
        try {
            pst = conn.prepareStatement("select salePrice from medicine_view "
                    + "where id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getDouble("salePrice");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return -1;
    }

    public boolean saveRecordSale(String customerName, String phone, double grandTotal) {
        createConnection();
        try {
            pst = conn.prepareStatement("insert into sale (customerName,phone,"
                    + "saleDate,total) values (?,?,curdate(),?)");
            pst.setString(1, customerName);
            pst.setString(2, phone);
            pst.setDouble(3, grandTotal);
            int r = pst.executeUpdate();
            if(r!=0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            closeConnection();
        }
        return false;
    }

    
}

