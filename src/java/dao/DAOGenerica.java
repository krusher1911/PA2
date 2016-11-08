package dao;

import entity.EntidadeBase;
import java.util.List;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruna
 */
public class DAOGenerica<T extends EntidadeBase> {

    private Session sessao = HibernateUtil.getSession();

    public void save(T t) {
        Transaction transacao = sessao.beginTransaction();
        sessao.save(t);
        transacao.commit();
    }

    public void update(T t) {
        Transaction transacao = sessao.beginTransaction();
        sessao.update(t);
        transacao.commit();
    }

    public void delete(Class<T> classe, Long id) throws NotFoundException {
        T entity = buscarPorId(classe, id);
        if (entity != null) {
            Transaction transacao = sessao.beginTransaction();
            sessao.delete(entity);
            transacao.commit();
        } else {
            String msg = "Objeto com o id " + id + " da classe " + classe + " não foi encontrado!";
            throw new NotFoundException(msg);
        }
    }

    public void closeSession() {
        HibernateUtil.closeSession(sessao);
    }

    //Listar uma entidade
    public <T extends EntidadeBase> List<T> buscarTudo(Class<T> classe) {
        return sessao.createCriteria(classe).list();
    }

    //Listar uma entidade em ordem ASC ou DESC ordenando por uma ou varias propriedades.
    public <T extends EntidadeBase> List<T> buscarTudo(Class<T> classe, Ordem ordem, String... ordemPropriedades) {
        Criteria criteria = sessao.createCriteria(classe);

        for (String ordemPropriedade : ordemPropriedades) {
            if (ordem.isOrdemASC()) {
                criteria.addOrder(org.hibernate.criterion.Order.asc(ordemPropriedade));
            } else {
                criteria.addOrder(org.hibernate.criterion.Order.desc(ordemPropriedade));
            }
        }
        return criteria.list();
    }

    //Encontrar uma entidade pelo seu id
    public <T extends EntidadeBase> T buscarPorId(Class<T> classe, Long id) {
        return (T) sessao.get(classe, id);
    }
    
    
    public <T extends EntidadeBase> List<T> buscarPorPropriedade(Class<T> classe, String nomesPropriedades, Object valores) {
        try{
            Criteria criteria = sessao.createCriteria(classe);
            criteria.add(Restrictions.eq(nomesPropriedades, valores));
            return criteria.list();
        } catch (Exception e){
            return null;
        }

    }

    //Encontrar entidades por uma ou mais de suas propriedades
    public <T extends EntidadeBase> List<T> buscarPorPropriedade(Class<T> classe, String[] nomesPropriedades, Object[] valores) throws NotFoundException {
        if (nomesPropriedades.length == valores.length) {
            Criteria criteria = sessao.createCriteria(classe);
            for (int i = 0; i < nomesPropriedades.length && i < valores.length; i++) {
                criteria.add(Restrictions.eq(nomesPropriedades[i], valores[i]));
            }
            return criteria.list();
        } else {
            throw new NotFoundException("A quantidade de propriedades tem que igual a quantidade de valores!");
        }
    }

    //Encontra entidades por uma propriedade String especificando um MatchMode. Esta busca é case insensitive
    public <T extends EntidadeBase> List<T> buscarPorPropriedade(Class<T> classe, String nomePropriedade, String valor, MatchMode matchMode) {
        if (matchMode != null) {
            return sessao.createCriteria(classe).add(Restrictions.ilike(nomePropriedade, valor, matchMode)).list();
        } else {
            return sessao.createCriteria(classe).add(Restrictions.ilike(nomePropriedade, valor, MatchMode.EXACT)).list();
        }
    }

}
