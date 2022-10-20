class Solution {
    // private String inttostr(int n) {
    //     if(n == 1) return "I";
    //     // else if(n == 4) return "IV";
    //     else if(n == 5) return "V";
    //     // else if(n == 9) return "IX";
    //     else if(n == 10) return "X";
    //     // else if(n == 40) return "XL";
    //     else if(n == 50) return "L";
    //     // else if(n == 90) return "XC";
    //     else if(n == 100) return "C";
    //     // else if(n == 400) return "CD";
    //     else if(n == 500) return "D";
    //     // else if(n == 900) return "CM";
    //     else if(n == 1000) return "M";
    // }
    public String intToRoman(int num) {
        // StringBuilder sb = new StringBuilder();
        String ans = "";
        
        int dig = num%10;
        num -= dig;
        
        if(dig == 4) {
            ans += "IV";
            dig = 0;
        }
        else if(dig == 9) {
            ans+= "IX";
            dig = 0;
        }
        else if(dig >= 5 && dig < 9) {
            ans += "V";
            dig -= 5;
        }
        if(dig < 4) {
            while(dig-- > 0)
                ans += "I";
        }
        
        dig = num%100;
        num -= dig;
        if(dig == 40) {
            ans = "XL" + ans;
            dig = 0;
        }
        else if(dig == 90) {
            ans = "XC" + ans;
            dig = 0;
        }
        if(dig >= 50){
            while(dig > 50) {
                ans = "X"+ans;
                dig -= 10;
            }
            if(dig == 50) {
                ans = "L"+ans;
                dig -= 50;
            }
        }
        else {
            while(dig >= 10) {
                ans = "X"+ans;
                dig -= 10;
            }
        }
        
        dig = num%1000;
        num -= dig;
        if(dig == 400) {
            ans = "CD" + ans;
            dig = 0;
        }
        else if(dig == 900) {
            ans = "CM" + ans;
            dig = 0;
        }
        else if(dig >= 500){
            while(dig > 500) {
                ans = "C"+ans;
                dig -= 100;
            }
            if(dig == 500) {
                ans = "D"+ans;
                dig -= 500;
            }
        }
        else {
            while(dig >= 100) {
                ans = "C"+ans;
                dig -= 100;
            }
        }
        
        dig = num%10000;
        while(dig >= 1000) {
            ans = "M" + ans;
            dig -= 1000;
        }
        
        return ans;
    }
}