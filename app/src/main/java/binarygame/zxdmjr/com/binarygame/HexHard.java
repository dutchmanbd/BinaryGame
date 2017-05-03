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

public class HexHard extends AppCompatActivity implements View.OnClickListener {

    private Button btnRow11,btnRow12,btnRow13,btnRow14,btnRow15,btnRow16,btnRow17,btnRow18,btnRow19;
    private Button btnRow21,btnRow22,btnRow23,btnRow24,btnRow25,btnRow26,btnRow27,btnRow28,btnRow29;
    private Button btnRow31,btnRow32,btnRow33,btnRow34,btnRow35,btnRow36,btnRow37,btnRow38,btnRow39;
    private Button btnRow41,btnRow42,btnRow43,btnRow44,btnRow45,btnRow46,btnRow47,btnRow48,btnRow49;
    private Button btnRow51,btnRow52,btnRow53,btnRow54,btnRow55,btnRow56,btnRow57,btnRow58,btnRow59;
    private Button btnRow61,btnRow62,btnRow63,btnRow64,btnRow65,btnRow66,btnRow67,btnRow68,btnRow69;
    private Button btnRow71,btnRow72,btnRow73,btnRow74,btnRow75,btnRow76,btnRow77,btnRow78,btnRow79;
    private Button btnRow81,btnRow82,btnRow83,btnRow84,btnRow85,btnRow86,btnRow87,btnRow88,btnRow89;
    private Button btnRow91,btnRow92,btnRow93,btnRow94,btnRow95,btnRow96,btnRow97,btnRow98;

    private TextView tvTimer;

    private boolean row11First,row12First,row13First,row14First,row15First,row16First,row17First,row18First;
    private boolean row21First,row22First,row23First,row24First,row25First,row26First,row27First,row28First;
    private boolean row31First,row32First,row33First,row34First,row35First,row36First,row37First,row38First;
    private boolean row41First,row42First,row43First,row44First,row45First,row46First,row47First,row48First;
    private boolean row51First,row52First,row53First,row54First,row55First,row56First,row57First,row58First;
    private boolean row61First,row62First,row63First,row64First,row65First,row66First,row67First,row68First;
    private boolean row71First,row72First,row73First,row74First,row75First,row76First,row77First,row78First;
    private boolean row81First,row82First,row83First,row84First,row85First,row86First,row87First,row88First;

    private boolean isCompleteRow1,isCompleteRow2,isCompleteRow3,isCompleteRow4,isCompleteRow5,isCompleteRow6,isCompleteRow7,isCompleteRow8;
    private boolean isCompleteVRow1,isCompleteVRow2,isCompleteVRow3,isCompleteVRow4,isCompleteVRow5,isCompleteVRow6,isCompleteVRow7,isCompleteVRow8;

    private Numbers[] numbers;
    private int[] val = {128,64,32,16,8,4,2,1};


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
        setContentView(R.layout.activity_hex_hard);

        getSupportActionBar().setTitle("HexaDecimal");
        getSupportActionBar().setSubtitle("Hard");

        init();
    }


    private void init(){


        // Row 1
        btnRow11 = (Button) findViewById(R.id.btnRowXH11);
        btnRow12 = (Button) findViewById(R.id.btnRowXH12);
        btnRow13 = (Button) findViewById(R.id.btnRowXH13);
        btnRow14 = (Button) findViewById(R.id.btnRowXH14);
        btnRow15 = (Button) findViewById(R.id.btnRowXH15);
        btnRow16 = (Button) findViewById(R.id.btnRowXH16);
        btnRow17 = (Button) findViewById(R.id.btnRowXH17);
        btnRow18 = (Button) findViewById(R.id.btnRowXH18);
        btnRow19 = (Button) findViewById(R.id.btnRowXH19);

        // Row 2
        btnRow21 = (Button) findViewById(R.id.btnRowXH21);
        btnRow22 = (Button) findViewById(R.id.btnRowXH22);
        btnRow23 = (Button) findViewById(R.id.btnRowXH23);
        btnRow24 = (Button) findViewById(R.id.btnRowXH24);
        btnRow25 = (Button) findViewById(R.id.btnRowXH25);
        btnRow26 = (Button) findViewById(R.id.btnRowXH26);
        btnRow27 = (Button) findViewById(R.id.btnRowXH27);
        btnRow28 = (Button) findViewById(R.id.btnRowXH28);
        btnRow29 = (Button) findViewById(R.id.btnRowXH29);

        // Row 3
        btnRow31 = (Button) findViewById(R.id.btnRowXH31);
        btnRow32 = (Button) findViewById(R.id.btnRowXH32);
        btnRow33 = (Button) findViewById(R.id.btnRowXH33);
        btnRow34 = (Button) findViewById(R.id.btnRowXH34);
        btnRow35 = (Button) findViewById(R.id.btnRowXH35);
        btnRow36 = (Button) findViewById(R.id.btnRowXH36);
        btnRow37 = (Button) findViewById(R.id.btnRowXH37);
        btnRow38 = (Button) findViewById(R.id.btnRowXH38);
        btnRow39 = (Button) findViewById(R.id.btnRowXH39);


        // Row 4
        btnRow41 = (Button) findViewById(R.id.btnRowXH41);
        btnRow42 = (Button) findViewById(R.id.btnRowXH42);
        btnRow43 = (Button) findViewById(R.id.btnRowXH43);
        btnRow44 = (Button) findViewById(R.id.btnRowXH44);
        btnRow45 = (Button) findViewById(R.id.btnRowXH45);
        btnRow46 = (Button) findViewById(R.id.btnRowXH46);
        btnRow47 = (Button) findViewById(R.id.btnRowXH47);
        btnRow48 = (Button) findViewById(R.id.btnRowXH48);
        btnRow49 = (Button) findViewById(R.id.btnRowXH49);

        // Row 5
        btnRow51 = (Button) findViewById(R.id.btnRowXH51);
        btnRow52 = (Button) findViewById(R.id.btnRowXH52);
        btnRow53 = (Button) findViewById(R.id.btnRowXH53);
        btnRow54 = (Button) findViewById(R.id.btnRowXH54);
        btnRow55 = (Button) findViewById(R.id.btnRowXH55);
        btnRow56 = (Button) findViewById(R.id.btnRowXH56);
        btnRow57 = (Button) findViewById(R.id.btnRowXH57);
        btnRow58 = (Button) findViewById(R.id.btnRowXH58);
        btnRow59 = (Button) findViewById(R.id.btnRowXH59);


        // Row 6
        btnRow61 = (Button) findViewById(R.id.btnRowXH61);
        btnRow62 = (Button) findViewById(R.id.btnRowXH62);
        btnRow63 = (Button) findViewById(R.id.btnRowXH63);
        btnRow64 = (Button) findViewById(R.id.btnRowXH64);
        btnRow65 = (Button) findViewById(R.id.btnRowXH65);
        btnRow66 = (Button) findViewById(R.id.btnRowXH66);
        btnRow67 = (Button) findViewById(R.id.btnRowXH67);
        btnRow68 = (Button) findViewById(R.id.btnRowXH68);
        btnRow69 = (Button) findViewById(R.id.btnRowXH69);


        // Row 7
        btnRow71 = (Button) findViewById(R.id.btnRowXH71);
        btnRow72 = (Button) findViewById(R.id.btnRowXH72);
        btnRow73 = (Button) findViewById(R.id.btnRowXH73);
        btnRow74 = (Button) findViewById(R.id.btnRowXH74);
        btnRow75 = (Button) findViewById(R.id.btnRowXH75);
        btnRow76 = (Button) findViewById(R.id.btnRowXH76);
        btnRow77 = (Button) findViewById(R.id.btnRowXH77);
        btnRow78 = (Button) findViewById(R.id.btnRowXH78);
        btnRow79 = (Button) findViewById(R.id.btnRowXH79);


        // Row 8
        btnRow81 = (Button) findViewById(R.id.btnRowXH81);
        btnRow82 = (Button) findViewById(R.id.btnRowXH82);
        btnRow83 = (Button) findViewById(R.id.btnRowXH83);
        btnRow84 = (Button) findViewById(R.id.btnRowXH84);
        btnRow85 = (Button) findViewById(R.id.btnRowXH85);
        btnRow86 = (Button) findViewById(R.id.btnRowXH86);
        btnRow87 = (Button) findViewById(R.id.btnRowXH87);
        btnRow88 = (Button) findViewById(R.id.btnRowXH88);
        btnRow89 = (Button) findViewById(R.id.btnRowXH89);


        // Row 9
        btnRow91 = (Button) findViewById(R.id.btnRowXH91);
        btnRow92 = (Button) findViewById(R.id.btnRowXH92);
        btnRow93 = (Button) findViewById(R.id.btnRowXH93);
        btnRow94 = (Button) findViewById(R.id.btnRowXH94);
        btnRow95 = (Button) findViewById(R.id.btnRowXH95);
        btnRow96 = (Button) findViewById(R.id.btnRowXH96);
        btnRow97 = (Button) findViewById(R.id.btnRowXH97);
        btnRow98 = (Button) findViewById(R.id.btnRowXH98);


        //TextView Timer

        tvTimer  = (TextView) findViewById(R.id.tvTimerXH);


        // Timer start
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);


        // Set Decimal Value on button
        Random rand;

        numbers = new Numbers[8];

        for(int i=1; i<=8; i++) {
            rand = new Random();

            int num = rand.nextInt(1000000000) % 256;

            numbers[i-1] = new Numbers(num,8);

            String hex = Integer.toHexString(num).toUpperCase();

            if(i == 1)
                btnRow19.setText(hex);
            else if(i == 2)
                btnRow29.setText(hex);
            else if(i == 3)
                btnRow39.setText(hex);
            else if(i == 4)
                btnRow49.setText(hex);
            else if(i == 5)
                btnRow59.setText(hex);
            else if(i == 6)
                btnRow69.setText(hex);
            else if(i == 7)
                btnRow79.setText(hex);
            else if(i == 8)
                btnRow89.setText(hex);

        }


        int decNum = 0;

        //Vertically Set

        for(int row=0; row<8; row++) {

            decNum = 0;

            for (int col = 0; col < 8; col++) {
                decNum = decNum + numbers[col].getBinDigitAtPosition(row) * val[col];
            }

            String hex = Integer.toHexString(decNum).toUpperCase();

            if(row == 0)
                btnRow91.setText(hex);

            else if(row == 1)
                btnRow92.setText(hex);

            else if(row == 2)
                btnRow93.setText(hex);

            else if(row == 3)
                btnRow94.setText(hex);

            else if(row == 4)
                btnRow95.setText(hex);

            else if(row == 5)
                btnRow96.setText(hex);

            else if(row == 6)
                btnRow97.setText(hex);

            else if(row == 7)
                btnRow98.setText(hex);



            // Actions row 1
            btnRow11.setOnClickListener(this);
            btnRow12.setOnClickListener(this);
            btnRow13.setOnClickListener(this);
            btnRow14.setOnClickListener(this);
            btnRow15.setOnClickListener(this);
            btnRow16.setOnClickListener(this);
            btnRow17.setOnClickListener(this);
            btnRow18.setOnClickListener(this);

            // Actions row 2
            btnRow21.setOnClickListener(this);
            btnRow22.setOnClickListener(this);
            btnRow23.setOnClickListener(this);
            btnRow24.setOnClickListener(this);
            btnRow25.setOnClickListener(this);
            btnRow26.setOnClickListener(this);
            btnRow27.setOnClickListener(this);
            btnRow28.setOnClickListener(this);

            // Actions row 3
            btnRow31.setOnClickListener(this);
            btnRow32.setOnClickListener(this);
            btnRow33.setOnClickListener(this);
            btnRow34.setOnClickListener(this);
            btnRow35.setOnClickListener(this);
            btnRow36.setOnClickListener(this);
            btnRow37.setOnClickListener(this);
            btnRow38.setOnClickListener(this);

            // Actions row 4
            btnRow41.setOnClickListener(this);
            btnRow42.setOnClickListener(this);
            btnRow43.setOnClickListener(this);
            btnRow44.setOnClickListener(this);
            btnRow45.setOnClickListener(this);
            btnRow46.setOnClickListener(this);
            btnRow47.setOnClickListener(this);
            btnRow48.setOnClickListener(this);


            // Actions row 5
            btnRow51.setOnClickListener(this);
            btnRow52.setOnClickListener(this);
            btnRow53.setOnClickListener(this);
            btnRow54.setOnClickListener(this);
            btnRow55.setOnClickListener(this);
            btnRow56.setOnClickListener(this);
            btnRow57.setOnClickListener(this);
            btnRow58.setOnClickListener(this);

            // Actions row 6
            btnRow61.setOnClickListener(this);
            btnRow62.setOnClickListener(this);
            btnRow63.setOnClickListener(this);
            btnRow64.setOnClickListener(this);
            btnRow65.setOnClickListener(this);
            btnRow66.setOnClickListener(this);
            btnRow67.setOnClickListener(this);
            btnRow68.setOnClickListener(this);


            // Actions row 7
            btnRow71.setOnClickListener(this);
            btnRow72.setOnClickListener(this);
            btnRow73.setOnClickListener(this);
            btnRow74.setOnClickListener(this);
            btnRow75.setOnClickListener(this);
            btnRow76.setOnClickListener(this);
            btnRow77.setOnClickListener(this);
            btnRow78.setOnClickListener(this);

            // Actions row 8
            btnRow81.setOnClickListener(this);
            btnRow82.setOnClickListener(this);
            btnRow83.setOnClickListener(this);
            btnRow84.setOnClickListener(this);
            btnRow85.setOnClickListener(this);
            btnRow86.setOnClickListener(this);
            btnRow87.setOnClickListener(this);
            btnRow88.setOnClickListener(this);

        }



        // Check Given number if already matches when given number is 0
        checkNumRow1();
        checkNumRow2();
        checkNumRow3();
        checkNumRow4();
        checkNumRow5();
        checkNumRow6();
        checkNumRow7();
        checkNumRow8();

        // Check Giver number if already matches in vertical when given number is 0
        firstCheckInVertical();

        allRowCompleted();

    }

    // First check in vertical

    private void firstCheckInVertical(){

        if(btnRow91.getText().toString().equals("0")){
            isCompleteVRow1 = true;
            if(isCompleteVRow1)
                btnRow91.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow91.setBackgroundResource(R.drawable.button_bg_2);

        }

        if(btnRow92.getText().toString().equals("0")){
            isCompleteVRow2 = true;
            if(isCompleteVRow2)
                btnRow92.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow92.setBackgroundResource(R.drawable.button_bg_2);

        }

        if(btnRow93.getText().toString().equals("0")){
            isCompleteVRow3 = true;
            if(isCompleteVRow3)
                btnRow93.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow93.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow94.getText().toString().equals("0")){
            isCompleteVRow4 = true;
            if(isCompleteVRow4)
                btnRow94.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow94.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow95.getText().toString().equals("0")){
            isCompleteVRow5 = true;
            if(isCompleteVRow5)
                btnRow95.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow95.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow96.getText().toString().equals("0")){
            isCompleteVRow6 = true;
            if(isCompleteVRow6)
                btnRow96.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow96.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow97.getText().toString().equals("0")){
            isCompleteVRow7 = true;
            if(isCompleteVRow7)
                btnRow97.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow97.setBackgroundResource(R.drawable.button_bg_2);
        }

        if(btnRow98.getText().toString().equals("0")){

            isCompleteVRow8 = true;

            if(isCompleteVRow8)
                btnRow98.setBackgroundResource(R.drawable.button_bg);
            else
                btnRow98.setBackgroundResource(R.drawable.button_bg_2);
        }

    }


    // Check All row

    private void allRowCompleted(){

        if((isCompleteRow1 && isCompleteRow2 && isCompleteRow3 && isCompleteRow4 && isCompleteRow5 && isCompleteRow6 && isCompleteRow7 && isCompleteRow8)
                && (isCompleteVRow1 && isCompleteVRow2 && isCompleteVRow3 && isCompleteVRow4 && isCompleteVRow5 && isCompleteVRow6 && isCompleteVRow7 && isCompleteVRow8)
                ){

            String[] str = tvTimer.getText().toString().split(":");

            int temp = (Integer.parseInt(str[0].trim()) * 60) + (Integer.parseInt(str[1].trim()));

            Score score = new Score(getApplicationContext());

            score.setData(KeyWords.HEX_HARD,temp);

            totalTime += temp;


            ScoreIntentData intentData = new ScoreIntentData(KeyWords.HEX_HARD, Integer.toString(temp), Integer.toString(totalTime));

            Intent intent = new Intent(HexHard.this,NextStepForEasy.class);
            intent.putExtra(KeyWords.INTENT_DATA, (Serializable) intentData);

//            Intent intent = new Intent(HexHard.this,NextStepForEasy.class);
//            intent.putExtra(KeyWords.CONGRETS_MSG,"Congratulations!");
//            intent.putExtra(KeyWords.TIME_MSG,"Your total time for Hex Hard round is:");
//            intent.putExtra(KeyWords.KEY_TYPE,KeyWords.HEX_HARD);
//            intent.putExtra(KeyWords.TOTALTIME,totalTime);
            startActivity(intent);
            finish();
        }
    }

    // Check in Vertical

    private boolean checkNumVRow(int j){

        int dNum = 0;
        String gNum = "";
        String hex = "0";

        switch(j) {

            case 0:

                dNum =  (Integer.parseInt(btnRow11.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow21.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow31.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow41.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow51.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow61.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow71.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow81.getText().toString()) * 1);

                gNum = btnRow91.getText().toString();
                break;

            case 1:

                dNum =  (Integer.parseInt(btnRow12.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow22.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow32.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow42.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow52.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow62.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow72.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow82.getText().toString()) * 1);

                gNum = btnRow92.getText().toString();
                break;

            case 2:

                dNum =  (Integer.parseInt(btnRow13.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow23.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow33.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow43.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow53.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow63.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow73.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow83.getText().toString()) * 1);

                gNum = btnRow93.getText().toString();
                break;

            case 3:

                dNum =  (Integer.parseInt(btnRow14.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow24.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow34.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow44.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow54.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow64.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow74.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow84.getText().toString()) * 1);

                gNum = btnRow94.getText().toString();
                break;

            case 4:

                dNum =  (Integer.parseInt(btnRow15.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow25.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow35.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow45.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow55.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow65.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow75.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow85.getText().toString()) * 1);

                gNum = btnRow95.getText().toString();
                break;

            case 5:
                dNum =  (Integer.parseInt(btnRow16.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow26.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow36.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow46.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow56.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow66.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow76.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow86.getText().toString()) * 1);

                gNum = btnRow96.getText().toString();
                break;

            case 6:
                dNum =  (Integer.parseInt(btnRow17.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow27.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow37.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow47.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow57.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow67.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow77.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow87.getText().toString()) * 1);

                gNum = btnRow97.getText().toString();
                break;

            case 7:
                dNum =  (Integer.parseInt(btnRow18.getText().toString()) * 128) +
                        (Integer.parseInt(btnRow28.getText().toString()) * 64) +
                        (Integer.parseInt(btnRow38.getText().toString()) * 32) +
                        (Integer.parseInt(btnRow48.getText().toString()) * 16) +
                        (Integer.parseInt(btnRow58.getText().toString()) * 8) +
                        (Integer.parseInt(btnRow68.getText().toString()) * 4) +
                        (Integer.parseInt(btnRow78.getText().toString()) * 2) +
                        (Integer.parseInt(btnRow88.getText().toString()) * 1);

                gNum = btnRow98.getText().toString();
                break;

        }

        hex = Integer.toHexString(dNum).toUpperCase();

        if(hex.equals(gNum)){

            return true;

        } else{

            return false;
        }

    }

    // Row 1
    private boolean checkNumRow1(){

        // Row 1

        int r1[] = new int[8];

        r1[0] = Integer.parseInt(btnRow11.getText().toString());
        r1[1] = Integer.parseInt(btnRow12.getText().toString());
        r1[2] = Integer.parseInt(btnRow13.getText().toString());
        r1[3] = Integer.parseInt(btnRow14.getText().toString());
        r1[4] = Integer.parseInt(btnRow15.getText().toString());
        r1[5] = Integer.parseInt(btnRow16.getText().toString());
        r1[6] = Integer.parseInt(btnRow17.getText().toString());
        r1[7] = Integer.parseInt(btnRow18.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r1[row] * val[row];
        }

        String gn = btnRow19.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow1 = true;
            btnRow19.setBackgroundResource(R.drawable.button_bg);

        } else{

            isCompleteRow1 = false;
            btnRow19.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow1;
    }

    //Row 2
    private boolean checkNumRow2(){

        int r2[] = new int[8];

        r2[0] = Integer.parseInt(btnRow21.getText().toString());
        r2[1] = Integer.parseInt(btnRow22.getText().toString());
        r2[2] = Integer.parseInt(btnRow23.getText().toString());
        r2[3] = Integer.parseInt(btnRow24.getText().toString());
        r2[4] = Integer.parseInt(btnRow25.getText().toString());
        r2[5] = Integer.parseInt(btnRow26.getText().toString());
        r2[6] = Integer.parseInt(btnRow27.getText().toString());
        r2[7] = Integer.parseInt(btnRow28.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r2[row] * val[row];
        }

        String gn = btnRow29.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){
            isCompleteRow2 = true;
            btnRow29.setBackgroundResource(R.drawable.button_bg);

        }else{

            isCompleteRow2 = false;
            btnRow29.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow2;
    }

    //Row 3
    private boolean checkNumRow3(){

        int r3[] = new int[8];

        r3[0] = Integer.parseInt(btnRow31.getText().toString());
        r3[1] = Integer.parseInt(btnRow32.getText().toString());
        r3[2] = Integer.parseInt(btnRow33.getText().toString());
        r3[3] = Integer.parseInt(btnRow34.getText().toString());
        r3[4] = Integer.parseInt(btnRow35.getText().toString());
        r3[5] = Integer.parseInt(btnRow36.getText().toString());
        r3[6] = Integer.parseInt(btnRow37.getText().toString());
        r3[7] = Integer.parseInt(btnRow38.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r3[row] * val[row];
        }

        String gn = btnRow39.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow3 = true;
            btnRow39.setBackgroundResource(R.drawable.button_bg);

        }else{

            isCompleteRow3 = false;
            btnRow39.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow3;

    }

    //Row 4
    private boolean checkNumRow4(){

        int r4[] = new int[8];

        r4[0] = Integer.parseInt(btnRow41.getText().toString());
        r4[1] = Integer.parseInt(btnRow42.getText().toString());
        r4[2] = Integer.parseInt(btnRow43.getText().toString());
        r4[3] = Integer.parseInt(btnRow44.getText().toString());
        r4[4] = Integer.parseInt(btnRow45.getText().toString());
        r4[5] = Integer.parseInt(btnRow46.getText().toString());
        r4[6] = Integer.parseInt(btnRow47.getText().toString());
        r4[7] = Integer.parseInt(btnRow48.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r4[row] * val[row];
        }

        String gn = btnRow49.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow4 = true;
            btnRow49.setBackgroundResource(R.drawable.button_bg);

        }else{

            isCompleteRow4 = false;
            btnRow49.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow4;

    }

    //Row 5
    private boolean checkNumRow5(){

        int r4[] = new int[8];

        r4[0] = Integer.parseInt(btnRow51.getText().toString());
        r4[1] = Integer.parseInt(btnRow52.getText().toString());
        r4[2] = Integer.parseInt(btnRow53.getText().toString());
        r4[3] = Integer.parseInt(btnRow54.getText().toString());
        r4[4] = Integer.parseInt(btnRow55.getText().toString());
        r4[5] = Integer.parseInt(btnRow56.getText().toString());
        r4[6] = Integer.parseInt(btnRow57.getText().toString());
        r4[7] = Integer.parseInt(btnRow58.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r4[row] * val[row];
        }

        String gn = btnRow59.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow5 = true;
            btnRow59.setBackgroundResource(R.drawable.button_bg);

        }else{
            isCompleteRow5 = false;
            btnRow59.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow5;
    }

    //Row 6
    private boolean checkNumRow6(){

        int r4[] = new int[8];

        r4[0] = Integer.parseInt(btnRow61.getText().toString());
        r4[1] = Integer.parseInt(btnRow62.getText().toString());
        r4[2] = Integer.parseInt(btnRow63.getText().toString());
        r4[3] = Integer.parseInt(btnRow64.getText().toString());
        r4[4] = Integer.parseInt(btnRow65.getText().toString());
        r4[5] = Integer.parseInt(btnRow66.getText().toString());
        r4[6] = Integer.parseInt(btnRow67.getText().toString());
        r4[7] = Integer.parseInt(btnRow68.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r4[row] * val[row];
        }

        String gn = btnRow69.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow6 = true;
            btnRow69.setBackgroundResource(R.drawable.button_bg);

        }else{

            isCompleteRow6 = false;
            btnRow69.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow6;
    }

    //Row 7
    private boolean checkNumRow7(){

        int r[] = new int[8];

        r[0] = Integer.parseInt(btnRow71.getText().toString());
        r[1] = Integer.parseInt(btnRow72.getText().toString());
        r[2] = Integer.parseInt(btnRow73.getText().toString());
        r[3] = Integer.parseInt(btnRow74.getText().toString());
        r[4] = Integer.parseInt(btnRow75.getText().toString());
        r[5] = Integer.parseInt(btnRow76.getText().toString());
        r[6] = Integer.parseInt(btnRow77.getText().toString());
        r[7] = Integer.parseInt(btnRow78.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r[row] * val[row];
        }

        String gn = btnRow79.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow7 = true;
            btnRow79.setBackgroundResource(R.drawable.button_bg);

        }else{

            isCompleteRow7 = false;
            btnRow79.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow7;
    }

    //Row 8
    private boolean checkNumRow8(){

        int r[] = new int[8];

        r[0] = Integer.parseInt(btnRow81.getText().toString());
        r[1] = Integer.parseInt(btnRow82.getText().toString());
        r[2] = Integer.parseInt(btnRow83.getText().toString());
        r[3] = Integer.parseInt(btnRow84.getText().toString());
        r[4] = Integer.parseInt(btnRow85.getText().toString());
        r[5] = Integer.parseInt(btnRow86.getText().toString());
        r[6] = Integer.parseInt(btnRow87.getText().toString());
        r[7] = Integer.parseInt(btnRow88.getText().toString());

        int bin = 0;

        for(int row=0; row < 8; row++){

            bin = bin + r[row] * val[row];
        }

        String gn = btnRow89.getText().toString();

        String hex = Integer.toHexString(bin).toUpperCase();

        if(hex.equals(gn)){

            isCompleteRow8 = true;
            btnRow89.setBackgroundResource(R.drawable.button_bg);

        }else{

            isCompleteRow8 = false;
            btnRow89.setBackgroundResource(R.drawable.button_bg_2);
        }

        return isCompleteRow8;
    }


    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){
            // Row 1
            case R.id.btnRowXH11:

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
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH12:

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
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH13:

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
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH14:

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
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH15:

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
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH16:

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
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH17:

                if(!row17First) {
                    btnRow17.setText("1");
                    btnRow17.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row17First = true;

                } else{
                    btnRow17.setText("0");
                    btnRow17.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row17First = false;
                }

                checkNumRow1();

                isCompleteVRow7 = checkNumVRow(6);

                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;
            case R.id.btnRowXH18:

                if(!row18First) {
                    btnRow18.setText("1");
                    btnRow18.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row18First = true;

                } else{
                    btnRow18.setText("0");
                    btnRow18.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row18First = false;
                }

                checkNumRow1();

                isCompleteVRow8 = checkNumVRow(7);

                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;

            // End Row 1

            // Start Row 2
            case R.id.btnRowXH21:

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
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH22:

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
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH23:

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
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH24:

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
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH25:

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
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH26:

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
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH27:

                if(!row27First) {
                    btnRow27.setText("1");
                    btnRow27.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row27First = true;

                } else{
                    btnRow27.setText("0");
                    btnRow27.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row27First = false;

                }

                checkNumRow2();

                isCompleteVRow7 = checkNumVRow(6);

                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH28:

                if(!row28First) {
                    btnRow28.setText("1");
                    btnRow28.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row28First = true;

                } else{
                    btnRow28.setText("0");
                    btnRow28.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row28First = false;

                }

                checkNumRow2();

                isCompleteVRow8 = checkNumVRow(7);

                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;

            //End row 2


            // Start Row 3
            case R.id.btnRowXH31:

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
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH32:

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
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH33:

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
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH34:

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
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH35:

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
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH36:

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
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH37:

                if(!row37First) {
                    btnRow37.setText("1");
                    btnRow37.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row37First = true;

                } else{
                    btnRow37.setText("0");
                    btnRow37.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row37First = false;

                }

                checkNumRow3();

                isCompleteVRow7 = checkNumVRow(6);
                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH38:

                if(!row38First) {
                    btnRow38.setText("1");
                    btnRow38.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row38First = true;

                } else{
                    btnRow38.setText("0");
                    btnRow38.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row38First = false;

                }

                checkNumRow3();

                isCompleteVRow8 = checkNumVRow(7);
                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;

            //End row 3


            // Start Row 4
            case R.id.btnRowXH41:

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
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH42:

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
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH43:

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
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH44:

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
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH45:

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
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH46:

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
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH47:

                if(!row47First) {
                    btnRow47.setText("1");
                    btnRow47.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row47First = true;

                } else{
                    btnRow47.setText("0");
                    btnRow47.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row47First = false;

                }

                checkNumRow4();

                isCompleteVRow7 = checkNumVRow(6);
                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH48:

                if(!row48First) {
                    btnRow48.setText("1");
                    btnRow48.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row48First = true;

                } else{
                    btnRow48.setText("0");
                    btnRow48.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row48First = false;

                }

                checkNumRow4();

                isCompleteVRow8 = checkNumVRow(7);
                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;

            //End row 4


            // Start Row 5
            case R.id.btnRowXH51:

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
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH52:

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
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH53:

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
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH54:

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
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH55:

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
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH56:

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
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH57:

                if(!row57First) {
                    btnRow57.setText("1");
                    btnRow57.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row57First = true;

                } else{
                    btnRow57.setText("0");
                    btnRow57.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row57First = false;
                }
                checkNumRow5();

                isCompleteVRow7 = checkNumVRow(6);
                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH58:

                if(!row58First) {
                    btnRow58.setText("1");
                    btnRow58.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row58First = true;

                } else{
                    btnRow58.setText("0");
                    btnRow58.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row58First = false;
                }
                checkNumRow5();

                isCompleteVRow8 = checkNumVRow(7);
                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;

            //End Row 5


            //Start Row 6
            case R.id.btnRowXH61:

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
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH62:

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
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH63:

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
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH64:

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
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH65:

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
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH66:

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
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH67:

                if(!row67First) {
                    btnRow67.setText("1");
                    btnRow67.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row67First = true;

                } else{
                    btnRow67.setText("0");
                    btnRow67.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row67First = false;
                }
                checkNumRow6();

                isCompleteVRow7 = checkNumVRow(6);
                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH68:

                if(!row68First) {
                    btnRow68.setText("1");
                    btnRow68.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row68First = true;

                } else{
                    btnRow68.setText("0");
                    btnRow68.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row68First = false;
                }
                checkNumRow6();

                isCompleteVRow8 = checkNumVRow(7);
                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;

            //End Row 6


            // Start Row 7

            case R.id.btnRowXH71:

                if(!row71First) {
                    btnRow71.setText("1");
                    btnRow71.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row71First = true;

                } else{
                    btnRow71.setText("0");
                    btnRow71.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row71First = false;
                }
                checkNumRow7();

                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH72:

                if(!row72First) {
                    btnRow72.setText("1");
                    btnRow72.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row72First = true;

                } else{
                    btnRow72.setText("0");
                    btnRow72.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row72First = false;
                }
                checkNumRow7();

                isCompleteVRow2 = checkNumVRow(1);
                if(isCompleteVRow2)
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH73:

                if(!row73First) {
                    btnRow73.setText("1");
                    btnRow73.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row73First = true;

                } else{
                    btnRow73.setText("0");
                    btnRow73.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row73First = false;
                }
                checkNumRow7();

                isCompleteVRow3 = checkNumVRow(2);
                if(isCompleteVRow3)
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH74:

                if(!row74First) {
                    btnRow74.setText("1");
                    btnRow74.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row74First = true;

                } else{
                    btnRow74.setText("0");
                    btnRow74.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row74First = false;
                }
                checkNumRow7();

                isCompleteVRow4 = checkNumVRow(3);
                if(isCompleteVRow4)
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH75:

                if(!row75First) {
                    btnRow75.setText("1");
                    btnRow75.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row75First = true;

                } else{
                    btnRow75.setText("0");
                    btnRow75.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row75First = false;
                }
                checkNumRow7();

                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH76:

                if(!row76First) {
                    btnRow76.setText("1");
                    btnRow76.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row76First = true;
                } else{
                    btnRow76.setText("0");
                    btnRow76.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row76First = false;
                }
                checkNumRow7();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH77:

                if(!row77First) {
                    btnRow77.setText("1");
                    btnRow77.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row77First = true;

                } else{
                    btnRow77.setText("0");
                    btnRow77.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row77First = false;
                }
                checkNumRow7();

                isCompleteVRow7 = checkNumVRow(6);
                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH78:

                if(!row78First) {
                    btnRow78.setText("1");
                    btnRow78.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row78First = true;

                } else{
                    btnRow78.setText("0");
                    btnRow78.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row78First = false;
                }
                checkNumRow7();

                isCompleteVRow8 = checkNumVRow(7);
                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;

            //End Row 7

            // Start Row 6

            case R.id.btnRowXH81:

                if(!row81First) {
                    btnRow81.setText("1");
                    btnRow81.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row81First = true;
                } else{
                    btnRow81.setText("0");
                    btnRow81.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row81First = false;
                }
                checkNumRow8();

                isCompleteVRow1 = checkNumVRow(0);
                if(isCompleteVRow1)
                    btnRow91.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow91.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH82:

                if(!row82First) {
                    btnRow82.setText("1");
                    btnRow82.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row82First = true;

                } else{
                    btnRow82.setText("0");
                    btnRow82.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row82First = false;
                }
                checkNumRow8();

                isCompleteVRow2 = checkNumVRow(1);
                if(isCompleteVRow2)
                    btnRow92.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow92.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH83:

                if(!row83First) {
                    btnRow83.setText("1");
                    btnRow83.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row83First = true;
                } else{
                    btnRow83.setText("0");
                    btnRow83.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row83First = false;
                }
                checkNumRow8();

                isCompleteVRow3 = checkNumVRow(2);
                if(isCompleteVRow3)
                    btnRow93.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow93.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH84:

                if(!row84First) {
                    btnRow84.setText("1");
                    btnRow84.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row84First = true;
                } else{
                    btnRow84.setText("0");
                    btnRow84.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row84First = false;
                }
                checkNumRow8();

                isCompleteVRow4 = checkNumVRow(3);
                if(isCompleteVRow4)
                    btnRow94.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow94.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH85:

                if(!row85First) {
                    btnRow85.setText("1");
                    btnRow85.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row85First = true;
                } else{
                    btnRow85.setText("0");
                    btnRow85.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row85First = false;
                }
                checkNumRow8();

                isCompleteVRow5 = checkNumVRow(4);
                if(isCompleteVRow5)
                    btnRow95.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow95.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH86:

                if(!row86First) {
                    btnRow86.setText("1");
                    btnRow86.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row86First = true;
                } else{
                    btnRow86.setText("0");
                    btnRow86.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row86First = false;
                }
                checkNumRow8();

                isCompleteVRow6 = checkNumVRow(5);
                if(isCompleteVRow6)
                    btnRow96.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow96.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH87:

                if(!row87First) {
                    btnRow87.setText("1");
                    btnRow87.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row87First = true;
                } else{
                    btnRow87.setText("0");
                    btnRow87.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row87First = false;
                }
                checkNumRow8();

                isCompleteVRow7 = checkNumVRow(6);
                if(isCompleteVRow7)
                    btnRow97.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow97.setBackgroundResource(R.drawable.button_bg_2);

                break;

            case R.id.btnRowXH88:

                if(!row88First) {
                    btnRow88.setText("1");
                    btnRow88.setBackgroundResource(R.drawable.bg_rounded_corner_2);
                    row88First = true;
                } else{
                    btnRow88.setText("0");
                    btnRow88.setBackgroundResource(R.drawable.bg_rounded_corner);
                    row88First = false;
                }
                checkNumRow8();

                isCompleteVRow8 = checkNumVRow(7);
                if(isCompleteVRow8)
                    btnRow98.setBackgroundResource(R.drawable.button_bg);
                else
                    btnRow98.setBackgroundResource(R.drawable.button_bg_2);

                break;
            //End Row 8
        }

        //Check all data are complete
        allRowCompleted();
    }
}
