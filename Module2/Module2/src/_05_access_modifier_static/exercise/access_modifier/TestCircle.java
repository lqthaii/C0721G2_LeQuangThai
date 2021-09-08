package _05_access_modifier_static.exercise.access_modifier;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TestCircle {
    public static void main(String[] args) {
        Circle cir = new Circle();
        System.out.println("Radius: "+cir.getRadius());
        System.out.println("Area: "+cir.getArea());
    }
}
