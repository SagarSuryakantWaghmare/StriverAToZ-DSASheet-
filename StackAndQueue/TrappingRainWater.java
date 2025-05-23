public class TrappingRainWater {
    // public static int trap(int [] height){
    //     int n=height.length;
    //     if(n==0){
    //         return 0;
    //     }
    //     int []left=new int[n];
    //     int []right=new int[n];
    //     // Finding the prefix max
    //     left[0]=height[0];
    //     for(int i=1;i<n;i++){
    //         left[i]=Math.max(left[i-1],height[i]);
    //     }
    //     // Finding the suffix max
    //     right[n-1]=height[n-1];
    //     for(int i=n-2;i>=0;i--){
    //         right[i]=Math.max(right[i+1],height[i]);
    //     }
    //     int water=0;
    //     // Finding the water trapped
    //     for(int i=0;i<n;i++){
    //         water+=Math.min(left[i],right[i])-height[i];
    //     }
    //     return water;

    // }

    //Optimal Solution
    public static int trap(int [] height){
        int n=height.length;
        if(n==0){
            return 0;
        }
        int left=0;
        int right=n-1;
        int leftMax=0;
        int rightMax=0;
        int water=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    water+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    water+=rightMax-height[right];
                }
                right--;
            }
        }
        return water;
    }
    
public static void main(String[] args) {
    int [] height={0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trap(height));

}
}