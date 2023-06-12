package finished;

import java.util.ArrayList;
import java.util.List;

public class LC6convert {
    public static void main(String[] args) {
        LC6convert l = new LC6convert();
        System.out.println(l.convert("PAYPALISHIRING", 4));
    }

    //Yo,solute it by math
    /*
    执行耗时:12 ms,击败了33.01% 的Java用户
	内存消耗:43.1 MB,击败了35.18% 的Java用户
     */
    //looks like it is trash,too
    public String convert(String s, int numRows) {
        if (numRows==1) return s;
        String res="";
        for (int j = 0; j < numRows; j++) {
            int i=j;
            if (i==0){
                while (i<s.length()){
                   res=res+s.charAt(i);
                   i=i+numRows+numRows-2;
                }
            }else if (i==numRows-1){
                while (i<s.length()){
                    res=res+s.charAt(i);
                    i=i+numRows+numRows-2;
                }
            }else {
                while (i<s.length()){
                    res=res+s.charAt(i);
                    int tmp=i+(numRows-j- 1)*2;
                    if (tmp<s.length()){
                        res=res+s.charAt(tmp);
                    }
                    i=i+numRows+numRows-2;
                }
            }
        }
        return res;
    }







    //little trash,but fix it.  0.0!
    /*
    执行耗时:12 ms,击败了33.01% 的Java用户
	内存消耗:43.2 MB,击败了31.33% 的Java用户
     */
    public String convert1(String s, int numRows) {
        if (numRows==1) return s;
        this.numRows=numRows;
        List<List> lists=new ArrayList<List>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList());
        }
        int idx=0;
        for (int i = 0; i < s.length(); ) {
            lists.get(idx).add(s.charAt(i++));
            idx=getRightIdx(idx);
        }
        s="";
        for (int i = 0; i < numRows; i++) {
            List<Character> l=lists.get(i);
            if (l.isEmpty()) continue;
            for (Character c :
                    l) {
                s=s+c;
            }
        }
        return s;
    }

    boolean flag=true;
    int numRows;

    int getRightIdx(int i){
        if (i==numRows-1){
            flag=false;
            return --i;
        }
        if (i==0){
            flag=true;
            return ++i;
        }
        if (flag){
            return ++i;
        }else {
            return --i;
        }
    }

}
