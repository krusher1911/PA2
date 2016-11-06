
import coletor.ParseNfe;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Teste_gustavo {

    public static void main(String[] args) throws FileNotFoundException {
        String content = new Scanner(new File("C:\\Servlet ServletPostReceita2.html")).useDelimiter("\\Z").next();
        
        System.out.println(content.substring(0, 10));
        ParseNfe teste = new ParseNfe(content);
        teste.rodar();
    }
}
