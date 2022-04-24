we took "-" in middle of the startstation and endstation because there will be a case like
1. startstation: aa  and endstation : ab
2. startstation: aaa and endstation : b
for above both of them there will an amboguity if we store without "-" in middle
for optimisation instead of storing the array in mapout we can just store the sum
```
class UndergroundSystem {
Map<Integer,List<String>> mapin = new HashMap<>();
Map<String,List<Integer>> mapout = new HashMap<>();
public UndergroundSystem() {
}
public void checkIn(int id, String stationName, int t) {
mapin.put(id,new ArrayList<>());
mapin.get(id).add(stationName);
mapin.get(id).add(t+"");
}
public void checkOut(int id, String stationName, int t) {
List<String> startstation = mapin.get(id);
if(!mapout.containsKey(startstation.get(0)+"-"+stationName)){
mapout.put(startstation.get(0)+"-"+stationName, new ArrayList<>());
mapout.get(startstation.get(0)+"-"+stationName).add(t-Integer.parseInt(startstation.get(1)));
}
else{
mapout.get(startstation.get(0)+"-"+stationName).add(t-Integer.parseInt(startstation.get(1)));
}
}
public double getAverageTime(String startStation, String endStation) {
List<Integer> arr = mapout.get(startStation+"-"+endStation);
double sum = 0;
for(double ele:arr) sum+=ele;
return sum/arr.size();
}
}
​
```