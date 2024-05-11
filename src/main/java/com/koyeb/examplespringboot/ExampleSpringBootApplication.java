package com.koyeb.examplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExampleSpringBootApplication {
  public static void main(String[] args) {
    SpringApplication.run(ExampleSpringBootApplication.class, args);
  }

  @GetMapping("/")
  public String hello(@RequestParam(value = "name", required = false) String name) {
    // Determinar el nombre a mostrar
    String displayName = name != null ? name : "¿Cómo vas?";

    // Construir la respuesta HTML
    return "<html>" +
        "<head>" +
        "<style>" +
        "body { height: 100vh; margin: 0; display: flex; flex-direction: column; align-items: center; justify-content: center; font-family: Arial, sans-serif; }"
        +
        "form { display: flex; flex-direction: column; align-items: center; gap: 10px; }" +
        "input[type='text'], button { padding: 15px; font-size: 16px; }" +
        "#logo { position: absolute; top: 20px; right: 20px; cursor: pointer; }" +
        "</style>" +
        "<script>" +
        "function showInfo() {" +
        "  alert('VISITA comovas.es');" +
        "}" +
        "</script>" +
        "</head>" +
        "<body>" +
        // Logo
        "<img id='logo' src='https://web.comovas.es/comovas.svg' alt='Comovas' width='100' height='100' onclick='showInfo()' />" +
        // Saludo personalizado
        "<h1>¡Hola " + displayName + "!</h1>" +
        // Formulario para cambiar el nombre
        "<form action='/' method='get'>" + // Usando método GET para simplificar
        "<input type='text' name='name' placeholder='Introduce Nombre'/>" +
        "<button type='submit'>OK</button>" +
        "</form>" +
        "</body>" +
        "</html>";
  }
}
