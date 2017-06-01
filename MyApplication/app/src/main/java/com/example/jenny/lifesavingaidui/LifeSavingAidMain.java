package com.example.jenny.lifesavingaidui;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LifeSavingAidMain extends AppCompatActivity {

    ImageButton me,friends,tip_bank;
    Button emergencyButton;
    TextView log_out,change_password,how_to_use;
    Profile user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_saving_aid_main);

        user = UserProfile.get(this).getProfile();

        //underline the "Log Out" text in .xml file
        log_out= (TextView) findViewById(R.id.Log_Out);
        log_out.setPaintFlags(log_out.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //underline the "Change Password" text in .xml file
        change_password = (TextView) findViewById(R.id.Change_password);
        change_password.setPaintFlags(change_password.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        how_to_use= (TextView) findViewById(R.id.instruction);
        how_to_use.setPaintFlags(how_to_use.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        how_to_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LifeSavingAidMain.this,HowToUse.class);
                startActivity(i);
            }
        });

        //reference all the buttons
        me = (ImageButton) findViewById(R.id.imgbt_me);
        friends = (ImageButton) findViewById(R.id.imgbt_friends);
        tip_bank = (ImageButton) findViewById(R.id.imgbt_tips);

       tip_bank.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent i= new Intent(LifeSavingAidMain.this,SavingTipBank.class);
               startActivity(i);
           }
       });

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfile.get(LifeSavingAidMain.this).downLoadUserProfile();
                Intent i=new Intent(LifeSavingAidMain.this,UserProfilePage.class);
                startActivity(i);
            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LifeSavingAidMain.this,FriendList.class);
                startActivity(i);
            }
        });

        emergencyButton = (Button) findViewById(R.id.emergency);
        emergencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfile.get(LifeSavingAidMain.this).EmergencyButtonPress();
            }
        });

        ImageButton new_request_list = (ImageButton) findViewById(R.id.imgbt_notification);
        new_request_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LifeSavingAidMain.this,NewFriendRequestList.class);
                startActivity(i);
            }
        });
    }
}
