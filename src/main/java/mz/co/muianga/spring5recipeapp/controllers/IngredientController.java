package mz.co.muianga.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import mz.co.muianga.spring5recipeapp.commands.IngredientCommand;
import mz.co.muianga.spring5recipeapp.commands.RecipeCommand;
import mz.co.muianga.spring5recipeapp.commands.UnitOfMeasureCommand;
import mz.co.muianga.spring5recipeapp.domain.Ingredient;
import mz.co.muianga.spring5recipeapp.domain.Recipe;
import mz.co.muianga.spring5recipeapp.domain.UnitOfMeasure;
import mz.co.muianga.spring5recipeapp.repositories.RecipeRepository;
import mz.co.muianga.spring5recipeapp.service.IngredientService;
import mz.co.muianga.spring5recipeapp.service.RecipeService;
import mz.co.muianga.spring5recipeapp.service.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created bt Nilvandro Muianga on 2/20/2020
 */
@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/new")
    public String newRecipe(@PathVariable String recipeId, Model model) {
        //make sure we have a good id valiue
        RecipeCommand recipeCommand = recipeService.findCOmmandById(Long.valueOf(recipeId));

        //todo raise exception if null
        //need to return back parent id for hidden form property
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);
        //init uom
        ingredientCommand.setUom(new UnitOfMeasureCommand());
        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());
        return "recipe/ingredient/ingredientform";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model) {
        log.debug("Getting Ingredient list for recipe id: " + recipeId);

        //Use command object to avoid lazy load errors in Thymeleaf
        model.addAttribute("recipe", recipeService.findCOmmandById(Long.valueOf(recipeId)));

        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,
                                         @PathVariable String id, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());
        return "recipe/ingredient/ingredientform";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));

        return "recipe/ingredient/show";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command) {
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved recipe id: " + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/delete")
    public String deleteById(@PathVariable String recipeId,
                             @PathVariable String id) {
        log.debug("deleting ingredient id: " + id);
        ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(id));

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
