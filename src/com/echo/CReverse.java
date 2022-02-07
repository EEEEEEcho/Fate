package com.echo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 整体思想：抠出来 转 再放回去
 * 1 2 3           7 4 1           3 6 9
 * 4 5 6   顺时针   8 5 2   逆时针  2 5 8
 * 7 8 9           9 6 3           1 4 7
 */
public class CReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matricTotal[][] = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matricTotal[i][j] = scanner.nextInt();
            }
        }
        int orders[] = new int[4];
        for (int i = 0; i < 4; i++) {
            orders[i] = scanner.nextInt();
        }
        //用于反转的数组一会儿嵌套
        int size = orders[1];   //要反转部分的大小
        int matric[][] = new int[size][size];
        int indexX = orders[2] - 1;
        int indexY = orders[3] - 1;
        int preIndexY = indexY;     //记录原来的y值
        for (int i = 0; i < size; i++, indexX++) {
            for (int j = 0; j < size; j++, indexY++) {
                matric[i][j] = matricTotal[indexX][indexY];
            }
            indexY = preIndexY; //重置为原来的y值
        }
        ArrayList<Integer> list[] = new ArrayList[size];
        int kindex = 0;
        for (int i = 0; i < size; i++) {
            list[kindex] = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                list[kindex].add(matric[i][j]);
            }
            kindex++;
        }
        if (orders[0] == 1) {
            matric = Confclockwise(matric, list);
        } else if (orders[0] == 2) {
            matric = Anticlockwise(matric, list);
        }
        indexX = orders[2] - 1;
        indexY = orders[3] - 1;
        preIndexY = indexY;     //记录原来的y值
        for (int i = 0; i < size; i++, indexX++) {
            for (int j = 0; j < size; j++, indexY++) {
                matricTotal[indexX][indexY] = matric[i][j];
            }
            indexY = preIndexY; //重置为原来的y值
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matricTotal[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] Anticlockwise(int matric[][], ArrayList<Integer> list[]) {
        int size = list.length;
        for (int i = 0; i < size; i++) {
            Collections.reverse(list[i]);
        }
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matric[j][i] = list[index].get(j);
            }
            index++;
        }
        return matric;
    }

    public static int[][] Confclockwise(int matric[][], ArrayList<Integer> list[]) {
        int size = list.length - 1;
        int index = 0;
        for (int i = size; i >= 0; i--) {
            for (int j = size; j >= 0; j--) {
                matric[j][i] = list[index].get(j);
            }
            index++;
        }
        return matric;
    }
}
