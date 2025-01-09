public class ShipPackagesInNDays {
    public static int findDay(int cap,int []weights){
        int load=0;
        int days=1;
        for (int i = 0; i < weights.length; i++) {
            if(load+weights[i]>cap){
                days++;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
    public static int leastCapacity(int[] weights, int d) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }
        int low = maxi;
        int high = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int numOfDays = findDay(mid, weights);
            if (numOfDays <= d) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        System.out.println("least capacity :" + leastCapacity(weights, d));
    }
}
