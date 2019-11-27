package cn.ekgc.dkscm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.pojo.entity.Role;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.RoleService;
import cn.ekgc.dkscm.util.ConstantUtil;

@Controller("roleController")
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Resource(name="roleService")
	private RoleService roleService;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String forwordRole() throws Exception{
		return "role/index";
	}
	@RequestMapping(value="/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<Role> getAllRole(Integer pageNum, Integer pageSize, Integer draw) throws Exception{
		Page<Role> page = new Page<Role>(pageNum, pageSize,draw);
		String statusCode = ConstantUtil.STATUS_ENABLE; 
		page = roleService.getRoleByStatusAndPage(page, statusCode);
		return page;
	}
}
