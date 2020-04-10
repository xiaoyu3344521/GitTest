package com.ysd.entity;

import java.io.Serializable;

public class Modules implements Serializable{
private Integer id;
private String name;
private Integer parentId;
private String path;
private int weight;
private String ops;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getParentId() {
	return parentId;
}
public void setParentId(Integer parentId) {
	this.parentId = parentId;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public String getOps() {
	return ops;
}
public void setOps(String ops) {
	this.ops = ops;
}



}
