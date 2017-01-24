package function;

/**
 * Created by Ringo on 18.01.2017.
 */
public class PolynomFunction extends FunctionImpl {
    @Override
    public double function(double x) {
        return 5*x*x*x + x*x + 5;
    }
}
