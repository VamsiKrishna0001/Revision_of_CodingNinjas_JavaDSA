package Group3;

import java.util.ArrayList;
import java.util.Scanner;

/*
public class WarOnNinjaLand {
    static class Node
    {
        int id;
        boolean isRationalised;
        ArrayList<Node> adlist = new ArrayList<>();
        Node(int id)
        {
            this.id = id;
            this.isRationalised = false;
        }
    }
    static class Tree
    {
        ArrayList<Node> nodelist = new ArrayList<>();
        public Node getNode(int i)
        {
            Node node = new Node(i);
            nodelist.add(node);
            return node;
        }
        public void addEdge(Node u, Node v)
        {
            u.adlist.add(v);
            v.adlist.add(u);
        }
        public int createTree(int[] arr)
        {
            Queue<Node> q = new LinkedList<>();
            q.add(getNode(nodelist.size()));

            int i = 1;
            while(!q.isEmpty())
            {
                Node nd = q.remove();
                int val = arr[i];
                for(int j=1;j<=val;j++)
                {
                    Node node = new Node(nodelist.size());
                    nodelist.add(node);
                    q.add(node);
                    addEdge(nd, node);
                }
                i+=val;
                i++;
            }

            q = new LinkedList<>();
            for(Node node: nodelist)
            {
                if(node.adlist.size()==1) {
                    q.add(node.adlist.get(0));
                }
            }

            int count = 0;

            while(!q.isEmpty())
            {
                Node cur = q.remove();
                if(!cur.isRationalised)
                {
                    cur.isRationalised = true;
                    count++;
                    System.out.println(cur.id);
                    for(Node nd: cur.adlist)
                    {
                        if(nd.isRationalised)
                            continue;
                        nd.isRationalised = true;
                        boolean hasLeaf = false;
                        for(Node adnd: nd.adlist)
                        {
                            if(adnd.adlist.size()==1)
                                hasLeaf = true;
                        }
                        if(hasLeaf)
                        {
                            q.add(nd);
                            nd.isRationalised = false;
                            continue;
                        }
                        for(Node adnd : nd.adlist)
                            if(!adnd.isRationalised)
                                q.add(adnd);
                    }
                }
            }

            return count;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] linearr = line.split(" ");
        int[] arr = new int[linearr.length];
        for(int i=0;i<linearr.length;i++)
        {
            arr[i] = Integer.parseInt(linearr[i]);
        }
        Tree tr = new Tree();
        int noh = tr.createTree(arr);

        if(noh>sc.nextInt())
        {
            System.out.println(noh+" Mission Unsuccessful");
        }
        else System.out.println(noh+" Mission Successful");
    }
}
 */
class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data){
        this.data = data;
        children = new ArrayList<TreeNode<T>>();
    }
}
public class warOnNinjas {
    static class QueueEmptyException extends Exception {
    }

    static class QueueUsingLL<T> {

        class Node<T> {
            T data;
            Node<T> next;
            Node(T data){
                this.data = data;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            if(size == 0){
                return true;
            }
            return false;
        }

        public T front() throws QueueEmptyException{
            if(size == 0){
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }

            return head.data;
        }
        public void enqueue(T element){
            Node<T> newNode = new Node<T>(element);

            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }

            size++;
        }

        public T dequeue() throws QueueEmptyException{
            if(head == null){
                QueueEmptyException e = new QueueEmptyException();
                throw e;
            }
            if(head == tail){
                tail = null;
            }
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }

        static int minLandingCover(TreeNode<Integer> root) {
        //Write your code here
            int sum=0;
            if (dfs(root,sum)==0){
                sum++;
            }else {
                sum= dfs(root,sum);
            }
            return sum;

        }

        static int dfs(TreeNode<Integer> root,int sum){
        if (root == null){
            return 1;
        }
        if (root.children.size()==0){
            return 0;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int ans=0;
        for (int i=0;i<root.children.size();i++){
            int left = dfs(root.children.get(i),sum);
            arr.add(left);
        }
        for (int i=0;i<arr.size();i++){
            if (arr.get(i) == 0){
                sum++;
                ans =2;
                return ans;
            }
        }
            for (int i=0;i<arr.size();i++){
                 if (arr.get(i) == 2){
                    ans= 1;
                    return ans;
                }
            }
            for (int i=0;i<arr.size();i++){
                if (arr.get(i) == 1){
                    ans =0;
                    return ans;
                }
            }


        return ans;
    }



    static void printAns(int allowed, int ans)
    {
        if (ans <= allowed)
        {
            System.out.println(ans + " Mission Successful");
        }
        else{
            System.out.println(ans + " Mission Unsuccessful");
        }
    }

    static Scanner s = new Scanner(System.in);

    public static TreeNode<Integer> takeInputLevelWise(){
        QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of nodes that are entered themselves but their children aren't added yet
        int rootData = s.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.enqueue(root);
        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> currentNode;
            try {
                currentNode = pendingNodes.dequeue();
                int numChild = s.nextInt();
                for(int i = 0 ; i < numChild; i++){
                    int currentChild = s.nextInt();
                    TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
                    pendingNodes.enqueue(childNode);
                    currentNode.children.add(childNode);
                }
            } catch (QueueEmptyException e) {
            }
        }
        return root;
    }


    public static void main(String[] args) {

        TreeNode<Integer> root =  takeInputLevelWise();
        int allowed;
        allowed = s.nextInt();
        int final_ans = minLandingCover(root);
        printAns(allowed, final_ans);

    }

}
