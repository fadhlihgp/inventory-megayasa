package com.megayasa.Backend.Context;

import com.megayasa.Backend.Context.Interfaces.Persistence;
import com.megayasa.Backend.Context.Interfaces.TransactionHandler;
import com.megayasa.Backend.Exceptions.ErrorException;

public class TransactionUtil {
    private static final AppDbContext context = new AppDbContext();
    private static final Persistence persistence = new DbPersistence(context.getConnection());
    public static void performTransaction(TransactionHandler handler) {
        try {
            persistence.beginTransaction();
            handler.execute();
            persistence.commit();
        } catch (Exception e) {
            persistence.rollback();
            throw new ErrorException(e.getMessage());
        }
    }
}
