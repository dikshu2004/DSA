class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (n < m) return -1;

        int occ = -1;
        for (int i = 0; i <= n - m; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) continue;
            if (m == 1) return i; // If needle.length() is 1, we already have a match

            int nIdx = 1;
            occ = i;  // Store occurrence
            for (int j = i + 1; j < n; j++) {
                if (haystack.charAt(j) != needle.charAt(nIdx)) {
                    occ = -1; // Reset
                    break;
                }

                if (nIdx == m - 1) return occ; // We arrived at the end of needle successfully
                else nIdx++;  // Continue iterating over needle
            }
        }
        return occ;
    }
}