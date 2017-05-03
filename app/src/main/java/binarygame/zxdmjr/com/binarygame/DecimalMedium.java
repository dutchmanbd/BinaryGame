package binarygame.zxdmjr.com.binarygame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Random;

import binarygame.zxdmjr.com.binarygame.objects.KeyWords;
import binarygame.zxdmjr.com.binarygame.objects.Numbers;
import binarygame.zxdmjr.com.binarygame.objects.Score;
import binarygame.zxdmjr.com.binarygame.objects.ScoreIntentData;

public class DecimalMedium extends AppCompatActivity implements View.OnClickListener {


    private Button btnRow11,btnRow12,btnRow13,btnRow14,btnRow15,btnRow16,btnRow17;
    private Button btnRow21,btnRow22,btnRow23,btnRow24,btnRow25,btnRow26,btnRow27;
    private Button btnRow31,btnRow32,btnRow33,btnRow34,btnRow35,btnRow36,btnRow37;
    private Button btnRow41,btnRow42,btnRow43,btnRow44,btnRow45,btnRow46,btnRow47;
    private Button btnRow51,btnRow52,btnRow53,btnRow54,btnRow55,btnRow56,btnRow57;
    private Button btnRow61,btnRow62,btnRow63,btnRow64,btnRow65,btnRow66,btnRow67;
    private Button btnRow71,btnRow72,btnRow73,btnRow74,btnRow75,btnRow76;

    private TextView tvTimer;

    private boolean row11First,row12First,row13First,row14First,row15First,row16First;
    private boolean row21First,row22First,row23First,row24First,row25First,row26First;
    private boolean row31First,row32First,row33First,row34First,row35First,row36First;
    private boolean row41First,row42First,row43First,row44First,row45First,row46First;
    private boolean row51First,row52First,row53First,row54First,row55First,row56First;
    private boolean row61First,row62First,row63First,row64First,row65First,row66First;

    private boolean isCompleteRow1,isCompleteRow2,isCompleteRow3,isCompleteRow4,isCompleteRow5,isCompleteRow6;
    private boolean isCompleteVRow1,isCompleteVRow2,isCompleteVRow3,isCompleteVRow4,isCompleteVRow5,isCompleteVRow6;

    private Numbers[] numbers;
    private int minTime;
    private int[] val = {32,16,8,4,2,1};


    private int countComplete = 0;
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
        setContentView(R.layout.activity_decimal_medium);

        getSupportActionBar().setTitle("Decimal");
        getSupportActionBar().setSubtitle("Medium");

        init();
    }

    private void init(){

        // Row 1
        btnRow11 = (Button) findViewById(R.id.btnRowM11);
        btnRow12 = (Button) findViewById(R.id.btnRowM12);
        btnRow13 = (Button) findViewById(R.id.btnRowM13);
        btnRow14 = (Button) findViewById(R.id.btnRowM14);
        btnRow15 = (Button) findViewById(R.id.btnRowM15);
        btnRow16 = (Button) findViewById(R.id.btnRowM16);
        btnRow17 = (Button) findViewById(R.id.btnRowM17);

        // Row 2
        btnRow21 = (Button) findViewById(R.id.btnRowM21);
        btnRow22 = (Button) findViewById(R.id.btnRowM22);
        btnRow23 = (Button) findViewById(R.id.btnRowM23);
        btnRow24 = (Button) findViewById(R.id.btnRowM24);
        btnRow25 = (Button) findViewById(R.id.btnRowM25);
        btnRow26 = (Button) findViewById(R.id.btnRowM26);
        btnRow27 = (Button) findViewById(R.id.btnRowM27);

        // Row 3
        btnRow31 = (Button) findViewById(R.id.btnRowM31);
        btnRow32 = (Button) findViewById(R.id.btnRowM32);
        btnRow33 = (Button) findViewById(R.id.btnRowM33);
        btnRow34 = (Button) findViewById(R.id.btnRowM34);
        btnRow35 = (Button) findViewById(R.id.btnRowM35);
        btnRow36 = (Button) findViewById(R.id.btnRowM36);
        btnRow37 = (Button) findViewById(R.id.btnRowM37);


        // Row 4
        btnRow41 = (Button) findViewById(R.id.btnRowM41);
        btnRow42 = (Button) findViewById(R.id.btnRowM42);
        btnRow43 = (Button) findViewById(R.id.btnRowM43);
        btnRow44 = (Button) findViewById(R.id.btnRowM44);
        btnRow45 = (Button) findViewById(R.id.btnRowM45);
        btnRow46 = (Button) findViewById(R.id.btnRowM46);
        btnRow47 = (Button) findViewById(R.id.btnRowM47);

        // Row 5
        btnRow51 = (Button) findViewById(R.id.btnRowM51);
        btnRow52 = (Button) findViewById(R.id.btnRowM52);
        btnRow53 = (Button) findViewById(R.id.btnRowM53);
        btnRow54 = (Button) findViewById(R.id.btnRowM54);
        btnRow55 = (Button) findViewById(R.id.btnRowM55);
        btnRow56 = (Button) findViewById(R.id.btnRowM56);
        btnRow57 = (Button) findViewById(R.id.btnRowM57);


        // Row 6
        btnRow61 = (Button) findViewById(R.id.btnRowM61);
        btnRow62 = (Button) findViewById(R.id.btnRowM62);
        btnRow63 = (Button) findViewById(R.id.btnRowM63);
        btnRow64 = (Button) findViewById(R.id.btnRowM64);
        btnRow65 = (Button) findViewById(R.id.btnRowM65);
        btnRow66 = (Button) findViewById(R.id.btnRowM66);
        btnRow67 = (Button) findViewById(R.id.btnRowM67);


        // Row 7
        btnRow71 = (Button) findViewById(R.id.btnRowM71);
        btnRow72 = (Button) findViewById(R.id.btnRowM72);
        btnRow73 = (Button) findViewById(R.id.btnRowM73);
        btnRow74 = (Button) findViewById(R.id.btnRowM74);
        btnRow75 = (Button) findViewById(R.id.btnRowM75);
        btnRow76 = (Button) findViewById(R.id.btnRowM76);


        //TextView Timer

        tvTimer  = (TextView) findViewById(R.id.tvTimerM);

        // Timer start
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);



        // Set Decimal Value on button
        Random rand;

        numbers = new Numbers[6];

        for(int i=1; i<=6; i++) {
            rand = new Random();

            int num = rand.nextInt(100000) % 64;

            numbers[i-1] = new Numbers(num,6);

            if(i == 1)
                btnRow17.setText(String.valueOf(num));
            else if(i == 2)
                btnRow27.setText(String.valueOf(num));
            else if(i == 3)
                btnRow37.setText(String.valueOf(num));
            else if(i == 4)
                btnRow47.setText(String.valueOf(num));
            else if(i == 5)
                btnRow57.setText(String.valueOf(num));
            else if(i == 6)
                btnRow67.setText(String.valueOf(num));
        }


        int decNum = 0;

        // Vertically set

        for(int row=0; row<6; row++) {
            decNum = 0;
            for (int col = 0; col < 6; col++) {
                decNum = decNum + numbers[col].getBinDigitAtPosition(row) * val[col];
            }
            if(row == 0)
                btnRow71.setText(String.valueOf(decNum));

            else if(row == 1)
                btnRow72.setText(String.valueOf(decNum));
            else if(row == 2)
                btnRow73.setText(String.valueOf(decNum));
            else if(row == 3)
                btnRow74.setText(String.valueOf(decNum));

            else if(row == 4)
                btnRow75.setText(String.valueOf(decNum));

            else if(row == 5)
                btnRow76.setText(String.valueOf(decNum));
        }


        // Actions row 1
        btnRow11.setOnClickListener(this);
        btnRow12.setOnClickListener(this);
        btnRow13.setOnClickListener(this);
        btnRow14.setOnClickListener(this);
        btnRow15.setOnClickListener(this);
        btnRow16.setOnClickListener(this);

        // Actions row 2
        btnRow21.setOnClickListener(this);
        btnRow22.setOnClickListener(this);
        btnRow23.setOnClickListener(this);
        btnRow24.setOnClickListener(this);
        btnRow25.setOnClickListener(this);
        btnRow26.setOnClickListener(this);

        // Actions row 3
        btnRow31.setOnClickListener(this);
        btnRow32.setOnClickListener(this);
        btnRow33.setOnClickListener(this);
        btnRow34.setOnClickListener(this);
        btnRow35.setOnClickListener(this);
        btnRow36.setOnClickListener(this);

        // Actions row 4
        btnRow41.setOnClickListener(this);
        btnRow42.setOnClickListener(this);
        btnRow43.setOnClickListener(this);
        btnRow44.setOnClickListener(this);
        btnRow45.setOnClickListener(this);
        btnRow46.setOnClickListener(this);


        // Actions row 5
        btnRow51.setOnClickListener(this);
        btnRow52.setOnClickListener(this);
        btnRow53.setOnClickListener(this);
        btnRow54.setOnClickListener(this);
        btnRow55.setOnClickListener(this);
        btnRow56.setOnClickListener(this);

        // Actions row 6
        btnRow61.setOnClickListener(this);
        btnRow62.setOnClickListener(this);
        btnRow63.setOnClickListener(this);
        btnRow64.setOnClickListener(this);
        btnRow65.setOnClickListener(this);
        btnRow66.setOnClickListener(this);


        // Check Given number if already matches when given number is 0
        checkNumRow1();
        checkNumRow2();
        checkNumRow3();
        checkNumRow4();
        checkNumRow5();
        checkNumRow6();

        // Check Giver number if already matches in vertical when given number is 0
        firstCheckInVertical();

        allRowCompleted();


    }


    // First check in vertical

    private void firstCheckInVertical(){

        if(btnRow71.getText().toString().equals("0")){
            isCompleteVRow1 = true;
            if(isCompleteVRow1)
                btnRow71.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow71.setBackgroundResource(R.drawable.button_bg_2);

        }

        if(btnRow72.getText().toString().equals("0")){
            isCompleteVRow2 = true;
            if(isCompleteVRow2)
                btnRow72.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow72.setBackgroundResource(R.drawable.button_bg_2);

        }

        if(btnRow73.getText().toString().equals("0")){
            isCompleteVRow3 = true;
            if(isCompleteVRow3)
                btnRow73.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow73.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow74.getText().toString().equals("0")){
            isCompleteVRow4 = true;
            if(isCompleteVRow4)
                btnRow74.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow74.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow75.getText().toString().equals("0")){
            isCompleteVRow5 = true;
            if(isCompleteVRow5)
                btnRow75.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow75.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow76.getText().toString().equals("0")){
            isCompleteVRow6 = true;
            if(isCompleteVRow6)
                btnRow76.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow76.setBackgroundResource(R.drawable.button_bg_2);
        }

    }



    // Check All row

    private void allRowCompleted(){

        if((isCompleteRow1 && isCompleteRow2 && isCompleteRow3 && isCompleteRow4 && isCompleteRow5 && isCompleteRow6)
                && (isCompleteVRow1 && isCompleteVRow2 && isCompleteVRow3 && isCompleteVRow4 && isCompleteVRow5 && isCompleteVRow6)
                ){

            String[] str = tvTimer.getText().toString().split(":");

            int temp = (Integer.parseInt(str[0].trim()) * 60) + (Integer.parseInt(str[1].trim()));

            Score score = new Score(getApplicationContext());

            score.setData(KeyWords.DEC_MEDIUM,temp);

            totalTime += temp;


            ScoreIntentData intentData = new ScoreIntentData(KeyWords.DEC_MEDIUM, Integer.toString(temp), Integer.toString(totalTime));

            Intent intent = new Intent(DecimalMedium.this,NextStepForEasy.class);
            intent.putExtra(KeyWords.INTENT_DATA, (Serializable) intentData);

//            Intent intent = new Intent(DecimalMedium.this,NextStepForEasy.class);
//            intent.putExtra(KeyWords.CONGRETS_MSG,"Congratulations!");
//            intent.putExtra(KeyWords.TIME_MSG,"Your total time for Decimal Medium round is:");
//            intent.putExtra(KeyWords.KEY_TYPE,KeyWords.DEC_MEDIUM);
//            intent.putExtra(KeyWords.TOTALTIME,totalTime);
            startActivity(intent);
            finish();
        }
    }

    // Check Vertically
    private boolean checkNumVRow(int j){

        int dNum = 0;

        int gNum = -1;

        switch(j) {

            case 0:

                dNum =  (Integer.parseInt(btnRow11.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow21.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow31.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow41.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow51.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow61.getText().toString()) * 1);

                gNum = Integer.parseInt(btnRow71.getText().toString().trim());
                break;

            case 1:

                dNum =  (Integer.parseInt(btnRow12.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow22.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow32.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow42.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow52.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow62.getText().toString()) * 1);

                gNum = Integer.parseInt(btnRow72.getText().toString().trim());
                break;

            case 2:

                dNum =  (Integer.parseInt(btnRow13.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow23.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow33.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow43.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow53.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow63.getText().toString()) * 1);

                gNum = Integer.parseInt(btnRow73.getText().toString().trim());
                break;

            case 3:

                dNum =  (Integer.parseInt(btnRow14.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow24.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow34.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow44.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow54.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow64.getText().toString()) * 1);

                gNum = Integer.parseInt(btnRow74.getText().toString().trim());
                break;

            case 4:

                dNum =  (Integer.parseInt(btnRow15.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow25.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow35.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow45.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow55.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow65.getText().toString()) * 1);

                gNum = Integer.parseInt(btnRow75.getText().toString().trim());
                break;

            case 5:
                dNum =  (Integer.parseInt(btnRow16.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow26.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow36.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow46.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow56.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow66.getText().toString()) * 1);

                gNum = Integer.parseInt(btnRow76.getText().toString().trim());
                break;

        }

        if(dNum == gNum){

            return true;

        } else{

            return false;
        }

    }

    // Row 1

    private boolean checkNumRow1(){

        // Row 1

        int r1[] = new int[6];

        r1[0] = Integer.parseInt(btnRow11.getText().toString());
        r1[1] = Integer.parseInt(btnRow12.getText().toString());
        r1[2] = Integer.parseInt(btnRow13.getText().toString());
        r1[3] = Integer.parseInt(btnRow14.getText().toString());
        r1[4] = Integer.parseInt(btnRow15.getText().toString());
        r1[5] = Integer.parseInt(btnRow16.getText().toString());

        int bin = 0;

        for(int row=0; row < 6; row++){

            bin = bin + r1[row] * val[row];
        }

        int gn = Integer.parseInt(btnRow17.getText().toString());

        if(bin == gn){

            isCompleteRow1 = true;

            //btnRow15.setBackgroundColor(0xff00ddff);
            btnRow17.setBackgroundResource(R.drawable.button_bg);


        } else{
            isCompleteRow1 = false;
            //btnRow15.setBackgroundColor(0xffff4444);
            btnRow17.setBackgroundResource(R.drawable.button_bg_2);

        }

        return isCompleteRow1;
    }

    //Row 2
    private boolean checkNumRow2(){

        int r2[] = new int[6];

        r2[0] = Integer.parseInt(btnRow21.getText().toString());
        r2[1] = Integer.parseInt(btnRow22.getText().toString());
        r2[2] = Integer.parseInt(btnRow23.getText().toString());
        r2[3] = Integer.parseInt(btnRow24.getText().toString());
        r2[4] = Integer.parseInt(btnRow25.getText().toString());
        r2[5] = Integer.parseInt(btnRow26.getText().toString());

        int bin = 0;

        for(int row=0; row < 6; row++){

            bin = bin + r2[row] * val[row];
        }

        int gn = Integer.parseInt(btnRow27.getText().toString());

        if(bin == gn){
            isCompleteRow2 = true;

            //btnRow25.setBackgroundColor(0xff00ddff);
            btnRow27.setBackgroundResource(R.drawable.button_bg);


        }else{
            isCompleteRow2 = false;
            //btnRow25.setBackgroundColor(0xffff4444);
            btnRow27.setBackgroundResource(R.drawable.button_bg_2);

        }


        return isCompleteRow2;
    }

    //Row 3
    private boolean checkNumRow3(){

        int r3[] = new int[6];

        r3[0] = Integer.parseInt(btnRow31.getText().toString());
        r3[1] = Integer.parseInt(btnRow32.getText().toString());
        r3[2] = Integer.parseInt(btnRow33.getText().toString());
        r3[3] = Integer.parseInt(btnRow34.getText().toString());
        r3[4] = Integer.parseInt(btnRow35.getText().toString());
        r3[5] = Integer.parseInt(btnRow36.getText().toString());

        int bin = 0;

        for(int row=0; row < 6; row++){

            bin = bin + r3[row] * val[row];
        }

        int gn = Integer.parseInt(btnRow37.getText().toString());

        if(bin == gn){
            isCompleteRow3 = true;
            //btnRow35.setBackgroundColor(0xff00ddff);
            btnRow37.setBackgroundResource(R.drawable.button_bg);


        }else{
            isCompleteRow3 = false;
            //btnRow35.setBackgroundColor(0xffff4444);
            btnRow37.setBackgroundResource(R.drawable.button_bg_2);

        }

        return isCompleteRow3;

    }

    //Row 4
    private boolean checkNumRow4(){

        int r4[] = new int[6];

        r4[0] = Integer.parseInt(btnRow41.getText().toString());
        r4[1] = Integer.parseInt(btnRow42.getText().toString());
        r4[2] = Integer.parseInt(btnRow43.getText().toString());
        r4[3] = Integer.parseInt(btnRow44.getText().toString());
        r4[4] = Integer.parseInt(btnRow45.getText().toString());
        r4[5] = Integer.parseInt(btnRow46.getText().toString());

        int bin = 0;

        for(int row=0; row < 6; row++){

            bin = bin + r4[row] * val[row];
        }

        int gn = Integer.parseInt(btnRow47.getText().toString());

        if(bin == gn){
            isCompleteRow4 = true;
            //btnRow45.setBackgroundColor(0xff00ddff);
            btnRow47.setBackgroundResource(R.drawable.button_bg);


        }else{
            isCompleteRow4 = false;
            //btnRow45.setBackgroundColor(0xffff4444);
            btnRow47.setBackgroundResource(R.drawable.button_bg_2);

        }


        return isCompleteRow4;

    }


    //Row 5
    private boolean checkNumRow5(){

        int r4[] = new int[6];

        r4[0] = Integer.parseInt(btnRow51.getText().toString());
        r4[1] = Integer.parseInt(btnRow52.getText().toString());
        r4[2] = Integer.parseInt(btnRow53.getText().toString());
        r4[3] = Integer.parseInt(btnRow54.getText().toString());
        r4[4] = Integer.parseInt(btnRow55.getText().toString());
        r4[5] = Integer.parseInt(btnRow56.getText().toString());

        int bin = 0;

        for(int row=0; row < 6; row++){

            bin = bin + r4[row] * val[row];
        }

        int gn = Integer.parseInt(btnRow57.getText().toString());

        if(bin == gn){
            isCompleteRow5 = true;
            //btnRow45.setBackgroundColor(0xff00ddff);
            btnRow57.setBackgroundResource(R.drawable.button_bg);


        }else{
            isCompleteRow5 = false;
            //btnRow45.setBackgroundColor(0xffff4444);
            btnRow57.setBackgroundResource(R.drawable.button_bg_2);

        }


        return isCompleteRow5;

    }


    //Row 6
    private boolean checkNumRow6(){

        int r4[] = new int[6];

        r4[0] = Integer.parseInt(btnRow61.getText().toString());
        r4[1] = Integer.parseInt(btnRow62.getText().toString());
        r4[2] = Integer.parseInt(btnRow63.getText().toString());
        r4[3] = Integer.parseInt(btnRow64.getText().toString());
        r4[4] = Integer.parseInt(btnRow65.getText().toString());
        r4[5] = Integer.parseInt(btnRow66.getText().toString());

        int bin = 0;

        for(int row=0; row < 6; row++){

            bin = bin + r4[row] * val[row];
        }

        int gn = Integer.parseInt(btnRow67.getText().toString());

        if(bin == gn){
            isCompleteRow6 = true;
            //btnRow45.setBackgroundColor(0xff00ddff);
            btnRow67.setBackgroundResource(R.drawable.button_bg);


        }else{
            isCompleteRow6 = false;
            //btnRow45.setBackgroundColor(0xffff4444);
            btnRow67.setBackgroundResource(R.drawable.button_bg_2);

        }


        return isCompleteRow6;

    }


    @Override
    public void onClick(View view) {

        int id = view.getId();


        switch (id){

            // Row 1
            case R.id.btnRowM11:

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

                // Vertically
                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow71.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow71.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM12:

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
                    btnRow72.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow72.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM13:

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
                    btnRow73.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow73.setBackgroundResource(R.drawable.button_bg_2);

                break;


            case R.id.btnRowM14:

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
                    btnRow74.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow74.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM15:

                if(!row15First) {
                    btnRow15.setText("1");
                    btnRow15.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row15First = true;

                } else{
                    btnRow15.setText("0");
                    btnRow15.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row15First = false;

                }
                checkNumRow1();

                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow75.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow75.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM16:

                if(!row16First) {
                    btnRow16.setText("1");
                    btnRow16.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row16First = true;
                } else{
                    btnRow16.setText("0");
                    btnRow16.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row16First = false;
                }
                checkNumRow1();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow76.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow76.setBackgroundResource(R.drawable.button_bg_2);

                break;

            // end row 1

            // Start Row 2
            case R.id.btnRowM21:

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
                    btnRow71.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow71.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM22:

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
                    btnRow72.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow72.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM23:

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
                    btnRow73.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow73.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM24:

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
                    btnRow74.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow74.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM25:

                if(!row25First) {
                    btnRow25.setText("1");
                    btnRow25.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row25First = true;
                } else{
                    btnRow25.setText("0");
                    btnRow25.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row25First = false;
                }

                checkNumRow2();

                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow75.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow75.setBackgroundResource(R.drawable.button_bg_2);
                break;

            case R.id.btnRowM26:

                if(!row26First) {
                    btnRow26.setText("1");
                    btnRow26.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row26First = true;
                } else{
                    btnRow26.setText("0");
                    btnRow26.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row26First = false;
                }

                checkNumRow2();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow76.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow76.setBackgroundResource(R.drawable.button_bg_2);
                break;

            // End Row 2


            // Start Row 3
            case R.id.btnRowM31:

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
                    btnRow71.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow71.setBackgroundResource(R.drawable.button_bg_2);
                break;

            case R.id.btnRowM32:

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
                    btnRow72.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow72.setBackgroundResource(R.drawable.button_bg_2);
                break;

            case R.id.btnRowM33:

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
                    btnRow73.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow73.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM34:

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
                    btnRow74.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow74.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM35:

                if(!row35First) {
                    btnRow35.setText("1");
                    btnRow35.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row35First = true;

                } else{
                    btnRow35.setText("0");
                    btnRow35.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row35First = false;
                }

                checkNumRow3();

                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow75.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow75.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM36:

                if(!row36First) {
                    btnRow36.setText("1");
                    btnRow36.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row36First = true;

                } else{
                    btnRow36.setText("0");
                    btnRow36.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row36First = false;
                }

                checkNumRow3();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow76.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow76.setBackgroundResource(R.drawable.button_bg_2);

                break;

            // End Row 3

            // Start Row 4
            case R.id.btnRowM41:

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
                    btnRow71.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow71.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM42:

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
                    btnRow72.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow72.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM43:

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
                    btnRow73.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow73.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM44:

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
                    btnRow74.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow74.setBackgroundResource(R.drawable.button_bg_2);

                break;


            case R.id.btnRowM45:

                if(!row45First) {
                    btnRow45.setText("1");
                    btnRow45.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row45First = true;

                } else{
                    btnRow45.setText("0");
                    btnRow45.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row45First = false;
                }

                checkNumRow4();

                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow75.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow75.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM46:

                if(!row46First) {
                    btnRow46.setText("1");
                    btnRow46.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row46First = true;

                } else{
                    btnRow46.setText("0");
                    btnRow46.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row46First = false;
                }

                checkNumRow4();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow76.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow76.setBackgroundResource(R.drawable.button_bg_2);

                break;

            // End Row 4


            // Start Row 5
            case R.id.btnRowM51:

                if(!row51First) {
                    btnRow51.setText("1");
                    btnRow51.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row51First = true;

                } else{
                    btnRow51.setText("0");
                    btnRow51.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row51First = false;
                }

                checkNumRow5();

                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow71.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow71.setBackgroundResource(R.drawable.button_bg_2);

                break;


            case R.id.btnRowM52:

                if(!row52First) {
                    btnRow52.setText("1");
                    btnRow52.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row52First = true;

                } else{
                    btnRow52.setText("0");
                    btnRow52.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row52First = false;
                }

                checkNumRow5();

                isCompleteVRow2 = checkNumVRow(1);
                if(isCompleteVRow2)
                    btnRow72.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow72.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM53:

                if(!row53First) {
                    btnRow53.setText("1");
                    btnRow53.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row53First = true;

                } else{
                    btnRow53.setText("0");
                    btnRow53.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row53First = false;
                }

                checkNumRow5();

                isCompleteVRow3 = checkNumVRow(2);
                if(isCompleteVRow3)
                    btnRow73.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow73.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM54:

                if(!row54First) {
                    btnRow54.setText("1");
                    btnRow54.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row54First = true;

                } else{
                    btnRow54.setText("0");
                    btnRow54.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row54First = false;
                }

                checkNumRow5();

                isCompleteVRow4 = checkNumVRow(3);
                if(isCompleteVRow4)
                    btnRow74.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow74.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM55:

                if(!row55First) {
                    btnRow55.setText("1");
                    btnRow55.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row55First = true;

                } else{
                    btnRow55.setText("0");
                    btnRow55.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row55First = false;
                }

                checkNumRow5();

                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow75.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow75.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM56:

                if(!row56First) {
                    btnRow56.setText("1");
                    btnRow56.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row56First = true;

                } else{
                    btnRow56.setText("0");
                    btnRow56.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row56First = false;
                }

                checkNumRow5();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow76.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow76.setBackgroundResource(R.drawable.button_bg_2);

                break;

            // End Row 5


            // Start Row 6

            case R.id.btnRowM61:

                if(!row61First) {
                    btnRow61.setText("1");
                    btnRow61.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row61First = true;

                } else{
                    btnRow61.setText("0");
                    btnRow61.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row61First = false;
                }

                checkNumRow6();

                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow71.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow71.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM62:

                if(!row62First) {
                    btnRow62.setText("1");
                    btnRow62.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row62First = true;

                } else{
                    btnRow62.setText("0");
                    btnRow62.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row62First = false;
                }

                checkNumRow6();
                isCompleteVRow2 = checkNumVRow(1);
                if(isCompleteVRow2)
                    btnRow72.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow72.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM63:

                if(!row63First) {
                    btnRow63.setText("1");
                    btnRow63.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row63First = true;

                } else{
                    btnRow63.setText("0");
                    btnRow63.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row63First = false;
                }

                checkNumRow6();

                isCompleteVRow3 = checkNumVRow(2);
                if(isCompleteVRow3)
                    btnRow73.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow73.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM64:

                if(!row64First) {
                    btnRow64.setText("1");
                    btnRow64.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row64First = true;

                } else{
                    btnRow64.setText("0");
                    btnRow64.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row64First = false;
                }

                checkNumRow6();

                isCompleteVRow4 = checkNumVRow(3);
                if(isCompleteVRow4)
                    btnRow74.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow74.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM65:

                if(!row65First) {
                    btnRow65.setText("1");
                    btnRow65.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row65First = true;

                } else{
                    btnRow65.setText("0");
                    btnRow65.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row65First = false;
                }

                checkNumRow6();
                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow75.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow75.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowM66:

                if(!row66First) {
                    btnRow66.setText("1");
                    btnRow66.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row66First = true;

                } else{
                    btnRow66.setText("0");
                    btnRow66.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row66First = false;
                }

                checkNumRow6();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow76.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow76.setBackgroundResource(R.drawable.button_bg_2);

                break;

            // End Row 6


        }

        allRowCompleted();

    }
}
