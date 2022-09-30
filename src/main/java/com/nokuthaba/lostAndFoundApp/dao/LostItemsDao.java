package com.nokuthaba.lostAndFoundApp.dao;

import com.nokuthaba.lostAndFoundApp.entity.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostItemsDao extends JpaRepository<LostItem, Long> {

}
