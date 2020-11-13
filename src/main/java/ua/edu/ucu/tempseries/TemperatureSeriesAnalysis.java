package ua.edu.ucu.tempseries;


import dynarr.DynDoubleArray;

import java.util.InputMismatchException;


public class TemperatureSeriesAnalysis {

    private DynDoubleArray temperatureSeries;
    private int minTemperature = -273;

    public TemperatureSeriesAnalysis() {
        temperatureSeries = new DynDoubleArray();
    }

    public TemperatureSeriesAnalysis(double[] tempSeries) {
        if (!checkInpArr(tempSeries)) {
            throw new InputMismatchException();
        }
        temperatureSeries = new DynDoubleArray(tempSeries);
    }

    private boolean checkInpArr(double[] inpArr) {
        for (int i = 0; i < inpArr.length; i++) {
            if (inpArr[i] < minTemperature) {
                return false;
            }
        }
        return true;
    }

    public double average() {
        if (temperatureSeries.len() == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < temperatureSeries.len(); i++) {
            sum += temperatureSeries.get(i) / temperatureSeries.len();
        }
        return sum;
    }

    public double deviation() {
        if (temperatureSeries.len() == 0) {
            throw new IllegalArgumentException();
        }
        double mean = average();
        double sum = 0;
        for (int i = 0; i < temperatureSeries.len(); i++) {
            sum += (temperatureSeries.get(i) - mean)
                    * (temperatureSeries.get(i) - mean)
                    / (temperatureSeries.len());
        }
        return Math.sqrt(sum);
    }

    public double min() {
        if (temperatureSeries.len() == 0) {
            throw new IllegalArgumentException();
        }
        return temperatureSeries.min();
    }

    public double max() {
        if (temperatureSeries.len() == 0) {
            throw new IllegalArgumentException();
        }
        return temperatureSeries.max();
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.len() == 0) {
            throw new IllegalArgumentException();
        }
        double closest = temperatureSeries.get(0);
        for (int i = 0; i < temperatureSeries.len(); i++) {
            if (Math.abs(tempValue - temperatureSeries.get(i))
                    < Math.abs(tempValue - closest)) {
                closest = temperatureSeries.get(i);
            } else if (Math.abs(temperatureSeries.get(i))
                    == Math.abs(closest)) {
                if ((tempValue - temperatureSeries.get(i)) < 0) {
                    closest = temperatureSeries.get(i);
                }
            }
        }
        return closest;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    private double[] findTempsThen(double tempValue, int sign) {
        if (temperatureSeries.len() == 0) {
            throw new IllegalArgumentException();
        }
        DynDoubleArray rezArr = new DynDoubleArray();
        for (int i = 0; i < temperatureSeries.len(); i++) {
            if (sign * temperatureSeries.get(i) > sign * tempValue) {
                rezArr.add(temperatureSeries.get(i));
            }
        }
        return rezArr.getData();
    }

    public double[] findTempsLessThen(double tempValue) {
        return findTempsThen(tempValue, -1);
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return findTempsThen(tempValue, 1);
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatureSeries.len() == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(this.average(), this.deviation(),
                this.min(), this.max());
    }

    public int addTemps(double[] temps) {
        if (!checkInpArr(temps)) {
            throw new InputMismatchException();
        }
        for (int i = 0; i < temps.length; i++) {
            temperatureSeries.add(temps[i]);
        }
        return temperatureSeries.len();
    }

    public double[] getTemps() {
        return temperatureSeries.getData();
    }
}
