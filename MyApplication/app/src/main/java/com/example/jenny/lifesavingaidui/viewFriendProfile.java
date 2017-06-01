package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jenny on 24/03/2016.
 */
public class viewFriendProfile extends Activity{

    TextView name,height,weight,blood_type,birthDay,healthHistory,phone;
    Profile friend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_friend_info);

        friend = UserProfile.get(this).getFriendProfile();
        name = (TextView) findViewById(R.id.viewFriendInfo_name);
        name.setText(friend.getName());

        height = (TextView) findViewById(R.id.viewFriendInfo_height);
        name.setText(friend.getHeight());

        weight = (TextView) findViewById(R.id.viewFriendInfo_weight);
        weight.setText(friend.getWeight());

        blood_type = (TextView) findViewById(R.id.viewFriendInfo_bloodType);
        blood_type.setText(friend.getBlood_type());

        birthDay = (TextView) findViewById(R.id.viewFriendInfo_birthDate);
        birthDay.setText(friend.getBirthDay());

        healthHistory = (TextView) findViewById(R.id.viewFriendInfo_health);
        healthHistory.setText(friend.getHealthHistory());

        phone = (TextView) findViewById(R.id.viewFriendInfo_phone);
        phone.setText(friend.getPhone());

        Button back = (Button) findViewById(R.id.viewFriendInfo_buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView parent = (ImageView) findViewById(R.id.viewFriendInfo_imageView);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NavUtils.getParentActivityName(viewFriendProfile.this)!=null)
                    NavUtils.navigateUpFromSameTask(viewFriendProfile.this);
            }
        });

    }
}
