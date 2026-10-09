public class Lingkaran extends Bentuk{
    private double radius;
    public static final double phi = 3.14;

// Constructor (mengambil constructor parent class Bentuk)
public Lingkaran(double radius, String warna){
    super(warna);
    this.radius = radius;
}
public double getRadius(){
    return radius;
}
public void setRadius(double r){
    radius = r;
}
public double hitungLuas(){
    return 3.14 * radius * radius;
}

// Override : Menimpa atau mengganti menthod printInfo() milikk parent class
@Override 
public void printInfo(){
    System.out.println("Lingkaran berwarna: " + getWarna()+ ", luas: " + hitungLuas());
}
}   