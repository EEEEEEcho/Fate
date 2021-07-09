package com.code.GreedyTrain;

import java.util.HashSet;

public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        //{directX,directY} = {0,1} 向北走
        //{directX,directY} = {1,0} 向东走
        //{directX,directY} = {0,-1} 向南走
        ////{directX,directY} = {-1,0} 向西走
        int[] directX = new int[]{0,1,0,-1};
        int[] directY = new int[]{1,0,-1,0};

        /**
         * direx[]direy[] 的下标 i 代表了当前机器人的方向
         * i=0,向北，i=1,向东，i=2,向南,i=3,向西
         */
        //读取到调整方向的指令时
        //"-1"：“向右转90度”，只要当前方向curdire + 1就可以得到右转方向
        //"-2"：“向左转90度”，只要当前方向curdire + 3 就可以得到左转方向 (curdire + 3) % 4，
        //因为不管curdire当前是哪个方向，左转都在其左边，在direx数组的定义中顺势针数3个就是其左边，所以就是加3

        //障碍物有多个，所以需要有一个障碍物坐标点集合
        //机器人每试图走一个位置，就用此位置与障碍物集合列表里的坐标进行比较，看是否刚好是障碍物坐标点
        //不是，则“真正走到这个点”，更新机器人坐标点(curx,cury)
        //是障碍物，那么不走下一步，停留在当前，执行下一条命令

        int curx = 0;
        int cury = 0;
        int curdirect = 0;  //面朝北
        int result = 0;
        //存储障碍物
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0;i < obstacles.length;i ++){
            hashSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        for(int i=0;i < commands.length;i ++){
            if(commands[i] == -1){
                //右转
                curdirect = (curdirect + 1) % 4;
            }
            else if(commands[i] == -2){
                //左转
                curdirect = (curdirect + 3) % 4;
            }
            else{
                //开始走，走N步，相当于一步一步走 走N次
                for(int j = 0 ;j < commands[i]; j ++){
                    int nx = curx + directX[curdirect];
                    int ny = cury + directY[curdirect];
                    if(hashSet.contains(nx+","+ny)){
                        //是障碍点，停住
                        break;
                    }
                    else{
                        curx = nx;
                        cury = ny;
                       result = Math.max(result,curx * curx + cury * cury);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RobotSim robotSim = new RobotSim();
        System.out.println(robotSim.robotSim(new int[]{4,-1,4,-2,4},new int[][]{{2,4}}));
    }
}
