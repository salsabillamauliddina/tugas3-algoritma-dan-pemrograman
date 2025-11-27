import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
// ! number format dan locale dibuat untuk memformat angka menjadi mata uang indonesia 
// ! scanner dipakai untuk inputan dari keyboard 

public class HitungGaji {
    public static void main(String[] args) {
        // * membaca inputan user dengan memanggil import scanner
        Scanner input = new Scanner(System.in);
        // ! array gaji 
        double[] gaji = {5_000_000, 6_500_000, 9_500_000};
        // ? array persenan lembur 
        double[] persenLembur = {30, 32, 34, 36, 38};

        System.out.print("Masukkan Golongan (A/B/C): ");
        // ? .trim() untuk menghapus spasi dan toUpperCase() untuk membuat inputan ototmatis menjadi kapital 
        String gol = input.nextLine().trim().toUpperCase();

        int indexGol;
        if (gol.equals("A")) indexGol = 0;
        else if (gol.equals("B")) indexGol = 1;
        else if (gol.equals("C")) indexGol = 2;
        else {
            System.out.println("Golongan tidak valid!");
            return;
        }
        // ! jika inputan A/B/C program otomatis stop karena inputan salah

        double gajiPokok = gaji[indexGol];

        System.out.print("Masukkan Jam Lembur: ");
        int jam = input.nextInt();
        if (jam < 0) jam = 0;
        //! Jam lembur tidak boleh negatif maka otomatis jadi 0. 

        double persen;
        if (jam == 1) persen = persenLembur[0];
        else if (jam == 2) persen = persenLembur[1];
        else if (jam == 3) persen = persenLembur[2];
        else if (jam == 4) persen = persenLembur[3];
        else if (jam >= 5) persen = persenLembur[4];
        else persen = 0;

        double gajiLemburPerJam = (persen / 100) * gajiPokok;
        double totalLembur = gajiLemburPerJam * jam;
        double totalGaji = gajiPokok + totalLembur;

        // ! format uang rupiah 
        NumberFormat rp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        System.out.println("\n=== TOTAL GAJI ===");
        System.out.println("Golongan: " + gol);
        System.out.println("Gaji Pokok: " + rp.format(gajiPokok));
        System.out.println("Jam Lembur: " + jam);
        System.out.println("Persen Lembur: " + persen + "%");
        System.out.println("Total Lembur: " + rp.format(totalLembur));
        System.out.println("Total Gaji: " + rp.format(totalGaji));
    }
}
