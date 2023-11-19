package br.com.pilares.ancontabil.model.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.pilares.ancontabil.util.DataUtilImpl;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder(toBuilder = true)
public abstract class EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public EntityBase() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "HASH", nullable = false)
	private String hash;
	
	@Column(name = "DESABILITADO", nullable = false)
	private boolean desabilitado;
	
	@Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "DATA_ATUALIZACAO")
    private LocalDateTime dataAtualizacao;
    
    @PreUpdate
    protected void preUpdate(){
    	this.setDataAtualizacao(new DataUtilImpl().getDataHoraServidor());
    }
    
    @PrePersist
    private void prePersist() {
    	if(this.getDataCadastro() == null) {
    		this.setDataCadastro(new DataUtilImpl().getDataHoraServidor());
    	}
    	if(this.getHash() == null) {
    		this.setHash(UUID.randomUUID().toString());    		
    	}
    	this.desabilitado = false;
    }
    
}