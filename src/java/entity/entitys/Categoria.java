package entity.entitys;

import entity.EntidadeBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "categoria")
public class Categoria implements EntidadeBase {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="descricao", length=100)
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
