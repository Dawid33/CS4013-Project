package ui;

import core.ReservationFormSaveExeception;

public interface OnSave<P> {
    void onSave(P value) throws ReservationFormSaveExeception;
}
