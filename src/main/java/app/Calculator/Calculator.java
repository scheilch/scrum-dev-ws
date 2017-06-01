package app.Calculator;

/**
 * Created by scheilch on 21.05.2017.
 */
public class Calculator {

    private int result;

    public void add(int arg1, int arg2) {
        result = arg1 + arg2;
    }

    public int getResult() {
        return result;
    }
}