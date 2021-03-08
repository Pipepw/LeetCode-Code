class Solution {
    boolean[][] isUsed;
    public boolean exist(char[][] board, String word) {
        isUsed = new boolean[board.length][board[0].length];
        boolean isFind;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                isFind = find(board, word, 0, i, j);
                if(isFind){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word, int index, int x, int y){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || isUsed[x][y]){
            return false;
        }
        if(board[x][y] == word.charAt(index)){
            if(index == word.length()-1){
                return true;
            }
            isUsed[x][y] = true;
            boolean isTrue;
            isTrue = find(board, word, index + 1, x + 1, y);
            if(isTrue){
                return true;
            }
            isTrue = find(board, word, index + 1, x - 1, y);
            if(isTrue){
                return true;
            }
            isTrue = find(board, word, index + 1, x, y + 1);
            if(isTrue){
                return true;
            }
            isTrue = find(board, word, index + 1, x, y - 1);
            if(isTrue){
                return true;
            }
            isUsed[x][y] = false;
            return false;
        }
        return false;
    }
}