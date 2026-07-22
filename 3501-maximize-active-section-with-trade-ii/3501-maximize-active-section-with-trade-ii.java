class SparseTable {

    private List<List<Integer>> tab;

    public SparseTable(List<Integer> arr) {
        tab = new ArrayList<>();
        tab.add(new ArrayList<>(arr));
        int pw = 1, siz = tab.get(0).size();

        while (2 * pw <= siz + 1) {
            List<Integer> prv = tab.get(tab.size() - 1);
            List<Integer> cur = new ArrayList<>();

            for (int idx = 0; idx < siz - 2 * pw + 1; idx++) {
                cur.add(Math.max(prv.get(idx), prv.get(idx + pw)));
            }

            tab.add(cur);
            pw <<= 1;
        }
    }

    public int query(int lft, int rgt) {
        if (lft > rgt) {
            return 0;
        }

        int len = rgt - lft + 1;
        int log = 31 - Integer.numberOfLeadingZeros(len);

        return Math.max(
            tab.get(log).get(lft),
            tab.get(log).get(rgt - (1 << log) + 1)
        );
    }
}

class Solution {

    public List<Integer> maxActiveSectionsAfterTrade(
        String str,
        int[][] qry
    ) {
        int len = str.length();
        int one = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '1') {
                one++;
            }
        }

        List<Integer> zer = new ArrayList<>();
        List<Integer> lft = new ArrayList<>();
        List<Integer> rgt = new ArrayList<>();

        int idx = 0;

        while (idx < len) {
            int beg = idx;

            while (idx < len && str.charAt(idx) == str.charAt(beg)) {
                idx++;
            }

            if (str.charAt(beg) == '0') {
                zer.add(idx - beg);
                lft.add(beg);
                rgt.add(idx - 1);
            }
        }

        int blk = zer.size();

        if (blk < 2) {
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < qry.length; i++) {
                res.add(one);
            }

            return res;
        }

        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < blk - 1; i++) {
            sum.add(zer.get(i) + zer.get(i + 1));
        }

        SparseTable spt = new SparseTable(sum);
        List<Integer> ans = new ArrayList<>();

        for (int[] cur : qry) {
            int l = cur[0];
            int r = cur[1];

            int lid = lowerBound(rgt, l);
            int rid = upperBound(lft, r) - 1;

            if (lid > blk - 1 || rid < 0 || lid >= rid) {
                ans.add(one);
                continue;
            }

            int fln = rgt.get(lid) - Math.max(lft.get(lid), l) + 1;
            int lln = Math.min(rgt.get(rid), r) - lft.get(rid) + 1;

            if (lid + 1 == rid) {
                int bst = fln + lln;
                ans.add(one + bst);
                continue;
            }

            int v1 = fln + zer.get(lid + 1);
            int v2 = zer.get(rid - 1) + lln;
            int v3 = spt.query(lid + 1, rid - 2);

            int bst = Math.max(Math.max(v1, v2), v3);
            ans.add(one + bst);
        }

        return ans;
    }

    private int lowerBound(List<Integer> lst, int tar) {
        int l = 0;
        int r = lst.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (lst.get(mid) < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int upperBound(List<Integer> lst, int tar) {
        int l = 0;
        int r = lst.size();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (lst.get(mid) <= tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}