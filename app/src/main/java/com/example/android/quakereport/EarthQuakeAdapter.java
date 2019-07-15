package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param earthQuakes A List of EarthQuake objects to display in a list
     */
    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthQuakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link EarthQuake} object located at this position in the list
        EarthQuake currentEarthQuake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the current Earthquake object and
        // set this text on the magnitude TextView
        magnitudeTextView.setText(currentEarthQuake.getMagnitude().toString());

        // Find the TextView in the list_item.xml layout with the ID location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        // Get the location from the current Earthquake object and
        // set this text on the location TextView
        locationTextView.setText(currentEarthQuake.getLocation());

        // Find the TextView in the list_item.xml layout with the ID date
        TextView iconView = (TextView) listItemView.findViewById(R.id.date);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setText(currentEarthQuake.getDate().toString());

        // Return the whole list item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
