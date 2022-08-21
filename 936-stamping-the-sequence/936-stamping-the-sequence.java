class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        int n = t.length;
        int m = s.length;
        List<Integer> res = new ArrayList<>();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n - m + 1; i++) {
                changed |= check(s, t, i, res);
            }
        }
        for (int ch : t) {
            if (ch != '?') {
                return new int[]{};
            }
        }
        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private boolean check(char[] s, char[] t, int i, List<Integer> res) {
        boolean changed = false;
        for (int j = 0; j < s.length; j++) {
            if (t[i + j] == '?') {
                continue;
            }
            if (t[i + j] != s[j]) {
                return false;
            }
            changed = true;
        }
        if (changed) {
            for (int j = 0; j < s.length; j++) {
                t[i + j] = '?';
            }
            res.add(i);
        }
        return changed;
    }
}