package com.example.stjepanlukac.prvapomoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Stjepan Lukac on 22.4.2016..
 */
public class CustomAdapterOzljede extends ArrayAdapter<String> {

    private final int[] imgs;

    public CustomAdapterOzljede(Context context, String[] popis_ozljeda, int[] imgs) {
        super(context, R.layout.custom_row_ozljede, popis_ozljeda);
        this.imgs = imgs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater ozljedeInflater = LayoutInflater.from(getContext());
        View customOzljedeView = ozljedeInflater.inflate(R.layout.custom_row_ozljede, parent, false);

        //reference za niz, sliku i tekst
        String singleOzljedeItem = getItem(position);
        TextView ozljedeText = (TextView) customOzljedeView.findViewById(R.id.ozljedeText);
        ImageView ozljedeSlika = (ImageView) customOzljedeView.findViewById(R.id.ozljedeSlika);

        ozljedeText.setText(singleOzljedeItem);
        ozljedeSlika.setImageResource(imgs[position]);

        return customOzljedeView;
    }
}
