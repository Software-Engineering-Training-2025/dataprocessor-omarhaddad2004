package org.example.dataprocessor.services.analysis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class top3count implements analysis_stratigy {
    @Override
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) return 0.0;

        return data.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))//هون  اخذت الرقم وعديت كم مرة تكرر

                .entrySet().stream()//حولتها لأنتري ستريم بتصير كي فاليو بتريحني بالتعامل
                .sorted((a, b) -> {//هون بعمل مقارنة بس بالفاليو بينهم الي هو عدد التكرارات عشان ارتبها
                    int cmp = b.getValue().compareTo(a.getValue());
                    return cmp != 0 ? cmp : a.getKey().compareTo(b.getKey());//هون برتب تصاعدي
                })
                .limit(3)//لأنه المطلوب اعلى 3 بس حطينا ليمت
                .mapToLong(Map.Entry::getValue)//وهون فعليا عشان ما يرجعلي اشي غير عدد التكرارات بس بدي اياه يرجع عدد التكرار
                .sum();
    }
}
