class Solution {
    public int candy(int[] rating) {
        int n=rating.length;
        int[] candies=new int[n];

        // Give every child at least 1 candy
        Arrays.fill(candies,1);

        // Left to right
        for(int i=1;i<n;i++){
            if(rating[i]>rating[i-1]){
                candies[i]= candies[i-1]+1;
            }
        }

        // Right to left
        for(int i=n-2;i>=0;i--){
            if(rating[i]>rating[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }

        // Calculate total candies
        int total=0;
        for(int candy:candies){
            total+=candy;
        }
        return total;
    }
}