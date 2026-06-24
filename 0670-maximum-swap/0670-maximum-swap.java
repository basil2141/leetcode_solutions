class Solution {
    public int maximumSwap(int num) {
        int[] arr = numToArray(num);
        int n = arr.length;
        int max_index = n-1;
        int left_index = -1, right_index = -1;
        
        for(int i = n-1; i>=0; i--){
            if (arr[i] > arr[max_index]){
                max_index = i;
            }else if( arr[i] < arr[max_index]){
                left_index = i; right_index = max_index;
            }else if(arr[i] == arr[max_index]) continue;
        }
        if(left_index == right_index) return num;
        swap(arr, left_index, right_index);
        int result = arrToNum(arr);
        return result;
    }

    public int arrToNum(int[] arr){
        int result = 0;
        for(int i = 0; i<arr.length; i++){
            result = result * 10 + arr[i];
        }
        return result;
    }
    public void swap(int[] arr, int i, int j){
        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int[] numToArray(int n){
        int len = 0;

        int a = n; 
        while( a > 0){
            len++;
            a /= 10;
        }
        int[] arr = new int[len];
        for(int i = len-1; i>=0; i--){
            arr[i] = n%10;
            n /=10;
        }
        return arr;
    }
}