package binarygame.zxdmjr.com.binarygame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import binarygame.zxdmjr.com.binarygame.objects.SoundSetting;

public class Settings extends AppCompatActivity {

    private Context context;

    private boolean isSoundEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        context = this;

        SoundSetting soundSetting = new SoundSetting(context);


    }
}
