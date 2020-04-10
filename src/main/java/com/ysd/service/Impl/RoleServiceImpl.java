package com.ysd.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;
import com.ysd.mapper.RoleMapper;
import com.ysd.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    @Resource
    private RoleMapper roleMapper;
	public List<Role> getAllRoles(int page,int limit) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("limit", limit);
		return roleMapper.getAllRoles(map);
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return roleMapper.getCount();
	}
	public int addRoles(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.addRoles(role);
	}
	public int updateRoleById(Role role) {
		// TODO Auto-generated method stub
		return roleMapper.updateRoleById(role);
	}
	public int deleteRoleById(String id) {
		// TODO Auto-generated method stub
		return roleMapper.deleteRoleById(id);
	}
	/*
	 * public List<Modules> getAllRoleModules() { // TODO Auto-generated method stub
	 * return roleMapper.getAllRoleModules(); } public List<Modules>
	 * getModuleByRoleId(String id) { // TODO Auto-generated method stub return
	 * roleMapper.getModuleByRoleId(id); } public int AddModulesToRole(String rid,
	 * int mid) { // TODO Auto-generated method stub return
	 * roleMapper.AddModulesToRole(rid, mid); } public int
	 * RemoveModulesFromRole(String rid, int mid) { // TODO Auto-generated method
	 * stub return roleMapper.RemoveModulesFromRole(rid,mid); }
	 */

}
