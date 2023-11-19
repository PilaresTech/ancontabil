package br.com.pilares.ancontabil.factory;

import br.com.pilares.ancontabil.model.entities.Pessoa;
import br.com.pilares.ancontabil.service.BaseService;

public abstract class BaseFactory implements IBaseFactory{
	
	@Override
	public BaseService getService(Class classe) {
		if(classe.equals(Pessoa.class)) {		
		}
		return null;
	}

}
