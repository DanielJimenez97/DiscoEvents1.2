/**
 * Created by DanielJimenez on 11/26/17.
 */
package com.brandi.discoevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.brandi.discoevents.R.id.ListBookmarkedEvents;

public class Bookmarks extends AppCompatActivity {

    globals g = globals.getInstance();  // Global Variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmarks);
        if(g.getBookmarks()==null) {
            Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();
        }

        // Make array adapter to show results
        ListView listview = (ListView) findViewById(ListBookmarkedEvents);
        ListAdapter eventAdapter = new CustomAdapter(this, g.getBookmarks());
        listview.setAdapter(eventAdapter);

        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // This is the code that allows the tagSearch button to take the app to the tagSearchCheckboxes class/fragment
                        EventData data = (EventData) parent.getItemAtPosition(position);
                        g.deleteBookmark(data);
                        Toast.makeText(getApplicationContext(), "Removed Event to Bookmark", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}