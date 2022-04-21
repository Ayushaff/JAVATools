package com.oyos.setterGetterGenerator.util;

import java.lang.reflect.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

public class setterGetter {
    public static void main(String[] gg) {

        if (gg.length != 1 && gg.length != 2) {
            System.out.println(
                    "usage : java -classpath path_to_jar_files;. com.oyos.setterGetterGenerator.util.setterGetter [class_name] [constructor =tru/fols]");
            return;
        }
        if (gg.length == 2) {
            if (gg[1].equalsIgnoreCase("constructor=true") == false
                    && gg[1].equalsIgnoreCase("constructor=false") == false) {
                System.out.println(
                        "usage : java classpath path_to_jar_files;. com.oyos.setterGetterGenerator.util.setterGetter class_name constructor =tru/fols");
                return;
            }
        }
        String className = gg[0];
        try {
            Class c = Class.forName(className);
            Field fields[] = c.getDeclaredFields();
            Field field;
            String fieldName;
            Class fieldType;
            String setterName;
            String getterName;
            String tmp;
            String line;
            LinkedList<String> list;
            list = new LinkedList<>();
            // constructor
            System.out.println("arguemnts length " + gg.length);
            if ((gg.length == 2 && gg[1].equalsIgnoreCase("constructor=true"))) {
                line = "public " + c.getSimpleName() + "()";
                list.add(line);
                list.add("{");
                for (int i = 0; i < fields.length; i++) {
                    field = fields[i];
                    line = "this." + field.getName() + "=" + getDefaultValue(field.getType()) + ";";
                    list.add(line);
                }
                list.add("}");
                System.out.println("Defaultconstructor done for " + c.getName() + " class");
            }
            // settergetter
            for (int i = 0; i < fields.length; i++) {
                field = fields[i];
                fieldName = field.getName();
                fieldType = field.getType();
                if (fieldName.charAt(0) >= 97 && fieldName.charAt(0) <= 122) {
                    tmp = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                } else {
                    tmp = fieldName;
                }
                setterName = "set" + tmp;
                getterName = "get" + tmp;
                line = "public void " + setterName + "(" + fieldType.getName() + " " + fieldName + ")";
                list.add(line);
                list.add("{");
                line = "this." + fieldName + "=" + fieldName + ";";
                list.add(line);
                list.add("}");
                line = "public " + fieldType.getName() + " " + getterName + "()";
                list.add(line);
                list.add("{");
                line = "return this." + fieldName + ";";
                list.add(line);
                list.add("}");
            }

            File file = new File("tmp.tmp");
            if (file.exists())
                file.delete();
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            Iterator<String> iter = list.iterator();
            while (iter.hasNext()) {
                line = iter.next();
                raf.writeBytes(line + "\r\n");
            }
            raf.close();
            System.out.println("setter/getter done for " + c.getName() + " class");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("class not found " + cnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private static String getDefaultValue(Class c) {
        String className = c.getName();
        if (className.equals("java.lang.Long") || className.equals("long"))
            return "0";
        if (className.equals("java.lang.Integer") || className.equals("int"))
            return "0";
        if (className.equals("java.lang.Short") || className.equals("short"))
            return "0";
        if (className.equals("java.lang.Byte") || className.equals("byte"))
            return "0";
        if (className.equals("java.lang.Double") || className.equals("double"))
            return "0.0";
        if (className.equals("java.lang.Float") || className.equals("float"))
            return "0.0f";
        if (className.equals("java.lang.Character") || className.equals("char"))
            return "' '";
        if (className.equals("java.lang.Boolean") || className.equals("boolean"))
            return "false";
        if (className.equals("java.lang.String"))
            return "\"\"";

        return "null";
    }
}