package org.example.dataprocessor.services.analysis;

import java.util.List;

public class stddev implements analysis_stratigy {
    @Override
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) return Double.NaN;
        double mean = 0;
        for (int x : data) mean += x;
        mean /= data.size();

        double s2 = 0;
        for (int x : data) {
            double d = x - mean;
            s2 += d * d;
        }
        return Math.sqrt(s2 / data.size());
    }
}
