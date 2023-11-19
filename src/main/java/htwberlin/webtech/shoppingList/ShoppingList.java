package htwberlin.webtech.shoppingList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShoppingList{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long listID;
    private String listName;

    protected ShoppingList(){}

    public ShoppingList(String listName){
        this.listName = listName;
    }


    public Long getListID() {
        return listID;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setListID(Long listID) {
        this.listID = listID;
    }
}
