package entity.entitys;

import entity.EntidadeBase;
import java.time.LocalDateTime;
import javax.persistence.*;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name="registo")
public class Log implements EntidadeBase {

    @Id
    @Column(name = "id_registro")
    @GeneratedValue	
    private Long id;
    
    @Column(name = "data")
    private LocalDateTime data_hora;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "tabela", length=20)
    private String  tabela;
    
    @Column(name = "campo", length=20)
    private String coluna;
    
    @Column(name = "valor_antigo", length = 200)
    private String valor_antigo;
    
    @Column(name = "valor_atual", length = 200)
    private String valor_novo;
    
    public Log(){
        
    }

    public Log(Usuario usuario, String tabela, String coluna, String valor_antigo, String valor_novo){
        this.data_hora = LocalDateTime.now();
        this.usuario = usuario;
        this.tabela = tabela;
        this.coluna = coluna;
        this.valor_antigo = valor_antigo;
        this.valor_novo = valor_novo;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getValor_antigo() {
        return valor_antigo;
    }

    public void setValor_antigo(String valor_antigo) {
        this.valor_antigo = valor_antigo;
    }

    public String getValor_novo() {
        return valor_novo;
    }

    public void setValor_novo(String valor_novo) {
        this.valor_novo = valor_novo;
    }
    
}
