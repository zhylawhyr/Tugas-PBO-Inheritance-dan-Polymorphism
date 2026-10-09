#🎓Tugas PBO – Inheritance dan Polymorphism

Repository ini berisi tugas mata kuliah Pemrograman Berorientasi Objek (PBO) berupa program Java yang mendemonstrasikan dua konsep utama OOP, yaitu Inheritance (pewarisan) dan Polymorphism. Konsep tersebut diterapkan pada kelas Bentuk, BujurSangkar, Lingkaran, dan Silinder.

Pada program ini, Bentuk berperan sebagai kelas induk yang menyimpan atribut umum berupa warna. Kelas BujurSangkar dan Lingkaran mewarisi sifat tersebut dan menambahkan perhitungan luasnya masing-masing, sedangkan Silinder mewarisi Lingkaran untuk memanfaatkan perhitungan luas alas dalam menghitung volume. Setiap kelas turunan menimpa (override) method printInfo() sehingga satu perintah yang sama menghasilkan keluaran yang berbeda sesuai jenis objeknya.


## 👤 Identitas

| Data | Keterangan |
|---|---|
| 👤 **Nama** | Zhylalan Wahyu Ramadhani |
| 🆔 **NIM** | F1D02510137 |
| 🏫 **Kelas** | 3B |
| 📘 **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) |
| 👨‍🏫 **Dosen Pengampu** | Rovana Afwani, S.T., M.T. |

## Daftar Isi

1. 📖[Deskripsi Program](#1-deskripsi-program)
2. 📁[Struktur Proyek](#2-struktur-proyek)
3. 📚[Library yang Digunakan](#3-library-yang-digunakan)
4. 💻[Penjelasan Kode](#4-penjelasan-kode)
5. ▶️[Cara Menjalankan](#5-cara-menjalankan)
6. 📸[Hasil Program (Screenshot)](#6-hasil-program-screenshot)
7. ✅[Kesimpulan](#7-kesimpulan)

---

##📖 1. Deskripsi Program

Program ini dibuat untuk memperlihatkan bagaimana **pewarisan (inheritance)** dan **polimorfisme (polymorphism)** bekerja dalam pemrograman berorientasi objek menggunakan bahasa Java. Studi kasusnya adalah perhitungan sederhana pada bangun datar dan bangun ruang: luas bujur sangkar, luas lingkaran, dan volume silinder.

**Rancangan kelas**

- **`Bentuk`** adalah kelas induk (*superclass*) yang menyimpan sifat umum semua bentuk, yaitu `warna`.
- **`BujurSangkar`** dan **`Lingkaran`** adalah kelas turunan langsung dari `Bentuk`. Keduanya mewarisi atribut `warna` dan menambahkan atribut serta perhitungan luasnya sendiri.
- **`Silinder`** adalah kelas turunan dari `Lingkaran`. Alas silinder berbentuk lingkaran, sehingga perhitungan luas alas dipakai ulang dan hanya ditambah atribut `tinggi` untuk menghitung volume.
- **`Main`** adalah kelas utama yang menjalankan program.

**Alur program**

1. `Main` membuat tiga objek: `BujurSangkar`, `Lingkaran`, dan `Silinder`.
2. Ketiganya disimpan dalam satu array bertipe `Bentuk`. Hal ini bisa dilakukan karena semua kelas tersebut adalah turunan `Bentuk`.
3. Program melakukan perulangan dan memanggil `printInfo()` pada setiap objek.
4. Setiap objek menampilkan informasinya dengan caranya masing-masing. Bujur sangkar dan lingkaran menampilkan luas, sedangkan silinder menampilkan volume. Inilah inti dari polimorfisme.

| Konsep | Penerapan di program |
|---|---|
| **Inheritance** | `BujurSangkar` dan `Lingkaran` memakai `extends Bentuk`, sedangkan `Silinder` memakai `extends Lingkaran`. Atribut `warna` serta method `getWarna()` dan `setWarna()` diwarisi tanpa ditulis ulang. |
| **Method Overriding** | Setiap kelas turunan menimpa method `printInfo()` dari `Bentuk` dengan anotasi `@Override`. |
| **Polymorphism** | Array `Bentuk[]` diisi objek turunan, dan `b.printInfo()` menjalankan versi method sesuai jenis objek aslinya. |
| **Encapsulation** | Atribut `sisi`, `radius`, dan `tinggi` bersifat `private` dan diakses lewat getter/setter. |

---

##📁 2. Struktur Proyek

```
.
├── Bentuk.java
├── BujurSangkar.java
├── Lingkaran.java
├── Silinder.java
├── Main.java
├── screenshots/
│   ├── repository.png
│   └── hasil-1.png
└── README.md
```

###🧩 Hierarki Kelas

```
Bentuk
├── BujurSangkar
└── Lingkaran
    └── Silinder
```

---

##📚 3. Library yang Digunakan

Program ini **tidak meng-import library apa pun** dan **tidak ada penambahan library baru**. Semua yang dipakai berasal dari paket bawaan `java.lang`, yang otomatis tersedia tanpa perintah `import`.

| Bagian `java.lang` | Dipakai untuk |
|---|---|
| `String` | Menyimpan atribut `warna`. |
| `System.out.println()` | Menampilkan teks ke layar. |

---

##💻 4. Penjelasan Kode

###🔷 4.1 `Bentuk.java` (Kelas Induk)

```java
public class Bentuk {
    public String warna;

    public Bentuk(String warna){
        this.warna = warna;
    }

    public String getWarna(){
        return warna;
    }
    public void setWarna(String w){
        warna = w;
    }
    public void printInfo(){
        System.out.println("Bentuk berwarna: " + warna);
    }
}
```

**📝Penjelasan:**
- Kelas ini adalah *superclass* yang menyimpan sifat umum semua bentuk, yaitu `warna`.
- Constructor `Bentuk(String warna)` mengisi atribut `warna` saat objek dibuat.
- `getWarna()` dan `setWarna()` dipakai untuk membaca dan mengubah warna.
- `printInfo()` mencetak informasi dasar. Method inilah yang nanti di-*override* oleh semua kelas turunan.

---

###🟩 4.2 `BujurSangkar.java`

```java
public class BujurSangkar extends Bentuk {
    private double sisi;

    // Constructor (mengambil constructor dari parent class Bentuk)
    public BujurSangkar(double sisi, String warna){
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

    // Override: menimpa method printInfo() milik parent class
    @Override
    public void printInfo(){
        System.out.println("Bujursangkar berwarna: " + getWarna() + ", luas: " + hitungLuas());
    }
}
```

**📝Penjelasan:**
- `extends Bentuk` membuat kelas ini mewarisi `warna` beserta getter dan setter-nya.
- `super(warna)` memanggil constructor `Bentuk` untuk mengisi atribut warna, lalu `this.sisi = sisi` mengisi atribut milik kelas ini sendiri.
- `hitungLuas()` menghitung luas dengan rumus **sisi × sisi**.
- `printInfo()` di-*override* agar menampilkan jenis bentuk, warna, dan luasnya.

---

###🔵 4.3 `Lingkaran.java`

```java
public class Lingkaran extends Bentuk {
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

    // Override: menimpa method printInfo() milik parent class
    @Override
    public void printInfo(){
        System.out.println("Lingkaran berwarna: " + getWarna() + ", luas: " + hitungLuas());
    }
}
```

**📝Penjelasan:**
- Atribut `radius` menyimpan jari-jari lingkaran.
- `phi` adalah konstanta (`static final`) bernilai 3,14, sehingga nilainya tidak bisa diubah.
- `hitungLuas()` memakai rumus **π × r × r** dengan π = 3,14.
- `printInfo()` di-*override* untuk menampilkan jenis bentuk, warna, dan luas lingkaran.

---

###🥫 4.4 `Silinder.java`

```java
public class Silinder extends Lingkaran {
    private double tinggi;

    // Constructor (mengambil constructor class induk Lingkaran)
    public Silinder(double tinggi, double radius, String warna){
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

    // Override: menimpa method printInfo() milik parent class
    @Override
    public void printInfo(){
        System.out.println("Silinder berwarna: " + getWarna() + ", volume: " + hitungVolume());
    }
}
```

**📝Penjelasan:**
- Silinder diturunkan dari `Lingkaran` karena alasnya berbentuk lingkaran, sehingga `hitungLuas()` dan `radius` bisa dipakai ulang.
- Ini contoh **pewarisan bertingkat**: `Silinder → Lingkaran → Bentuk`.
- `super(radius, warna)` meneruskan data ke constructor `Lingkaran`, yang kemudian meneruskan `warna` ke `Bentuk`.
- `hitungVolume()` menghitung volume dengan rumus **luas alas × tinggi**.
- `printInfo()` di-*override* untuk menampilkan volume, bukan luas.

---

###🚀 4.5 `Main.java`

```java
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
```

**📝Penjelasan:**
- Array `Bentuk[]` berisi tiga objek berbeda: `BujurSangkar`, `Lingkaran`, dan `Silinder`. Hal ini boleh dilakukan karena ketiganya adalah turunan `Bentuk`.
- Perulangan `for` memanggil `b.printInfo()` pada setiap elemen. Java menentukan versi `printInfo()` yang dijalankan berdasarkan **jenis objek sebenarnya**, bukan tipe variabelnya. Inilah **polymorphism**.
- Data objek: bujur sangkar sisi 5 (merah), lingkaran jari-jari 14 (biru), dan silinder tinggi 21 dengan jari-jari 28 (kuning).

---

##▶️ 5. Cara Menjalankan

**Prasyarat:** JDK sudah terpasang (cek dengan `java -version`).

```bash
# 1. Clone repository
git clone https://github.com/[USERNAME]/[NAMA-REPO].git
cd [NAMA-REPO]

# 2. Compile semua file
javac *.java

# 3. Jalankan program
java Main
```

Atau lewat VS Code: buka `Main.java`, lalu klik **Run** di atas method `main`.

---

##📸 6. Hasil Program (Screenshot)

### Struktur Repository

<img width="1912" height="872" alt="image" src="https://github.com/user-attachments/assets/89fa85ab-6148-4c6a-953a-1638458364fb" />


*Gambar 1. Isi repository di GitHub.*



!<img width="492" height="162" alt="image" src="https://github.com/user-attachments/assets/1d183412-4003-449a-8323-8b7894414bac" />

*Gambar 2. Output program saat dijalankan.*
**🧮Perhitungan:**

| Objek | Rumus | Hasil |
|---|---|---|
| Bujur sangkar | 5 × 5 | 25.0 |
| Lingkaran | 3,14 × 14 × 14 | 615.44 |
| Silinder | (3,14 × 28 × 28) × 21 = 2461,76 × 21 | 51696.96 |

> Angka `51696.96000000001` muncul karena sifat bilangan desimal `double` pada komputer (pembulatan floating point). Nilai sebenarnya adalah 51696,96.

---

##✅ 7. Kesimpulan

- **Inheritance** membuat kelas turunan memakai ulang atribut dan method induknya, sehingga `warna` cukup ditulis sekali di `Bentuk`.
- **Method overriding** memungkinkan tiap kelas punya versi `printInfo()` sendiri.
- **Polymorphism** terlihat pada `Main`: satu perintah `b.printInfo()` menghasilkan keluaran berbeda sesuai jenis objeknya.
- Program hanya memakai paket bawaan `java.lang`, tanpa library tambahan.
