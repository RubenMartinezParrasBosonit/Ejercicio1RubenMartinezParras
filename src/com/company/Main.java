package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {

    File doc =
        new File(
            "C:\\Users\\ruben.mparras\\IdeaProjects\\Ejercicio1RubenMartinezParras\\personas.txt");

    BufferedReader obj = new BufferedReader(new FileReader(doc));
    List<Persona> personas = new ArrayList();
    String strng = new String();
    String[] splitText = new String[2];
    while ((strng = obj.readLine()) != null) {
      splitText = strng.split(":");
      personas.add(new Persona(splitText));
      Arrays.fill(splitText, null);
    }

    personas.stream()
        .filter(persona -> persona.getEdadInt() < 25)
        .forEach(
            (p) -> {
              System.out.println(p.toString());
            });

    // Si queremos meter a las personas filtradas en una lista, se haría así.
    /*List<Persona> personaFiltro = personas.stream().filter(persona -> persona.getEdadInt() < 25).collect(Collectors.toList());

    personaFiltro.stream().forEach((p)-> {
        System.out.println(p.getNombre());
        System.out.println(p.getPoblacion());
        System.out.println(p.getEdad());
    });*/

  }
}
