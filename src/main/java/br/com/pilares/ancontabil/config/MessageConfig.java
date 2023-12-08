package br.com.pilares.ancontabil.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        addMessage(messageSource);        
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

	private void addMessage(ReloadableResourceBundleMessageSource messageSource) {
		messageSource.addBasenames("classpath:mensagens/erros");
	}
	
}
