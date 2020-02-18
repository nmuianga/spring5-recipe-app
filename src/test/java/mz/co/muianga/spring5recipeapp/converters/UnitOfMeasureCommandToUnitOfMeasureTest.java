package mz.co.muianga.spring5recipeapp.converters;

import mz.co.muianga.spring5recipeapp.commands.UnitOfMeasureCommand;
import mz.co.muianga.spring5recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Created by Nilvandro Muianga on 2/18/2020
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {

    UnitOfMeasureCommandToUnitOfMeasure converter;

    private static final String DESCRIPTION = "description";
    private static final Long ID = 1L;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter);
    }

    @Test
    public void convert() {
        //Given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setDescription(DESCRIPTION);
        command.setId(ID);

        //When
        UnitOfMeasure uom = converter.convert(command);

        //Then
        assertEquals(uom.getId(), ID);
        assertEquals(uom.getDescription(), DESCRIPTION);
    }
}