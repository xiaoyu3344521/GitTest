package com.ysd.service;

import java.util.List;
import java.util.Map;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;
import com.ysd.entity.User;

public interface UserService {
		public User pdLogin(User user);
		public int addUser(User user);
		public List<User> getAll(String LoginName,String begin,String end,String isLockout,String orderby,int page,int limit);
		public int getCount(String LoginName,String begin,String end,String isLockout);
		public int updateUserById(User user);
		public int deleteUserById(String id);
		public User getUserByLoginNameAndPassword(User user);
		public int LockUser(User user);
		public int unLockUser(User user);
		public int updatePassword(User user);
		public int daleteUsers(String id);
		public List<Role> getAllRoles();
		public List<Role> GetRolesByUserIdLayUI(String id);
		public int AddUserToRole(String uid,String rid);
		public int RemoveUserFromRole(String uId, String rId);
	    public List<String> getRoleNames(String id);
		public List<Modules> GetSysRightsJsonLayUI(List<String> roleNames);
		public int updateLastLoginTime(User user);
}
