package com.loyola.talktracer.model;

import java.util.ArrayList;

/**
 * Tracks the duration information for each speaker.
 * Implements Comparable to facilitate sorting.
 */
public class Speaker {
    private static final String TAG = "Speaker";
    private int color;
    private ArrayList<Long> startTimes = new ArrayList<Long>();  // features since start of meeting
    private ArrayList<Long> durations = new ArrayList<Long>();  // duration in features
    private String mLabel = null;
    private String mName = null;
    private char mGender = '\0';
    public Speaker(String label, char gender) {
        mLabel = label;
        mName = label;  // default name is the Label
        mGender = gender;
    }

    public ArrayList<Long> getStartTimes() {
        return startTimes;
    }

    public ArrayList<Long> getDurations() {
        return durations;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    /**
     * Add a speaking turn to this speaker
     *
     * @param start    - time in ms
     * @param duration - duration in ms
     */
    public void addTurn(long start, long duration) {
        startTimes.add(start);
        durations.add(duration);
    }

    public char getGender() {
        return mGender;
    }

    private String getLabel() {
        return mLabel;
    }

    public long getTotalDuration() {
        long totalDurationInMilliseconds = 0;
        for (long duration : durations) {
            totalDurationInMilliseconds += duration;
        }
        return totalDurationInMilliseconds;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
