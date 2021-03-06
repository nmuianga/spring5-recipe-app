package mz.co.muianga.spring5recipeapp.service;

import mz.co.muianga.spring5recipeapp.commands.RecipeCommand;
import mz.co.muianga.spring5recipeapp.domain.Recipe;

import java.util.Set;

/*
 * Created by Nilvandro Muianga on 1/7/2020
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand findCOmmandById(Long id);

    RecipeCommand save(RecipeCommand command);

    void deleteById(Long id);
}
