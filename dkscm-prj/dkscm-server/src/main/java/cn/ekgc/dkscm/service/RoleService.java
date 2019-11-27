package cn.ekgc.dkscm.service;

import cn.ekgc.dkscm.pojo.entity.Role;
import cn.ekgc.dkscm.pojo.vo.Page;

public interface RoleService {

	Page<Role> getRoleByStatusAndPage(Page<Role> page, String statusCode) throws Exception;

}
