package com.safebuy.safebuy_backend.config;

import com.safebuy.safebuy_backend.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    public StartupRunner(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("✔ Repositorio cargado: " + (categoriaRepository != null));
    }
}
