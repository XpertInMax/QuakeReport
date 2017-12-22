package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.graphics.drawable.GradientDrawable;
/**
 * Created by Amani on 15-12-2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private List<Earthquake> earthquake = new ArrayList<Earthquake>();

    public EarthquakeAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listEarthquakeView = convertView;

        if(listEarthquakeView == null){
            listEarthquakeView = LayoutInflater.from(getContext()).inflate(R.layout.list_earthquake, parent, false);
        }

        // Get the {@link earthquake} object located at this position in the list
        Earthquake earthquake = getItem(position);
        Log.v("EarthQuakeAdapter", "position " + position);
        Log.v("EarthQuakeAdapter", "earthquake  " + earthquake);

        String magnitude = formatMagnitude(earthquake.getmMagnitude());

        TextView magnitudeTextView = (TextView)listEarthquakeView.findViewById(R.id.magnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);



        magnitudeTextView.setText(magnitude);

        String location = earthquake.getmLocation();
        String primaryLocation = null;
        String offsetLocation = null;

        if(location.contains("of")){
            String [] places = location.split("of");
           // primaryLocation =   places[0];
          //  offsetLocation =   places[1];

            primaryLocation = location.substring(0, location.indexOf("of")+2);
            offsetLocation = location.substring(location.indexOf("of")+3, location.length());
        }
        else {
            primaryLocation = "Near the";
            offsetLocation = location;
        }


        TextView locationTextView = (TextView)listEarthquakeView.findViewById(R.id.primary_location);
        locationTextView.setText(primaryLocation);

        TextView offsetLocTextView = (TextView)listEarthquakeView.findViewById(R.id.location_offset);
        offsetLocTextView.setText(offsetLocation);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(earthquake.getmTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateTextView = (TextView)listEarthquakeView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateTextView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listEarthquakeView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        return listEarthquakeView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
