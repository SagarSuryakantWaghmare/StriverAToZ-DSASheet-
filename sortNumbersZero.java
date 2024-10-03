public class sortNumbersZero {
    public static void main(String[] args) {
        // So we have to sort the zero,one and two's
        // Merge sort is the brute force approach
        
        // we have the better  solution
        int arr[]={0,1,1,2,0,1,2,0,2,0,1,2,0};
        sort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }

    }
    // Optimal solution
    // Deutch national flag algorithm

    // Three pointer algorithm

    // low ,mid and high

    // Three rules
    // every 0 to low-1-0 extreme left
    // every low to mid-1-1
    // every mid to high-1-0,1,2 unsorted
    // high+1 to n-1

    // starting low,mid on the 0 and high on the n-1
    //  a[mid]==0 swap(a[low],a[mid]) low++,mid++
    //  a[mid]==1 mid++
    //  a[mid]==2 swap(a[mid],a[high]) high-- mid++;
    public static void sort(int arr[]){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while (mid<=high) {
            if(arr[mid]==0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1){
              mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }


    public static void swap(int []arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    // O(2n):better solution
    // we can modify the given array without using extra array
    // private static int[] sort(int[] arr) {
    //     int count0=0;
    //     int count1=0;
    //     int count2=0;
    //     for (int i = 0; i < arr.length; i++) {
    //         if(arr[i]==0){
    //             count0++;
    //         }
    //         else if(arr[i]==1){
    //             count1++;
    //         }
    //         else{
    //             count2++;
    //         }
    //     }
    //     int ans[]=new int[arr.length];
    //     for (int i = 0; i <count0; i++) {
    //         ans[i]=0;
    //     }
    //     for(int i=count0;i<count0+count1;i++){
    //         ans[i]=1;
    //     }
    //     for (int i = count0+count1; i < count0+count1+count2; i++) {
    //         ans[i]=2;
    //     }
    //     return ans;
    // }
}
