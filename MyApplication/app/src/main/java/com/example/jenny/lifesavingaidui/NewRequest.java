package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jenny on 28/03/2016.
 */
public class NewRequest extends Activity {

    public static final String EXTRA_REQUEST= "com.example.jenny.lifesavingaidui.request";
    private static final String TAG="Notification";
    int position;
    Button accept,deny,ignore;
    TextView name;
    ImageView parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_request_option);

        Log.d(TAG, "pass set Content View");

        position = getIntent().getIntExtra(EXTRA_REQUEST,-1);

        Log.d(TAG, "position has set up with value " + position);

        accept = (Button) findViewById(R.id.friends_request_add);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  UserProfile.acceptNewRequest(position);
                  finish();
            }
        });

        Log.d(TAG, "accept button has been set up");

        deny = (Button) findViewById(R.id.friends_request_deny);
        Log.d(TAG, "deny button id has been set up");
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfile.denyNewRequest(position);
                finish();
            }
        });

        Log.d(TAG, "deny button has been set up");

        ignore= (Button) findViewById(R.id.friends_request_back);

        Log.d(TAG, "Ignore button id has been set up");
        ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Log.d(TAG, "Ignore button has been set up");

         name = (TextView) findViewById(R.id.friends_request_name);
        Log.d(TAG,"name text view id has been set up");
        name.setText(UserProfile.getNewRequestItem(position));

        Log.d(TAG,"text view have been set up");

        parent = (ImageView) findViewById(R.id.friend_request_imgv2);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NavUtils.getParentActivityName(NewRequest.this) != null)
                    NavUtils.navigateUpFromSameTask(NewRequest.this);
            }
        });
    }
}
