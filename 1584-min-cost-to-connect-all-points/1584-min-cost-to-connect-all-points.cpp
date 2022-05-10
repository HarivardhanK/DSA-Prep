class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        int n = points.size();
        vector<vector<pair<int, int>>> graph(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                graph[i].push_back({abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]), j});
            }   
        }
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
        vector<bool> vis(n, false);
        pq.push({0, 0}); // {cost, Node}
        int ans = 0;
        while (!pq.empty())
        {
            pair<int,int> p = pq.top();
            int currNode = p.second;
            int currCost = p.first;
            pq.pop();
            if (vis[currNode]) continue;
            ans += currCost;
            vis[currNode] = true;
            for(int i=0;i<graph[currNode].size();i++)
            {
                int neighbourNode = graph[currNode][i].second;
                int neighbourNodeCost = graph[currNode][i].first;
                if(vis[neighbourNode]) continue;
                pq.push({neighbourNodeCost, neighbourNode});
            }
        }
        return ans;
    }
};