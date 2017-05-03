package binarygame.zxdmjr.com.binarygame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OctalBase extends AppCompatActivity implements View.OnClickListener {

    private Button btnEasy;
    private Button btnMedium;
    private Button btnHard;

    private Button btnHighScore;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal_base);

        getSupportActionBar().setTitle("Octal");
        //getSupportActionBar().setSubtitle("Easy");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        // init button

        init();

    }


    //init method
    private void init(){

        btnEasy      = (Button) findViewById(R.id.btnOEasy);
        btnMedium    = (Button) findViewById(R.id.btnOMedium);
        btnHard      = (Button) findViewById(R.id.btnOHard);

        btnHighScore = (Button) findViewById(R.id.btnOHighScore);



        // action

        btnEasy.setOnClickListener(this);
        btnMedium.setOnClickListener(this);
        btnHard.setOnClickListener(this);

        btnHighScore.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        int id = view.getId();

        Intent intent;
        switch (id){

            case R.id.btnOEasy:

                //showMessage("Easy Button Clicked");

                intent = new Intent(OctalBase.this,OctalEasy.class);
                startActivity(intent);
                //finish();

                break;

            case R.id.btnOMedium:

                //showMessage("Medium Button Clicked");
                intent = new Intent(OctalBase.this,OctalMedium.class);
                startActivity(intent);

                break;

            case R.id.btnOHard:

                //showMessage("Hard Button Clicked");
                intent = new Intent(OctalBase.this,OctalHard.class);
                startActivity(intent);

                break;


            case R.id.btnOHighScore:

                intent = new Intent(OctalBase.this,HighScore.class);
                startActivity(intent);

                break;
        }
    }

    public void showMessage(String message){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

}
