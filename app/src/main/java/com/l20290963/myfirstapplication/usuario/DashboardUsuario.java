package com.l20290963.myfirstapplication.usuario;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.l20290963.myfirstapplication.usuario.model.Usuario;
import com.l20290963.myfirstapplication.usuario.repository.UsuarioRepository;
import com.l20290963.myfirstapplication.R;

public class DashboardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_usuario);
        //Aquí creamos la instancia del Usuario repository
        ur = UsuarioRepository.getInstance();
        //Esta es la manera en que recibimos información de otro activity
        String usuario = getIntent().getStringExtra("usuario");
        String pass = getIntent().getStringExtra("pass");
        //Obtenemos información del usuario logueado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        /*ShapeableImageView ivUserImage = findViewById(R.id.ivUserImage);
        if ( userInfo.getGenero() == 'h' )
            ivUserImage.setImageResource(R.drawable.human_man);
        else
            ivUserImage.setImageResource(R.drawable.human_woman);*/


        TextView tvUserUsuario = findViewById(R.id.tvUserUsuario);
        TextView tvUserNombre = findViewById(R.id.tvUserNombre);
        TextView tvUserEmail = findViewById(R.id.tvUserEmail);
        TextView tvUserEdad = findViewById(R.id.tvUserEdad);

        tvUserUsuario.setText( userInfo.getUsuario() );
        tvUserNombre .setText( userInfo.getNombre() );
        tvUserEmail  .setText( userInfo.getEmail() );
        tvUserEdad   .setText( userInfo.getEdad() + " ".concat( getString(R.string.tvUserEdadComplement) ) );
    }
//Empieza tollbar clase 28 de septiembre
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tollbar_menu, menu);

        return true;

        public boolean nOptionsItemSelected(@NonNull item){
            if(item.getItemId()==R.id.miBorrar){
                Toast.makeText(this,"Borrar",Toast.LENGTH_LONG).show();
            } else if (item.getItemId()==R.id.miInfo) {
                Toast.makeText(this, "info", Toast.LENGTH_SHORT).show();

            }

        }
    }*/


}
