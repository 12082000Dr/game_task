package Game_config;

public class Validate {
    public String validate_animals(int bull, int cow) {
        String v_bull = null;
        String v_cow = null;

        if (cow == 1) {
            v_cow = cow + " ������";
        } else if (cow > 1) {
            v_cow = cow + " ������";
        }

        if (bull == 1) {
            v_bull = bull + " ���";
        } else {
            v_bull = bull + " ����";
        }

        if (bull == 0) {
            return v_cow;
        } else if (cow == 0) {
            return v_bull;
        } else {
            return v_bull + " " + v_cow;
        }
    }

    public String validate_result_ending(int count) {
        if (count == 1) {
            return " �������";
        } else if (count > 1 && count < 5) {
            return " �������";
        } else {
            return " �������";
        }
    }
}
