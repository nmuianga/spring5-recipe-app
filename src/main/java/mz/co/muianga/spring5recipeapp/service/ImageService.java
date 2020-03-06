package mz.co.muianga.spring5recipeapp.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Nilvandro Muianga on 3/6/2020
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
