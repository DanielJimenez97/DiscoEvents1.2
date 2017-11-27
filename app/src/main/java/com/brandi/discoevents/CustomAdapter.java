package com.brandi.discoevents;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Owner on 11/24/2017.
 */

class CustomAdapter extends ArrayAdapter<EventData>{

    public CustomAdapter(Context context, ArrayList<EventData> event) {
        super(context, R.layout.custom_row ,event);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater eventInflater = LayoutInflater.from(getContext());

        // Equal to one custom row
        View customView = convertView;
        if(customView == null){
            customView = eventInflater.inflate(R.layout.custom_row, parent, false);
        }

        // Get a reference to everything
        String OrgName = getItem(position).getOrgName();
        TextView o_Name_Text = (TextView) customView.findViewById(R.id.textOrgName);
        o_Name_Text.setText("Organization: " + OrgName);

        String EventName= getItem(position).getEventName();
        TextView e_Name_Text = (TextView) customView.findViewById(R.id.textEventName);
        e_Name_Text.setText("Event: " + EventName);

        String EventDesc= getItem(position).getEventDesc();
        TextView e_Desc_Text = (TextView) customView.findViewById(R.id.textEventDesc);
        e_Desc_Text.setText("Description: " + EventDesc);

        String EventDate= getItem(position).getEventDate();
        TextView e_Date_Text = (TextView) customView.findViewById(R.id.textEventDate);
        e_Date_Text.setText("Date: " + EventDate);

        String EventLocation= getItem(position).getEventLocation();
        TextView e_Loca_Text = (TextView) customView.findViewById(R.id.textEventLocation);
        e_Loca_Text.setText("Location: " + EventLocation);

        return customView;
    }
}