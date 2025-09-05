package org.example.dataprocessor.services.cleaning;

import java.util.List;
import java.util.stream.Collectors;

public class remove_negative implements clean_stratigy
{
    @Override
    public List<Integer> clean(List<Integer> data) {
        return data.stream().filter(n -> n >= 0).collect(Collectors.toList());
    }
}
