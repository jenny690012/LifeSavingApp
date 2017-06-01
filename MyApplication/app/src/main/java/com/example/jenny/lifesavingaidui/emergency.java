package com.example.jenny.lifesavingaidui;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jenny on 20/03/2016.
 */
public class emergency {

    String emergency_title;
    ArrayList<String> emergency_instrs;
    String date;


    // ------these function are useful for you to upload and downLoad information from server
    public emergency(String emergency_title){

        this.emergency_title=emergency_title;
        emergency_instrs = new ArrayList<String>();
    }

    public String getDate(){return date;}
    public void setNewDate(String date){this.date =date; }
    public void setEmergency_title(String title){ emergency_title=title;}
    public String getEmergency_title(){return emergency_title;}
    public ArrayList<String> getEmergency_instrs(){return emergency_instrs;}

    public void add_instr(String instruction){emergency_instrs.add(instruction);}
    public void add_instr(int position,String instruction){
        emergency_instrs.add(position,instruction);
    }
    public String get_instr(int position){return emergency_instrs.get(position);}

    //////////////////////////////////////////////////////////////////////////////////



    //these function does not
    public void pickedFromTipBank(String[] content, int length){
        for(int i=0;i<length;i++){
            emergency_instrs.add(content[i]);
        }
    }

    public void remove(int position){emergency_instrs.remove(position);}
    public void modify(int position,String new_instruction){
        emergency_instrs.set(position,new_instruction);
    }






}
