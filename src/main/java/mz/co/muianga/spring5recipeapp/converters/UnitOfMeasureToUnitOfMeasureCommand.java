package mz.co.muianga.spring5recipeapp.converters;

import lombok.Synchronized;
import mz.co.muianga.spring5recipeapp.commands.UnitOfMeasureCommand;
import mz.co.muianga.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*
 * Created by Nilvandro Muianga on 2/10/2020
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure != null) {
            final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
            unitOfMeasureCommand.setId(unitOfMeasure.getId());
            unitOfMeasureCommand.setDescription(unitOfMeasure.getDescription());

            return unitOfMeasureCommand;
        }
        return null;
    }
}
