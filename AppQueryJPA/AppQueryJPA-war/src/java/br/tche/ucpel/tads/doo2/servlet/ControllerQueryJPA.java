package br.tche.ucpel.tads.doo2.servlet;

import br.tche.ucpel.tads.doo2.ejb.JPAQueriesRemote;
import br.tche.ucpel.tads.doo2.persisty.Departamento;
import br.tche.ucpel.tads.doo2.persisty.Pessoa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mertins
 */
@WebServlet(name = "ControllerQueryJPA", urlPatterns = {"/jpaquerycontrol"})
public class ControllerQueryJPA extends HttpServlet {

    private enum OPCOES {

        POPULABD, LISTADEPT, LISTAPESSOAPARTE, LISTAPESSOACPF, LISTAPESSOANOMEDEPT, ATUALIZASAL
    }
    @EJB
    private JPAQueriesRemote ejbQueries;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        String opc = req.getParameter("opcao");
        if (opc == null) {
            dispatcher = req.getRequestDispatcher("index.jsp");
        } else {
            try {
                OPCOES opcao = OPCOES.valueOf(opc.toUpperCase());
                switch (opcao) {
                    case POPULABD:
                        ejbQueries.popula();
                        dispatcher = req.getRequestDispatcher("mensagem.jsp");
                        break;
                    case LISTADEPT:
                        List<Departamento> lstDept = ejbQueries.findDepartamentos();
                        req.setAttribute("listaDept", lstDept);
                        dispatcher = req.getRequestDispatcher("listaDepartamentos.jsp");
                        break;
                    case LISTAPESSOAPARTE:
                        List<Pessoa> lstPessoas = ejbQueries.findPessoasPorNome("%ÃO%");
                        req.setAttribute("lstPessoas", lstPessoas);
                        dispatcher = req.getRequestDispatcher("listaPessoas.jsp");
                        break;
                    case LISTAPESSOACPF:
                        Pessoa pessoa = ejbQueries.findPessoaCPF("45445");
                        List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
                        if (pessoa != null) {
                            lstPessoa.add(pessoa);
                        }
                        req.setAttribute("lstPessoas", lstPessoa);
                        dispatcher = req.getRequestDispatcher("listaPessoas.jsp");
                        break;
                    case LISTAPESSOANOMEDEPT:
                        List<Pessoa> lstPessoasDept = ejbQueries.findPessoasPorNomeDepartamento("RH");
                        req.setAttribute("lstPessoas", lstPessoasDept);
                        dispatcher = req.getRequestDispatcher("listaPessoas.jsp");
                        break;
                    case ATUALIZASAL:
                        int numLinhas = ejbQueries.aumentoSalario(10);
                        dispatcher = req.getRequestDispatcher("mensagem.jsp");
                        break;
                }
            } catch (IllegalArgumentException ex) {
                dispatcher = req.getRequestDispatcher("index.jsp");
            } catch (Exception ex) {
                req.setAttribute("javax.servlet.jsp.jspException", ex);
                req.setAttribute("javax.servlet.error.status_code", 0);
                dispatcher = req.getRequestDispatcher("paginaErro.jsp");
            }
        }
        dispatcher.forward(req, resp);
    }
}
