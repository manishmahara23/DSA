class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        int[][] height = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        for(int r=0;r<rows; r++){
            for(int c=0; c<cols; c++){
                if(isWater[r][c]==1){
                    height[r][c]=0;
                    queue.offer(new int[]{r,c});
                }else{
                    height[r][c]=-1;
                }
            }
        }
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for(int[] dir : directions){
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                if(nextR >=0 && nextR < rows && nextC >=0 && nextC< cols && height[nextR][nextC]==-1){
                    // Agle cell ki height pichle cell se +1 hogi
                    height[nextR][nextC] = height[r][c] + 1;
                    // Naye cell ko queue me daalo taaki uske neighbors check ho sakein
                    queue.offer(new int[]{nextR, nextC});
            }
        }
    }
    return height;
}
}