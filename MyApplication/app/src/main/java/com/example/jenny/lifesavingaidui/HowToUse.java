package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jenny on 26/03/2016.
 */
public class HowToUse extends Activity {

    //this Activity is just a menu page to guide user how to use this app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_use);
        Button back = (Button) findViewById(R.id.how_to_use);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
