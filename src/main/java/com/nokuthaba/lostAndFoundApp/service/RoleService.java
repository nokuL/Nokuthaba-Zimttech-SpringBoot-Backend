package com.nokuthaba.lostAndFoundApp.service;
import com.nokuthaba.lostAndFoundApp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nokuthaba.lostAndFoundApp.dao.RoleDao;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
