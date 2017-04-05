package edu.nyu.cs9053.homework8;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

/*This is a tester class for LambdaScheduler and LambdaWeightedScheduler.*/

public class Tester {
    public static void testLambdaScheduler(ArrayList<Job> jobs, int start, int end) {
        System.out.print("(Unweighted) Input: ");
        for (Job j: jobs) {
            j.print();
        }
        System.out.println();
        LambdaScheduler lsr = new LambdaScheduler(start, end);
        ArrayList<Job> result = lsr.findOptimal(jobs);
        System.out.print("(Unweighted) Result: ");
        for (Job j : result) {
            j.print();
        }
        System.out.println();
    }

    public static void testLambdaWeightedScheduler(ArrayList<WeightedJob> jobs, int start, int end) {
        System.out.print("(Weighted) Input: ");
        for (WeightedJob j: jobs) {
            j.print();
        }
        System.out.println();
        LambdaWeightedScheduler lsr = new LambdaWeightedScheduler(start, end);
        ArrayList<WeightedJob> result = lsr.findOptimal(jobs);
        System.out.print("(Weighted) Result: ");
        for (WeightedJob j : result) {
            j.print();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test LambdaScheduler class using the inputs below
        ArrayList<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job(0, 3));
        jobs.add(new Job(1, 5));
        jobs.add(new Job(2, 5));
        jobs.add(new Job(4, 8));
        jobs.add(new Job(3, 7));
        jobs.add(new Job(5, 8));
        jobs.add(new Job(5, 9));
        jobs.add(new Job(1, 2));
        jobs.add(new Job(3, 5));
        jobs.add(new Job(4, 8));
        jobs.add(new Job(7, 9));
        jobs.add(new Job(0, 8));
        jobs.add(new Job(9, 13));
        testLambdaScheduler(jobs, 1, 15);

        // Test LambdaWeightedScheduler class using the cases below
        ArrayList<WeightedJob> weightedJobs = new ArrayList<WeightedJob>();
        weightedJobs.add(new WeightedJob(0, 3, 9));
        weightedJobs.add(new WeightedJob(2, 5, 8));
        weightedJobs.add(new WeightedJob(4, 6, 7));
        weightedJobs.add(new WeightedJob(6, 7, 4));
        weightedJobs.add(new WeightedJob(5, 8, 11));
        weightedJobs.add(new WeightedJob(8, 12, 9));
        weightedJobs.add(new WeightedJob(7, 11, 22));
        weightedJobs.add(new WeightedJob(7, 9, 8));
        testLambdaWeightedScheduler(weightedJobs, 1, 13);
    }
}
