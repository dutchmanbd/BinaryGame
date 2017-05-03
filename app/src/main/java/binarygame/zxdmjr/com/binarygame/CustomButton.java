package binarygame.zxdmjr.com.binarygame;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import binarygame.zxdmjr.com.binarygame.objects.FontCache;

/**
 * Created by dutchman on 12/20/16.
 */

public class CustomButton extends Button {

    public CustomButton(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context){

        Typeface customFont = FontCache.getTypeface(context,"quikhand.ttf");

        setTypeface(customFont);
    }
}
