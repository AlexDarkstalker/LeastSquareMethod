package sample;

import function.Function;
import function.SinFunction;

/**
 * Created by Ringo on 17.01.2017.
 */
public class SinSample extends SampleImpl {
    Function sinFunc = new SinFunction();
    @Override
    protected double function(double x) {
        return sinFunc.function(x);
    }
}
