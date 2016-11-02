package entity.entitys;

import entity.EntidadeBase;
import entity.enums.ModoCadastro;
import entity.enums.Natureza;
import entity.enums.TipoNota;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements EntidadeBase {
    
    @Id
    @GeneratedValue
    @Column(name = "id_nota")
    private Long id;
    
    @Column(name = "chave")
    private String chave;
    
    @Column(name = "data_emissao")
    private Date emissao;
    
    @Column(name = "valor_nota")
    private double valorTotal;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_envolvido")
    private Entidade entidade;
    
    @Column(name = "numero")
    private Long numero;
    
    @Column(name = "serie")
    private int serie;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoNota tipo; //Indica se a NotaFiscal e de Entrada ou Saida.
    
    @Enumerated(EnumType.STRING)
    @Column(name = "natureza")
    private Natureza natureza; //Indica se � Venda/Bonifica��o/Devolu��o
    
    @OneToMany(mappedBy = "id", targetEntity = NotaFiscal.class, fetch = FetchType.LAZY)
    private List<Movimentacao> itens;
    
    @Column(name="data_hora")
    private LocalDateTime dataCadastro;
    
    @Enumerated(EnumType.STRING)
    @Column(name="modo_insercao")
    private ModoCadastro modoCadastro;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
            
    public NotaFiscal() {
    }

    public NotaFiscal(String chave, Date emissao, double valorTotal, Entidade entidade, Long numero, int serie, TipoNota tipo, Natureza natureza, List<Movimentacao> itens, ModoCadastro modoCadastro, Usuario usuario) {

        this.chave = chave;
        this.emissao = emissao;
        this.valorTotal = valorTotal;
        this.entidade = entidade;
        this.numero = numero;
        this.serie = serie;
        this.tipo = tipo;
        this.natureza = natureza;
        this.itens = itens;
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

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public TipoNota getTipo() {
        return tipo;
    }

    public void setTipo(TipoNota tipo) {
        this.tipo = tipo;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public List<Movimentacao> getItens() {
        return itens;
    }

    public void setItens(List<Movimentacao> itens) {
        this.itens = itens;
    }

    public void setNatureza(Natureza natureza) {
        this.natureza = natureza;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
