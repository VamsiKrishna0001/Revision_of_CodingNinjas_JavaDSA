package Lecture23_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StacksUsing2Queues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public StacksUsing2Queues() {
        //Implement the Constructor
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public int size(){
    return q1.size();
    }

    public boolean isEmpty(){
    return q1.isEmpty();
    }

    public void push(int ele){
        q1.add(ele);
    }

    public int top(){
        if(isEmpty()){
            return -1;
        }
        while(q1.size()>1) {
            q2.add(q1.poll());
        }
        int temp = q1.peek();
        q2.add(q1.poll());
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return temp;

    }

    public int pop(){
        if (isEmpty()) return -1;
        while (!q1.isEmpty()){
            q2.add(q1.poll());
        }
        int temp = q2.poll();
        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return temp;

//        if(isEmpty()){
//            return -1;
//        }
//        while(q1.size()>1) {
//            q2.add(q1.poll());
//        }
//        int temp = q1.poll();
//        Queue<Integer> t = q1;
//        q1 = q2;
//        q2 = t;
//        return temp;
    }
}
