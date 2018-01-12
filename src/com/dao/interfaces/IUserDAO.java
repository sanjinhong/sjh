package com.dao.interfaces;

import java.util.List;

import com.beans.User;

public interface IUserDAO {

	List<User> selectUser(String yhxm, String yhbm);

	void insert(User user);

	void delete(String yhdm);

	void update(User user);

	List<User> selectUserByYhdm(String yhdmParam);


}
