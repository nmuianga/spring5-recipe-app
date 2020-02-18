package mz.co.muianga.spring5recipeapp.converters;

import lombok.Synchronized;
import mz.co.muianga.spring5recipeapp.commands.UnitOfMeasureCommand;
import mz.co.muianga.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*
 * Created by Nilvandro Muianga on 2/5/2020
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
