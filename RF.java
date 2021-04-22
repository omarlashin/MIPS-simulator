package project;

public class RF {
    private static final String[] NAMES={"($0)","($at)","($v0)","($v1)","($a0)","($a1)","($a2)","($a3)","($t0)",
        "($t1)","($t2)","($t3)","($t4)","($t5)","($t6)","($t7)","($s0)","($s1)","($s2)","($s3)","($s4)","($s5)",
        "($s6)","($s7)","($t8)","($t9)","($k0)","($k1)","($gp)","($sp)","($fp)","($ra)"};
    private static final int[] REGS=new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,10000,0,0};
    private static boolean RegWrite;
    private static int Readreg1;
    private static int Readreg2;
    private static int Readdata1;
    private static int Readdata2;
    private static int Writereg;
    private static int Writedata;
    
    public static void init(){
        Readreg1=Integer.parseInt(IM.getRS(),2);
        Readreg2=Integer.parseInt(IM.getRT(),2);
        Readdata1=REGS[Readreg1];
        Readdata2=REGS[Readreg2];
    }
    public static void WB(){
        RegWrite=CU.getRegWrite();
        Writereg=MUXWR.getOutput();
        Writedata=MUXWD.getOutput();
        if(RegWrite&&Writereg!=0)
            REGS[Writereg]=Writedata;
    }
    public static int getReaddata1(){return Readdata1;}
    public static int getReaddata2(){return Readdata2;}
    
    public static String toPrint1(){
        String s="";
        for(int i=0;i<16;i++)
            s+=i+" "+NAMES[i]+"\n";
        return s;
    }
    public static String toPrint2(){
        String s="";
        for(int i=16;i<32;i++)
            s+=i+" "+NAMES[i]+"\n";
        return s;
    }
    public static String toPrint3(){
        String s="";
        for(int i=0;i<16;i++)
            s+=REGS[i]+"\n";
        return s;
    }
    public static String toPrint4(){
        String s="";
        for(int i=16;i<32;i++)
            s+=REGS[i]+"\n";
        return s;
    }
    public static void reset(){
        for(int i=0;i<REGS.length;i++){
            if(i==29)
                REGS[i]=10000;
            else
                REGS[i]=0;
        }
    }
}
