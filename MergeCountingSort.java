import java.util.Arrays;

public class MergeCountingSort {
        // Nama: Haldian
        // Nim: 059548189
        // Jurusan: Sistem Informasi
    public static void main(String[] args) {
        // Deklarasi variabel individual
        int a1 = 45, a2 = 12, a3 = 89, a4 = 33, a5 = 67, a6 = 21, a7 = 90, a8 = 15;

        // --- MERGE SORT ---
        int[] dataMerge = {a1, a2, a3, a4, a5, a6, a7, a8};
        System.out.println("=== MERGE SORT ===");
        System.out.println("Sebelum diurutkan: " + Arrays.toString(dataMerge));
        mergeSort(dataMerge, 0, dataMerge.length - 1);
        System.out.println("Sesudah diurutkan: " + Arrays.toString(dataMerge));

        System.out.println();

        // --- COUNTING SORT ---
        int[] dataCounting = {a1, a2, a3, a4, a5, a6, a7, a8};
        System.out.println("=== COUNTING SORT ===");
        System.out.println("Sebelum diurutkan: " + Arrays.toString(dataCounting));
        countingSort(dataCounting);
        System.out.println("Sesudah diurutkan: " + Arrays.toString(dataCounting));
    }

    // Metode Merge Sort (Descending)
    public static void mergeSort(int[] arr, int kiri, int kanan) {
        if (kiri < kanan) {
            int tengah = (kiri + kanan) / 2;
            mergeSort(arr, kiri, tengah);         // Bagi bagian kiri
            mergeSort(arr, tengah + 1, kanan);     // Bagi bagian kanan
            gabung(arr, kiri, tengah, kanan);      // Gabungkan
        }
    }

    public static void gabung(int[] arr, int kiri, int tengah, int kanan) {
        int[] kiriArr = Arrays.copyOfRange(arr, kiri, tengah + 1);
        int[] kananArr = Arrays.copyOfRange(arr, tengah + 1, kanan + 1);

        int i = 0, j = 0, k = kiri;

        // Pilih nilai yang lebih BESAR dulu (Descending)
        while (i < kiriArr.length && j < kananArr.length) {
            if (kiriArr[i] >= kananArr[j]) {
                arr[k++] = kiriArr[i++];
            } else {
                arr[k++] = kananArr[j++];
            }
        }
        while (i < kiriArr.length) arr[k++] = kiriArr[i++];
        while (j < kananArr.length) arr[k++] = kananArr[j++];
    }

    // Metode Counting Sort (Descending)
    public static void countingSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
            if (x < min) min = x;
        }

        // Buat ember hitungan berdasarkan selisih angka terbesar & terkecil
        int[] hitung = new int[max - min + 1];

        // Hitung kemunculan angka
        for (int x : arr) {
            hitung[x - min]++;
        }

        // Isi kembali dari angka TERBESAR ke TERKECIL
        int index = 0;
        for (int i = hitung.length - 1; i >= 0; i--) {
            while (hitung[i] > 0) {
                arr[index++] = i + min;
                hitung[i]--;
            }
        }
    }
}