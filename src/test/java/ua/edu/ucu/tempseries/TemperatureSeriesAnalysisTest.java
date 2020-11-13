package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import dynArr.DynDoubleArray;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // average
        double avrg = seriesAnalysis.average();
        assertEquals(-1.0, avrg, 0.00001);

        // deviation
        double dev = seriesAnalysis.deviation();
        assertEquals(0, dev, 0.00001);

        // min
        double smallest = seriesAnalysis.min();
        assertEquals(-1.0, smallest, 0.00001);

        // max
        double largest = seriesAnalysis.max();
        assertEquals(-1.0, largest, 0.00001);

        //  findTempClosestToZero
        double closestToZero = seriesAnalysis.findTempClosestToZero();
        assertEquals(-1.0, closestToZero, 0.00001);

        //  findTempClosestToValue
        double closestToValue = seriesAnalysis.findTempClosestToValue(100);
        assertEquals(-1.0, closestToValue, 0.00001);

        //  findTempsLessThen
        double[] smaller_arr = seriesAnalysis.findTempsLessThen(100);
        double[] correct_smaller_arr = new double[] {-1.0};
        assertEquals(correct_smaller_arr.length, smaller_arr.length, 0.00001);
        for (int i=0; i < correct_smaller_arr.length; i++) {
            assertEquals(correct_smaller_arr[i], smaller_arr[i], 0.00001);
        }

        // findTempsGreaterThen
        double[] larger_arr = seriesAnalysis.findTempsGreaterThen(100);
        double[] correct_greater_arr = new double[] {};
        assertEquals(correct_greater_arr.length, larger_arr.length, 0.00001);
        for (int i=0; i < correct_greater_arr.length; i++) {
            assertEquals(correct_greater_arr[i], larger_arr[i], 0.00001);
        }

        //  addTemps
        int arr_len = seriesAnalysis.addTemps(new double[]{1, 34, 646, -100});
        double[] updated_arr = seriesAnalysis.getTemps();
        double[] correct_updated_arr = new double[] {-1, 1, 34, 646, -100};
        int correct_len = 5;
        assertEquals(arr_len, correct_len, 0.00001);
        for (int i=0; i < updated_arr.length; i++) {
            assertEquals(correct_updated_arr[i], updated_arr[i], 0.00001);
        }

    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Ignore
    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }


}
