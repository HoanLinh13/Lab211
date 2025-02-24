package Uitility;

public class CheckValidate {
    public String validateInput(String input, String type) {
        switch (type) {
            case "ID":
                // Kiểm tra ID chỉ chứa số và có độ dài tối đa 6 chữ số
                if (!input.matches("\\d{1,6}")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return String.format("%06d", Integer.parseInt(input)); // Định dạng 6 chữ số

            case "NAME":
                // Kiểm tra tên không chứa số hoặc ký tự đặc biệt
                if (!input.matches("^[A-Za-zÀ-ỹ ]{2,50}$")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input;

            case "PHONE":
                // Kiểm tra số điện thoại: 10 hoặc 11 số, bắt đầu bằng 0
                if (!input.matches("^0\\d{9,10}$")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input;

            case "ROOM":
                // Kiểm tra số phòng là số dương
                if (!input.matches("\\d{1,4}")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input;

            case "DATE":
                // Kiểm tra ngày tháng theo định dạng dd/MM/yyyy
                if (!input.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input;

            case "YN":
                // Kiểm tra câu trả lời Y hoặc N
                if (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input.toUpperCase();

            case "FLIGHT":
                // Kiểm tra số hiệu chuyến bay (có thể là chữ + số)
                if (!input.matches("^[A-Za-z0-9]{2,10}$")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input;

            case "SEAT":
                // Kiểm tra số ghế (chữ cái + số, VD: A12)
                if (!input.matches("^[A-Z]\\d{1,3}$")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input;

            case "TIME":
                // Kiểm tra thời gian đón khách (định dạng dd/MM/yyyy hh:mmAM/PM)
                if (!input.matches("^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}(AM|PM)$")) {
                    System.out.println("Data input is invalid");
                    return null;
                }
                return input;

            default:
                System.out.println("Invalid validation type.");
                return null;
        }
    }
}

