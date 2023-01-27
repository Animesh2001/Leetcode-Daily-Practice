class Solution {
  HashSet<String> set;
  
  private boolean isConcatenated(String word, int i) {
    if (i > 0 && set.contains(word.substring(i)))
      return true;

    for (int j = i+1; j < word.length(); j++) {
      if (set.contains(word.substring(i, j)) && isConcatenated(word, j)) {
        set.add(word.substring(i));
        return true;
      }
    }
    return false;
  }
  
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    set = new HashSet<>(Arrays.asList(words));
    List<String> ans = new ArrayList<>();

    for (String word : words)
      if (isConcatenated(word, 0))
        ans.add(word);
    
    return ans;
  }
}