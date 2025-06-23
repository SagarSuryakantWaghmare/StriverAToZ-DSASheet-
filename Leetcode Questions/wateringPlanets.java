public class wateringPlanets{
    public static int countPlanets(int planets[],int capacity){
        int steps=0;
        int temp=capacity;
        int n=planets.length;
        for(int i=0;i<n;i++){
            if(planets[i]>temp){
                steps=2*i;
                temp-=capacity;
            }
            else{
                temp-=planets[i];
            }
     
        }
        return steps;
    }
    public static void main(String[]args){
        int planets[]={10,20,3,29,29,1};
        int k=15;
        System.out.println("The number of Steps required to water all the planets: " + countSteps(planets, k));
    }
}