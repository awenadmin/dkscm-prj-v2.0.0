package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.UserDao;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User getUserByCellphone(String cellphone) throws Exception {
		// 在数据持久层，将会把所所有的查询都进行集成，那么需要封装查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		// 设定查询参数
		params.put("cellphone", cellphone);
		// 进行查询，得到结果集
		List<User> userList = userDao.findByQueryForPage(params);
		// 判断结果集中是否有数据，如果有，也只能有一个
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	@Override
	public Page<User> getAllUserByPage(Page<User> page) throws Exception {
			Map<String, Object> query = new HashMap<String, Object>();
			long totalSize = userDao.findByQueryForPage(null).size();
			query.put("begin", page.getPageNum());
			query.put("size", page.getSize());
			List<User> userList = userDao.findByQueryForPage(query);
			page.setList(userList);
			page.setTotalSize(totalSize);
			page.setTotalPage();
			return page;
	}

	public User getUserById(Long userId) throws Exception {
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("userId", userId);
		List<User> userList = userDao.findByQueryForPage(query);
		return userList.get(0);
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		try {
			userDao.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addUser(User user) throws Exception {
		try {
			userDao.insertUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getUserNo() throws Exception {
		List<User> userList = userDao.findByQueryForPage(null);
		String userNo = userList.get(userList.size()-1).getUserNo();
		String userNo1 = userNo.substring(0,2);
		Integer userNo2 = Integer.parseInt(userNo.substring(2));
		userNo = userNo1 + (String.format("%0" + (userNo.length()-2) + "d", userNo2 + 1));
		return userNo;
	}
}
