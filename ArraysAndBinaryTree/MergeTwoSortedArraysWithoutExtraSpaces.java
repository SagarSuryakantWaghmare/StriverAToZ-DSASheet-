import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpaces {
    //Using teh extra spaces
    // public static void merge(int[]arr1,int []arr2,int n,int m){
    //     int arr3[]=new int[n+m];
    //     int left=0;
    //     int right=0;
    //     int index=0;
    //     while (left<n&&right<m) {
    //         if(arr1[left]<=arr2[right]){
    //              arr3[index]=arr1[left];
    //              left++;
    //              index++;
    //         }
    //         else{
    //             arr3[index]=arr2[right];
    //             right++;
    //             index++;
    //         }
    //     }
    //     while (left<n) {
    //         arr3[index++]=arr1[left++];
    //     }
    //     while (right<m) {
    //         arr3[index++]=arr2[right++];
    //     }
    //     for(int i=0;i<n+m;i++){
    //         if(i<n) arr1[i]=arr3[i];
    //         else arr2[i-n]=arr3[i];
    //     }

    // }

    // Using the optimal solution in the space complexity:O(1)
    // public static void merge(int[]arr1,int[]arr2,int n,int m){
    //     int left=n-1;
    //     int right=0;
    //     while(left>=0&&right<m){
    //         if(arr1[left]>arr2[right]){
    //             swap(left,right,arr1,arr2);
    //             left--;
    //             right++;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     Arrays.sort(arr1);
    //     Arrays.sort(arr2);
    // }
    // public static void swap(int left,int right,int arr1[],int arr2[]){
    //     int temp=arr1[left];
    //     arr1[left]=arr2[right];
    //     arr2[right]=temp;
    // }

    // Optimal solution one-gap method-shell sort
    public static void merge(int arr1[], int arr2[], int n, int m) {
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // arr1 and arr2
                if (left < n && right >= n) {
                    if (arr1[left] > arr2[right - n]) {
                        int temp = arr1[left];
                        arr1[left] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                // arr2 and arr2
                else if (left >= n) {
                    if (arr2[left - n] > arr2[right - n]) {
                        int temp = arr2[left - n];
                        arr2[left - n] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }
                // arr1 and arr1
                else {
                    if (arr1[left] > arr1[right]) {
                        int temp = arr1[left];
                        arr1[left] = arr1[right];
                        arr1[right] = temp;
                    }
                }
                left++;
                right++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void main(String[] args) {
        int arr1[]={1,3,5,7};
        int arr2[]={0,2,6,8,9};
        int n=arr1.length;
        int m=arr2.length;
        // We have to solve this problem without using the extra spaces
        merge(arr1,arr2,n,m);
        System.out.println("Array 1 is :");
        for (int i : arr1) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Array 2 is :");
        for (int i : arr2) {
            System.out.print(i+" ");
        }
    }
}
