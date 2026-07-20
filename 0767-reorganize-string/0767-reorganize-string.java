class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> b.freq - a.freq
        );
        int max = 0, n = s.length();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
            if(map.get(ch) > max ) max = map.get(ch);
        }

        if(max > (n + 1)/2) return "";
        StringBuilder sb = new StringBuilder();
        for(char x : map.keySet()){
            pq.add(new Pair(x, map.get(x)));
        }
        while(pq.size() >= 2){
            Pair first = pq.poll();
            Pair sec = pq.poll();
            sb.append(first.ch);
            first.freq--;
            if(first.freq != 0) pq.add(first);
            sb.append(sec.ch);
            sec.freq--;
            if(sec.freq != 0) pq.add(sec);
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll().ch);
        }
        return sb.toString();
    }
}
class Pair{
    char ch;
    int freq;
    public Pair(char ch, int freq){
        this.ch =ch;
        this.freq = freq;
    }
}