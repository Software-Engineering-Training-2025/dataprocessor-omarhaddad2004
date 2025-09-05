package org.example.dataprocessor.services.cleaning;

import java.util.List;
import java.util.stream.Collectors;

public class replace_withzeros implements clean_stratigy {
    @Override
    public List<Integer> clean(List<Integer> data) {
        return data.stream().map(n -> n < 0 ? 0 : n).collect(Collectors.toList());
    }
}
