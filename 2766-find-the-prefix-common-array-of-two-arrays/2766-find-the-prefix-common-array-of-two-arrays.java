class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int ans[] =new int[a.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        // map.put(b[i],1);

        for(int i=0;i<a.length;i++){
             map.put(b[i],1);
             int temp = i;
             int cnt = 0;
             while(temp>=0){
                if(map.containsKey(a[temp])) cnt++;
                temp--;
             }
             ans[i] = cnt;
        }


        return ans;
    }
}