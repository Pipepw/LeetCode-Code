class Solution {
    Set<Integer> inCol = new HashSet<>();
    Set<Integer> inL2r = new HashSet<>();
    Set<Integer> inR2l = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(queens, 0);
        return res;
    }

    void backtrack(int[] queens, int row) {
        // 成功条件
        if (row == queens.length) {
            List<String> board = buildBoard(queens);
            res.add(board);
        } else {
            for (int col = 0; col < queens.length; col++) {
                // 排除不正确选项，L2r中的行列之差，R2l中的行列之和相等
                if (inCol.contains(col) || inL2r.contains(row - col) || inR2l.contains(row + col)) {
                    continue;
                }
                // 选择
                inCol.add(col);
                inL2r.add(row - col);
                inR2l.add(row + col);
                queens[row] = col;
                // 下一次决策
                backtrack(queens, row + 1);
                // 撤销选择
                inCol.remove(col);
                inL2r.remove(row - col);
                inR2l.remove(row + col);
                queens[row] = -1;
            }
        }

    }

    List<String> buildBoard(int[] queens) {
        List<String> board = new ArrayList<>();
        for (int queen : queens) {
            char[] row = new char[queens.length];
            Arrays.fill(row, '.');
            row[queen] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}