package bean;

/**
 * @author Christp
 * @version 1.0
 * @ClassName Triangle1
 * @Description TODO
 * @date 2022/3/17 16:30
 */
public class Triangle1 {
    public static void main(String[] args) {
        System.out.println("He");
    }
    double a, b, c;

    public Triangle1(){

    }
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
