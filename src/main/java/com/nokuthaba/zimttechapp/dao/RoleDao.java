package com.nokuthaba.zimttechapp.dao;

import com.nokuthaba.zimttechapp.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
