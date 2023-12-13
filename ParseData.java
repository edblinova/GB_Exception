import java.util.HashMap;

public class ParseData {

    public HashMap<String, Object> parsInputData() {
        InputData inputData = new InputData();
        String[] data = inputData.enterData();
        HashMap<String, Object> dataDic = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String i : data) {
            if (i.length() == 1) {
                if (i.equals("f") || i.equals("m")) {
                    dataDic.put("sex", i);
                } else{
                    try {
                        throw new SexException();
                    } catch (SexException e) {
                        e.sexException(i);
                    }
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                String[] arrayDate = i.split("\\.");
                // System.out.println(arrayDate[0]);
                // System.out.println(arrayDate[1]);
                // System.out.println(arrayDate[2]);
                System.out.println(Integer.parseInt(arrayDate[0]));
                if (Integer.parseInt(arrayDate[0]) < 0 ||
                        Integer.parseInt(arrayDate[0]) > 31 || Integer.parseInt(arrayDate[1]) < 0 ||
                        Integer.parseInt(arrayDate[1]) > 12 || Integer.parseInt(arrayDate[2]) < 0 ||
                        Integer.parseInt(arrayDate[2]) > 2023) {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateException(i);
                    }
                } else {
                    if (Integer.parseInt(arrayDate[2]) == 2) {
                        if (Integer.parseInt(arrayDate[2]) % 4 == 0) {
                            if (Integer.parseInt(arrayDate[0]) > 29) {
                                try {
                                    throw new DataException();
                                } catch (DataException e) {
                                    e.dataException(i);
                                }
                            }
                        } else {
                            if (Integer.parseInt(arrayDate[0]) > 28) {
                                try {
                                    throw new DataException();
                                } catch (DataException e) {
                                    e.dataException(i);
                                }
                            }
                        }
                    }
                    else if (Integer.parseInt(arrayDate[1]) == 1 
                        || Integer.parseInt(arrayDate[1]) == 3 
                        || Integer.parseInt(arrayDate[1]) == 5 
                        || Integer.parseInt(arrayDate[1]) == 7 
                        || Integer.parseInt(arrayDate[1]) == 8 
                        || Integer.parseInt(arrayDate[1]) == 10 
                        || Integer.parseInt(arrayDate[1]) == 12 ) {
                        if (Integer.parseInt(arrayDate[0]) > 31) {
                            try {
                                throw new DataException();
                            } catch (DataException e) {
                                e.dataException(i);
                            }
                        }
                    } else {
                        if (Integer.parseInt(arrayDate[0]) > 30) {
                            try {
                                throw new DataException();
                            } catch (DataException e) {
                                e.dataException(i);
                            }
                        }
                    }
                    dataDic.put("date", i);
                }

            } else if (i.matches("[0-9]+")) {
                dataDic.put("tel", i);
            } else if (i.matches("[A-Za-z]+")) {
                sb.append(i + " ");
            } else {
                try {
                    throw new DataException();
                } catch (DataException e) {
                    e.dataException(i);
                }
            }
        }
        String[] fullName = String.valueOf(sb).split(" ");
        if (fullName.length == 3) {
            dataDic.put("firstName", fullName[1]);
            dataDic.put("lastName", fullName[0]);
            dataDic.put("patronymic", fullName[2]);
        }
        return dataDic;
    }    
}
