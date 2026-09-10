class Solution {
    boolean isCycle(int curr, boolean[] visited, List<Integer>[] graph, boolean[] recPath, int V) {
        visited[curr] = true;
        recPath[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            int v = graph[curr].get(i); 

            if (!visited[v]) {
                if (isCycle(v, visited, graph, recPath, V)) {
                    return true;
                }
            } else if (recPath[v]) {
                return true;
            }
        }

        recPath[curr] = false;
        return false;
    }

    void dfs(int curr, boolean visited[], ArrayList<Integer>[] graph, Stack<Integer> stack){
        
        visited[curr] = true;
        for(int nei : graph[curr]){
            if(!visited[nei]){
               dfs(nei, visited, graph, stack);
            }
        }
        stack.push(curr);
    }
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        
        int len = edges.length;
        for(int i=0;i<len;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[v].add(u);
        }
            
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        boolean[] recPath = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycle(i, visited, graph, recPath, V)){
                    return new int[0];
                }
            }
        }
        visited = new boolean[V]; 
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i, visited, graph, stack);
            }
        }

        int[] res = new int[V];
        int size = stack.size();
        for(int i=0;i<size;i++){
           res[i] = stack.pop();
        }
        return res;
    }
}