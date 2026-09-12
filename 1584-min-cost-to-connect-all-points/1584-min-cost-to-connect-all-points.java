class Solution {
    public int minCostConnectPoints(int[][] points) {

        int len = points.length;

        ArrayList<int[]>[] graph = new ArrayList[len];

        for(int i=0;i<len;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){

                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int cost = Math.abs(Math.abs(x1-x2) + Math.abs(y1-y2));

                graph[i].add(new int[]{j,cost});
                graph[j].add(new int[]{i,cost});

            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[] visited = new boolean[len];
        int minCost = 0;

        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){

            int curr[] = pq.poll();

            int wei = curr[0];
            int node = curr[1];

            if(visited[node]) continue;

            visited[node] = true;
            minCost += wei;

            for(int[] edge : graph[node]){
                int nei = edge[0];
                int newWei = edge[1];

                if(!visited[nei]){
                    pq.add(new int[]{newWei,nei});
                }
            }
        }
        return minCost;
        
    }
}