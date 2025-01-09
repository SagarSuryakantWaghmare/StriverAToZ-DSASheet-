public class MedianOfTwoSortedArrays {
    // public static int median(int arr1[], int arr2[]) {
    //     int n1 = arr1.length;
    //     int n2 = arr2.length;
    //     int arr[] = new int[n1 + n2];
    //     int n = arr.length;
    //     int s1 = 0;
    //     int s2 = 0;
    //     int s = 0;
    //     while (s1 < n1 && s2 < n2) {
    //         if (arr1[s1] < arr2[s2]) {
    //             arr[s] = arr1[s1];
    //             s1++;
    //         } else {
    
    //             arr[s] = arr2[s2];
    //             s2++;
    //         }
    //         s++;
    //     }
    //     while (s1 < n1) {
    //         arr[s] = arr1[s1];
    //         s++;
    //         s1++;
    //     }
    //     while (s2 < n2) {
    //         arr[s] = arr2[s2];
    //         s++;
    //         s2++;
    //     }
    //     int n3 = arr.length;

    
    //     return n3%2==1?arr[(n3 - 1) / 2]: (arr[n3 / 2] + arr[(n3 / 2) - 1]) / 2;
    // }

    public static int median(int arr1[], int arr2[]){
      int n1=arr1.length;
      int n2=arr2.length;
      int i=0;
      int j=0;
      int n=(n1+n2);
      int ind2=n/2;
      int ind1=ind2-1;
      int count=0;
      int i1=-1;
      int i2=-1;
      while (i<n1&&j<n2) {
        if(arr1[i]<arr2[j]){
            if(count==ind1) i1=arr1[i];
            if(count==ind2) i2=arr1[i];
            count++;
            i++;
        }
        else{
            if(count==ind1) i1=arr1[j];
            if(count==ind2) i2=arr2[j];
            count++;
            j++;
        }
      }
      while (i<n1) {
        if(count==ind1) i1=arr1[i];
        if(count==ind2) i2=arr2[i];
        count++;
        i++;
      }
      while (j<n2) {
        if(count==ind1) i1=arr2[j];
        if(count==ind2) i2=arr2[j];
        count++;
        j++;
      }
      if(n%2==1) return i2;
      return (int)((double)(i1+i2)/2.0);
    }
    public static void main(String[] args) {
        int arr1[] = { 1, 3, 5, 7, 8 };
        int arr2[] = { 3, 6, 7, 9, 10, 12 };
        System.out.println(median(arr1, arr2));
    }
}
