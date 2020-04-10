package com.ysd.mapper;

import java.util.List;
import java.util.Map;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;
import com.ysd.entity.User;

public interface UserMapper {
/**
 * ��¼��֤
 * */
	public User pdLogin(User user);
/**
 * ����û�
 * */
	public int addUser(User user);
	/**
	 * ��ѯusers
	 * */
	public List<User> getAll(Map<String, Object> map);
	/**
	 * ��ѯ����������
	 * */
	public int getCount(Map<String, Object> map);
	/**
	 * ����id�޸�user��Ϣ
	 * */
	public int updateUserById(User user);
	/**
	 * ɾ��user������id��ɾ����
	 * */
	public int deleteUserById(String id);
	/**
	 * ����LoginName����user
	 * */
	public User getUserByLoginNameAndPassword(User user);
	/**
	 * �����û�
	 * */
	public int LockUser(User user);
	/**
	 * �����û�
	 * */
	public int unLockUser(User user);
	/**
	 * �޸�����
	 * */
	public int updatePassword(User user);
	/**
	 * ����ɾ��user
	 * */
	public int deleteUsers(String id);
	/**
	 * ��ѯ���н�ɫ
	 * */
	public List<Role> getAllRoles();
	/**
	 * ����userid��ѯroles
	 * */
	public List<Role> GetRolesByUserIdLayUI(String id);
	/**
	 * ��ɫ���
	 * */
	public int AddUserToRole(Map<String, Object> map);
	/**
	 * ��ɫ�¼�
	 * */
	public int RemoveUserFromRole(Map<String, Object> map);
	/**
	 * ����userid��ȡ��ɫ��name
	 * */
	public List<String> getRoleNames(String id);
	/**
	 * ����rolename��ȡmodules
	 * */
	public List<Modules> GetSysRightsJsonLayUI(List<String> roleNames);
	/**
	 * ����¼ʱ�����
	 * */
	public int updateLastLoginTime(User user);
}
