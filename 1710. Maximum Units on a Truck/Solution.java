class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
		//Sort the array's second column in descending order (greatest to least).  This is because we want to prioritize
		//any boxes that have higher amounts of items.  This will give us the MAXIMUM amount of items
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1],a[1]));
		
		//Create our return value - result
        int result = 0;
		//Loop through all the box groups.  When our truckSize is less than our current numberOfBoxes, 
		//Then we can only process the remaining amount of boxes left.  For example if truckSize is 2,
		//and we have 3 boxes in our group, we can only do 2.  We are only running the loop until truckSize is 0. (Truck is full)
		//OTHERWISE, multiply the boxes by the units and add to the result.
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                result += box[0] * box[1];
                truckSize -= box[0];
            }else {
                result += truckSize * box[1];
				//We break here because our truckSize is now 0.  (Truck is full)
                break;
            }
        }
		// We either finished looping or broke because our truck is full.
         return result;
    }
    
}