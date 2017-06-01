package com.example.jenny.lifesavingaidui;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jenny on 20/03/2016.
 */


// this class is a global structure
public class UserProfile {

    private static UserProfile myUserProfile;
    private Context myAppContext;
    private static Profile user;

    private static ArrayList<String> friends_list;
    private static Profile friend;


    private UserProfile(Context context){
        myAppContext=context;
        user = new Profile();
    }
    public static UserProfile get(Context c){
        if (myUserProfile==null){
            myUserProfile = new UserProfile(c.getApplicationContext());
        }
        return myUserProfile;
    }


    ////code relate to user-----------------------------------
    public Profile getProfile(){return user;}
    public ArrayList<emergency> getEmergencyList(){return user.getEmergencies();}
    public static void updateUserInfo(String name,String weight,String height,String bloodtype,
                               String healthHistory,
                               String phone,String birthDay){

        user.setName(name);
        user.setWeight(weight);
        user.setHeight(height);
        user.setBlood_type(bloodtype);
        user.setHealthHistory(healthHistory);
        user.setPhone(phone);
        user.setBirthDay(birthDay);
    }

    public static void addEmergencyItem(emergency em){
          user.addEmergencyItem(em);
    }
    public static void setEmergencyItem(int position, emergency em){
         user.setEmergencyItem(position, em);
    }
    public static emergency getEmergencyItem(int position){
       return user.getEmergencyItem(position);
    }
    public static void removeEmergencyItem(int position){
        user.removeEmergencyItem(position);
    }

    public static void upLoadUserProfile(){}
    public static void downLoadUserProfile(){}
    //---------------------------------------


    //code for friends-------------------------------------


       /*everything about friends should only be readable to user. user can not modify
         any friends information. please make sure all the setters appear in this file only*/
       public static void DownLoadFriendProfileFromServer(int position){

           //example of how to set up a profile for a friend, delete this part and put meaningful code
           // when actually wire up UI with server
                friend = new Profile();
                friend.setName(friends_list.get(position));
                friend.setBirthDay("March 20, 2016");
                friend.setPhone("519-588-9460");
                friend.setWeight("65");
                friend.setHeight("165");
                friend.setBlood_type("AB");
                friend.setHealthHistory("very Healthy.long text long text long text long text long text");

                emergency em= new emergency("Final Exam");
                em.setNewDate(new Date().toString());
                em.add_instr("Calm Down");
                em.add_instr("Find a seat");
                em.add_instr("study all day");
                em.add_instr(2,"prepare snack");
                friend.addEmergencyItem(em);
           //---------------------------------------------------------
        }

        public void DownLoadFriendListFromServer(){
            friends_list = new ArrayList<String>();
            friends_list.add("Kevin");
            friends_list.add("Jenny");
        }

        public static ArrayList<String> getFriendsList(){return friends_list;}
        public static Profile getFriendProfile(){return friend;}
    //-----------------------------------------------------


    //code for Emergency Button and for Tracking Button---------------------
    public void EmergencyButtonPress(){
        /* all the information about the user is within this file, and is updated before
        * this call. feel free to use those information*/

    }

    public void TackingButtonPress(){
        /* all the information about the friends is also updated before this call*/

    }

    public boolean addFriend(String name){
        //please add code for adding a friend here, you may want to add additional layout files
        //for this part of functionality
        boolean friends_found=false;

        if(friends_found){
            friends_list.add(name);
        }
        return friends_found;
    }


    private static ArrayList<String> friend_request_list;
    public static ArrayList<String> getNewRequestList(){return friend_request_list;}
    public static String getNewRequestItem(int position){return friend_request_list.get(position);}
    private static void deleteFriendRequest(int position){friend_request_list.remove(position);}

    public static void acceptNewRequest(int position){//position is the index of accepted person,
                                                     //you can make use of it, some how.

        // do something here with server

        //--------------------------------

        //then remove the person's name from friend request list
        deleteFriendRequest(position);//please do not remove this code
    }

    public static void denyNewRequest(int position){

        // do something here with server

        //--------------------------------

        //again, remove the person's name
        deleteFriendRequest(position);//please do not remove this code
    }

    public static void downLoadNewRequestListServer(){
        friend_request_list = new ArrayList<String>();
        friend_request_list.add("Jenny");
    }

}
