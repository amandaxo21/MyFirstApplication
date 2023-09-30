package com.l20290963.myfirstapplication.usuario.repository;

import com.l20290963.myfirstapplication.usuario.model.Usuario;

import java.util.HashMap;

public class UsuarioRepository {
    private static UsuarioRepository repository = null;
    private HashMap< String, HashMap<String, Usuario>> registeredUsers;

    private UsuarioRepository() {
        Usuario u1 = new Usuario("Amanda", "mamabuebo", "Amanda Campos",
                "21", 'h', "Ac2583414@gmail.com");
        Usuario u2 = new Usuario("Willy", "123", "William",
                "21", 'h', "chilywilly@gmail.com");
        Usuario u3 = new Usuario("Check", "12345", "Sergio Santana",
                "21", 'm', "Sergio@gmail.com");

        this.registeredUsers = new HashMap<String, HashMap<String, Usuario> >();

        registeredUsers.put(u1.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPass(), u1);

        registeredUsers.put(u2.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPass(), u2);

        registeredUsers.put(u3.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPass(), u3);
    }

    public static UsuarioRepository getInstance() {
        if (repository == null)
            repository = new UsuarioRepository();

        return repository;
    }

    public HashMap<String, HashMap<String, Usuario>> getRegisteredUsers() {
        return registeredUsers;
    }
}

