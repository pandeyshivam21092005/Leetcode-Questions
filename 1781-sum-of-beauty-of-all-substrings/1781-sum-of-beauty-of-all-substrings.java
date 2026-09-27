class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int[]freq=new int[26];

            for(int j=i;j<n;j++){
                // Add current character
                freq[s.charAt(j)-'a']++;

                int maxfreq=0;
                int minfreq=Integer.MAX_VALUE;
                
                // Find max and min frequency
                for(int k=0;k<26;k++){
                    if(freq[k]>0){
                        maxfreq=Math.max(maxfreq,freq[k]);
                        minfreq=Math.min(minfreq,freq[k]);
                    }
                }
                ans+=maxfreq-minfreq;
            }
        }
        return ans;
    }
}