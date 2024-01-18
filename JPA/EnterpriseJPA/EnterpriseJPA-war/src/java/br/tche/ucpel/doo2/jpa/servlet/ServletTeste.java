package br.tche.ucpel.doo2.jpa.servlet;

import br.tche.ucpel.doo2.jpa.ejb.dao.DepartamentoDAORemote;
import br.tche.ucpel.doo2.jpa.ejb.dao.FuncionarioDAO;
import br.tche.ucpel.doo2.jpa.ejb.dao.FuncionarioDAORemote;
import br.ucpel.tche.doo2.jpa.bean.Departamento;
import br.ucpel.tche.doo2.jpa.bean.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mertins
 */
@WebServlet(name = "ServletTeste", urlPatterns = {"/testejpa"})
public class ServletTeste extends HttpServlet {

    @EJB
    DepartamentoDAORemote daoDept;
    @EJB
    FuncionarioDAORemote daoFunc = new FuncionarioDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            Departamento deptMarketing = new Departamento();
            deptMarketing.setDescricao("Marketing");
            Departamento deptControladoria = new Departamento();
            deptControladoria.setDescricao("Controladoria");

            deptMarketing=daoDept.create(deptMarketing);
            deptControladoria=daoDept.create(deptControladoria);

            Funcionario func = new Funcionario();
            func.setNome("Pedro");
            func.setSalario(1000.0);
            func.setDtContratacao(new Date());
            func.setDepartamento(deptMarketing);
            deptMarketing.addFuncionario(func);

            daoFunc.create(func);

            func = new Funcionario();
            func.setNome("Helena");
            func.setSalario(2000.0);
            func.setDtContratacao(new Date());
            func.setDepartamento(deptControladoria);
            func=daoFunc.create(func);

            deptControladoria.addFuncionario(func);
            deptControladoria.setDescricao("Nova Controladoria");
            daoDept.update(deptControladoria);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TesteContext</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabelas criadas se necessário</h1>");
            out.println("<h1>Informações inseridas</h1>");
            out.printf("<h1>Data: %s</h1>",new Date());
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            throw new ServletException("Não foi possível utilizar o JPA", ex);
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
