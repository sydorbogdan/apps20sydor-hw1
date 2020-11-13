package dynArr;

import java.util.Arrays;

public class DynDoubleArray {
    private int capacity;
    private int size; //last index
    private double[] data;

    public DynDoubleArray(){
        data = new double[]{0};
        capacity = 1;
        size = -1;
    }

    public DynDoubleArray(double[] inp_data){
        data = inp_data;
        capacity = inp_data.length;
        size = inp_data.length-1;
    }

    public void add(double inp_elem){
        if (capacity == size+1){
            data = Arrays.copyOf(data, 2*capacity);
            capacity *= 2;
        }
        data[size+1] = inp_elem;
        size += 1;
    }

    public int len(){
        return size + 1;
    }

    public double get(int ind)
    {
        if (-1 < ind && ind < size + 1) {
            return data[ind];
        } else{
            throw new IndexOutOfBoundsException();
        }

    }


    public double min()
    {
        double curr_min = data[0];
        for (int i=0; i < size+1; i++){
            if (curr_min > data[i]) {
                curr_min = data[i];
            }
        }
        return curr_min;
    }

    public double max()
    {
        double curr_max = data[0];
        for (int i=0; i < size+1; i++){
            if (curr_max < data[i]) {
                curr_max = data[i];
            }
        }
        return curr_max;
    }

    public double[] getData() {
        double[] slice = new double[size+1];
        for (int i=0; i < size+1; i++){
            slice[i] = data[i];
        }
        return slice;
    }
}
