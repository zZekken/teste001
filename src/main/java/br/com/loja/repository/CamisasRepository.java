/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.repository;

import br.com.loja.model.Camisas;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author breno
 */
public interface CamisasRepository extends CrudRepository<Camisas,Long>{
    
}
