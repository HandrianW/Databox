**Databox Documentation**

    1. Definition

	Databox adalah aplikasi pencatatan barang kontainer yang ditujukan untuk operator logistik pelabuhan agar koordinasi lapangan saat pengeluaran barang dari kapal dapat berjalan lancar. Databox memiliki 2 aplikasi, Client dan Admin. Client hanya bisa melihat informasi berdasarkan nama atau kode Item, sedangkan Admin dapat melakukan Create, Update dan Delete pada data Item.  


    2. System
       
	Pembuatan aplikasi Databox menggunakan Kotlin Android Studio dengan minimum OS Lolipop (5.1) dan menggunakan XML. Data yang diolah ada 4, yaitu :
    • Goods Name (Nama atau Kode barang)
    • Owner Name (Pemilik Barang)
    • Destination (Data Tujuan Barang)
    • Weight (Berat barang (Kg))



    3. Halaman
       
        a) Admin
            i. Halaman Utama
                    Halaman utama akan muncul pertamakali saat aplikasi dijalankan. Pada halaman utama terdapat 3 Option, Upload Data, Update Data atau Delete Data.

![image](https://github.com/HandrianW/Databox/assets/69663236/4bd27f87-6c99-4b14-97ac-dfaa7621fb12)


          ii. Halaman Upload
			              Halaman Upload adalah halaman untuk mengupload data item. 

![image](https://github.com/HandrianW/Databox/assets/69663236/2b776d91-1c35-4bd9-87bc-2049575e9b17)


        iii. Halaman Update
			            Halaman Update adalah halaman untuk mengubah data item.Dengan data Goods Name sebagai reference.

![image](https://github.com/HandrianW/Databox/assets/69663236/0f4b6714-f46d-4557-b63e-fa9dd3f3c4e7)


          v. Halaman Delete  
			            Halaman Delete adalah halaman untuk menghapus data item. Dengan data Goods Name sebagai reference.

![image](https://github.com/HandrianW/Databox/assets/69663236/a6df9315-aefa-448b-b905-4596a957a253)


      b) User
        i. Halaman Cari
                  Halaman Cari akan muncul pertamakali saat aplikasi Client Databox dijalankan. Pada halaman ini user Client dapat mencari Data Item dengan Goods Name sebagai reference.
                  
![image](https://github.com/HandrianW/Databox/assets/69663236/b398ed3e-ea29-4ba4-b866-6bf2d660b6ae)

