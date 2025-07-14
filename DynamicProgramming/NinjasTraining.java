import java.util.*;
public class NinjasTraining {
    public static int  func(int day,int last,List<List<Integer>> points,int[][]dp){
        if(day==0){
            int maxi=0;
            for(int task=0;task<3;task++){
                if(task!=last){
                    maxi=Math.max(points.get(0).get(task),maxi);
                }
            }
            return maxi;
        }
        if(dp[day][last]!=-1) return dp[day][last];
        int maxi=0;
        for(int task=0;task<3;task++){
            if(task!=last){
               int point=points.get(day).get(task)+func(day-1,task,points,dp);
               maxi=Math.max(maxi, point);
            }
        }
        return dp[day][last]= maxi;
    }
    public static int helper(int n,List<List<Integer>> points){
        int dp[][]=new int[n][4];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return func(n-1,3,points,dp);
    }

    // Tabulation approach
    public static int helperTab(int n,List<List<Integer>> points){
        int dp[][]=new int[n][4];
        dp[0][0]=Math.max(points.get(0).get(1),points.get(0).get(2));
        dp[0][1]=Math.max(points.get(0).get(0),points.get(0).get(2));
        dp[0][2]=Math.max(points.get(0).get(0),points.get(0).get(1));
        dp[0][3]=Math.max(points.get(0).get(0),Math.max(points.get(0).get(1),points.get(0).get(2)));


        for(int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                dp[day][last]=0;
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int point=points.get(day).get(task)+dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    // Space optimization approach
    public static int spacehelper(int n,List<List<Integer>> points){
        int[] prev = new int[4];
        
        // Initialize for day 0
        prev[0] = Math.max(points.get(0).get(1), points.get(0).get(2));
        prev[1] = Math.max(points.get(0).get(0), points.get(0).get(2));
        prev[2] = Math.max(points.get(0).get(0), points.get(0).get(1));
        prev[3] = Math.max(points.get(0).get(0), Math.max(points.get(0).get(1), points.get(0).get(2)));
        
        for(int day = 1; day < n; day++){
            int[] temp = new int[4];
            for(int last = 0; last < 4; last++){
                temp[last] = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int point = points.get(day).get(task) + prev[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    public static void main(String[] args) {
        //Tasks are given like different running, eating, studing we have to find the most important for progress in the max format.
        /*
        2 1 3  d0
        3 4 6  d1
        10 1 6 d2
        8 3 7  d3*/ 
        // Write the given in the list of list format
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(2, 1, 3));
        points.add(Arrays.asList(3, 4, 6));
        points.add(Arrays.asList(10, 1, 6));
        points.add(Arrays.asList(8, 3, 7));
        int n = points.size();
        // System.out.println(helper(n, points));
        System.out.println(helperTab(n, points));




    }
}
