package com.example.guswng.quakeport;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class QuakeListAdapter extends ArrayAdapter<QuakeClass> {

    public QuakeListAdapter(MainActivity context, ArrayList<QuakeClass> earthquakes){
        super(context,0, earthquakes);
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        /**
         * currentQuakeItem is the current item from the list
         */
        QuakeClass currentQuakeItem = getItem(position);

        /**
         * setting the Text inside of each list item
         */
        //Magnitude
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magId);
        magnitude.setText(String.valueOf(currentQuakeItem.getmMag()));

        //Location
        TextView location = (TextView) listItemView.findViewById(R.id.locId);
        location.setText(currentQuakeItem.getmLocation());

        //Date and Time
        Date dateObject = new Date(currentQuakeItem.getmTimeInMilliseconds());

        TextView dateView = listItemView.findViewById(R.id.dateId);
        TextView timeView = listItemView.findViewById(R.id.timeId);

        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);

        dateView.setText(formattedDate);
        timeView.setText(formattedTime);

        return listItemView;

    }
    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h: mm a");
        return timeFormat.format(dateObject);
    }
}
