package _06_inheritance.execrises.triagle;

public class Triangle {
    protected double slide1 = 1.0;
    protected double slide2 = 1.0;
    protected double slide3 = 1.0;

    public Triangle() {
    }

    public Triangle(double slide1, double slide2, double slide3) {
        this.slide1 = slide1;
        this.slide2 = slide2;
        this.slide3 = slide3;
    }

    public double getSlide1() {
        return slide1;
    }

    public void setSlide1(double slide1) {
        this.slide1 = slide1;
    }

    public double getSlide2() {
        return slide2;
    }

    public void setSlide2(double slide2) {
        this.slide2 = slide2;
    }

    public double getSlide3() {
        return slide3;
    }

    public void setSlide3(double slide3) {
        this.slide3 = slide3;
    }
    public double getPerimeter(){
        return this.slide1+this.slide2+this.slide3;
    }
    public double getArea(){
        double heron = this.getPerimeter()/2;
        double area = Math.sqrt(heron*(heron-this.slide1)*(heron-this.slide2)*(heron-this.slide3));
        return area;
    }

}
