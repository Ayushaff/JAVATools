import java.io.*;

class membermanager {

    // default file name
    private static final String DATA_FILE = "member.data";

    public static void main(String[] gg) {
        if (gg.length <= 0) {
            System.out.println("specify the operation");
            operationsList();
        }

        String operation = gg[0];// operation specified
        if (!isOperationValid(operation)) {
            System.out.println("invalid operation " + operation);
            operationsList();
        }
        if (operation.equalsIgnoreCase("add")) {
            add(gg);
        } else if (operation.equalsIgnoreCase("update")) {

        } else if (operation.equalsIgnoreCase("remove")) {

        } else if (operation.equalsIgnoreCase("getByNumber")) {
            getByNumber(gg);
        } else if (operation.equalsIgnoreCase("getByNum")) {
            getByNumber(gg);
        } else if (operation.equalsIgnoreCase("getByCourse")) {
            getByCourse(gg);
        } else if (operation.equalsIgnoreCase("getByCors")) {
            getByCourse(gg);
        } else if (operation.equalsIgnoreCase("getByAll")) {
            getByAll(gg);
        } else if (operation.equalsIgnoreCase("getAll")) {
            getByAll(gg);
        } else {
            System.out.println("nothig");
        }
    }

    // operations
    private static void add(String[] data) {
        if (data.length < 5) {// because 0 is add operation 1 is contactNumber to add ... 4 is int Fee
            System.out.println("not enough data to add ,\nFormat :\nmob: _Name _courseTitle _fee ");
            return;
        }
        String mobNumber = data[1];
        String Name = data[2];
        String courseTitle = data[3];
        if (!isCourseValid(courseTitle)) {
            System.out.println("Invalid course : " + courseTitle);
            CourseList();
            return;
        }
        int fee = 0;
        try {
            fee = Integer.parseInt(data[4]);
        } catch (NumberFormatException nfe) {
            System.out.println("fee should be an int value" + nfe.getMessage());
        }

        try {
            File file = new File(DATA_FILE);
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            // number already exist karta h ya ni
            // for comaprison 4 fields hogi ek record me so ham mobileNumber se comapare
            // karenge vo he ya ni
            String fMobileNumber;
            while (raf.getFilePointer() < raf.length()) {
                fMobileNumber = raf.readLine();
                if (fMobileNumber.equalsIgnoreCase(mobNumber)) {
                    raf.close();
                    System.out.println(mobNumber + " already exists");
                    return;
                }
                raf.readLine();
                raf.readLine();
                raf.readLine();
                // sare elements and fields ko read krdia gaya from maybe buffer

            }
            raf.writeBytes(mobNumber);
            raf.writeBytes("\n");
            raf.writeBytes(Name);
            raf.writeBytes("\n");
            raf.writeBytes(courseTitle);
            raf.writeBytes("\n");
            raf.writeBytes(String.valueOf(fee));// int converted to string kyoki writebytes string ko write krta
            raf.writeBytes("\n");
            raf.close();
            // sare elements and fields ko write krdia gaya into a DATAFILE
            System.out.println("member added");

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return;
        }

    }

    private static void getByNumber(String[] data) {
        if (data.length != 2) {
            System.out.println("invalid no. of data passed");
            System.out.println("usage : java MemberManager getByNumber [contact_Number]");
        }
        String MobileNum = data[1];
        try {
            File file = new File(DATA_FILE);
            if (file.exists() == false) {
                System.out.println("no members of this contact " + MobileNum);
                return;
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            if (raf.length() == 0) {
                raf.close();
                System.out.println("noo member of contact " + MobileNum);
                return;
            }
            String fmobNum = "";
            String fName = "";
            String fCourse = "";
            int fFee = 0;
            boolean found = false;
            while (raf.getFilePointer() < raf.length()) {
                fmobNum = raf.readLine();
                if (fmobNum.equalsIgnoreCase(MobileNum) == true) {
                    fName = raf.readLine();
                    fCourse = raf.readLine();
                    fFee = Integer.parseInt(raf.readLine());
                    found = true;
                    break;
                }
                raf.readLine();
                raf.readLine();
                raf.readLine();
            }
            raf.close();
            if (found == false) {
                System.out.println("no member of contact " + MobileNum);
                return;
            }
            System.out.println("name " + fName);
            System.out.println("mob " + fmobNum);
            System.out.println("course " + fCourse);
            System.out.println("fee " + fFee);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private static void getByCourse(String[] data) {
        try {
            if (data.length != 2) {// one operation another one course num
                System.out.println("Please pass correct arguments");
                System.out.println("usage : java getByCourse [course...]");
            }
            String course = data[1];
            if (!isCourseValid(course)) {
                System.out.println("invalid course : " + course);
                CourseList();
                return;
            }

            File file = new File(DATA_FILE);
            if (file.exists() == false) {
                System.out.println("NO registrations against COUrSE and dataFileIssuue error: " + course);
                return;
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            if (raf.length() == 0) {
                raf.close();
                System.out.println("NO registrations against COURSE none courses available: " + course);
                return;
            }
            boolean found = false;
            String fmob = "";
            String fname = "";
            String fcourse = "";
            int Ffee = 0;
            int memberCount = 0;
            int totalFee = 0;
            
            while (raf.getFilePointer() < raf.length()) {
                fmob = raf.readLine();
                fname = raf.readLine();
                fcourse = raf.readLine();
                Ffee = Integer.parseInt(raf.readLine());
                if (fcourse.equalsIgnoreCase(course)) {
                    found = true;
                    System.out.println("name " + fname);
                    System.out.println("mob " + fmob);
                    System.out.println("course " + fcourse);
                    System.out.println("fee " + Ffee);
                    System.out.println("***********************");
                }
                if (found == false) {
                    System.out.println("not found ,no one bought " + course);
                }
            }
            raf.seek(0);
            while (raf.getFilePointer() < raf.length()) {
                fmob = raf.readLine();
                fname = raf.readLine();
                fcourse = raf.readLine();
                Ffee = Integer.parseInt(raf.readLine());
                memberCount++;
                totalFee += Ffee;
            }
            System.out.println("total registrations : " + memberCount);
            System.out.println("total fee collected : " + totalFee);

            // only this cors?
            /*
             * raf.seek(0);
             * int coursecount = 0;
             * while (raf.getFilePointer() < raf.length()) {
             * if (fcourse.equalsIgnoreCase(course)) {
             * fmob = raf.readLine();
             * fname = raf.readLine();
             * fcourse = raf.readLine();
             * Ffee = Integer.parseInt(raf.readLine());
             * coursecount++;
             * }
             * }
             * System.out.println("current course total registrations : "+coursecount);
             * raf.close();
             */
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private static void getByAll(String[] data) {
        try {
            File file = new File(DATA_FILE);
            if (file.exists() == false) {
                System.out.println("No members");
                return;
            }
            RandomAccessFile raff = new RandomAccessFile(file, "rw");
            if (raff.length() <= 0) {
                raff.close();
                System.out.println("No members");
                return;
            }
            String fname;
            String fmobNum;
            String fcourse;
            int ffee;
            int memberCount = 0;
            int totalFee = 0;
            while (raff.getFilePointer() < raff.length()) {
                fmobNum = raff.readLine();
                fname = raff.readLine();
                fcourse = raff.readLine();
                ffee = Integer.parseInt(raff.readLine());
                memberCount++;
                totalFee += ffee;
                System.out
                        .println("Member " + memberCount + ") " + fmobNum + ", " + fname + "," + fcourse + ", " + ffee);
            }
            raff.close();
            System.out.println("total registrations : " + memberCount);
            System.out.println("total fee collected: " + totalFee);

        } catch (IOException ioe) {
            System.err.println(" " + ioe.getMessage());
        }
    }

    // helper funtions

    private static boolean isOperationValid(String operation) {
        operation = operation.trim();
        String operations[] = { "add", "update", "remove", "getByNumber", "getByNum", "getByCourse", "getBycors",
                "getByAll", "getAll" };
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equalsIgnoreCase(operation))
                return true;
        }
        return false;
    }

    private static boolean isCourseValid(String course) {
        String courses[] = { "C++", "JAVA", "PYTHON", "reactJS", "SWIFT", "cryptoMining" };
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].equalsIgnoreCase(course))
                return true;
        }
        return false;
    }

    private static void CourseList() {
        System.out.println("Courses :\n[ C++ , JAVA , PYTHON , reactJS , SWIFT , CryptoMining ,]");
    }

    private static void operationsList() {
        System.out.println("operations : [ add , update , remove , getByNumber , getByCourse , getByAll]");
    }
}