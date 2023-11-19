package htwberlin.webtech.shoppingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

    @Autowired
    ListService service;

    @PostMapping("/saveList")
    public ShoppingList createList(@RequestBody ShoppingList list){
        return service.save(list);
    }

    @GetMapping("/getList/{id}")
    public ShoppingList getList(@PathVariable String id){
        Long listId = Long.parseLong(id);
        return service.get(listId);
    }

    @DeleteMapping("/deleteList/{id}")
    public void deleteList(@PathVariable String id){
        Long itemId = Long.parseLong(id);
        service.delete(itemId);
    }
}
