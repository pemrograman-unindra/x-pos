# x-pos
Point Of Sales Sederhana, Tugas PBO Kelompok 1 Kelas X5C

## Anggota

NPM          | Nama                                                        | Pembagian Tugas
-------------|-------------------------------------------------------------|--------------------------
202243570024 | [Jeffry Luqman](https://github.com/jeffry-luqman)           | Menampilkan daftar dan rincian produk
202XXXXXXXXX | -                                                           | Menambah data produk
202XXXXXXXXX | -                                                           | Merubah data produk
202XXXXXXXXX | -                                                           | Menghapus data produk
202XXXXXXXXX | -                                                           | Menampilkan daftar dan rincian transaksi penjualan
202XXXXXXXXX | -                                                           | Menambah transaksi penjualan
202XXXXXXXXX | -                                                           | Merubah transaksi penjualan
202XXXXXXXXX | -                                                           | Menghapus transaksi penjualan

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
	# jika build nya menggunakan maven : execute jar file
	java -jar target/x-pos-1.0.jar

	# jika build nya menggunakan maven : run java class
	cd target/classes && java App

	# jika build nya tanpa menggunakan maven : run java class
	cd src/main/java && javac App.java
	```

## Fitur
- [ ] Menampilkan Daftar Produk
- [ ] Melihat Rincian Produk
- [ ] Menambah Data Produk
- [ ] Merubah Data Produk
- [ ] Menghapus Data Produk
- [ ] Menampilkan Daftar Transaksi Penjualan
- [ ] Melihat Rincian Transaksi Penjualan
- [ ] Menambah Transaksi Penjualan
- [ ] Merubah Transaksi Penjualan
- [ ] Menghapus Transaksi Penjualan
