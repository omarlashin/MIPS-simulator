package project;

public class MUXPC {
    private static int output;
    private static int npc;
    private static int bpc;
    private static int jpc;
    private static int rpc;
    
    public static void pass(){
        npc=PC.getPC()+4;
        bpc=npc+(Tool.toInt(Tool.signExtend(IM.getImmediate()))<<2);
        jpc=Tool.toInt(Tool.toBString(npc).substring(0,4)+IM.getJAddress()+"00");
        rpc=ALU.getResult();
        
        boolean x=(CU.getBranch()&&ALU.getZeroFlag())||(CU.getBNE()&&(!ALU.getZeroFlag()));
        output=(x)? bpc:npc;
        output=(CU.getJump())? jpc:output;
        output=(CU.getJR())? rpc:output;
    }
    public static int getOutput(){return output;}
    public static int getNPC(){return npc;}
    public static int getBPC(){return bpc;}
    public static int getJPC(){return jpc;}
    public static int getRPC(){return rpc;}
}
