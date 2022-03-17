/**
 * @author Christp
 * @version 1.0
 * @ClassName Triangle
 * @Description TODO
 * @date 2022/3/17 15:55
 */
public class Triangle {
    private double a, b, c = 0;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double calculateSquare(double a, double b, double c){
        double d = (a + b + c)/2;
        return Math.sqrt(d * (d - a) * (d - b) * (d - c));
    }

    public boolean isTriangle(double a, double b, double c){
        if (a + b > c && a + c > b && b + c > a){
            return true;
        }else {
            return false;
        }
    }

    public double calculatePerimeter(double a, double b, double c){
        return a + b + c;
    }
}
