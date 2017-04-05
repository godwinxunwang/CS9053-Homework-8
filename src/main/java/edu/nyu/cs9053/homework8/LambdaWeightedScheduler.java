package edu.nyu.cs9053.homework8;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* Assume we have a set of weighted jobs needed to be complete. In the set "Jobs",
there are number of N (labeled as 1..n) jobs. This program is to select a compatible
subset of weighted jobs of maximum total value.
*/

public class LambdaWeightedScheduler {
    private final int startTime, finishTime;

    /* This method finds the total weight of all jobs in an ArrayList<WeightedJob> */
    private int getTotalWeight(ArrayList<WeightedJob> jobs) {
        int res = 0;
        for (int i=0; i<jobs.size(); i++) {
            res += jobs.get(i).getWeight();
        }
        return res;
    }

    public LambdaWeightedScheduler(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    /* This method takes in the given weighted jobs, and returns the subset of jobs that
    carrys the maximum total weights. If each job has its weight, greedy approach is no
    longer optimal. Instead, we should use dynamic programming approach to solve this problem. */
    public ArrayList<WeightedJob> findOptimal(ArrayList<WeightedJob> jobs){
        /* At first, remove invalid jobs in the ArrayList using Iterator<> to ensure a safe
        modification on a collection during iteration */
        for (Iterator<WeightedJob> iter = jobs.iterator(); iter.hasNext(); ){
            WeightedJob job = iter.next();
            if (job.getFinishTime() > this.finishTime || job.getStartTime() < this.startTime) {
                iter.remove();
            }
        }
        // Get the number of available jobs
        int size = jobs.size();
        // Sort all elements by their finishing times
        Collections.sort(jobs, new Comparator<WeightedJob>() {
            @Override
            public int compare(WeightedJob job1, WeightedJob job2) {
                return job1.getFinishTime().compareTo(job2.getFinishTime());
            }
        });
        // Create a table to record the current optimal subsets at each index
        ArrayList<ArrayList<WeightedJob>> dpTable = new ArrayList<>();
        /* Initialize the dpTable (at the beginning, the subset at each entry only
        contains the corresponding job at the same index in "jobs". */
        for (int i=0; i<size; i++) {
            ArrayList<WeightedJob> list = new ArrayList<WeightedJob>();
            list.add(jobs.get(i));
            dpTable.add(list);
        }
        /* Then, starting from i=1, let j parse through the indices before i (j < i). If the job at i
        conflict with the job at j, we should not put their subsets together. If not conflicted, these jobs
        then can co-exist, so we can merge them together and store the merged subset at index i in dpTable. */
        for (int i=1; i<size; i++) {
            /* If the current job at index i contains greater weight than the previous sunset, then use it to
            update the table entry. */
            if (getTotalWeight(dpTable.get(i-1)) < jobs.get(i).getWeight()){
                ArrayList<WeightedJob> newList = new ArrayList<WeightedJob>();
                newList.add(jobs.get(i));
                dpTable.set(i, newList);
            }
            for (int j=i-1; j>=0; j--) {
                // check whether jobs overlap
                if (jobs.get(j).getFinishTime() <= jobs.get(i).getStartTime()) {
                    // if the new total weight is greater than the old total weight, then we add the new set
                    if (getTotalWeight(dpTable.get(j)) + jobs.get(i).getWeight() > getTotalWeight(dpTable.get(i))){
                        ArrayList<WeightedJob> subset = new ArrayList<WeightedJob>(dpTable.get(j));
                        subset.add(jobs.get(i));
                        dpTable.set(i, subset);
                        break;
                    }
                }
            }
        }
        // find the entry in dpTable that has the maximum total weight, and return it
        ArrayList<WeightedJob> res = new ArrayList<WeightedJob>(); int currentMaxWeight = 0;
        for (int i=0; i<size; i++) {
            int currentWeight = getTotalWeight(dpTable.get(i));
            if (currentWeight > currentMaxWeight) {
                res = dpTable.get(i);
                currentMaxWeight = currentWeight;
            }
        }
        return res;
    }
}
