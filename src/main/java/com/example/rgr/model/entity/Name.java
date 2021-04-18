package com.example.rgr.model.entity;

import org.springframework.util.StringUtils;

import java.text.Collator;
import java.text.Normalizer;
import java.util.Objects;

public class Name implements Comparable<Name>  {

    private String name;
    private Integer count = 1;

    public Name(){
    }

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = StringUtils.hasText(name) ? NoAccent.removeAccent(name.toUpperCase().trim()) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int compareTo(Name o) {
        return Collator.getInstance().compare(name, o);
    }
}

class NoAccent {
    public static String removeAccent(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
