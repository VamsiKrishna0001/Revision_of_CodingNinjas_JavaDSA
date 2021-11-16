package Lecture23_Queues;

public class QueueCollection {
    public static void main(String[] args) throws QueueEmptyException {
//        Queue<Integer> qq = new LinkedList<>();
//        qq.add(10);
//        qq.add(200);
//        qq.add(30);
//        qq.add(400);
//        qq.add(50);
//        System.out.println(qq.size());
//        System.out.println(qq.poll());
//        System.out.println(qq.peek());
//        System.out.println(qq.size());
//        System.out.println(qq.element());

//        QueueUsingStack<Integer> qq = new QueueUsingStack<>();
//        qq.enqueue(10);
//        qq.enqueue(20);
//        qq.enqueue(30);
//        qq.enqueue(40);
//        System.out.println(qq.size());
//        System.out.println(qq.isEmpty());
//        System.out.println(qq.dequeue());
//        System.out.println(qq.dequeue());
//        System.out.println(qq.front());
//        System.out.println(qq.dequeue());
//        System.out.println(qq.dequeue());

        StacksUsing2Queues st2 = new StacksUsing2Queues();
        st2.push(10);
        st2.push(200);
        st2.push(30);
        st2.push(400);
        System.out.println(st2.size());
        System.out.println(st2.isEmpty());
        System.out.println(st2.top());
        System.out.println(st2.pop());
        System.out.println(st2.pop());
        System.out.println(st2.top());
        System.out.println(st2.size());
    }
}
