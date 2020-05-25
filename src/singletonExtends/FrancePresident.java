package singletonExtends;

public class FrancePresident extends President {
    public FrancePresident() throws SingletonException {
        super();
    }

    public static FrancePresident getInstance() {
        try {
            return President.getInstance(FrancePresident.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
