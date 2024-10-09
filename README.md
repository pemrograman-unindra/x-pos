# x-pos
Point Of Sales Sederhana, Tugas PBO Kelompok 1 Kelas X5C

## Anggota

NPM          | Nama                                                        | Pembagian Tugas
-------------|-------------------------------------------------------------|--------------------------
202243570024 | [Jeffry Luqman](https://github.com/jeffry-luqman)           | Menampilkan daftar dan rincian produk
-            | -                                                           | Menambah data produk
-            | -                                                           | Merubah data produk
-            | -                                                           | Menghapus data produk
-            | -                                                           | Menampilkan daftar dan rincian transaksi penjualan
-            | -                                                           | Menambah transaksi penjualan
-            | -                                                           | Merubah transaksi penjualan
-            | -                                                           | Menghapus transaksi penjualan

## Memulai
1. Pastikan komputer kamu sudah terinstall [Git](https://git-scm.com/), [Java Development Kit](http://jdk.java.net/), dan [Maven](https://maven.apache.org/download.cgi).
2. Buka terminal atau powershell, clone repositori ini ke komputer kamu dan masuk ke folder yang terbentuk
	```bash
	git clone https://github.com/pemrograman-unindra/x-pos.git && cd x-pos
	```
3. Lakukan kompilasi aplikasi
	```bash
	# menggunakan maven
	mvn clean install

	# tanpa menggunakan maven
	cd src/main/java && javac App.java
	```
4. Jalankan aplikasi
	```bash
	# menggunakan maven : execute jar file
	java -jar target/x-pos-1.0.jar

	# menggunakan maven : run java class
	cd target/classes && java App

	# tanpa menggunakan maven : run java class
	cd src/main/java && javac App.java
	```

## Fitur
- [x] Menampilkan Daftar Makanan
- [x] Melihat Rincian Makanan
- [x] Menambah Data Makanan
- [x] Merubah Data Makanan
- [x] Menghapus Data Makanan
- [x] Menampilkan Daftar Minuman
- [x] Melihat Rincian Minuman
- [x] Menambah Data Minuman
- [x] Merubah Data Minuman
- [x] Menghapus Data Minuman
- [x] Menampilkan Daftar Transaksi Penjualan
- [x] Melihat Rincian Transaksi Penjualan
- [x] Menambah Data Transaksi Penjualan
- [x] Merubah Data Transaksi Penjualan
- [x] Menghapus Data Transaksi Penjualan
