
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        // Maps group size -> current list of person IDs
        Map<Integer, List<Integer>> sizeToGroupMap = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            int desiredSize = groupSizes[i];
            
            // Get the existing temporary group or initialize a new one
            sizeToGroupMap.putIfAbsent(desiredSize, new ArrayList<>());
            List<Integer> currentGroup = sizeToGroupMap.get(desiredSize);
            
            // Add the current person ID to the group
            currentGroup.add(i);
            
            // If the group reaches its full capacity, push it to results
            if (currentGroup.size() == desiredSize) {
                result.add(new ArrayList<>(currentGroup));
                currentGroup.clear(); // Clear the buffer for the next group of this size
            }
        }
        
        return result;
    }
}
