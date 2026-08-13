class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j= 0;
        List<Integer> list = new ArrayList<>();

        while(i < len1 && j < len2){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }

        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}