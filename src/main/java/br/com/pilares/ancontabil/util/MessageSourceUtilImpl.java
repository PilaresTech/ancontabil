package br.com.pilares.ancontabil.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceUtilImpl implements MessageSourceUtil{

	@Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String id) throws NoSuchMessageException {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, null, locale);
    }
	
}
