package dao;

/**
 *
 * @author Bruna
 */
public enum Ordem {

    ASC,
    DESC;

    public boolean isOrdemASC() {
        return ASC.equals(this);
    }


}
