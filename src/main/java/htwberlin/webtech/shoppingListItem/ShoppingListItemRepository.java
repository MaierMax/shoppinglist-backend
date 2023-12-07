package htwberlin.webtech.shoppingListItem;

import htwberlin.webtech.shoppingListItem.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {

    List<ShoppingListItem> findByListID(Long listID);
}
