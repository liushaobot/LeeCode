/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        helper(list, num, 0, 0, 0);
        return list;
    }

    public void helper(List<String> list, int num, int cnt, int watch, int bit) {
        if (cnt == num) {
            int minute = 0, hour = 0, pos = 0;
            while (pos < 6) {
                if ((watch & (1<<pos)) != 0) {
                    minute += (1<<pos);
                }
                ++pos;
            }
            while (pos < 10) {
                if ((watch & (1<<pos)) != 0) {
                    hour += (1<<(pos-6));
                }
                ++pos;
            }
            if (minute >= 60 || hour >= 12) return;
            if (minute >= 10) {
                list.add(hour + ":" + minute);
            } else {
                list.add(hour + ":0" + minute);
            }
        } else {
            for (int i = bit; i < 10; ++i) {
                watch |= (1<<i);
                helper(list, num, cnt+1, watch, i+1);
                watch -= (1<<i);
            }
        }
    }
}
