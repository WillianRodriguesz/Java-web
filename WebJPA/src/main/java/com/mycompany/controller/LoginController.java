package com.mycompany.controller;

import com.mycompany.dao.UsuarioService;
import com.mycompany.entity.Usuario;
import com.mycompany.servlet.ServletPrincipal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author willian
 */

public class LoginController {
    
    @EJB
    private UsuarioService usuarioService;
    private HttpServletRequest req;
    private HttpServletResponse resp;

    public LoginController(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void processo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("txtUsuario");
        String senha = req.getParameter("txtSenha");

        Usuario usuario = usuarioService.retrieve(login);

        if (usuario == null || !usuario.validaSenha(senha)) {
            ServletPrincipal.dispatcherErro(req, resp, String.format("Usuário ou Senha Inválidos.[%s]", login));
            return;
        } else {
            req.getSession().setAttribute("UsuarioLogado", Boolean.TRUE);
            RequestDispatcher dispatcher = req.getRequestDispatcher("formprincipal.jsp");
            dispatcher.forward(req, resp);
        }
    }
    
}
