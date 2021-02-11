package id.ramein.prakerin.pesanmenurestoran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailPemesananActivity extends AppCompatActivity {

    private TextView tv_totalPemesanan;
    private Button bt_pesanLagi, bt_selesai;
    private String teksTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan);

        panggilView();
        tangkapDataIntent();
        actionView();
    }

    private void actionView() {
        bt_pesanLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // fungsi untuk kembali seperti menekan tombol back pada smartphone
                onBackPressed();
            }
        });

        bt_selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // siapkan intent dari detail pemesanan ke main
                Intent keMainActivity = new Intent(DetailPemesananActivity.this, MainActivity.class);

                // supaya setelah sampai di main activity dan di tekan tombol back tidak kembali ke detail pemesanan
                keMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // pindah ke main
                startActivity(keMainActivity);

            }
        });
    }

    private void tangkapDataIntent() {
        teksTotal = getIntent().getExtras().getString("totalPemesanan");
        tv_totalPemesanan.setText("Rp. " + teksTotal + ",-");
    }

    private void panggilView() {
        tv_totalPemesanan = (TextView) findViewById(R.id.tv_totalPemesanan);
        bt_pesanLagi = (Button) findViewById(R.id.bt_pesanLagi);
        bt_selesai = (Button) findViewById(R.id.bt_keluar);
    }
}
