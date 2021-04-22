package project;

public class PC {
    private static int pc;
    
    public static void useOnce(int x){
        pc=x;
        IM.start=x;
    }
    public static void updatePC(){pc=MUXPC.getOutput();}
    public static int getPC(){return pc;}
}