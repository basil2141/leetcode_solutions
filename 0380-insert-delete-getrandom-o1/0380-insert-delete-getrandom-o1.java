class RandomizedSet {
    Map<Integer, Integer> map ;
    List<Integer> list ;
    public RandomizedSet() {
      map  = new HashMap<>();
      list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        
        if(map.containsKey(val)){
            int idx = map.get(val);
            int lastElement = list.get(list.size() - 1);
            
            list.set(idx, lastElement);
            list.remove(list.size() - 1);

            map.put(lastElement, idx);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int rand = (int)( Math.random()  *  (list.size()));
        return list.get(rand);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */