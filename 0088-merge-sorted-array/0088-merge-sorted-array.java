class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        for(int i=0; i<m; i++){
            nums[i] = nums1[i];
        }
        int i=0, j=0, k=0; 
        while(i<m && j<n){
            if(nums[i] < nums2[j]){
                nums1[k] = nums[i];
                i++;
            }else{
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        if(i!=m){
            while(i<m) {
                nums1[k] = nums[i];
            k++;
            i++;
            }
        }
        if(j != n){
            while(j<n){
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }
    }
}