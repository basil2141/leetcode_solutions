class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets){
            String u = ticket.get(0), v = ticket.get(1);
            adj.putIfAbsent(u, new PriorityQueue<>());

            adj.get(u).add(v);
        }
        String startNode = "JFK";
        List<String> path = new ArrayList<>();
        dfs(adj, path, startNode);
        Collections.reverse(path);
        return path;
    }

    public void dfs(Map<String, PriorityQueue<String>> adj , List<String> path, String node){
        

        PriorityQueue<String> neighbors = adj.get(node);

        while(neighbors != null && !neighbors.isEmpty()){
            String neighbor = neighbors.poll();
            dfs(adj, path, neighbor);
        }path.add(node);
    }
}