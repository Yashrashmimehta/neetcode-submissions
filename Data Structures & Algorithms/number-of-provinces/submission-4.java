class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for(int i=0;i<n;i++){
            if(vis[i]==false){
            provinces++;
            dfs(i,isConnected,vis);

        }
        }
        return provinces;
        
    }
    private static void dfs(int city,int isConnected[][],boolean[] vis){
         int n = isConnected.length;

        vis[city] = true;
        for(int neighbour=0;neighbour<n;neighbour++){
            if(isConnected[city][neighbour]==1 && !vis[neighbour]){
                dfs(neighbour,isConnected,vis);
            }
        }
    }
}