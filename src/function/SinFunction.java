package function;

/**
 * Created by Ringo on 18.01.2017.
 */
public class SinFunction extends FunctionImpl {
    @Override
    public double function(double x) {
        return x*Math.sin(2*Math.PI*x);
    }
}
