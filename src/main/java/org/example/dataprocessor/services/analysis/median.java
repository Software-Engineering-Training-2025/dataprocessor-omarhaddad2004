package org.example.dataprocessor.services.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class median implements analysis_stratigy {
    @Override
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) return Double.NaN;
        List<Integer> copy = new ArrayList<>(data);
        Collections.sort(copy);
        int n = copy.size();
        if (n % 2 == 1) return copy.get(n / 2);
        return (copy.get(n/2 - 1) + copy.get(n/2)) / 2.0;
    }
}
