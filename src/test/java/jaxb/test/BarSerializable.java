package jaxb.test;

import java.io.Serializable;

public class BarSerializable implements Serializable{
    public String tete;

    public BarSerializable(String tete) {
        this.tete = tete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BarSerializable that = (BarSerializable) o;

        return !(tete != null ? !tete.equals(that.tete) : that.tete != null);

    }

    @Override
    public int hashCode() {
        return tete != null ? tete.hashCode() : 0;
    }
}