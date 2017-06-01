package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jenny on 24/03/2016.
 */
public class FriendList extends Activity {

    ListView friends_list;
    Button back,addFriend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);

        //pull a list of friends from server
        UserProfile.get(this).DownLoadFriendListFromServer();


        back= (Button) findViewById(R.id.friendList_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addFriend = (Button) findViewById(R.id.friendList_addNewFriend);
        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FriendList.this,AddFriend.class);
                startActivity(i);
            }
        });

        friends_list= (ListView) findViewById(R.id.friendList_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,UserProfile.getFriendsList());
        friends_list.setAdapter(adapter);
        friends_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserProfile.get(FriendList.this).DownLoadFriendProfileFromServer(position);
                Intent i = new Intent(FriendList.this, FriendProfile.class);
                startActivity(i);
            }
        });

        ImageView parent = (ImageView) findViewById(R.id.friendList_imageView);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NavUtils.getParentActivityName(FriendList.this) != null)
                    NavUtils.navigateUpFromSameTask(FriendList.this);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,UserProfile.getFriendsList());
        friends_list.setAdapter(adapter);
    }
}
