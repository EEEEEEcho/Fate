package com.echo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Compare {
    int x;
    int y;

    public Compare(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FindMinTwoNum {
    /**
     * 未过
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            Compare list[] = new Compare[n];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Compare compare = new Compare(x, y);
                list[i] = compare;
            }
            Arrays.sort(list, new Comparator<Compare>() {
                @Override
                public int compare(Compare o1, Compare o2) {
                    if (o1.x <= o2.x && o1.y <= o2.y) {
                        return -1;
                    }
                    return 1;
                }
            });
            Compare compare = list[0];
            System.out.println(compare.x + " " + compare.y);
        }
    }
}
