package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jenny on 24/03/2016.
 */
public class FriendProfile extends Activity {

    ListView emergencyList;
    Profile friend;
    Button track,profile,back,help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_profile);

        friend = UserProfile.get(this).getFriendProfile();
        TextView name = (TextView) findViewById(R.id.friend_profile);
        name.setText(friend.getName());

        track = (Button) findViewById(R.id.view_friends_track);
        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something to track friends
                UserProfile.get(FriendProfile.this).TackingButtonPress();
            }
        });

        profile = (Button) findViewById(R.id.view_friends_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FriendProfile.this,viewFriendProfile.class);
                startActivity(i);
            }
        });

         back = (Button) findViewById(R.id.butonBack_friend_profile);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });

        help = (Button) findViewById(R.id.friend_profile_getHelp);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = friend.getPhone();

                    if(phone.equals("")){
                    Toast.makeText(FriendProfile.this,"Friend's phone number is empty",
                            Toast.LENGTH_SHORT).show();
                }else{

                    //add code here to send current location to server

                    //-----------------------------------------

                    try {
                        String user_name = UserProfile.get(FriendProfile.this)
                                .getProfile().getName();
                        String message= "SOS Help : "+user_name+ " has send you a SOS Message.";
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phone, null, message, null, null);
                        Toast.makeText(getApplicationContext(),
                                "SOS_Message sent.", Toast.LENGTH_SHORT).show();
                    }

                    catch (Exception e) {
                        Toast.makeText(getApplicationContext(),
                                "SOS Message sending failed, please try again.",
                                Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
            }
        });

        emergencyList= (ListView) findViewById(R.id.friend_emergency_list);
        ArrayList<emergency> emergencies = friend.getEmergencies();
        emergencyAdapter adapter = new emergencyAdapter(this,emergencies);
        emergencyList.setAdapter(adapter);
        emergencyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(FriendProfile.this, showFriendEmergency.class);
                i.putExtra(showFriendEmergency.EXTRA_POSITION, position);
                startActivity(i);
            }
        });

        ImageView parent = (ImageView) findViewById(R.id.friendProfile_imageView);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NavUtils.getParentActivityName(FriendProfile.this) != null)
                    NavUtils.navigateUpFromSameTask(FriendProfile.this);
            }
        });
    }
}
