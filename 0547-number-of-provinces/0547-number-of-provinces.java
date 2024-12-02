class Solution {
    void bfs(int[][] adj ,boolean visited[],Queue<Integer> q,int start){
        q.offer(start);
        visited[start] =true;

        while(q.isEmpty()==false){
            int curr = q.poll();
            for(int i=0;i<adj.length;i++){
                if(adj[curr][i]==1 && visited[i]==false){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
    }

    public int findCircleNum(int[][] adj) {
        int ans = 0;
        boolean visited[] = new boolean[adj.length];
        Queue<Integer> q =new LinkedList<>();

        for(int i=0;i<adj.length;i++){
            if(visited[i]==false) {
                ans++;
                bfs(adj,visited,q,i);
            }
        }

        return ans;
        
    }
}