package com.manage.practise;

/*
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[]args) {
        int[] data = {9,5,77,3,2,8};
        System.out.println("冒泡排序法： ");
        System.out.println("原始数据为： ");
        //遍历数组
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
        //冒泡排序
        bubbleSort(data);
    }
    public static void bubbleSort(int[]data) {
        //temp用于数组元素交换
        int temp;
        //i记录扫描次数
        for(int i = data.length - 1; i > 0; i--) {
            //进行这一轮的冒泡排序
            for(int j = 0; j < i; j++) {
                //从第一个元素开始和下一个比较，比下一个大则交换
                if(data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
            System.out.print("第" + (data.length - i) +"次排序结果为： ");
            //输出本次排序后的结果
            for(int k = 0; k < data.length; k++) {
                System.out.print(data[k] + " ");
            }
            System.out.print("\n");
        }
    }
}
