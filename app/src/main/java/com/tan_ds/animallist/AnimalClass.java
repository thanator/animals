package com.tan_ds.animallist;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class AnimalClass {

    public AnimalClass(){
    }

    private String name;
    private String mSpecies;
    private int mAge;

    public AnimalClass(String name, String mSpecies, int mAge) {
        this.name = name;
        this.mSpecies = mSpecies;
        this.mAge = mAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmSpecies() {
        return mSpecies;
    }

    public void setmSpecies(String mSpecies) {
        this.mSpecies = mSpecies;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    @Override
    public String toString() {
        return "\tИмя: " + name + "\n\tВид: " + mSpecies + "\n\tВозраст: " + mAge;
    }
}
