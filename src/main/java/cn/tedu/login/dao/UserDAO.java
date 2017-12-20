package cn.tedu.login.dao;

import cn.tedu.login.entity.User;

/**
 *  数据访问层接口
 */
public interface UserDAO {
	public User findByUsername(String uname);
}


