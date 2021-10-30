package com.my.discriminant.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DetailsDao {
        @Query("SELECT * FROM detailsmodel")
        List<DetailsModel> getAll();

        @Query("SELECT * FROM detailsmodel WHERE id = :id")
        DetailsModel getById(long id);

        @Insert
        void insert(DetailsModel employee);

        @Update
        void update(DetailsModel employee);

        @Delete
        void delete(DetailsModel employee);

    }

