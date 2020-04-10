package com.ysd.mapper;

import java.util.List;
import java.util.Map;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;
import com.ysd.entity.User;

public interface UserMapper {
/**
 * 登录验证
 * */
	public User pdLogin(User user);
/**
 * 添加用户
 * */
	public int addUser(User user);
	/**
	 * 查询users
	 * */
	public List<User> getAll(Map<String, Object> map);
	/**
	 * 查询数据总条数
	 * */
	public int getCount(Map<String, Object> map);
	/**
	 * 根据id修改user信息
	 * */
	public int updateUserById(User user);
	/**
	 * 删除user（根据id号删除）
	 * */
	public int deleteUserById(String id);
	/**
	 * 根据LoginName查找user
	 * */
	public User getUserByLoginNameAndPassword(User user);
	/**
	 * 锁定用户
	 * */
	public int LockUser(User user);
	/**
	 * 解锁用户
	 * */
	public int unLockUser(User user);
	/**
	 * 修改密码
	 * */
	public int updatePassword(User user);
	/**
	 * 批量删除user
	 * */
	public int deleteUsers(String id);
	/**
	 * 查询所有角色
	 * */
	public List<Role> getAllRoles();
	/**
	 * 根据userid查询roles
	 * */
	public List<Role> GetRolesByUserIdLayUI(String id);
	/**
	 * 角色添加
	 * */
	public int AddUserToRole(Map<String, Object> map);
	/**
	 * 角色下架
	 * */
	public int RemoveUserFromRole(Map<String, Object> map);
	/**
	 * 根据userid获取角色的name
	 * */
	public List<String> getRoleNames(String id);
	/**
	 * 根据rolename获取modules
	 * */
	public List<Modules> GetSysRightsJsonLayUI(List<String> roleNames);
	/**
	 * 最后登录时间更新
	 * */
	public int updateLastLoginTime(User user);
}
