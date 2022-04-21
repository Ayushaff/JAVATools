import java.util.concurrent.CountDownLatch;

class addit {
    public static void main(String[] args) {
        int sum = 0;
        if (args.length < 2) {
            System.out.println("'" + args[0] + "'"
                    + " lmox is not recognized as an internal or external command \n,operable program or batch file\n inputs .");
            System.out.println("usage :\n1) java addIt num1 num2 ...so on\n2) Min. inputs 2");
            return;
        }
        try {
            for (int i = 0; i < args.length; i++) {
                sum += Double.parseDouble(args[i]);
            }
            System.out.println("sum : " + sum);
        } catch (NumberFormatException nfe) {
            System.out.println("invalid " + nfe.getMessage());
            return;
        }

        System.out.println("no of command line arguments passed : " + args.length);
        System.out.println("list of command line arguments are : ");
        for (int i = 0; i < args.length; i++) {// arguments counts from 1 in java like first arguments at 1 index
            System.out.println("(" + (i) + ") " + args[i]);
        }
    }
}