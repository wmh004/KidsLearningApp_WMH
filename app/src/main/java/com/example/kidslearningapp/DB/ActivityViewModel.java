package com.example.kidslearningapp.DB;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kidslearningapp.ActivityClass;

public class ActivityViewModel extends AndroidViewModel {

    private Repository repo;
    private LiveData<Integer> math, english, Total;
    boolean valid = true;

    public ActivityViewModel(Application application) {
        super(application);
        repo = new Repository(application);

        // Initialise the database since later we only gonna update the values (math & english)
        if(valid) {
            ActivityClass activity = new ActivityClass(0, 0);
            insert(activity);
            valid = false;
        }

        math = repo.getMath();
        english = repo.getEnglish();
        Total = repo.getTotal();
    }

    public LiveData<Integer> getMath() {
        return math;
    }

    public LiveData<Integer> getEnglish() {
        return english;
    }

    public LiveData<Integer> getTotal() {
        return Total;
    }

    public void insert(ActivityClass activity) {
        repo.insert(activity);
    }

    public void updateMath(Integer math) {
        repo.updateMath(math);
    }

    public void updateEnglish(Integer english) {
        repo.updateEnglish(english);
    }
}
