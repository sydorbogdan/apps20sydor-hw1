package dynarr;

import java.util.Arrays;
import java.util.InputMismatchException;

public class DynDoubleArray {
    private int capacity;
    private int size; //last index
    private double[] data;

    public DynDoubleArray() {
        data = new double[]{0};
        capacity = 1;
        size = -1;
    }

    public DynDoubleArray(double[] inpData) {
        data = inpData;
        capacity = inpData.length;
        size = inpData.length - 1;
    }

    public void add(double inpElem) {
        if (capacity == size + 1) {
            data = Arrays.copyOf(data, 2 * capacity);
            capacity *= 2;
        }
        data[size + 1] = inpElem;
        size += 1;
    }

    public int len() {
        return size + 1;
    }

    public double get(int ind) {
        if (-1 < ind && ind < size + 1) {
            return data[ind];
        } else {
            throw new IndexOutOfBoundsException();
        }

    }


    public double min() {
        double currMin = data[0];
        for (int i = 0; i < size + 1; i++) {
            if (currMin > data[i]) {
                currMin = data[i];
            }
        }
        return currMin;
    }

    public double max() {
        double currMax = data[0];
        for (int i = 0; i < size + 1; i++) {
            if (currMax < data[i]) {
                currMax = data[i];
            }
        }
        return currMax;
    }

    public double[] getData() {
        double[] slice = new double[size + 1];
        for (int i = 0; i < size + 1; i++) {
            slice[i] = data[i];
        }
        return slice;
    }
}
