package org.jsp.userApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.userApp.dto.User;

public class UserDao {
	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	 EntityManager  manager =factory.createEntityManager();

	public  User SaveUser(User user) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(user);
	    transaction.begin();
	    transaction.commit();
		return user;
		
	}
	
	
	public boolean DeleteUser(int id) {
		EntityTransaction transaction = manager.getTransaction();
		User u = manager.find(User.class, id);
		if(u!=null) {
			manager.remove(u);
			transaction.begin();
			transaction.commit();
			return true;
		}
		return false;
	}
	
	
	public User findUserById(int id) {
		return manager.find(User.class, id);
	}
	
	
	
	public   List<User> findAllUser(){
		Query q = manager.createQuery("Select U From User U ");
		return q.getResultList();

	}
	
	
	
	public User VerfyUser(String name,String password) {
		
		Query q = manager.createQuery("Select U From User U Where U.name=?1 and U.password=?2");
		q.setParameter(1, name);
		q.setParameter(2, password);
		List<User>users = q.getResultList();
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
		
	}
	
public User VerifyUser(String name,String password) {
		
		Query q = manager.createQuery("Select U From User U Where U.name=?1 and U.password=?2");
		q.setParameter(1, name);
		q.setParameter(2, password);
		List<User>users = q.getResultList();
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
		
	}
	
	
	
	
 

}
