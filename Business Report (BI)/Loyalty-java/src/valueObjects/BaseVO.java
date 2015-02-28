package valueObjects;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseVO {

	String cadastro_usuario;
	
	@Column(name="excluido", nullable = false,  columnDefinition="bit default 0", insertable = false, updatable = true) 
	Boolean excluido;
	
	@Basic
	@Temporal(TemporalType.DATE)
	Date excluido_data;
	
	String excluido_usuario;
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name="cadastro_data", nullable = false, insertable = true, updatable = false)
	Date cadastro_data;

	public String getCadastro_usuario() {
		return cadastro_usuario;
	}

	public void setCadastro_usuario(String cadastroUsuario) {
		cadastro_usuario = cadastroUsuario;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

	public Date getExcluido_data() {
		return excluido_data;
	}

	public void setExcluido_data(Date excluidoData) {
		excluido_data = excluidoData;
	}

	public String getExcluido_usuario() {
		return excluido_usuario;
	}

	public void setExcluido_usuario(String excluidoUsuario) {
		excluido_usuario = excluidoUsuario;
	}

	public Date getCadastro_data() {
		return cadastro_data;
	}

	public void setCadastro_data(Date cadastroData) {
		cadastro_data = cadastroData;
	}
}
