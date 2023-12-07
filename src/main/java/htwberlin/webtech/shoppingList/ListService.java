package htwberlin.webtech.shoppingList;

import htwberlin.webtech.shoppingListItem.ShoppingListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListService {

    @Autowired
    ShoppingListRepository repo;
    @Autowired
    ShoppingListItemRepository itemRepo;

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

    public void deleteAll(){
        repo.deleteAll();
        itemRepo.deleteAll();
    }

    public Iterable<ShoppingList> getAll(){
        return repo.findAll();
    }

    public ShoppingList rename(String newName, Long id){
        ShoppingList list = get(id);
        list.setListName(newName);
        repo.save(list);
        return list;
    }
}
