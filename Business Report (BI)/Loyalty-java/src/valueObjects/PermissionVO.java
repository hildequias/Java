package valueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BI_PERMISSOES")
public class PermissionVO {
	
	@Id
	@GeneratedValue
	int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	ResourceVO recurso;
	
	@ManyToOne(fetch=FetchType.EAGER)
	UserProfileVO perfilUsuario;
	
	@Column(name="novo", nullable = false,  columnDefinition="bit default 0") 
	Boolean novo;
	
	@Column(name="editar", nullable = false,  columnDefinition="bit default 0") 
	Boolean editar;
	
	@Column(name="excluir", nullable = false,  columnDefinition="bit default 0") 
	Boolean excluir;

	public Boolean getNovo() {
		return novo;
	}

	public void setNovo(Boolean novo) {
		this.novo = novo;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public Boolean getExcluir() {
		return excluir;
	}

	public void setExcluir(Boolean excluir) {
		this.excluir = excluir;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ResourceVO getRecurso() {
		return recurso;
	}

	public void setRecurso(ResourceVO recurso) {
		this.recurso = recurso;
	}

	public UserProfileVO getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(UserProfileVO perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
}
