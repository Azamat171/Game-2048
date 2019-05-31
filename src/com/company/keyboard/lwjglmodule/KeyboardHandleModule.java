package com.company.keyboard.lwjglmodule;


import org.lwjgl.input.Keyboard;
import com.company.keyboard.KeyboardHandleModule;
import com.company.main.Direction;

public class KeyboardHandleModule implements KeyboardHandleModule {
    /* Данные о вводе за последнюю итераци. */
    private boolean wasEscPressed;
    private Direction lastDirectionKeyPressed;

    /**
     * Считывание последних данных из стека событий
     */
    @Override
    public void update() {
        resetValues();
        lastDirectionKeyPressed = Direction.AWAITING;

        while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                switch(Keyboard.getEventKey()){
                    case Keyboard.KEY_ESCAPE:
                        wasEscPressed = true;
                        break;
                    case Keyboard.KEY_UP:
                        lastDirectionKeyPressed = Direction.UP;
                        break;
                    case Keyboard.KEY_RIGHT:
                        lastDirectionKeyPressed = Direction.RIGHT;
                        break;
                    case Keyboard.KEY_DOWN:
                        lastDirectionKeyPressed = Direction.DOWN;
                        break;
                    case Keyboard.KEY_LEFT:
                        lastDirectionKeyPressed = Direction.LEFT;
                        break;
                }
            }
        }
    }

    /**
     * Обнуление данных, полученых в при предыдущих запросах
     */
    private void resetValues() {
        lastDirectionKeyPressed = Direction.AWAITING;
        wasEscPressed = false;
    }

    /**
     * @return Возвращает направление последней нажатой "стрелочки",
     * либо AWAITING, если не было нажато ни одной
     */
    @Override
    public Direction lastDirectionKeyPressed() {
        return lastDirectionKeyPressed;
    }

    /**
     * @return Возвращает информацию о том, был ли нажат ESCAPE за последнюю итерацию
     */
    @Override
    public boolean wasEscPressed() {
        return wasEscPressed;
    }


}
