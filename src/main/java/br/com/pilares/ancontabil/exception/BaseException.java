package br.com.pilares.ancontabil.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;	
	private final List<String> mensagens;

    public BaseException(List<String> mensagens) {
        this.mensagens = new ArrayList<>();
        this.mensagens.addAll(mensagens);
    }
    
    public BaseException(String mensagem) {
        this.mensagens = Arrays.asList(mensagem);
    }

	public List<String> getMensagens() {
		return mensagens;
	}
	
}
