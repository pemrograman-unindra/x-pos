# x-pos
Point Of Sales Sederhana

## Kontributor
- 202043500406 - [Mitra Perdana](mailto:mitraperdana96@gmail.com)
- 202043500433 - [Irvan Cornelius](https://github.com/Irvan1105)
- 202043500516 - [Taufik Alkaf](https://github.com/Taufikalkaf)
- 202043500668 - [Fajar Sidik](https://github.com/Fajarsidik27)
- 202143579025 - [Syihabudien Arief](https://github.com/Syihabudien)
- 202243570024 - [Jeffry Luqman](https://github.com/jeffry-luqman)
- 202243570052 - [Muhammad Sulton Fauzi](https://github.com/msfauzi10)
- 202343570068 - [Alamanda Septiara](https://github.com/Almnd3424)

## Memulai tanpa maven
1. Pastikan komputer kamu sudah terinstall [Git](https://git-scm.com/) dan [Java Development Kit](http://jdk.java.net/).
2. Buka terminal (linux atau mac) atau powershell (windows), clone repositori ini ke komputer kamu dan masuk ke folder yang terbentuk
	```bash
	git clone https://github.com/pemrograman-unindra/x-pos.git
	cd x-pos
	```
3. Lakukan kompilasi aplikasi
	```bash
	# linux atau mac
	javac -d target/classes $(find src/main/java -name "*.java")

	# windows dengan powershell
	javac -d target/classes (Get-ChildItem -Recurse -Filter *.java src/main/java).FullName
	```
4. Jalankan aplikasi
	```bash
	java -cp target/classes XPOS
	```
5. build file .jar agar dapat didistribusikan
	```bash
	jar --create --file target/x-pos-1.0.jar --main-class XPOS -C target/classes .
	```
6. Jalankan aplikasi yang sudah di build ke file .jar
	```bash
	java -jar target/x-pos-1.0.jar
	```

## Memulai dengan maven
1. Pastikan komputer kamu sudah terinstall [Git](https://git-scm.com/), [Java Development Kit](http://jdk.java.net/), dan [Maven](https://maven.apache.org/download.cgi).
2. Buka terminal atau powershell, clone repositori ini ke komputer kamu dan masuk ke folder yang terbentuk
	```bash
	git clone https://github.com/pemrograman-unindra/x-pos.git && cd x-pos
	```
3. Lakukan kompilasi aplikasi
	```bash
	mvn clean install
	```
4. Jalankan aplikasi
	```bash
	java -jar target/x-pos-1.0.jar
	```

## Fitur
- [x] Menampilkan Daftar Produk
- [x] Melihat Rincian Produk
- [x] Menambah Data Produk
- [x] Merubah Data Produk
- [x] Menghapus Data Produk
- [x] Menampilkan Daftar Kelompok Produk
- [x] Melihat Rincian Kelompok Produk
- [x] Menambah Data Kelompok Produk
- [x] Merubah Data Kelompok Produk
- [x] Menghapus Data Kelompok Produk
- [x] Menampilkan Daftar Transaksi Penjualan
- [x] Melihat Rincian Transaksi Penjualan
- [x] Menambah Transaksi Penjualan
- [x] Merubah Transaksi Penjualan
- [x] Menghapus Transaksi Penjualan
