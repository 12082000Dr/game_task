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

    public String validate_result_ending(Integer count) {
        // TODO что будет если будет 21 попытка
        //Заменено на проверку последнего разряда
        int dischargeNumber = Integer.parseInt(String.valueOf(count.toString().charAt(count.toString().length() - 1)));
        if (dischargeNumber == 1) {
            return " попытку";
        } else if (dischargeNumber > 1 && dischargeNumber < 5) {
            return " попытки";
        } else {
            return " попыток";
        }
    }
}
