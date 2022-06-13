// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int max = 0;
        for(Job j: arr){
            max = Math.max(max, j.deadline);
        }
        //take an array for 
        boolean jobseq[] = new boolean[max+1];
        //-1 indicates that the no job is taken in that time slice
        // Arrays.fill(jobseq, -1);
        
        //sorting according to the profits as we need maximize profits
        Arrays.sort(arr, (a,b)-> b.profit - a.profit);
        
        int maxProfit = 0, count = 0;
        for(Job j:arr){
            int ind = j.deadline;
            if(!jobseq[ind]){
                jobseq[ind] = true;
                maxProfit += j.profit;
                count++;
            }
            else{
                for(int i = ind -1; i>0;i--){
                    if(!jobseq[i]){
                        jobseq[i] = true;
                        maxProfit += j.profit;
                        count++;
                        break;
                    }
                }
            }
        }
        return new int[]{count, maxProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/