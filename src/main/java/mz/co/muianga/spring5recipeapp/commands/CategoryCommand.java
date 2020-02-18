package mz.co.muianga.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Created by Nilvandro Muianga on 2/5/2020
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
}
