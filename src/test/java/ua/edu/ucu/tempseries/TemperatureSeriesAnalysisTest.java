package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import dynArr.DynDoubleArray;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {

//    @Ignore
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

        TempSummaryStatistics tSummaryStatistics = seriesAnalysis.summaryStatistics();

    }

//    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.deviation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToValue(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testfindTempsLessThenWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsLessThen(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsGreaterThen(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.summaryStatistics();
    }



    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // average
        double avrg = seriesAnalysis.average();
        assertEquals(1, avrg, 0.00001);

        // deviation
        double dev = seriesAnalysis.deviation();
        assertEquals(3.74165, dev, 0.00001);

        // min
        double smallest = seriesAnalysis.min();
        assertEquals(-5.0, smallest, 0.00001);

        // max
        double largest = seriesAnalysis.max();
        assertEquals(5.0, largest, 0.00001);

        //  findTempClosestToZero
        double closestToZero = seriesAnalysis.findTempClosestToZero();
        assertEquals(1.0, closestToZero, 0.00001);

        //  findTempClosestToValue
        double closestToValue = seriesAnalysis.findTempClosestToValue(100);
        assertEquals(5.0, closestToValue, 0.00001);

        //  findTempsLessThen
        double[] smaller_arr = seriesAnalysis.findTempsLessThen(100);
        double[] correct_smaller_arr = new double[] {3.0, -5.0, 1.0, 5.0};
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
        int arr_len = seriesAnalysis.addTemps(new double[]{1});
        double[] updated_arr = seriesAnalysis.getTemps();
        double[] correct_updated_arr = new double[] {3.0, -5.0, 1.0, 5.0, 1};
        int correct_len = 5;
        assertEquals(arr_len, correct_len, 0.00001);
        for (int i=0; i < updated_arr.length; i++) {
            assertEquals(correct_updated_arr[i], updated_arr[i], 0.00001);
        }
    }


}
