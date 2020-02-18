package mz.co.muianga.spring5recipeapp.converters;

import lombok.Synchronized;
import mz.co.muianga.spring5recipeapp.commands.NotesCommand;
import mz.co.muianga.spring5recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/*
 * Created by Nilvandro Muianga on 2/10/2020
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand notesCommand) {
        if (notesCommand == null) {
            return null;
        }

        final Notes notes = new Notes();
        notes.setId(notesCommand.getId());
        notes.setRecipeNotes(notesCommand.getRecipeNotes());

        return notes;
    }
}
