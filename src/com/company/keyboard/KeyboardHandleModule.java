package com.company.keyboard;

public class KeyboardHandleModule {
    /**
     * Считывание последних данных из стека событий, если можулю это необходимо
     */
    void update();

    /**
     * @return Возвращает направление последней нажатой "стрелочки",
     * либо AWAITING, если не было нажато ни одной
     */
    ru.tproger.game2048.main.Direction lastDirectionKeyPressed();

    /**
     * @return Возвращает информацию о том, был ли нажат ESCAPE за последнюю итерацию
     */
    boolean wasEscPressed();
}
