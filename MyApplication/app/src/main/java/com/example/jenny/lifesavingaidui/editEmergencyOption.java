package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jenny on 23/03/2016.
 */
public class editEmergencyOption extends Activity {

    public static final String EXTRA_OPTION_ID= "com.example.jenny.lifesavingaidui.option_edit_id";
    public static final String EXTRA_NEW_INSTRUCTION="com.example.jenny.lifesavingaidui.new_instruction";
    public static final String EXRRA_OLD_INSTRUCTION="com.example.jenny.lifesavingaidui.old_instruction";
    private static final String TAG = "CheckFlow";
    private String old_instruction;


    private void returnOptionId(int resultCode,int option, String new_insruction) {
        Log.d(TAG, "returnOptionId() in .editEmergencyOption is called, option="+option+" str="+new_insruction);
        Intent i = new Intent();
        i.putExtra(EXTRA_OPTION_ID, option);
        i.putExtra(EXTRA_NEW_INSTRUCTION,new_insruction);
        setResult(resultCode, i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate in .editEmergencyOption is called");
        setContentView(R.layout.edit_emergency_option);

        old_instruction=getIntent().getStringExtra(EXRRA_OLD_INSTRUCTION);

        Button add_step_before = (Button) findViewById(R.id.editEmergency_addStep);
        add_step_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(editEmergencyOption.this,getNewInstruction.class);
                startActivityForResult(i,1);
            }
        });

        Button modify = (Button) findViewById(R.id.editEmergency_modifyStep);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(editEmergencyOption.this,modifyInstruction.class);
                i.putExtra(modifyInstruction.EXTRA_MODIFY_IN,old_instruction);
                startActivityForResult(i,2);
            }
        });

        Button delete = (Button) findViewById(R.id.editEmergency_deleteStep);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnOptionId(RESULT_OK,3, "");
            }
        });

        Button cancel = (Button) findViewById(R.id.addOption_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnOptionId(RESULT_CANCELED,4, "");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(data==null)return;
            String new_instruction=data.getStringExtra(getNewInstruction.EXTRA_INSTRUCTION);
            returnOptionId(resultCode,1,new_instruction);

        }else if(requestCode==2){
            String new_instruction=data.getStringExtra(modifyInstruction.EXTRA_MODIFY_OUT);
            returnOptionId(resultCode,2,new_instruction);

        }
    }
}


