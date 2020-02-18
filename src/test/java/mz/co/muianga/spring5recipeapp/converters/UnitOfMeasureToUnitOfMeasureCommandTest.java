package mz.co.muianga.spring5recipeapp.converters;

import mz.co.muianga.spring5recipeapp.commands.UnitOfMeasureCommand;
import mz.co.muianga.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Created by Nilvandro Muianga on 2/18/2020
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

    UnitOfMeasureToUnitOfMeasureCommand converter;

    private static final String DESCRIPTION = "description";
    private static final Long ID = 1L;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter);
    }

    @Test
    public void convert() {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(DESCRIPTION);
        uom.setId(ID);

        UnitOfMeasureCommand command = converter.convert(uom);

        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(ID, command.getId());
    }
}