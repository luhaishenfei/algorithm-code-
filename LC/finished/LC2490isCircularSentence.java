package finished;

public class LC2490isCircularSentence {
    public static void main(String[] args) {
        LC2490isCircularSentence l = new LC2490isCircularSentence();
        String str="leetcode exercises sound delightful";
        System.out.println(l.isCircularSentence(str));
    }

    /*
    执行耗时:1 ms,击败了96.22% 的Java用户
	内存消耗:40.1 MB,击败了51.26% 的Java用户
    */
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        char start=words[0].charAt(0);
        char end=words[words.length-1].charAt(words[words.length-1].length()-1);
        if (start!=end) return false;
        char c=' ';
        for (String s:
             words) {
            if (c==' '||s.charAt(0)==c){
                c=s.charAt(s.length()-1);
            }else {
                return false;
            }
        }
        return true;
    }


    //more elegance
    public boolean isCircularSentenceLC(String sentence) {
        if (sentence.charAt(sentence.length() - 1) != sentence.charAt(0)) {
            return false;
        }
        for (int i = 0; i < sentence.length(); i++) {
            //elegance
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != sentence.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
