package deep;

public class Test {
    private int var1, var2, result;
    public void setVar1(String var1) {
        System.out.println(var1);
        this.var1 = Integer.parseInt(var1);
    }
    public void setVar2(String var2) {
        System.out.println(var2);
        this.var2 = Integer.parseInt(var2);
    }
    public int getResult() {
        return result;
    }
    public void sum() {
        result = var1 + var2;
    }
    public void avg() {
        result = var1 + var2 / 2;
    }
}