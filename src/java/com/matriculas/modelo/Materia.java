/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matriculas.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro Rios
 */
@Entity
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByCodigo", query = "SELECT m FROM Materia m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Materia.findByNombre", query = "SELECT m FROM Materia m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Materia.findByCreditos", query = "SELECT m FROM Materia m WHERE m.creditos = :creditos")})


public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "codigo",length=7,nullable=false)
    private Integer codigo;
    @Basic(optional = false)
  
    @Column(name = "nombre",length=40,nullable=false)
    private String nombre;
    @Basic(optional = false)
   
    @Column(name = "creditos",length=1,nullable=false)
    private int creditos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Collection<Matricula> matriculaCollection;

    public Materia() {
    }

    public Materia(Integer codigo) {
        this.codigo = codigo;
    }

    public Materia(Integer codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @XmlTransient
    public Collection<Matricula> getMatriculaCollection() {
        return matriculaCollection;
    }

    public void setMatriculaCollection(Collection<Matricula> matriculaCollection) {
        this.matriculaCollection = matriculaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matriculas.modelo.Materia[ codigo=" + codigo + " ]";
    }
    
}
