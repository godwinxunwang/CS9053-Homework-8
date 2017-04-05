package edu.nyu.cs9053.homework8;

/*This is the class that represents each Job. Each job is represented by two attributes:
start time "start", and a finish time "finish".
*/

public class Job {
    private final int start, finish;

    public Job(int start, int finish){
        this.start = start;
        this.finish = finish;
    }

    public Integer getStartTime() {
        return this.start;
    }

    public Integer getFinishTime() {
        return this.finish;
    }

    public void print(){
        System.out.print("[" + Integer.toString(start) + ", " + Integer.toString(finish) + "]"); 
    }

}
