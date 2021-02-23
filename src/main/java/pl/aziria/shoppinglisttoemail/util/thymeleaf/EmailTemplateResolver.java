package pl.aziria.shoppinglisttoemail.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.cache.ICacheEntryValidity;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import java.util.Map;

@Slf4j
@Component
public class EmailTemplateResolver extends AbstractTemplateResolver {

    @Override
    protected ITemplateResource computeTemplateResource(IEngineConfiguration iEngineConfiguration, String s, String s1, Map<String, Object> map) {
        return null;
    }

    @Override
    protected TemplateMode computeTemplateMode(IEngineConfiguration iEngineConfiguration, String s, String s1, Map<String, Object> map) {
        return null;
    }

    @Override
    protected ICacheEntryValidity computeValidity(IEngineConfiguration iEngineConfiguration, String s, String s1, Map<String, Object> map) {
        return null;
    }
}
