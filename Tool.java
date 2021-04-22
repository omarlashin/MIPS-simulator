package project;

public class Tool {
    
    public static String toBString(int x){
        final String filler="0000000000000000000000000000000";
        String s=Integer.toBinaryString(x);
        if(x>=0){
            String t=filler.substring(0,(32-s.length()));
            s=t+s;
        }
        return s;
    }
    
    public static int toInt(String s){
        int x;
        if(s.charAt(0)=='0')
            x=Integer.parseInt(s,2);
        else{
            x=Integer.parseInt(s.substring(1,32),2);
            x+=-2147483648;
        }
        return x;
    }
    
    public static String signExtend(String s){
        if(s.charAt(0)=='0')
            return ("0000000000000000"+s);
        return ("1111111111111111"+s);
    }
}
