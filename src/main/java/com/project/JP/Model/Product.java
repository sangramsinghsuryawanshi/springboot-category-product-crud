package com.project.JP.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int p_id;
    private String p_name;
    private double p_price;
    private long qut;

    @ManyToOne()
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private Category Cat;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }

    public long getQut() {
        return qut;
    }

    public void setQut(long qut) {
        this.qut = qut;
    }

    public Category getCat() {
        return Cat;
    }

    public void setCat(Category cat) {
        this.Cat = cat;
    }

    public Product(int p_id, String p_name, double p_price, long qut, Category cat) {
        super();
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.qut = qut;
        this.Cat = cat;
    }

    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_price=" + p_price + ", qut=" + qut 
                + ", categoryId=" + (Cat != null ? Cat.getId() : "None") + "]";
    }
}
