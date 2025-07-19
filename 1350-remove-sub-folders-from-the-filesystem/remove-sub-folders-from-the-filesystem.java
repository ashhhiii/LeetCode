class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result  =  new ArrayList<>();

        String prev = "";
        for (String curr : folder){
            if(prev.isEmpty() || !curr.startsWith(prev +'/')){
                result.add(curr);
                prev = curr;
            }
        }
        return result;
    }
}