package com.megayasa.Frontend.View.Asset.datechooser;

public interface SelectedAction {

    public final int DAY_SELECTED = 1;
    public final int MONTH_SELECTED = 2;
    public final int YEAR_SELECTED = 3;

    public int getAction();
}
