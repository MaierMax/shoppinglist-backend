package htwberlin.webtech.shoppingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    ShoppingListRepository repo;

    public ShoppingList save(ShoppingList list){
        ShoppingList result = repo.save(list);
        return result;
    }

    public ShoppingList get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void delete(Long id){
        ShoppingList list = get(id);
        repo.delete(list);
    }
}
