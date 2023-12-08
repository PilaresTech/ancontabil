package br.com.pilares.ancontabil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BaseRepository<E> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E>  {

	List<E> findByDesabilitado(boolean desabilitado);
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	Optional<E> findByIdAndHash(Long id, String hash);
	
}
