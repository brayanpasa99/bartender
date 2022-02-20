package com.bartender.bartender.models;

import javax.persistence.*;

@Entity
@Table(name = "arrays")
public class GlassArray {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "input_array", nullable = false)
    private String input_array;

    public GlassArray() { }

    public GlassArray(String input_array) {
        this.input_array = input_array;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput_array() {
        return input_array;
    }

    public void setInput_array(String input_array) {
        this.input_array = input_array;
    }

    @Override
    public String toString() {
        return "GlassArray{" +
                "id=" + id +
                ", input_array='" + input_array + '\'' +
                '}';
    }
}
