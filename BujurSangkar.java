public class BujurSangkar extends Bentuk{
    private double sisi;

// Constructor (Mengambil constructor dari parent class Bentuk)    
public BujurSangkar (double sisi, String warna){
    super(warna);
    this.sisi = sisi;
}

public double getSisi(){
    return sisi;
}

public void setSisi(double s){
    sisi = s;
}

public double hitungLuas(){
    return sisi * sisi;
}

// Override : Menimpa atau mengganti menthod printInfo() milikk parent class
@Override 
public void printInfo(){
    System.out.println("Bujursangkar berwarna: " + getWarna()+ ", luas: " + hitungLuas());
}
}
