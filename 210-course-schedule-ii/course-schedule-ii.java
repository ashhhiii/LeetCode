class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prereq : prerequisites) {
            graph[prereq[1]].add(prereq[0]);
        }

        int[] visited = new int[numCourses]; 
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(graph, i, visited, stack)) {
                return new int[0]; 
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            order[index++] = stack.pop();
        }
        return order;
    }

    private boolean hasCycle(List<Integer>[] graph, int course, int[] visited, Stack<Integer> stack) {
        if (visited[course] == 1) return true;  
        if (visited[course] == 2) return false;
        
        visited[course] = 1; 

        for (int neighbor : graph[course]) {
            if (hasCycle(graph, neighbor, visited, stack)) return true;
        }

        visited[course] = 2; 
        stack.push(course); 
        return false;
    }
}