package mz.co.muianga.spring5recipeapp.service;

import lombok.extern.slf4j.Slf4j;
import mz.co.muianga.spring5recipeapp.domain.Recipe;
import mz.co.muianga.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Nilvandro Muianga on 3/6/2020
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        Recipe recipe = recipeRepository.findById(recipeId).get();

        try {
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;
            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);
        } catch (IOException e) {

            //todo handle better
            log.error("Error occured", e);
            e.printStackTrace();
        }
        log.debug("Received a file");
    }
}
