package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jenny on 24/03/2016.
 */
public class AddFriend extends Activity {


    Button add,back;
    EditText name;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);

        back= (Button) findViewById(R.id.addFriend_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        name= (EditText) findViewById(R.id.addFriend_name);
        result= (TextView) findViewById(R.id.addFriend_result);

        add= (Button) findViewById(R.id.addFriend_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_str= name.getText().toString();

                if(!name_str.equals("")) {
                    boolean found=UserProfile.get(AddFriend.this).addFriend(name_str);

                   if (found) {
                       result.setText(name_str + " was added");
                   } else {
                       result.setText(name_str + " was not found");
                   }
                }
            }
        });

        ImageView parent = (ImageView) findViewById(R.id.addFriend_imageView);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NavUtils.getParentActivityName(AddFriend.this)!=null)
                    NavUtils.navigateUpFromSameTask(AddFriend.this);
            }
        });
    }
}
