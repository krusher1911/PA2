package servlet;

import coletor.ColetorReceita;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Receita", urlPatterns = {"/Receita"})
public class ServletGetReceita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        response.setContentType("text/html;charset=UTF-8");
    
        ColetorReceita coletor2 = new ColetorReceita();
        coletor2.rodar();
        
        response.addCookie(coletor2.getCookie_session());
        String btnConsultar =coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_btnConsultar");
        String btnLimpar = coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_btnLimpar");
        String imagemCaptcha = coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_imgCaptcha");
        String chaveCompleta = coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_txtChaveAcessoCompleta");
        String chaveCaptcha = coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_txtCaptcha");
        chaveCompleta = chaveCompleta.replace("class=\"txtChaveAcesso\"", "class=\"form-control\" placeholder=\"Chave de Acesso da NF-e\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Chave de Acesso da NF-e\"");
        chaveCaptcha = chaveCaptcha.replace("class=\"txtCaptcha\"", "class=\"form-control\" placeholder=\"Captcha\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Captcha\"");
        
        String viewstate = coletor2.getElementoPorID("[name=__VIEWSTATE]");
        String viewstatgen = coletor2.getElementoPorID("[name=__VIEWSTATEGENERATOR]");
        String eventval = coletor2.getElementoPorID("[name=__EVENTVALIDATION]");
        String contenttoken = coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_token");
        String contentcapsom = coletor2.getElementoPorID("#ctl00_ContentPlaceHolder1_captchaSom");

        btnConsultar = btnConsultar.replace("class=\"botao\"", "class=\"btn btn-primary\" ");
        btnLimpar = btnLimpar.replace("class=\"botao\"", "class=\"btn btn-default\" ");
        btnLimpar = btnLimpar.replace("type=\"submit\"", "type=\"reset\" ");

        String captcha = ""
                + "<form class=\"form-horizontal\" name=\"form_coletor\" action=\"posteceita\" method=\"POST\">"
                + "       <div class=\"form-group\">"
                + "<center>" + imagemCaptcha + "</center>"
                + "       </div>"
                + "       <div class=\"form-group\">"
                + "           <label class=\"col-lg-4 control-label\" for=\"ctl00_ContentPlaceHolder1_txtCaptcha\">Captcha</label>"
                + "           <div class=\"col-lg-8\">"
                + chaveCaptcha
                + "           </div>"
                + "       </div>"
                + "       <div class=\"form-group\">"
                + "           <label class=\"col-lg-4 control-label\" for=\"ctl00_ContentPlaceHolder1_txtChaveAcessoCompleta\">Chave de Acesso</label>"
                + "           <div class=\"col-lg-8\">"
                + chaveCompleta
                + "           </div>"
                + "       </div>"
                + "       <div class=\"form-group\">"
                + "           <div class=\"col-lg-6\">"
                + "<center>" + btnLimpar + "</center>"
                + "           </div>"
                + "           <div class=\"col-lg-6\">"
                + "<center>" + btnConsultar + "</center>"
                + "           </div>"
                + "       </div>"
                + "</from>"
                +                        viewstate +
                        viewstatgen+
                        eventval+
                        contenttoken+
                        contentcapsom ;
        
        map.put("capt", captcha);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
