/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;
import edu.ijse.mvc.db.DBConnection;
import edu.ijse.mvc.dto.ItemDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author mskku
 */
public class ItemModel {
    public String saveItem(ItemDto itemDto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemDto.getItemCode());
        statement.setString(2, itemDto.getDescription());
        statement.setString(3, itemDto.getPackSize());
        statement.setDouble(4, itemDto.getUnitPrice());
        statement.setInt(5, itemDto.getQoh());
        
        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, itemDto.getDescription());
        statement.setString(2, itemDto.getPackSize());
        statement.setDouble(3, itemDto.getUnitPrice());
        statement.setInt(4, itemDto.getQoh());
        statement.setString(5, itemDto.getItemCode());
        
        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }
    
    public String deleteItem(String itemCode) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Item WHWRE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, itemCode);
        
        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }
    
    public ArrayList<ItemDto> getAll() throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        
        while (rst.next()) {            
            ItemDto dto = new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"), rst.getString("PackSize"),
                    rst.getInt("QtyOnHand"), rst.getDouble("UnitPrice"));
            itemDtos.add(dto);
        }
        
        
        return itemDtos;
    }
    
    public ItemDto searchItem(String itemCode) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item WHERE ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemCode);
        
        ResultSet rst = statement.executeQuery();
        
        if (rst.next()) {            
            ItemDto dto = new ItemDto(rst.getString("ItemCode"),
                    rst.getString("Description"), rst.getString("PackSize"),
                    rst.getInt("QtyOnHand"), rst.getDouble("UnitPrice"));
            return dto;
        }
        return null;
    }
    
}
