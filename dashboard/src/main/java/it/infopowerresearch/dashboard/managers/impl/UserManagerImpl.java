package it.infopowerresearch.dashboard.managers.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.infopowerresearch.dashboard.bean.User;
import it.infopowerresearch.dashboard.dao.UserDAO;
import it.infopowerresearch.dashboard.managers.UserManager;

@Component
public class UserManagerImpl implements UserManager {

	private Logger log = LoggerFactory.getLogger(UserManagerImpl.class);
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User login(String username, String password) {
		User u = userDAO.findByUsername(username);
		
		if (u.getPassword().equals(password)) {
			return u;
		}

		return null;
	}

}
