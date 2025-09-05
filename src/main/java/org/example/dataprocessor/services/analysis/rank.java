package org.example.dataprocessor.services.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rank implements analysis_stratigy {
    @Override
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) return Double.NaN;
        List<Integer> copy = new ArrayList<>(data);
        Collections.sort(copy);
        int n = copy.size();
        int rank = (int) Math.ceil(0.90 * n);
        int idx = Math.max(1, rank) - 1;
        return copy.get(idx);
    }
}
