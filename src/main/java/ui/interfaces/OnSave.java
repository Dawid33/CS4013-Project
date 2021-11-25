package ui.interfaces;

import booking_system.BookingFormSaveExeception;

public interface OnSave<P> {
    void onSave(P value) throws BookingFormSaveExeception;
}
