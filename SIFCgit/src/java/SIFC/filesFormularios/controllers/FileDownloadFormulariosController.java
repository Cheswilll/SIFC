/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIFC.filesFormularios.controllers;

import SIFC.files.controllers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ismael
 */
@Named(value = "fileDownloadFormulariosController")
@ViewScoped
public class FileDownloadFormulariosController implements Serializable {

    /**
     * Creates a new instance of FileDownloadController
     */
    public FileDownloadFormulariosController() {
    }

    public void download() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        OutputStream out = null;
        try {
            if (!fc.getResponseComplete()) {
                File file = new File("C:\\Users\\Cheswill\\Desktop\\PROYECTOOOOOOOOOOOOOOO\\SIFC\\build\\web\\files\\uploads\\file.pdf");
                FileInputStream fis = new FileInputStream(file);
                byte[] bytes = new byte[1024];
                int read = 0;
                String fileName = file.getName();
                String contentType = "application/pdf";
                long contentLength = file.length();
                System.out.println(ec.getMimeType(fileName));
                ec.responseReset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
                ec.setResponseContentType(contentType); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ExternalContext#getMimeType() for auto-detection based on filename.
                ec.setResponseContentLength((int)contentLength); // Set it with the file size. This header is optional. It will work if it's omitted, but the download progress will be unknown.
                ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\""); // The Save As popup magic is done here. You can give it any file name you want, this only won't work in MSIE, it will use current request URL as file name instead.
                out = ec.getResponseOutputStream();
                /*
                HttpServletResponse response = (HttpServletResponse) ec.getResponse();
                response.setContentType(contentType);
                response.setHeader("Content-Disposition",
                        "attachment;filename=\"" + fileName + "\"");
                out = response.getOutputStream();
                */
                while ((read = fis.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                out.flush();
                out.close();
                System.out.println("\nDescargado\n");
                fc.addMessage(null, new FacesMessage("Se va a descargar el archivo " + fileName));
                fc.responseComplete();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDownloadFormulariosController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(out != null)
                    out.close();
            } catch (IOException ex) {
                Logger.getLogger(FileDownloadFormulariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
