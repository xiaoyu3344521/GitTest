package com.ysd.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;
import com.ysd.entity.User;
import com.ysd.mapper.UserMapper;
import com.ysd.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
    private UserMapper userMapper;
	public User pdLogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.pdLogin(user);
	}
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}
	public List<User> getAll(String LoginName,String begin,String end,String isLockout,String orderby,int page,int limit) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LoginName", LoginName);
		map.put("begin", begin);
		map.put("end", end);
		map.put("isLockout", isLockout);
		map.put("orderby", orderby);
		map.put("page", page);
		map.put("limit", limit);
		return userMapper.getAll(map);
	}
	public int updateUserById(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserById(user);
	}
	public int deleteUserById(String id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserById(id);
	}
	public User getUserByLoginNameAndPassword(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginNameAndPassword(user);
	}
	public int LockUser(User user) {
		// TODO Auto-generated method stub
		user.setIsLockout("ÊÇ");
		return userMapper.LockUser(user);
	}
	public int unLockUser(User user) {
		// TODO Auto-generated method stub
		user.setIsLockout("·ñ");
		return userMapper.unLockUser(user);
	}
	public int updatePassword(User user) {
		// TODO Auto-generated method stub
		return userMapper.updatePassword(user);
	}
	public int daleteUsers(String id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUsers(id);
	}
	public int getCount(String LoginName, String begin, String end, String isLockout) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LoginName", LoginName);
		map.put("begin", begin);
		map.put("end", end);
		map.put("isLockout", isLockout);
		return userMapper.getCount(map);
	}
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return userMapper.getAllRoles();
	}
	public List<Role> GetRolesByUserIdLayUI(String id) {
		// TODO Auto-generated method stub
		return userMapper.GetRolesByUserIdLayUI(id);
	}
	public int AddUserToRole(String uid, String rid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("rid", rid);
		return userMapper.AddUserToRole(map);
	}
	public int RemoveUserFromRole(String uId, String rId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uId);
		map.put("rid", rId);
		return userMapper.RemoveUserFromRole(map);
	}
	public List<String> getRoleNames(String id) {
		// TODO Auto-generated method stub
		return userMapper.getRoleNames(id);
	}
	public List<Modules> GetSysRightsJsonLayUI(List<String> roleNames) {
		// TODO Auto-generated method stub
		return userMapper.GetSysRightsJsonLayUI(roleNames);
	}
	public int updateLastLoginTime(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateLastLoginTime(user);
	}
	
}
