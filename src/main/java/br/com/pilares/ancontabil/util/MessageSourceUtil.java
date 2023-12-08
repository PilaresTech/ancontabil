package br.com.pilares.ancontabil.util;

import org.springframework.context.NoSuchMessageException;

public interface MessageSourceUtil {

	public String getMessage(String id) throws NoSuchMessageException;

}
