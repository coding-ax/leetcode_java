package 周赛;

import java.math.BigInteger;

public class 数的平方 {
    public int numTriplets(int[] nums1, int[] nums2) {
        // 循环寻找
        int count =0;
        for(int i=0;i<nums1.length;i++){
            long num = nums1[i] * nums1[i];
            for(int j=0;j<nums2.length;j++){
                // 必须能被整除才有寻找的意义
                if(num%nums2[j]==0){
                    long target = num/nums2[j];
                    for(int k=j+1;k<nums2.length;k++){
                        // 找到了
                        if(nums2[k]==target){
                            count++;
                        }
                    }
                }
            }
        }
        for(int i=0;i<nums2.length;i++){
            long num = nums2[i] * nums2[i];
            for(int j=0;j<nums1.length;j++){
                // 必须能被整除才有寻找的意义
                if(num%nums1[j]==0){
                    long target = num/nums1[j];
                    for(int k=j+1;k<nums1.length;k++){
                        // 找到了
                        if(nums1[k]==target){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
