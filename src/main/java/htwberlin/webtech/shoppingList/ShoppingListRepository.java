package htwberlin.webtech.shoppingList;

import htwberlin.webtech.shoppingList.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

}
