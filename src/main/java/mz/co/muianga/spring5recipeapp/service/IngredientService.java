package mz.co.muianga.spring5recipeapp.service;

import mz.co.muianga.spring5recipeapp.commands.IngredientCommand;

/**
 * Created by Nilvandro Muianga on 2/21/2020
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdIngredientId(Long recipeId, Long ingredientId);
}
