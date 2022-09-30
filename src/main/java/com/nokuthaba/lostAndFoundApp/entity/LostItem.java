package com.nokuthaba.lostAndFoundApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter

public class LostItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String userName;
    private Date dateOfLoss;
    private String itemDescription;
    private String province;

    @Override
    public String toString() {
        return "LostItem{" +
                "id=" + id +
                ", dateOfLoss=" + dateOfLoss +
                ", itemDescription='" + itemDescription + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
