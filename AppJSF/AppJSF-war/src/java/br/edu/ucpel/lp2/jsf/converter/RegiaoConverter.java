package br.edu.ucpel.lp2.jsf.converter;

import br.edu.ucpel.lp2.jpa.Regiao;
import br.edu.ucpel.lp2.jsf.mng.RegiaoMNG;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "regiaoConverter")
public class RegiaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueExpression vExp = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{regiaoMNG}", RegiaoMNG.class);
        RegiaoMNG regiaoMNG = (RegiaoMNG) vExp.getValue(ctx.getELContext());
        Regiao regiao = regiaoMNG.getRegiao(Long.valueOf(value));
        if (regiao == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor desconhecido", "Região não foi encontrada");
            throw new ConverterException(msg);
        }
        return regiao;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "0";
        } else {
            return ((Regiao) value).getCodigo().toString();
        }
    }
}
