package reflection;

public class FatherClass {
    public String mFatherName;
    public int mFatherAge;

    public FatherClass(String mFatherName) {
        this.mFatherName = mFatherName;
    }

    public FatherClass(int mFatherAge) {
        this.mFatherAge = mFatherAge;
    }

    public void printFatherMsg(){}
}
