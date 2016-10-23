package entity.entitys;

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import entity.enums.ModoCadastro;
import entity.enums.TipoEntidade;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "entidade")
@Inheritance (strategy = InheritanceType.JOINED)
public class Entidade implements EntidadeBase {

    @Id
    @Column(name = "id_entidade")
    @GeneratedValue
    private Long id;
        
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_entidade")
    private TipoEntidade tipo;

    @Column(name="apelido", length=100)
    private String apelido;
    
    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    
    @Column(name="data_hora")
    private LocalDateTime dataCadastro;
    
    @Enumerated(EnumType.STRING)
    @Column(name="modo_insercao")
    private ModoCadastro modoCadastro;
    
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    
    public Entidade() {
    }

    public Entidade(TipoEntidade tipo, String apelido, Endereco endereco, ModoCadastro modoInsercao, Usuario usuario) {
        this.tipo = tipo;
        this.apelido = apelido;
        this.endereco = endereco;
        this.dataCadastro = LocalDateTime.now();
        this.modoCadastro = modoInsercao;
        this.usuario = usuario;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEntidade getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntidade tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
