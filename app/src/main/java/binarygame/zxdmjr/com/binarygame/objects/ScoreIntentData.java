package binarygame.zxdmjr.com.binarygame.objects;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by dutchman on 3/26/17.
 */

public class ScoreIntentData implements Serializable {

//    intent.putExtra(KeyWords.CONGRETS_MSG,"Congratulations!");
//            intent.putExtra(KeyWords.CURRENT_TIME_MSG,"Your Current Time For Decimal Easy Round :")
//            intent.putExtra(KeyWords.TIME_MSG,"Your Total Time For Decimal Easy Round :");
//            intent.putExtra(KeyWords.KEY_TYPE,KeyWords.DEC_EASY);
//            intent.putExtra(KeyWords.TOTALTIME,totalTime);

    private String congrets = "Congratulations!";
    private String currentTimeMsg = "";
    private String totalTimeMsg = "";
    private String currentTime = "";
    private String totalTime = "";
    private String type = "";

    public ScoreIntentData(String type, String currentTime, String totalTime){

        this.setCurrentTimeMsg(type);
        this.setCurrentTime(currentTime);
        this.setTotalTimeMsg(type);
        this.setTotalTime(totalTime);
        this.setType(type);

    }

    public String getCongrets() {
        return congrets;
    }

    public void setCongrets(String congrets) {
        this.congrets = congrets;
    }

    public String getCurrentTimeMsg() {
        return currentTimeMsg;
    }

    public void setCurrentTimeMsg(String type) {

        this.currentTimeMsg = getMessage("Current",type);

    }

    public String getTotalTimeMsg() {
        return totalTimeMsg;
    }

    public void setTotalTimeMsg(String type) {
        this.totalTimeMsg = getMessage("Total",type);
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String getMessage(String state, String type){

        String[] parts = type.split("_");

        String roundName = getRoundName(parts[0]);
        String roundState  = toCapSentace(parts[0]);

        String message = String.format("Your %s Time For %s %s Round: ",state,roundName,roundState);

        return message;
    }

    private String getRoundName(String roundCode){


        if(roundCode.equals("DEC")){
            return "Decimal";
        } else if(roundCode.equals("OCT")){
            return "Octal";

        } else if(roundCode.equals("HEX")){
            return "HexaDecimal";
        }

        return "";

    }

    private String toCapSentace(String state){

        if(state.equals("EASY"))
            return "Easy";
        else if(state.equals("MEDIUM"))
            return "Medium";
        else if (state.equals("HARD"))
            return "Hard";

        return "";
    }

}
