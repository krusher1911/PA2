package entity.entitys;

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import entity.enums.ModoCadastro;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "movimentacao")
public class Movimentacao implements EntidadeBase {

    @Id
    @Column(name = "id_movimentacao")
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @OneToOne
    @JoinColumn(name = "id_unidade")
    private UnidadeMedida unidade;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nota")
    private NotaFiscal notaFiscal;

    @Column(name = "valor_total")
    private Double total;

    @Column(name = "valor_unitario")
    private Double unitario;

    @Column(name = "valor_desconto")
    private Double desconto;

    @Column(name = "data_hora")
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "modo_insercao")
    private ModoCadastro modoCadastro;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Movimentacao() {
        this.dataCadastro = LocalDateTime.now();
    }

    public Movimentacao(Produto produto, Integer quantidade, UnidadeMedida unidade, NotaFiscal notaFiscal, Double total, Double unitario, Double desconto, ModoCadastro modoCadastro, Usuario usuario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.notaFiscal = notaFiscal;
        this.total = total;
        this.unitario = unitario;
        this.desconto = desconto;
        this.modoCadastro = modoCadastro;
        this.usuario = usuario;
        this.dataCadastro = LocalDateTime.now();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public UnidadeMedida getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeMedida unidade) {
        this.unidade = unidade;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getUnitario() {
        return unitario;
    }

    public void setUnitario(double unitario) {
        this.unitario = unitario;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public ModoCadastro getModoCadastro() {
        return modoCadastro;
    }

    public void setModoCadastro(ModoCadastro modoCadastro) {
        this.modoCadastro = modoCadastro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Movimentacao{" + "id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + ", unidade=" + unidade + ", nota_fiscal=" + notaFiscal + ", total=" + total + ", unitario=" + unitario + ", desconto=" + desconto + ", data_hora=" + dataCadastro + ", modo_insercao=" + modoCadastro + ", usuario=" + usuario + '}';
    }

}
