package valueObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BI_USUARIOS")
public class UserVO extends BaseVO{
	
	@Id
	@GeneratedValue
	int id;
	
	String usuario;
	String nome_completo;
	String email;
	
	String password;
	String observacao;
	
	@Column(name="ativo", nullable = false,  columnDefinition="bit default 1", insertable = false, updatable = true)
	Boolean ativo;
	
	@Temporal(TemporalType.DATE)
	Date data_ultimo_login;
	
	@ManyToOne(fetch=FetchType.EAGER)
	UserProfileVO perfilUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nomeCompleto) {
		nome_completo = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData_ultimo_login() {
		return data_ultimo_login;
	}

	public void setData_ultimo_login(Date dataUltimoLogin) {
		data_ultimo_login = dataUltimoLogin;
	}

	public UserProfileVO getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(UserProfileVO perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
}
