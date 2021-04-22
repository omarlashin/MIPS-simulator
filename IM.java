package project;

class Instruction {
    private String ins;
    private String label;
    private String PDaddress;
    
    public Instruction(String ins){
        this.ins=ins;
    }
    public Instruction(String label, String PDaddress){
        this.label=label;
        this.PDaddress=PDaddress;
    }
    
    public void setIns(String ins){this.ins=ins;}
    public String getIns(){return this.ins;}
    public String getLabel(){return this.label;}
    public String getPDaddress(){return this.PDaddress;}
}
public class IM {
    static final Instruction[] IS=new Instruction[200];
    public static int start;
    private static String CIR;
    
    public static void setCIR(){CIR=IS[(PC.getPC()-start)/4].getIns();}
    public static String getCIR(){return CIR;}
    public static String getOPCode(){return CIR.substring(0,6);}
    public static String getRS(){return CIR.substring(6,11);}
    public static String getRT(){return CIR.substring(11,16);}
    public static String getRD(){return CIR.substring(16,21);}
    public static String getShamt(){return CIR.substring(21,26);}
    public static String getFCode(){return CIR.substring(26,32);}
    public static String getImmediate(){return CIR.substring(16,32);}
    public static String getJAddress(){return CIR.substring(6,32);}
    
    public static String toPrint(){
        String s="";
        int i=0;
        while(IS[i]!=null){
            s+=((i*4)+start)+"\t"+IS[i].getIns()+"\n";
            i++;
        }
        return s;
    }
    public static void reset(){
        for(int i=0;i<IS.length;i++)
            IS[i]=null;
    }
}
