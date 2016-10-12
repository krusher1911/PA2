package entity.entitys;

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import javax.persistence.*;

@Entity
@Table(name = "permissao")
public class Permissao implements EntidadeBase {
    
    @Id
    @Column(name = "id_permissao")
    @GeneratedValue
    private Long id;

    @Column(name = "descricao", length = 200)
    private String descricao;

    public Permissao() {
    }

    public Permissao(String descricao) {
        this.descricao = descricao;
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
	
        
}
