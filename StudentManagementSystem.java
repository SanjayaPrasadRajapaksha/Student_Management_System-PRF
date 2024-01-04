import java.util.Scanner;

class StudentManagementSystem {

    public static String[] sID = new String[0];
    public static String[] sName = new String[0];
    public static int[] pF = new int[0];
    public static int[] dBMS = new int[0];
    public static int option = 0;

    public static void dashBoard() {
        clearConsole();

        Scanner input = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                      WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                     |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("[1] Add New Student                    [2] Add New Student With Marks");
        System.out.println("[3] Add Marks                          [4] Update Student Details");
        System.out.println("[5] Update Marks                       [6] Delete Student");
        System.out.println("[7] Prints Students Details            [8] Print Student Ranks");
        System.out.println("[9] Best In Programming Fundamentals   [10] Best In Database Management System");
        try {
            System.out.println();
            System.out.print("Enter An Option To Continue : ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addNewStudentWithMarks();
                    break;
                case 3:
                    addMarks();
                    break;
                case 4:
                    updateStudentDetails();
                    break;
                case 5:
                    updateMarks();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    printsStudentsDetails();
                    break;
                case 8:
                    printStudentRanks();
                    break;
                case 9:
                    bestInProgrammingFundamentals();
                    break;
                case 10:
                    bestInDatabaseManagementSystem();
                    break;
                default:
                    System.out.println("Wrong Number");
                    break;
            }
        } catch (Exception e) {
            dashBoard();
        }

    }

    public static boolean isDuplicateId(String id, String[] sID) {

        for (int a = 0; a < sID.length; a++) {
            if (id.equals(sID[a])) {
                return true;
            }

        }

        return false;

    }

    public static int searchIndex(String stuID, String[] sID) {
        int index = -1;
        for (int i = 0; i < sID.length; i++) {
            if (stuID.equals(sID[i])) {
                index = i;
            }
        }
        return index;
    }

    public static void findRank(double[] avgSubArray2) {

        for (int i = 0; i < avgSubArray2.length; i++) {
            for (int j = (i + 1); j < avgSubArray2.length; j++) {

                if (avgSubArray2[i] < avgSubArray2[j]) {
                    double temp = avgSubArray2[i];
                    avgSubArray2[i] = avgSubArray2[j];
                    avgSubArray2[j] = temp;

                }

            }
        }

    }

    public static int[] totalArray(int pF[], int dBMS[]) {

        int[] temp = new int[pF.length];

        for (int i = 0; i < pF.length; i++) {
            temp[i] = pF[i] + dBMS[i];
        }

        return temp;
    }

    public static double[] avgArray(int pF[], int dBMS[]) {

        double[] temp = new double[pF.length];

        for (int i = 0; i < pF.length; i++) {
            temp[i] = (pF[i] + dBMS[i]) / (double) 2;
        }

        return temp;
    }

    public static void sortArray(int[] totalSub, double[] avgSub, String[] sName, String[] sID, int pF[], int dBMS[]) {

        for (int i = 0; i < totalSub.length; i++) {
            for (int j = i + 1; j < totalSub.length; j++) {

                if (totalSub[i] < totalSub[j]) {
                    int temp = totalSub[i];
                    totalSub[i] = totalSub[j];
                    totalSub[j] = temp;

                    double temp1 = avgSub[i];
                    avgSub[i] = avgSub[j];
                    avgSub[j] = temp1;

                    String temp2 = sID[i];
                    sID[i] = sID[j];
                    sID[j] = temp2;

                    String temp3 = sName[i];
                    sName[i] = sName[j];
                    sName[j] = temp3;

                    int temp4 = pF[i];
                    pF[i] = pF[j];
                    pF[j] = temp4;

                    int temp5 = dBMS[i];
                    dBMS[i] = dBMS[j];
                    dBMS[j] = temp5;

                }

            }
        }
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();

        }
    }

    public static void bestPF(String[] sName, String[] sID, int pF[], int dBMS[]) {

        for (int i = 0; i < pF.length; i++) {
            for (int j = i + 1; j < pF.length; j++) {

                if (pF[i] < pF[j]) {

                    String temp2 = sID[i];
                    sID[i] = sID[j];
                    sID[j] = temp2;

                    String temp3 = sName[i];
                    sName[i] = sName[j];
                    sName[j] = temp3;

                    int temp4 = pF[i];
                    pF[i] = pF[j];
                    pF[j] = temp4;

                    int temp5 = dBMS[i];
                    dBMS[i] = dBMS[j];
                    dBMS[j] = temp5;

                }

            }
        }
    }

    public static void bestDBMS(String[] sName, String[] sID, int pF[], int dBMS[]) {

        for (int i = 0; i < pF.length; i++) {
            for (int j = i + 1; j < pF.length; j++) {

                if (dBMS[i] < dBMS[j]) {

                    String temp2 = sID[i];
                    sID[i] = sID[j];
                    sID[j] = temp2;

                    String temp3 = sName[i];
                    sName[i] = sName[j];
                    sName[j] = temp3;

                    int temp4 = pF[i];
                    pF[i] = pF[j];
                    pF[j] = temp4;

                    int temp5 = dBMS[i];
                    dBMS[i] = dBMS[j];
                    dBMS[j] = temp5;

                }

            }
        }
    }

    public static void addNewStudent() {

        clearConsole();
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                                   ADD NEW STUDENT                                |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID : ");
        String id = input.next();
        System.out.print("Enter Student Name : ");
        String name = input.next();

        while (true) {

            String temp1[] = new String[sID.length + 1];
            String temp2[] = new String[sName.length + 1];

            while (true) {
                if (isDuplicateId(id, sID)) {
                    System.out.println("The student ID is already exists");

                    System.out.print("Enter Student ID :");
                    id = input.next();

                    System.out.print("Enter Student Name :");
                    name = input.next();
                    continue;

                } else {
                    for (int a = 0; a < sID.length; a++) {
                        temp1[a] = sID[a];
                    }

                    temp1[temp1.length - 1] = id;
                    sID = temp1;
                    break;
                }
            }

            for (int a = 0; a < sName.length; a++) {
                temp2[a] = sName[a];
            }

            temp2[temp2.length - 1] = name;

            sName = temp2;

            System.out.println();
            System.out.print("Student has been added successfully..Do you want to add a new student (Y/N) : ");
            char yes = input.next().charAt(0);

            if (yes == 121 || yes == 89) {
                System.out.print("Enter Student ID :");
                id = input.next();

                System.out.print("Enter Student Name :");
                name = input.next();

                continue;
            }

            dashBoard();
            break;

        }

    }

    public static void addNewStudentWithMarks() {

        clearConsole();
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                            ADD NEW STUDENT WITH MARKS                            |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student ID : ");
        String id = input.next();
        System.out.print("Enter Student Name : ");
        String name = input.next();

        System.out.println();

        System.out.print("Programming Fundamentals Marks : ");
        int marksPF = input.nextInt();
        System.out.print("Database Management System Marks : ");
        int marksDBMS = input.nextInt();

        while (true) {

            String temp1[] = new String[sID.length + 1];
            String temp2[] = new String[sName.length + 1];

            int temp3[] = new int[sID.length + 1];
            int temp4[] = new int[sID.length + 1];

            while (true) {
                if (isDuplicateId(id, sID)) {
                    System.out.println("The student ID is already exists");

                    System.out.print("Enter Student ID :");
                    id = input.next();

                    System.out.print("Enter Student Name :");
                    name = input.next();
                    continue;

                } else {
                    for (int a = 0; a < sID.length; a++) {
                        temp1[a] = sID[a];
                    }

                    temp1[temp1.length - 1] = id;
                    sID = temp1;
                    break;
                }
            }

            for (int a = 0; a < sName.length; a++) {
                temp2[a] = sName[a];
            }

            temp2[temp2.length - 1] = name;

            sName = temp2;

            while (true) {
                if (marksPF <= 100 && marksPF >= 0) {
                    for (int a = 0; a < pF.length; a++) {
                        temp3[a] = pF[a];
                    }

                    temp3[temp3.length - 1] = marksPF;

                    pF = temp3;
                    break;

                } else {
                    System.out.println(2);
                    System.out.println("Invalid Marks,Please Enter Correct Marks");

                    System.out.print("Programming Fundamentals Marks : ");
                    marksPF = input.nextInt();

                    continue;
                }
            }

            while (true) {
                if (marksDBMS <= 100 && marksDBMS >= 0) {
                    for (int a = 0; a < dBMS.length; a++) {
                        temp4[a] = dBMS[a];
                    }

                    temp4[temp4.length - 1] = marksDBMS;

                    dBMS = temp4;
                    break;

                } else {
                    System.out.println();
                    System.out.println("Invalid Marks,Please Enter Correct Marks");

                    System.out.print("Database Management System Marks : ");
                    marksDBMS = input.nextInt();

                    continue;

                }

            }

            System.out.println();
            System.out.print(
                    "Student has been added with marks successfully.Do you want to add a new student with marks (Y/N) : ");
            char yes = input.next().charAt(0);
            System.out.println();
            if (yes == 121 || yes == 89) {
                System.out.print("Enter Student ID :");
                id = input.next();

                System.out.print("Enter Student Name :");
                name = input.next();

                System.out.println();

                System.out.print("Programming Fundamentals Marks : ");
                marksPF = input.nextInt();
                System.out.print("Database Management System Marks : ");
                marksDBMS = input.nextInt();

                continue;

            }
            dashBoard();
            break;

        }

    }

    public static void addMarks() {

        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                                    ADD MARKS                                     |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student ID : ");
        String stuID = input.next();
        int index = searchIndex(stuID, sID);

        int marksPF;
        int marksDBMS;

        while (true) {

            while (index == -1) {

                System.out.print("Invalid Student ID.Do you want to search again (Y/N) : ");
                char yes = input.next().charAt(0);

                if (yes == 121 || yes == 89) {
                    System.out.print("Enter Student ID : ");
                    stuID = input.next();
                    index = searchIndex(stuID, sID);
                    continue;
                }
                dashBoard();
                break;
            }

            if (index != -1) {

                System.out.println();
                System.out.println("Enter Student ID : " + sID[index]);
                System.out.println("Enter Student Name : " + sName[index]);

                if (pF.length == 0 && dBMS.length == 0) {
                    while (true) {

                        while (index == -1) {

                            System.out.print("Invalid Student ID.Do you want to search again (Y/N) : ");
                            char yes = input.next().charAt(0);

                            if (yes == 121 || yes == 89) {
                                System.out.print("Enter Student ID : ");
                                stuID = input.next();
                                index = searchIndex(stuID, sID);
                                continue;
                            }
                            dashBoard();
                            break;
                        }
                        int[] temp1 = new int[sID.length + 1];
                        int[] temp2 = new int[sID.length + 1];
                        System.out.println();
                        System.out.print("Programming Fundamentals Marks : ");
                        marksPF = input.nextInt();

                        System.out.print("Database Management System Marks : ");
                        marksDBMS = input.nextInt();

                        while (true) {
                            if (marksPF > 100 || marksPF < 0) {
                                System.out.println();
                                System.out.println("Invalid Marks,Please Enter Correct Marks");

                                System.out.print("Programming Fundamentals Marks : ");
                                marksPF = input.nextInt();

                                continue;
                            }
                            break;
                        }

                        while (true) {
                            if (marksDBMS > 100 || marksDBMS < 0) {
                                System.out.println();
                                System.out.println("Invalid Marks,Please Enter Correct Marks");

                                System.out.print("Programming Fundamentals Marks : ");
                                marksDBMS = input.nextInt();

                                continue;
                            }
                            break;
                        }
                        for (int a = 0; a < pF.length; a++) {
                            temp1[a] = pF[a];
                            temp2[a] = dBMS[a];
                        }
                        temp1[index] = marksPF;
                        temp2[index] = marksPF;
                        pF = temp1;
                        dBMS = temp2;

                        System.out.println();
                        System.out.print("Marks have been added.Do you want Add marks for another student (Y/N) : ");
                        char yes = input.next().charAt(0);

                        if (yes == 121 || yes == 89) {
                            System.out.print("Enter Student ID : ");
                            stuID = input.next();
                            index = searchIndex(stuID, sID);
                            continue;
                        }
                        dashBoard();
                    }
                } else if (pF[index] > 0 && dBMS[index] > 0) {
                    System.out.println();
                    System.out.println("This Student's marks have been already added.");
                    System.out.println("If you want to update marks, please use [4] update marks option. ");
                    System.out.println();
                    System.out.print("Do you want Add marks for another student  (Y/N) : ");

                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {
                        System.out.print("Enter Student ID : ");
                        stuID = input.next();
                        index = searchIndex(stuID, sID);
                        continue;
                    }
                    dashBoard();
                    break;
                } else if (pF[index] == 0 && dBMS[index] == 0) {
                    System.out.println();
                    System.out.print("Programming Fundamentals Marks : ");
                    marksPF = input.nextInt();

                    System.out.print("Database Management System Marks : ");
                    marksDBMS = input.nextInt();

                    while (true) {
                        if (marksPF > 100 || marksPF < 0) {
                            System.out.println();
                            System.out.println("Invalid Marks,Please Enter Correct Marks");

                            System.out.print("Programming Fundamentals Marks : ");
                            marksPF = input.nextInt();

                            continue;
                        }
                        break;
                    }

                    while (true) {
                        if (marksDBMS > 100 || marksDBMS < 0) {
                            System.out.println();
                            System.out.println("Invalid Marks,Please Enter Correct Marks");

                            System.out.print("Programming Fundamentals Marks : ");
                            marksDBMS = input.nextInt();

                            continue;

                        }
                        break;
                    }
                    pF[index] = marksPF;
                    dBMS[index] = marksDBMS;

                    System.out.println();
                    System.out.print("Marks have been added.Do you want Add marks for another student (Y/N) : ");
                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {
                        System.out.print("4Enter Student ID : ");
                        stuID = input.next();
                        index = searchIndex(stuID, sID);
                        continue;

                    }

                    dashBoard();

                }

            }
        }
    }

    public static void updateStudentDetails() {

        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                            UPDATE STUDENTS DETAILS                               |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student ID : ");
        String stID = input.next();

        int index = searchIndex(stID, sID);

        while (true) {

            if (index != -1) {

                System.out.println("Student name : " + sName[index]);
                System.out.println();
                System.out.print("Enter the new student name: ");
                sName[index] = input.next();

                System.out.println("Student details has been added successfully.");
                System.out.println();
                System.out.print("Do you want to update another student details ? (Y/N) : ");
                char yes = input.next().charAt(0);

                if (yes == 121 || yes == 89) {

                    System.out.print("Enter Student ID : ");
                    stID = input.next();
                    index = searchIndex(stID, sID);

                    continue;
                }
                break;
            } else {
                System.out.println();
                System.out.print("Invalid Student ID.Do you want to search again (Y/N) : ");
                char yes = input.next().charAt(0);

                if (yes == 121 || yes == 89) {
                    System.out.print("Enter Student ID : ");
                    stID = input.next();
                    index = searchIndex(stID, sID);
                    continue;
                }

            }

            break;
        }

        dashBoard();

    }

    public static void updateMarks() {

        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                                   UPDATE MARKS                                   |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student ID : ");
        String studID = input.next();

        int index = searchIndex(studID, sID);

        while (true) {

            if (index != -1) {
                if (pF.length == 0) {

                    System.out.println("This student's marks yet to be added");

                    System.out.print("Do you want to update marks for another student ? (Y/N) : ");
                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {

                        System.out.print("Enter Student ID : ");
                        studID = input.next();
                        index = searchIndex(studID, sID);

                        continue;
                    }
                    break;

                } else if (pF[index] > 0) {
                    System.out.println("Student name : " + sName[index]);
                    System.out.println();

                    System.out.println("Programming Fundamentals Marks : " + pF[index]);
                    System.out.println("Database Management System Marks : " + dBMS[index]);
                    System.out.println();

                    System.out.print("Enter New Programming Fundamentals Marks : ");
                    int newMarksPF = input.nextInt();
                    while (true) {

                        if (newMarksPF <= 100 && newMarksPF >= 0) {

                            pF[index] = newMarksPF;

                            break;

                        } else {
                            System.out.println(2);
                            System.out.println("Invalid Marks,Please Enter Correct Marks");

                            System.out.print("Enter New Programming Fundamentals Marks :");
                            newMarksPF = input.nextInt();

                            continue;
                        }

                    }
                    System.out.println();
                    System.out.print("Enter New Database Management System Marks : ");
                    int newMarksDBMS = input.nextInt();
                    while (true) {

                        if (newMarksDBMS <= 100 && newMarksDBMS >= 0) {

                            dBMS[index] = newMarksDBMS;

                            break;

                        } else {
                            System.out.println();
                            System.out.println("Invalid Marks,Please Enter Correct Marks");

                            System.out.print("Enter New Database Management System Marks : ");
                            newMarksDBMS = input.nextInt();

                            continue;
                        }

                    }

                    System.out.println("Marks have been added successfully.");
                    System.out.println();
                    System.out.print("Do you want to update marks for another student ? (Y/N) : ");
                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {

                        System.out.print("Enter Student ID : ");
                        studID = input.next();
                        index = searchIndex(studID, sID);

                        continue;
                    }
                    break;
                } else if (pF[index] == 0) {

                    System.out.println("This student's marks yet to be added");

                    System.out.print("Do you want to update marks for another student ? (Y/N) : ");
                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {
                        System.out.println();
                        System.out.print("Enter Student ID : ");
                        studID = input.next();
                        index = searchIndex(studID, sID);

                        continue;
                    }
                    break;

                }

            } else {

                System.out.print("Invalid Student ID.Do you want to search again (Y/N) : ");
                char yes = input.next().charAt(0);

                if (yes == 121 || yes == 89) {
                    System.out.print("Enter Student ID : ");
                    studID = input.next();
                    index = searchIndex(studID, sID);
                    continue;
                }
                break;

            }
            dashBoard();
            break;

        }

        dashBoard();

    }

    public static void deleteStudent() {

        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out
                .println("|                                   DELETE STUDENT                                   |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student ID : ");
        String studeID = input.next();

        int index = searchIndex(studeID, sID);

        while (true) {
            if (index != -1) {

                String[] newSID = new String[sID.length - 1];
                String[] newSName = new String[sID.length - 1];
                int[] newPF = new int[sID.length - 1];
                int[] newDBMS = new int[sID.length - 1];

                for (int i = 0, k = 0; i < sID.length; i++) {

                    if (i == index) {
                        continue;
                    }

                    newSID[k++] = sID[i];
                }

                sID = newSID;

                for (int i = 0, k = 0; i < sName.length; i++) {

                    if (i == index) {
                        continue;
                    }

                    newSName[k++] = sName[i];
                }

                sName = newSName;

                for (int i = 0, k = 0; i < pF.length; i++) {

                    if (i == index) {
                        continue;
                    }

                    newPF[k++] = pF[i];
                }

                pF = newPF;

                for (int i = 0, k = 0; i < dBMS.length; i++) {

                    if (i == index) {
                        continue;
                    }

                    newDBMS[k++] = dBMS[i];
                }

                dBMS = newDBMS;

                System.out.print("Do you want to delete another sstudent (Y/N) : ");
                char yes = input.next().charAt(0);

                if (yes == 121 || yes == 89) {
                    System.out.print("Enter Student ID : ");
                    studeID = input.next();
                    index = searchIndex(studeID, sID);
                    continue;
                }
                break;
            } else {
                System.out.print("Invalid Student ID.Do you want to search again (Y/N) : ");
                char yes = input.next().charAt(0);

                if (yes == 121 || yes == 89) {
                    System.out.print("Enter Student ID : ");
                    studeID = input.next();
                    index = searchIndex(studeID, sID);
                    continue;
                }
                break;
            }

        }

        dashBoard();

    }

    public static void printsStudentsDetails() {

        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                            PRINTS STUDENT DETAILS                                |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("Enter Student ID : ");
        String studID = input.next();

        int index = searchIndex(studID, sID);

        while (true) {

            if (index != -1) {
                if (pF.length == 0) {

                    System.out.println("Marks yet to be added");

                    System.out.print("Do you want to search another student details ? (Y/N) : ");
                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {

                        System.out.print("Enter Student ID : ");
                        studID = input.next();
                        index = searchIndex(studID, sID);

                        continue;
                    }
                    break;

                } else if (pF[index] > 0) {
                    int rankIndex = 0;
                    System.out.println();
                    System.out.println("+----------------------------------+------------+");
                    System.out.println("|Student Name :                    |     " + sName[index] + "\t|");
                    System.out.println("|Programming Fundamentals Marks    |     " + pF[index] + "\t|");
                    System.out.println("|Database MAnagement System Marks  |     " + dBMS[index] + "\t|");

                    int total = pF[index] + dBMS[index];

                    double avg = total / (double) 2;

                    double[] avgSubArray1 = new double[pF.length];
                    double[] avgSubArray2 = new double[pF.length];

                    for (int a = 0; a < pF.length; a++) {
                        avgSubArray1[a] = (pF[a] + dBMS[a]) / 2;
                    }

                    for (int a = 0; a < avgSubArray2.length; a++) {
                        avgSubArray2[a] = avgSubArray1[a];
                    }

                    findRank(avgSubArray2);

                    for (int i = 0; i < pF.length; i++) {
                        if (avgSubArray2[i] == avgSubArray1[index]) {
                            rankIndex = (i + 1);

                        }

                    }

                    System.out.println("|Total Marks                       |     " + total + "\t|");
                    System.out.println("|Avg. Marks                        |     " + avg + "\t|");
                    System.out.println("|Rank :                            |     " + rankIndex + "\t|");
                    System.out.println("+----------------------------------+------------+");

                    System.out.print("Do you want to back to main menu ? (Y/N) : ");
                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {

                        dashBoard();
                        break;
                    }

                    System.out.println();
                    System.out.print("Enter Student ID : ");
                    studID = input.next();
                    index = searchIndex(studID, sID);
                    continue;

                } else if (pF[index] == 0) {

                    System.out.println("Marks yet to be added");

                    System.out.print("Do you want to search another student details ? (Y/N) : ");
                    char yes = input.next().charAt(0);

                    if (yes == 121 || yes == 89) {
                        System.out.println();
                        System.out.print("Enter Student ID : ");
                        studID = input.next();
                        index = searchIndex(studID, sID);

                        continue;
                    }
                    break;

                }

            } else {

                System.out.print("Invalid Student ID.Do you want to search again (Y/N) : ");
                char yes = input.next().charAt(0);

                if (yes == 121 || yes == 89) {
                    System.out.print("Enter Student ID : ");
                    studID = input.next();
                    index = searchIndex(studID, sID);
                    continue;
                }
                break;

            }
            dashBoard();
            break;

        }

        dashBoard();

    }

    public static void printStudentRanks() {

        clearConsole();

        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                              PRINTS STUDENT RANKS                                |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        int totalSub[] = totalArray(pF, dBMS);

        double avgSub[] = avgArray(pF, dBMS);

        sortArray(totalSub, avgSub, sName, sID, pF, dBMS);

        System.out.println("+-------+-------+---------------+---------------+---------------+");
        System.out.println("|Rank\t|ID\t|Name\t\t|Total Marks\t|Avg.Marks\t|");
        System.out.println("+-------+-------+---------------+---------------+---------------+");

        for (int i = 0; i < totalSub.length; i++) {
            if (totalSub[i] > 0) {

                System.out
                        .println("|" + (i + 1) + "\t|" + sID[i] + "\t|" + sName[i] + "\t\t|" + totalSub[i] + "\t\t|"
                                + avgSub[i] + "\t\t|");

            }

        }
        System.out.println("+-------+-------+---------------+---------------+---------------+");

        System.out.print("Do you want to back to main menu ? (Y/N) : ");
        char yes = input.next().charAt(0);

        if (yes == 121 || yes == 89) {

            dashBoard();

        }

    }

    public static void bestInProgrammingFundamentals() {

        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                         BEST IN PROGRAMMING FUNDAMENTALS                         |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        bestPF(sName, sID, pF, dBMS);
        System.out.println("+-------+---------------+---------------+---------------+");
        System.out.println("|ID\t|Name\t\t|PF Marks\t|DBMS Marks\t|");
        System.out.println("+-------+---------------+---------------+---------------+");

        for (int i = 0; i < pF.length; i++) {
            if (pF[i] > 0) {

                System.out.println("|" + sID[i] + "\t|" + sName[i] + "\t\t|" + pF[i] + "\t\t|" + dBMS[i] + "\t\t|");

            }

        }

        System.out.println("+-------+---------------+---------------+---------------+");

        System.out.print("Do you want to back to main menu ? (Y/N) : ");
        char yes = input.next().charAt(0);

        if (yes == 121 || yes == 89) {

            dashBoard();

        }

    }

    public static void bestInDatabaseManagementSystem() {

        clearConsole();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("|                         BEST IN DATABASE MANAGEMENT SYSTEM                       |");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println();

        bestDBMS(sName, sID, pF, dBMS);
        System.out.println("+-------+---------------+---------------+---------------+");
        System.out.println("|ID\t|Name\t\t|DBMS Marks\t|PF Marks\t|");
        System.out.println("+-------+---------------+---------------+---------------+");

        for (int i = 0; i < pF.length; i++) {
            if (dBMS[i] > 0) {

                System.out.println("|" + sID[i] + "\t|" + sName[i] + "\t\t|" + dBMS[i] + "\t\t|" + pF[i] + "\t\t|");

            }

        }

        System.out.println("+-------+---------------+---------------+---------------+");

        System.out.print("Do you want to back to main menu ? (Y/N) : ");
        char yes = input.next().charAt(0);

        if (yes == 121 || yes == 89) {

            dashBoard();

        }

    }

    public static void main(String[] args) {

        dashBoard();
    }

}