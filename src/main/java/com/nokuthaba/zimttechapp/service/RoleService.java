package com.nokuthaba.zimttechapp.service;
import com.nokuthaba.zimttechapp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nokuthaba.zimttechapp.dao.RoleDao;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
