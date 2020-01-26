//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

public class TheWrongWayCow {

	public static int[] findWrongWayCow(final char[][] field) {
		// Fill in the code to return the x,y coordinate position of the
		// head (letter 'c') of the wrong way cow!
		int[] cowLocation = new int[2];
		int rightCowCount = 0;
		int leftCowCount = 0;
		int upCowCount = 0;
		int downCowCount = 0;
		int rightX = 0;
		int rightY = 0;
		int leftX = 0;
		int leftY = 0;
		int upX = 0;
		int upY = 0;
		int downX = 0;
		int downY = 0;
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				if (field[i][j] == 'c') {
					if (i < field.length-1) {
						if (field[i + 1][j] == 'o') {
							rightCowCount += 1;
							rightX = j;
							rightY = i;
						}
					}
					if (i > 0) {
						if (field[i - 1][j] == 'o') {
							leftCowCount += 1;
							leftX = j;
							leftY = i;
						}
					}
					if (j < field.length-1) {
						if (field[i][j + 1] == 'o') {
							downCowCount += 1;
							upX = j;
							upY = i;
						}
					}
					if (j > 0) {
						if (field[i][j - 1] == 'o') {
							upCowCount += 1;
							downX = j;
							downY = i;
						}
					}
				}
			}
		}
		if(rightCowCount>1 || leftCowCount>1 || upCowCount>1 || downCowCount>1 && 
		rightCowCount==1 || leftCowCount==1 || upCowCount==1 || downCowCount==1) {
			if (rightCowCount == 1) {
			cowLocation[0] = rightX;
			cowLocation[1] = rightY;
			System.out.println(rightX);
			System.out.println(rightY);
		} else if (leftCowCount == 1) {
			cowLocation[0] = leftX;
			cowLocation[1] = leftY;
			System.out.println(leftX);
			System.out.println(leftY);
		} else if (upCowCount == 1) {
			cowLocation[0] = upX;
			cowLocation[1] = upY;
			System.out.println(upX);
			System.out.println(upY);
		} else if (downCowCount == 1) {
			cowLocation[0] = downX;
			cowLocation[1] = downY;
			System.out.println(downX);
			System.out.println(downY);
		}
		}
		return cowLocation;
	}
}
