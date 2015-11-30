package com.ocit.trainingapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ocit.trainingapi.R;
import com.ocit.trainingapi.model.DisplayStatus;

import java.util.ArrayList;

/**
 * Created by ar-android on 30/11/2015.
 */
public class AdapterDisplaystatus extends BaseAdapter{

    private LayoutInflater inflater;
    private ArrayList<DisplayStatus> data;
    private Context context;

    public AdapterDisplaystatus(Context context, ArrayList<DisplayStatus> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_displaystatus, null);

        TextView tvNameCreator, tvContent, tvCreated, tvUpdated;
        ImageView imgImage;

        tvNameCreator = (TextView) convertView.findViewById(R.id.tvNameCreator);
        tvContent = (TextView) convertView.findViewById(R.id.tvContent);
        tvCreated = (TextView) convertView.findViewById(R.id.tvCreated);
        tvUpdated = (TextView) convertView.findViewById(R.id.tvUpdated);
        imgImage = (ImageView) convertView.findViewById(R.id.imgImage);

        tvNameCreator.setText(data.get(position).getName_creator());
        tvContent.setText(data.get(position).getContent());
        tvCreated.setText(data.get(position).getCreated());
        tvUpdated.setText(data.get(position).getUpdated());

        String base_image = "http://raihanshop.com/";
        Glide.with(context)
                .load(base_image + data.get(position).getImage())
                .into(imgImage);
        return convertView;
    }
}