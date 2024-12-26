# Ongkos Kirim App

## Deskripsi
Ongkos Kirim App adalah aplikasi konsol berbasis Java yang memungkinkan
pengguna untuk mengelola informasi paket pengiriman.
Aplikasi ini menyediakan fitur CRUD (Create, Read, Update, Delete)
untuk data paket dan mendukung tampilan gambar paket melalui jalur file yang valid.

## Fitur Utama
- Membuat paket dengan detail seperti deskripsi, berat, tujuan, biaya, dan gambar.
- Melihat daftar semua paket yang tersimpan.
- Memperbarui detail paket yang ada.
- Menghapus paket berdasarkan ID.
- Membuka gambar paket berdasarkan jalur file yang disediakan.

## Cara Menggunakan

### Menjalankan Program
1. Pastikan Java Development Kit (JDK) sudah terpasang di komputer Anda.
2. Kompilasi file sumber menggunakan perintah berikut:
   ```bash
   javac OngkosKirimApp.java
   ```
3. Jalankan aplikasi dengan perintah:
   ```bash
   java OngkosKirimApp
   ```

### Menu Utama
Setelah menjalankan program, Anda akan melihat menu utama:
```
=== Aplikasi Ongkos Kirim ===
1. Buat Package
2. Lihat semua Packages
3. Update Package
4. Hapus Package
5. Lihat Gambar Package
6. Keluar
Masukan pilihan anda :
```
Pilih opsi sesuai dengan angka yang tertera untuk melakukan operasi yang diinginkan.

### Validasi Input
- **Berat paket** harus lebih besar dari 0.
- **Jalur file gambar** harus valid dan menunjuk ke file yang ada.

## Struktur Data Paket
Setiap paket memiliki atribut berikut:
- **ID**: Nomor unik yang dihasilkan oleh aplikasi.
- **Deskripsi**: Keterangan tentang paket.
- **Berat**: Berat paket dalam kilogram.
- **Tujuan**: Lokasi tujuan pengiriman paket.
- **Biaya**: Biaya pengiriman yang dihitung berdasarkan berat.
- **Jalur Gambar**: Path menuju file gambar paket.

## Catatan
- Jalankan aplikasi ini pada sistem operasi yang mendukung Java
dan memiliki akses ke Desktop untuk membuka file gambar.
- Biaya pengiriman dihitung berdasarkan rumus sederhana: `Biaya = Berat x 10`.
Anda dapat memodifikasi metode `calculateCost` untuk menggunakan rumus lain jika diperlukan.

## Contoh Penggunaan
1. **Membuat Paket**
   - Masukkan deskripsi, berat, tujuan, dan jalur file gambar saat diminta.
   - Program akan menghitung biaya secara otomatis dan menampilkan detail paket yang berhasil dibuat.

2. **Melihat Semua Paket**
   - Pilih opsi 2 di menu utama.
   - Semua paket yang tersimpan akan ditampilkan di konsol.

3. **Menghapus Paket**
   - Pilih opsi 4 dan masukkan ID paket yang ingin dihapus.

## Pengembang
- **Nama**: [RAMAHAN & Revaldo Ramadan]


## Lisensi
Proyek ini menggunakan lisensi MIT. Silakan lihat file LICENSE untuk informasi lebih lanjut.
