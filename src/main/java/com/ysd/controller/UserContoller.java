package com.ysd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;
import com.ysd.entity.User;
import com.ysd.redis.RedisTrans;
import com.ysd.service.UserService;

@RestController
public class UserContoller {
	@Resource
	UserService userService;
	@Resource(name = "redis")
	RedisTrans redisTrans;

	/**
	 * 在这里获取调用业务层，并将结果响应给我们的页面
	 */
	@RequestMapping("/Login")
	public Map<String, Object> Login(User user) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String Time = df.format(new Date());
		User user1 = userService.getUserByLoginNameAndPassword(user);
		Map<String, Object> map = new HashMap<String, Object>();
		if (user1 != null) {
			if (user1.getIsLockout().equals("是")) {
				String time = user1.getLastLoginTime();
				map.put("msg", "账号已被锁定,锁定时间是" + time);
				map.put("code", "1");
			} else {
				map.put("msg", "登陆成功");
				user1.setLastLoginTime(Time);
				userService.updateLastLoginTime(user1);				
				List<Object> list = new ArrayList<Object>();
				list.add(user1);
				redisTrans.set("id", user1.getId());
				redisTrans.set("name", user1.getLoginName());
				map.put("data", user1);
				map.put("code", "0");
			}
		} else {
			map.put("msg", "登陆失败，请检查用户名或密码是否正确");
			map.put("code", "1");
		}
		return map;
	}
	@RequestMapping("/getSession")
    public Map<String, Object> getSession(){
		String id ="";
    	id = redisTrans.get("id");
    	String name = redisTrans.get("name");
    	User user = new User();
    	user.setId(id);
    	user.setLoginName(name);
    	System.out.println(id);
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("msg", user);
    	return map;
    }
	@RequestMapping("/Loginout")
	public void Loginout() {
		redisTrans.delete("id");
	}
	@RequestMapping("/getAll")
	public Map<String, Object> getAll(String LoginName, String begin, String end, String isLockout, String orderby,
			int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		int page1 = (page - 1) * limit;
		int count = userService.getCount(LoginName, begin, end, isLockout);
		List<User> list = userService.getAll(LoginName, begin, end, isLockout, orderby, page1, limit);
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", list);
		map.put("count", count);
		return map;
	}

	@RequestMapping("/getRoles")
	public List<Role> getAllRoles() {
		List<Role> list = userService.getAllRoles();
		return list;
	}

	@RequestMapping("/GetRolesByUserIdLayUI")
	public List<Role> GetRolesByUserIdLayUI(String id) {
		List<Role> list = userService.GetRolesByUserIdLayUI(id);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/RemoveUserFromRole")
	public int RemoveUserFromRole(String uId, String rId) {
		int a = userService.RemoveUserFromRole(uId, rId);
		return a;
	}

	@RequestMapping("/AddUserToRole")
	public int AddUserToRole(String uId, String rId) {
		int a = userService.AddUserToRole(uId, rId);
		return a;
	}

	@RequestMapping("/addUser")
	public int addUser(User user) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String createTime = df.format(new Date());// new Date()为获取当前系统时间
		user.setCreateTime(createTime);
		user.setIsLockout("否");
		int a = userService.addUser(user);
		return a;
	}

	@RequestMapping("/updateUserById")
	public int updateUserById(User user) {
		int a = userService.updateUserById(user);
		return a;
	}

	@RequestMapping("/deleteUserById")
	public int deleteUserById(String id) {
		int a = userService.deleteUserById(id);
		return a;
	}

	@RequestMapping("/lockUser")
	public int lockUser(User user) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String LockTime = df.format(new Date());// new Date()为获取当前系统时间
		user.setLockTime(LockTime);
		int a = userService.LockUser(user);
		return a;
	}

	@RequestMapping("/unLockUser")
	public int unLockUser(User user) {
		int a = userService.unLockUser(user);
		return a;
	}

	@RequestMapping("/updatePassWord")
	public int updatePassWord(User user) {
		int a = userService.updatePassword(user);
		return a;
	}
	@RequestMapping("/deleteUsers")
	public int deleteUsers(String ids) {
		int a = 0;
		if (ids != null && !ids.equals("")) {
			String[] s = ids.split("，");
			for (String id : s) {
				if (id != null && !id.equals("")) {
					a = userService.daleteUsers(id);
				}
			}
		}
		return a;
	}
	@RequestMapping("/getRoleNames")
	public Map<String, Object> getRoleNames(String id){
		List<String> list = userService.getRoleNames(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", list);
		return map;
	}
	@RequestMapping("/GetSysRightsJsonLayUI")
	public Map<String, Object> GetSysRightsJsonLayUI(@RequestParam(value="roleNames")List<String> roleNames){
		//System.out.println(roleNames);
		List<Modules> modules = new ArrayList<Modules>();
		modules = userService.GetSysRightsJsonLayUI(roleNames);
		Set<Object> set = new HashSet<Object>();
		for (Modules m : modules) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(m.getParentId()==0) {
				map.put("id", m.getId());
				map.put("title", m.getName());
				map.put("checked",false);
				map.put("href", m.getPath());
				map.put("children", pdChild(m.getId(), modules));
				set.add(map);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", set);
		return map;
	}
	public Set<Object> pdChild(int id,List<Modules> list){
		   Set<Object> set = new HashSet<Object>();
		   for (Modules ls : list) {
			if(ls.getParentId()==id) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", ls.getId());
				map.put("title", ls.getName());
				map.put("checked",false);
				map.put("href", ls.getPath());
				set.add(map);
			}
		}
		   return set;	   
	   }
}
