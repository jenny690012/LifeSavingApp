package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jenny on 24/03/2016.
 */
public class modifyInstruction extends Activity {

    public static String EXTRA_MODIFY_IN="com.example.jenny.lifesavingaidui.modify_instruction_in";
    public static String EXTRA_MODIFY_OUT="com.example.jenny.lifesavingaidui.modify_instruction_out";
    private static String TAG="CheckFlow";

    Button modify,cancel;
    EditText instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_instruction);
        Log.d(TAG,"onCreate() in .modifyInstruction is called");

        instruction= (EditText) findViewById(R.id.modifyInstruction_instruction);
        final String old_instruction = getIntent().getStringExtra(EXTRA_MODIFY_IN);
        Log.d(TAG,"instrction got is("+old_instruction+") in .modifyInstruction");
        instruction.setText(old_instruction, TextView.BufferType.EDITABLE);

         modify = (Button) findViewById(R.id.modifyInstruction_modify);
         modify.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String new_instruction=instruction.getText().toString();

                 if(new_instruction.equals(old_instruction)){
                     returnResult(RESULT_CANCELED,null);
                 }else{
                     returnResult(RESULT_OK,new_instruction);
                 }
             }
         });

        cancel= (Button) findViewById(R.id.modifyInstruction_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult(RESULT_CANCELED,null);
            }
        });
    }

    private void returnResult(int resultCode,String new_instruction){
        Log.d(TAG,"returnResult() in .modifyInstruction is called, str="+new_instruction);
        Intent i = new Intent();
        i.putExtra(EXTRA_MODIFY_OUT,new_instruction);
        setResult(resultCode, i);
        finish();
    }
}
