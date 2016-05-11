package com.mimos.amugae;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by jkm50 on 2016-05-05.
 */
public class DrawerAdapter extends BaseAdapter {
    Context context = null;
    String[] drawer = {"홈","나","세팅"};
    @Override
    public int getCount() {
        return drawer.length;
    }

    @Override
    public Object getItem(int position) {
        return drawer[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_item,parent,false);

        }
        ImageView drawerImg = (ImageView) convertView.findViewById(R.id.drawerImage);
        TextView drawerTxt = (TextView) convertView.findViewById(R.id.drawerText);
        drawerTxt.setText(drawer[position]);
        switch (position){
            case 0: drawerImg.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_home_white_48dp));
                break;
            case 1: drawerImg.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_account_box_white_48dp));
                break;
            case 2: drawerImg.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_settings_white_48dp));
                break;
        }
        return convertView;
    }
}
