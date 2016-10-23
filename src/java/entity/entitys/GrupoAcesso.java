package entity.entitys;

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "grupo_acesso")
public class GrupoAcesso implements EntidadeBase {

    @Id
    @Column(name = "id_grupo")
    @GeneratedValue
    private Long id;

    @Column(name = "nome", length = 20)
    private String nome;

    @OneToMany
    @JoinTable(name = "grupo_acesso_permissao",
            joinColumns = {
                @JoinColumn(name = "id_grupo",
                        referencedColumnName = "id_grupo")},
            inverseJoinColumns = {
                @JoinColumn(name = "id_permissao",
                        referencedColumnName = "id_permissao")})
    private List<Permissao> permissoes;

    public GrupoAcesso() {
    }

    public GrupoAcesso(String nome, List<Permissao> permissoes) {
        this.nome = nome;
        for (Permissao p : permissoes) {
            permissoes.add(p);
        }
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

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

}
