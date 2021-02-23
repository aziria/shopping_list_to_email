package pl.aziria.shoppinglisttoemail.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Slf4j
public class ListData {

    private final List<ListItem> list = new ArrayList<>();

    private static int idNum = 1;

    public ListData() {
        addItem(new ListItem("pierw", "detpierw"));
        addItem(new ListItem("drugi", "detdrug"));
        addItem(new ListItem("trzeci", "dettrzeci"));
    }


    public List<ListItem> getData() {
        return Collections.unmodifiableList(list);
    }

    public void addItem(@NonNull ListItem item) {
        item.setId(idNum);
        list.add(item);
        idNum++;
    }

    public void removeItem(int id) {
        ListIterator<ListItem> iterator = list.listIterator();

        while (iterator.hasNext()) {
            ListItem item = iterator.next();

            if (item.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    public void updateItem(@NonNull ListItem newItem) {
        ListIterator<ListItem> iterator = list.listIterator();

        while (iterator.hasNext()) {
            ListItem item = iterator.next();

            if (item.equals(newItem)) {
                iterator.set(newItem);
            }
        }
    }

    public ListItem getItem(int id) {
        for (ListItem item : list) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
