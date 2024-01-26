package br.edu.ucpel.lp2.jsf.mng;

import br.edu.ucpel.lp2.dao.FuncionarioDAOLocal;
import br.edu.ucpel.lp2.jpa.Departamento;
import br.edu.ucpel.lp2.jpa.Funcionario;
import br.edu.ucpel.lp2.jpa.Regiao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.validation.constraints.Pattern;

/**
 * ...
 */
@Named(value = "funcionarioMNG")
@RequestScoped
public class FuncionarioMNG {

    @EJB
    FuncionarioDAOLocal dao;
    private String codigo;
    private String nome;
    private Date dtContratacao;
    private Double salario;
    private Departamento departamento;
    private Regiao regiao; 

  
    public FuncionarioMNG() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtContratacao() {
        return dtContratacao;
    }

    public void setDtContratacao(Date dtContratacao) {
        this.dtContratacao = dtContratacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public List<Funcionario> getLista() {
        return dao.listaTodos();
    }

    public void clear(AjaxBehaviorEvent event) {
        this.codigo = null;
        this.nome = null;
        this.regiao = null; // Limpar a Regiao
    }

    public String save() {
        Funcionario elem = new Funcionario();
        elem.setDepartamento(this.departamento);        
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        elem.setDtContratacao(new Date());
        elem.setNome(this.nome);
        elem.setSalario(this.salario);
        elem.setRegiao(this.regiao); 
        dao.create(elem);
        return "funcionarioList";
    }

    public void remove() {
        Long index = Long.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codExcluir").toString());
        Funcionario elem = new Funcionario();
        elem.setCodigo(index);
        dao.delete(elem);
        this.clear(null);
    }

    public String prepUpdate() {
        Long index = Long.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codEditar").toString());
        Funcionario elem = new Funcionario();
        elem.setCodigo(index);
        elem = dao.retrieve(elem);
        this.codigo = elem.getCodigo().toString();
        this.nome = elem.getNome();
        this.salario = elem.getSalario();
        this.dtContratacao = elem.getDtContratacao();
        this.departamento = elem.getDepartamento();
        this.regiao = elem.getRegiao(); // Definir a Regiao
        return "funcionarioUpdate";
    }

    public String update() {
        Funcionario elem = new Funcionario();
        elem.setCodigo(Long.valueOf(codigo));
        elem.setNome(nome);
        elem.setDepartamento(departamento);
        elem.setSalario(salario);
        elem.setDtContratacao(dtContratacao);
        elem.setRegiao(this.regiao); // Definir a Regiao
        dao.update(elem);
        return "funcionarioList";
    }
}
