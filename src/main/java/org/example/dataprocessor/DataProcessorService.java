package org.example.dataprocessor;

import org.example.dataprocessor.enums.AnalysisType;
import org.example.dataprocessor.enums.CleaningType;
import org.example.dataprocessor.enums.OutputType;

// cleaning
import org.example.dataprocessor.services.cleaning.clean_stratigy;
import org.example.dataprocessor.services.cleaning.remove_negative;
import org.example.dataprocessor.services.cleaning.replace_withzeros;

// analysis
import org.example.dataprocessor.services.analysis.analysis_stratigy;
import org.example.dataprocessor.services.analysis.mean;
import org.example.dataprocessor.services.analysis.median;
import org.example.dataprocessor.services.analysis.stddev;
import org.example.dataprocessor.services.analysis.rank;          // P90
import org.example.dataprocessor.services.analysis.top3count;

// output
import org.example.dataprocessor.services.output.output_stratigy;
import org.example.dataprocessor.services.output.consol_out;
import org.example.dataprocessor.services.output.file_out;

import java.util.List;

public class DataProcessorService {

    /**
     * Implement this method.
     */
    public double process(
            CleaningType cleaningType,
            AnalysisType analysisType,
            OutputType outputType,
            List<Integer> data
    ) throws Exception {

        clean_stratigy cleaner = switch (cleaningType) {
            case REMOVE_NEGATIVES -> new remove_negative();
            case REPLACE_NEGATIVES_WITH_ZERO -> new replace_withzeros();
        };

        List<Integer> cleaned = cleaner.clean(data);

        analysis_stratigy analyzer = switch (analysisType) {
            case MEAN -> new mean();
            case MEDIAN -> new median();
            case STD_DEV -> new stddev();
            case P90_NEAREST_RANK -> new rank();
            case TOP3_FREQUENT_COUNT_SUM -> new top3count();
        };

        double result = analyzer.analyze(cleaned);

        output_stratigy out = switch (outputType) {
            case CONSOLE -> new consol_out();
            case TEXT_FILE -> new file_out();
        };

        out.output(result);
        return result;
    }
}
