package mz.co.muianga.spring5recipeapp.converters;

import lombok.Synchronized;
import mz.co.muianga.spring5recipeapp.commands.IngredientCommand;
import mz.co.muianga.spring5recipeapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*
 * Created by Nilvandro Muianga on 2/10/2020
 */
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUnitOfMeasure()));

        return ingredientCommand;
    }
}
