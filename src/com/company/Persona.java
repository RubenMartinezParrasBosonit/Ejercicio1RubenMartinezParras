package com.company;

import java.io.InvalidClassException;
import java.util.Arrays;
import java.util.Optional;

public class Persona {
  private String nombre;
  private String poblacion;
  private String edad;

  public Persona(String nombre, String poblacion, String edad) {
    this.setNombre(nombre);
    this.setPoblacion(poblacion);
    this.setEdad(edad);
  }

  public Persona() {
    this.setNombre("Nombre");
    this.setPoblacion("Poblacion");
    this.setEdad("-1");
  }

  public Persona(String[] persona) {

    /*try {
        if(persona[0] != null){
            this.setNombre(persona[0]);
        }else{
            this.setNombre("Desconocido");
        }
    }catch(IndexOutOfBoundsException e){
        this.setNombre("Desconocida");
    }

    try {
        if(persona[1] != ""){
            this.setPoblacion(persona[1]);
        }else{
            this.setPoblacion("Desconocida");
        }
    }catch(IndexOutOfBoundsException e){
        this.setPoblacion("Desconocida");
    }

    try {
        if (persona[2] != null) {
            try{
                this.setEdad(persona[2]);
            }catch(IndexOutOfBoundsException e){
                this.setEdad("-1");
            }

        } else {
            this.setEdad("-1");
        }
    }catch(IndexOutOfBoundsException e){
        this.setEdad("-1");
    }*/

    Optional<String> optName;
    Optional<String> optPoblacion;
    Optional<String> optEdad;

    try{
      optName = Optional.of(persona[0]);
    }catch(IndexOutOfBoundsException e){
      optName = Optional.of("Desconocido");
    }

    try{
      optPoblacion = Optional.of(persona[1]);
    } catch (IndexOutOfBoundsException e){
      optPoblacion = Optional.of("Desconocida");
    }

    try {
      optEdad = Optional.of(persona[2]);
    } catch (IndexOutOfBoundsException e) {
      optEdad = Optional.of("-1");
    }

    this.setNombre(optName.get());
    this.setPoblacion(optPoblacion.orElse("Desconocida"));
    this.setEdad(optEdad.get());
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPoblacion() {
    return poblacion;
  }

  public void setPoblacion(String poblacion) {
    this.poblacion = poblacion;
  }

  public String getEdad() {
    return edad;
  }

  public int getEdadInt() {
    return Integer.valueOf(edad);
  }

  public void setEdad(String edad) {
    this.edad = edad;
  }

  @Override
  public String toString() {
    return ("Nombre: " + this.nombre + ", Población: " + this.poblacion + ", Edad: " + this.edad);
  }
}
