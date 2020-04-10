package com.ysd.mapper;

import java.util.List;
import java.util.Map;

import com.ysd.entity.Modules;

public interface ModulesMapper {
   public List<Modules> getAllModules();
   public int updateModulesById(Modules modules);
   public int deleteModulesById(int id);
   public int addModules(Modules modules);
   public List<Integer> getModulesIds(String id);
   public int deleteRoleModulesByRoleId(String id);
   public int addRoleModules(Map<String, Object> map);
}
