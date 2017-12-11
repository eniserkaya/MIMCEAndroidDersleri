package com.eniserkaya.customlistview;

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
 * Created by eniserkaya on 4.12.2017.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context, int resource,List<Contact> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_item,parent,false);
        }
        ImageView personImg = (ImageView)convertView.findViewById(R.id.photo_img);
        TextView userNameTv = (TextView)convertView.findViewById(R.id.user_name_tv);
        TextView phoneNumberTv = (TextView)convertView.findViewById(R.id.phone_tv);

        Contact contact = getItem(position);

       /* if(position % 2 == 0){

            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.erkek));

        }
        else{
            convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.kadin));

        }
*/
        userNameTv.setText(contact.getUserName());
        phoneNumberTv.setText(contact.getPhoneNumber());

        if(contact.isGender()){
            //personImg.setBackgroundResource(R.drawable.male);
            personImg.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.male));
        }
        else{
            personImg.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.female_icon));
        }

        return convertView;
    }
}
