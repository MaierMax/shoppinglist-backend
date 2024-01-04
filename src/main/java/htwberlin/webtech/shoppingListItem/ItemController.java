package htwberlin.webtech.shoppingListItem;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.*;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @PostMapping(value = "/saveItem", consumes = "application/json")
    public ShoppingListItem createItem(@RequestBody ShoppingListItem item){
        return service.save(item);
    }

    @GetMapping("/getItem/{id}")
    public ShoppingListItem getItem(@PathVariable String id){
        Long itemId = Long.parseLong(id);
        return service.get(itemId);
    }

    @GetMapping("/items")
    public Iterable<ShoppingListItem> getAllItems(){
        return service.getAll();
    }

    @GetMapping("/getItemsOfList/{id}")
    public Iterable<ShoppingListItem> getItemsOfList(@PathVariable String id){
        Long listId = Long.parseLong(id);
        return service.getAllOfList(listId);
    }

    @DeleteMapping("/deleteItem/{id}")
    public void deleteItem(@PathVariable String id){
        Long itemId = Long.parseLong(id);
        service.delete(itemId);
    }

    @DeleteMapping("/deleteAllItems")
    public void deleteAllItems(){
        service.deleteAll();
    }

    @PutMapping("/updateItemDescription/{id}")
    public ShoppingListItem updateItemDescr(@RequestBody String jsonString, @PathVariable String id){
        Long itemId = Long.parseLong(id);
        JSONObject jsonObject = new JSONObject(jsonString);
        String newDescr = jsonObject.getString("newDescr");
        return service.updateDescr(itemId, newDescr);
    }

    @PutMapping("/updateItemName/{id}")
    public ShoppingListItem updateItemName(@RequestBody String jsonString, @PathVariable String id){
        Long itemId = Long.parseLong(id);
        JSONObject jsonObject = new JSONObject(jsonString);
        String newName = jsonObject.getString("newName");
        return service.updateName(itemId, newName);
    }
}
