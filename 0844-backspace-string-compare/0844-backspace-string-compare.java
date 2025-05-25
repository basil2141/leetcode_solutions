class Solution {
    public boolean backspaceCompare(String s, String t) {
        int index1 = s.length()-1;
        int index2 = t.length()-1;
         
        while(index1>=0 || index2>=0){
            int i1 = getValidIndex(s, index1);
            int i2 = getValidIndex(t, index2);

            if(i1<0 && i2<0) return true;
            if(i1<0 || i2<0 ) return false;
            if(s.charAt(i1)!=t.charAt(i2)) return false;

            index1 = i1-1;
            index2 = i2-1;
        }
        return true;
    }
    public static int getValidIndex(String s, int index){
        int backSpaceCount = 0;
        while(index>=0){
            if(s.charAt(index)=='#') backSpaceCount++;
            else if(backSpaceCount>0) backSpaceCount--;
            else break;
            index--;
        }
        return index;
    }
}