package classloader;

import java.io.*;
import java.lang.reflect.Field;

public class CustomClassLoader extends ClassLoader {
    private String path;

    public CustomClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz;
        // 注释1
        byte[] data = loadClassData(name);
        if (data == null) {
            throw new ClassNotFoundException();
        } else {
            // 注释2
            clazz = defineClass(name, data, 0, data.length);
        }

        return clazz;
    }

    private byte[] loadClassData(String name) {
        String fileName = getFileName(name);
        File file = new File(this.path, fileName);
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int lenght = 0;
            while ((lenght = in.read(buffer)) != -1) {
                out.write(buffer, 0, lenght);
            }
            return out.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    private String getFileName(String name) {
        int index = name.lastIndexOf('.');
        if (index == -1) {
            // 如果没有找到'.'则直接在末尾添加.class
            return name + ".class";
        } else {
            return name.substring(index + 1) + ".class";
        }
    }
}
