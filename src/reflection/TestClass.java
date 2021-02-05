package reflection;

public class TestClass {
    private String MSG = "Original";

    private void privateMethod(String head , int tail){
        System.out.print(head + tail);
    }

    public String getMsg(){
        return MSG;
    }
}
