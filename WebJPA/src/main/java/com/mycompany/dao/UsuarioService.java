
package com.mycompany.dao;

import com.mycompany.entity.Usuario;
import javax.ejb.Remote;


@Remote
public interface UsuarioService {
    Usuario retrieve(String login);
}
