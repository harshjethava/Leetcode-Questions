// class Solution {
//     public int minCostConnectPoints(int[][] points) {

//         int len = points.length;

//         ArrayList<int[]>[] graph = new ArrayList[len];

//         for(int i=0;i<len;i++){
//             graph[i] = new ArrayList<>();
//         }

//         for(int i=0;i<len-1;i++){
//             for(int j=i+1;j<len;j++){

//                 int x1 = points[i][0];
//                 int y1 = points[i][1];

//                 int x2 = points[j][0];
//                 int y2 = points[j][1];

//                 int cost = Math.abs(Math.abs(x1-x2) + Math.abs(y1-y2));

//                 graph[i].add(new int[]{j,cost});
//                 graph[j].add(new int[]{i,cost});

//             }
//         }

//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
//         boolean[] visited = new boolean[len];
//         int minCost = 0;

//         pq.add(new int[]{0,0});

//         while(!pq.isEmpty()){

//             int curr[] = pq.poll();

//             int wei = curr[0];
//             int node = curr[1];

//             if(visited[node]) continue;

//             visited[node] = true;
//             minCost += wei;

//             for(int[] edge : graph[node]){
//                 int nei = edge[0];
//                 int newWei = edge[1];

//                 if(!visited[nei]){
//                     pq.add(new int[]{newWei,nei});
//                 }
//             }
//         }
//         return minCost;
        
//     }
// }

//Using Kruskal's Algorithm
class Solution {

    static class DSU{

        int[] par;
        int[] rank;

        DSU(int n){            
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                par[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x){
            if(par[x] == x) return x;
            return par[x] = find(par[x]);
        }

        boolean union(int a, int b){
            int parA = find(a);
            int parB = find(b);

            if(parA == parB){
                return false;
            }

            if(rank[parA] == rank[parB]){
                par[parB] = parA;
                rank[parA]++;
            }else if(rank[parA] > rank[parB]){
                par[parB] = parA;
            }else{
                par[parA] = parB;
            }
            return true;
        }

    }

    public int minCostConnectPoints(int[][] points) {

        int len = points.length;

        // 1. Initialize the requested adjacency list structure
        // graph[u] stores elements as int[] {v, weight}
        ArrayList<int[]>[] graph = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. Populate the adjacency list with Manhattan distances
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i].add(new int[]{j, distance});
                // Note: For Kruskal's, adding one direction (i -> j) is enough to collect all unique edges.
            }
        }

        // 3. Flatten the adjacency list into a flat list for sorting
        // Each entry in flattenedEdges will be: int[] {u, v, weight}
        List<int[]> flattenedEdges = new ArrayList<>();
        for (int u = 0; u < len; u++) {
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int weight = edge[1];
                flattenedEdges.add(new int[]{u, v, weight});
            }
        }

        // 4. Sort the flat list of edges by weight (index 2)
        Collections.sort(flattenedEdges, (a, b) -> Integer.compare(a[2], b[2]));

        DSU dsu = new DSU(len);
        int minCost = 0;
        int totalE = 0;

        for(int[] edge : flattenedEdges){

            int u = edge[0];
            int v = edge[1];
            int wei = edge[2];

            if(dsu.union(u,v)){
                minCost += wei;
                totalE++;

                if(totalE == len - 1){
                    break;
                }
            }
        } 

        return minCost;
    }
}

