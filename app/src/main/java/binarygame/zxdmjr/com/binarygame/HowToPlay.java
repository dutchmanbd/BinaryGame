package binarygame.zxdmjr.com.binarygame;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import binarygame.zxdmjr.com.binarygame.objects.FontCache;

public class HowToPlay extends AppCompatActivity {

    private TextView tvHTPRowMsg;
    private TextView tvHTPMsgEasy;
    private TextView tvHTPMsgMedium;
    private TextView tvHTPRowMsg2;

    private Button btnHTPE8,btnHTPE4,btnHTPE2,btnHTPE1,btnHTPE10;
    private Button btnHTPE11,btnHTPE12,btnHTPE13,btnHTPE14,btnHTPE15;

    private Button btnHTPE81,btnHTPE41,btnHTPE21,btnHTPE111,btnHTPE101;
    private Button btnHTPE1111,btnHTPE121,btnHTPE131,btnHTPE141,btnHTPE151;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);

        tvHTPRowMsg = (TextView) findViewById(R.id.tvHTPRowMsg);
        tvHTPRowMsg2 = (TextView) findViewById(R.id.tvHTPRowMsg2);
        tvHTPMsgEasy = (TextView) findViewById(R.id.tvHTPMsgEasy);
        tvHTPMsgMedium = (TextView) findViewById(R.id.tvHTPMsgMedium);

        btnHTPE8 = (Button) findViewById(R.id.btnHTPE8);
        btnHTPE4 = (Button) findViewById(R.id.btnHTPE4);
        btnHTPE2 = (Button) findViewById(R.id.btnHTPE2);
        btnHTPE1 = (Button) findViewById(R.id.btnHTPE1);
        btnHTPE10 = (Button) findViewById(R.id.btnHTPE10);

        btnHTPE11 = (Button) findViewById(R.id.btnHTPE11);
        btnHTPE12 = (Button) findViewById(R.id.btnHTPE12);
        btnHTPE13 = (Button) findViewById(R.id.btnHTPE13);
        btnHTPE14 = (Button) findViewById(R.id.btnHTPE14);
        btnHTPE15 = (Button) findViewById(R.id.btnHTPE15);

        btnHTPE81 = (Button) findViewById(R.id.btnHTPE81);
        btnHTPE41 = (Button) findViewById(R.id.btnHTPE41);
        btnHTPE21 = (Button) findViewById(R.id.btnHTPE21);
        btnHTPE111 = (Button) findViewById(R.id.btnHTPE111);
        btnHTPE101 = (Button) findViewById(R.id.btnHTPE101);

        btnHTPE1111 = (Button) findViewById(R.id.btnHTPE1111);
        btnHTPE121  = (Button) findViewById(R.id.btnHTPE121);
        btnHTPE131  = (Button) findViewById(R.id.btnHTPE131);
        btnHTPE141  = (Button) findViewById(R.id.btnHTPE141);
        btnHTPE151  = (Button) findViewById(R.id.btnHTPE151);




        btnHTPE8.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE4.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        //btnHTPE2.setTypeface(FontCache.getTypeface(HowToPlay.this,"perfograma.otf"));
        btnHTPE1.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE10.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));

        btnHTPE11.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE12.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        //btnHTPE13.setTypeface(FontCache.getTypeface(HowToPlay.this,"perfograma.otf"));
        btnHTPE14.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE15.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));



        btnHTPE81.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE41.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        //btnHTPE2.setTypeface(FontCache.getTypeface(HowToPlay.this,"perfograma.otf"));
        btnHTPE111.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE101.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));

        btnHTPE1111.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE121.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        //btnHTPE13.setTypeface(FontCache.getTypeface(HowToPlay.this,"perfograma.otf"));
        btnHTPE141.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));
        btnHTPE151.setTypeface(FontCache.getTypeface(HowToPlay.this,"quikhand.ttf"));

//        Typeface typeface = Typeface.createFromAsset(getAssets(),"gladifilthefte.ttf");
//        //quikhand.ttf   rhumbascriptnf.ttf  perfograma.otf
//
//        tvHTPRowMsg.setTypeface(typeface);
//
//        typeface = Typeface.createFromAsset(getAssets(),"gladifilthefte.ttf");
//
//        tvHTPRowMsg2.setTypeface(typeface);
//
//        typeface = Typeface.createFromAsset(getAssets(),"gladifilthefte.ttf");
//
//        tvHTPMsgEasy.setTypeface(typeface);
//
//        typeface = Typeface.createFromAsset(getAssets(),"gladifilthefte.ttf");
//
//        tvHTPMsgMedium.setTypeface(typeface);


//        String message = "Easy\n8-4-2-1\nMedium\n32-16-8-4-2-1\nHard\n128-64-32-16-8-4-2-1\n";
//        message += "Rows\n";
//        message += "";
    }
}
