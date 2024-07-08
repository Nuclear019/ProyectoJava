package com.example.demo.Services;

import com.example.demo.Model.Entities.Imagen;
import com.example.demo.Model.Entities.Jugador;
import com.example.demo.Model.Repositories.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Imagen getImageByJugador(Jugador jugador){
        Imagen imagen = imageRepository.findByIdJugador(jugador).orElse(null);
        return imagen;

    }

    public List<Imagen> getImages(){
        List<Imagen> imagenes = imageRepository.findAll();
        return imagenes;
    }
}
