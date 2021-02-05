package reflection;

public class SonClass extends FatherClass {
    private String mSonName;
    protected int mSonAge;
    public String mSonBirthday;

    private SonClass(String mFatherName, String mSonName, int mSonAge) {
        super(mFatherName);
        this.mSonName = mSonName;
        this.mSonAge = mSonAge;
    }

    public SonClass(String mFatherName, String mSonName) {
        super(mFatherName);
        this.mSonName = mSonName;
    }

    public SonClass(int mFatherAge, int mSonAge) {
        super(mFatherAge);
        this.mSonAge = mSonAge;
    }

    public void printSonMsg(){
        System.out.println("Son Msg - name : "
                + mSonName + "; age : " + mSonAge);
    }

    private void setSonName(String name){
        mSonName = name;
    }

    private void setSonAge(int age){
        mSonAge = age;
    }

    private int getSonAge(){
        return mSonAge;
    }

    private String getSonName(){
        return mSonName;
    }
}
