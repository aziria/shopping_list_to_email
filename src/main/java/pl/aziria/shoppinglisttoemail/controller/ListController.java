package pl.aziria.shoppinglisttoemail.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.aziria.shoppinglisttoemail.model.ListItem;
import pl.aziria.shoppinglisttoemail.service.ListService;
import pl.aziria.shoppinglisttoemail.util.AttributeNames;
import pl.aziria.shoppinglisttoemail.util.Mappings;
import pl.aziria.shoppinglisttoemail.util.ViewNames;

@Slf4j
@Controller
public class ListController {

    private final ListService listService;


    public ListController(ListService listService) {
        this.listService = listService;
    }


    //request methods

    @GetMapping(Mappings.ITEMS_LIST)
    public String itemsList(Model model) {
        log.info("displaying list = {}", listService.getData());
        model.addAttribute(AttributeNames.ITEMS_LIST, listService.getData());
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        log.info("displaying item with id = {}", id);
        model.addAttribute(AttributeNames.ITEM, listService.getItem(id));
        return ViewNames.VIEW_ITEM;
    }

    @PostMapping(Mappings.VIEW_ITEM)
    public String updateItem(@ModelAttribute ListItem item) {
        log.info("updating with item = {}", item);
        listService.updateItem(item);
        return Mappings.REDIRECT_TO_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addItemForm(Model model) {
        log.info("displaying addItem view");
        model.addAttribute(AttributeNames.ITEM, listService.newItem());
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String addItem(@ModelAttribute ListItem item) {
        log.info("adding item = {}", item);
        listService.addItem(item);
        return Mappings.REDIRECT_TO_LIST;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("deleting item with id = {}", id);
        listService.removeItem(id);
        return Mappings.REDIRECT_TO_LIST;
    }
}