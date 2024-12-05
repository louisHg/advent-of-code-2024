/*
* Sum up by reading each line of the left list,
* In how much time the number appear in the right list
* e.g :
*
* This time, you'll need to figure out exactly how often each number from the left list appears in the right list.
* Calculate a total similarity score by adding up each number
* in the left list after multiplying it by the number of times that number appears in the right list.
Here are the same example lists again:
3   4
4   3
2   5
1   3
3   9
3   3
For these example lists, here is the process of finding the similarity score:

The first number in the left list is 3. It appears in the right list three times, so the similarity score increases by 3 * 3 = 9.
The second number in the left list is 4. It appears in the right list once, so the similarity score increases by 4 * 1 = 4.
The third number in the left list is 2. It does not appear in the right list, so the similarity score does not increase (2 * 0 = 0).
The fourth number, 1, also does not appear in the right list.
The fifth number, 3, appears in the right list three times; the similarity score increases by 9.
The last number, 3, appears in the right list three times; the similarity score again increases by 9.
So, for these example lists, the similarity score at the end of this process is 31 (9 + 4 + 0 + 0 + 9 + 9).
*
* */


import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        // File path is passed as parameter
        File file = new File(
                "C:\\Users\\louis\\Documents\\Perso\\advent-of-code-2024\\day1\\exo2\\input.txt");

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            // we split into characters even if there's more than 1 character of space
            String[] parts = st.split("\\s+");

            leftList.add(Integer.parseInt(parts[0]));
            rightList.add(Integer.parseInt(parts[1]));
        }

        br.close();

        // Calculate the total distance
        int totalSumUp = 0;

        for (int i = 0; i < leftList.size(); i++) {
            int currentNumber = leftList.get(i);

            // Count how many times the current number appears in the right list
            int numberFindInRightSide = 0;
            for (int j = 0; j < rightList.size(); j++) {
                if (rightList.get(j) == currentNumber) {
                    numberFindInRightSide++;
                }
            }

            System.out.println("Left number: " + currentNumber + " appears " + numberFindInRightSide + " times in the right list");

            totalSumUp += Math.abs(currentNumber * numberFindInRightSide);
        }

        System.out.println("Final sum up: " + totalSumUp);
    }
}