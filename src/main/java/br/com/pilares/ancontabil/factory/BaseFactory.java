package br.com.pilares.ancontabil.factory;

import br.com.pilares.ancontabil.model.entities.PessoaFisica;
import br.com.pilares.ancontabil.model.enums.TipoPessoa;
import br.com.pilares.ancontabil.service.BaseService;
import br.com.pilares.ancontabil.service.PessoaFisicaService;

public abstract class BaseFactory implements IBaseFactory{
	
	@Override
	public BaseService getService(Class classe) {
		if(classe.equals(PessoaFisica.class)) {		
		}
		return null;
	}

}
