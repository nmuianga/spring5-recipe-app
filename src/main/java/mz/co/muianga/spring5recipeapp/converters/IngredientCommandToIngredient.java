package mz.co.muianga.spring5recipeapp.converters;

import lombok.Synchronized;
import mz.co.muianga.spring5recipeapp.commands.IngredientCommand;
import mz.co.muianga.spring5recipeapp.domain.Ingredient;
import mz.co.muianga.spring5recipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;

/*
 * Created by Nilvandro Muianga on 2/10/2020
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());

        if (source.getRecipeId() != null) {
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUnitOfMeasure(uomConverter.convert(source.getUom()));

        return ingredient;
    }
}
