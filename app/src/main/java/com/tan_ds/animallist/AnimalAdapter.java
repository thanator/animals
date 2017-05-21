package com.tan_ds.animallist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tan-DS on 5/20/2017.
 */

public class AnimalAdapter extends BaseAdapter {

    private List<Animal> mAnimal;


    public void setAnimals(List<Animal> animals){
        mAnimal.clear();
        mAnimal.addAll(animals);
        notifyDataSetChanged();

    }

    public AnimalAdapter(){
        this.mAnimal = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mAnimal.size();
    }

    @Override
    public Object getItem(int position) {
        return mAnimal.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =  convertView;

        if (view == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate( R.layout.list_elem, parent, false);
            AnimHolder anim = new AnimHolder();
            anim.textAge = (TextView) view.findViewById(R.id.age_id);
            anim.textName = (TextView) view.findViewById(R.id.name_id);
            anim.textType = (TextView) view.findViewById(R.id.type_id);
            view.setTag(anim);
        }


        AnimHolder anim = (AnimHolder) view.getTag();
        Animal animalClass = mAnimal.get(position);
        anim.textAge.setText(""+animalClass.getmAge());
        anim.textName.setText(animalClass.getmName());
        anim.textType.setText(animalClass.getmSpecies());


        return view;
    }




    private static class AnimHolder {
        public TextView textName, textType, textAge;

    }

}
