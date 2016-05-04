/**
 * 
 */
package hadoopTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Iver3oN Zhang
 * @date 2016年4月21日
 * @email grepzwb@qq.com Main.java Impossible is nothing
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] page = { 1, 2, 1, 3, 1, 2 };
		int max = 2;
		//System.out.println(countCacheMiss(max, page));
		int[] start = { 8, 9, 10, 11 };
		int[] dur = { 1, 2, 1, 4 };
		System.out.println(waitingTimeSJF(start, dur));
	}

	// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
	// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
	// DEFINE ANY CLASS AND METHOD NEEDED
	// CLASS BEGINS, THIS CLASS IS REQUIRED
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int countCacheMiss(int max_cache_size, int[] page_requests) {
		int num = max_cache_size;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < page_requests.length; i++) {
			if (queue.size() < max_cache_size) {
				queue.add(page_requests[i]);
			}
			if (i >= max_cache_size) {
				if (queue.contains(page_requests[i])) {
					continue;
				} else {
					queue.poll();
					queue.add(page_requests[i]);
					num++;
				}
			}
		}
		return num;
		// INSERT YOUR CODE HERE
	}

	// METHOD SIGNATURE ENDS

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static float waitingTimeSJF1(int[] requestTimes, int[] durations) {
		int time = 0;
		int temp = 0;

		Queue<Integer> waitQueue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		int startTime = requestTimes[0];
		time = durations[0];
		for (int i = 1; i < requestTimes.length; i++) {
			if (requestTimes[i] - startTime > time) {

			}
		}

		return 0;
		// INSERT YOUR CODE HERE

	}

	// 短作业优先SJF进程调度算法
	public static float waitingTimeSJF(int[] requestTimes, int[] durations) {
		int now = 0;
		int SumTime = 0;
		int realNum = requestTimes.length;
		int[] finishTime = new int[requestTimes.length];
		int[] duration_avg = new int[requestTimes.length];
		int[] sumTime = new int[requestTimes.length];
		int min = 0;
		now = requestTimes[0] + durations[0];// 计算第一次的now
		finishTime[0] = durations[0];// 计算第一个进程的完成时间
		duration_avg[0] = 1;// 赋初值。
		int allin = 0, j, k;
		for (int i = 1; i < realNum; i++)// 进入循环，从第二个到达的进程开始
		{
			k = 1;
			min = 0;
			if (allin == 0)// 找到已经到达的进程个数
			{
				for (j = 0; j < realNum&&requestTimes[j] <= now; j++)
				{
					if (j >= realNum) {
						allin = 1;
					}
				}
			} else {
				j = realNum;
			}
			j = j - 1;// j是已经到达的进程数（减去已经计算过的第一个进程）
			while (k <= j)// 从已经到达的进程里找到服务时间最短的进程
			{
				if (duration_avg[k] == 0)// 进程的服务时间如果等于0，则跳过该进程
					k++;
				else {
					if (duration_avg[min] > duration_avg[k])// 比较，找到服务时间最短的进程
						min = k;
					k++;
				}

			}
			duration_avg[min] = 0;// 找完后置零，便于下一次循环时跳过
			now  = now+durations[min];// 累加当前时间
			finishTime[min] = now;// 完成时间
		}
		for (int i = 0; i < realNum; i++)// 计算周转时间，带权周转时间，总的周转时间和总的带权周转时间
		{
			System.out.println(finishTime[i]+"--"+requestTimes[i]);
			sumTime[i] = finishTime[i] - requestTimes[i];
			// WeightsumTime[i] = (double)sumTime[i] / ServiceTime[i];
			SumTime += sumTime[i];
			// SumWWT_SJF += WeightsumTime[i];
		}
		float average = SumTime / realNum;// 平均周转时间
		// AverageWWT_SJF = (double)SumWWT_SJF / realNum;// 平均带权周转时间
		System.out.println(SumTime);
		// 输出每个进程的完成时间、周转时间、带权周转时间、所有进程的平均周转时间以及带权平均周转时间
		return average;
	}

}
