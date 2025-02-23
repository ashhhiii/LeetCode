class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prereq : prerequisites) {
            graph[prereq[1]].add(prereq[0]);
        }

        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(graph, i, visited, stack)) {
                return new int[0]; // Cycle detected
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
        if (visited[course] == 1) return true;  // Cycle detected
        if (visited[course] == 2) return false; // Already processed
        
        visited[course] = 1; // Mark as visiting

        for (int neighbor : graph[course]) {
            if (hasCycle(graph, neighbor, visited, stack)) return true;
        }

        visited[course] = 2; // Mark as processed
        stack.push(course); // Add to stack for topological sorting
        return false;
    }
}