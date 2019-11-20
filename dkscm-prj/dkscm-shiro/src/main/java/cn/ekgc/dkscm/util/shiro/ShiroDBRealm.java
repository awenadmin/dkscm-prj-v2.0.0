package cn.ekgc.dkscm.util.shiro;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.service.UserService;
import cn.ekgc.dkscm.util.ConstantUtil;
import cn.ekgc.dkscm.util.MD5Util;

@Component("shiroDBRealm")
public class ShiroDBRealm extends AuthorizingRealm {
	@Resource(name = "userService")
	private UserService userService;
	@Autowired
	private HttpSession session;

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * <b>Shiro进行认证的规则方法</b>
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) 
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String cellphone = token.getUsername();
		char[] pwds = token.getPassword();
		
		if (cellphone != null && !"".equals(cellphone.trim()) 
				&& pwds != null && pwds.length > 0) {
			token.setPassword(MD5Util.encrypt(new String(pwds)).toCharArray());
			try {
				User user = userService.getUserByCellphone(cellphone);
				if (user != null && ConstantUtil.STATUS_ENABLE.equals(user.getStatus().getStatusCode())) {
					SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
							user.getCellphone(), user.getPassword(), getName());
					session.setAttribute("user", user);
					System.out.println(1123);
					return info;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
