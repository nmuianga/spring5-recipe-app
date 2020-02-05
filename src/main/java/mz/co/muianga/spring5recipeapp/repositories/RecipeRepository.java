package mz.co.muianga.spring5recipeapp.repositories;

import mz.co.muianga.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
