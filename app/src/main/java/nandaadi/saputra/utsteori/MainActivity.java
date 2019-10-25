package nandaadi.saputra.utsteori;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_kodePelanggan)
    EditText edtKodePelanggan;
    @BindView(R.id.edt_nama)
    EditText edtNama;
    @BindView(R.id.edt_type)
    EditText edtType;
    @BindView(R.id.edt_meterAwal)
    EditText edtMeterAwal;
    @BindView(R.id.edt_meterAkhir)
    EditText edtMeterAkhir;
    @BindView(R.id.edt_pemakaian)
    EditText edtPemakaian;
    @BindView(R.id.edt_harga)
    EditText edtHarga;
    @BindView(R.id.edt_bayar)
    EditText edtBayar;
    @BindView(R.id.tv_kategori)
    TextView tvKategori;
    @BindView(R.id.tv_uangkembalian)
    TextView tvUangkembalian;
    @BindView(R.id.tv_keterangan)
    TextView tvKeterangan;
    @BindView(R.id.btn_hapus)
    Button btnHapus;
    @BindView(R.id.btn_keluar)
    Button btnKeluar;
    @BindView(R.id.btn_total)
    Button btnTotal;
    @BindView(R.id.tv_jumlahbayar)
    TextView tvJumlahbayar;
    @BindView(R.id.tv_totalPemakaian)
    TextView tvTotalPemakaian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Program Sederhana UTS Teori");

        //memberikan action pada tombol total

        btnTotal.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Katogori Pembayaran",
                    Toast.LENGTH_LONG).show();
            String kodepelanggan = edtKodePelanggan.getText().toString().trim();
            String nama = edtNama.getText().toString().trim();
            String type = edtType.getText().toString().trim();
            String meter_awal = edtMeterAwal.getText().toString().trim();
            String meter_akhir = edtMeterAkhir.getText().toString().trim();
            String pemakaian = edtPemakaian.getText().toString().trim();
            String harga = edtHarga.getText().toString().trim();
            String bayar = edtBayar.getText().toString().trim();
            String total = tvJumlahbayar.getText().toString().trim();
            String kategori = tvKategori.getText().toString().trim();

            double pemakaianitem = Double.parseDouble(pemakaian);
            double hargaitem = Double.parseDouble(harga);
            double uangbayar = Double.parseDouble(bayar);
            double meterawalitem = Double.parseDouble(meter_awal);
            double meterakhiritem = Double.parseDouble(meter_akhir);
            double totalbayar = (pemakaianitem * hargaitem);
            double totalpemakaian = (meterawalitem - meterakhiritem);
            tvJumlahbayar.setText("Total Bayar : " + totalbayar);
            tvTotalPemakaian.setText("Total Pemakaian: "+ totalpemakaian);

            //pemberian if dan else untuk aturan pemberian harga
            if (totalbayar < 150000) {
                tvKategori.setText("Kategori Boros: " + "Anda Termasuk Kategori Irit");
            }else if(totalbayar>150000&& totalbayar <=200000){
                tvKategori.setText("Kategori Boros : "+"Anda Termasuk Kategori Agak Boros");

            } else if (totalbayar > 200000) {
                tvKategori.setText("Kategori Boros : "+"Anda Termasuk Kategori Boros");
            } else if (totalbayar ==0) {
                tvKategori.setText("Kategori Boros : "+"Maaf Anda Tidak Menginput atau Salah Input");
            }
            double uangkembalian = (uangbayar - totalbayar);

            if (uangbayar < totalbayar) {
                tvKeterangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                tvUangkembalian.setText("Uang Kembali : Rp 0");
            } else {
                tvKeterangan.setText("Keterangan : Tunggu Kembalian");
                tvUangkembalian.setText("Uang Kembali : " + uangkembalian);
            }

            //memberikan action pada tombol hapus
        });
        btnHapus.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Anda Berhasil Menghapus Data",
                    Toast.LENGTH_LONG).show();
            edtKodePelanggan.setText(" ");
            edtNama.setText(" ");
            edtType.setText(" ");
            edtMeterAwal.setText(" ");
            edtMeterAkhir.setText(" ");
            tvJumlahbayar.setText(" Total Bayar : Rp 0");
            edtHarga.setText(" ");
            edtBayar.setText(" ");
            tvUangkembalian.setText("Uang Kembali : Rp 0");
            edtPemakaian.setText(" ");
            tvKeterangan.setText("Keterangan : - ");

            Toast.makeText(MainActivity.this.getApplicationContext(), "Data sudah direset", Toast.LENGTH_LONG).show();

            // memberikan action pada tombol keluar
        });
        btnKeluar.setOnClickListener(view -> MainActivity.this.moveTaskToBack(true));
    }
}
