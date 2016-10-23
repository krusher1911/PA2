
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Teste_gustavo {

    public static void main(String[] args) throws FileNotFoundException {
        String content = new Scanner(new File("H:\\Servlet ServletPostReceita.html")).useDelimiter("\\Z").next();

        ParseNfe teste = new ParseNfe(content);
        teste.rodar();
    }
}
