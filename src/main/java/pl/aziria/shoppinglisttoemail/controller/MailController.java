package pl.aziria.shoppinglisttoemail.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.aziria.shoppinglisttoemail.service.ListService;
import pl.aziria.shoppinglisttoemail.service.MailService;
import pl.aziria.shoppinglisttoemail.util.AttributeNames;
import pl.aziria.shoppinglisttoemail.util.Mappings;

import java.time.LocalDate;

@Slf4j
@Controller
public class MailController {

    private final MailService mailService;
    private final ListService listService;


    public MailController(MailService mailService, ListService listService) {
        this.mailService = mailService;
        this.listService = listService;
    }

    @PostMapping(Mappings.ITEMS_LIST)
    public String sendEmail(@RequestParam String recipient) {
        log.info("sending list to recipient = {}", recipient);

        Context context = new Context();
        TemplateEngine templateEngine = mailService.getTemplateEngine();

        context.setVariable(AttributeNames.ITEMS_LIST, listService.getData());
        String body = templateEngine.process("email_template", context);
        mailService.sendEmail(recipient, "Your shopping list - " + LocalDate.now(), body);

        return Mappings.REDIRECT_TO_LIST;
    }


}
