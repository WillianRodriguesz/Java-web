package br.tche.ucpel.doo2.jpa.swing;

import br.tche.ucpel.doo2.jpa.swing.dao.DepartamentoDAO;
import br.tche.ucpel.doo2.jpa.swing.dao.FuncionarioDAO;
import br.tche.ucpel.doo2.jpa.swing.factory.ConexaoFactory;
import br.ucpel.tche.doo2.jpa.bean.Departamento;
import br.ucpel.tche.doo2.jpa.bean.Funcionario;
import java.util.Date;

public class Teste {

    public static void main(String[] args) {

//        Departamento deptRH = new Departamento();
//        deptRH.setDescricao("Recursos Humanos");
//        Departamento deptContab = new Departamento();
//        deptContab.setDescricao("Contabilidade");
//
//        DepartamentoDAO daoDept = new DepartamentoDAO();
//        deptRH=daoDept.create(deptRH);
//        deptContab=daoDept.create(deptContab);
//
//        Funcionario func=new Funcionario();
//        func.setNome("João");
//        func.setSalario(1000.0);
//        func.setDtContratacao(new Date());
//                    func.setDepartamento(deptRH);
//        deptRH.addFuncionario(func);
//
//        FuncionarioDAO daoFunc=new FuncionarioDAO();
//        daoFunc.create(func);
//
//        func=new Funcionario();
//        func.setNome("Maria");
//        func.setSalario(2000.0);
//        func.setDtContratacao(new Date());
//        func.setDepartamento(deptContab);
//        daoFunc.create(func);
//
//        deptContab.addFuncionario(func);
//        deptContab.setDescricao("Nova Contabilidade");
//        daoDept.update(deptContab);

        ConexaoFactory.close();
    }
}
