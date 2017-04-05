package edu.nyu.cs9053.homework8;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* Assume we have a set of jobs needed to be complete. In the set "Jobs", there are
number of N (labeled as 1..n) jobs. This program is to select a compatible subset of
jobs of maximum possible size.
*/

public class LambdaScheduler {
    private final int startTime, finishTime;

    public LambdaScheduler(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    /* This method takes in the given unweighted jobs, and returns the subset of jobs that
    carry the maximum total number of jobs. We can simply apply greedy approach to find the
    subset of mutually compatible unweighted jobs */
    public ArrayList<Job> findOptimal(ArrayList<Job> jobs){
        /* At first, remove invalid jobs in the ArrayList using Iterator<> to ensure a safe
        modification on a collection during iteration */
        for (Iterator<Job> iter = jobs.iterator(); iter.hasNext(); ){
            Job job = iter.next();
            if (job.getFinishTime() > this.finishTime || job.getStartTime() < this.startTime) {
                iter.remove();
            }
        }
        // Sort all jobs by their finishing times in ascending order
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return job1.getFinishTime().compareTo(job2.getFinishTime());
            }
        });
        // Create an ArrayList for the selected jobs
        ArrayList<Job> selectedJobs = new ArrayList<Job>();
        int curListFinishTime = this.startTime;
        // Parse through the jobs, find the next compatible job, and add it to selectedJobs
        for (int i=1; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.getStartTime() >= curListFinishTime) {
                curListFinishTime = curr.getFinishTime();
                if (curListFinishTime >= this.finishTime) {
                    break;
                }
                selectedJobs.add(curr);
            }
        }
        return selectedJobs;
    }

}
