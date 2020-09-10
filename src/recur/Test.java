package recur;

public class Test {

    public static void main(String[] args) {
        Resolution resolution = new Resolution();
//        int result = resolution.mutiplyFromOneToN(6);
//        System.out.println(result);

        System.out.println("跳台阶------------------");
        long before = System.currentTimeMillis();
        int ways = resolution.totalWays(35);
        long after = System.currentTimeMillis();
        System.out.println("花费时间： " + (after - before));
        System.out.println(ways);

        System.out.println("跳台阶循环------------------");
        long before2 = System.currentTimeMillis();
        int ways2 = resolution.totalWaysIter(35);
        long after2 = System.currentTimeMillis();
        System.out.println("花费时间： " + (after2 - before2));
        System.out.println(ways2);
    }
}
