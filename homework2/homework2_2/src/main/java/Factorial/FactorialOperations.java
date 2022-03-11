package Factorial;

import Types.LoopType;

import java.util.HashMap;
import java.util.Map;

public class FactorialOperations {

    public static Map<Integer, Factorial> Operations =
            new HashMap<>() {{
                put(LoopType.WHILE, new FactorialWithWhile());
                put(LoopType.DO_WHILE, new FactorialWithDoWhile());
                put(LoopType.FOR, new FactorialWithFor());
            }};
}
