package FibonacciSeries;

import Types.LoopType;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSeriesOperations {

    public static Map<Integer, FibonacciSeries> Operations =
            new HashMap<>() {{
                put(LoopType.WHILE, new FibonacciSeriesWithWhile());
                put(LoopType.DO_WHILE, new FibonacciSeriesWithDoWhile());
                put(LoopType.FOR, new FibonacciSeriesWithFor());
            }};
}
