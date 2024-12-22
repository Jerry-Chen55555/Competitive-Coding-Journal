// not my solution :p (I gave up)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Cowntact_Tracing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Observation: min # of cows required to create these sets of infected cows (intervals)
		// corresponds to the max # of days to create the intervals (more days it takes, the
		// smaller # of cows we need).
		//
		// Therefore, if we figure out the max # of days to create the intervals, then if we are
		// able to figure out a formula in which given an arbitrary interval length l and the
		// # of days it took to create that interval (d), we have solved the problem.
		//
		// Break this problem down into 2 steps:
		//
		// 1. Figure out the max # of days to create the intervals.
		// 2. Figure out the formula init#OfCows(l, d)
		//
		// Step 1:
		// Observation: Max # of days to create all the intervals is going to be the max # of days
		// to create the smallest interval (i_min). This is because if we use any more days, the
		// smallest interval that we will create will exceed i_min (proof by contradiction).
		//
		// Now the question becomes Given an interval, how do we determine the # of days to create
		// that interval? We can split into 3 disjoint test cases.
		//
		// 1. Edge Case: interval start at 1st cow or ends at last cow. The max # of days is going
		//    to be l - 1, because:
		//    a. Start at 1st cow case (e.x. 111000): Place cow at index 0, cow can only infect
		//       1 cow to the right per day.
		//    b. Ends at last cow case (e.x. 000111): Place cow at last index, cow can only infect
		//       1 cow to the left per day.
		//
		// 2. Even l: Note that we need an even # of initial cows. This is because after d days, 2d cows 
		//    will be infected. Thus, l = i + 2d (i = # of initial cows infected), which means:
		//    d = (l - 2)/2 (2 is the smallest possible value for i).
		//
		// 3. Odd l: Note that we need an odd # of cows to create an interval of odd length, as 
		//    l = i + 2d, and in order for l to be odd, i must be odd. Since the smallest possible value
		//    for i = 1, l = 1 + 2d -> d = (l - 1)/2.
		// 
		// Therefore, to figure out the max # of days to create the intervals, we just loop through all
		// the intervals, and for each interval, figure out the max # of days to create that interval and
		// if it is smaller than our current answer, we update it.
		//
		// Step 2:
		// Now that we have figured out d, we need to figure out init#OfCows(l, d).
		// 
		// Observation: For each cow, including itself, it will after d days create an infection window of
		// up to 1 + 2d. Therefore, for each interval, the min # of cows needed to create that interval is
		// given by ceil(l/(1 + 2d)). We need to use the ceil function because to cover any interval, we
		// need at least 1 cow. In the case that 1 + 2d > l, ceil(l/(1 + 2d)) = 1.
		//
		// Therefore, we just need to loop through each interval, apply that formula, and add that result
		// to our answer.
		//
		// Time Complexity: O(n), where n is the # of intervals.
		// Space Complexity: O(n), because we have to store each interval's length.
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String endState = in.readLine();
		
		// Preliminary step: Figure out the intervals.
		List<Integer> intervalLengths = new LinkedList<Integer>();
		
		int length = 0;
		boolean firstIntervalIsAtStart = false;
		boolean lastIntervalEndsAtEnd = false;
		
		for (int i = 0; i < n; i++) {
			if (endState.charAt(i) == '1') {
				if (i == 0) {
					firstIntervalIsAtStart = true;
				}
				
				length++;
			} else {
				if (length > 0) {
					intervalLengths.add(length);
				}
				
				length = 0;
			}
		}
		
		// Handle the case where the interval extends to the end.
		if (length > 0) {
			intervalLengths.add(length);
			lastIntervalEndsAtEnd = true;
		}
		
		// Step 1: Figure out the max # of days it takes to create each interval.
		int maxNumDaysToCreateIntervals = Integer.MAX_VALUE;
		
		for (int j = 0; j < intervalLengths.size(); j++) {
			Integer intervalLength = intervalLengths.get(j);
			
			// Edge Case: interval starts at 1st or ends at last cow.
			if (j == 0 && firstIntervalIsAtStart || j == intervalLengths.size() - 1 && lastIntervalEndsAtEnd) {
				maxNumDaysToCreateIntervals = Math.min(maxNumDaysToCreateIntervals, intervalLength - 1);
			}
			// Even l.
			else if (intervalLength % 2 == 0) {
				maxNumDaysToCreateIntervals = Math.min(maxNumDaysToCreateIntervals, (intervalLength - 2)/2);
			}
			// Odd l.
			else {
				maxNumDaysToCreateIntervals = Math.min(maxNumDaysToCreateIntervals, (intervalLength - 1)/2);
			}
		}
		
		// Step 2: Figure out the min # of cows to create the intervals based on the max # of days to
		// create those intervals.
		int numCows = 0;
		
		for (int k = 0; k < intervalLengths.size(); k++) {
			Integer intervalLength = intervalLengths.get(k);
			numCows += Math.ceil(intervalLength / (2.0 * maxNumDaysToCreateIntervals + 1));
		}
		
		System.out.println(numCows);
	}

}