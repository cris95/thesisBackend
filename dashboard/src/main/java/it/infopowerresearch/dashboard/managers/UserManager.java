package it.infopowerresearch.dashboard.managers;

import it.infopowerresearch.dashboard.bean.User;

public interface UserManager {

	public User login(String username, String password);

}
