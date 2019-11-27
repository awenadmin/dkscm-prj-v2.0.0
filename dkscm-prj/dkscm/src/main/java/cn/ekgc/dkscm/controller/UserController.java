package cn.ekgc.dkscm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.pojo.entity.Role;
import cn.ekgc.dkscm.pojo.entity.Status;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.UserService;
import cn.ekgc.dkscm.util.ConstantUtil;

@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource(name="userService")
	private UserService userService;
	/**
	 * <b>转发登录界面</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() throws Exception {
		return "user/user_login_form";
	}
	
	/**
	 * <b>登陆失败之后的重定向</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginError() throws Exception {
		return "redirect:logout";
	}
	@RequestMapping(value="/index")
	public String forwordIndex() throws Exception{
		return "user/index";
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public Page<User> getAllUser(Integer pageNum,Integer pageSize, Integer draw) throws Exception{
		Page<User> page = new Page<User>(pageNum, pageSize,draw);
		page = userService.getAllUserByPage(page);
		return page;
	}
	@RequestMapping(value="/userDetial/{userId}")
	public String forwordUserDetial(@PathVariable("userId")Long userId, ModelMap map) throws Exception {
		User user = userService.getUserById(userId);
		map.put("user", user);
		return "user/user_form";
	}
	@RequestMapping(value="/userUpdate/{userId}", method=RequestMethod.GET)
	public String forwordUserUpdate(@PathVariable("userId")Long userId, ModelMap map) throws Exception {
		User user = userService.getUserById(userId);
		map.put("user", user);
		return "user/update_form";
	}
	@RequestMapping(value="/userUpdate/{userId}", method=RequestMethod.POST)
	@ResponseBody
	public boolean updateUserById(@PathVariable("userId")Long userId,Role role, User user) throws Exception {
		user.setUserId(userId);
		user.setRole(role);
		return userService.updateUser(user);
	}
	@RequestMapping(value="/userDelete/{userId}", method=RequestMethod.GET)
	public String forwordUserDelete(@PathVariable("userId")Long userId, ModelMap map) throws Exception {
		User user = userService.getUserById(userId);
		map.put("user", user);
		return "user/delete_form";
	}
	@RequestMapping(value="/userDelete/{userId}", method=RequestMethod.POST)
	@ResponseBody
	public boolean deleteUserById(@PathVariable("userId")Long userId, String statusCode) throws Exception{
		User user = new User();
		user.setUserId(userId);
		Status status = new Status();
		status.setStatusCode(statusCode);
		user.setStatus(status);
		return userService.updateUser(user);
	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String forwordUserDelete(ModelMap map) throws Exception {
		User user = (User) session.getAttribute("user");
		map.put("user", user);
		return "user/user_detial";
	}
	@RequestMapping(value="/regist_form", method = RequestMethod.GET)
	public String forwordRegistForm(ModelMap map) throws Exception{
		String userNo = userService.getUserNo();
		map.put("userNo", userNo);
		return "user/regist_form";
		}
	@RequestMapping(value="/regist_form", method = RequestMethod.POST)
	@ResponseBody
	public boolean addUser(Role role, User user) throws Exception{
		Status status = new Status();
		status.setStatusCode(ConstantUtil.STATUS_ENABLE);
		user.setStatus(status);
		user.setRole(role);
		return userService.addUser(user);
	}
	
}
