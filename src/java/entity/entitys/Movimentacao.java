package entity.entitys;

import entity.EntidadeBase;
import entity.enums.ModoCadastro;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "movimentacao")
public class Movimentacao implements EntidadeBase {

    @Id
    @Column(name = "id_movimentacao")
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade")
    private int quantidade;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_unidade")
    private UnidadeMedida unidade;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_nota")
    private NotaFiscal notaFiscal;

    @Column(name = "valor_total")
    private double total;

    @Column(name = "valor_unitario")
    private double unitario;

    @Column(name = "valor_desconto")
    private double desconto;

    @Column(name = "data_hora")
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "modo_insercao")
    private ModoCadastro modoCadastro;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Movimentacao() {
        this.dataCadastro = LocalDateTime.now();
    }

    public Movimentacao(Produto produto, int quantidade, UnidadeMedida unidade, NotaFiscal notaFiscal, double total, double unitario, double desconto, ModoCadastro modoCadastro, Usuario usuario) {
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
