package org.example.dataprocessor.services.analysis;

import java.util.List;

public class mean implements analysis_stratigy {
    @Override
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) return Double.NaN;
        double sum = 0;
        for (int x : data) sum += x;
        return sum / data.size();
    }
}
