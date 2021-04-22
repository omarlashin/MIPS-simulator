package project;

public class ALU {
    private static int src1;
    private static int src2;
    private static int shamt;
    private static int Op;
    private static int result;
    private static boolean zeroFlag;
    
    public static void execute(){
        src1=RF.getReaddata1();
        src2=MUXALUSrc.getOutput();
        shamt=Integer.parseInt(IM.getShamt(),2);
        Op=ALUControl.getALUOrder();
        switch(Op){
            case 0:result=src1+src2;
            break;
            case 1:result=src1-src2;
            break;
            case 2:result=src1*src2;
            break;
            case 3:result=src1&src2;
            break;
            case 4:result=src1|src2;
            break;
            case 5:result=~(src1|src2);
            break;
            case 6:result=src2<<shamt;
            break;
            case 7:result=src2>>>shamt;
            break;
            case 8:result=(src1<src2)? 1:0;
            break;
            case 9:
                if(Integer.compareUnsigned(src1,src2)==-1) result=1;
                else result=0;
            break;
            case 10: result=src2<<16;
            break;
        }
        zeroFlag=(result==0);
    }
    public static int getResult(){return result;}
    public static boolean getZeroFlag(){return zeroFlag;}
}