public class CountRotations {
    public static int minDominoRotations(int[]tops,int bottoms[]){
        int rotate=Math.min(check(tops[0],tops,bottoms), check(bottoms[0],tops,bottoms));
        return rotate==Integer.MAX_VALUE?-1:rotate;
    }
    public static int check(int target,int[]tops,int []bottoms){
        int rotateTop=0;
        int rotateBottom=0;
        for (int i = 0; i < bottoms.length; i++) {
            if(target!=tops[i]&&target!=bottoms[i]){
                return Integer.MAX_VALUE;
            }
            else if(target!=tops[i]){
                rotateBottom++;
            }
            else if(target!=bottoms[i]){
                rotateTop++;
            }
        }
        return Math.min(rotateTop, rotateBottom);
    }
    public static void main(String[] args) {
        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};

        int result = minDominoRotations(tops, bottoms);
        System.out.println("Minimum rotations needed: " + result);
    }
}
