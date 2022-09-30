package com.nokuthaba.lostAndFoundApp.service;

import com.nokuthaba.lostAndFoundApp.dao.LostItemsDao;
import com.nokuthaba.lostAndFoundApp.entity.LostItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostItemsService {

    @Autowired
    private LostItemsDao lostItemsDao;

    public LostItem recordLostItem(LostItem lostItem){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>         "+ lostItem.toString());
        return lostItemsDao.save(lostItem);
    }

    public List<LostItem> findAllLostItems(){
        return  lostItemsDao.findAll();
    }

    public LostItem editLostItem(LostItem lostItem){
        return lostItemsDao.save(lostItem);
    }

    public void deleteById(Long id){
        lostItemsDao.deleteById(id);
    }

    public LostItem findById(long id){
        return   lostItemsDao.findById(id).orElse(null);
    }


}
