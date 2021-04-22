package project;

public class MUXWR {
    private static int output;
    
    public static void pass(){
        if(CU.getLink()) output=31;
        else
            output=(CU.getRegDst())? Integer.parseInt(IM.getRD(),2):Integer.parseInt(IM.getRT(),2);
    }
    public static int getOutput(){return output;}
}
