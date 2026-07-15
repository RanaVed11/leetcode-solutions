class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;
    private Set<Integer> set;
    private int next;

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        next = 1;
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int val = pq.poll();
            set.remove(val);
            return val;
        }
        return next++;
    }

    public void addBack(int num) {
        if (num < next && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}
