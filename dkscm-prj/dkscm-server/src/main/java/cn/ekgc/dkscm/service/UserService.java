package cn.ekgc.dkscm.service;

import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.pojo.vo.Page;

public interface UserService {
	User getUserByCellphone(String cellphone) throws Exception;

	Page<User> getAllUserByPage(Page<User> page) throws Exception;

	User getUserById(Long userId) throws Exception;

	boolean updateUser(User user) throws Exception;

	boolean addUser(User user) throws Exception;

	String getUserNo() throws Exception;


}
