package mz.co.muianga.spring5recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created bt Nilvandro Muianga on 1/10/2020
 */
public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;
        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
        String descricao = "Pizzas";
        category.setDescription(descricao);

        assertEquals(category.getDescription(), descricao);
    }

    @Test
    public void getRecipes() {
    }
}