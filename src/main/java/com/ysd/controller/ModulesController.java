package com.ysd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.entity.Modules;
import com.ysd.service.ModulesService;

@RestController
public class ModulesController {
	@Resource
	ModulesService modulesService;
	
   @RequestMapping("/getAllModules")
   public List<Object> getAllModules(){
	List<Object> list = new ArrayList<Object>();
	List<Modules> modules = modulesService.getAllModules();
	for (Modules m : modules) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(m.getParentId()==0) {
			map.put("id", m.getId());
			map.put("title", m.getName());
			map.put("parentid", m.getParentId());
			map.put("weight", m.getWeight());
			map.put("url", m.getPath());
			map.put("children", pdChild(m.getId(), modules));
			list.add(map);
		}
	}
	   return list;   
   }
   //判断子节点
   public List<Object> pdChild(int id,List<Modules> list){
	   List<Object> m = new ArrayList<Object>();
	   for (Modules ls : list) {
		if(ls.getParentId()==id) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", ls.getId());
			map.put("title", ls.getName());
			map.put("parentid", ls.getParentId());
			map.put("weight", ls.getWeight());
			map.put("url", ls.getPath());
			m.add(map);
		}
	}
	   return m;	   
   } 
   //根据id修改节点名称
   @RequestMapping("/updateModulesById")
   public int updateModulesById(Modules modules) {
	   int  a = modulesService.updateModulesById(modules);
	   return a;   
   }
   //根据userid获取模块id
   @RequestMapping("/getModulesIds")
   public Map<String, Object> getModulesIds(String id){
	   List<Integer> list = new ArrayList<Integer>();
	   list = modulesService.getModulesIds(id);
	   //System.out.println(list);
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("data", list);
	   return map;
   }
   @RequestMapping("/addModulesAdmin")
   public int addModulesAdmin(@RequestParam("mid")List<Integer> mid,@RequestParam("rid")String rid){
	   //System.out.println(mid);
	   //System.out.println(rid);
	   int b = modulesService.deleteRoleModulesByRoleId(rid);
	   int a = 0;
	   if(mid!=null) {
		   for (Integer integer : mid) {
				a = modulesService.addRoleModules(integer,rid);
			}
	   }
	   System.out.println(mid);
	return 1;
   }
   //根据id删除节点
   @RequestMapping("/deleteModulesById")
   public int deleteModulesById(int id) {
	   int  a = modulesService.deleteModulesById(id);
	   return a;   
   }
   @RequestMapping("/addModules")
   public int addModules(Modules modules) {
	   int  a = modulesService.addModules(modules);
	   return a;   
   }
}
