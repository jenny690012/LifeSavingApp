package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Jenny on 23/03/2016.
 */
public class getNewInstruction extends Activity {

    public static final String EXTRA_INSTRUCTION ="com.example.jenny.lifesavingaidui.extra_instruction";
    private static final String TAG="CheckFlow";
    String new_instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_new_instruction);

        Log.d(TAG,"onCreate() in .getNewInstruction is called");

        final EditText instruction = (EditText) findViewById(R.id.getNewInstruction_instruction);

        Button done = (Button) findViewById(R.id.getNewInstruction_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_instruction = instruction.getText().toString();
                giveBackInstruction();
            }
        });

        Button cancel = (Button) findViewById(R.id.getNewInstruction_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giveBackInstruction();
            }
        });
    }

    public void giveBackInstruction(){

        Log.d(TAG,"giveBackInstruction()in .getNewInstruction is called");
        Intent i = new Intent();
        i.putExtra(EXTRA_INSTRUCTION, new_instruction);

        if(new_instruction==null || new_instruction.equals("")){
            setResult(RESULT_CANCELED,i);
        }else{
            setResult(RESULT_OK,i);
        }

        finish();
    }
}
