package com.example.assignmentssnexchange.service.impl;

import com.example.assignmentssnexchange.service.ISSNService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class SSNService implements ISSNService {
    private static Map<Integer, Character> map = new HashMap<>();

    static {
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');
        map.put(16, 'H');
        map.put(17, 'J');
        map.put(18, 'K');
        map.put(19, 'L');
        map.put(20, 'M');
        map.put(21, 'N');
        map.put(22, 'P');
        map.put(23, 'R');
        map.put(24, 'S');
        map.put(25, 'T');
        map.put(26, 'U');
        map.put(27, 'V');
        map.put(28, 'W');
        map.put(29, 'X');
        map.put(30, 'Y');
    }
    @Override
    public boolean isValidSSN(String ssn) {
        String regex = "^[\\d]{6}[-+A]{1}[\\d]{3}[\\d\\w]{1}";
        if (!Pattern.compile(regex)
                .matcher(ssn).matches()) {
            return false;
        }
        Integer day = Integer.parseInt(ssn.substring(0, 2));
        Integer month = Integer.parseInt(ssn.substring(2, 4));

        if(day > 31 || month > 12){
            return false;
        }

        Integer individualNumber = Integer.parseInt(ssn.substring(7, 10));

        if(individualNumber < 2 || individualNumber > 899){
            return false;
        }

        int indentityCode = Integer.parseInt(ssn.substring(0, 6) + ssn.substring(7, 10));
        int div = indentityCode % 31;
        char c = ssn.charAt(ssn.length() - 1);
        char d = div <= 9? (char)(div + '0') : map.get(div);

        if(d != c){
            return false;
        }
        return true;
    }



}
