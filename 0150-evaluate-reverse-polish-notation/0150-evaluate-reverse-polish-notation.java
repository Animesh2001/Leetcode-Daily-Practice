class Solution {

    public void cal(Stack<Integer> s2, String sym) {
        int fn = s2.pop();
        int sn = s2.pop();
        if (sym.equals("+")) {
            s2.push(fn + sn);
        } else if (sym.equals("-")) {
            s2.push(sn - fn);
        } else if (sym.equals("*")) {
            s2.push(fn * sn);
        } else {
            s2.push((int) (sn / fn));
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<String> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) {
                if (s2.size() >= 2) {
                    cal(s2, tokens[i]);
                } else {
                    s1.push(tokens[i]);
                }
            } else {
                s2.push(Integer.parseInt(tokens[i]));
            }
        }

        while (s1.size() > 0) {
            cal(s2, s1.pop());
        }

        return s2.pop();
    }
}
