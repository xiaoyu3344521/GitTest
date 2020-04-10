package com.ysd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.entity.Modules;
import com.ysd.entity.Role;
import com.ysd.service.RoleService;

@RestController
public class RoleController {
   @Resource
   RoleService roleService;
   @RequestMapping("/getAllRoles")
   public Map<String, Object> getAllRoles(int page,int limit){
	Map<String, Object> map = new HashMap<String, Object>();
	int page1 = (page-1)*limit;
	List<Role> list = roleService.getAllRoles(page1, limit);
	int count = roleService.getCount();
	map.put("code", 0);
	map.put("msg", "");
	map.put("data", list);
	map.put("count", count);
	return map;  
   }
   @RequestMapping("/addRoles")
   public int addRoles(Role role) {
	   int a = 0;
	   a = roleService.addRoles(role);
	   return a;
   }
   @RequestMapping("/updateRoleById")
   public int updateRoleById(Role role) {
	   int a = 0;
	   a = roleService.updateRoleById(role);
	   return a;
   }
   @RequestMapping("/deleteRoleById")
   public int deleteRoleById(String id) {
	   int a = 0;
	   a = roleService.deleteRoleById(id);
	   return a;
   }
   @RequestMapping("/deleteRoles")
   public int deleteRoles(String ids) {
	   int a = 0;
		if(ids!=null&&!ids.equals("")){
			String[] s =ids.split("£¬");
			for (String id : s) {
				if(id!=null&&!id.equals("")) {
					a = roleService.deleteRoleById(id);
				}
			}
		}
		return a;
   }
	/*
	 * @RequestMapping("/getAllRoleModules") public List<Modules>
	 * getAllRoleModules(){ List<Modules> list = roleService.getAllRoleModules();
	 * return list; }
	 * 
	 * @RequestMapping("/getModuleByRoleId") public List<Modules>
	 * getModuleByRoleId(String id){ List<Modules> list =
	 * roleService.getModuleByRoleId(id); return list; }
	 * 
	 * @RequestMapping("/AddModulesToRole") public int AddModulesToRole(String
	 * rid,int mid){ int a = roleService.AddModulesToRole(rid, mid); return a; }
	 * 
	 * @RequestMapping("RemoveModulesFromRole") public int
	 * RemoveModulesFromRole(String rid,int mid){ int a =
	 * roleService.RemoveModulesFromRole(rid, mid); return a; }
	 */
}
