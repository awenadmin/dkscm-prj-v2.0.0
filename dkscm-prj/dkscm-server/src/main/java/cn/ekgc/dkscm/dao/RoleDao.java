package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.Role;

public interface RoleDao {

	List<Role> findRoleListByQuery(Map<String, Object> query)throws Exception;

}
