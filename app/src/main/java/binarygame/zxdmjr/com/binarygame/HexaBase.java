package binarygame.zxdmjr.com.binarygame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HexaBase extends AppCompatActivity implements View.OnClickListener {


    private Button btnEasy;
    private Button btnHard;

    private Button btnHighScore;


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexa_base);

        getSupportActionBar().setTitle("HexaDecimal");
        //getSupportActionBar().setSubtitle("Easy");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;


        // init button

        init();

    }

    //init method
    private void init(){

        btnEasy      = (Button) findViewById(R.id.btnHexEasy);
        btnHard      = (Button) findViewById(R.id.btnHexHard);

        btnHighScore = (Button) findViewById(R.id.btnHexHighScore);



        // action

        btnEasy.setOnClickListener(this);
        btnHard.setOnClickListener(this);

        btnHighScore.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        Intent intent;

        switch (id){

            case R.id.btnHexEasy:

                //showMessage("Easy Button Clicked");

                intent = new Intent(HexaBase.this,HexEasy.class);
                startActivity(intent);
                //finish();

                break;

            case R.id.btnHexHard:

                intent = new Intent(HexaBase.this,HexHard.class);
                startActivity(intent);

                break;


            case R.id.btnHexHighScore:

                intent = new Intent(HexaBase.this,HighScore.class);
                startActivity(intent);

                break;
        }

    }


    public void showMessage(String message){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
