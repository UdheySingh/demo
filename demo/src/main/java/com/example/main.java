package com.example;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class main {

  // Deserializzare xml
  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    File file = new File(" D:/udhey/scuola/5B-IA/TPSIT/LAB/demo");// si indica il percorso del file
    XmlMapper xmlMapper = new XmlMapper();
    root value = xmlMapper.readValue(file, root.class);// file per non scrivere tutti le linee di codice,root può
                                                       // variare in base al tag totale
    System.out.println("la classe " + value.getClasse() + " " + value.getSpecializzazione() + " si trova nell'aula " +
        value.getAula().getNome() + " ed è composta dai seguenti studenti:");// si fa la stampa

    for (int i = 0; i < value.getStudenti().size(); i++) {
      System.out.println("-" + value.getStudenti().get(i).getCognome());
    }
    whenJavaSerializedToXmlStr_thenCorrect();
    whenJavaSerializedToJsonStr_thenCorrect();

  }

  // Serializza xml
  public static void whenJavaSerializedToXmlStr_thenCorrect() throws JsonProcessingException {
    XmlMapper xmlMapper = new XmlMapper();
    String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new root());
    System.out.println(xml);
  }

  // Serializza Json
  public static void whenJavaSerializedToJsonStr_thenCorrect() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new root());
    System.out.println(json);
  }
}