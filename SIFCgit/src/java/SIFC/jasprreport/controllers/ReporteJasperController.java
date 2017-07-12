/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.jasprreport.controllers;
 
import DAO.PersonaFacadeLocal;
import Entities.Persona;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Ismael
 */
@Named(value = "ReporteJasperController")
@RequestScoped
public class ReporteJasperController {
    @EJB
    private PersonaFacadeLocal pfl;
    private List<Persona> personas;
    private JasperPrint jp;
    
    public ReporteJasperController() {
    }
    @PostConstruct
    public void init() {
        personas = pfl.findAll();
    }

    public List<Persona> getPersonas() {
        return personas;
    }
    
    private void prepararExport() throws JRException {
        Map<String, Object> params = new HashMap<>();
        params.put("UsuarioDelReporte", "Wilson Mora");
        JRBeanCollectionDataSource bcds = new JRBeanCollectionDataSource(personas);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/") + "/WEB-INF/reportes/jasper/Reporte1.jasper";
        jp = JasperFillManager.fillReport(reportPath, params, bcds);
    }
    public void exportarPDF() throws IOException, JRException {
        prepararExport();
        ServletOutputStream out = null;
        String contentType = "application/pdf";
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletResponse res = (HttpServletResponse) ec.getResponse();
        res.setContentType(contentType);
        res.addHeader("Content-disposition", "attachment; filename=\"reporte.pdf\"");
        out = res.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jp, out);
        fc.responseComplete();
    }

}
