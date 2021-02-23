package pl.aziria.shoppinglisttoemail.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.aziria.shoppinglisttoemail.model.ListData;
import pl.aziria.shoppinglisttoemail.model.ListItem;

import java.util.List;


@Service
public class ListServiceImpl implements ListService {

    // ==fields==
    @Getter
    private ListData list;

    // ==constructor==
    public ListServiceImpl(ListData list) {
        this.list = list;
    }


    // ==methods==

    @Override
    public ListItem newItem() {
        return new ListItem("", "");
    }

    @Override
    public List<ListItem> getData() {
        return list.getData();
    }

    @Override
    public void addItem(ListItem item) {
        list.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        list.removeItem(id);
    }

    @Override
    public void updateItem(ListItem item) {
        list.updateItem(item);
    }

    @Override
    public ListItem getItem(int id) {
        return list.getItem(id);
    }

//    @Override
//    public String getMailableList() {
//        TemplateEngine templateEngine = new TemplateEngine();
//        Context context = new Context();
//    }
}
