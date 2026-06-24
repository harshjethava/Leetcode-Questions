class RecentCounter {
    Queue<Integer> que;
    public RecentCounter() {
        que = new LinkedList<>();
    }
    
    public int ping(int t) {
        que.add(t);

        int st = t - 3000;
        while(que.peek() < st) que.poll();
        return que.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */