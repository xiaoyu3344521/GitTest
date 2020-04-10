package com.ysd.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ysd.entity.Modules;
import com.ysd.mapper.ModulesMapper;
import com.ysd.service.ModulesService;
@Service
@Transactional
public class ModulesServiceImpl implements ModulesService{
	@Resource
    private ModulesMapper modulesMapper;
	public List<Modules> getAllModules() {
		// TODO Auto-generated method stub
		return modulesMapper.getAllModules();
	}
	public int updateModulesById(Modules modules) {
		// TODO Auto-generated method stub
		return modulesMapper.updateModulesById(modules);
	}
	public int deleteModulesById(int id) {
		// TODO Auto-generated method stub
		return modulesMapper.deleteModulesById(id);
	}
	public int addModules(Modules modules) {
		// TODO Auto-generated method stub
		return modulesMapper.addModules(modules);
	}
	public List<Integer> getModulesIds(String id) {
		// TODO Auto-generated method stub
		return modulesMapper.getModulesIds(id);
	}
	public int deleteRoleModulesByRoleId(String id) {
		// TODO Auto-generated method stub
		return modulesMapper.deleteRoleModulesByRoleId(id);
	}
	public int addRoleModules(Integer integer, String rid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("integer", integer);
		map.put("rid", rid);
		return modulesMapper.addRoleModules(map);
	}

}
