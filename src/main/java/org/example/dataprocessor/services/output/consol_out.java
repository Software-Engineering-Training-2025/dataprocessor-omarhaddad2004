package org.example.dataprocessor.services.output;

public class consol_out implements output_stratigy {
    @Override
    public void output(double value) {
        System.out.println("Result = " + value);
    }
}
