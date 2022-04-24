class Pair{
    Double sum;
    int numofele;
    Pair(Double s, int n){
        sum = s;
        numofele = n; 
    }
}
class UndergroundSystem {
    Map<Integer,List<String>> mapin = new HashMap<>();
    Map<String,Pair> mapout = new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        mapin.put(id,new ArrayList<>());
        mapin.get(id).add(stationName);
        mapin.get(id).add(t+"");
    }
    
    public void checkOut(int id, String stationName, int t) {
        List<String> startstation = mapin.get(id);
        mapin.remove(id);
        String routeName = startstation.get(0)+"-"+stationName;
        int starttime = Integer.parseInt(startstation.get(1));
        if(!mapout.containsKey(routeName)){
            Pair p = new Pair((double)t-starttime,1);
            mapout.put(routeName, p);
        }
        else{
            Pair p = mapout.get(routeName);
            Pair newp = new Pair(p.sum+((double)t-starttime), p.numofele+1);
            mapout.put(routeName,newp);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair p = mapout.get(startStation+"-"+endStation);
        return p.sum/p.numofele;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */