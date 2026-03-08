class Solution {
    public boolean isMatch(String s, String p) {
        int sptr = 0 , pptr = 0;
        int startidx = -1 , stmpidx = -1;

        while(sptr < s.length()) {

            // if character matches or pattern has '?'
            if(pptr < p.length() && 
               (p.charAt(pptr) == '?' || p.charAt(pptr) == s.charAt(sptr))) {
                pptr++;
                sptr++;
            } 

            // if pattern has '*', record its position
            else if(pptr < p.length() && p.charAt(pptr) == '*') {
                startidx = pptr;
                stmpidx = sptr;
                pptr++;
            }

            // if mismatch but '*' was found earlier, backtrack
            else if(startidx != -1) {
                pptr = startidx + 1;
                stmpidx++;
                sptr = stmpidx;
            } 

            // mismatch and no '*' to backtrack
            else {
                return false;
            }
        }

        // check if remaining pattern has only '*'
        while(pptr < p.length() && p.charAt(pptr) == '*') {
            pptr++;
        }

        return pptr == p.length();
    }
}