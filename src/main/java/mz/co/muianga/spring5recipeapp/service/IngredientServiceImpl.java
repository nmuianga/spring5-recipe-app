package mz.co.muianga.spring5recipeapp.service;

import lombok.extern.slf4j.Slf4j;
import mz.co.muianga.spring5recipeapp.commands.IngredientCommand;
import mz.co.muianga.spring5recipeapp.converters.IngredientToIngredientCommand;
import mz.co.muianga.spring5recipeapp.domain.Recipe;
import mz.co.muianga.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Nilvandro Muianga on 2/21/2020
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            log.error("Recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
                .findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            log.error("Ingredient is not found. Id: " + ingredientId);
        }
        return ingredientCommandOptional.get();
    }
}
