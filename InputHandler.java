package project;

public class InputHandler {
    private static String Code;
    private static String[] CodeLines;
    private static int begin=0;
    private static String OP,RS,RT,RD,SH,FC,CONSTANT,JA;
    
    public static void reset(){begin=0;}
    public static void setCode(String s){Code=s;}
    public static void translate(){
        CodeLines=Code.split("\n");
        if(CodeLines[begin].equalsIgnoreCase(".data")){
            begin++;
            while(!(CodeLines[begin].equalsIgnoreCase(".text"))){
                String[] ss=CodeLines[begin].split(" ");
                DM.locate(Integer.parseInt(ss[1]),Integer.parseInt(ss[0]));
                begin++;
            }
        }
        begin++;
        PC.useOnce(Integer.parseInt(CodeLines[begin]));
        begin++;
        for(int i=0,j=begin;j<CodeLines.length;i++,j++){
            int index=CodeLines[j].indexOf(":");
            if(index!=-1){
                String label=CodeLines[j].substring(0,index);
                String PDA=Tool.toBString((i*4)+IM.start).substring(4,30);
                IM.IS[i]=new Instruction(label,PDA);
                CodeLines[j]=CodeLines[j].replaceFirst(label+":","");
            }
        }
        for(int i=0,j=begin;j<CodeLines.length;i++,j++){
            String[] ss=CodeLines[j].split(" ");
            String total;
            if(ss[0].equalsIgnoreCase("add")||ss[0].equalsIgnoreCase("sub")||ss[0].equalsIgnoreCase("mul")||ss[0].equalsIgnoreCase("and")
                    ||ss[0].equalsIgnoreCase("or")||ss[0].equalsIgnoreCase("nor")||ss[0].equalsIgnoreCase("slt")||ss[0].equalsIgnoreCase("sltu")){
                OP="000000";
                RS=convert(ss[2]);
                RT=convert(ss[3]);
                RD=convert(ss[1]);
                SH="00000";
                ss[0]=ss[0].toLowerCase();
                switch(ss[0]){
                    case "add":FC="100000"; break;
                    case "sub":FC="100010"; break;
                    case "mul":FC="011000"; break;
                    case "and":FC="100100"; break;
                    case "or":FC="100101"; break;
                    case "nor":FC="100111"; break;
                    case "slt":FC="101010"; break;
                    case "sltu":FC="101011"; break;
                }
                total=OP+RS+RT+RD+SH+FC;
            }
            else if(ss[0].equalsIgnoreCase("addi")||ss[0].equalsIgnoreCase("andi")||ss[0].equalsIgnoreCase("ori")
                    ||ss[0].equalsIgnoreCase("slti")||ss[0].equalsIgnoreCase("sltiu")){
                ss[0]=ss[0].toLowerCase();
                switch(ss[0]){
                    case "addi":OP="001000"; break;
                    case "andi":OP="001100"; break;
                    case "ori":OP="001101"; break;
                    case "slti":OP="001010"; break;
                    case "sltiu":OP="001011"; break;
                }
                RS=convert(ss[2]);
                RT=convert(ss[1]);
                CONSTANT=Tool.toBString(Integer.parseInt(ss[3])).substring(16,32);
                total=OP+RS+RT+CONSTANT;
            }
            else if(ss[0].equalsIgnoreCase("lw")||ss[0].equalsIgnoreCase("lh")||ss[0].equalsIgnoreCase("lhu")||ss[0].equalsIgnoreCase("lb")
                    ||ss[0].equalsIgnoreCase("lbu")||ss[0].equalsIgnoreCase("sw")||ss[0].equalsIgnoreCase("sh")||ss[0].equalsIgnoreCase("sb")){
                switch(ss[0]){
                    case "lw":OP="100011"; break;
                    case "lh":OP="100001"; break;
                    case "lhu":OP="100101"; break;
                    case "lb":OP="100000"; break;
                    case "lbu":OP="100100"; break;
                    case "sw":OP="101011"; break;
                    case "sh":OP="101001"; break;
                    case "sb":OP="101000"; break;
                }
                int TM=ss[2].indexOf("(");
                String[] TMS={ss[2].substring(0,TM),ss[2].substring(TM+1,ss[2].length()-1)};
                RS=convert(TMS[1]);
                RT=convert(ss[1]);
                CONSTANT=Tool.toBString(Integer.parseInt(TMS[0])).substring(16,32);
                total=OP+RS+RT+CONSTANT;
            }
            else if(ss[0].equalsIgnoreCase("beq")||ss[0].equalsIgnoreCase("bne")){
                ss[0]=ss[0].toLowerCase();
                switch(ss[0]){
                    case "beq":OP="000100"; break;
                    case "bne":OP="000101"; break;
                }
                RS=convert(ss[1]);
                RT=convert(ss[2]);
                int k=0;
                while(true){
                    if(IM.IS[k]!=null)
                        if(IM.IS[k].getLabel()!=null)
                            if(IM.IS[k].getLabel().equals(ss[3]))
                                break;
                    k++;
                }
                int offset=k-i-1;
                CONSTANT=Tool.toBString(offset).substring(16,32);
                total=OP+RS+RT+CONSTANT;
            }
            else if(ss[0].equalsIgnoreCase("j")||ss[0].equalsIgnoreCase("jal")){
                ss[0]=ss[0].toLowerCase();
                switch(ss[0]){
                    case "j":OP="000010"; break;
                    case "jal":OP="000011"; break;
                }
                int k=0;
                while(true){
                    if(IM.IS[k]!=null)
                        if(IM.IS[k].getLabel()!=null)
                            if(IM.IS[k].getLabel().equals(ss[1])){
                                JA=IM.IS[k].getPDaddress();
                                break;
                            }
                    k++;
                }
                total=OP+JA;
            }
            else if(ss[0].equalsIgnoreCase("sll")||ss[0].equalsIgnoreCase("srl")){
                OP="000000";
                RS="00000";
                RT=convert(ss[2]);
                RD=convert(ss[1]);
                SH=Tool.toBString(Integer.parseInt(ss[3])).substring(27,32);
                switch(ss[0]){
                    case "sll":FC="000000"; break;
                    case "srl":FC="000010"; break;
                }
                total=OP+RS+RT+RD+SH+FC;
            }
            else if(ss[0].equalsIgnoreCase("jr")){
                OP="000000";
                RS=convert(ss[1]);
                RT="00000";
                RD="00000";
                SH="00000";
                FC="001000";
                total=OP+RS+RT+RD+SH+FC;
            }
            else{
                OP="001111";
                RS="00000";
                RT=convert(ss[1]);
                CONSTANT=Tool.toBString(Integer.parseInt(ss[2])).substring(16,32);
                total=OP+RS+RT+CONSTANT;
            }
            
            if(IM.IS[i]==null)
                IM.IS[i]=new Instruction(total);
            else
                IM.IS[i].setIns(total);
        }
    }
    private static String convert(String r){
        r=r.toLowerCase();
        String t;
        switch(r){
            case "$zero":t="00000"; break;
            case "$at":t="00001"; break;
            case "$v0":t="00010"; break;
            case "$v1":t="00011"; break;
            case "$a0":t="00100"; break;
            case "$a1":t="00101"; break;
            case "$a2":t="00110"; break;
            case "$a3":t="00111"; break;
            case "$t0":t="01000"; break;
            case "$t1":t="01001"; break;
            case "$t2":t="01010"; break;
            case "$t3":t="01011"; break;
            case "$t4":t="01100"; break;
            case "$t5":t="01101"; break;
            case "$t6":t="01110"; break;
            case "$t7":t="01111"; break;
            case "$s0":t="10000"; break;
            case "$s1":t="10001"; break;
            case "$s2":t="10010"; break;
            case "$s3":t="10011"; break;
            case "$s4":t="10100"; break;
            case "$s5":t="10101"; break;
            case "$s6":t="10110"; break;
            case "$s7":t="10111"; break;
            case "$t8":t="11000"; break;
            case "$t9":t="11001"; break;
            case "$k0":t="11010"; break;
            case "$k1":t="11011"; break;
            case "$gp":t="11100"; break;
            case "$sp":t="11101"; break;
            case "$fp":t="11110"; break;
            case "$ra":t="11111"; break;
            default:
                r=r.substring(1);
                t=Tool.toBString(Integer.parseInt(r)).substring(27,32);
                break;
        }
        return t;
    }
}