# Job Scheduler for Unweighted and Weighted Jobs
### Xun Wang
### Homework 8 - CS-GY-9053 - New York University

#### Unweighted job scheduler requirement:  
> The first task at your new job is to optimize the cluster of EC2 machines which are running the Lambda jobs in containers. Specifically you need to create a scheduler of Lambda jobs which maximizes the number of jobs a single container can accept. For context, each Lambda job consists of the following: a starting time s until a final time t. You can assume the job can be run by at most one container at a time. Given a list of jobs you must accept a subset of the jobs, rejecting all others, so that the accepted jobs do not overlap in time.

#### My approach:
For unweighted job scheduler, we can simply apply greedy approach to find the
subset of mutually compatible unweighted jobs. The Java source code of my solution is at `src/main/java/edu/nyu/cs9053/homework8/LambdaScheduler.java`.


#### Weighted job scheduler requirement:  
>  The team is thinking about introducing prioritized jobs within Lambda. In this case someone would pay more money to have their job run first. Make an extension to your work that instead of optimizing for the number of jobs, you now maximize for the total value (i.e. each job now as an associated cost or weight and you're optimizing for the largest cost). Place this within directory/file `src/main/java/edu/nyu/cs9053/homework8/LambdaWeightedScheduler.java`

#### My approach:
If each job has its weight, greedy approach is no
longer optimal. Instead, we should use dynamic programming approach to solve this problem. The Java source code of my solution is at `src/main/java/edu/nyu/cs9053/homework8/LambdaWeightedScheduler.java`.

#### How to Run the Tester Class
I wrote my tester, and you may find the tester class at `src/main/java/edu/nyu/cs9053/homework8/Tester.java`. You may change the test cases by modifying the code in the main method. To run this tester, just simply compile everything under `src/main/java/edu/nyu/cs9053/homework8/` and then use the command
`java edu.nyu.cs9053.homework8.Tester` in Linux Terminal.
