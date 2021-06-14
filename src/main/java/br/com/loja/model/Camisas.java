/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author breno
 */
@Entity
public class Camisas implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idCamisas;
    private String nome;

    public long getIdCamisas() {
        return idCamisas;
    }

    public void setIdCamisas(long idCamisas) {
        this.idCamisas = idCamisas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}