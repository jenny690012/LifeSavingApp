package com.example.jenny.lifesavingaidui;

import java.util.ArrayList;

/**
 * Created by Jenny on 20/03/2016.
 */
public class Profile {

    String name,height,weight,blood_type,birthDay,healthHistory,phone;
    ArrayList<emergency> emergencies;


    //here are the functions you need to upload and download to server
    public Profile(){
        //I initialize data this way. but when info is downloaded from server
        // UI will update these field automatically
        name = "Jenny Ye";
        height ="";
        weight = "";
        blood_type="";
        birthDay="";
        healthHistory="";
        phone="";
        emergencies = new ArrayList<emergency>();
    }


    //all the getters
    public String getName(){return name;}
    public String getHeight() {return height;}
    public String getWeight() {return weight;}
    public String getBirthDay() {return birthDay;}
    public String getBlood_type() {return blood_type;}
    public String getHealthHistory() {return healthHistory;}
    public String getPhone(){return phone;}
    public ArrayList<emergency> getEmergencies(){return emergencies;}

    //all the setters
    public void setName(String name){this.name = name;}
    public void setHeight(String height) {this.height = height;}
    public void setWeight(String weight) {this.weight = weight;}
    public void setBirthDay(String birthDay) {this.birthDay = birthDay;}
    public void setBlood_type(String blood_type) {this.blood_type = blood_type;}
    public void setHealthHistory(String healthHistory) {this.healthHistory = healthHistory;}
    public void setPhone(String phone){ this.phone= phone;}

    //add an emergency to the end of the emergencies
    public void addEmergencyItem(emergency em){emergencies.add(em);}
    //get the emergency from emergencies at index=position
    public emergency getEmergencyItem(int position){return emergencies.get(position);}

    ///////////////////////////////////////////////////////////////////////////////////////


    //these function below are not related to server

    //remove the emergency from emergencies at index=position
    public void removeEmergencyItem(int position){emergencies.remove(position);}
    public void setEmergencyItem(int position,emergency em){emergencies.set(position,em);}
}