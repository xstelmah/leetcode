
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


class Task929 {

    @Test
    void example1() {
        String[] s = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        Assertions.assertEquals(2, numUniqueEmails(s));
    }

    @Test
    void example2() {
        String[] s = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        Assertions.assertEquals(1, numUniqueEmails(s));
    }

    public int numUniqueEmails(String[] emails) {
        var set = new HashSet<String>();
        for (var email : emails) {
           set.add(format(email));
        }
        return set.size();
    }

    private String format(String email) {
        var sb = new StringBuilder();
        var chars = email.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == '+' || chars[j] == '@') {
                break;
            }
            if (chars[j] == '.') {
                continue;
            }
            sb.append(chars[j]);
        }
        var domainIndex = email.indexOf('@');
        sb.append(email.substring(domainIndex));
        return sb.toString();
    }
}
