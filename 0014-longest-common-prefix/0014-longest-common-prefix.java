class Solution {
    public String longestCommonPrefix(String[] str) {
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        StringBuilder ans = new StringBuilder();

        int n1=str[0].length(),n2=str[str.length-1].length();
        int i=0;
        while(i<n1 && i<n2){
            if(str[0].charAt(i)==str[str.length-1].charAt(i)) ans.append(str[0].charAt(i));
            else break;
            i++;
        }
        return ans.toString();
    }
}