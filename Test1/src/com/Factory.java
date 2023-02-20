package com;
import java.util.*;
public class Factory{
	private static List<Integer> asList;
	public static void main(String[] args)
	{

		Scanner scanner = new Scanner(System.in);
		List<int[]> jobData = new ArrayList<>();
		System.out.println("Enter the number of Jobs ");
		int totalTasks = scanner.nextInt();
		int[] jobDetail = null;

		asList = new ArrayList<>();
		System.out.println("Enter job start time, end time, and earnings ");
		for (int i = 0; i < totalTasks; i++) {
			jobDetail = new int[3];
			jobDetail[0] = scanner.nextInt();
			jobDetail[1] = scanner.nextInt();
			jobDetail[2] = scanner.nextInt();
			jobData.add(jobDetail);
		}
		int[] findNumberOfJobRemaining = findNumberOfJobRemaining(jobData);
		System.out.println("The number of tasks and earnings available for others");
		System.out.println("Task: "+findNumberOfJobRemaining[0]);
		System.out.println("Earning :"+findNumberOfJobRemaining[1]);
	}

	public static int[] findNumberOfJobRemaining(List<int[]> jobData){
		int[] response = new int[2];
		for (int i = 0; i < jobData.size(); i++) {
			int[] job = jobData.get(i);
			if (job[0] < job[1])asList.add(job[2]);
		}
		Collections.sort(asList);
		int sum = 0, numberOfTaskRemaining = 0, initialValue = 0;
		for (int i = 0; i < asList.size()-1; i++) {
			if (i == 0) {
				initialValue = asList.get(i);
				sum += asList.get(i);numberOfTaskRemaining++;
			} 
			else 
			{
				if (initialValue == asList.get(i))
					continue;
				else 
				{
					sum += asList.get(i);numberOfTaskRemaining++;
				}
			}
		}
		response[0] = numberOfTaskRemaining;
		response[1] = sum;
		return response;
	}
}

