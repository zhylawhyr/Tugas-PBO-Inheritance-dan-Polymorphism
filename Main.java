public class Main {
    public static void main(String[] args) {
        System.out.println("=========================");
        System.out.println(" Informasi Macam Bentuk ");
        System.out.println("=========================");

        // polymorphism: satu nama method, banyak bentuk perilaku
        Bentuk[] objBentuk = new Bentuk[3];
        objBentuk[0] = new BujurSangkar(5, "merah");
        objBentuk[1] = new Lingkaran(14, "biru");
        objBentuk[2] = new Silinder(21, 28, "kuning");

        // Pemanggilan
        for (Bentuk b : objBentuk){
            b.printInfo();
        }
    }
} 
    

