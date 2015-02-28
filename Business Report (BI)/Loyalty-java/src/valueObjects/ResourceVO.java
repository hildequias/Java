package valueObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BI_RECURSOS")
public class ResourceVO {
	
	@Id
	@GeneratedValue
	int id;
	
	String nome_exibicao;
	String descricao;
	int visao;
	String icon;
	String grupo;
	Boolean excluido;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_exibicao() {
		return nome_exibicao;
	}
	public void setNome_exibicao(String nomeExibicao) {
		nome_exibicao = nomeExibicao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getVisao() {
		return visao;
	}
	public void setVisao(int visao) {
		this.visao = visao;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Boolean getExcluido() {
		return excluido;
	}
	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}
}
