class Solution 
{
	
    public boolean isRobotBounded(String instructions) {
		// Create a distance int[] array to plot where the robot is.  If we increment pointer and we are facing North then:
		// Distance == [1, 0, 0, 0]
        int[] distance = new int[4]; 
		// Use the pointer to point to where the robot is facing.  The pointer will never go greater than 4.
		// North - 0, East - 1, South - 2, West - 3
        int pointer = 0; 
		
		// Iterate through our instructions by analyzing every char as c (convert string to a char array)
		for (char c : instructions.toCharArray()) {
			//Move forward in whichever direction
			if (c == 'G') distance[pointer]++;
			//Rotate our robot to the right.  We are reassigning our pointer by adding 1 and then modding by 4 to get the remainder.  (We should never be greater than 4)
			else if (c == 'R') pointer = ++pointer % 4;
			////Rotate our robot to the left.  We are reassigning our pointer by using a ternary operator
			// If our pointer is 0 then set the pointer to 3 else subtract 1 (We should never be greater than 4 or less than 0)
			else if (c== 'L') pointer = pointer == 0 ? 3 : --pointer;
		}
		
		//We either need the North and South to be equal AND East and West to be equal 
		//Or if our pointer > 0 then we have a robot that will return to the center.
        if (distance[0] == distance[2] && distance[1] == distance[3] || pointer > 0) return true;
        return false;
    }
}