/*
Parse and sort both the left and right lists of location IDs from the puzzle input.
Pair up the smallest number from the left list with the smallest
from the right list, the second-smallest with the second-smallest, and so on.
Compute the absolute differences between each pair and sum them to get the total distance.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // File path is passed as parameter
        File file = new File(
                "C:\\Users\\louis\\Documents\\Perso\\advent-of-code-2024\\day1\\exo1\\input.txt");

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
        
        // Sort both lists (By default sorting by ascending order)
        Collections.sort(leftList);
        Collections.sort(rightList);

        // Calculate the total distance
        int totalDistance = 0;

        // Pair the smallest numbers from both lists and calculate the absolute difference
        for (int i = 0; i < leftList.size(); i++) {
            if(i == 0){
                System.out.println(leftList.get(i));
                System.out.println(rightList.get(i));
            }
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }

        System.out.println("Total Distance: " + totalDistance);
    }
}
