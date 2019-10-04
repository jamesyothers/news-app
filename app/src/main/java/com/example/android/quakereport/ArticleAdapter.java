/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link ArticleAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link Article} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class ArticleAdapter extends ArrayAdapter<Article> {

    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context of the app
     * @param articles is the list of articles, which is the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Article currentArticle = getItem(position);

        // Find the TextView with view ID article section
        TextView articleSectionView = (TextView) listItemView.findViewById(R.id.articleSection);
        // Format the magnitude to show 1 decimal place
//        String sectionName = formatMagnitude(currentArticle.getSectionName());
        String sectionName = currentArticle.getSectionName();
        // Display the magnitude of the current earthquake in that TextView
        articleSectionView.setText(sectionName);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
//        GradientDrawable magnitudeCircle = (GradientDrawable) articleSectionView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
//        int magnitudeColor = getMagnitudeColor(currentArticle.getMagnitude());
        // Set the color on the magnitude circle
//        magnitudeCircle.setColor(magnitudeColor);

        // Get the original location string from the Earthquake object,
        // which can be in the format of "5km N of Cairo, Egypt" or "Pacific-Antarctic Ridge".
        String originalLocation = currentArticle.getLocation();

        // If the original location string (i.e. "5km N of Cairo, Egypt") contains
        // a primary location (Cairo, Egypt) and a location offset (5km N of that city)
        // then store the primary location separately from the location offset in 2 Strings,
        // so they can be displayed in 2 TextViews.
        String primaryLocation;
//        String locationOffset;

        // Check whether the originalLocation string contains the " of " text
//        if (originalLocation.contains(LOCATION_SEPARATOR)) {
//            // Split the string into different parts (as an array of Strings)
//            // based on the " of " text. We expect an array of 2 Strings, where
//            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
//            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
//            // Location offset should be "5km N " + " of " --> "5km N of"
//            locationOffset = parts[0] + LOCATION_SEPARATOR;
//            // Primary location should be "Cairo, Egypt"
//            primaryLocation = parts[1];
//        } else {
//            // Otherwise, there is no " of " text in the originalLocation string.
//            // Hence, set the default location offset to say "Near the".
////            locationOffset = getContext().getString(R.string.near_the);
//            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            primaryLocation = originalLocation;
//        }

        // Find the TextView with view ID location
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Display the location of the current earthquake in that TextView
        primaryLocationView.setText(primaryLocation);

        // Find the TextView with view ID location offset
//        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Display the location offset of the current earthquake in that TextView
//        locationOffsetView.setText(locationOffset);

        // Create a new Date object from the time in milliseconds of the earthquake
//        Date dateObject = new Date(currentArticle.getTimeInMilliseconds());
        String dateTimePublication = currentArticle.getDateTimePublication();

        String datePublication = removeTime(dateTimePublication);

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
//        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(datePublication);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
//        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
//        timeView.setText(dateTimePublication);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

//    /**
//     * Return the color for the magnitude circle based on the intensity of the earthquake.
//     *
//     * @param magnitude of the earthquake
//     */
//    private int getMagnitudeColor(double magnitude) {
//        int magnitudeColorResourceId;
//        int magnitudeFloor = (int) Math.floor(magnitude);
//        switch (magnitudeFloor) {
//            case 0:
//            case 1:
//                magnitudeColorResourceId = R.color.magnitude1;
//                break;
//            case 2:
//                magnitudeColorResourceId = R.color.magnitude2;
//                break;
//            case 3:
//                magnitudeColorResourceId = R.color.magnitude3;
//                break;
//            case 4:
//                magnitudeColorResourceId = R.color.magnitude4;
//                break;
//            case 5:
//                magnitudeColorResourceId = R.color.magnitude5;
//                break;
//            case 6:
//                magnitudeColorResourceId = R.color.magnitude6;
//                break;
//            case 7:
//                magnitudeColorResourceId = R.color.magnitude7;
//                break;
//            case 8:
//                magnitudeColorResourceId = R.color.magnitude8;
//                break;
//            case 9:
//                magnitudeColorResourceId = R.color.magnitude9;
//                break;
//            default:
//                magnitudeColorResourceId = R.color.magnitude10plus;
//                break;
//        }

//        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
//    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String removeTime(String dateTimePublication) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
//        return dateFormat.format(dateObject);
        String[] timeArray = dateTimePublication.split("T", 2);
        return timeArray[0];
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}