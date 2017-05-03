package binarygame.zxdmjr.com.binarygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import binarygame.zxdmjr.com.binarygame.objects.KeyWords;
import binarygame.zxdmjr.com.binarygame.objects.Score;

public class HighScore extends AppCompatActivity {

    private TextView tvDEasy,tvDMedium,tvDHard;
    private TextView tvHEasy,tvHHard;
    private TextView tvOEasy,tvOMedium,tvOHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        getSupportActionBar().setTitle("High Score");
        //getSupportActionBar().setSubtitle("Easy");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init(){

        //Decimal
        tvDEasy = (TextView) findViewById(R.id.tvDEasy);
        tvDMedium = (TextView) findViewById(R.id.tvDMedium);
        tvDHard = (TextView) findViewById(R.id.tvDHard);

        //Hex
        tvHEasy = (TextView) findViewById(R.id.tvHEasy);
        tvHHard = (TextView) findViewById(R.id.tvHHard);

        //Octal
        tvOEasy = (TextView) findViewById(R.id.tvOEasy);
        tvOMedium = (TextView) findViewById(R.id.tvOMedium);
        tvOHard = (TextView) findViewById(R.id.tvOHard);


        //Get Score

        getScoreData();


    }

    private void getScoreData(){

        Score score = new Score(getApplicationContext());

        int minTime;

        //DEC EASY
        minTime = score.getData(KeyWords.DEC_EASY);
        String fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvDEasy.setText(fmt);

        //DEC MEDIUM
        minTime = score.getData(KeyWords.DEC_MEDIUM);
        fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvDMedium.setText(fmt);

        //DEC HARD
        minTime = score.getData(KeyWords.DEC_HARD);
        fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvDHard.setText(fmt);

        //HEX EASY
        minTime = score.getData(KeyWords.HEX_EASY);
        fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvHEasy.setText(fmt);

        //HEX HARD
        minTime = score.getData(KeyWords.HEX_HARD);
        fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvHHard.setText(fmt);

        //OCT EASY
        minTime = score.getData(KeyWords.OCT_EASY);
        fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvOEasy.setText(fmt);

        //OCT MEDIUM
        minTime = score.getData(KeyWords.OCT_MEDIUM);
        fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvOMedium.setText(fmt);

        //OCT HARD
        minTime = score.getData(KeyWords.OCT_HARD);
        fmt = String.format("%d:%02d",minTime/60,minTime%60);
        tvOHard.setText(fmt);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
        onBackPressed();
        return true;
    }

}
