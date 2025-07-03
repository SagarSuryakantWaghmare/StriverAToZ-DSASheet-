class ReachNumber {
    public int reachNumber(int target) {
       target=Math.abs(target);
       int sum=0;
       int steps=0;
       while(sum<target||(sum-target)%2!=0){
        steps++;
        sum+=steps;
       } 
       return steps;
    }
    public static void main(String[] args) {
        ReachNumber rn = new ReachNumber();
        System.out.println(rn.reachNumber(2)); // Output: 3
        System.out.println(rn.reachNumber(3)); // Output: 2
        System.out.println(rn.reachNumber(4)); // Output: 3
        System.out.println(rn.reachNumber(-2)); // Output: 3
    }

}