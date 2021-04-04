package com.example.indoornavigationwithaugmentedreality.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.indoornavigationwithaugmentedreality.model.Destination;

import java.util.List;

@Dao
public interface DestinationDao {
    // CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Destination destination);

    @Query("DELETE FROM destination_table")
    void deleteAll();

    @Query("SELECT * FROM DESTINATION_TABLE")
    LiveData<List<Destination>> getAllDestinations();
}
