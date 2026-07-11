class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for(int[] pair : pairs ){
            int u = pair[0], v = pair[1];
            adj.putIfAbsent(u, new ArrayDeque<>());

            adj.get(u).add(v);
            in.put(v, in.getOrDefault(v, 0) + 1);
            out.put(u, out.getOrDefault(u, 0) + 1);
        }

        int startNode = pairs[0][0];

        for(int x : adj.keySet()){
            if(out.get(x) - in.getOrDefault(x,0) == 1){
                startNode = x;
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        dfs(adj, startNode, path);
        
        int[][] result = new int[pairs.length][2];
        Collections.reverse(path);
        for(int i = 0; i<path.size()-1; i++){
            result[i][0] = path.get(i);
            result[i][1] = path.get(i + 1);
        }
        return result;
    }

    public void dfs(Map<Integer, Deque<Integer>> adj, int node, List<Integer> path){

        Deque<Integer> neighbors = adj.get(node);

        while(neighbors != null && !neighbors.isEmpty()){
            int n = neighbors.pollFirst();

            dfs(adj, n, path);
        }
        path.add(node);
    }
}