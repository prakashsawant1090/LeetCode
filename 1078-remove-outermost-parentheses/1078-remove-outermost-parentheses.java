class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans =new StringBuilder();
        Stack<Character> st =new Stack<>();
        for(char ch:s.toCharArray()){
           if(ch=='('){
                if(st.size()>0) ans.append('(');
                st.push(ch);
           }
           else {
                st.pop();
                if(st.size()>0) ans.append(ch);
           }
        }

        return ans.toString();
    }
}