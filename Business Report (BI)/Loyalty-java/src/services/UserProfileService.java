package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import valueObjects.UserProfileVO;

@Service("UserProfileService")
@RemotingDestination(channels={"my-amf"})
public class UserProfileService extends AbstractService<UserProfileVO>{
	
	@RemotingInclude
	@Override
	public List<UserProfileVO> findAll(){
		
		Session newSession = template.getSessionFactory().openSession();
		List<UserProfileVO> perfis = newSession.createCriteria(UserProfileVO.class).add(Restrictions.eq("excluido", false)).list();
		newSession.close();
		
		return perfis;
	}
}
