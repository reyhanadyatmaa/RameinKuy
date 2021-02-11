package id.ramein.prakerin.pesanmenurestoran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/* ======= AUTHORS FAKHRUS SYAKIRIN RAMADHAN | RAMEIN.ID | fakhrusramadhan@gmail.com ====== */
/* This Apps is for learning how to develop android apps */


public class PesanMenuActivity extends AppCompatActivity {

    private String dataNamaPengunjung;
    private TextView tv_welcomePengunjung, tv_totalHargaMakanan, tv_totalHargaMinuman, tv_totalKeseluruhan,
                        tv_hargaIndomie, tv_hargaEsteh, tv_jumlahIndomie, tv_jumlahEsteh;

    private Button bt_tambahIndomie, bt_kurangIndomie, bt_tambahEsteh, bt_kurangEsteh, bt_bayar;
    private int jumlahIndomie, jumlahHargaIndomie, jumlahEsteh, jumlahHargaEsteh;


    // Ubah Harga Makanan atau Minuman di sini :
    private int hargaEsteh = 2500;
    private int hargaIndomie = 6000;
    private int hargaKeseluruhan;


    // PUSAT KENDALI  onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan_menu);

        // Panggil semua method disini

        panggilView();
        tangkapDataIntent();
        actionView();
    }


    void kondisiTidakBolehMinusIndomie() {

        if (jumlahIndomie <= 0){
            jumlahIndomie = 0;
            jumlahHargaIndomie = 0;
        }
    }

    void kondisiTidakBolehMinusEsteh() {

        if (jumlahEsteh <= 0){
            jumlahEsteh = 0;
            jumlahHargaEsteh = 0;
        }
    }

    void totalHargaKeseluruhan () {

        hargaKeseluruhan = jumlahHargaIndomie + jumlahHargaEsteh;
        tv_totalKeseluruhan.setText("Total Harga Keseluruhan =   Rp. " +  hargaKeseluruhan  +",-");
    }





    private void actionView() {

        tv_hargaIndomie.setText("Rp. "+hargaIndomie);
        tv_hargaEsteh.setText("Rp. "+hargaEsteh);

        bt_tambahIndomie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // tampil di atas tombol + -
                jumlahIndomie = jumlahIndomie + 1;

                // cek kondisi
                kondisiTidakBolehMinusIndomie();

                // tampil di atas daftar menu
                jumlahHargaIndomie = hargaIndomie * jumlahIndomie;

                // set jumlah indomie
                tv_jumlahIndomie.setText(""+jumlahIndomie);

                // set total harga indomie
                tv_totalHargaMakanan.setText("Total Harga Indomie =   "+jumlahHargaIndomie+",-");

                totalHargaKeseluruhan();

            }
        });

        bt_kurangIndomie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // tampil di atas tombol + -
                jumlahIndomie = jumlahIndomie - 1;

                // cek kondisi
                kondisiTidakBolehMinusIndomie();

                // tampil di atas daftar menu
                jumlahHargaIndomie = hargaIndomie * jumlahIndomie;

                // set jumlah indomie
                tv_jumlahIndomie.setText(""+jumlahIndomie);

                // set total harga indomie
                tv_totalHargaMakanan.setText("Total Harga Indomie =   "+jumlahHargaIndomie+",-");

                totalHargaKeseluruhan();

            }
        });

        bt_tambahEsteh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // tampil di atas tombol + -
                jumlahEsteh = jumlahEsteh + 1;

                // cek kondisi
                kondisiTidakBolehMinusEsteh();

                // tampil di atas daftar menu
                jumlahHargaEsteh = hargaEsteh * jumlahEsteh;

                // set jumlah indomie
                tv_jumlahEsteh.setText(""+jumlahEsteh);

                // set total harga indomie
                tv_totalHargaMinuman.setText("Total Harga Es Teh =   "+jumlahHargaEsteh+",-");

                totalHargaKeseluruhan();

            }
        });

        bt_kurangEsteh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // tampil di atas tombol + -
                jumlahEsteh = jumlahEsteh - 1;

                // cek kondisi
                kondisiTidakBolehMinusEsteh();

                // tampil di atas daftar menu
                jumlahHargaEsteh = hargaEsteh * jumlahEsteh;

                // set jumlah indomie
                tv_jumlahEsteh.setText(""+jumlahEsteh);

                // set total harga indomie
                tv_totalHargaMinuman.setText("Total Harga Es Teh =   "+jumlahHargaEsteh+",-");

                totalHargaKeseluruhan();

            }
        });


        bt_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent keDetailPemesanan = new Intent(PesanMenuActivity.this, DetailPemesananActivity.class);

                //lempar data harga keseluruhan ke detail pemesanan activity
                keDetailPemesanan.putExtra("totalPemesanan", ""+hargaKeseluruhan);

                startActivity(keDetailPemesanan);
            }
        });

    }





    private void panggilView() {
        tv_welcomePengunjung = (TextView) findViewById(R.id.tv_welcomePengunjung);

        tv_totalHargaMakanan = (TextView) findViewById(R.id.tv_totalHargaMakanan);
        tv_totalHargaMinuman = (TextView) findViewById(R.id.tv_totalHargaMinuman);
        tv_totalKeseluruhan = (TextView) findViewById(R.id.tv_totalHargaKeseluruhan);

        tv_hargaIndomie = (TextView) findViewById(R.id.tv_hargaIndomie);
        tv_hargaEsteh = (TextView) findViewById(R.id.tv_hargaEsteh);

        tv_jumlahIndomie = (TextView) findViewById(R.id.tv_jumlahIndomie);
        tv_jumlahEsteh = (TextView) findViewById(R.id.tv_jumlahEsteh);

        bt_tambahIndomie = (Button) findViewById(R.id.bt_tambahIndomie);
        bt_kurangIndomie = (Button) findViewById(R.id.bt_kurangIndomie);
        bt_tambahEsteh = (Button) findViewById(R.id.bt_tambahEsteh);
        bt_kurangEsteh = (Button) findViewById(R.id.bt_kurangEsteh);

        bt_bayar = (Button) findViewById(R.id.bt_bayar);
    }





    private void tangkapDataIntent() {

        // tangkap data nama pengunjung dari intent MainActivity
        dataNamaPengunjung = getIntent().getExtras().getString("namaPengunjung");

        //set nama pengunjung
       // tv_welcomePengunjung.setText("Selamat Datang "+dataNamaPengunjung);
    }
}
