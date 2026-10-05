class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans= new ArrayList<>();
        backtrack(0,num,target,"",ans,0,0);
        return ans;
    }
    private void backtrack(int index,String num, int target,String curr,List<String> ans,long prev,long res){

         // Base case
        if(index==num.length()){
            if(res==target){
                ans.add(curr);
            }
            return;
        }
        String st="";
        long currRes=0;
        for(int i=index;i<num.length();i++){

            // Don't allow numbers like "05"
            if(i>index && num.charAt(index)=='0') break;
            st+=num.charAt(i);
            currRes=currRes*10+(num.charAt(i)-'0');

            // First number: no operator before it
            if(index==0){
                backtrack(i+1,num,target,st,ans,currRes,currRes);
            }
            else{

                //+
                backtrack(i+1,num,target,curr+"+"+st,ans,currRes,res+currRes);

                //-
                backtrack(i+1,num,target,curr+"-"+st,ans,-currRes,res-currRes);

                //*
                backtrack(i+1,num,target,curr+"*"+st,ans,prev *currRes,res-prev+(currRes*prev));
            }
        }
    }
}