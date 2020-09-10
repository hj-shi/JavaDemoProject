package recur;

import java.util.HashMap;

public class Resolution {
    private HashMap<Integer, Integer> map = new HashMap<>();

    // 求阶乘
    public int mutiplyFromOneToN(int n) {
        if ( n == 1) {
            return 1;
        }
        return n * mutiplyFromOneToN(n-1);
    }

    // 小青蛙跳台阶（迭代 + 保存中间结果）
    public int totalWays(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (map.get(n) != null) {
            System.out.println("called n = " + n);
            return map.get(n);
        }

        int result = totalWays(n-1) + totalWays(n-2);
        map.put(n, result); // 保存中间结果

        return result;
    }

    // 跳台阶（循环）
    public int totalWaysIter(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int result1 = 1;
        int result2 = 2;

        for (int i = 3; i <= n; i++) {
            int tmp = result2;
            result2 = result1 + result2;
            result1 = tmp;
        }

        return result2;
    }
}
