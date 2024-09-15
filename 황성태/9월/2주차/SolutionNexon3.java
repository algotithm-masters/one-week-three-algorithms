import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SolutionNexon3 {


    class Result {

        private static int dfs(int node, List<List<Integer>> tree, List<Integer> values, int[] maxSum) {
            int currentMax = values.get(node);
            int maxChildPathSum = 0;

            for (int child : tree.get(node)) {
                int childMaxPathSum = dfs(child, tree, values, maxSum);
                maxChildPathSum = Math.max(maxChildPathSum, childMaxPathSum);
            }

            currentMax += maxChildPathSum;

            maxSum[0] = Math.max(maxSum[0], currentMax);

            return Math.max(values.get(node), values.get(node) + maxChildPathSum);
        }

        public static int bestSumAnyTreePath(List<Integer> parent, List<Integer> values) {
            int n = parent.size();

            return 0;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int parentCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> parent = IntStream.range(0, parentCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> values = IntStream.range(0, valuesCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = Result.bestSumAnyTreePath(parent, values);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
