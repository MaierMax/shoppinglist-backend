package htwberlin.webtech.shoppingListItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ShoppingListItemRepository repo;

    public ShoppingListItem save(ShoppingListItem item){
        ShoppingListItem result = repo.save(item);
        return result;
    }

    public ShoppingListItem get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void delete(Long id){
        ShoppingListItem item = get(id);
        repo.delete(item);
    }

    public ShoppingListItem update(Long id, String newDescr){
        ShoppingListItem item = get(id);
        item.setItemDescr(newDescr);
        return item;
    }

    //TODO soll nur alle aus bestimmter Liste löschen
    public void deleteAll(){
        repo.deleteAll();
    }
}
