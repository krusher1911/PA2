package entity.entitys;

//importações para o Hibernate e JPA
import entity.EntidadeBase;
import entity.enums.ModoCadastro;
import entity.enums.TipoEntidade;
import javax.persistence.*;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Entidade implements EntidadeBase {
    
    @Column(name="razao_social", length=100)
    private String razaoSocial;
    
    @Column(name="nome_fantasia", length=100)
    private String nomeFantasia;
            
    @Column(name="cnpj")
    private Long cnpj;

    public Fornecedor(){
        
    }
    
    public Fornecedor(String razaoSocial, Long cnpj, String nomeFantasia, String apelido, Endereco endereco, ModoCadastro modoCadastro, Usuario usuario) {
        super(TipoEntidade.JURIDICA, apelido, endereco, modoCadastro, usuario);
        this.razaoSocial = razaoSocial;
       this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
   }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

}
