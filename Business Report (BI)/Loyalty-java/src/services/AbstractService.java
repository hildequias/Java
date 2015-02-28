package services;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingInclude;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

public class AbstractService<T> {

	protected Class<T> classVO = null;
	public HibernateTemplate template;

	
	public AbstractService()
	{
		this.classVO = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		template = new HibernateTemplate(sessionFactory);
	}

	@RemotingInclude
	public void add(T t) throws Exception
	{
		this.template.save(t);
	}

	@RemotingInclude
	public void update(T t)
	{
		this.template.update(t);
	}

	@RemotingInclude
	public void del(T t)
	{
		this.template.delete(t);
	}

	@RemotingInclude
	public List<T> findAll()
	{
		return template.find(String.format("from %s", this.classVO.getName()));
	}
	
	@RemotingInclude
	public List<T> findByExample(T t)
	{
		return this.template.findByExample(t);
	}

}
