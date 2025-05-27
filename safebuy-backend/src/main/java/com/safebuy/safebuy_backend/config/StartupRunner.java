package com.safebuy.safebuy_backend.config;

import com.safebuy.safebuy_backend.entity.Categoria;
import com.safebuy.safebuy_backend.entity.DetalleCategoria;
import com.safebuy.safebuy_backend.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StartupRunner implements CommandLineRunner {
    private final CategoriaRepository categoriaRepository;

    public StartupRunner(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("✔ Insertando datos de prueba...");

        Categoria cat = new Categoria();
        cat.setId(UUID.fromString("4978cb64-7c65-4d71-87d6-2e94d3ec2e0c"));
        cat.setNombre("Tecnología");

        DetalleCategoria detalle = new DetalleCategoria();
        detalle.setDescripcionProducto("Productos electrónicos de consumo");
        detalle.setSubcategoria("Electrónica");

        cat.setDetalleCategoria(detalle);
        categoriaRepository.save(cat);

        System.out.println("✔ Categoría insertada con ID: " + cat.getId());
    }
}