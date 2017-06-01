package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.jenny.lifesavingaidui.R.id.friendEmergency_imageView;

/**
 * Created by Jenny on 24/03/2016.
 */
public class showFriendEmergency extends Activity {

    public static final String EXTRA_POSITION="com.example.jenny.lifesavingaidui.emergency_position";
    private static final String TAG="ShowFriendEmergency";

    TextView name,title;
    Button back,next,previous;
    int position;
    ListView instructions;
    ArrayList<emergency> emergencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_emergency);

        Log.d(TAG, "ContentView has set up");

        position= getIntent().getIntExtra(EXTRA_POSITION, -1);
        emergencies= UserProfile.get(this).getFriendProfile().getEmergencies();
        Log.d(TAG, "position passed in and has value "+position);

        back= (Button) findViewById(R.id.friendEmergency_butonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        previous = (Button) findViewById(R.id.friendEmergency_buttonPrevious);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position>0) position--;
                displayContent(position);
            }
        });

        next = (Button) findViewById(R.id.friendEmergency_buttonNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < emergencies.size()-1) position++;
                displayContent(position);
            }
        });

        ImageView parent = (ImageView) findViewById(R.id.friendEmergency_imageView);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NavUtils.getParentActivityName(showFriendEmergency.this)!=null)
                    NavUtils.navigateUpFromSameTask(showFriendEmergency.this);
            }
        });

        name = (TextView) findViewById(R.id.friendEmergency_name);
        name.setText(UserProfile.get(this).getFriendProfile().getName());//come back to check on this one

        title= (TextView) findViewById(R.id.friendEmergency_em);
        instructions= (ListView) findViewById(R.id.emergency_listView);

        Log.d(TAG,"Buttons,TextView, ListView has been referenced");

        displayContent(position);
    }

    private void displayContent(int position){
        Log.d(TAG,"displayContent is called");

        emergency em= emergencies.get(position);
        title.setText(em.getEmergency_title());

        TipAdapter2 adapter = new TipAdapter2(this,em.getEmergency_instrs());
        instructions.setAdapter(adapter);
    }
}
