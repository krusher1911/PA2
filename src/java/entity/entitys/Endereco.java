package entity.entitys;

//poderia ser @Embedded

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import entity.enums.TipoLogadouro;
import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco implements EntidadeBase {
    
    @Id
    @Column(name = "id_endereco")
    @GeneratedValue
    private Long id;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name="tipo_logadouro")
    private TipoLogadouro tipo_logadouro;
    
    @Column(name="logadouro")
    private String logadouro;
    
    @Column(name="numero")
    //verificar no bd está varchar
    private int numero;
    
    @Column(name="complemento")
    private String complemento;
    
    @Column(name="bairro")
    private String bairro;
    
    @Column(name="cidade")
    private String cidade;
    
    @Column(name="estado")
    private char estado;

    public Endereco() {
    }

    public Endereco(TipoLogadouro tipo_logadouro, String logadouro, int numero, String complemento, String cidade, char estado) {
        this.tipo_logadouro = tipo_logadouro;
        this.logadouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoLogadouro getTipo_logadouro() {
        return tipo_logadouro;
    }

    public void setTipo_logadouro(TipoLogadouro tipo_logadouro) {
        this.tipo_logadouro = tipo_logadouro;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

}
