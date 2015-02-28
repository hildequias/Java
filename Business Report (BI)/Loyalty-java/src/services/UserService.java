package services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.stereotype.Service;

import valueObjects.UserVO;

@Service("UserService")
@RemotingDestination(channels={"my-amf"})
public class UserService extends AbstractService<UserVO>{
	
	@RemotingInclude
	public UserVO login(UserVO t) throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		Session newSession = template.getSessionFactory().openSession();
		List<UserVO> usuarios = newSession.createCriteria(UserVO.class).add(Restrictions.eq("excluido", false))
																			 .add(Restrictions.eq("password",geraMD5(t)))
																			 .add(Restrictions.eq("ativo", true))
																			 .add(Restrictions.eq("usuario", t.getUsuario())).list();
		newSession.close();

		if (usuarios.size()==1)
			return usuarios.get(0);

		return null;
	}
	
	@RemotingInclude
	@Override
	public void add(UserVO t)throws Exception{
		
		//Verifica se o usuário já existe através do usuario
		UserVO verificaUsuario = new UserVO();
		verificaUsuario.setUsuario(t.getUsuario());
		
		List<UserVO> usuarios = this.findByExample(verificaUsuario);
		
		if (usuarios.size()==0)
		{	
			// Gera o password em MD5 para salvar no Banco
			t.setPassword(geraMD5(t));
			super.add(t);
		}
		else
		{
			throw new Exception("Usuário existente! Tente outro");
		}
	}
	
	public String geraMD5(UserVO t)throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		//Transforma a senha digitada do Usuario em MD5
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		byte messageDigest[] = algorithm.digest(t.getPassword().getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();
	}
}
