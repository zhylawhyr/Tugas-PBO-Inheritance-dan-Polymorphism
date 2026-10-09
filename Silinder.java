public class Silinder extends Lingkaran{
    private double tinggi;

// Constructor (mengambil constructor class induk Lingkaran)
public Silinder (double tinggi,double radius, String warna){
    super(radius, warna);
    this.tinggi = tinggi;
}

public double getTinggi(){
    return tinggi;
}

public void setTinggi(double t){
    tinggi = t;
}
double hitungVolume(){
    return hitungLuas() * tinggi;
}

// Override : Menimpa atau mengganti menthod printInfo() milikk parent class
@Override 
public void printInfo(){
    System.out.println("Silinder berwarna: " + getWarna()+ ", volume: " + hitungVolume());
}
} 

