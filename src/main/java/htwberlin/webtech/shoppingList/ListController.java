package htwberlin.webtech.shoppingList;

import htwberlin.webtech.shoppingListItem.ItemService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

    @Autowired
    ListService service;
    @Autowired
    ItemService itemService;

    @PostMapping("/saveList")
    public ShoppingList createList(@RequestBody ShoppingList list){
        return service.save(list);
    }

    @GetMapping("/getList/{id}")
    public ShoppingList getList(@PathVariable String id){
        Long listId = Long.parseLong(id);
        return service.get(listId);
    }

    @GetMapping("/home")
    public Iterable<ShoppingList> getAllLists(){
        return service.getAll();
    }

    @DeleteMapping("/deleteList/{id}")
    public void deleteList(@PathVariable String id){
        Long listId = Long.parseLong(id);
        service.delete(listId);
        itemService.deleteAllOfList(itemService.getAllOfList(listId));
    }

    @DeleteMapping("/deleteAllLists")
    public void deleteAllLists(){
        service.deleteAll();
    }

    @PutMapping("/updateList/{id}")
    public ShoppingList updateList(@PathVariable String id, @RequestBody String jsonString){
        Long listId = Long.parseLong(id);
        JSONObject jsonObject = new JSONObject(jsonString);
        String newName = jsonObject.getString("newName");
        return  service.rename(newName, listId);
    }
}
