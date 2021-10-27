package ui.interfaces;

import core.exceptions.BookingFormSaveExeception;

public interface OnSave<P> {
    void onSave(P value) throws BookingFormSaveExeception;
}
