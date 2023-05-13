package heaps;

public class MinLargestNumber {
    public int solve(ArrayList<Integer> A, int B) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        for (int i : A) {
            pq.add(new Node(i));
        }

        for (int i = 0; i < B; i++) {
            Node n = pq.poll();
            n.now += n.org;
            n.next += n.org;
            pq.add(n);
        }

        int max = Integer.MIN_VALUE;
        for (Node n : pq) {
            max = Math.max(max, (int) n.now);
        }
        return max;
    }

    static class Node implements Comparable<Node> {
        long now;
        int org;
        long next;

        Node(int a) {
            now = (long) a;
            org = a;
            next = 2l * a;
        }

        public int compareTo(Node n) {
            int ans = (int) ((this.next) - (n.next));
            if (ans == 0) return this.org - n.org;

            return ans;
        }
    }
}