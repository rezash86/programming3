package com.jac.springboot.demosecurity.dao;

import com.jac.springboot.demosecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
