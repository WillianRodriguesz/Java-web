package br.tche.ucpel.tads.doo2.persisty;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author mertins
 */
@Entity
@Table(name = "jpa_aluno")
public class Aluno extends Pessoa {

    private Long matricula;
    @ManyToMany
    private List<Disciplina> disciplinasMatriculadas=new ArrayList<Disciplina>();

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public void setDisciplinasMatriculadas(List<Disciplina> disciplinasMatriculadas) {
        this.disciplinasMatriculadas = disciplinasMatriculadas;
    }

    public void addDisciplina(Disciplina disciplina){
        this.disciplinasMatriculadas.add(disciplina);
    }

    public boolean removeDisciplina(Disciplina disciplina){
        return this.disciplinasMatriculadas.remove(disciplina);
    }

}
