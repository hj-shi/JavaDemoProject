package singletonExtends;

import java.util.HashMap;
import java.util.Map;

public abstract class President {
    private static Map<String, President> registryMap = new HashMap<>();

    President() throws SingletonException {
        String clazzName = this.getClass().getName();
        if (registryMap.containsKey(clazzName)) {
            throw new SingletonException("cannot construct instance for class " + clazzName + ", since an instance already exists!");
        } else {
            synchronized (registryMap) {
                if (registryMap.containsKey(clazzName)) {
                    throw new SingletonException("cannot construct instance for class " + clazzName + ", since an instance already exists!");
                } else {
                    registryMap.put(clazzName, this);
                }
            }
        }
    }

    public static <T extends President> T getInstance(final Class<T> clazz) throws IllegalAccessException, InstantiationException {
        String clazzName = clazz.getName();
        if (!registryMap.containsKey(clazzName)) {
            synchronized (registryMap) {
                if (!registryMap.containsKey(clazzName)) {
                    T instance = clazz.newInstance();
                    return instance;
                }
            }
        }
        return (T) registryMap.get(clazzName);
    }


    static class SingletonException extends Exception {
        private SingletonException(String message) {
            super(message);
        }
    }
}
