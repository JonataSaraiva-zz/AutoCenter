package br.com.own.autocar.utility.number;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

public class NumberUtil {

    public static int toInt(final double number) {
        return BigDecimal.valueOf(number)
                         .intValue();
    }

    public static int toInt(final BigDecimal number) {
        if (number == null) {
            return 0;
        } else {
            return number.intValue();
        }
    }

    public static long toLong(final BigDecimal number) {
        if (number == null) {
            return 0;
        } else {
            return number.longValue();
        }
    }

    public static long toLong(final Object o) {
        if (o instanceof BigDecimal) {
            return toLong((BigDecimal) o);
        } else if (o instanceof Number) {
            return new BigDecimal(String.valueOf(o)).longValue();
        } else {
            return NumberUtils.toLong(String.valueOf(o));
        }
    }


}
