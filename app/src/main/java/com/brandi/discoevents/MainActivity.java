package com.brandi.discoevents;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    globals g = globals.getInstance();  // Global Variables

    // Intent used for the tag search button, this is used in the onClick listener
    private Intent intent;
    //private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //does nothing because is in home
                    return true;
                case R.id.navigation_dashboard:
                    intent = new Intent(MainActivity.this, allEvents.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    intent = new Intent(MainActivity.this, Bookmarks.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView);
        calendarView.setDate(System.currentTimeMillis(), false, true);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            //@RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                // Setting the global variable for the clicked day on the calender that way pop can display the events corresponding to that date
                g.setYear(year);
                g.setDay(dayOfMonth);
                g.setMonth(month+1);

                //Toast.makeText(getApplicationContext(), "" +month, Toast.LENGTH_SHORT).show();
 //               TextView evLog = (TextView) findViewById(R.id.eventLog);
 //               evLog.setMovementMethod(new ScrollingMovementMethod());

                month++; //idk wby but because it reads first months as 0
                startActivity(new Intent(MainActivity.this, Pop.class));

 //               if (month == 9 && dayOfMonth == 16)
 //               {
 //                   evLog.setText(
 //                           ""+month + "/" + dayOfMonth + "/" + year + "\n\n" +
 //                           "Chapter One\n" +
 //                                   "A Stop on the Salt Route\n" +
 //                                   "1000 B.C.\n" +
 //                                   "As they rounded a bend in the path that ran beside the river, Lara recognized the silhouette of a fig tree atop a nearby hill. The weather was hot and the days were long. The fig tree was in full leaf, but not yet bearing fruit.\n" +
 //                                   "Soon Lara spotted other landmarks—an outcropping of limestone beside the path that had a silhouette like a man’s face, a marshy spot beside the river where the waterfowl were easily startled, a tall tree that looked like a man with his arms upraised. They were drawing near to the place where there was an island in the river. The island was a good spot to make camp. They would sleep on the island tonight.\n" +
 //                                   "Lara had been back and forth along the river path many times in her short life. Her people had not created the path—it had always been there, like the river—but their deerskin-shod feet and the wooden wheels of their handcarts kept the path well worn. Lara’s people were salt traders, and their livelihood took them on a continual journey.\n" +
 //                                   "At the mouth of the river, the little group of half a dozen intermingled families gathered salt from the great salt beds beside the sea. They groomed and sifted the salt and loaded it into handcarts. When the carts were full, most of the group would stay behind, taking shelter amid rocks and simple lean-tos, while a band of fifteen or so of the heartier members set out on the path that ran alongside the river.\n" +
 //                                   "With their precious cargo of salt, the travelers crossed the coastal lowlands and traveled toward the mountains. But Lara’s people never reached the mountaintops; they traveled only as far as the foothills. Many people lived in the forests and grassy meadows of the foothills, gathered in small villages. In return for salt, these people would give Lara’s people dried meat, animal skins, cloth spun from wool, clay pots, needles and scraping tools carved from bone, and little toys made of wood.\n" +
 //                                   "Their bartering done, Lara and her people would travel back down the river path to the sea. The cycle would begin again.\n" +
 //                                   "It had always been like this. Lara knew no other life. She traveled back and forth, up and down the river path. No single place was home. She liked the seaside, where there was always fish to eat, and the gentle lapping of the waves lulled her to sleep at night. She was less fond of the foothills, where the path grew steep, the nights could be cold, and views of great distances made her dizzy. She felt uneasy in the villages, and was often shy around strangers. The path itself was where she felt most at home. She loved the smell of the river on a hot day, and the croaking of frogs at night. Vines grew amid the lush foliage along the river, with berries that were good to eat. Even on the hottest day, sundown brought a cool breeze off the water, which sighed and sang amid the reeds and tall grasses. ");

 //               }

            }
        });
    }

    // This is the code that allows the tagSearch button to take the app to the tagSearchCheckboxes class/fragment
    public void sendMessage(View view){
        intent = new Intent(MainActivity.this, tagSearchCheckboxes.class);
        startActivity(intent);
    }
}