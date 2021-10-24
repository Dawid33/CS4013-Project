package ui.interfaces;

import core.exceptions.ReservationFormSaveExeception;

public interface OnSave<P> {
    void onSave(P value) throws ReservationFormSaveExeception;
}
