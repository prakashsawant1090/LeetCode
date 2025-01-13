class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer> map =new HashMap<>();
        int deleted = 0;
        for(char c : s.toCharArray())  map.put(c,map.getOrDefault(c,0)+1);

        for(int count : map.values()){
            System.out.println("count "+count);
            while(count >=3){
                deleted +=2;
                count -= 2;
            }
        }

        System.out.println("deleted"+deleted);

        return s.length()-deleted;
    }
}