package mz.co.muianga.spring5recipeapp.converters;

import lombok.Synchronized;
import mz.co.muianga.spring5recipeapp.commands.NotesCommand;
import mz.co.muianga.spring5recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/*
 * Created by Nilvandro Muianga on 2/10/2020
 */
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Notes notes) {
        if (notes == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(notes.getId());
        notesCommand.setRecipeNotes(notes.getRecipeNotes());

        return notesCommand;
    }
}
