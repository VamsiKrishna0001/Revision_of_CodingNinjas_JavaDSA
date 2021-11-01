package LinekedList1;

import java.util.ArrayList;

public class RemoveDuplicateFromArray {
    public static ArrayList<Integer> removeconsecutiveElements(int[] arr){
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(arr[0]);
        for (int i=1;i< arr.length;i++){
            if (arr[i-1]!=arr[i]){
                res.add(arr[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,10,20,20,30,40,10};
        ArrayList<Integer> ress = removeconsecutiveElements(arr);
        for (int i=0;i<ress.size();i++){
            System.out.print(ress.get(i)+" ");
        }

    }
}
