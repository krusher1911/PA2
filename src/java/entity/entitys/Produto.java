package entity.entitys;

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto implements EntidadeBase {

    @Id
    @GeneratedValue
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @OneToOne
    @JoinColumn(name = "id_unidade")
    private UnidadeMedida unidade;

    @Column(name = "permite_fracionamento")
    private boolean permiteFracionar;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "codigo_ncm")
    private int codigNcm;

    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(name = "valor_minimo")
    private Double valorMinimo;

    @Column(name = "valor_maximo")
    private Double valorMaximo;

    @Column(name = "link")
    private String link;

    public Produto() {
    }

    public Produto(String descricao, UnidadeMedida unidade, boolean permiteFracionar, String tipo, int codigoNcm, Categoria categoria) {
        this.descricao = descricao;
        this.unidade = unidade;
        this.permiteFracionar = permiteFracionar;
        this.tipo = tipo;
        this.codigNcm = codigoNcm;
        this.categoria = categoria;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public UnidadeMedida getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeMedida unidade) {
        this.unidade = unidade;
    }

    public boolean isPermiteFracionar() {
        return permiteFracionar;
    }

    public void setPermiteFracionar(boolean permiteFracionar) {
        this.permiteFracionar = permiteFracionar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigNcm() {
        return codigNcm;
    }

    public void setCodigNcm(int codigNcm) {
        this.codigNcm = codigNcm;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
