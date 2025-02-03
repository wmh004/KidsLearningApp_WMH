package com.example.kidslearningapp.DB;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.example.kidslearningapp.ActivityClass;

public class Repository {
    private DAO dao;
    private LiveData<Integer> math, english, Total;

    Repository(Application application) {
        RoomDatabases db = RoomDatabases.getDatabase(application);
        dao = db.dao();

        math = dao.getMath();
        english = dao.getEnglish();
        Total = dao.getTotal();
    }

    LiveData<Integer> getMath() {
        return math;
    }

    LiveData<Integer> getEnglish() {
        return english;
    }

    LiveData<Integer> getTotal() {
        return Total;
    }

    void insert(ActivityClass activity) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            dao.insert(activity);
        });
    }

    void updateMath(Integer math) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            dao.updateMath(math);
        });
    }

    void updateEnglish(Integer english) {
        RoomDatabases.databaseWriteExecutor.execute(() -> {
            dao.updateEnglish(english);
        });
    }
}