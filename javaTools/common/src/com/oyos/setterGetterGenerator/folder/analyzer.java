import java.io.File;
import java.lang.reflect.*;

class ClassAnalyzer {
    public static void main(String[] gg) {
        try {
            if (gg.length <= 0) {
                System.out.println("java ClassAnalyzer _CLASS_NAME_");
                return;
            }
            String classToAnalyze = gg[0];
            Class c;// class nam ki class ka objext bna
            c = Class.forName(classToAnalyze);// for name ko string pass karna he vo for name uss class ki definition ko
            // load krdega
            // then c ko us class nam ke class ka address assign krdijayga
            System.out.println("name (package) " + c.getName());
            System.out.println("SimpleName " + c.getSimpleName());

            Method methods[];
            // methods=c.getMethods();
            methods = c.getDeclaredMethods();// only declared
            System.out.println("no. of methods: " + methods.length);
            String methodsName = "";
            Method m;
            Class MethodsReturnType;
            Class parametres[];
            for (int i = 0; i < methods.length; i++) {
                m = methods[i];
                methodsName = m.getName();
                System.err.println(" "+(i+1)+" methods name : " + methodsName);
                MethodsReturnType = m.getReturnType();
                System.out.println("return type : " + MethodsReturnType);
                parametres = m.getParameterTypes();
                System.out.println("no. of parametre : " + parametres.length);
                for (int j = 0; j < parametres.length; j++) {
                    System.out.println("parametres no. " + (j + 1) + ", type : " + parametres[j].getName());
                }
                System.out.println("****************");

            }
            System.out.println("**************************");
            Field fields[];
            fields = c.getDeclaredFields();
            System.err.println("no, of fields : " + fields.length);
            Field f;
            String fieldName;
            Class fieldType;
            for (int k = 0; k < fields.length; k++) {
                f = fields[k];
                fieldName = f.getName();
                fieldType = f.getType();
                System.err.println("fields no. " + (k + 1) + ", fieldName " + fieldName + ", FieldType " + fieldType);
            }
        } catch (ClassNotFoundException cnf) {
            System.out.println("class " + cnf.getMessage() + " not found");
        }
    }
}