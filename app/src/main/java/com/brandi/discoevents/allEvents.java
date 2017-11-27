/**
 * Created by DanielJimenez on 11/26/17.
 */

package com.brandi.discoevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.brandi.discoevents.R.id.ListAllEvents;

public class allEvents extends AppCompatActivity {

    globals g = globals.getInstance();
    private static final String TAG = "TagEventList Data";

    // This will hold our collection of com.brandi.disco events.EventData Objects that will be printed to the screen
    final ArrayList<EventData> events = new ArrayList<EventData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_events);

        // Get a reference to our Events
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();

        // Attach a listener to read the data at our posts reference
        ref.child("Events").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // get all of the children at this level.
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                // Iterate over the collection called children
                // Each time you get to a child put it in the collection variable
                for (DataSnapshot child : children) {
                    // Returned as a java object
                    EventData value = child.getValue(EventData.class);
                    events.add(value);
                }
                showListNow();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Display a toast Error message
                Log.d(TAG, " Error ");
                Toast.makeText(allEvents.this, "The read failed: " + databaseError.getCode(), Toast.LENGTH_LONG).show();
            }
        });

        // Make array adapter to show results
        ListView listview = (ListView) findViewById(ListAllEvents);
        ListAdapter eventAdapter = new CustomAdapter(this, events);
        listview.setAdapter(eventAdapter);
    }

    private void showListNow() {
        // Make array adapter to show results
        ListView listview = (ListView) findViewById(ListAllEvents);
        ListAdapter eventAdapter = new CustomAdapter(this, events);
        listview.setAdapter(eventAdapter);
    }
}