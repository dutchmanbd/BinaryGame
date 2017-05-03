package binarygame.zxdmjr.com.binarygame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Random;

import binarygame.zxdmjr.com.binarygame.objects.KeyWords;
import binarygame.zxdmjr.com.binarygame.objects.Numbers;
import binarygame.zxdmjr.com.binarygame.objects.Score;
import binarygame.zxdmjr.com.binarygame.objects.ScoreIntentData;

public class HexEasy extends AppCompatActivity implements View.OnClickListener {


    private Button btnRow11,btnRow12,btnRow13,btnRow14,btnRow15;
    private Button btnRow21,btnRow22,btnRow23,btnRow24,btnRow25;
    private Button btnRow31,btnRow32,btnRow33,btnRow34,btnRow35;
    private Button btnRow41,btnRow42,btnRow43,btnRow44,btnRow45;
    private Button btnRow51,btnRow52,btnRow53,btnRow54;

    private TextView tvTimer;

    private boolean row11First,row12First,row13First,row14First;
    private boolean row21First,row22First,row23First,row24First;
    private boolean row31First,row32First,row33First,row34First;
    private boolean row41First,row42First,row43First,row44First;

    private boolean isCompleteRow1,isCompleteRow2,isCompleteRow3,isCompleteRow4;
    private boolean isCompleteVRow1,isCompleteVRow2,isCompleteVRow3,isCompleteVRow4;

    private Numbers[] numbers;
    private int[] val = {8,4,2,1};


    private static int totalTime = 0;

    private long startTime = 0;

    //runs without a timer by reposting this handler at the end of the runnable
    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            tvTimer.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_easy);

        getSupportActionBar().setTitle("HexaDecimal");
        getSupportActionBar().setSubtitle("Easy");

        init();

    }


    private void init(){

        // Row 1
        btnRow11 = (Button) findViewById(R.id.btnRowXE11);
        btnRow12 = (Button) findViewById(R.id.btnRowXE12);
        btnRow13 = (Button) findViewById(R.id.btnRowXE13);
        btnRow14 = (Button) findViewById(R.id.btnRowXE14);
        btnRow15 = (Button) findViewById(R.id.btnRowXE15);

        // Row 2
        btnRow21 = (Button) findViewById(R.id.btnRowXE21);
        btnRow22 = (Button) findViewById(R.id.btnRowXE22);
        btnRow23 = (Button) findViewById(R.id.btnRowXE23);
        btnRow24 = (Button) findViewById(R.id.btnRowXE24);
        btnRow25 = (Button) findViewById(R.id.btnRowXE25);

        // Row 3
        btnRow31 = (Button) findViewById(R.id.btnRowXE31);
        btnRow32 = (Button) findViewById(R.id.btnRowXE32);
        btnRow33 = (Button) findViewById(R.id.btnRowXE33);
        btnRow34 = (Button) findViewById(R.id.btnRowXE34);
        btnRow35 = (Button) findViewById(R.id.btnRowXE35);


        // Row 4
        btnRow41 = (Button) findViewById(R.id.btnRowXE41);
        btnRow42 = (Button) findViewById(R.id.btnRowXE42);
        btnRow43 = (Button) findViewById(R.id.btnRowXE43);
        btnRow44 = (Button) findViewById(R.id.btnRowXE44);
        btnRow45 = (Button) findViewById(R.id.btnRowXE45);

        // Row 5
        btnRow51 = (Button) findViewById(R.id.btnRowXE51);
        btnRow52 = (Button) findViewById(R.id.btnRowXE52);
        btnRow53 = (Button) findViewById(R.id.btnRowXE53);
        btnRow54 = (Button) findViewById(R.id.btnRowXE54);

        //TextView Timer

        tvTimer  = (TextView) findViewById(R.id.tvTimerX);

//        new CountDownTimer(30000,1000){
//
//            @Override
//            public void onTick(long mil) {
//                tvTimer.setText(""+mil/1000);
//            }
//
//            @Override
//            public void onFinish() {
//                //tvTimer.setText("Time Finish.");
//                Intent intent = new Intent(DecimalEasy.this,NextStepForEasy.class);
//                intent.putExtra("TEXT","oops, try again.");
//                startActivity(intent);
//            }
//        }.start();

        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);


        Random rand;

        numbers = new Numbers[4];

        for(int i=1; i<=4; i++) {
            rand = new Random();

            int num = rand.nextInt(1000) % 16;

            String hex = Integer.toHexString(num).toUpperCase();

            numbers[i-1] = new Numbers(num);

            if(i == 1)
                btnRow15.setText(hex);
            if(i == 2)
                btnRow25.setText(hex);
            if(i == 3)
                btnRow35.setText(hex);
            if(i == 4)
                btnRow45.setText(hex);
        }

        int decNum = 0;

        // Vertically set

        for(int row=0; row<4; row++) {
            decNum = 0;
            for (int col = 0; col < 4; col++) {
                decNum = decNum + numbers[col].getBinDigitAtPosition(row) * val[col];
            }

            String hex = Integer.toHexString(decNum).toUpperCase();

            if(row == 0)
                btnRow51.setText(hex);

            else if(row == 1)
                btnRow52.setText(hex);
            else if(row == 2)
                btnRow53.setText(hex);
            else if(row == 3)
                btnRow54.setText(hex);
        }

        // Actions row 1
        btnRow11.setOnClickListener(this);
        btnRow12.setOnClickListener(this);
        btnRow13.setOnClickListener(this);
        btnRow14.setOnClickListener(this);

        // Actions row 2
        btnRow21.setOnClickListener(this);
        btnRow22.setOnClickListener(this);
        btnRow23.setOnClickListener(this);
        btnRow24.setOnClickListener(this);

        // Actions row 3
        btnRow31.setOnClickListener(this);
        btnRow32.setOnClickListener(this);
        btnRow33.setOnClickListener(this);
        btnRow34.setOnClickListener(this);

        // Actions row 4
        btnRow41.setOnClickListener(this);
        btnRow42.setOnClickListener(this);
        btnRow43.setOnClickListener(this);
        btnRow44.setOnClickListener(this);



        // Check Given number if already matches
        checkNumRow1();
        checkNumRow2();
        checkNumRow3();
        checkNumRow4();


        firstCheckInVertical();

        allRowCompleted();

    }


    //Check First
    private void firstCheckInVertical(){

        if(btnRow51.getText().toString().equals("0")){
            isCompleteVRow1 = true;
            if(isCompleteVRow1)
                //btnRow51.setBackgroundColor(0xff00ddff);
                btnRow51.setBackgroundResource(R.drawable.button_bg);
            else
                //btnRow51.setBackgroundColor(0xffff4444);
                btnRow51.setBackgroundResource(R.drawable.button_bg_2);

        }

        if(btnRow52.getText().toString().equals("0")){
            isCompleteVRow2 = true;
            if(isCompleteVRow2)
                //btnRow52.setBackgroundColor(0xff00ddff);
                btnRow52.setBackgroundResource(R.drawable.button_bg);
            else
                //btnRow52.setBackgroundColor(0xffff4444);
                btnRow52.setBackgroundResource(R.drawable.button_bg_2);

        }

        if(btnRow53.getText().toString().equals("0")){
            isCompleteVRow3 = true;
            if(isCompleteVRow3)
                //btnRow53.setBackgroundColor(0xff00ddff);
                btnRow53.setBackgroundResource(R.drawable.button_bg);
            else
                //btnRow53.setBackgroundColor(0xffff4444);
                btnRow53.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow54.getText().toString().equals("0")){
            isCompleteVRow4 = true;
            if(isCompleteVRow4)
                //btnRow54.setBackgroundColor(0xff00ddff);
                btnRow54.setBackgroundResource(R.drawable.button_bg);
            else
                //btnRow54.setBackgroundColor(0xffff4444);
                btnRow54.setBackgroundResource(R.drawable.button_bg_2);
        }
    }


    //Check when all completed
    private void allRowCompleted(){

        if((isCompleteRow1 && isCompleteRow2 && isCompleteRow3 && isCompleteRow4)
                && (isCompleteVRow1 && isCompleteVRow2 && isCompleteVRow3 && isCompleteVRow4)
                ){

            String[] str = tvTimer.getText().toString().split(":");

            int temp = (Integer.parseInt(str[0].trim()) * 60) + (Integer.parseInt(str[1].trim()));

            Score score = new Score(getApplicationContext());

            score.setData(KeyWords.HEX_EASY,temp);

            totalTime += temp;


            ScoreIntentData intentData = new ScoreIntentData(KeyWords.HEX_EASY, Integer.toString(temp), Integer.toString(totalTime));

            Intent intent = new Intent(HexEasy.this,NextStepForEasy.class);
            intent.putExtra(KeyWords.INTENT_DATA, (Serializable) intentData);


//            Intent intent = new Intent(HexEasy.this,NextStepForEasy.class);
//            intent.putExtra(KeyWords.CONGRETS_MSG,"Congratulations!");
//            intent.putExtra(KeyWords.TIME_MSG,"Your total time for Hex Easy round is:");
//            intent.putExtra(KeyWords.KEY_TYPE,KeyWords.HEX_EASY);
//            intent.putExtra(KeyWords.TOTALTIME,totalTime);
            startActivity(intent);
            finish();
        }
    }

    //check vertically

    private boolean checkNumVRow(int j){

        int dNum = 0;
        String gNum = "";
        String hex  = "0";

        switch(j) {

            case 0:

                dNum =  (Integer.parseInt(btnRow11.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow21.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow31.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow41.getText().toString()) * 1);

                gNum = btnRow51.getText().toString();

                break;

            case 1:

                dNum =  (Integer.parseInt(btnRow12.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow22.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow32.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow42.getText().toString()) * 1);

                gNum = btnRow52.getText().toString();
                break;

            case 2:

                dNum =  (Integer.parseInt(btnRow13.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow23.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow33.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow43.getText().toString()) * 1);

                gNum = btnRow53.getText().toString();
                break;

            case 3:

                dNum =  (Integer.parseInt(btnRow14.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow24.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow34.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow44.getText().toString()) * 1);

                gNum = btnRow54.getText().toString().trim();
                break;

        }

        hex = Integer.toHexString(dNum).toUpperCase();

        if(hex.equals(gNum)){

            return true;

        } else{

            return false;
        }

    }


    //Check Row 1
    private boolean checkNumRow1(){

        int bin = (Integer.parseInt(btnRow11.getText().toString()) * 8)  +
                  (Integer.parseInt(btnRow12.getText().toString()) * 4 ) +
                  (Integer.parseInt(btnRow13.getText().toString()) * 2)  +
                  (Integer.parseInt(btnRow14.getText().toString()) * 1);

        String gn = btnRow15.getText().toString();
        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow1 = true;
            btnRow15.setBackgroundResource(R.drawable.button_bg);

        } else{

            isCompleteRow1 = false;
            btnRow15.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow1;
    }

    //check Row 2
    private boolean checkNumRow2(){

        int bin = (Integer.parseInt(btnRow21.getText().toString()) * 8)  +
                  (Integer.parseInt(btnRow22.getText().toString()) * 4 ) +
                  (Integer.parseInt(btnRow23.getText().toString()) * 2)  +
                  (Integer.parseInt(btnRow24.getText().toString()) * 1);

        String gn = btnRow25.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow2 = true;
            btnRow25.setBackgroundResource(R.drawable.button_bg);


        }else{

            isCompleteRow2 = false;
            btnRow25.setBackgroundResource(R.drawable.button_bg_2);

        }


        return isCompleteRow2;
    }

    //Check Row 3
    private boolean checkNumRow3(){

        int bin = (Integer.parseInt(btnRow31.getText().toString()) * 8)  +
                  (Integer.parseInt(btnRow32.getText().toString()) * 4 ) +
                  (Integer.parseInt(btnRow33.getText().toString()) * 2)  +
                  (Integer.parseInt(btnRow34.getText().toString()) * 1);

        String gn = btnRow35.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow3 = true;
            btnRow35.setBackgroundResource(R.drawable.button_bg);

        }else{

            isCompleteRow3 = false;
            btnRow35.setBackgroundResource(R.drawable.button_bg_2);

        }

        return isCompleteRow3;

    }

    //Check Row 4
    private boolean checkNumRow4(){

        int bin = (Integer.parseInt(btnRow41.getText().toString()) * 8)  +
                  (Integer.parseInt(btnRow42.getText().toString()) * 4 ) +
                  (Integer.parseInt(btnRow43.getText().toString()) * 2)  +
                  (Integer.parseInt(btnRow44.getText().toString()) * 1);

        String gn = btnRow45.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){
            isCompleteRow4 = true;
            btnRow45.setBackgroundResource(R.drawable.button_bg);
        }else{
            isCompleteRow4 = false;
            btnRow45.setBackgroundResource(R.drawable.button_bg_2);
        }


        return isCompleteRow4;

    }


    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){

            // Start Row 1
            case R.id.btnRowXE11:

                if(!row11First) {
                    btnRow11.setText("1");
                    btnRow11.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row11First = true;

                } else{
                    btnRow11.setText("0");
                    btnRow11.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row11First = false;

                }

                checkNumRow1();

                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow51.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow51.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE12:

                if(!row12First) {
                    btnRow12.setText("1");
                    btnRow12.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row12First = true;

                } else{
                    btnRow12.setText("0");
                    btnRow12.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row12First = false;

                }

                checkNumRow1();

                isCompleteVRow2 = checkNumVRow(1);
                if(isCompleteVRow2)
                    btnRow52.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow52.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE13:

                if(!row13First) {
                    btnRow13.setText("1");
                    btnRow13.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row13First = true;

                } else{
                    btnRow13.setText("0");
                    btnRow13.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row13First = false;

                }

                checkNumRow1();

                isCompleteVRow3 = checkNumVRow(2);
                if(isCompleteVRow3)
                    btnRow53.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow53.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE14:

                if(!row14First) {
                    btnRow14.setText("1");
                    btnRow14.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row14First = true;

                } else{
                    btnRow14.setText("0");
                    btnRow14.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row14First = false;

                }

                checkNumRow1();

                isCompleteVRow4 = checkNumVRow(3);
                if(isCompleteVRow4)
                    btnRow54.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow54.setBackgroundResource(R.drawable.button_bg_2);

                break;
            //End Row 1

            // Start Row 2
            case R.id.btnRowXE21:

                if(!row21First) {
                    btnRow21.setText("1");
                    btnRow21.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row21First = true;

                } else{
                    btnRow21.setText("0");
                    btnRow21.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row21First = false;

                }

                checkNumRow2();

                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow51.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow51.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE22:

                if(!row22First) {
                    btnRow22.setText("1");
                    btnRow22.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row22First = true;

                } else{
                    btnRow22.setText("0");
                    btnRow22.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row22First = false;

                }

                checkNumRow2();

                isCompleteVRow2 = checkNumVRow(1);
                if(isCompleteVRow2)
                    btnRow52.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow52.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE23:

                if(!row23First) {
                    btnRow23.setText("1");
                    btnRow23.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row23First = true;

                } else{
                    btnRow23.setText("0");
                    btnRow23.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row23First = false;

                }

                checkNumRow2();

                isCompleteVRow3 = checkNumVRow(2);

                if(isCompleteVRow3)
                    btnRow53.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow53.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE24:

                if(!row24First) {
                    btnRow24.setText("1");
                    btnRow24.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row24First = true;

                } else{
                    btnRow24.setText("0");
                    btnRow24.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row24First = false;
                }

                checkNumRow2();

                isCompleteVRow4 = checkNumVRow(3);

                if(isCompleteVRow4)
                    btnRow54.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow54.setBackgroundResource(R.drawable.button_bg_2);

                break;
            //End Row 2


            // Start Row 3
            case R.id.btnRowXE31:

                if(!row31First) {
                    btnRow31.setText("1");
                    btnRow31.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row31First = true;

                } else{
                    btnRow31.setText("0");
                    btnRow31.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row31First = false;

                }

                checkNumRow3();

                isCompleteVRow1 = checkNumVRow(0);

                if(isCompleteVRow1)
                    btnRow51.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow51.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE32:

                if(!row32First) {
                    btnRow32.setText("1");
                    btnRow32.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row32First = true;

                } else{
                    btnRow32.setText("0");
                    btnRow32.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row32First = false;

                }

                checkNumRow3();

                isCompleteVRow2 = checkNumVRow(1);

                if(isCompleteVRow2)
                    btnRow52.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow52.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE33:

                if(!row33First) {
                    btnRow33.setText("1");
                    btnRow33.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row33First = true;

                } else{
                    btnRow33.setText("0");
                    btnRow33.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row33First = false;

                }

                checkNumRow3();

                isCompleteVRow3 = checkNumVRow(2);
                if(isCompleteVRow3)
                    btnRow53.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow53.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE34:

                if(!row34First) {
                    btnRow34.setText("1");
                    btnRow34.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row34First = true;

                } else{
                    btnRow34.setText("0");
                    btnRow34.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row34First = false;

                }

                checkNumRow3();

                isCompleteVRow4 = checkNumVRow(3);
                if(isCompleteVRow4)
                    btnRow54.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow54.setBackgroundResource(R.drawable.button_bg_2);

                break;
            //End Row 3

            // Start Row 4
            case R.id.btnRowXE41:

                if(!row41First) {
                    btnRow41.setText("1");
                    btnRow41.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row41First = true;

                } else{
                    btnRow41.setText("0");
                    btnRow41.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row41First = false;

                }

                checkNumRow4();

                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow51.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow51.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE42:

                if(!row42First) {
                    btnRow42.setText("1");
                    btnRow42.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row42First = true;
                } else{
                    btnRow42.setText("0");
                    btnRow42.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row42First = false;
                }

                checkNumRow4();

                isCompleteVRow2 = checkNumVRow(1);
                if(isCompleteVRow2)
                    btnRow52.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow52.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE43:

                if(!row43First) {
                    btnRow43.setText("1");
                    btnRow43.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row43First = true;

                } else{
                    btnRow43.setText("0");
                    btnRow43.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row43First = false;

                }

                checkNumRow4();

                isCompleteVRow3 = checkNumVRow(2);
                if(isCompleteVRow3)
                    btnRow53.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow53.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXE44:

                if(!row44First) {
                    btnRow44.setText("1");
                    btnRow44.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row44First = true;

                } else{
                    btnRow44.setText("0");
                    btnRow44.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row44First = false;

                }

                checkNumRow4();

                isCompleteVRow4 = checkNumVRow(3);
                if(isCompleteVRow4)
                    btnRow54.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow54.setBackgroundResource(R.drawable.button_bg_2);

                break;
            //End Row 4

        }
        //when all are complete
        allRowCompleted();

    }
}
