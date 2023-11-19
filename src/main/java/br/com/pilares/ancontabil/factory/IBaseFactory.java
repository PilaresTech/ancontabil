package br.com.pilares.ancontabil.factory;

import br.com.pilares.ancontabil.service.BaseService;

public interface IBaseFactory {
	
	BaseService getService(Class classe);

}