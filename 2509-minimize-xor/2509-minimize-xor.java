class Solution {
public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;  
            }
            num = num >> 1;
        }
        return count;
    }

    public int minimizeXor(int num1, int num2) {
        int setbits = countSetBits(num2);
        int result=0;

        for(int i=31;i>=0 && setbits>0;i--){
            if((num1 & (1<<i))!=0){
                result = result | (1<<i);
                setbits--; 
            } 
        }

        for(int i=0;i<31 && setbits>0;i++){
            if((num1 & (1<<i))==0){
                result = result | (1<<i);
                setbits--; 
            } 
        }

        return result;
    }
}