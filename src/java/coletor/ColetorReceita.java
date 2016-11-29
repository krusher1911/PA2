package coletor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.servlet.http.Cookie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/**
 *
 * @author Gustavo
 */
public class ColetorReceita {

    private Document doc;
    private Cookie cookie_session;

    public ColetorReceita() {
    }

    public Cookie getCookie_session() {
        return cookie_session;
    }
   
    /**
     *
     * @param args
     */
    public void rodar() {
        String receitaURL = coletar_pagina("http://www.nfe.fazenda.gov.br/portal/consulta.aspx?tipoConsulta=completa&tipoConteudo=XbSeqxE8pl8=");

        doc = Jsoup.parse(receitaURL, "UTF-8", Parser.xmlParser());
    }

    public String getElementoPorID(String id) {
        Elements element = doc.select(id);

        return element.toString();
    }

 
    public String coletar_pagina(String str_url) {
        StringBuilder pagina = new StringBuilder();
        try {
            //Estabelecendo a conexão.

            CookieManager cookieManager = new CookieManager();
            CookieHandler.setDefault(cookieManager);

            URL url = new URL(str_url);
            URLConnection url_connection = url.openConnection();
            url_connection.getContent();

            CookieStore cookieStore = cookieManager.getCookieStore();

            List cookieList = cookieStore.getCookies();
            String[] cookie = cookieList.toString().split("[=]");            
            
            cookie_session = new Cookie(cookie[0].substring(1), 
                                        cookie[1].substring(0,cookie[1].length()-1));
            
            InputStreamReader reader = new InputStreamReader(url_connection.getInputStream());
            BufferedReader buffer = new BufferedReader(reader);

            //Lendo o texto da página.
            String linha;
            while ((linha = buffer.readLine()) != null) {
                pagina.append(linha);
            }

        } catch (Exception e) {
            
        }
        return pagina.toString();
    }

}
