class Solution {

    private HashMap<Character, Integer> getMaxFrequency(String[] words2) {
        HashMap<Character, Integer> maxFreq = new HashMap<>();
        
        // For each word in words2, calculate the required frequency of each character
        for (String word : words2) {
            HashMap<Character, Integer> wordFreq = new HashMap<>();
            for (char c : word.toCharArray()) {
                wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
            }
            
            // Update maxFreq with the maximum frequency of each character needed
            for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();
                maxFreq.put(c, Math.max(maxFreq.getOrDefault(c, 0), count));
            }
        }
        
        return maxFreq;
    }

    private boolean isUniversal(String word, HashMap<Character, Integer> maxFreq) {
        HashMap<Character, Integer> wordFreq = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
        }
        
        // Check if word contains all the required frequencies
        for (Map.Entry<Character, Integer> entry : maxFreq.entrySet()) {
            char c = entry.getKey();
            int requiredCount = entry.getValue();
            if (wordFreq.getOrDefault(c, 0) < requiredCount) {
                return false;
            }
        }
        
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        
        // Precompute the required frequencies from words2
        HashMap<Character, Integer> maxFreq = getMaxFrequency(words2);
        
        // For each word in words1, check if it is a universal word
        for (String word : words1) {
            if (isUniversal(word, maxFreq)) {
                ans.add(word);
            }
        }

        return ans;
    }
}
