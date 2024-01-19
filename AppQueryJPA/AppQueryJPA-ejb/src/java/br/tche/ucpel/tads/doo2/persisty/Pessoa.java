package br.tche.ucpel.tads.doo2.persisty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mertins
 */
@Entity
@Table(name = "jpa_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seqGerPessoa", sequenceName = "SEQGERPESSOAJPA", allocationSize = 1)
@NamedQueries({
    @NamedQuery(name = "pessoa.findAll", query = "select p from Pessoa p"),
    @NamedQuery(name = "pessoa.findAllAtivo", query = "select o from Pessoa o where o.ativo=true order by o.id"),
    @NamedQuery(name = "pessoa.findPartNome", query = "select o from Pessoa o where upper(o.nome) like :partNome order by o.nome")
})
public class Pessoa implements Serializable {
    public enum Sexo { MASCULINO, FEMININO}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqGerPessoa")
    private Long id;
    @Column(nullable = false, length = 500)
    private String nome;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;
    @Column(nullable = false)
    private boolean ativo = true;
    @Column(unique=true)
    private String cpf;
    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;

    public Pessoa() {
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }
}
