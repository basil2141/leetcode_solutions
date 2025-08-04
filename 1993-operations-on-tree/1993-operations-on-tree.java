class LockingTree {
    Integer[] locked;
    int[] parent;
    private HashMap<Integer, List<Integer>> children;
    public LockingTree(int[] parent) {
        this.parent = parent;
        this.locked = new Integer[parent.length];
        this.children = new HashMap<>();

        for(int i=0; i<parent.length; i++){
            children.put(i, new ArrayList<>());
        }

        for(int i=1; i<parent.length; i++){
            children.get(parent[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(locked[num] == null){
            locked[num] = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(locked[num] != null && locked[num] == user){
            locked[num] = null;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if (locked[num] != null) return false;

        int i= num;
        while(i != -1){
            if(locked[i] != null) return false;
            i = parent[i];
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
        int lockedCount = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for( int child : children.get(node)){
                if(locked[child] != null){
                    lockedCount++;
                    locked[child] = null;
                }
                q.offer(child);
            }
        }
        if(lockedCount > 0) {
            locked[num] = user;
            return true;
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */