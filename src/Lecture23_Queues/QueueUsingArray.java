package Lecture23_Queues;

public class QueueUsingArray {

    private int[] data;
    private int front;
    private int rear,size;
    public QueueUsingArray(){
        data = new int[5];
        front = -1;
        rear = -1;
        size=0;
    }
    public QueueUsingArray(int Capacity){
        data = new int[Capacity];
        front = -1 ;
        rear = -1;
        size=0;
    }

    public void enqueue(int ele) throws QueueFullException {
        if (size >= data.length-1){
         //   throw new QueueFullException();
            doubleCapacity();
        }
        if (size == 0) front =0;
       //***----- if circular queue ---***
       // if (rear == data.length) rear =0;
        //--------------or---------
        //  rear = (rear+1)%data.length;
        //data[rear] = ele
        data[++rear]=ele;
        size++;

    }

    private void doubleCapacity(){
        int temp[] = data;
        data = new int[2 * temp.length];
        int index=0;
        for (int i = front;i<temp.length;i++){
            data[index++] = temp[i];
        }
        for (int i=0;i<front-1;i++){
            data[index++] = temp[i];
        }
        front=0;
        rear= temp.length;
    }

    public boolean isEmpty(){
    return size == 0;
    }

    public int size(){
    return size;
    }

    public int Front() throws QueueEmptyException {
        if (size==0){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public int dequeue() throws QueueEmptyException {
        if (size==0){
            throw new QueueEmptyException();
        }
    int temp = data[front++];
        // if circular queue
//        if (front == data.length)
//            front =0;
        //--------------or---------
        //  front = (front+1)%data.length;
    size--;
    return temp;
    }

}
