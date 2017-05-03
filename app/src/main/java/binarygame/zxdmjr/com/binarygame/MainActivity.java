package binarygame.zxdmjr.com.binarygame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import binarygame.zxdmjr.com.binarygame.objects.KeyWords;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnDecimal;
    private Button btnHexaDecimal;
    private Button btnOctal;

    private Button btnSettings;
    private Button btnHowToPlay;
    private Button btnAbout;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        context = this;

        // init button

        init();


    }
    //init method
    private void init(){

        btnDecimal     = (Button) findViewById(R.id.btnDecimal);
        btnHexaDecimal = (Button) findViewById(R.id.btnHexaDecimal);
        btnOctal       = (Button) findViewById(R.id.btnOctal);

        btnSettings  = (Button) findViewById(R.id.btnSettings);
        btnHowToPlay = (Button) findViewById(R.id.btnHowToPlay);
        btnAbout     = (Button) findViewById(R.id.btnAbout);


        // action

        btnDecimal.setOnClickListener(this);
        btnHexaDecimal.setOnClickListener(this);
        btnOctal.setOnClickListener(this);

        btnSettings.setOnClickListener(this);
        btnHowToPlay.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

        btnSettings.setVisibility(View.GONE);



    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        Intent intent;

        switch (id){

            case R.id.btnDecimal:

                    //showMessage("Decimal Button Clicked");

                intent = new Intent(MainActivity.this,DecimalBase.class);
                //intent.putExtra(KeyWords.KEY_TYPE,"DECIMAL");
                startActivity(intent);
                //finish();


                break;

            case R.id.btnHexaDecimal:

                //showMessage("HexaDecimal Button Clicked");

                intent = new Intent(MainActivity.this,HexaBase.class);

                startActivity(intent);

                //finish();

                break;

            case R.id.btnOctal:

                intent = new Intent(MainActivity.this,OctalBase.class);
                startActivity(intent);
                //showMessage("Octal Button Clicked");

                break;

            case R.id.btnSettings:

                showMessage("Underconstruction");

                break;

            case R.id.btnHowToPlay:

                //showMessage("HowToPlay Button Clicked");
                intent = new Intent(MainActivity.this,HowToPlay.class);
                startActivity(intent);

                break;

            case R.id.btnAbout:

                //showMessage("About Button Clicked");

                intent = new Intent(MainActivity.this,About.class);
                startActivity(intent);

                break;
        }

    }

    public void showMessage(String message){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
