/**
 * Created by F on 1/1/2018.
 */
public class ComplexNum {
    private double real;
    private double imaginary;
    public ComplexNum(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNum add(ComplexNum lValue){
        return new ComplexNum(this.real + lValue.getReal(), this.imaginary + lValue.getImaginary());
    }

    public ComplexNum multiply(ComplexNum lValue){
        double x = real;
        double y = imaginary;
        double u = lValue.real;
        double v = lValue.imaginary;

        double newReal = x * u - y * v;
        double newImag = x * v + y * u;
        return new ComplexNum(newReal, newImag);
    }

    public double getReal(){
        return real;
    }

    public double getImaginary(){
        return imaginary;
    }

    public double distance(){
        return Math.sqrt(real * real + imaginary * imaginary);
    }
}
