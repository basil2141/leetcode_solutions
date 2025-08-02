class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.children[index] == null) curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return (node != null && node.isEnd);
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }
    public TrieNode searchNode(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }
}

class TrieNode{
    public TrieNode[] children;
    public boolean isEnd;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEnd = false;
    }   
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */