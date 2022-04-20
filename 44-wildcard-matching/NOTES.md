int n=s.length(),m=p.length();
boolean prev[] = new boolean[m+1];
//base case
prev[0] = true;
for(int j=1;j<=m;j++){
if(p.charAt(j-1)=='*')
prev[j]=true;
else
prev[j]=false;
}
//nested loops
for(int i=1;i<=n;i++){
boolean curr[] = new boolean[m+1];
curr[0] = false;
for(int j=1;j<=m;j++){
if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
curr[j] = prev[j-1];
else if(p.charAt(j-1)=='*')
curr[j] = prev[j] || curr[j-1];
else
curr[j] = false;
}
prev=curr;
}
return prev[m];
}
}
```