package reflection;

public class TestFinalField {
    private final String FINAL_VALUE = null == null ? "hello" : null;

    public TestFinalField() {
    }

    public boolean isSame(String str) {
        if (FINAL_VALUE.equals(str)) {
            return true;
        }
        return false;
    }

    public String getFinalValue() {
        return FINAL_VALUE;
    }
}
