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
    @Column(name="tipopessoa_entidade")
    private TipoEntidade tipoPessoa;
    
    @Column(name="nome", length=100)
    private String nome;
    
    @Column(name="nome_fantasia", length=100)
    private String nomeFantasia;
    
    @Column(name="cnpjCpf")
    private Long cnpjCpf;

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

    public Entidade(TipoEntidade tipoPessoa, String nome, String nomeFantasia, Long cnpjCpf, String apelido, Endereco endereco, LocalDateTime dataCadastro, ModoCadastro modoCadastro, Usuario usuario) {
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.nomeFantasia = nomeFantasia;
        this.cnpjCpf = cnpjCpf;
        this.apelido = apelido;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
        this.modoCadastro = modoCadastro;
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
        return tipoPessoa;
    }

    public void setTipo(TipoEntidade tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Long getCpfCnpj() {
        return cnpjCpf;
    }

    public void setCpfCnpj(Long cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ModoCadastro getModoCadastro() {
        return modoCadastro;
    }

    public void setModoCadastro(ModoCadastro modoCadastro) {
        this.modoCadastro = modoCadastro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
