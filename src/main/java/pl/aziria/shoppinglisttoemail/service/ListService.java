package pl.aziria.shoppinglisttoemail.service;

import pl.aziria.shoppinglisttoemail.model.ListItem;

import java.util.List;

public interface ListService {

    List<ListItem> getData();

    ListItem newItem();

    void addItem(ListItem item);

    void removeItem(int id);

    void updateItem(ListItem item);

    ListItem getItem(int id);

//    String getMailableList();
}
