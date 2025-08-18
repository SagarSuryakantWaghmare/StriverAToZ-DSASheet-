public class BuyAndSellStockWithCooldown {
    public static int MaxProfitTab(int prices[]){
        int n=prices.length;
        int dp[][]=new int[n+2][2];
        for(int i=n-1;i>=0;i--){
            for(int b=0;b<=1;b++){
                int profit=0;
                if(b==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],
                    0+dp[i+1][1]);
                }
                else{
                    profit=Math.max(prices[i]+dp[i+2][1],
                    0+dp[i+1][0]);
                }
                dp[i][b]=profit;
            }
        }
        return dp[0][1];
    }
    public static int MaxProfitSpace(int []prices){
        int n=prices.length;
        int curr[]=new int[2];
        int after1[]=new int[2];
        int after2[]=new int[2];
        for(int i=n-1;i>=0;i--){
            for(int b=0;b<=1;b++){
                int profit=0;
                if(b==1){
                    profit=Math.max(-prices[i]+after1[0],
                    0+after1[1]);
                }
                else{
                    profit=Math.max(prices[i]+after2[1],
                    0+after1[0]);
                }
                curr[b]=profit;
            }
            after2=after1.clone();
            after1=curr.clone();
        }
        return after1[1];
    }
    public static void main(String[]args){
        int prices[]={4, 9, 0, 4, 10};
        // System.out.println("Max profit by sell and buy with cooldown: "+MaxProfitTab(prices));

        // Space optimization
        System.out.println("Max profit by sell and buy with cooldown: "+MaxProfitSpace(prices));
    }
}
