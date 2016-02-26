package com.thinkgem.jeesite.test;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * 模拟3个队，3个班的产量数据
 * 
 */
public class Test {

	public static int DAY = 1; // 产生数据天数
	public static double TOTAL = 120.35; // 总产量
	public static double[] dbArr = new double[DAY * 9]; // 存放产生的数据
	public static double avg = format(TOTAL / dbArr.length);// 平均值

	public static void main(String[] args) {
		if (TOTAL >= DAY * 0.09) {
			initDB();// 初始化数据
			pingheng();// 对数据进行平衡
			printResult();// 输出结果
		} else
			System.out.println("模拟总量太小，不能完成");
	}

	/**
	 * 进行数据平衡
	 */
	public static void pingheng() {
		double sum = 0.0;
		int max = 0, min = 0;// 最大值，最小值索引
		for (int i = 0; i < dbArr.length; i++) {
			sum += dbArr[i];
			if (dbArr[i] > dbArr[max])
				max = i;
			else if (dbArr[i] < dbArr[min])
				min = i;
		}

		if (sum > TOTAL) {// 模拟的数据和大于预期
			// 能直接平衡
			if (dbArr[max] - format(sum - TOTAL) >= avg)
				dbArr[max] = format(dbArr[max] - (sum - TOTAL));
			else
				dbArr[max] = format(dbArr[max] - (dbArr[max] - avg) / 2);
		} else if (sum < TOTAL) {
			if (dbArr[min] + format(TOTAL - sum) <= avg)
				dbArr[min] = format(dbArr[min] + (TOTAL - sum));
			else
				dbArr[min] = format(dbArr[min] + (dbArr[min] + avg) / 2);
		}
		if (format(sum) != TOTAL)
			pingheng();
	}

	/**
	 * 产生随机数
	 */
	public static void initDB() {
		for (int i = 0; i < DAY * 9; i++) {
			double t = new Random().nextDouble();
			if (avg - t <= 0)
				dbArr[i] = avg;
			else {
				dbArr[i] = format(i % 2 == 0 ? avg + t : avg - t);
			}
		}
	}

	/**
	 * 格式化小数点
	 */
	public static double format(double m) {
		DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(df.format(m));
	}

	/**
	 * 输出结果
	 */
	public static void printResult() {
		for (int i = 0; i < dbArr.length / 9; i++) {
			System.out.println("--------第" + (i + 1) + "天--------");
			System.out.print("早班产量：");
			System.out.println("1队产量：" + dbArr[i * 9] + "    2队产量：" + dbArr[i * 9 + 1] + "    3队产量：" + dbArr[i * 9 + 2]);
			System.out.print("中班产量：");
			System.out.println("1队产量：" + dbArr[i * 9 + 3] + "    2队产量：" + dbArr[i * 9 + 4] + "    3队产量：" + dbArr[i * 9 + 5]);
			System.out.print("晚班产量：");
			System.out.println("1队产量：" + dbArr[i * 9 + 6] + "    2队产量：" + dbArr[i * 9 + 7] + "    3队产量：" + dbArr[i * 9 + 8]);
		}
		double result = 0.0;
		for (double d : dbArr) {
			result += d;
		}
		System.out.println("总产量验证：" + format(result));
	}
}
