package com.example.diseasetracker;

import android.app.Activity;
import android.content.Context;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomAdaptor extends ArrayAdapter<UserInfo> {
    private Activity context;
    private List<UserInfo> Info;
    TextView s1,s2,s3,s4;
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout, null,true);
        UserInfo info = Info.get(position);
        s1=view.findViewById(R.id.t1);
        s2=view.findViewById(R.id.t2);
        s3=view.findViewById(R.id.t3);
        s4=view.findViewById(R.id.t4);

        s1.setText("Name :"+info.getName());
        s2.setText("Email :"+info.getEmail());
        s3.setText("Age :"+info.getAge());
        s4.setText("Gender :"+info.getGender());
        return  view;

    }

    public CustomAdaptor(Context context, List<UserInfo> Info ) {
        super(context, R.layout.sample_layout,Info);
        this.context= (Activity) context;
        this.Info=Info;

    }
}
