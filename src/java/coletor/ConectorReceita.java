package coletor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.Cookie;

public class ConectorReceita {

    private final String USER_AGENT = "Mozilla/5.0";

    // HTTP POST request
    public String sendPost(Cookie cookie, String[] parametros, String[] nomes_parametros) throws Exception {

        String url = "http://www.nfe.fazenda.gov.br/portal/consulta.aspx?tipoConsulta=completa&tipoConteudo=XbSeqxE8pl8=";
        URL obj = new URL(url);
        URLConnection con = obj.openConnection();
        
        
        
        String urlParameters = nomes_parametros[0] + "=" + parametros[0];
        
        for (int i = 1; i < parametros.length; i++) {
            urlParameters = urlParameters + "&" + URLEncoder.encode(nomes_parametros[i], "UTF-8") + "=" +  URLEncoder.encode(parametros[i], "UTF-8");
        }
        
         
        //add reuqest header
        //con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        //con.setRequestProperty("Cookie", cookie.getName());
        System.out.println("cookie name: \"" + cookie.getName() + "\"");

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        //int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
        //print result

    }



}
