package project;

public class CU {
    private static String OPC;
    private static boolean BNE;
    private static boolean JR;
    private static boolean RegDst;
    private static boolean Jump;
    private static boolean Branch;
    private static String MemRead;
    private static boolean MemtoReg;
    private static String ALUOp;
    private static String MemWrite;
    private static boolean ALUSrc;
    private static boolean RegWrite;
    private static boolean Link;
    
    public static void control(){
        OPC=IM.getOPCode();
        switch(OPC){
            case "000000"://R-type.
                BNE=false; JR=IM.getFCode().equals("001000"); RegDst=true; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="010";
                MemWrite="00"; ALUSrc=false; RegWrite=true; Link=false;
                break;
            case "001000"://addi.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="000";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "001010"://slti.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="011";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "001011"://sltiu.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="100";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "001100"://andi.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="101";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "001101"://ori.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="110";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "000100"://beq.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=true; MemRead="000"; MemtoReg=false; ALUOp="001";
                MemWrite="00"; ALUSrc=false; RegWrite=false; Link=false;
                break;
            case "000101"://bne.
                BNE=true; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="001";
                MemWrite="00"; ALUSrc=false; RegWrite=false; Link=false;
                break;
            case "000010"://j.
                BNE=false; JR=false; RegDst=false; Jump=true;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="000";
                MemWrite="00"; ALUSrc=false; RegWrite=false; Link=false;
                break;
            case "000011"://jal.
                BNE=false; JR=false; RegDst=false; Jump=true;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="000";
                MemWrite="00"; ALUSrc=false; RegWrite=true; Link=true;
                break;
            case "100011"://lw.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="001"; MemtoReg=true; ALUOp="000";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "100001"://lh.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="010"; MemtoReg=true; ALUOp="000";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "100101"://lhu.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="011"; MemtoReg=true; ALUOp="000";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "100000"://lb.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="100"; MemtoReg=true; ALUOp="000";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "100100"://lbu.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="101"; MemtoReg=true; ALUOp="000";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
            case "101011"://sw.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="000";
                MemWrite="01"; ALUSrc=true; RegWrite=false; Link=false;
                break;
            case "101001"://sh.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="000";
                MemWrite="10"; ALUSrc=true; RegWrite=false; Link=false;
                break;
            case "101000"://sb.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="000";
                MemWrite="11"; ALUSrc=true; RegWrite=false; Link=false;
                break;
            case "001111"://lui.
                BNE=false; JR=false; RegDst=false; Jump=false;
                Branch=false; MemRead="000"; MemtoReg=false; ALUOp="111";
                MemWrite="00"; ALUSrc=true; RegWrite=true; Link=false;
                break;
        }
    }
    
    public static boolean getBNE(){return BNE;}
    public static boolean getJR(){return JR;}
    public static boolean getRegDst(){return RegDst;}
    public static boolean getJump(){return Jump;}
    public static boolean getBranch(){return Branch;}
    public static String getMemRead(){return MemRead;}
    public static boolean getMemtoReg(){return MemtoReg;}
    public static String getALUOp(){return ALUOp;}
    public static String getMemWrite(){return MemWrite;}
    public static boolean getALUSrc(){return ALUSrc;}
    public static boolean getRegWrite(){return RegWrite;}
    public static boolean getLink(){return Link;}
}
