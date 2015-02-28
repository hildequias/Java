package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import valueObjects.UserProfileVO;
import valueObjects.PermissionVO;

@Service("PermissionService")
@RemotingDestination(channels={"my-amf"})
public class PermissionService extends AbstractService<PermissionVO>{
	
	@RemotingInclude
	public List<PermissionVO> getByPerfilUsuario(UserProfileVO p){
		
		Session newSession = template.getSessionFactory().openSession();
		List<PermissionVO> permissoes = newSession.createCriteria(PermissionVO.class).add(Restrictions.eq("perfilUsuario", p)).list();
		newSession.close();
		return permissoes;
	}
	
	@RemotingInclude
	public void addListaPermissao(List<PermissionVO> permissoes, UserProfileVO perfil )throws Exception{
		
		Session newSession = template.getSessionFactory().openSession();
		List<PermissionVO> lista = newSession.createCriteria(PermissionVO.class).add(Restrictions.eq("perfilUsuario", perfil)).list();
		newSession.close();
		
		// Deleta todas as Permissoes do Perfil
		for(PermissionVO p : lista){
			this.del(p);
		}

		// Insere a nova lista de Permissoes do perfil
		for(PermissionVO p : permissoes){
			
			this.add(p);
		}
	}
}
