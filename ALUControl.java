package project;

public class ALUControl {
    private static String ALUOp;
    private static String FCode;
    private static int ALUOrder;
    
    public static void control(){
        ALUOp=CU.getALUOp();
        FCode=IM.getFCode();
        switch(ALUOp){
            case "000":ALUOrder=0; break;
            case "001":ALUOrder=1; break;
            case "010":
                switch(FCode){
                    case "100000":ALUOrder=0; break; //add.
                    case "100010":ALUOrder=1; break; //sub.
                    case "011000":ALUOrder=2; break; //mul.
                    case "100100":ALUOrder=3; break; //and.
                    case "100101":ALUOrder=4; break; //or.
                    case "100111":ALUOrder=5; break; //nor.
                    case "000000":ALUOrder=6; break; //sll.
                    case "000010":ALUOrder=7; break; //srl.
                    case "101010":ALUOrder=8; break; //slt.
                    case "101011":ALUOrder=9; break; //sltu.
                    case "001000":ALUOrder=0; break; //jr.
                }
                break;
            case "011":ALUOrder=8; break;
            case "100":ALUOrder=9; break;
            case "101":ALUOrder=3; break;
            case "110":ALUOrder=4; break;
            case "111":ALUOrder=10; break;
        }
    }
    public static int getALUOrder(){return ALUOrder;}
}
