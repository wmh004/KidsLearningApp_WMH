package com.example.kidslearningapp.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kidslearningapp.ActivityClass;

@Dao
public interface DAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ActivityClass activity);

    @Query("UPDATE ActivityClass SET math = :math WHERE activityID = 1")
    void updateMath(Integer math);

    @Query("UPDATE ActivityClass SET english = :english WHERE activityID = 1")
    void updateEnglish(Integer english);

    @Query("SELECT math FROM ActivityClass WHERE activityID = 1")
    LiveData<Integer> getMath();

    @Query("SELECT english FROM ActivityClass WHERE activityID = 1")
    LiveData<Integer> getEnglish();

    @Query("SELECT (math + english) FROM ActivityClass WHERE activityID = 1")
    LiveData<Integer> getTotal();
}
