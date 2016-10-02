package coletor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/**
 *
 * @author Gustavo
 */
public class ColetorReceita {

    public Document doc;

    public ColetorReceita() {
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
            
            InputStreamReader reader = new InputStreamReader(url_connection.getInputStream());
            BufferedReader buffer = new BufferedReader(reader);

            //Lendo o texto da página.
            String linha;
            while ((linha = buffer.readLine()) != null) {
                pagina.append(linha);
            }

        } catch (Exception e) {
            System.out.println("Erro: não foi possível coletar a página: " + str_url + "!");
        }
        return pagina.toString();
    }

}
