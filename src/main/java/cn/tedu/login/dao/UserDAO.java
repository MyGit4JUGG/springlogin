package cn.tedu.login.dao;

import cn.tedu.login.entity.User;

/**
 *  ���ݷ��ʲ�ӿ�
 */
public interface UserDAO {
	public User findByUsername(String uname);
}


