package sample;

import function.CosFunction;
import function.Function;

/**
 * Created by Ringo on 17.01.2017.
 */
public class CosSample extends SampleImpl {

    Function cosFunc = new CosFunction();
    @Override
    protected double function(double x) {
        return cosFunc.function(x);
    }
}
