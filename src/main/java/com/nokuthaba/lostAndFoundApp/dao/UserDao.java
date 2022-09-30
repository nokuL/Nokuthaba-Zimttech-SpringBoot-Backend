package com.nokuthaba.lostAndFoundApp.dao;

import com.nokuthaba.lostAndFoundApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {
}
