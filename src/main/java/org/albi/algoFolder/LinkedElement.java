package org.albi.algoFolder;

import java.util.Objects;

public class LinkedElement {
    private final int value;
    private int prevElement;
    private int nextElement;
    private final int [] elements;

    LinkedElement(int value, int[] providedElements) {
        this.elements = providedElements;
        this.value = value;
    }

    int getValue() {
        return value;
    }
    void removeElement(int value){

    }
    private void setPrevElement(){

    }
}
