class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int mid =  ( lo+hi) / 2;

            if (arr[mid] < arr[mid + 1])
                lo = mid + 1;   // increasing part
            else
                hi = mid;       // decreasing part
        }
        return lo;
    }
}
