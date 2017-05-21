package com.tan_ds.animallist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tan-DS on 5/20/2017.
 */

public class AnimalAddingActivity extends AppCompatActivity {

    private AnimalStorage mAnimalStorage;

    private EditText mNameNew, mAgeNew, mSpicieNew;
    private Button button;
    private EditText[] mEditTexts;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, AnimalAddingActivity.class);
        return intent;
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnimalStorageProvider provider = (AnimalStorageProvider) getApplication();
        mAnimalStorage = provider.getAnimalStorage();
        setContentView(R.layout.add_animal);
        mNameNew = (EditText) findViewById(R.id.new_name);
        mAgeNew = (EditText) findViewById(R.id.new_age);
        mSpicieNew = (EditText) findViewById(R.id.new_spicie);
        button = (Button) findViewById(R.id.butt_add_new_animal);
        mEditTexts = new EditText[]{mSpicieNew, mAgeNew, mNameNew};
        for (EditText editText: mEditTexts){
            editText.addTextChangedListener(new TextWatcherMy());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAnimal();
            }
        });
    }

    private void addAnimal() {
        String Spic = mSpicieNew.getText().toString();
        String Name = mNameNew.getText().toString();
        int Age = Integer.valueOf(mAgeNew.getText().toString());
        mAnimalStorage.addAnimal(new Animal(Name, Spic, Age));

        finish();
    }


    private class TextWatcherMy implements TextWatcher{
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean buttonEnabled = true;
            for (EditText editText : mEditTexts) {
                if (TextUtils.isEmpty(editText.getText())) {
                    buttonEnabled = false;
                    break;
                }
            }
            button.setEnabled(buttonEnabled);

        }
    }

}
