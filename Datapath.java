package project;

public class Datapath {
    private static int Clock=0;
    
    public static void run(){
        Clock++;
        IM.setCIR();
        CU.control();
        ALUControl.control();
        RF.init();
        MUXALUSrc.pass();
        ALU.execute();
        DM.init();
        DM.use();
        MUXWR.pass();
        MUXWD.pass();
        RF.WB();
        MUXPC.pass();
        PC.updatePC();
    }
    public static int getClock(){return Clock;}
    public static void reset(){Clock=0;}
}
