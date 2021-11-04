package Group2.Set1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quadruplets {
    static public List<List<Integer>> quadruplets(int[] nums, int x)
    {
        int l = nums.length;
        HashMap<String,Boolean> map = new HashMap<>();
        List<List<Integer>> newList = new ArrayList<>();
        for(int i=0;i<l-3;i++){
            for(int j=i+1;j<l-2;j++){
                for(int k=j+1;k<l-1;k++){
                    for(int m = k+1;m<l;m++){
                        if(nums[i]+nums[j]+nums[k]+nums[m] == x){
                     //       System.out.println(nums[i]+" "+nums[j]+" " +nums[k]+" "+nums[m]);
                            List<Integer> sorted = sort(nums[i],nums[j],nums[k],nums[m]);
                            if(map.containsKey(sorted.toString())) continue;
                            else{
                                newList.add(sorted);
                                map.put(sorted.toString(),true);
                            }
                        }
                    }
                }
            }
        }
        return newList;
    }

    static List<Integer> sort(int i,int j,int k,int m){
        List<Integer> ll = new ArrayList<>();
        int[] arr = {i,j,k,m};
        Arrays.sort(arr);
        for(int x=0;x<arr.length;x++) ll.add(arr[x]);
        return ll;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine().trim());

        int arr[] = new int[n];

        StringTokenizer tk = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int x = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> answer = quadruplets(arr, x);

        for (int p = 0; p < answer.size(); p++)
        {
            for (int q = 0; q < 4; q++)
            {
                System.out.print(answer.get(p).get(q) + " ");
            }
            System.out.println();
        }
    }
}
