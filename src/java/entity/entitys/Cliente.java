package entity.entitys;

//importações para o Hibernate e JPA
// classes cliente e fornecedor podem ser tanto PF quanto PJ!
import entity.EntidadeBase;
import entity.enums.ModoCadastro;
import entity.enums.TipoEntidade;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends Entidade implements EntidadeBase {
    
    @Column(name="nome", length=100)
    private String nome;
    
    @Column(name="cpf")
    //coluna no bd com letra maiscula - se mudar aqui mudar fornecedor tbm
    private Long cpf;
    
    public Cliente() {
    }

    public Cliente(String nome, Long cpf, String apelido, Endereco endereco, ModoCadastro modoCadastro, Usuario usuario) {
       this.nome = nome;
       this.cpf = cpf;
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((getId() == null && other.getId() != null) || (getId() != null && !getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
    
}
