package binarygame.zxdmjr.com.binarygame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import binarygame.zxdmjr.com.binarygame.objects.KeyWords;
import binarygame.zxdmjr.com.binarygame.objects.Score;
import binarygame.zxdmjr.com.binarygame.objects.ScoreIntentData;

public class NextStepForEasy extends AppCompatActivity {

    private Button btnReplay,btnExit;

    private TextView tvCongrtulations;
    private TextView tvTotalTime;
    private TextView tvTimeText;
    private TextView tvCurrentTimeText;
    private TextView tvCurrentTime;

    private TextView tvNewBestTime;

    private String text;
    private String timeText;
    private String type;

    private int totalTime;
    private int minutes;
    private int seconds;
    private ScoreIntentData intentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_step_for_easy);

        getSupportActionBar().setTitle("Binary Game");
        //getSupportActionBar().setSubtitle("");

        Intent intent = getIntent();

        // intent value
//        text      = intent.getStringExtra(KeyWords.CONGRETS_MSG);
//        timeText  = intent.getStringExtra(KeyWords.TIME_MSG);
//        type      = intent.getStringExtra(KeyWords.KEY_TYPE);
//        totalTime = intent.getIntExtra(KeyWords.TOTALTIME,30);


        intentData = (ScoreIntentData) intent.getSerializableExtra(KeyWords.INTENT_DATA);

        init();
    }

    private void init(){

        btnReplay        = (Button) findViewById(R.id.btnReplay);
        btnExit          = (Button) findViewById(R.id.btnExit);
        tvCongrtulations = (TextView) findViewById(R.id.tvCongrtulations);
        tvTotalTime      = (TextView) findViewById(R.id.tvTotalTime);
        tvTimeText       = (TextView) findViewById(R.id.tvTimeText);
        tvNewBestTime    = (TextView) findViewById(R.id.tvNewBestTime);
        tvCurrentTimeText    = (TextView) findViewById(R.id.tvCurrentTimeText);
        tvCurrentTime    = (TextView) findViewById(R.id.tvCurrentTime);

        type = intentData.getType();

        Score score = new Score(this);

        int bestTime = score.getData(type);


        tvNewBestTime.setText("Best Time: "+bestTime);
        tvCongrtulations.setText(intentData.getCongrets());
        tvCurrentTimeText.setText(intentData.getCurrentTimeMsg());
        tvTimeText.setText(intentData.getTotalTimeMsg());


        //For Current Time
        totalTime = Integer.parseInt(intentData.getCurrentTime());
        minutes = totalTime / 60;
        seconds = totalTime % 60;
        String fmt = String.format("%d:%02d",minutes,seconds);
        tvCurrentTime.setText(fmt);

        //For Total Time
        totalTime = Integer.parseInt(intentData.getTotalTime());
        minutes = totalTime / 60;
        seconds = totalTime % 60;
        fmt = String.format("%d:%02d",minutes,seconds);
        tvTotalTime.setText(fmt);



        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(type.equals(KeyWords.DEC_EASY)) {
                    Intent intent = new Intent(NextStepForEasy.this, DecimalEasy.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.DEC_MEDIUM)){
                    Intent intent = new Intent(NextStepForEasy.this, DecimalMedium.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.DEC_HARD)){
                    Intent intent = new Intent(NextStepForEasy.this, DecimalHard.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.HEX_EASY)){
                    Intent intent = new Intent(NextStepForEasy.this, HexEasy.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.HEX_HARD)){
                    Intent intent = new Intent(NextStepForEasy.this, HexHard.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.OCT_EASY)){
                    Intent intent = new Intent(NextStepForEasy.this, OctalEasy.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.OCT_MEDIUM)){
                    Intent intent = new Intent(NextStepForEasy.this, OctalMedium.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.OCT_HARD)){

                    Intent intent = new Intent(NextStepForEasy.this, OctalHard.class);
                    startActivity(intent);
                    finish();

                }

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//
//                intent.addCategory(Intent.CATEGORY_HOME);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//                finish();
//                System.exit(0);

                if(type.equals(KeyWords.DEC_EASY) || type.equals(KeyWords.DEC_MEDIUM) || type.equals(KeyWords.DEC_HARD)) {
                    Intent intent = new Intent(NextStepForEasy.this, DecimalBase.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.HEX_EASY) || type.equals(KeyWords.HEX_HARD)){
                    Intent intent = new Intent(NextStepForEasy.this, HexaBase.class);
                    startActivity(intent);
                    finish();

                } else if(type.equals(KeyWords.OCT_EASY) || type.equals(KeyWords.OCT_MEDIUM) || type.equals(KeyWords.OCT_HARD)){
                    Intent intent = new Intent(NextStepForEasy.this, OctalBase.class);
                    startActivity(intent);
                    finish();
                }


            }
        });

    }
}
