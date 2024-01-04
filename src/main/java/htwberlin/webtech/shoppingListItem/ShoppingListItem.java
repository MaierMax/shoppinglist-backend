package htwberlin.webtech.shoppingListItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class ShoppingListItem{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long itemID;
    private Long listID;
    private String itemName;
    private String itemDescr;

    public ShoppingListItem(){}
    public ShoppingListItem(Long listID, String itemName, String itemDescr){
        this.listID = listID;
        this.itemName = itemName;
        this.itemDescr = itemDescr;
    }

    public ShoppingListItem(Long listID, String itemName){
        this.listID = listID;
        this.itemName = itemName;
    }

    //Getter
    public long getItemID() {
        return itemID;
    }
    public Long getListID() {
        return listID;
    }
    public String getItemName() {
        return itemName;
    }
    public String getItemDescr() {
        return itemDescr;
    }

    //Setter
    public void setItemName(String newName) {
        this.itemName = newName;
    }

    public void setItemDescr(String newDescr) {
        this.itemDescr = newDescr;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public void setListID(Long listID) {
        this.listID = listID;
    }
}
