package com.eniserkaya.ulkelerhomework;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eniserkaya on 11.12.2017.
 */

public class Adapter extends ArrayAdapter<Ulke> {

    public Adapter(Context context, int resource, List<Ulke> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.item_layout,parent,false);
        }

        ImageView bayrakImg = (ImageView)convertView.findViewById(R.id.bayrak_img);
        TextView ulkeNameTv = (TextView)convertView.findViewById(R.id.ulke_adi_tv);
        TextView kurulusYiliTv = (TextView)convertView.findViewById(R.id.kurulus_yili_tv);

        Ulke ulke = getItem(position);

        ulkeNameTv.setText(ulke.getUlkeAdi());
        kurulusYiliTv.setText(ulke.getKurulusYili() +" ");

       // bayrakImg.setImageResource(ulke.getUlkeBayragi());
        bayrakImg.setImageDrawable(ContextCompat.getDrawable(getContext(), ulke.getUlkeBayragi()));

        return convertView;
    }
}
