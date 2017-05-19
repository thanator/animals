package com.tan_ds.animallist;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.os.Bundle;

import java.util.Random;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class AnimalLoader extends AsyncTaskLoader<AnimalClass> {

    public AnimalLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public AnimalClass loadInBackground() {
        Random rand = new Random();
        return  new AnimalGenerator().provadeAnimal().get(rand.nextInt(10));

    }
}
