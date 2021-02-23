package pl.aziria.shoppinglisttoemail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class ListItem {

    private int id;
    private String name;
    private String details;

    public ListItem(String name, String details) {
        this.name = name;
        this.details = details;
    }
}
