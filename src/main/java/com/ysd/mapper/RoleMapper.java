package com.ysd.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;

public interface RoleMapper {
	/**
	 * ��ѯ���еĽ�ɫ
	 */
	public List<Role> getAllRoles(Map<String, Object> map);

	/**
	 * ��ȡ����������
	 */
	public int getCount();

	/**
	 * ��ӽ�ɫ
	 */
	public int addRoles(Role role);

	/**
	 * �޸Ľ�ɫ
	 */
	public int updateRoleById(Role role);

	/**
	 * ɾ����ɫ
	 */
	public int deleteRoleById(String id);
	/**
	 * ��ѯ����ϵͳģ��
	 */
	/*
	 * public List<Modules> getAllRoleModules();
	 *//**
		 * ��ѯ��ɫ��Ӧ��ģ��
		 */
	/*
	 * public List<Modules> getModuleByRoleId(String id);
	 *//**
		 * ����ɫ����Ȩ��
		 */
	/*
	 * public int AddModulesToRole(@Param("rid")String rid,@Param("mid")int mid);
	 *//**
		 * ����ɫ�¼�Ȩ��
		 *//*
			 * public int RemoveModulesFromRole(@Param("rid")String rid,@Param("mid")int
			 * mid);
			 */
}
