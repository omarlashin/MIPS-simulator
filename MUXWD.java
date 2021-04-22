package project;

public class MUXWD {
    private static int output;
    
    public static void pass(){
        if(CU.getLink()) output=PC.getPC()+4;
        else
            output=(CU.getMemtoReg())? DM.getReaddata():ALU.getResult();
    }
    public static int getOutput(){return output;}
}
