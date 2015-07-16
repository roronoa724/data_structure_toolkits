package com.lanfea.util.generator;

import java.util.Random;

/**
 * Created by lanfea on 2015/7/16.
 */
public class RandomGenerator {
    private static Random r = new Random(47);

    public static class
    Integer implements Generator<java.lang.Integer> {
        private int mod = 10000;
        public Integer() {}
        public Integer(int modulo) {mod = modulo;}
        public java.lang.Integer next() {
            return r.nextInt(mod);
        }
    }
}
