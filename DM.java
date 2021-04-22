package project;
import java.util.*;

class Segment {
    private int value;
    private final int address;
    
    public Segment(int value,int address){
        this.value=value;
        this.address=address;
    }
    
    public void setValue(int value){this.value=value;}
    public int getValue(){return this.value;}
    public int getAddress(){return this.address;}
}
public class DM {
    private static final ArrayList<Segment> DS=new ArrayList<>(0);
    private static int Address;
    private static int Writedata;
    private static int Readdata;
    private static int MemRead;
    private static int MemWrite;
    
    public static void reset(){
        DS.clear();
    }
    public static void init(){
        Address=ALU.getResult();
        Writedata=RF.getReaddata2();
        MemRead=Integer.parseInt(CU.getMemRead(),2);
        MemWrite=Integer.parseInt(CU.getMemWrite(),2);
    }
    public static void use(){
        write();
        read();
    }
    private static void write(){
        boolean alreadyExist=false;
        int i=0;
        if(MemWrite==0){}
        else if(MemWrite==1){
            for(;i<DS.size()&&DS.get(i).getAddress()<=Address;i++)
                if(Address==DS.get(i).getAddress()){
                    alreadyExist=true;
                    break;
                }
            if(alreadyExist) DS.get(i).setValue(Writedata);
            else DS.add(i,new Segment(Writedata,Address));
            }
        else if(MemWrite==2){
            boolean check=(Address%4==0);
            int pAddress=(check)? Address:Address-2;
            String pWritedata=Tool.toBString(Writedata).substring(16,32);
            for(;i<DS.size()&&DS.get(i).getAddress()<=pAddress;i++)
                if(pAddress==DS.get(i).getAddress()){
                    alreadyExist=true;
                    break;
                }
            String s=(alreadyExist)? Tool.toBString(DS.get(i).getValue()):"00000000000000000000000000000000";
            if(check) s=pWritedata+s.substring(16,32);
            else s=s.substring(0,16)+pWritedata;
            int x=Tool.toInt(s);
            if(alreadyExist) DS.get(i).setValue(x);
            else DS.add(i,new Segment(x,pAddress));
        }
        else if(MemWrite==3){
            int rem=Address%4;
            int pAddress=Address-rem;
            String pWritedata=Tool.toBString(Writedata).substring(24,32);
            for(;i<DS.size()&&DS.get(i).getAddress()<=pAddress;i++)
                if(pAddress==DS.get(i).getAddress()){
                    alreadyExist=true;
                    break;
                }
            String s=(alreadyExist)? Tool.toBString(DS.get(i).getValue()):"00000000000000000000000000000000";
            switch(rem){
                case 0: s=pWritedata+s.substring(8,32);
                break;
                case 1: s=s.substring(0,8)+pWritedata+s.substring(16,32);
                break;
                case 2: s=s.substring(0,16)+pWritedata+s.substring(24,32);
                break;
                case 3:s=s.substring(0,24)+pWritedata;
                break;
            }
            int x=Tool.toInt(s);
            if(alreadyExist) DS.get(i).setValue(x);
            else DS.add(i,new Segment(x,pAddress));
        }
    }
    private static void read(){
        boolean alreadyExist=false;
        int i=0;
        int pAddress;
        switch(MemRead){
            case 0: Readdata=0; break;
            case 1:
                for(;i<DS.size()&&DS.get(i).getAddress()<=Address;i++)
                    if(Address==DS.get(i).getAddress()){
                        alreadyExist=true;
                        break;
                    }
                Readdata=(alreadyExist)? DS.get(i).getValue():0;
                break;
            case 2:
            case 3:
                boolean check=(Address%4==0);
                pAddress=(check)? Address:Address-2;
                for(;i<DS.size()&&DS.get(i).getAddress()<=pAddress;i++)
                    if(pAddress==DS.get(i).getAddress()){
                        alreadyExist=true;
                        break;
                    }
                if(!alreadyExist) Readdata=0;
                else{
                    String s=Tool.toBString(DS.get(i).getValue());
                    s=(check)? s.substring(0,16):s.substring(16,32);
                    s=(MemRead==2)? Tool.signExtend(s):"0000000000000000"+s;
                    Readdata=Tool.toInt(s);
                }
                break;
            case 4:
            case 5:
                int rem=Address%4;
                pAddress=Address-rem;
                for(;i<DS.size()&&DS.get(i).getAddress()<=pAddress;i++)
                    if(pAddress==DS.get(i).getAddress()){
                        alreadyExist=true;
                        break;
                    }
                if(!alreadyExist) Readdata=0;
                else{
                    String s=Tool.toBString(DS.get(i).getValue());
                    switch(rem){
                        case 0:s=s.substring(0,8); break;
                        case 1:s=s.substring(8,16); break;
                        case 2:s=s.substring(16,24); break;
                        case 3:s=s.substring(24,32); break;
                    }
                    if(MemRead==4)
                        s=(s.startsWith("0"))? "000000000000000000000000"+s:"111111111111111111111111"+s;
                    else
                        s="000000000000000000000000"+s;
                    Readdata=Tool.toInt(s);
                }
                break;
        }
    }
    
    public static void locate(int v,int a){
        boolean alreadyExist=false;
        int i=0;
        for(;i<DS.size()&&DS.get(i).getAddress()<=a;i++)
            if(a==DS.get(i).getAddress()){
                alreadyExist=true;
                break;
            }
        if(alreadyExist) DS.get(i).setValue(v);
        else DS.add(i,new Segment(v,a));
    }
    
    public static int getReaddata(){return Readdata;}
    
    public static String toPrint(){
        String s="";
        for(int i=0;i<DS.size();i++)
            s+=DS.get(i).getAddress()+"\t"+DS.get(i).getValue()+"\n";
        return s;
    }
}
