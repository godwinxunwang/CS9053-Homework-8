package edu.nyu.cs9053.homework8;

/*This is the class that represents each Weighted Job. Each job is represented by
three attributes: a start time "start", a finish time "finish", and a value "val".
*/

public class WeightedJob {
    private final int start, finish, val;

    public WeightedJob(int start, int finish, int val){
        this.start = start;
        this.finish = finish;
        this.val = val;
    }

    public Integer getStartTime() {
        return this.start;
    }

    public Integer getFinishTime() {
        return this.finish;
    }

    public Integer getWeight() {
        return this.val;
    }

    public void print(){
        System.out.print("[" + Integer.toString(start) + ", " + Integer.toString(finish)
            + ", " + Integer.toString(val)  + "]");
    }
}
