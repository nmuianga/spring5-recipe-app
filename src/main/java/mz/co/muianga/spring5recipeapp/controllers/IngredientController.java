package mz.co.muianga.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import mz.co.muianga.spring5recipeapp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created bt Nilvandro Muianga on 2/20/2020
 */
@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model) {
        log.debug("Getting Ingredient list for recipe id: " + recipeId);

        //Use command object to avoid lazy load errors in Thymeleaf
        model.addAttribute("recipe", recipeService.findCOmmandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }
}
