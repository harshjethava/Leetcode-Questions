class Solution {

    boolean dfs(int curr, boolean[] visited, List<Integer>[] graph, boolean recPath[]){
        
        visited[curr] = true;
        recPath[curr] = true;

        for(int nei : graph[curr]){
            if(!visited[nei]){
                if(dfs(nei, visited, graph, recPath)){
                    return true;
                }
            }else if(recPath[nei]){
                return true;
            }
        }
        recPath[curr] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }

        int len = prerequisites.length;
        for(int i=0;i<len;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph[u].add(v);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recPath = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i, visited, graph, recPath)){
                    return false;
                }
            }
        }
        return true;
    }
}