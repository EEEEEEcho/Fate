package com.code.Dynamic;

public class RobDemo2 {
    /**
     * 核心思想：
     * 如果偷窃了第一间房屋，则不能偷窃最后一间房屋，因此偷窃房屋的范围是第一间房屋到最后第二间房屋；
     * 如果偷窃了最后一间房屋，则不能偷窃第一间房屋，因此偷窃房屋的范围是第二间房屋到最后一间房屋
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        else if(len == 2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            //偷第一间房，不偷最后一间房
            int m = nums[0];
            int n = Math.max(nums[0],nums[1]);
            for (int i = 2; i < nums.length - 1; i++) {
                int tmp = n;
                n = Math.max(m + nums[i],n);
                m = tmp;
            }

            //不偷第一间房。偷最后一间房
            int x = nums[1];
            int y = Math.max(nums[1], nums[2]);
            for (int i = 3; i < nums.length; i++) {
                int tmp = y;
                y = Math.max(x + nums[i],y);
                x = tmp;
            }

            return Math.max(n,y);
        }
    }
}
