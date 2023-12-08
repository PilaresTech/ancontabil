package br.com.pilares.ancontabil.exception;

import java.util.List;

public class ValidacaoException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public ValidacaoException(List<String> mensagens) {
		super(mensagens);
	}

	public ValidacaoException(String mensagem) {
		super(mensagem);
	}
	
}
