package enumerated;

enum Shrubbery { GROUND, CRAWLING, HANGING}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinary: " + s.ordinal());
            System.out.println(s + " compareTo " + " equals " + " == ? " + Shrubbery.CRAWLING);
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubbery.CRAWLING + " "));
            System.out.print(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("---------------------------");
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println("从一个string 名字生成一个 Enum 值");
            System.out.println(shrub);
        }
    }
}
