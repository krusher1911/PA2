package dao;

import entity.EntidadeBase;
import java.util.List;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruna
 */
public class DAOGenerica<T extends EntidadeBase> {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    public boolean save(T t) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    public boolean update(T t) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    public boolean delete(Class<T> classe, Long id) throws NotFoundException {
        Session session = sf.openSession();
        try {
            T entity = buscarPorId(classe, id);
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    //Listar uma entidade
    public <T extends EntidadeBase> List<T> buscarTudo(Class<T> classe) {
        Session session = sf.openSession();
        List<T> lista = session.createCriteria(classe).list();
        session.close();
        return lista;
    }

    //Listar uma entidade em ordem ASC ou DESC ordenando por uma ou varias propriedades.
    public <T extends EntidadeBase> List<T> buscarTudo(Class<T> classe, Ordem ordem, String... ordemPropriedades) {
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(classe);

        for (String ordemPropriedade : ordemPropriedades) {
            if (ordem.isOrdemASC()) {
                criteria.addOrder(org.hibernate.criterion.Order.asc(ordemPropriedade));
            } else {
                criteria.addOrder(org.hibernate.criterion.Order.desc(ordemPropriedade));
            }
        }
        List<T> lista = criteria.list();
        session.close();
        return lista;
    }

    //Encontrar uma entidade pelo seu id
    public <T extends EntidadeBase> T buscarPorId(Class<T> classe, Long id) {
        Session session = sf.openSession();
        try {
            T obj = (T) session.get(classe, id);
            session.close();
            return obj;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }
    
    
    public <T extends EntidadeBase> List<T> buscarPorPropriedade(Class<T> classe, String nomesPropriedades, Object valores) {
        Session session = sf.openSession();
        try {
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq(nomesPropriedades, valores));
            List<T> lista = criteria.list();
            session.close();
            return lista;
        } catch (Exception e) {
            session.close();
            return null;
        }

    }

    //Encontrar entidades por uma ou mais de suas propriedades
    public <T extends EntidadeBase> List<T> buscarPorPropriedade(Class<T> classe, String[] nomesPropriedades, Object[] valores) throws NotFoundException {
        if (nomesPropriedades.length == valores.length) {
            Session session = sf.openSession();
            try {
                Criteria criteria = session.createCriteria(classe);
                for (int i = 0; i < nomesPropriedades.length && i < valores.length; i++) {
                    criteria.add(Restrictions.eq(nomesPropriedades[i], valores[i]));
                }
                List<T> lista = criteria.list();
                session.close();
                return lista;
            } catch (Exception e) {
                session.close();
                return null;
            }
        } else {
            throw new NotFoundException("A quantidade de propriedades tem que igual a quantidade de valores!");
        }
    }

    //Encontra entidades por uma propriedade String especificando um MatchMode. Esta busca é case insensitive
    public <T extends EntidadeBase> List<T> buscarPorPropriedade(Class<T> classe, String nomePropriedade, String valor, MatchMode matchMode) {
        Session session = sf.openSession();
        try {
            List<T> lista;
            if (matchMode != null) {
                lista = session.createCriteria(classe).add(Restrictions.ilike(nomePropriedade, valor, matchMode)).list();
                session.close();
                return lista;
            } else {
                lista = session.createCriteria(classe).add(Restrictions.ilike(nomePropriedade, valor, MatchMode.EXACT)).list();
            }
            session.close();
            return lista;
        } catch (Exception e) {
            session.close();
            return null;
        }

    }
}
