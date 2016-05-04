/**
 * 
 */
package hadoopTest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Iver3oN Zhang
 * @date 2016��4��21��
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

	// ����ҵ����SJF���̵����㷨
	public static float waitingTimeSJF(int[] requestTimes, int[] durations) {
		int now = 0;
		int SumTime = 0;
		int realNum = requestTimes.length;
		int[] finishTime = new int[requestTimes.length];
		int[] duration_avg = new int[requestTimes.length];
		int[] sumTime = new int[requestTimes.length];
		int min = 0;
		now = requestTimes[0] + durations[0];// �����һ�ε�now
		finishTime[0] = durations[0];// �����һ�����̵����ʱ��
		duration_avg[0] = 1;// ����ֵ��
		int allin = 0, j, k;
		for (int i = 1; i < realNum; i++)// ����ѭ�����ӵڶ�������Ľ��̿�ʼ
		{
			k = 1;
			min = 0;
			if (allin == 0)// �ҵ��Ѿ�����Ľ��̸���
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
			j = j - 1;// j���Ѿ�����Ľ���������ȥ�Ѿ�������ĵ�һ�����̣�
			while (k <= j)// ���Ѿ�����Ľ������ҵ�����ʱ����̵Ľ���
			{
				if (duration_avg[k] == 0)// ���̵ķ���ʱ���������0���������ý���
					k++;
				else {
					if (duration_avg[min] > duration_avg[k])// �Ƚϣ��ҵ�����ʱ����̵Ľ���
						min = k;
					k++;
				}

			}
			duration_avg[min] = 0;// ��������㣬������һ��ѭ��ʱ����
			now  = now+durations[min];// �ۼӵ�ǰʱ��
			finishTime[min] = now;// ���ʱ��
		}
		for (int i = 0; i < realNum; i++)// ������תʱ�䣬��Ȩ��תʱ�䣬�ܵ���תʱ����ܵĴ�Ȩ��תʱ��
		{
			System.out.println(finishTime[i]+"--"+requestTimes[i]);
			sumTime[i] = finishTime[i] - requestTimes[i];
			// WeightsumTime[i] = (double)sumTime[i] / ServiceTime[i];
			SumTime += sumTime[i];
			// SumWWT_SJF += WeightsumTime[i];
		}
		float average = SumTime / realNum;// ƽ����תʱ��
		// AverageWWT_SJF = (double)SumWWT_SJF / realNum;// ƽ����Ȩ��תʱ��
		System.out.println(SumTime);
		// ���ÿ�����̵����ʱ�䡢��תʱ�䡢��Ȩ��תʱ�䡢���н��̵�ƽ����תʱ���Լ���Ȩƽ����תʱ��
		return average;
	}

}
