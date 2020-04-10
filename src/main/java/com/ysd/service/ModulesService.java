package com.ysd.service;

import java.util.List;

import com.ysd.entity.Modules;

public interface ModulesService {
	 public List<Modules> getAllModules();
	 public int updateModulesById(Modules modules);
	 public int deleteModulesById(int id);
	 public int addModules(Modules modules);
	 public List<Integer> getModulesIds(String id);
	 public int deleteRoleModulesByRoleId(String id);
	 public int addRoleModules(Integer integer, String rid);
}
