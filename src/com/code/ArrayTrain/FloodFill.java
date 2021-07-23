package com.code.ArrayTrain;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (sr - 1 > 0 && image[sr - 1][sc] == image[sr][sc] && image[sr - 1][sc] != newColor){
            image[sr - 1][sc] = newColor;
            floodFill(image,sr - 1,sc,newColor);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == image[sr][sc] && image[sr + 1][sc]!=newColor){
            image[sr + 1][sc] = newColor;
            floodFill(image,sr + 1,sc,newColor);
        }
        if (sc - 1 > 0 && image[sr][sc - 1] == image[sr][sc] && image[sr][sc - 1] != newColor){
            image[sr][sc - 1] = newColor;
            floodFill(image,sr,sc - 1,newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == image[sr][sc] && image[sr][sc + 1] != newColor){
            image[sr][sc + 1] = newColor;
            floodFill(image,sr,sc + 1,newColor);
        }
        return image;
    }
}
