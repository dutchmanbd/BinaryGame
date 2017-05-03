package binarygame.zxdmjr.com.binarygame.objects;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * Created by dutchman on 12/20/16.
 */

public class FontCache {

    private static HashMap<String,Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(Context context, String fontName){

        Typeface typeface;

        if(!fontCache.containsKey(fontName)){

            typeface = Typeface.createFromAsset(context.getAssets(),fontName);
            fontCache.put(fontName,typeface);

        } else{

            typeface = fontCache.get(fontName);
        }

        return typeface;
    }
}
