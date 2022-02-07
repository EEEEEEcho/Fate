package com.code.StackTrain;

/**
 * 对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if(points.length == 0 || points == null){
            return 0;
        }
        if(points.length < 3){
            return points.length;
        }
        int samePoint;  //相同的点
        int sameLinePoint;  //在同一条线上的点
        int max = 2;
        for(int i=0;i < points.length;i ++){
            samePoint = 0;  //每次大循环结束都要重新初始化一下相同的点的个数
            for(int j = i+1;j < points.length;j ++) {
                sameLinePoint = 1;   //两点确定一条直线，将该直线纳入总数
                int xDistance = points[j].x - points[i].x;
                int yDistance = points[j].y - points[i].y;
                if (xDistance == 0 && yDistance == 0) {
                    //同一个点
                    samePoint++;
                } else {
                    sameLinePoint = 2;
                    for (int k = j + 1; k < points.length; k++) {
                        int xDistance2 = points[k].x - points[i].x;
                        int yDistance2 = points[k].y - points[i].y;
                        if (xDistance * yDistance2 == xDistance2 * yDistance) {
                            //相乘可以避免斜率为0导致除0异常
                            sameLinePoint++;
                        }
                    }

                }
                if (max < sameLinePoint + samePoint) {
                    max = sameLinePoint + samePoint;
                }
            }
        }
        return max;
    }
}
