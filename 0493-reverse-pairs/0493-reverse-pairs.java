class Solution {
    public int reversePairs(int[] arr) {
        int n=arr.length;
        return mergesort(arr,0,n-1);
    }
    private static void merge(int[] arr,int low,int mid ,int high){
        List<Integer>temp=new ArrayList<>(); // temporary array
        int left=low; // starting index of left half of arr
        int right=mid+1;// starting index of right half of arr

        //storing elements in the temporary array in a sorted manner
        while(left<=mid&&right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        // if elements on the left half are still left
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        //  if elements on the right half are still left
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        // transfering all elements from temporary to arr
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }
    private int countpair(int []arr,int low,int mid,int high){
        int right=mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high&& arr[i]>2L*arr[right]) right++;
            cnt+=(right-(mid+1));
        }
        return cnt;
    }
    private int mergesort(int[]arr,int low,int high){
        int cnt=0;
        int mid=low+(high-low)/2;
        if(low>=high) return cnt;
        cnt+=mergesort(arr,low,mid);// left half
        cnt+=mergesort(arr,mid+1,high); // right half
        cnt+=countpair(arr,low,mid,high);//Modification
        merge(arr,low,mid,high);// merging sorted halves
        return cnt;
    }
}