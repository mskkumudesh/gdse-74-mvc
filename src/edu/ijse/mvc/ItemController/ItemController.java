/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.ItemController;
import edu.ijse.mvc.dto.ItemDto;
import edu.ijse.mvc.model.ItemModel;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author mskku
 */

    public class ItemController {
    private ItemModel itemModel;

    public ItemController() {
        itemModel = new ItemModel();
    }
    
    public String saveItem(ItemDto dto) throws SQLException, ClassNotFoundException{
        String resp = itemModel.saveItem(dto);
        return resp;
    }
    
    
    public String updateItem(ItemDto dto) throws SQLException, ClassNotFoundException{
        String resp = itemModel.updateItem(dto);
        return resp;
    }
    
    
    public String deleteItem(String itemCode) throws SQLException, ClassNotFoundException{
        String resp = itemModel.deleteItem(itemCode);
        return resp;
    }
    
    public ItemDto searchItem(String code) throws SQLException, ClassNotFoundException{
        ItemDto resp = itemModel.searchItem(code);
        return resp;
    }
    
    public ArrayList<ItemDto> getAllItem() throws  SQLException, ClassNotFoundException{
        ArrayList<ItemDto> resp = itemModel.getAll();
        return resp;
    }
}
    

