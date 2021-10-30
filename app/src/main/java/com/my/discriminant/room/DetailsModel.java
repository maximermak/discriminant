package com.my.discriminant.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DetailsModel {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String a;
    public String b;
    public String c;


    public String getValueForList()
    {
        return a + " " + b + " " + c;
    }
}
