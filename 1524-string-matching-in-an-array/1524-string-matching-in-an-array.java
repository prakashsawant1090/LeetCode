class Solution {
    boolean find(String[] words,String search){
        for(String str : words){
            if(str !=search && str.indexOf(search)!=-1) return true;
        }
        return false;
    }

    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();

        for(String str : words){
            if(find(words,str))  ans.add(str);
        }

        return ans;
        
    }
}