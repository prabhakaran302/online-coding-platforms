class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
		Map<Character, Integer> map = new HashMap<>();
		for (char c : magazine.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);

		for (char c : ransomNote.toCharArray()) {
			if (!map.containsKey(c))
				return false;
			map.put(c, map.get(c) - 1);
			if (map.get(c) == 0)
				map.remove(c);
		}

		return true;
	
    }
}