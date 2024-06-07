package com.car.util.validation;

/**
 * 身份证验证.
 */
public final class IDCardUtil {
    private IDCardUtil() {
    }

    /**
     * 15位身份证号码转18位身份证号码.
     *
     * @param century    19xx年用19，20xx年用20
     * @param idcardno15 待转换15位身份证号码
     * @return 18位身份证号码
     */
    public static String from15to18(int century, String idcardno15) {
        if ((century + "").length() != 2) {
            throw new RuntimeException("世纪数为2位整数");
        }

        if (!Validator.isIDCard(idcardno15)) {
            throw new RuntimeException("身份证号码输入有误");
        }

        //系数
        int[] weight = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1}; //SUPPRESS
        //通过加入世纪码，变成17位的新号码
        String newNoBody = idcardno15.substring(0, 6) + century + idcardno15.substring(6); //SUPPRESS
        //校检码
        int checkSum = 0;

        for (int i = 0; i < 17; i++) { //SUPPRESS
            int ai = Integer.parseInt(newNoBody.charAt(i) + "");
            checkSum = checkSum + ai * weight[i];
        }

        int checkNum = checkSum % 11; //SUPPRESS
        char[] veruftCode = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

        return newNoBody + veruftCode[checkNum];
    }

    /**
     * 18位身份证号码转15位身份证号码.
     *
     * @param idcardno18 待转换的18位身份证号码
     * @return 15位的身份证号码
     */
    public static String from18to15(String idcardno18) {
        if (!Validator.isIDCard(idcardno18)) {
            throw new RuntimeException("身份证号码输入有误");
        }
        return idcardno18.substring(0, 6) + idcardno18.substring(8, 17); //SUPPRESS
    }
}
