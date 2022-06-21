class Solution {
    public String reverseWords(String s) {
        if(s == null) 
            return s;
        
        char arr[] = s.toCharArray();
        int n = arr.length;
        
        //reverse the whole string
        reverse(arr, 0, n - 1);
        
        //reverse the words 
        reverseWords(arr, n);
        
        //clean ups - removes the trailing and multiple spaces in the string
        return cleanup(arr, n);
        
    }
    private void reverse(char[] arr, int i, int j) {
        while(i < j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++; j--;
        }
    }
    private void reverseWords(char[] arr, int n) {
        int i = 0, j = 0;
        while(i < n) {
            while(i<j || (i<n && arr[i] == ' '))
                i++;
            while(j<i || (j<n && arr[j] != ' '))
                j++;
            reverse(arr, i, j - 1);
        }
    }
    private String cleanup(char[] arr, int n) {
        int i = 0, j = 0;
        while(j < n) {
            while(j<n && arr[j]==' ') 
                j++;
            while(j<n && arr[j]!=' ') 
                arr[i++] = arr[j++];
            while(j<n && arr[j]==' ') 
                j++;
            if(j<n) 
                arr[i++] = ' ';
        }
        return new String(arr).substring(0, i);
    }
    
}