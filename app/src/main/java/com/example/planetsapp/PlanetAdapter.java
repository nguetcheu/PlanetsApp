package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlanetAdapter extends BaseAdapter {
    private Context context;
    private List<Planet> planetList;

    public PlanetAdapter(Context context, List<Planet> planetList) {
        this.context = context;
        this.planetList = planetList;
    }

    @Override
    public int getCount() {
        return planetList.size();
    }

    @Override
    public Object getItem(int position) {
        return planetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Planet planet = planetList.get(position);

        ImageView planetImage = convertView.findViewById(R.id.imageView);
        TextView planetName = convertView.findViewById(R.id.textView);
        TextView planetLines = convertView.findViewById(R.id.textView2);

        planetImage.setImageResource(planet.getImageResId());
        planetName.setText(planet.getName());
        planetLines.setText(planet.getNumberOfMoons() + " moons");

        return convertView;
    }
}
