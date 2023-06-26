package undo;

import java.util.LinkedList;
import java.util.List;

public class LCOffer20isNumber {
    public static void main(String[] args) {
        //(int)'0'==48
        //(int)'1'==49
        //(int)'9'==57
        char c='+';
        System.out.println((int)c);
    }

    public boolean isNumber(String s) {
        if (s == "" || s.isEmpty()) return false;
        char[] chars = s.toCharArray();
        int idx = 0;

        boolean haveE=false;
        boolean haveDot=false;
        boolean haveOperator=false;

        List<Character> tmp=new LinkedList<>();




        while (chars[idx] != ' ') {
            idx++;
        }
        if (chars[idx] == '-'||chars[idx]=='+'){
            idx++;
            haveOperator=true;
        }else if (48<=chars[idx]&&chars[idx]<=57){
            //numbers
            haveOperator=true;
        }

        for (int i = idx; i < chars.length; i++) {
            if (chars[idx]==' ') continue;
            if (chars[idx]=='+'||chars[idx]=='-'){

            }

        }



        return false;
    }
}
