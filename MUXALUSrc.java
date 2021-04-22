package project;

public class MUXALUSrc {
    private static int output;
    private static int immediate;
    
    public static void pass(){
        immediate=Tool.toInt(Tool.signExtend(IM.getImmediate()));
        output=(CU.getALUSrc())? immediate:RF.getReaddata2();
    }
    public static int getOutput(){return output;}
}
