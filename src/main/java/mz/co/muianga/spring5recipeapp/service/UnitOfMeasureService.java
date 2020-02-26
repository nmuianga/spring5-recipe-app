package mz.co.muianga.spring5recipeapp.service;

import mz.co.muianga.spring5recipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

/**
 * Created by Nilvandro Muianga on 2/25/2020
 */
public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
