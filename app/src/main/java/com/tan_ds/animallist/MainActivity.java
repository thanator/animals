package com.tan_ds.animallist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static int LOADER_ID = 123;
    private Button mButt;
    private ListView listViewl;
    AnimalAdapter mAnimalAdapter;
    private AnimalStorage mAnimalStorage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimalStorageProvider mAnimalsProvider = (AnimalStorageProvider) getApplication();
        mAnimalStorage = mAnimalsProvider .getAnimalStorage();
        setContentView(R.layout.animal_act);
        mButt = (Button) findViewById(R.id.butt_refresh);

        listViewl = (ListView) findViewById(R.id.list_view);
        mAnimalAdapter = new AnimalAdapter();
        listViewl.setAdapter(mAnimalAdapter);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalsLoaderCallBacks());
        mButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AnimalAddingActivity.newIntent(MainActivity.this));

            }
        });

    }

    private class AnimalsLoaderCallBacks implements LoaderManager.LoaderCallbacks <List<Animal>>{
         @Override
        public Loader<List<Animal>> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainActivity.this, mAnimalStorage);
        }

        @Override
        public void onLoadFinished(Loader<List<Animal>> loader, List<Animal> data) {
            mAnimalAdapter.setAnimals(data);
        }

        @Override
        public void onLoaderReset(Loader<List<Animal>> loader) {

        }



    }







}
