package com.restapi.service;

import java.util.List;

import com.restapi.entity.Visitor;

public interface VisitorService {
	
	public abstract Visitor saveVisitor(Visitor visitor);
	
	public abstract Visitor updateVisitor(Visitor visitor);
	
	public abstract List<Visitor> showAllVisitors();
	
	public abstract void deleteVisitor(String id);
	
	public abstract Visitor getVisitorById(String id);
	
	public abstract List<Visitor> getVisitorBySex(String sex);

	
}
