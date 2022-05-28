class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Greedy Method
        //counting the occurences/frequencies of tasks
        int counter[] = new int[26];
        for(char task : tasks){
            counter[task - 'A']++;
        }
        //sort according to the frequencies
        Arrays.sort(counter);
        //max freq is at end
        int maxFreq = counter[25];
        int idle = (maxFreq-1) * n;
        
        for(int i = 24;i >= 0; i--){
            if(counter[i] != 0){
                idle -= Math.min(counter[i], maxFreq - 1);
            }
        }
        
        idle = Math.max(0, idle);
        return tasks.length + idle;
    }
}

