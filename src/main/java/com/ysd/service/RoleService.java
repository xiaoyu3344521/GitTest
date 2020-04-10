package com.ysd.service;

import java.util.List;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;

public interface RoleService {
public List<Role> getAllRoles(int page,int limit);
public int getCount();
public int addRoles(Role role);
public int updateRoleById(Role role);
public int deleteRoleById(String id);
	/*
	 * public List<Modules> getAllRoleModules(); public List<Modules>
	 * getModuleByRoleId(String id); public int AddModulesToRole(String rid,int
	 * mid); public int RemoveModulesFromRole(String rid, int mid);
	 */
}
