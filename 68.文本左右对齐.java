class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<Integer> Remains = new ArrayList<>();
        List<List<String>> Rows = new ArrayList<>();
        List<String> Result = new ArrayList<>();
        int row = 0;
        for (int i = 0; i < words.length; i++) { // 将每一行的单词放进去
            List<String> temp = new ArrayList<>(); // 暂时存放一行的单词
            // 将一行的第一个放进去
            temp.add(words[i]);
            Remains.add(maxWidth - words[i].length());
            while (i + 1 < words.length && Remains.get(row) > words[i + 1].length()) { // 剩余空格数大于下一个单词的长度
                i++;
                temp.add(words[i]);
                Remains.set(row, Remains.get(row) - words[i].length() - 1); // 将其加入到这一行中
            }
            Rows.add(temp);
            row++;
        }
        // 将除最后一行外的每一行单词合并
        for (int i = 0; i < Rows.size() - 1; i++) {
            StringBuilder TempString = new StringBuilder();
            if (Rows.get(i).size() == 1) { // 只有一个的单词，左对齐
                TempString.append(Rows.get(i).get(0));
                TempString.append(" ".repeat(Math.max(0, maxWidth - Rows.get(i).get(0).length())));
                Result.add(TempString.toString());
                continue;
            }
            int SpaceNum = Remains.get(i) / (Rows.get(i).size() - 1);
            int AdditionalNum = Remains.get(i) % (Rows.get(i).size() - 1);
            for (int j = 0; j < Rows.get(i).size(); j++) {
                if (j != 0) {
                    TempString.append(" ".repeat(SpaceNum + 1));
                    if (j < AdditionalNum + 1) {
                        TempString.append(" ");
                    }
                }
                TempString.append(Rows.get(i).get(j));
            }
            Result.add(TempString.toString());
        }
        // 放入最后一行
        StringBuilder LastString = new StringBuilder();
        for (int j = 0; j < Rows.get(Rows.size() - 1).size(); j++) {
            LastString.append(Rows.get(row - 1).get(j));
            if (j != Rows.get(Rows.size() - 1).size() - 1) {
                LastString.append(" ");
            }
        }
        LastString.append(" ".repeat(Math.max(0, maxWidth - LastString.length())));
        Result.add(LastString.toString());
        return Result;
    }
}