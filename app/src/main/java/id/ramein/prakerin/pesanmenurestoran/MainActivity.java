package id.ramein.prakerin.pesanmenurestoran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/* ======= AUTHORS FAKHRUS SYAKIRIN RAMADHAN | RAMEIN.ID | fakhrusramadhan@gmail.com ====== */
/* This Apps is for learning how to develop android apps */


public class MainActivity extends AppCompatActivity {

    private Button btPesanMenu;
    private EditText etNamaPengunjung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // panggil semua method disini

        pemanggilanView();
        actionView();



    }


    private void pemanggilanView() {

        etNamaPengunjung = (EditText) findViewById(R.id.et_namaPengunjung);

        btPesanMenu = (Button) findViewById(R.id.bt_pesanMenu);
    }

    private void actionView() {

        // ACTION BUTTON ON CLICK
        btPesanMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Inisialisasi variable tampungNamaPengunjung dan ambil data dari EditText etNamaPengunjung
                String tampungNamaPengunjung = etNamaPengunjung.getText().toString();

                // Siapkan Perpindahan dari Main ke Pesan Menu) Activity
                Intent kePesanMenuActivity = new Intent(MainActivity.this, PesanMenuActivity.class);

                // Lempar data nama pengunjung edit text dari activity main ke activity pesan menu
                kePesanMenuActivity.putExtra("namaPengunjung", tampungNamaPengunjung);

                // Mulai perpindahan activity
                startActivity(kePesanMenuActivity);
            }
        });

    }

}
