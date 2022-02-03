package ru.appline.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WorkWithArray {
    private static final List<Element> elementList = new ArrayList<>();

    public void start() {
        int[] values = fillArray();
        System.out.println("Массив до изменений " + Arrays.toString(values));
        System.out.println("Максимальное значение = " + findMaxElement().getValue() + ", позиция " + findMaxElement().getIndex());
        System.out.println("Минимальное значение = " + findMinElement().getValue() + ", позиция " + findMinElement().getIndex());
        System.out.println("Массив после изменений " + Arrays.toString(getResultArray(values)));
    }

    private int[] fillArray() {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            int value = (int) ((Math.random() * 20) - 10);
            array[i] = value;
            elementList.add(new Element(i, value));
        }
        return array;
    }

    private Element findMaxElement() {
        return elementList
                .stream()
                .max(Comparator.comparingInt(Element::getValue))
                .get();
    }

    private Element findMinElement() {
        return elementList
                .stream()
                .min(Comparator.comparingInt(Element::getValue))
                .get();
    }

    private int[] getResultArray(int[] array) {
        array[findMaxElement().getIndex()] = findMinElement().getValue();
        array[findMinElement().getIndex()] = findMaxElement().getValue();
        return array;
    }
}
