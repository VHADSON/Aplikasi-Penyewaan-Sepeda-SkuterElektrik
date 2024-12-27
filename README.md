# Aplikasi Cek Ongkos Kirim

Aplikasi Cek Ongkos Kirim adalah sebuah aplikasi berbasis GUI yang dibuat menggunakan Java Swing. Aplikasi ini memungkinkan pengguna untuk:
- Melakukan login sederhana.
- Menghitung biaya pengiriman berdasarkan berat barang.
- Menampilkan data pengiriman dalam bentuk tabel.

## Fitur Utama
1. **Login dengan Validasi**
   - Pengguna diminta untuk memasukkan email dan password.
   - Validasi email untuk memastikan format yang benar (harus berakhir dengan `@gmail.com`).

2. **Penghitungan Ongkos Kirim**
   - Biaya pengiriman dihitung berdasarkan berat barang dengan tarif standar Rp 5.000 per kilogram.

3. **Tampilan Data Pengiriman**
   - Menyimpan informasi pengiriman dalam tabel, meliputi:
     - Email pengguna.
     - Alamat asal.
     - Alamat tujuan.
     - Berat barang.
     - Harga pengiriman.

4. **Tampilan Antarmuka yang Menarik**
   - Menggunakan panel dan tombol dengan desain gradien.
   - Komponen input memiliki desain sudut melengkung untuk pengalaman pengguna yang lebih baik.

## Teknologi yang Digunakan
- Bahasa Pemrograman: Java
- Framework: Java Swing untuk GUI

## Struktur Kode
Kode terdiri dari beberapa kelas utama:

### 1. **AplikasiOngkir**
   - Titik masuk utama aplikasi.
   - Memanggil `LoginFrame` untuk memulai proses login.

### 2. **LoginFrame**
   - Menyediakan antarmuka untuk login pengguna.
   - Validasi email dan password.
   - Mengarahkan ke `MainFrame` jika login berhasil.

### 3. **MainFrame**
   - Antarmuka utama aplikasi setelah login.
   - Menyediakan form untuk input data pengiriman.
   - Menghitung biaya pengiriman.
   - Menampilkan data pengiriman dalam tabel.

### 4. **GradientPanel**
   - Panel dengan latar belakang gradien untuk meningkatkan estetika aplikasi.

### 5. **RoundedButton**
   - Tombol dengan sudut melengkung dan efek gradien.

### 6. **RoundedTextField dan RoundedPasswordField**
   - Komponen input teks dan password dengan desain melengkung.

## Cara Menjalankan Aplikasi
1. Pastikan Java Development Kit (JDK) sudah terinstal.
2. Unduh atau kloning repositori ini.
3. Jalankan aplikasi melalui IDE favorit Anda atau gunakan perintah berikut di terminal:
   ```bash
   javac AplikasiOngkir.java
   java AplikasiOngkir
   ```
4. Ikuti langkah-langkah berikut:
   - Masukkan email dan password untuk login.
   - Input data pengiriman (alamat asal, alamat tujuan, dan berat barang).
   - Klik "Cek Ongkir" untuk menghitung biaya pengiriman.
   - Klik "Tambah ke Tabel" untuk menyimpan data ke dalam tabel.

## Struktur Direktori
```
|-- src
|   |-- AplikasiOngkir.java      # File utama aplikasi
|   |-- resources
|       |-- icon.png            # Ikon aplikasi
```

## Screenshot
1. **Halaman Login**
   Menampilkan formulir login sederhana.

2. **Halaman Utama**
   - Formulir input data pengiriman.
   - Kalkulasi biaya pengiriman.
   - Tabel data pengiriman.

## Lisensi
Proyek ini dilisensikan di bawah lisensi MIT. Silakan lihat file `LICENSE` untuk informasi lebih lanjut.

---
**Dibuat oleh:** RAMAHAN & Revaldo Ramadana

