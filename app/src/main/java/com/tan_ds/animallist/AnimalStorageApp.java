package com.tan_ds.animallist;

import android.app.Application;

/**
 * Created by Tan-DS on 5/20/2017.
 */

public class AnimalStorageApp extends Application implements AnimalStorageProvider {

    private AnimalStorage mAnimalStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        mAnimalStorage = new AnimalStorage();
    }

    @Override
    public AnimalStorage getAnimalStorage() {
        return mAnimalStorage;
    }
}
