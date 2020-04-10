package com.ysd.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;

public interface RoleMapper {
	/**
	 * 查询所有的角色
	 */
	public List<Role> getAllRoles(Map<String, Object> map);

	/**
	 * 获取数据总条数
	 */
	public int getCount();

	/**
	 * 添加角色
	 */
	public int addRoles(Role role);

	/**
	 * 修改角色
	 */
	public int updateRoleById(Role role);

	/**
	 * 删除角色
	 */
	public int deleteRoleById(String id);
	/**
	 * 查询所有系统模块
	 */
	/*
	 * public List<Modules> getAllRoleModules();
	 *//**
		 * 查询角色对应的模块
		 */
	/*
	 * public List<Modules> getModuleByRoleId(String id);
	 *//**
		 * 给角色赋予权限
		 */
	/*
	 * public int AddModulesToRole(@Param("rid")String rid,@Param("mid")int mid);
	 *//**
		 * 给角色下架权限
		 *//*
			 * public int RemoveModulesFromRole(@Param("rid")String rid,@Param("mid")int
			 * mid);
			 */
}
