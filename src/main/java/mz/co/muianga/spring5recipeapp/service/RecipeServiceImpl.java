package mz.co.muianga.spring5recipeapp.service;

import lombok.extern.slf4j.Slf4j;
import mz.co.muianga.spring5recipeapp.commands.RecipeCommand;
import mz.co.muianga.spring5recipeapp.converters.RecipeCommandToRecipe;
import mz.co.muianga.spring5recipeapp.converters.RecipeToRecipeCommand;
import mz.co.muianga.spring5recipeapp.domain.Recipe;
import mz.co.muianga.spring5recipeapp.exception.NotFoundException;
import mz.co.muianga.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/*
 * Created by Nilvandro Muianga on 1/7/2020
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            //throw new RuntimeException("Recipe Not Found");
            throw new NotFoundException("Recipe Not Found for ID Value: " + id.toString());
        }

        return recipeOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public RecipeCommand findCOmmandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand save(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved Recipe ID:  " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
