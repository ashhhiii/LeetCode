class Solution {
    class DisjointSet {
    Map<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();

        String find(String x) {
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x))); 
            }
            return parent.get(x);
        }

        void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                if (rank.get(rootX) > rank.get(rootY)) {
                    parent.put(rootY, rootX);
                } else if (rank.get(rootX) < rank.get(rootY)) {
                    parent.put(rootX, rootY);
                } else {
                    parent.put(rootY, rootX);
                    rank.put(rootX, rank.get(rootX) + 1);
                }
            }
        }

        void add(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 0);
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    DisjointSet ds = new DisjointSet();
        Map<String, String> emailToName = new HashMap<>();
   
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            ds.add(firstEmail);
            emailToName.put(firstEmail, name);

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                ds.add(email);
                emailToName.put(email, name);
                ds.union(firstEmail, email);
            }
        }

        Map<String, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = ds.find(email);
            rootToEmails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (String root : rootToEmails.keySet()) {
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(emailToName.get(root)); 
            List<String> emails = rootToEmails.get(root);
            Collections.sort(emails);
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }

        return result;
    }
}