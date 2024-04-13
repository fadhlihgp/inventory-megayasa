package com.megayasa.Backend.Context.Interfaces;

import com.megayasa.Backend.Exceptions.ErrorException;

public interface TransactionHandler {
    void execute() throws ErrorException;
}
