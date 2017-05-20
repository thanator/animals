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

    private List<AnimalClass> mAnimal;


    public void setAnimals(List<AnimalClass> animals){
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
            anim.text = (TextView) view.findViewById(R.id.list_elem);
            view.setTag(anim);
        }


        AnimHolder anim = (AnimHolder) view.getTag();
        AnimalClass animalClass = mAnimal.get(position);

        anim.text.setText(animalClass.toString());

        return view;
    }




    private static class AnimHolder {
        public TextView text;

    }

}
