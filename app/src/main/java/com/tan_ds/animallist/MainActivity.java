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
    private final static String TAG = "RatesActivity";
    private Button mButt;
    private TextView mTextView;
    private ListView listViewl;
    AnimalAdapter animalAdapter;
    private AnimalStorage mAnimalLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimalStorageProvider AnimalsProvider = (AnimalStorageProvider) getApplication();
        mAnimalLoader = AnimalsProvider.getAnimalStorage();
        setContentView(R.layout.animal_act);
        mButt = (Button) findViewById(R.id.butt_refresh);

        mTextView = (TextView) findViewById(R.id.list_elem);

        listViewl = (ListView) findViewById(R.id.list_view);
        animalAdapter = new AnimalAdapter();
        listViewl.setAdapter(animalAdapter);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalsLoaderCallBacks());
        //mTextView.setText();
        mButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AnimalAdding.newIntent(MainActivity.this));

            }
        });

    }

    private class AnimalsLoaderCallBacks implements LoaderManager.LoaderCallbacks <List<AnimalClass>>{

        @Override
        public Loader<List<AnimalClass>> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainActivity.this, mAnimalLoader);
        }

        @Override
        public void onLoadFinished(Loader<List<AnimalClass>> loader, List<AnimalClass> data) {
            animalAdapter.setAnimals(data);
           // mTextView.setText(data.toString());
        }

        @Override
        public void onLoaderReset(Loader<List<AnimalClass>> loader) {

        }



    }







}
