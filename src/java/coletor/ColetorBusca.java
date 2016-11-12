/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package coletor;

import dao.DAOGenerica;
import entity.entitys.Produto;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Queue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Bruna
 */
public class ColetorBusca {

    Queue url = new LinkedList();
    String texto = new String();
    Produto produto;

    public ColetorBusca() {
    }

    public void setFilaUrls(Queue filaurls) {
        this.url = filaurls;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void coletar() {
        try {
            String url_pagina = (String) this.url.poll();
            url_pagina = url_pagina.concat(URLEncoder.encode(produto.getDescricao(), "UTF-8"));
            produto.setLink(url_pagina);
            this.procurarValores(url_pagina);
        } catch (Exception e) {
            System.out.println("Erro ao coletar páginas!");
            e.printStackTrace();
        }
    }

    private void procurarValores(String url) {
        try {
            Document doc = Jsoup.parse(new URL(url).openStream(), "utf-8", url);

            String menor = doc.select("article:lt(1) > div:eq(4) > p:eq(0) > a > span > strong").text();
            String maior = doc.select("article:lt(1) > div:eq(4) >  p:eq(1) > a > span").text();

            Double minimo = Double.parseDouble(menor.substring(3).replace(".", "").replace(",", "."));
            Double maximo = Double.parseDouble(maior.substring(3).replace(".", "").replace(",", "."));

            produto.setValorMinimo(minimo);
            produto.setValorMaximo(maximo);
            atualizarProduto();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarProduto() {
        DAOGenerica dao = new DAOGenerica();
        dao.update(produto);;
    }

}
