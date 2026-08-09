class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        // Store {capital required, profit}
        int[][]projects=new int[n][2];
        for(int i=0;i<n;i++){
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];
        }
        // Sort projects by required capital
        Arrays.sort(projects,(a,b)-> a[0]-b[0]);
        // Max heap based on profit
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
         
        for(int count=0;count<k;count++){
            // Add all affordable projects
            while(i<n&&projects[i][0]<=w){
                pq.add(projects[i][1]);
                i++;
            }
             // No project can be started
            if(pq.isEmpty()) break;
             // Choose maximum profit
            w+=pq.remove();
        }
        return w;
    }
}