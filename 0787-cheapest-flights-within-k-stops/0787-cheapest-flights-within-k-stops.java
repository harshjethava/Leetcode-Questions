class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<int[]>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] flight : flights){

            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            graph[from].add(new int[]{to,price});
        }

        int[][] distance = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        //minHeap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,src,0});
        distance[src][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int dist = curr[0];
            int node = curr[1];
            int flightCount = curr[2];

            if(node == dst){
                return dist;
            }

            if(flightCount == k + 1){
                continue;
            }

            for(int[] edge : graph[node]){
                int nei = edge[0];
                int wei = edge[1];

                int newD = dist + wei;
                if (newD < distance[nei][flightCount + 1]) {

                    distance[nei][flightCount + 1] = newD;

                    pq.add(
                        new int[]{
                            newD,
                            nei,
                            flightCount + 1
                        }
                    );
                }
            }

        }

        return -1;
    }
}