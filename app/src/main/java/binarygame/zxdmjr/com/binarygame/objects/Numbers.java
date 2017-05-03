package binarygame.zxdmjr.com.binarygame.objects;

/**
 * Created by dutchman on 12/10/16.
 */

public class Numbers {

    private int dNumVertical;
    private int dNumHorizontal;
    char[] binNum;

    public Numbers(int dNumHorizontal){
        this.dNumHorizontal = dNumHorizontal;
        setBinNum(4);

    }

    public Numbers(int dNumHorizontal,int size){
        this.dNumHorizontal = dNumHorizontal;
        setBinNum(size);
    }

    private void setBinNum(int size){

        String n = Integer.toBinaryString(this.dNumHorizontal);

        if(n.length() < size){

            for(int i=n.length(); i<size; i++){

                n = "0"+n;
            }
        }

        binNum = n.toCharArray();

    }

    public char[] getBinNum(){

        return binNum;
    }

    public int getBinDigitAtPosition(int pos){

        return Integer.parseInt(binNum[pos]+"");
    }

}
