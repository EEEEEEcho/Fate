package com.code.ArrayTrain;

import java.util.LinkedList;
import java.util.Queue;

class Index{
    int row;
    int col;
    public Index(int row,int col){
        this.row = row;
        this.col = col;
    }
}

/**
 * 000
 * 011
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        image[sr][sc] = -1;
        Queue<Index> queue = new LinkedList<>();
        Index root = new Index(sr,sc);
        queue.add(root);
        while (!queue.isEmpty()){
            Index node = queue.poll();
            int x = node.row;
            int y = node.col;
            if (x - 1 >= 0 && image[x-1][y] == oldColor){
                image[x-1][y] = -1;
                queue.add(new Index(x-1,y));
            }
            if (x + 1 < image.length && image[x+1][y] == oldColor){
                image[x+1][y] = -1;
                queue.add(new Index(x+1,y));
            }
            if (y - 1 >= 0 && image[x][y - 1] == oldColor){
                image[x][y - 1] = -1;
                queue.add(new Index(x,y-1));
            }
            if (y + 1 <image[0].length && image[x][y + 1] == oldColor){
                image[x][y + 1] = -1;
                queue.add(new Index(x,y + 1));
            }
        }
        for (int i = 0;i < image.length;i ++){
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == -1){
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
}
