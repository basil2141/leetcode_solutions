class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }
    public boolean searchHelper(TrieNode node, int index, String word){
        if(index == word.length()) return node.isWord;

        char c = word.charAt(index);
        if(c == '.'){

            for(TrieNode child : node.children.values()){
                if(searchHelper(child, index + 1, word)) return true;
            }
            return false;
        }else{
            if(!node.children.containsKey(c)) return false;
            return searchHelper(node.children.get(c), index + 1, word);
        }
    }
}
class TrieNode{
    public HashMap<Character, TrieNode> children;
    public boolean isWord;
    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */