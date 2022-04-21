import java.lang.reflect.Field;
import java.util.Arrays;

 class GetterSetterGenerator {

    public static void main(String[] args) {
        try {
            GetterSetterGenerator gt = new GetterSetterGenerator();
            StringBuffer sb = new StringBuffer();

            Class<?> c = Class.forName("org.prgm.TestClass");
            // Getting fields of the class
            Field[] fields = c.getDeclaredFields();
            System.out.println("Fields - " + Arrays.toString(fields));
            for (Field f : fields) {
                String fieldName = f.getName();
                String fieldType = f.getType().getSimpleName();

                System.out.println("Field Name -- " + fieldName);
                System.out.println("Field Type " + fieldType);

                gt.createSetter(fieldName, fieldType, sb);
                //gt.createGetter(fieldName, fieldType, sb);
            }
            System.out.println("" + sb.toString());

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void createSetter(String fieldName, String fieldType, StringBuffer setter) {
        setter.append("public void").append(" set");
        setter.append(getFieldName(fieldName));
        setter.append("(" + fieldType + " " + fieldName + ") {");
        setter.append("\n\t this." + fieldName + " = " + fieldName + ";");
        setter.append("\n" + "}" + "\n");
    }

    /*
     * private void createGetter(String fieldName, String fieldType, StringBuffer
     * getter){
     * // for boolean field method starts with "is" otherwise with "get"
     * getter.append("public " + fieldType).append((fieldType.equals("boolean")?"
     * is" : " get") + getFieldName(fieldName) + "(){");
     * getter.append("\n\treturn " + fieldName + ";");
     * getter.append("\n" + "}" + "\n");
     * }
     */

    private String getFieldName(String fieldName) {
        return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
    }
}
