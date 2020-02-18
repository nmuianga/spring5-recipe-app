package mz.co.muianga.spring5recipeapp.converters;

import lombok.Synchronized;
import mz.co.muianga.spring5recipeapp.commands.RecipeCommand;
import mz.co.muianga.spring5recipeapp.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*
 * Created by Nilvandro Muianga on 2/10/2020
 */
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final NotesCommandToNotes notesCommandToNotes;
    private final IngredientCommandToIngredient ingredientConverter;
    private final CategoryCommandToCategory categoryConverter;

    public RecipeCommandToRecipe(NotesCommandToNotes notesCommandToNotes,
                                 IngredientCommandToIngredient ingredientConverter, CategoryCommandToCategory categoryConverter) {

        this.notesCommandToNotes = notesCommandToNotes;
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {

        if (recipeCommand == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotes()));

        if (recipeCommand.getCategories() != null && recipeCommand.getCategories().size() > 0) {
            recipeCommand.getCategories()
                    .forEach(category ->
                            recipe .getCategories().add(categoryConverter.convert(category)));
        }

        if (recipeCommand.getIngredients() != null && recipeCommand.getIngredients().size() > 0) {
            recipeCommand.getIngredients()
                    .forEach(ingredient ->
                            recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
