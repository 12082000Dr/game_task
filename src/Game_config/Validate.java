package Game_config;

public class Validate {
    public String validate_animals(int bull, int cow) {
        String v_bull = null;
        String v_cow = null;

        if (cow == 1) {
            v_cow = cow + " корова";
        } else if (cow > 1) {
            v_cow = cow + " коровы";
        }

        if (bull == 1) {
            v_bull = bull + " бык";
        } else {
            v_bull = bull + " быка";
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
            return " попытка";
        } else if (count > 1 && count < 5) {
            return " попытки";
        } else {
            return " попыток";
        }
    }
}
