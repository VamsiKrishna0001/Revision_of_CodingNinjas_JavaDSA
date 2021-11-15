package Lecture22_Stacks;

public class StackUsingArray {

    private int data[];
    private int topIndex;


    public StackUsingArray(){
        data = new int[2];
        topIndex = -1;
    }

    public StackUsingArray(int size){
        data = new int[size];
        topIndex = -1;
    }
//0(1)
    public int size(){
    return topIndex+1;
    }
//O(1)
    public void push(int ele) throws StackFullException{
        if (topIndex == data.length-1){
           // throw new StackFullException();
        }
        data[++topIndex] = ele;
    }

    private void Capacitydouble(){
        int temp[] = data;
        data = new int[2*temp.length];
        for (int i =0;i<temp.length;i++){
            data[i]=temp[i];
        }
    }
    //O(1)
    public int top() throws StackEmptyException{
        if (topIndex == -1){
        throw new StackEmptyException();
        }
    return data[topIndex];
    }
    //O(1)
    public int pop() throws StackEmptyException {
        if (topIndex == -1){
            throw new StackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;
    }
// O(1)
    public boolean isEmpty(){
    if (topIndex != -1) return false;
    return true;
    }
}
