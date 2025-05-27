package com.safebuy.safebuy_backend;

import com.safebuy.safebuy_backend.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCategoriaRepo implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    public TestCategoriaRepo(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("✅ Repositorio encontrado: " + (categoriaRepository != null));
    }
}