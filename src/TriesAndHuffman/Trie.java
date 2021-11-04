package TriesAndHuffman;


class TrieNode{
    char data;
    boolean isTerminating;
    TrieNode children[];

    public TrieNode(char data){
        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];
    }

    public TrieNode() {

        children = new TrieNode[26];
        isTerminating = false;
        for (int i = 0; i < 26; i++)
        {
            children[i] = null;
        }
    }
}
public class Trie {

    public TrieNode root;
    //    public static void main(String[] args)  {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//
//        String[] words = new String[n];
//        for(int i = 0; i < n; i++) {
//            words[i]=s.next();
//            add(words[i]);
//        }
//        for (int i=0;i<n;i++){
//            printer(root,words[i]);
//        }
//
//    }
    public  Trie(){
        root = new TrieNode('\0');
    }
    public  void add(String word){
    add(root,word);

    }
    public  void add(TrieNode root,String word){
        if (word.length()== 0){
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0)-'a';
        TrieNode child = root.children[childIndex];
        if (child == null){
            child = new TrieNode(word.charAt(0));
            root.children[childIndex]=child;
        }
        /*
        trienode *current;
    int index = s[0] - 'a';
    if (root->children[index] != NULL)
    {
        current = root->children[index];
    }
    else
    {
        current = new trienode();
        root->children[index] = current;
        current = root->children[index];
    }
         */

//        TrieNode child;
//        int childIndex = word.charAt(0)-'a';
//        if (root.children!=null){
//            child = root.children[childIndex];
//        }else {
//            child = new TrieNode();
//            root.children[childIndex]=child;
//            child = root.children[childIndex];
//        }
        add(child,word.substring(1));
    }

    public  void printer(TrieNode root,String s){
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (current.children[index]==null){
                System.out.println("No Suggestions");
                add(root,s);
                return;

            }else {
                current=current.children[index];
            }
        }
    helper(current,s);
    }

    public  void helper(TrieNode current,String prefix){
        boolean check = true;
        if (current.isTerminating) {
            System.out.println(prefix) ;
        }
        for (int i=0;i<26;i++){
            TrieNode temp = current;
            if (temp.children[i]!=null){
                char suffix=  (char) (i+ (int)'a');
                helper(current.children[i],prefix+suffix );
            }
        }
    }



}
