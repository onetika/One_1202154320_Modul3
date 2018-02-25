package android.example.com.one_1202154320_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText mUsername; //buat inisialisasi variabel user
    private EditText mPassword; //buat inisialisasi variabel pass

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUsername = (EditText) findViewById(R.id.username); //var user ambil id dari username
        mPassword = (EditText) findViewById(R.id.pass); //var pass ambil id dari password

    }

    public void Login(View view) {
        Intent intent = new Intent(this, MainActivity.class); //merujuk ke kelas MainActivity

        String username = mUsername.getText().toString(); //inisialisai parse si username ke string
        String password = mPassword.getText().toString(); //inisialisai parse si password ke string

        if ((username.equals("EAD")) || (password.equals("MOBILE")) ) { //buat kondisi dengan username dan password yang ditentukan
            Toast toast=Toast.makeText(this, "Anda Berhasil Login", Toast.LENGTH_SHORT); //menampilkan toast jika button di klik
            toast.show();
            startActivity(intent);

        } else {
            Toast toast = Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT); //nampilin toast jika button diklik tapi belum ada isi
            toast.show();}
    }
}
