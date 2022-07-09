package com.example.demo.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ksiazki")
public class Ksiazka {
    public Ksiazka(){}
    public Ksiazka(String nazwa, String wydawnictwo, float cena){
        this.nazwa = nazwa;
        this.wydawnictwo = wydawnictwo;
        this.cena = cena;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nazwa")
    private String nazwa;
    @Column(name="autor")
    private String autor;

    @Column(name="wydawnictwo")
    private String wydawnictwo;

    @Column(name="cena")
    private float cena;

    public String getNazwa(){
        return nazwa;
    }
    public String getWydawnictwo(){
        return wydawnictwo;
    }
    public float getCena(){
        return cena;
    }
    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }
    public void setAutor(String autor) {this.autor = autor;}
    public String getAutor(){ return autor; }
    public void setWydawnictwo(String wydawnictwo){
        this.wydawnictwo = wydawnictwo;
    }
    public void setCena(float cena){
        this.cena = cena;
    }
    public int getId() { return id; }
    @Override
    public String toString(){
        return "Ksiazka{" +
                "id="+id+
                ", nazwa="+nazwa+'\''+
                ", wydawnictwo="+wydawnictwo+'\''+
                ", cena="+cena+
                '}';
    }
}
