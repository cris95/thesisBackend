package it.infopowerresearch.dashboard.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.infopowerresearch.dashboard.bean.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
