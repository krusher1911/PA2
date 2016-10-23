package entity.entitys;

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import javax.persistence.*;

@Entity
@Table(name = "unidade_medida")
public class UnidadeMedida implements EntidadeBase {
    
    @Id
    @GeneratedValue
    @Column( name = "id_unidade")
    private Long id;
    
    @Column( name = "descricao", length = 100)
    private String descricao;
    
    @Column( name = "sigla", length = 5)
    private String sigla;

    public UnidadeMedida() {
    }

    public UnidadeMedida(String descricao, String sigla) {
        this.descricao = descricao;
        this.sigla = sigla;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }

}
