class Solution {
private static final char QUESTION = '?';
private static final String STR_QUESTION = "?";
private static final char CHAR_Z = 'z';
private static final char CHAR_A = 'a';
private static final String STR_A = "a";

    public String modifyString(String s) {
        int len = s.length();
        if (len == 1) {
            return STR_QUESTION.equals(s) ? STR_A : s;
        }
        char[] chArr = s.toCharArray();

        for (int i = 0; i < len; i++) {
            if (chArr[i] != QUESTION) {
                continue;
            }

            if (i == 0) {
                chArr[0] = chArr[1] != QUESTION ? nextCh(chArr[1]) : CHAR_A;
            } else if (i == len - 1) {
                chArr[len - 1] = nextCh(chArr[len - 2]);
            } else {
                char tmp = nextCh(chArr[i - 1]);
                chArr[i] = tmp != chArr[i + 1] ? tmp : nextCh(tmp);
            }
        }
        return new String(chArr);
    }

    private char nextCh(char ch) {
        if (ch == CHAR_Z) {
            return CHAR_A;
        }
        return (char) (ch + 1);
    }
