package binarygame.zxdmjr.com.binarygame.objects;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by dutchman on 12/21/16.
 */

public class SoundSetting {

    private Context context;

    public SoundSetting(Context context){

        this.context = context;

    }

    public void setSoundEnable(){

        SharedPreferences.Editor editor = this.context.getSharedPreferences(KeyWords.PREF_SOUND_OPT, this.context.MODE_PRIVATE).edit();

        editor.putBoolean(KeyWords.PREF_IS_SOUND_ENABLE,true);

        editor.commit();

    }

    public boolean isSoundEnable(){

        SharedPreferences prefs = context.getSharedPreferences(KeyWords.PREF_SOUND_OPT, context.MODE_PRIVATE);

        boolean isEnable;

        isEnable = prefs.getBoolean(KeyWords.PREF_IS_SOUND_ENABLE,false);

        return isEnable;
    }


}
