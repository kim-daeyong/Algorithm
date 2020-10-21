package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPopPlus {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int c = numbers[i] + numbers[j];
                if (list.indexOf(c) < 0)
                    list.add(c);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}