class Solution {

    boolean isprefix(String str,String pref){
        if(str.length()<pref.length())  return false;
        for(int i=0;i<pref.length();i++){
            if(str.charAt(i)!=pref.charAt(i)) return false;
        }

        return true;
    }
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for(String str : words){
            if(isprefix(str,pref)) cnt++;
        }

        return cnt;
    }
}