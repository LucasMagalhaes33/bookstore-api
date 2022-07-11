package com.lucas.bookstore.service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.repositories.CategoriaRepository;
import com.lucas.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){
        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficção científica", "Livros de Ficção científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografia");

        Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem Ipsum", cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis Gersther", "Lorem Ipsum", cat2);
        Livro l3 = new Livro(null, "The time machine", "H.G. Wells", "Lorem Ipsum", cat2);
        Livro l4 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem Ipsum", cat3);

        cat1.getLivros().addAll(Arrays.asList(l1));
        cat2.getLivros().addAll(Arrays.asList(l2, l3));
        cat3.getLivros().addAll(Arrays.asList(l4));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
    }
}
