public class DominosProblem {
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int forces[] = new int[n];
        int force = 0;
        StringBuilder res = new StringBuilder();
        // left to right
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n;
            } else if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }
        force=0;

        // Right to left
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;

            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        for (int f : forces) {
            if (f > 0) {
                res.append('R');
            } else if (f < 0) {
                res.append('L');
            } else {
                res.append('.');
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        System.out.println(pushDominoes(dominoes)); // Output: "LL.RR.LLRRLL.."
    }
}
