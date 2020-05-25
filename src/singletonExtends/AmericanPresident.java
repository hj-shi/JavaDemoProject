package singletonExtends;

public class AmericanPresident extends President {
    public AmericanPresident() throws SingletonException {
        super();
    }

    public static AmericanPresident getInstance() {
        try {
            return President.getInstance(AmericanPresident.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
