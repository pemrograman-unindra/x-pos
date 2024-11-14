# x-pos
Point Of Sales Sederhana

## Kontributor
- NPM - [Alamanda Septiara](https://github.com/Almnd3424)
- NPM - [Fajar Sidik](fajarsidik0327@gmail.com)
- NPM - [Irvan Cornelius](https://github.com/Irvan1105)
- 202243570024 - [Jeffry Luqman](https://github.com/jeffry-luqman)
- NPM - [Mitra Perdana](mitraperdana96@gmail.com)
- NPM - [Muhammad Sulton Fauzi](https://github.com/msfauzi10)
- NPM - [Satrio Bagus. D](strbgs21@gmail.com)
- NPM - [Syihabudien Arief](https://github.com/Syihabudien)
- NPM - [Taufik Alkaf](taufik.alkaf9@gmail.com)

## Memulai tanpa maven
1. Pastikan komputer kamu sudah terinstall [Git](https://git-scm.com/) dan [Java Development Kit](http://jdk.java.net/).
2. Buka terminal (linux atau mac) atau powershell (windows), clone repositori ini ke komputer kamu dan masuk ke folder yang terbentuk
	```bash
	git clone https://github.com/pemrograman-unindra/x-pos.git && cd x-pos
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
- [ ] Menampilkan Daftar Transaksi Penjualan
- [ ] Melihat Rincian Transaksi Penjualan
- [ ] Menambah Transaksi Penjualan
- [ ] Merubah Transaksi Penjualan
- [ ] Menghapus Transaksi Penjualan
