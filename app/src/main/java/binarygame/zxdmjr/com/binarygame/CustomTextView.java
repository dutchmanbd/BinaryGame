package binarygame.zxdmjr.com.binarygame;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import binarygame.zxdmjr.com.binarygame.objects.FontCache;

/**
 * Created by dutchman on 12/20/16.
 */

public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context){

        Typeface customFont = FontCache.getTypeface(context,"trench.otf");  //gladifilthefte.ttf

        setTypeface(customFont);

        //setTextColor(getResources().getColor(R.color.defaultTextColor));

    }

}
