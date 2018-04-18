//建立一個父類別Shape
abstract class Shape {

    //設立show函數，讓每個被繼承的子類別都要有此函數
    public abstract void show();
}

//建立一個介面Measure
interface Measure {

    //定義最終變數PI
    final double PI = 3.14;

    //設立perimeter(周長)函數，讓每個被繼承的子類別都要有此函數
    abstract void perimeter();

    //設立area(面積)函數，讓每個被繼承的子類別都要有此函數
    abstract void area();
}

//建立Rectangle類別，分別繼承了Shape及Measure
class Rectangle extends Shape implements Measure {

    private int width , height;

    //建構元
    public Rectangle (int w , int h) {
        width = w;
        height = h;
    }

    //設定perimeter函數要做什麼事
    @Override
    public void perimeter(){
        System.out.println("perimeter = " + ( width + height ) * 2);
    }

    //設定area函數要做什麼事
    @Override
    public void area() {
        System.out.println("area = " + width * height);
    }

    //設定show函數要做什麼事
    @Override
    public void show(){
        System.out.println("width = " + width);
        System.out.println("height = " + height);
    }
}
//建立Circle類別，分別繼承了Shape及Measure
class Circle extends Shape implements Measure {

    private double radius;

    //建構元
    public Circle (double r) {
        radius = r;
    }

    //設定perimeter函數要做什麼事
    @Override
    public void perimeter() {
        System.out.println("perimeter = " + 2 * radius * PI);
    }

    //設定area函數要做什麼事
    @Override
    public void area(){
        System.out.println("area = " + PI * radius * radius);
    }

    //設定show函數要做什麼事
    @Override
    public void show(){
        System.out.println("radius = " + radius);
    }
}

//建立Triangle類別，分別繼承了Shape及Measure
class Triangle extends Shape implements Measure{

    private int line_A , line_B , line_C;

    //建構元
    public Triangle(int a , int b , int c) {
        line_A = a;
        line_B = b;
        line_C = c;
    }


    //設定area函數要做什麼事
    @Override
    public void area() {
        double s = ((line_A + line_B + line_C)/2);
        System.out.println("area = " + Math.sqrt( s * (s - line_A) * (s - line_B) * (s - line_C)));
    }

    //設定perimeter函數要做什麼事
    @Override
    public void perimeter() {
        System.out.println("perimeter = " + (line_A + line_B + line_C));
    }

    //設定show函數要做什麼事
    @Override
    public void show() {
        System.out.println("line_A = " + line_A);
        System.out.println("line_B = " + line_B);
        System.out.println("line_C = " + line_C);
    }
}

//執行的主程式
public class Ex20180417{
    public static void main(String args[]){

        Circle cir = new Circle(8);
        cir.area();
        cir.perimeter();
        cir.show();

        System.out.println();

        Rectangle rec = new Rectangle(5 , 5);
        rec.area();
        rec.perimeter();
        rec.show();

        System.out.println();

        Triangle tri = new Triangle(3 , 4 , 5);
        tri.area();
        tri.perimeter();
        tri.show();
    }
}