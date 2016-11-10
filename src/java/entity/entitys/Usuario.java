package entity.entitys;

import entity.EntidadeBase;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements EntidadeBase, Serializable {
	
    @Id @GeneratedValue
    @Column(name = "id_usuario")
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "usuario")
    private String login;
    
    @Column(name = "senha")
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
