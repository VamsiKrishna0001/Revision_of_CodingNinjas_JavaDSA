package Lecture23_Queues;

public class QueueUse {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        QueueUsingArray queue = new QueueUsingArray();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(40);
        System.out.println(queue.size());
        System.out.println(queue.Front());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.Front());

    }
}
