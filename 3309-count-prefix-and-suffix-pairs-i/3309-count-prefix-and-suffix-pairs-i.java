class Solution {
    boolean isPrefixAndSuffix(String str1,String str2){
        if(str2.length()<str1.length()) return false;
        for(int i=0;i<str1.length();i++){
            if(str2.charAt(i) != str1.charAt(i))  return false;
            if(str2.charAt(str2.length()-str1.length()+i) != str1.charAt(i))  return false;
        }
        return true;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int cnt =0;
        int n = words.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isPrefixAndSuffix(words[i],words[j])) cnt++;
            }
        }
        return cnt;
    }
}