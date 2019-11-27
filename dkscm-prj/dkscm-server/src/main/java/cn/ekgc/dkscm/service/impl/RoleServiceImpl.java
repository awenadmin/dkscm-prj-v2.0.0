package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.MenuDao;
import cn.ekgc.dkscm.dao.RoleDao;
import cn.ekgc.dkscm.pojo.entity.Role;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
	@Resource(name = "roleDao")
	private RoleDao roleDao;
	@Resource(name = "menuDao")
	private MenuDao menuDao;
	public Page<Role> getRoleByStatusAndPage(Page<Role> page, String statusCode) throws Exception {
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("statusCode", statusCode);
		long totalSize = roleDao.findRoleListByQuery(query).size();
		query.put("pageBegin", page.getBegin());
		query.put("size", page.getSize());
		List<Role> roleList = roleDao.findRoleListByQuery(query);
		for (Role role : roleList) {
			query.put("roleId", role.getRoleId());
			role.setMenuList(menuDao.finMenuByQuery(query));
		}
		page.setList(roleList);
		page.setTotalSize(totalSize);
		page.setTotalPage();
		return page;
	}
}
