package com.epam.rd.autotasks;


class CycleSwap {
    static void cycleSwap(int[] array) {
        while (array.length != 0) {
            int[] clone = new int[array.length];
            clone[0] = array[array.length-1];
            for (int i = 1, zero = 0; i < array.length; i++, zero++) {
                clone[i] = array[zero];
            }
            System.arraycopy(clone, 0, array, 0, array.length);
            break;
        }
    }

    static void cycleSwap(int[] array, int shift) {
        while (array.length != 0) {
            int[] clone = new int[array.length];
            for (int i = array.length-shift, zero = 0; i < array.length; i++, zero++) {
                clone[zero] = array[i];
            }
            for (int i = shift, plus = 0; i < array.length; i++, plus++) {
                clone[i] = array[plus];
            }
            System.arraycopy(clone, 0, array, 0, array.length);
            break;
        }
    }
}
