package heaps;

public class MergeKSortedList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pr = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode node : a) {
            pr.add(node);
        }

        ListNode res = new ListNode(0);

        ListNode ptr = res;
        while (!pr.isEmpty()) {
            ListNode now = pr.pop();
            ptr.next = now;
            ptr = ptr.next;
            now = now.next;
            if (now != null) pr.add(now);
        }

        return res.next;
    }
}