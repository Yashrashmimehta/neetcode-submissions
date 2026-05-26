class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] vis = new boolean[n];

        int provinces = 0;

        for(int i = 0; i < n; i++) {

            if(!vis[i]) {

                provinces++;

                bfs(i, isConnected, vis);
            }
        }

        return provinces;
    }

    private void bfs(int start, int[][] isConnected, boolean[] vis) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        vis[start] = true;

        while(!q.isEmpty()) {

            int city = q.poll();

            for(int neighbour = 0; neighbour < isConnected.length; neighbour++) {

                if(isConnected[city][neighbour] == 1 && !vis[neighbour]) {

                    vis[neighbour] = true;

                    q.offer(neighbour);
                }
            }
        }
    }
}