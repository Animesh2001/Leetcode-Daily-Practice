class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (int j = 0; j < cpdomains.length; j++) {
            String domainName = cpdomains[j];
            int space = 0;
            while (space < domainName.length()) {
                if (domainName.charAt(space) == ' ') {
                    break;
                }
                space++;
            }
            int num = Integer.parseInt(domainName.substring(0, space));
            String remainingdomainName = domainName.substring(space + 1, domainName.length());
            if (map.containsKey(remainingdomainName)) {
                map.put(remainingdomainName, map.get(remainingdomainName) + num);
            } else {
                map.put(remainingdomainName, num);
            }

            for (int i = 0; i < remainingdomainName.length(); i++) {
                if (remainingdomainName.charAt(i) == '.') {
                    String check = remainingdomainName.substring(i + 1, remainingdomainName.length());
                    if (map.containsKey(check)) {
                        map.put(check, map.get(check) + num);
                    } else {
                        map.put(check, num);
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();

        for (String s : map.keySet()) {
            String str = "";
            str += map.get(s);
            str = str + " ";
            str = str + s;
            list.add(str);
        }
        return list;
    }
}
//900 google.mail.com
