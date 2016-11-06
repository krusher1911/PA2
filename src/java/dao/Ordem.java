package dao;

public enum Ordem {

    ASC,
    DESC;

    public boolean isOrdemASC() {
        return ASC.equals(this);
    }
}
