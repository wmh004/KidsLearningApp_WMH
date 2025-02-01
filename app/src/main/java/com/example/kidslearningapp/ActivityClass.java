package com.example.kidslearningapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ActivityClass {

    @PrimaryKey(autoGenerate = true)
    public int activityID;

    @NonNull
    private Integer math;

    @NonNull
    private Integer english;

    public ActivityClass(@NonNull Integer math, @NonNull Integer english) {
        this.math = math;
        this.english = english;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getMath() {
        return math;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getEnglish() {
        return english;
    }
}
