package com.tan_ds.animallist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int LOADER_ID = 123;
    private final static String TAG = "RatesActivity";
    private Button mButt;
    private TextView mTextView;
    private int number;
    private AnimalClass animals;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_act);
        mButt = (Button) findViewById(R.id.butt_refresh);
        mButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportLoaderManager().getLoader(LOADER_ID).forceLoad();

            }
        });
        mTextView = (TextView) findViewById(R.id.anim_text);
        getSupportLoaderManager().initLoader(LOADER_ID, null, new AnimalsLoaderCallBacks());
        //mTextView.setText();

    }

    private class AnimalsLoaderCallBacks implements LoaderManager.LoaderCallbacks <AnimalClass>{

        @Override
        public Loader<AnimalClass> onCreateLoader(int id, Bundle args) {
            return new AnimalLoader(MainActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<AnimalClass> loader, AnimalClass data) {
            mTextView.setText(data.toString());
        }

        @Override
        public void onLoaderReset(Loader<AnimalClass> loader) {

        }
    }







}
