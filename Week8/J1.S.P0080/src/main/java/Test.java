import model.*;

public class Test {
    public static void main(String[] args) {
        // Khởi tạo mảng các hình
        Shape[] shapes = {
                new Circle(5),        // Hình tròn
                new Sphere(4),        // Hình cầu
                new Tetrahedron(3)    // Hình tứ diện đều
        };

        // Xử lý từng hình trong mảng
        for (Shape shape : shapes) {
            System.out.println(shape);

            if (shape instanceof TwoDimensionalShape) {
                System.out.println("This is a 2D Shape.");
                System.out.println("Area: " + shape.getArea());
            } else if (shape instanceof ThreeDimensionalShape) {
                System.out.println("This is a 3D Shape.");
                System.out.println("Area: " + shape.getArea());
                System.out.println("Volume: " + ((ThreeDimensionalShape) shape).getVolume());
            }

            System.out.println("-----------------");

        }
    }
}
