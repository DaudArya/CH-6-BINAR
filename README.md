# CH-7-BINAR
- Unit Testing
- Firebase Feature (Analytics and CrashLytics)
- Build Flavoring (Free Version and Paid Version)
- User Profiler Documentation

---------------------------------------------------------------------------------------------------------------------------
ANDROID PROFILER
---------------------------------------------------------------------------------------------------------------------------

Aplikasi yang akan dianalisis dengan Android Profiler:
MyMovies (Versi Gratis) dan BullMovies (VersiBerbayar)

Network Profiler
---------------------------------------------------------------------------------------------------------------------------
Network Profiler menampilkan aktivitas jaringan secara real time pada linimasa, yang menunjukkan data terkirim dan diterima, serta jumlah koneksi saat ini. Hal ini memungkinkan Anda memeriksa cara dan waktu aplikasi mentransfer data, serta mengoptimalkan kode yang mendasarinya dengan semestinya.

Untuk membuka Network Profiler, ikuti langkah-langkah berikut:

1. Klik View > Tool Windows > Profiler (Anda juga dapat mengklik Profile  di toolbar).

2. Pilih perangkat dan proses aplikasi yang ingin dibuat profilnya dari toolbar Android Profiler.
(Jika Anda telah menyambungkan perangkat melalui USB, tetapi tidak melihatnya tercantum, pastikan Anda telah mengaktifkan proses debug USB.)

3. Anda bisa menembukan fitur ini pada bagian bawah android studio pada tab profiler -> Network Inspector , pastikan perangkat anda tersambung ke internet

Pada Running Aplikasi “Movies” yang memiliki opsi aktivitas yang melibatkan internet antara lain :
Membuka Movies Detail pada saat icon movies di klik.
Menampilkan Daftar movies dengan request data ke API ke TMDB (Popular Movies, Top Rated Movies, dan Upcoming Movies).
Kami Melakukan Pengujian pada Network Profiler ketika aplikasi dijalankan, dengan langkah - langkah berikut,


1.Membuka Aplikasi “Movies”

![splashscreen](https://user-images.githubusercontent.com/90670459/200175591-381fbdc4-71c2-4c54-bf25-7383c939cd2d.png)

2.Klik Movies yang akan dibuka

![homescreen](https://user-images.githubusercontent.com/90670459/200175664-3d83dc62-e3d6-4635-b94b-42b56ea375c7.png)

Network Profiler akan memberikan feedback berupa data internet yang digunakan pada aplikasi ketika membuka aplikasi , dimana request API yakni Get Popular Movies dengan data sebagai berikut : 

![image](https://user-images.githubusercontent.com/90670459/200175979-56bdf71b-4d37-4b1b-90c4-cf386be6619b.png)


lalu data yang digunakan dalam aplikasi akan dicatat dalam network profiler dengan keterangan get API popular movies seperti pada Connection View, dimana data yang diterima dan dikirim adalah sebagai berikut : 

Max Data Recieving : 11.8 Kb/s 
 Max Data Sending : 1.9 Kb/s

pada proses berikut request yang dilakukan oleh aplikasi adalah sebagai berikut , 
dengan response sebagai berikut,

3.Network Profiler ketika membuka detail Movies

![image](https://user-images.githubusercontent.com/90670459/200175837-2fb773c3-9647-4998-8259-8a9ff6fee37b.png)

lalu data yang digunakan dalam aplikasi akan dicatat dalam network profiler dengan keterangan get API salah satu movies yakni “ Black Adam” seperti pada Connection View, dimana data yang diterima dan dikirim adalah sebagai berikut : 

Max Data Recieving : 9.2 Kb/s 
 Max Data Sending : 2 Kb/s

Memory Profiler 
---------------------------------------------------------------------------------------------------------------------------
Memory Profiler adalah komponen dalam Android Profiler yang membantu Anda mengidentifikasi kebocoran memori dan churn memori yang dapat menyebabkan aplikasi tersendat, berhenti merespons, dan bahkan tidak bekerja. Komponen ini menampilkan grafik yang realtime atas penggunaan memori aplikasi Anda, yang memungkinkan Anda merekam heap dump, memaksa pembersihan sampah memori, dan melacak alokasi memori.

Untuk membuka Memory Profiler, ikuti langkah-langkah berikut:

1. Klik View > Tool Windows > Profiler (Anda juga dapat mengklik Profile  di toolbar).

2. Pilih perangkat dan proses aplikasi yang ingin dibuat profilnya dari toolbar Android Profiler.
(Jika Anda telah menyambungkan perangkat melalui USB, tetapi tidak melihatnya tercantum, pastikan Anda telah mengaktifkan proses debug USB.)

3. Klik di mana saja dalam linimasa MEMORY untuk membuka Memory Profiler
(Atau, Anda dapat memeriksa memori aplikasi dari command line dengan dumpsys, dan juga melihat peristiwa GC di logcat)

Untuk melihat kinerja memory yang digunakan pada aplikasi kita bisa melakukan pengujian yang sama dengan Network Profiler , yakni dengan membuka aplikasi dan membuka detail movies , lalu akan kami tambahkan aktivitas memory ketika menggunakan database local (edit user)

berikut adalah data memory yang digunakan saat aplikasi dibuka dan pengguna ada di home fragment
![image](https://user-images.githubusercontent.com/90670459/200176861-1c3ea08f-683d-4f93-96f2-e25551e9e728.png)

dari keterangan diatas aplikasi dalam keadaan idle atau tidak melakukan apa apa sudah mengkonsumsi 160mb memory yang ada pada device,

lalu berikut adalah grafik ketika aplikasi digunakan untuk membuka 3 detail movies ,
![image](https://user-images.githubusercontent.com/90670459/200176974-8403c87d-9947-48ef-b06a-9b0fb4b1ce3f.png)

dalam pengujian ketika membuka 3 detail movies rata-rata penggunaan memory melonjak sampai kurang lebih 18-25 MB 

Kemudian berikut adalah alokasi memory ketika digunakan untuk berinteraksi dengan database lokal (edit user profile)

pada penggunaan memory untuk edit user profile terdapat pergerakan grafik yang cukup berubah-ubah
![image](https://user-images.githubusercontent.com/90670459/200177296-c1be4b23-5ff3-4ff2-94be-4f0f86687682.png)

dimana grafik naik ketika memasuki fragment user edit hingga 170MB , lalu ketika membuka gallery grafik aplikasi turun hingga 151MB , dan naik kembali ketika galerry ditutup menjadi 170MB , akhirnya naik hingga 190MB ketika user menyimpan profilenya

![image](https://user-images.githubusercontent.com/90670459/200177428-76a34b8d-1768-4826-8554-4fd26d8ec156.png)

Kemudian berikut adalah dokumentasi dari headdump aplikasi ini 
![image](https://user-images.githubusercontent.com/90670459/200177562-2eab6bf9-e1f2-4506-889f-aef60f3e164b.png)

CPU Profiler
---------------------------------------------------------------------------------------------------------------------------
Anda dapat menggunakan CPU Profiler untuk memeriksa penggunaan CPU dan aktivitas thread aplikasi Anda secara real time saat berinteraksi dengan aplikasi Anda, atau Anda dapat memeriksa detailnya di rekaman pelacakan metode, rekaman aktivitas fungsi, dan pelacakan sistem.

Untuk membuka CPU Profiler, ikuti langkah-langkah berikut:

1. Pilih View > Tool Windows > Profiler atau klik Profile  pada toolbar.

2. Jika diminta oleh dialog Select Deployment Target, pilih perangkat tujuan deployment aplikasi untuk pembuatan profil. Jika Anda telah menyambungkan perangkat melalui USB, tetapi tidak melihatnya tercantum, pastikan Anda telah mengaktifkan proses debug USB.

3.Klik di mana saja dalam linimasa CPU untuk membuka CPU Profiler.

Untuk melihat kinerja memory yang digunakan pada aplikasi kita bisa melakukan pengujian  dengan membuka aplikasi dan membuka detail movies , dan ketika user mengubah profile miliknya.

Berikut adalah tampilan Event Timeline,CPU timeline dan Thread Activity Timeline ketika User membuka detail movies lalu ke home dan diulang sebanyak 5 kali,

![image](https://user-images.githubusercontent.com/90670459/200178060-27c78e27-19f4-4db6-b129-25fb2ad2dcd4.png)

dimana hasil yang didapatkan rata-rata penggunaan CPU pada setiap aksi adalah 12% , aktivitas background atay othernya adalah 28% dan menggunakan 77 thread hingga membuka aplikasi yang kelima.

berikut adalah penjelasan mengenai Timeline-timeline pada CPU Profiler
1. Event timeline: Menunjukkan aktivitas dalam aplikasi Anda saat bertransisi melalui berbagai keadaan dalam siklus prosesnya, dan menunjukkan interaksi pengguna dengan perangkat, termasuk peristiwa rotasi layar. Untuk mengetahui informasi tentang cara mengaktifkan linimasa peristiwa di perangkat yang menjalankan Android 7.1 (API level 25) dan yang lebih rendah, lihat Mengaktifkan pembuatan profil lanjutan.
2. CPU timeline: Menunjukkan penggunaan CPU secara real time oleh aplikasi Anda, berupa persentase dari total waktu CPU yang tersedia, dan total jumlah thread yang digunakan oleh aplikasi Anda. Linimasa ini juga menunjukkan penggunaan CPU oleh proses lainnya (seperti proses sistem atau aplikasi lainnya) sehingga Anda dapat membandingkannya dengan penggunaan oleh aplikasi Anda. Anda dapat memeriksa data penggunaan CPU secara historis dengan menggerakkan mouse di sepanjang sumbu horizontal linimasa.
3. Thread activity timeline: Mencantumkan setiap thread yang termasuk dalam proses aplikasi dan menunjukkan aktivitasnya sepanjang linimasa tertentu menggunakan warna yang tercantum di bawah ini. Setelah merekam aktivitas, Anda dapat memilih thread dari linimasa ini untuk memeriksa datanya di panel rekaman aktivitas.
Hijau: Thread aktif atau siap untuk menggunakan CPU. Dengan kata lain, thread sudah berjalan atau dalam keadaan dapat dijalankan.
Kuning: Thread aktif, tetapi sedang menunggu operasi I/O, (misalnya, I/O jaringan atau disk) sebelum dapat menyelesaikan pekerjaannya.
Abu-Abu: Thread sedang tidur dan tidak menggunakan waktu CPU sama sekali. Hal ini terkadang terjadi ketika thread memerlukan akses ke resource yang belum tersedia. Thread akan tidur dengan sendirinya, atau kernel akan menidurkan thread hingga resource yang diperlukannya tersedia.

Energy Profiler
---------------------------------------------------------------------------------------------------------------------------
Energy Profiler memantau penggunaan CPU, radio jaringan, dan sensor GPS, serta menampilkan visualisasi jumlah energi yang digunakan setiap komponen. Energy Profiler juga menunjukkan kemunculan peristiwa sistem (penguncian layar saat aktif, alarm, tugas, dan permintaan lokasi) yang dapat memengaruhi konsumsi energi.
Energy Profiler tidak secara langsung mengukur konsumsi energi. Sebaliknya, fitur ini menggunakan model yang memperkirakan konsumsi energi untuk setiap resource pada perangkat.

untuk mengakses Energy Profiler tidak jauh beda dengan profiler lainnya yakni sebagai berikut,

1. Pilih View > Tool Windows > Profiler atau klik Profile  pada toolbar.
Jika diminta oleh dialog Select Deployment Target, pilih perangkat tujuan deployment aplikasi untuk pembuatan profil. Jika Anda telah menyambungkan perangkat melalui USB, tetapi tidak melihatnya tercantum, pastikan Anda telah mengaktifkan proses debug USB.

2. Klik di mana saja pada linimasa Energy untuk membuka Energy Profiler.

Berikut adalah pengujian dimana kami membuka 6 detail movies seperti pada pengujian sebeleumnya dan di dapatkan data sebagai berikut,

![image](https://user-images.githubusercontent.com/90670459/200178568-19ceb833-6ff4-4bce-8f78-ab62b69582a7.png)

pada penggunaannya ada 3 indikator utama dalam penentuan aktivitas mana yang menghabiskan daya pada ponsel ketika menjalankan aplikasi yakni CPU Usage, Network Usage, dan Location Usage, 

karena aplikasi ini tidak memerlukan Location Usage maka penggunaannya akan selalau None atau nol, sedangkan rata-rata penggunaan CPU ketika user membuka detail movies berada pada tingkatan light atau ringan dan paling tinggi berada ditingakt medium, dan network usage juga sama dengan CPU usage.

maka dapat disimpulkan aplikasi ini cukup hemat daya karena penggunaan sumber daya pada fitur-fiturnya cukup minim.




