package mz.co.muianga.spring5recipeapp.service;

import mz.co.muianga.spring5recipeapp.commands.IngredientCommand;
import mz.co.muianga.spring5recipeapp.domain.Ingredient;

/**
 * Created by Nilvandro Muianga on 2/21/2020
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
