package htwberlin.webtech.shoppingListItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    ItemService service;

    @PostMapping("/saveItem")
    public ShoppingListItem createItem(@RequestBody ShoppingListItem item){
        return service.save(item);
    }

    @GetMapping("/getItem/{id}")
    public ShoppingListItem getItem(@PathVariable String id){
        Long itemId = Long.parseLong(id);
        return service.get(itemId);
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

    @PutMapping("/updateItem")
    public ShoppingListItem updateItem(@RequestBody String newDescr, @RequestBody Long id){
        return service.update(id, newDescr);
    }
}
