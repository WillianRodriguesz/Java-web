package br.tche.ucpel.tads.doo2.persisty;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mertins
 */
@Entity
@Table(name = "jpa_funcionario")
public class Funcionario extends Pessoa {

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtContratacao;
    private Double salario;
    @ManyToOne
    @JoinColumn(name = "CODDEPARTAMENTO", referencedColumnName = "CODIGO")
    private Departamento departamento;

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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

}
