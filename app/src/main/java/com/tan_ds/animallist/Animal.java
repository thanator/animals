package com.tan_ds.animallist;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class Animal {

    private String mName;
    private String mSpecies;
    private int mAge;

    public Animal(String name, String mSpecies, int mAge) {
        this.mName = name;
        this.mSpecies = mSpecies;
        this.mAge = mAge;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }

    public String getmSpecies() {
        return mSpecies;
    }

    public void setmSpecies(String mSpecies) {
        this.mSpecies = mSpecies;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public int getmAge() {
        return mAge;
    }

    @Override
    public int hashCode() {
        return (mName+mSpecies+mAge).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (mName+mSpecies+mAge).equals(obj.toString());
    }



    @Override
    public String toString() {
        return mName + mSpecies + mAge;
    }
}
