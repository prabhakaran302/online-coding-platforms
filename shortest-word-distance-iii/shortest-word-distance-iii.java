class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        boolean same = false;
        
        if(word1.equals(word2))
            same = true;
        
        int prev = -1;
        
        String prevw = "";
        
        for(int i = 0; i < wordsDict.length; i++) {
            if(same && wordsDict[i].equals(word1))    {
                if(prev == -1)
                    prev = i;
                else    {
                    min = Math.min(min, i - prev);
                    prev = i;
                }
            } else  {
                if(prevw.equals(wordsDict[i]))  {
                    prev = i;
                    continue;
                }
                if(wordsDict[i].equals(word1) || wordsDict[i].equals(word2))  {
                    if(prev != -1)  {
                        min = Math.min(min, i - prev);
                    }
                    prev = i;
                    prevw = wordsDict[i];
                }
            }
        }
        
        return min;
    }
}