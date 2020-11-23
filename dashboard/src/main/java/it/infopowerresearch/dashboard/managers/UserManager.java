package it.infopowerresearch.dashboard.managers;

import it.infopowerresearch.dashboard.beans.User;

public interface UserManager {

	public User login(String username, String password);

}
