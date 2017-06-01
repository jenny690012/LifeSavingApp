package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Jenny on 28/03/2016.
 */
public class NewFriendRequestList extends Activity {

    ListView friends_list;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_friends_request);

        //pull a list of friends from server
        UserProfile.downLoadNewRequestListServer();


        back= (Button) findViewById(R.id.friends_request_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        friends_list= (ListView) findViewById(R.id.friend_request_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,UserProfile.getNewRequestList());
        friends_list.setAdapter(adapter);
        friends_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(NewFriendRequestList.this, NewRequest.class);
                i.putExtra(NewRequest.EXTRA_REQUEST,position);
                startActivity(i);
            }
        });

        ImageView parent = (ImageView) findViewById(R.id.friend_request_imgv);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                      finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,UserProfile.getNewRequestList());
        friends_list.setAdapter(adapter);
    }
}
