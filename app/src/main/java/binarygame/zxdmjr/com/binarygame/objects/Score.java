package binarygame.zxdmjr.com.binarygame.objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by dutchman on 12/20/16.
 */

public class Score {

//    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
//    editor.putString("name", "Elena");
//    editor.putInt("idName", 12);
//    editor.commit();

//    SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
//    String restoredText = prefs.getString("text", null);
//    if (restoredText != null) {
//        String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
//        int idName = prefs.getInt("idName", 0); //0 is the default value.
//    }

//    private Round decimal;
//    private Round hexDecimal;
//    private Round octal;
    private String type;
    private Context context;
    private int minTime;
    //private SharedPreferences.Editor editor;


    public Score(Context context){

        this.context = context;
    }
//
//    public Score(Context context,String type,int hs){
//
//        this.type = type;
//        this.hs = hs;
//        this.context = context;
//
//    }

    public void setData(String type,int hs){


        minTime = getData(type);

        if(minTime > 0){
            minTime = Math.min(minTime,hs);

        } else{
            minTime = hs;
        }

        SharedPreferences.Editor editor = this.context.getSharedPreferences(KeyWords.PREF_HIGH_SCORE, this.context.MODE_PRIVATE).edit();

        editor.putInt(type,minTime);

        editor.commit();


    }

    public int getData(String type){

        SharedPreferences prefs = context.getSharedPreferences(KeyWords.PREF_HIGH_SCORE, context.MODE_PRIVATE);

        int hs;

        hs = prefs.getInt(type,0);

        return hs;
    }



    private class Round{

        private String easy;
        private String medium;
        private String hard;

        public String getEasy() {
            return easy;
        }

        public void setEasy(String easy) {
            this.easy = easy;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getHard() {
            return hard;
        }

        public void setHard(String hard) {
            this.hard = hard;
        }
    }


}
