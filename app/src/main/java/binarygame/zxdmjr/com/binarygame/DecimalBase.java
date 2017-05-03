package binarygame.zxdmjr.com.binarygame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import binarygame.zxdmjr.com.binarygame.objects.KeyWords;

public class DecimalBase extends AppCompatActivity implements View.OnClickListener {

    private Button btnEasy;
    private Button btnMedium;
    private Button btnHard;

    private Button btnHighScore;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_decimal_base);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
//        View view = getSupportActionBar().getCustomView();
//
//        TextView tvActionBarTitle = (TextView) view.findViewById(R.id.tvActionBarTitle);
//        tvActionBarTitle.setText("Decimal");
//        TextView tvActionBarSubTitle = (TextView) view.findViewById(R.id.tvActionBarSubTitle);
//        tvActionBarSubTitle.setText("Easy");

        getSupportActionBar().setTitle("Decimal");
        //getSupportActionBar().setSubtitle("Decimal");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        // init button

        init();



    }

    //init method
    private void init(){

        btnEasy      = (Button) findViewById(R.id.btnEasy);
        btnMedium    = (Button) findViewById(R.id.btnMedium);
        btnHard      = (Button) findViewById(R.id.btnHard);

        btnHighScore = (Button) findViewById(R.id.btnHighScore);



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

            case R.id.btnEasy:

                //showMessage("Easy Button Clicked");

                intent = new Intent(DecimalBase.this,DecimalEasy.class);
                startActivity(intent);
                //finish();

                break;

            case R.id.btnMedium:

                //showMessage("Medium Button Clicked");
                intent = new Intent(DecimalBase.this,DecimalMedium.class);
                startActivity(intent);

                break;

            case R.id.btnHard:

                //showMessage("Hard Button Clicked");
                intent = new Intent(DecimalBase.this,DecimalHard.class);
                startActivity(intent);

                break;


            case R.id.btnHighScore:

                intent = new Intent(DecimalBase.this,HighScore.class);
                startActivity(intent);

                break;
        }
    }

    public void showMessage(String message){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
