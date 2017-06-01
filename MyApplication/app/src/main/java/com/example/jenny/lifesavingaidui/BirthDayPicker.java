package com.example.jenny.lifesavingaidui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jenny on 25/03/2016.
 */
public class BirthDayPicker extends DialogFragment {

    String myDate;
    public static final String EXTRA_DATE="com.example.jenny.lifesavingaidui.date";
    private static final String TAG="CheckDAte";
    GetBirthDateListener listener;

    public interface GetBirthDateListener{
        public void dispalyBirthDate(String birthDate);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (GetBirthDateListener) activity;//get a reference from EditUserProfile
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        myDate= getArguments().getString(EXTRA_DATE);

        //assume myDate has format "dd/mm/yyyy"
        int day,month,year;

        if(!myDate.equals("")) {
            day = makeInteger(myDate.substring(0, 2));
            month = makeInteger(myDate.substring(3, 5))-1;
            year = Integer.parseInt(myDate.substring(6, 10));
        }else{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            year= calendar.get(Calendar.YEAR);
            month=calendar.get(Calendar.MONTH);
            day=calendar.get(Calendar.DAY_OF_MONTH);
        }

        View v = getActivity().getLayoutInflater().inflate(R.layout.date_picker,null);
        DatePicker picker= (DatePicker) v.findViewById(R.id.datePicker);
        picker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myDate= makeString(dayOfMonth)+"/"+makeString(monthOfYear+1)+"/"+makeString(year);
                listener.dispalyBirthDate(myDate);
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Pick Your Birthday")
                .setPositiveButton(android.R.string.ok,null)
                .create();
    }

    public static BirthDayPicker newInstance(String date){
        Bundle args = new Bundle();
        args.putString(EXTRA_DATE, date);

        BirthDayPicker fragment = new BirthDayPicker();
        fragment.setArguments(args);
        return fragment;
    }

    //PRE: two-digit number which may has leading zero
    //POST: if number has leading zero, delete it, else do nothing
    private int makeInteger(String number){

        if(number.substring(0,1).equals("0")) return Integer.parseInt(number.substring(1));
        else return Integer.parseInt(number);
    }

    private String makeString(int number){
        String result= Integer.toString(number);
        if(result.length()==1) return "0"+result;
        else return result;
    }


}
