package function;

/**
 * Created by Ringo on 18.01.2017.
 */
public class CosFunction extends FunctionImpl {
    @Override
    public double function(double x) {
        return Math.cos(2*Math.PI*x);
    }


}
