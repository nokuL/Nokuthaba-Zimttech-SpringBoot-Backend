package com.nokuthaba.lostAndFoundApp.controller;

import com.nokuthaba.lostAndFoundApp.entity.LostItem;
import com.nokuthaba.lostAndFoundApp.service.LostItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LostItemsController {

    @Autowired
    private LostItemsService lostItemsService;

    @PostMapping("/recordLostItem")
    public LostItem recordLostItem(@RequestBody LostItem lostItem){
       return lostItemsService.recordLostItem(lostItem);
    }

    @GetMapping("/lostItemsList")
    public List<LostItem> getLOstItems(){
        return lostItemsService.findAllLostItems();

    }


    @PutMapping("/edit-lost-item")
    public LostItem editLostItem(@RequestBody LostItem lostItem){
        return  lostItemsService.editLostItem(lostItem);
    }

    @DeleteMapping("/delete/lost-item/{id}")
    public void deleteCourse(@PathVariable Long id){
        lostItemsService.deleteById(id);
    }
}
