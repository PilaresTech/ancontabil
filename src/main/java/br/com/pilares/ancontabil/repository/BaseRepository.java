package br.com.pilares.ancontabil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E>  {

	List<E> findByDesabilitado(boolean desabilitado);
	
}
