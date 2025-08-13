package br.com.fiap.spring.mvc.controller;

import br.com.fiap.spring.mvc.entity.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @GetMapping("/lista")
    public String listarLivros(Model model) {
        Livro livro1 = new Livro();
        Livro livro2 = new Livro();
        Livro livro3 = new Livro();
        livro1.setTitulo("Livro 1");
        livro2.setTitulo("Livro 2");
        livro3.setTitulo("Livro 3");
        livro1.setId((long) 1);
        livro2.setId((long) 2);
        livro3.setId((long) 3);

        List<Livro> livros = List.of(livro1, livro2, livro3);
        model.addAttribute("listaLivros", livros);

        return "livroLista";
    }
}
