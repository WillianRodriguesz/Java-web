package br.edu.ucpel.lp2.jsf.mng;

import br.edu.ucpel.lp2.dao.RegiaoDAOLocal;
import br.edu.ucpel.lp2.jpa.Regiao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.validation.constraints.Pattern;

/**
 * Managed Bean para Região.
 */
@Named(value = "regiaoMNG")
@RequestScoped
public class RegiaoMNG {

    @EJB
    private RegiaoDAOLocal dao;
    
    private String codigo;
    
    @Pattern(regexp = "(.+)", message = "{invalid.regiao.pais}")
    private String pais;

    @Pattern(regexp = "(.+)", message = "{invalid.regiao.estado}")
    private String estado;

    @Pattern(regexp = "(.+)", message = "{invalid.regiao.cidade}")
    private String cidade;

    /**
     * Cria uma nova instância de RegiaoMNG.
     */
    public RegiaoMNG() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Regiao getRegiao(Long cod) {
        Regiao regiao = new Regiao();
        regiao.setCodigo(cod);
        return dao.retrieve(regiao);
    }

    public List<Regiao> getLista() {
        return dao.listaTodos();
    }

    public List<SelectItem> getListaSelectItem() {
        List<SelectItem> lista = new ArrayList<SelectItem>();
        lista.add(new SelectItem(null, ""));
        for (Regiao regiao : dao.listaTodos()) {
            lista.add(new SelectItem(regiao, regiao.getPais() + " - " + regiao.getEstado() + " - " + regiao.getCidade()));
        }
        return lista;
    }

    public void clear(AjaxBehaviorEvent event) {
        this.codigo = null;
        this.pais = null;
        this.estado = null;
        this.cidade = null;
    }

    public String save() {
        Regiao regiao = new Regiao();
        regiao.setPais(pais);
        regiao.setEstado(estado);
        regiao.setCidade(cidade);
        dao.create(regiao);
        return "regiaoList";
    }

    public void remove() {
        Long index = Long.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codExcluir").toString());
        Regiao regiao = new Regiao();
        regiao.setCodigo(index);
        dao.delete(regiao);
        this.clear(null);
    }

    public String prepUpdate() {
        Long index = Long.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codEditar").toString());
        Regiao regiao = new Regiao();
        regiao.setCodigo(index);
        regiao = dao.retrieve(regiao);
        this.codigo = regiao.getCodigo().toString();
        this.pais = regiao.getPais();
        this.estado = regiao.getEstado();
        this.cidade = regiao.getCidade();
        return "regiaoUpdate";
    }

    public String update() {
        Regiao regiao = new Regiao();
        //regiao.setCodigo(Long.valueOf(codigo));
        regiao.setPais(pais);
        regiao.setEstado(estado);
        regiao.setCidade(cidade);
        dao.update(regiao);
        return "regiaoList";
    }
}
