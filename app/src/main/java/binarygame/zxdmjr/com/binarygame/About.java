package binarygame.zxdmjr.com.binarygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView tvEmail;
    private TextView tvLinkedin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tvEmail    = (TextView) findViewById(R.id.tvEmail);
        tvLinkedin = (TextView) findViewById(R.id.tvLinkedin);

        tvEmail.setText(Html.fromHtml("Email: zxdmjr@gmail.com"));

        Linkify.addLinks(tvEmail,Linkify.EMAIL_ADDRESSES);

        tvLinkedin.setText(Html.fromHtml("https://bd.linkedin.com/in/dutchmanbd"));

        Linkify.addLinks(tvLinkedin,Linkify.WEB_URLS);

//        TextView t2 = (TextView) findViewById(R.id.TextView03);
//        t2.setText("E-mail:email@gmail.com");
//        Linkify.addLinks(t2, Linkify.EMAIL_ADDRESSES);

    }
}
