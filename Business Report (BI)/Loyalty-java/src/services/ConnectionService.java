package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import valueObjects.ConnectionVO;

@Service("ConnectionService")
@RemotingDestination(channels={"my-amf"})
public class ConnectionService extends AbstractService<ConnectionVO>{
	
	@RemotingInclude
	@Override
	public List<ConnectionVO> findAll(){
		
		Session newSession = template.getSessionFactory().openSession();
		List<ConnectionVO> conexoes = newSession.createCriteria(ConnectionVO.class).add(Restrictions.eq("excluido", false)).list();
		newSession.close();
		
		return conexoes;
	}
}
